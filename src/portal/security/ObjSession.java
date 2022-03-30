package portal.security;

import java.math.BigDecimal;
import java.util.List;

import portal.entities.AdmUsuario;
import portal.entities.AdmUsuariosPermiso;

public class ObjSession {

	private AdmUsuario usuario;
	private List<AdmUsuariosPermiso> permisos;

	public boolean isPermisoValido(String rol) {
		boolean valido = false;
		if (permisos != null) {
			for (AdmUsuariosPermiso reg : this.permisos) {
				String comparar = rol.trim().toUpperCase();
				String registro = reg.getAdmRole().getRolNombre();
				if ((registro.equals(comparar))
						&& (reg.getRegActivo().equals(BigDecimal.ONE))) {
					return true;
				}
			}
		}
		return valido;
	}

	public boolean isPermisoValido(String rol, String permiso) {
		boolean valido = false;
		if (permisos != null) {
			for (AdmUsuariosPermiso reg : this.permisos) {
				String comparar = rol.trim().toUpperCase() + ":"
						+ permiso.trim().toUpperCase();
				String registro = reg.getAdmRole().getRolNombre() + ":"
						+ reg.getAdmPermiso().getPerNombre();
				if ((registro.equals(comparar))
						&& (reg.getRegActivo().equals(BigDecimal.ONE))) {
					return true;
				}
			}
		}
		return valido;
	}

	public AdmUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(AdmUsuario usuario) {
		this.usuario = usuario;
	}

	public List<AdmUsuariosPermiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<AdmUsuariosPermiso> permisos) {
		this.permisos = permisos;
	}
}
