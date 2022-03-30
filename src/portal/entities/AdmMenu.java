package portal.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "ADM_MENU" database table.
 * 
 */
@Entity
@Table(schema="sismar", name="\"ADM_MENU\"")
@NamedQuery(name="AdmMenu.findAll", query="SELECT a FROM AdmMenu a")
public class AdmMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name="ADM_MENU_SQ", schema="sismar", table="CONTADOR", pkColumnName="CNT_NOMBRE",valueColumnName="CNT_VALOR", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="ADM_MENU_SQ")
	@Column(name="\"MNU_ID\"")
	private long mnuId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"FEC_CREA\"")
	private Date fecCrea;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"FEC_MODI\"")
	private Date fecModi;

	@Column(name="\"MNU_ID_PADRE\"")
	private BigDecimal mnuIdPadre;

	@Column(name="\"MNU_NOMBRE\"")
	private String mnuNombre;

	@Column(name="\"MNU_ORDEN\"")
	private BigDecimal mnuOrden;

	@Column(name="\"MNU_TIPO\"")
	private String mnuTipo;

	@Column(name="\"MNU_URL\"")
	private String mnuUrl;

	@Column(name="\"REG_ACTIVO\"")
	private BigDecimal regActivo;

	@Column(name="\"USU_CREA\"")
	private String usuCrea;

	@Column(name="\"USU_MODI\"")
	private String usuModi;

	//bi-directional many-to-one association to AdmMenuRole
	@OneToMany(mappedBy="admMenu")
	private List<AdmMenuRole> admMenuRoles;

	public AdmMenu() {
	}

	public long getMnuId() {
		return this.mnuId;
	}

	public void setMnuId(long mnuId) {
		this.mnuId = mnuId;
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

	public BigDecimal getMnuIdPadre() {
		return this.mnuIdPadre;
	}

	public void setMnuIdPadre(BigDecimal mnuIdPadre) {
		this.mnuIdPadre = mnuIdPadre;
	}

	public String getMnuNombre() {
		return this.mnuNombre;
	}

	public void setMnuNombre(String mnuNombre) {
		this.mnuNombre = mnuNombre;
	}

	public BigDecimal getMnuOrden() {
		return this.mnuOrden;
	}

	public void setMnuOrden(BigDecimal mnuOrden) {
		this.mnuOrden = mnuOrden;
	}

	public String getMnuTipo() {
		return this.mnuTipo;
	}

	public void setMnuTipo(String mnuTipo) {
		this.mnuTipo = mnuTipo;
	}

	public String getMnuUrl() {
		return this.mnuUrl;
	}

	public void setMnuUrl(String mnuUrl) {
		this.mnuUrl = mnuUrl;
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

	public List<AdmMenuRole> getAdmMenuRoles() {
		return this.admMenuRoles;
	}

	public void setAdmMenuRoles(List<AdmMenuRole> admMenuRoles) {
		this.admMenuRoles = admMenuRoles;
	}

	public AdmMenuRole addAdmMenuRole(AdmMenuRole admMenuRole) {
		getAdmMenuRoles().add(admMenuRole);
		admMenuRole.setAdmMenu(this);

		return admMenuRole;
	}

	public AdmMenuRole removeAdmMenuRole(AdmMenuRole admMenuRole) {
		getAdmMenuRoles().remove(admMenuRole);
		admMenuRole.setAdmMenu(null);

		return admMenuRole;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (mnuId ^ (mnuId >>> 32));
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
		AdmMenu other = (AdmMenu) obj;
		if (mnuId != other.mnuId)
			return false;
		return true;
	}

}