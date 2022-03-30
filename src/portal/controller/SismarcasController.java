package portal.controller;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.eclipse.persistence.exceptions.DatabaseException;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

import portal.security.ObjSession;
import portal.sessions.BusinessSBSLLocal;
import portal.util.AppConstant;

public abstract class SismarcasController {

	@EJB(mappedName = "ejb/BusinessSBSL")
	protected BusinessSBSLLocal localSBSL;
	
	@ManagedProperty("#{msg}")
	private ResourceBundle bundleApps;
	
	private String status; 
	private boolean loggedIn;
	protected ObjSession objSession;
	protected String outcome;

	private Serializable registro;
	private List<? extends Serializable> listado;
	
	public SismarcasController() {
		setStatus(AppConstant.STATUS_VIEW);
	}
	
	public SismarcasController(Serializable registro) {
		setRegistro(registro);
		setStatus(AppConstant.STATUS_VIEW);
	}
	
	protected void addMessage(FacesMessage message) {  
		//RequestContext context = RequestContext.getCurrentInstance(); 
		FacesContext.getCurrentInstance().addMessage(null, message);
    }

	protected void addInfo(String message) {
		FacesMessage fm = new FacesMessage();
		fm.setSeverity(FacesMessage.SEVERITY_INFO);
		fm.setSummary("INFORMACION:");
		fm.setDetail(message);
		addMessage(fm);  
    } 
	
	protected void addError(String message) {
		FacesMessage fm = new FacesMessage();
		fm.setSeverity(FacesMessage.SEVERITY_ERROR);
		fm.setSummary("ERROR:");
		fm.setDetail(message);
		addMessage(fm);  
    } 

	protected void addWarn(String message) {
		FacesMessage fm = new FacesMessage();
		fm.setSeverity(FacesMessage.SEVERITY_WARN);
		fm.setSummary("ADVERTENCIA:");
		fm.setDetail(message);
		addMessage(fm);  
    } 

	protected void addFatal(String message) {
		FacesMessage fm = new FacesMessage();
		fm.setSeverity(FacesMessage.SEVERITY_FATAL);
		fm.setSummary("FATAL:");
		fm.setDetail(message);
		addMessage(fm);  
    } 
	
	protected void viewErrorMessage(Throwable e){
		addError("Se ha generado un error, consulte con el Administrador.");
		e.printStackTrace();
		onCancel();
	}
	
	public void onNew() {
		if (getRegistro()!=null){
			nuevaInstancia();
		}
		if (beforeNew()) {
			status = AppConstant.STATUS_NEW;
			afterNew();
		}
	}
	
	public abstract void nuevaInstancia();
	
	public void onEdit() {
		if (beforeEdit()) {
			afterEdit();
			status = AppConstant.STATUS_EDIT;
		}
	}

	public void onCancel() {
		RequestContext rctx = RequestContext.getCurrentInstance();
		if (beforeCancel()) {
			if (status.equals(AppConstant.STATUS_EDIT)) {
				onCancelEdit();
			} else if (status.equals(AppConstant.STATUS_NEW)) {
				onCancelNew();
			} else {
				cancel();
			}
			afterCancel();
		}
		rctx.addCallbackParam("success", true);
	}

	public void onCancelNew() {
		if (beforeCancelNew()) {
			cancel();
			afterCancelNew();
		}
	}

	public void onCancelEdit() {
		if (beforeCancelEdit()) {
			cancel();
			afterCancelEdit();
		}
	}

	private void cancel(){
		if (getRegistro() != null){
			nuevaInstancia();
		}
		status = AppConstant.STATUS_SEARCH;
	}
	
	public void onSave() {
		try {
			if (beforeSave()) {
				if (status.equals(AppConstant.STATUS_EDIT)) {
					onSaveEdit();
				} else if (status.equals(AppConstant.STATUS_NEW)) {
					onSaveNew();
				}
				if (getRegistro()==null){
					nuevaInstancia();
				}
			}
		} catch (Exception e) {
			viewErrorMessage(e);
			e.printStackTrace();
		}
	}

	public void onSaveNew() {
		RequestContext rctx = RequestContext.getCurrentInstance();
		try {
			if (beforeSaveNew()) {
				getLocalSBSL().insert(getRegistro());
				status = AppConstant.STATUS_EDIT;
				addInfo(getStringMessage("msg.info.guarda"));
				rctx.addCallbackParam("success", true);
				afterSaveNew();
			} else {
				rctx.addCallbackParam("success", false);
			}
		} catch (DatabaseException e) {
			viewErrorMessage(e);
			rctx.addCallbackParam("success", false);
			e.printStackTrace();
		} catch (Exception e) {
			viewErrorMessage(e);
			rctx.addCallbackParam("success", false);
			e.printStackTrace();
		}
		
	}

	public void onSaveEdit() {
		RequestContext rctx = RequestContext.getCurrentInstance();
		try {
			if (beforeSaveEdit()) {
				getLocalSBSL().update(getRegistro());
				addInfo(getStringMessage("msg.info.guarda"));
				rctx.addCallbackParam("success", true);
				afterSaveEdit();
			} else {
				rctx.addCallbackParam("success", false);
			}
		} catch (Exception e) {
			viewErrorMessage(e);
			rctx.addCallbackParam("success", false);
			e.printStackTrace();
		}
	}

	public void onSaveEditRow(RowEditEvent event) {
		setRegistro((Serializable) event.getObject());
		onEdit();
		onSaveEdit();
	}

	public void onDelete() {
		RequestContext rctx = RequestContext.getCurrentInstance();
		try {
			if (beforeDelete()) {
				getLocalSBSL().delete(getRegistro());
				addInfo(getStringMessage("msg.info.elimina"));
				rctx.addCallbackParam("success", true);
				status = AppConstant.STATUS_SEARCH;
				afterDelete();
				if (getRegistro() != null){
					nuevaInstancia();
					
				}
			} else {
				rctx.addCallbackParam("success", false);
			}
		} catch (Exception e) {
			viewErrorMessage(e);
			rctx.addCallbackParam("success", false);
		}
	}

	public void onDeleteRow() {
		if (getRegistro() != null) {
			onDelete();
		} else {
			addError(getStringMessage("msg.error.noseleccion"));
		}
	}

	public void onRowSelect() {
		if (beforeRowSelect()) {
			
			afterRowSelect();
		}
	}

	public void onRowUnSelect() {
		if (beforeRowUnSelect()) {
			nuevaInstancia();
			afterRowUnSelect();
		}
	}

	public void onShowSelected() {
		onRowSelect();
	}

	public void onEditSelected() {
		onRowSelect();
		onEdit();
	}

	public void onDeleteSelected() {
		onRowSelect();
		onDelete();
	}

    public void selectFromDialog(SelectEvent event) {
    	if (beforeSelectFromDialog(event)){
    		RequestContext.getCurrentInstance().closeDialog(event.getObject());
    	}
    }

    public void onView(){
    	if (beforeView()){
    		setStatus(AppConstant.STATUS_VIEW);
    		afterView();
    	}
    }
    
	//********************************************************************************************
    protected boolean beforeView(){
    	return true;
    }
    
    protected void afterView(){
    	
    }
    
	protected boolean beforeSelectFromDialog(SelectEvent event){
		return true;
	}
	
	protected boolean beforeNew(){
		return true;
	}

	protected void afterNew(){
	}

	protected boolean beforeEdit(){
		return true;
	}

	protected void afterEdit(){
	}

	protected boolean beforeCancel(){
		return true;
	}

	protected void afterCancel(){
	}

	protected boolean beforeCancelNew(){
		return true;
	}

	protected void afterCancelNew(){
	}

	protected boolean beforeCancelEdit(){
		return true;
	}

	protected void afterCancelEdit(){
	}

	protected boolean beforeSave(){
		return true;
	}

	protected void afterSave(){
	}
	
	protected boolean beforeSaveNew(){
		return true;
	}

	protected void afterSaveNew(){
	}

	protected boolean beforeSaveEdit(){
		return true;
	}

	protected void afterSaveEdit(){
	}
	
	protected boolean beforeDelete(){
		return true;
	}

	protected void afterDelete(){
	}

	protected boolean beforeRowSelect(){
		return true;
	}
	
	protected void afterRowSelect(){
	}
	
	protected boolean beforeRowUnSelect(){
		return true;
	}
	
	protected void afterRowUnSelect(){
	}

	public String getStringMessage(String key) {
		return getBundleApps().getString(key);
	}
	
	public String getStringMessage(String key, String bundleName) {
		FacesContext context = FacesContext.getCurrentInstance();
		ResourceBundle bundle = context.getApplication().getResourceBundle(
				context, bundleName);
		return bundle.getString(key);
	}

	public ResourceBundle getBundleApps() {
		return bundleApps;
	}

	public void setBundleApps(ResourceBundle bundleApps) {
		this.bundleApps = bundleApps;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public Serializable getRegistro() {
		return registro;
	}

	public void setRegistro(Serializable registro) {
		this.registro = registro;
	}

	public List<? extends Serializable> getListado() {
		return listado;
	}

	public void setListado(List<? extends Serializable> listado) {
		this.listado = listado;
	}

	public BusinessSBSLLocal getLocalSBSL() {
		return localSBSL;
	}

	public void setLocalSBSL(BusinessSBSLLocal localSBSL) {
		this.localSBSL = localSBSL;
	}

	public ObjSession getObjSession() {
		return objSession;
	}

	public void setObjSession(ObjSession objSession) {
		this.objSession = objSession;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}
	
}
