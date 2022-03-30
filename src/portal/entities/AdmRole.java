package portal.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "ADM_ROLES" database table.
 * 
 */
@Entity
@Table(name="\"ADM_ROLES\"",schema="sismar") 
@NamedQuery(name="AdmRole.findAll", query="SELECT a FROM AdmRole a")
public class AdmRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name="ADM_ROLES_SQ", schema="sismar", table="CONTADOR", pkColumnName="CNT_NOMBRE",valueColumnName="CNR_VALOR", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="ADM_ROLES_SQ")
	@Column(name="\"ROL_ID\"")
	private long rolId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"FEC_CREA\"")
	private Date fecCrea;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"FEC_MODI\"")
	private Date fecModi;

	@Column(name="\"REG_ACTIVO\"")
	private BigDecimal regActivo;

	@Column(name="\"ROL_DESCRIPCION\"")
	private String rolDescripcion;

	@Column(name="\"ROL_NOMBRE\"")
	private String rolNombre;

	@Column(name="\"USU_CREA\"")
	private String usuCrea;

	@Column(name="\"USU_MODI\"")
	private String usuModi;

	//bi-directional many-to-one association to AdmMenuRole
	@OneToMany(mappedBy="admRole")
	private List<AdmMenuRole> admMenuRoles;

	//bi-directional many-to-one association to AdmRolesPermiso
	@OneToMany(mappedBy="admRole")
	private List<AdmRolesPermiso> admRolesPermisos;

	//bi-directional many-to-one association to AdmUsuariosPermiso
	@OneToMany(mappedBy="admRole")
	private List<AdmUsuariosPermiso> admUsuariosPermisos;

	public AdmRole() {
	}

	public long getRolId() {
		return this.rolId;
	}

	public void setRolId(long rolId) {
		this.rolId = rolId;
	}

	public Date getFecCrea() {
		return this.fecCrea;
	}

	public void setFecCrea(Date fecCrea) {
		this.fecCrea = fecCrea;
	}

	public Date getFecModi() {
		return this.fecModi;
	}

	public void setFecModi(Date fecModi) {
		this.fecModi = fecModi;
	}

	public BigDecimal getRegActivo() {
		return this.regActivo;
	}

	public void setRegActivo(BigDecimal regActivo) {
		this.regActivo = regActivo;
	}

	public String getRolDescripcion() {
		return this.rolDescripcion;
	}

	public void setRolDescripcion(String rolDescripcion) {
		this.rolDescripcion = rolDescripcion;
	}

	public String getRolNombre() {
		return this.rolNombre;
	}

	public void setRolNombre(String rolNombre) {
		this.rolNombre = rolNombre;
	}

	public String getUsuCrea() {
		return this.usuCrea;
	}

	public void setUsuCrea(String usuCrea) {
		this.usuCrea = usuCrea;
	}

	public String getUsuModi() {
		return this.usuModi;
	}

	public void setUsuModi(String usuModi) {
		this.usuModi = usuModi;
	}

	public List<AdmMenuRole> getAdmMenuRoles() {
		return this.admMenuRoles;
	}

	public void setAdmMenuRoles(List<AdmMenuRole> admMenuRoles) {
		this.admMenuRoles = admMenuRoles;
	}

	public AdmMenuRole addAdmMenuRole(AdmMenuRole admMenuRole) {
		getAdmMenuRoles().add(admMenuRole);
		admMenuRole.setAdmRole(this);

		return admMenuRole;
	}

	public AdmMenuRole removeAdmMenuRole(AdmMenuRole admMenuRole) {
		getAdmMenuRoles().remove(admMenuRole);
		admMenuRole.setAdmRole(null);

		return admMenuRole;
	}

	public List<AdmRolesPermiso> getAdmRolesPermisos() {
		return this.admRolesPermisos;
	}

	public void setAdmRolesPermisos(List<AdmRolesPermiso> admRolesPermisos) {
		this.admRolesPermisos = admRolesPermisos;
	}

	public AdmRolesPermiso addAdmRolesPermiso(AdmRolesPermiso admRolesPermiso) {
		getAdmRolesPermisos().add(admRolesPermiso);
		admRolesPermiso.setAdmRole(this);

		return admRolesPermiso;
	}

	public AdmRolesPermiso removeAdmRolesPermiso(AdmRolesPermiso admRolesPermiso) {
		getAdmRolesPermisos().remove(admRolesPermiso);
		admRolesPermiso.setAdmRole(null);

		return admRolesPermiso;
	}

	public List<AdmUsuariosPermiso> getAdmUsuariosPermisos() {
		return this.admUsuariosPermisos;
	}

	public void setAdmUsuariosPermisos(List<AdmUsuariosPermiso> admUsuariosPermisos) {
		this.admUsuariosPermisos = admUsuariosPermisos;
	}

	public AdmUsuariosPermiso addAdmUsuariosPermiso(AdmUsuariosPermiso admUsuariosPermiso) {
		getAdmUsuariosPermisos().add(admUsuariosPermiso);
		admUsuariosPermiso.setAdmRole(this);

		return admUsuariosPermiso;
	}

	public AdmUsuariosPermiso removeAdmUsuariosPermiso(AdmUsuariosPermiso admUsuariosPermiso) {
		getAdmUsuariosPermisos().remove(admUsuariosPermiso);
		admUsuariosPermiso.setAdmRole(null);

		return admUsuariosPermiso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (rolId ^ (rolId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdmRole other = (AdmRole) obj;
		if (rolId != other.rolId)
			return false;
		return true;
	}

}