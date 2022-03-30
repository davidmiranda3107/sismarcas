package portal.sessions;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import portal.entities.AdmUsuario;

/**
 * Session Bean implementation class ValidacionSBSL
 */
@Stateless
@LocalBean
public class ValidacionSBSL implements ValidacionSBSLLocal {

	@EJB(mappedName = "ejb/BusinessSBSL")
	BusinessSBSLLocal businessLocal;
	
	private static final String CLAVE_ESTANDAR = "abc";

	public static final Integer VAL_ERROR_NO_DETERMINADO = -1;
	public static final Integer VAL_USUARIO_NO_EXISTE = 0;
	public static final Integer VAL_USUARIO_VALIDO = 1;
	public static final Integer VAL_USUARIO_DEBE_CAMBIAR_CLAVE = 2;
	public static final Integer VAL_ERROR_EN_CLAVE = 3;
	public static final Integer VAL_USUARIO_EXPIRADO = 4;
	public static final Integer VAL_USUARIO_DE_BAJA = 5;
	public static final Integer VAL_USUARIO_NO_TIENE_ACCESO_A_SISTEMA = 6;
	
    public ValidacionSBSL() {
        
    }

	@Override
	public Integer validar(String usuario, String clave) {
		Integer resp = VAL_USUARIO_NO_EXISTE;
		String claveMD5 = "";
		try {
			AdmUsuario admUsuario = (AdmUsuario) businessLocal.findByPropertyUnique(AdmUsuario.class, "usuLogin", usuario);
			admUsuario = (AdmUsuario) businessLocal.refresh(AdmUsuario.class, admUsuario.getUsuId());
			if (admUsuario != null) {
				if (admUsuario.getRegActivo().equals(BigDecimal.ONE)) {
					claveMD5 = getMD5String(usuario+clave);
					if (admUsuario.getUsuClave().equals(claveMD5)) {
						// USUARIO VALIDO
						resp = VAL_USUARIO_VALIDO;
					} else {
						// CLAVE EQUIVOCADA
						resp = VAL_ERROR_EN_CLAVE;
					}
				} else {
					// USUARIO INACTIVO O DE BAJA
					resp = VAL_USUARIO_DE_BAJA;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}
	
	public static String getMD5String(String texto) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(texto.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			return number.toString(16).toUpperCase();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
    
    
    
}
