package portal.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the "ADM_MENU_ROLES" database table.
 * 
 */
@Entity
@Table(schema="sismar", name="\"ADM_MENU_ROLES\"")
@NamedQuery(name="AdmMenuRole.findAll", query="SELECT a FROM AdmMenuRole a")
public class AdmMenuRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name="ADM_MENU_ROLES_SQ", schema="sismar", table="CONTADOR", pkColumnName="CNT_NOMBRE",valueColumnName="CNT_VALOR", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="ADM_MENU_ROLES_SQ")
	@Column(name="\"MNR_ID\"")
	private long mnrId;

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

	//bi-directional many-to-one association to AdmMenu
	@ManyToOne
	@JoinColumn(name="MNR_MNU_ID")
    private AdmMenu admMenu;

	//bi-directional many-to-one association to AdmRole
	@ManyToOne
	@JoinColumn(name="MNR_ROL_ID")
	private AdmRole admRole;

	public AdmMenuRole() {
	}

	public long getMnrId() {
		return this.mnrId;
	}

	public void setMnrId(long mnrId) {
		this.mnrId = mnrId;
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

	public AdmMenu getAdmMenu() {
		return this.admMenu;
	}

	public void setAdmMenu(AdmMenu admMenu) {
		this.admMenu = admMenu;
	}

	public AdmRole getAdmRole() {
		return this.admRole;
	}

	public void setAdmRole(AdmRole admRole) {
		this.admRole = admRole;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (mnrId ^ (mnrId >>> 32));
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
		AdmMenuRole other = (AdmMenuRole) obj;
		if (mnrId != other.mnrId)
			return false;
		return true;
	}

}