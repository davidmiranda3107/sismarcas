package portal.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import portal.controller.SismarcasController;
import portal.entities.AdmUsuario;

@ManagedBean
@ViewScoped
public class UsuarioMB extends SismarcasController {

	AdmUsuario usuario;
	List<AdmUsuario> listadoUsuarios;
	
	public UsuarioMB() {
		
	}
	
	@Override
	public void nuevaInstancia() {

	}

	public AdmUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(AdmUsuario usuario) {
		this.usuario = usuario;
	}

	public List<AdmUsuario> getListadoUsuarios() {
		return listadoUsuarios;
	}

	public void setListadoUsuarios(List<AdmUsuario> listadoUsuarios) {
		this.listadoUsuarios = listadoUsuarios;
	}

}
