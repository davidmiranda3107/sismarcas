package portal.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the "ADM_USUARIOS_PERMISOS" database table.
 * 
 */
@Entity
@Table(name="\"ADM_USUARIOS_PERMISOS\"", schema="sismar")
@NamedQuery(name="AdmUsuariosPermiso.findAll", query="SELECT a FROM AdmUsuariosPermiso a")
public class AdmUsuariosPermiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name="ADM_USUARIOS_PERMISOS_SQ", schema="sismar", table="CONTADOR", pkColumnName="CNT_NOMBRE",valueColumnName="CNT_VALOR", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="ADM_USUARIOS_PERMISOS_SQ")
	@Column(name="\"UPR_ID\"")
	private long uprId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"FEC_CREA\"")
	private Date fecCrea;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"FEC_MODI\"")
	private Date fecModi;

	@Column(name="\"REG_ACTIVO\"")
	private BigDecimal regActivo;

	@Column(name="\"USU_CREA\"")
	private String usuCrea;

	@Column(name="\"USU_MODI\"")
	private String usuModi;

	//bi-directional many-to-one association to AdmPermiso
	@ManyToOne
	@JoinColumn(name="\"UPR_PER_ID\"")
	private AdmPermiso admPermiso;

	//bi-directional many-to-one association to AdmRole
	@ManyToOne
	@JoinColumn(name="\"UPR_ROL_ID\"")
	private AdmRole admRole;

	//bi-directional many-to-one association to AdmUsuario
	@ManyToOne
	@JoinColumn(name="\"UPR_USU_ID\"")
	private AdmUsuario admUsuario;

	public AdmUsuariosPermiso() {
	}

	public long getUprId() {
		return this.uprId;
	}

	public void setUprId(long uprId) {
		this.uprId = uprId;
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

	public AdmPermiso getAdmPermiso() {
		return this.admPermiso;
	}

	public void setAdmPermiso(AdmPermiso admPermiso) {
		this.admPermiso = admPermiso;
	}

	public AdmRole getAdmRole() {
		return this.admRole;
	}

	public void setAdmRole(AdmRole admRole) {
		this.admRole = admRole;
	}

	public AdmUsuario getAdmUsuario() {
		return this.admUsuario;
	}

	public void setAdmUsuario(AdmUsuario admUsuario) {
		this.admUsuario = admUsuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (uprId ^ (uprId >>> 32));
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
		AdmUsuariosPermiso other = (AdmUsuariosPermiso) obj;
		if (uprId != other.uprId)
			return false;
		return true;
	}

}