package portal.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "MRC_MARCAS_TRACKING" database table.
 * 
 */
@Entity
@Table(name="\"MRC_MARCAS_TRACKING\"", schema="sismar")
@NamedQuery(name="MrcMarcasTracking.findAll", query="SELECT m FROM MrcMarcasTracking m")
public class MrcMarcasTracking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name="MRC_MARCAS_TRACKING_SQ", schema="sismar", table="CONTADOR", pkColumnName="CNT_NOMBRE",valueColumnName="CNT_VALOR", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="MRC_MARCAS_TRACKING_SQ")
	@Column(name="\"TRA_ID\"")
	private long traId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"FEC_CREA\"")
	private Date fecCrea;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"FEC_MODI\"")
	private Date fecModi;

	@Column(name="\"REG_ACTIVO\"")
	private BigDecimal regActivo;

	@Column(name="\"TRA_EST_ID\"")
	private BigDecimal traEstId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"TRA_FEC_FIN\"")
	private Date traFecFin;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"TRA_FEC_INI\"")
	private Date traFecIni;

	@Column(name="\"TRA_MAR_ID\"")
	private BigDecimal traMarId;

	@Column(name="\"TRA_SER_ID\"")
	private BigDecimal traSerId;

	@Column(name="\"USU_CREA\"")
	private String usuCrea;

	@Column(name="\"USU_MODI\"")
	private String usuModi;

	//bi-directional many-to-one association to MrcMarcasDocumento
	@OneToMany(mappedBy="mrcMarcasTracking")
	private List<MrcMarcasDocumento> mrcMarcasDocumentos;

	//bi-directional many-to-one association to MrcMarcasPost
	@OneToMany(mappedBy="mrcMarcasTracking")
	private List<MrcMarcasPost> mrcMarcasPosts;

	//bi-directional many-to-one association to MrcMarca
	@ManyToOne
	@JoinColumns({
		})
	private MrcMarca mrcMarca;

	//bi-directional many-to-one association to MrcServiciosMarca
	@ManyToOne
	@JoinColumns({
		})
	private MrcServiciosMarca mrcServiciosMarca;

	public MrcMarcasTracking() {
	}

	public long getTraId() {
		return this.traId;
	}

	public void setTraId(long traId) {
		this.traId = traId;
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

	public BigDecimal getTraEstId() {
		return this.traEstId;
	}

	public void setTraEstId(BigDecimal traEstId) {
		this.traEstId = traEstId;
	}

	public Date getTraFecFin() {
		return this.traFecFin;
	}

	public void setTraFecFin(Date traFecFin) {
		this.traFecFin = traFecFin;
	}

	public Date getTraFecIni() {
		return this.traFecIni;
	}

	public void setTraFecIni(Date traFecIni) {
		this.traFecIni = traFecIni;
	}

	public BigDecimal getTraMarId() {
		return this.traMarId;
	}

	public void setTraMarId(BigDecimal traMarId) {
		this.traMarId = traMarId;
	}

	public BigDecimal getTraSerId() {
		return this.traSerId;
	}

	public void setTraSerId(BigDecimal traSerId) {
		this.traSerId = traSerId;
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

	public List<MrcMarcasDocumento> getMrcMarcasDocumentos() {
		return this.mrcMarcasDocumentos;
	}

	public void setMrcMarcasDocumentos(List<MrcMarcasDocumento> mrcMarcasDocumentos) {
		this.mrcMarcasDocumentos = mrcMarcasDocumentos;
	}

	public MrcMarcasDocumento addMrcMarcasDocumento(MrcMarcasDocumento mrcMarcasDocumento) {
		getMrcMarcasDocumentos().add(mrcMarcasDocumento);
		mrcMarcasDocumento.setMrcMarcasTracking(this);

		return mrcMarcasDocumento;
	}

	public MrcMarcasDocumento removeMrcMarcasDocumento(MrcMarcasDocumento mrcMarcasDocumento) {
		getMrcMarcasDocumentos().remove(mrcMarcasDocumento);
		mrcMarcasDocumento.setMrcMarcasTracking(null);

		return mrcMarcasDocumento;
	}

	public List<MrcMarcasPost> getMrcMarcasPosts() {
		return this.mrcMarcasPosts;
	}

	public void setMrcMarcasPosts(List<MrcMarcasPost> mrcMarcasPosts) {
		this.mrcMarcasPosts = mrcMarcasPosts;
	}

	public MrcMarcasPost addMrcMarcasPost(MrcMarcasPost mrcMarcasPost) {
		getMrcMarcasPosts().add(mrcMarcasPost);
		mrcMarcasPost.setMrcMarcasTracking(this);

		return mrcMarcasPost;
	}

	public MrcMarcasPost removeMrcMarcasPost(MrcMarcasPost mrcMarcasPost) {
		getMrcMarcasPosts().remove(mrcMarcasPost);
		mrcMarcasPost.setMrcMarcasTracking(null);

		return mrcMarcasPost;
	}

	public MrcMarca getMrcMarca() {
		return this.mrcMarca;
	}

	public void setMrcMarca(MrcMarca mrcMarca) {
		this.mrcMarca = mrcMarca;
	}

	public MrcServiciosMarca getMrcServiciosMarca() {
		return this.mrcServiciosMarca;
	}

	public void setMrcServiciosMarca(MrcServiciosMarca mrcServiciosMarca) {
		this.mrcServiciosMarca = mrcServiciosMarca;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (traId ^ (traId >>> 32));
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
		MrcMarcasTracking other = (MrcMarcasTracking) obj;
		if (traId != other.traId)
			return false;
		return true;
	}

}