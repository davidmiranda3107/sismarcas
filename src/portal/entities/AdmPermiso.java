package portal.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "ADM_PERMISOS" database table.
 * 
 */
@Entity
@Table(name="\"ADM_PERMISOS\"", schema="sismar")
@NamedQuery(name="AdmPermiso.findAll", query="SELECT a FROM AdmPermiso a")
public class AdmPermiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name="ADM_PERMISOS_SQ", schema="sismar", table="CONTADOR", pkColumnName="CNT_NOMBRE",valueColumnName="CNT_VALOR", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="ADM_PERMISOS_SQ")
	@Column(name="\"PER_ID\"")
	private long perId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"FEC_CREA\"")
	private Date fecCrea;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"FEC_MODI\"")
	private Date fecModi;

	@Column(name="\"PER_DESCRIPCION\"")
	private String perDescripcion;

	@Column(name="\"PER_NOMBRE\"")
	private String perNombre;

	@Column(name="\"REC_ACTIVO\"")
	private BigDecimal recActivo;

	@Column(name="\"USU_CREA\"")
	private String usuCrea;

	@Column(name="\"USU_MODI\"")
	private String usuModi;

	//bi-directional many-to-one association to AdmRolesPermiso
	@OneToMany(mappedBy="admPermiso")
	private List<AdmRolesPermiso> admRolesPermisos;

	//bi-directional many-to-one association to AdmUsuariosPermiso
	@OneToMany(mappedBy="admPermiso")
	private List<AdmUsuariosPermiso> admUsuariosPermisos;

	public AdmPermiso() {
	}

	public long getPerId() {
		return this.perId;
	}

	public void setPerId(long perId) {
		this.perId = perId;
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

	public String getPerDescripcion() {
		return this.perDescripcion;
	}

	public void setPerDescripcion(String perDescripcion) {
		this.perDescripcion = perDescripcion;
	}

	public String getPerNombre() {
		return this.perNombre;
	}

	public void setPerNombre(String perNombre) {
		this.perNombre = perNombre;
	}

	public BigDecimal getRecActivo() {
		return this.recActivo;
	}

	public void setRecActivo(BigDecimal recActivo) {
		this.recActivo = recActivo;
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

	public List<AdmRolesPermiso> getAdmRolesPermisos() {
		return this.admRolesPermisos;
	}

	public void setAdmRolesPermisos(List<AdmRolesPermiso> admRolesPermisos) {
		this.admRolesPermisos = admRolesPermisos;
	}

	public AdmRolesPermiso addAdmRolesPermiso(AdmRolesPermiso admRolesPermiso) {
		getAdmRolesPermisos().add(admRolesPermiso);
		admRolesPermiso.setAdmPermiso(this);

		return admRolesPermiso;
	}

	public AdmRolesPermiso removeAdmRolesPermiso(AdmRolesPermiso admRolesPermiso) {
		getAdmRolesPermisos().remove(admRolesPermiso);
		admRolesPermiso.setAdmPermiso(null);

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
		admUsuariosPermiso.setAdmPermiso(this);

		return admUsuariosPermiso;
	}

	public AdmUsuariosPermiso removeAdmUsuariosPermiso(AdmUsuariosPermiso admUsuariosPermiso) {
		getAdmUsuariosPermisos().remove(admUsuariosPermiso);
		admUsuariosPermiso.setAdmPermiso(null);

		return admUsuariosPermiso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (perId ^ (perId >>> 32));
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
		AdmPermiso other = (AdmPermiso) obj;
		if (perId != other.perId)
			return false;
		return true;
	}

}