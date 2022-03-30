package portal.security;

import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.primefaces.component.menubar.Menubar;

import portal.controller.SismarcasController;
import portal.entities.AdmMenu;
import portal.entities.AdmUsuario;
import portal.entities.AdmUsuariosPermiso;
import portal.interfaces.IAdmMenu;
import portal.sessions.ValidacionSBSLLocal;
import portal.util.AppConstant;
import portal.util.SystemConfig;

public class SecurityController extends SismarcasController {

	@EJB(mappedName = "ejb/ValidacionSBSL")
	protected ValidacionSBSLLocal validacionLocal;

	private Menubar menu;
	private String usuario;
	private String clave;
	private String claveNueva;
	private String claveConfirmada;
	private long sisId;
	private boolean loggedIn = false;
	private String changePassOutcome;
	private Date fechaSistema;
	private boolean validarSistema = true;
	private String nit;
	private String dui;
	private boolean runLogout = true;

	private boolean produccion = false;

	public static final int LOGIN_CNR = 1;
	public static final int LOGIN_EXTERNO = 2;
	private int tipoUsuario = 0;

	private Integer msgCodigo = 0;// guarda la respuesta del login

	public SecurityController() {
		TimeZone tzSv = TimeZone.getTimeZone("America/El_Salvador");
		fechaSistema = Calendar.getInstance(tzSv, new Locale("es", "SV"))
				.getTime();

	}

	@PostConstruct
	public void init() {

	}

	@SuppressWarnings("unchecked")
	public String onLogin() {
		loggedIn = false;
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			if (beforeLogin()) {
				if (usuario == null || clave == null) {
					addWarn("Usuario y Clave son requeridos. Consulte con el administrador.");
					return null;
				} else {
					msgCodigo = 0;
					msgCodigo = validacionLocal.validar(usuario, clave);
				}
				// el usuario es valido
				if (msgCodigo.equals(ValidacionSBSLLocal.VAL_USUARIO_VALIDO)) {
					ObjSession objSession = new ObjSession();
					AdmUsuario user = (AdmUsuario) localSBSL
							.findByPropertyUnique(AdmUsuario.class, "usuLogin",
									usuario);
					if (user == null) {
						addWarn("Usuario erroneo o sin permiso del sistema.");
						return null;
					}
					objSession.setUsuario(user);
					objSession.setPermisos((List<AdmUsuariosPermiso>) localSBSL
							.findByProperty(AdmUsuariosPermiso.class,
									"admUsuario", user));
					menu = (new SystemConfig())
							.crearMenu((List<IAdmMenu>) localSBSL.menuByUser(
									AdmMenu.class, user.getUsuId()));
					context.getExternalContext().getSessionMap()
							.put(AppConstant.AUTH_KEY, usuario);
					context.getExternalContext().getSessionMap()
							.put(AppConstant.AUTH_SESSION, objSession);
					setObjSession(objSession);
					loggedIn = true;
				} else if (msgCodigo.equals(validacionLocal.VAL_ERROR_EN_CLAVE)) {
					addWarn("Clave equivocada");
					return null;
				}
			}
			return outcome;
		} catch (Exception e) {
			e.printStackTrace();
			addWarn("Se presento un error al iniciar Sesi\u00F3n en el Sistema, registro de sesi\u00F3n no pudo ser creado. Consulte con el administrador.");
			return null;
		}
	}

	@Override
	public void nuevaInstancia() {

	}

	protected void afterLogin() {
	}

	protected boolean beforeLogin() {
		return true;
	}

	public String onLogout() {
		if (beforeLogout()) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getSessionMap()
					.remove(AppConstant.AUTH_KEY);
			context.getExternalContext().getSessionMap()
					.remove(AppConstant.AUTH_SESSION);
			HttpServletResponse response = (HttpServletResponse) context
					.getExternalContext().getResponse();
			HttpSession session = (HttpSession) context.getExternalContext()
					.getSession(false);
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-control", "must-revalidate");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);

			// Eliminando los MB's de la aplicacion
			Enumeration<String> attribs = session.getAttributeNames();
			while (attribs.hasMoreElements()) {
				String mb = attribs.nextElement();
				if (mb.endsWith("MB")) {
					session.removeAttribute(mb);
				}
			}
			session.invalidate();

			this.usuario = null;
			this.clave = null;
			this.loggedIn = false;

			menu = null;
			tipoUsuario = 0;
			afterLogout();
			return outcome;
		}
		return null;
	}

	protected void afterLogout() {
	}

	protected boolean beforeLogout() {
		return true;
	}

	public ValidacionSBSLLocal getValidacionLocal() {
		return validacionLocal;
	}

	public void setValidacionLocal(ValidacionSBSLLocal validacionLocal) {
		this.validacionLocal = validacionLocal;
	}

	public Menubar getMenu() {
		return menu;
	}

	public void setMenu(Menubar menu) {
		this.menu = menu;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getClaveNueva() {
		return claveNueva;
	}

	public void setClaveNueva(String claveNueva) {
		this.claveNueva = claveNueva;
	}

	public String getClaveConfirmada() {
		return claveConfirmada;
	}

	public void setClaveConfirmada(String claveConfirmada) {
		this.claveConfirmada = claveConfirmada;
	}

	public long getSisId() {
		return sisId;
	}

	public void setSisId(long sisId) {
		this.sisId = sisId;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String getChangePassOutcome() {
		return changePassOutcome;
	}

	public void setChangePassOutcome(String changePassOutcome) {
		this.changePassOutcome = changePassOutcome;
	}

	public Date getFechaSistema() {
		return fechaSistema;
	}

	public void setFechaSistema(Date fechaSistema) {
		this.fechaSistema = fechaSistema;
	}

	public boolean isValidarSistema() {
		return validarSistema;
	}

	public void setValidarSistema(boolean validarSistema) {
		this.validarSistema = validarSistema;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getDui() {
		return dui;
	}

	public void setDui(String dui) {
		this.dui = dui;
	}

	public boolean isRunLogout() {
		return runLogout;
	}

	public void setRunLogout(boolean runLogout) {
		this.runLogout = runLogout;
	}

	public boolean isProduccion() {
		return produccion;
	}

	public void setProduccion(boolean produccion) {
		this.produccion = produccion;
	}

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Integer getMsgCodigo() {
		return msgCodigo;
	}

	public void setMsgCodigo(Integer msgCodigo) {
		this.msgCodigo = msgCodigo;
	}
}
