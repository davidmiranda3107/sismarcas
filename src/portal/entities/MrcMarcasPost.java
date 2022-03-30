package portal.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the "MRC_MARCAS_POST" database table.
 * 
 */
@Entity
@Table(name="\"MRC_MARCAS_POST\"", schema="sismar")
@NamedQuery(name="MrcMarcasPost.findAll", query="SELECT m FROM MrcMarcasPost m")
public class MrcMarcasPost implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name="MRC_MARCAS_POST_SQ", schema="sismar", table="CONTADOR", pkColumnName="CNT_NOMBRE",valueColumnName="CNT_VALOR", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="MRC_MARCAS_POST_SQ")
	@Column(name="\"POST_ID\"")
	private long postId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"FEC_CREA\"")
	private Date fecCrea;

	@Column(name="\"FEC_MODI\"")
	private String fecModi;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"POST_FECHA_INS\"")
	private Date postFechaIns;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"POST_FECHA_PRE\"")
	private Date postFechaPre;

	@Column(name="\"POST_MAR_ID\"")
	private BigDecimal postMarId;

	@Column(name="\"POST_NUM_INS\"")
	private BigDecimal postNumIns;

	@Column(name="\"POST_NUM_LIBRO\"")
	private BigDecimal postNumLibro;

	@Column(name="\"POST_NUM_PRE\"")
	private String postNumPre;

	@Column(name="\"POST_SER_ID\"")
	private BigDecimal postSerId;

	@Column(name="\"POST_TRA_ID\"")
	private BigDecimal postTraId;

	@Column(name="\"REG_ACTIVO\"")
	private BigDecimal regActivo;

	@Column(name="\"USU_CREA\"")
	private String usuCrea;

	@Column(name="\"USU_MODI\"")
	private String usuModi;

	//bi-directional many-to-one association to MrcMarca
	@ManyToOne
	@JoinColumns({
		})
	private MrcMarca mrcMarca;

	//bi-directional many-to-one association to MrcMarcasTracking
	@ManyToOne
	@JoinColumns({
		})
	private MrcMarcasTracking mrcMarcasTracking;

	//bi-directional many-to-one association to MrcServiciosMarca
	@ManyToOne
	@JoinColumns({
		})
	private MrcServiciosMarca mrcServiciosMarca;

	public MrcMarcasPost() {
	}

	public long getPostId() {
		return this.postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public Date getFecCrea() {
		return this.fecCrea;
	}

	public void setFecCrea(Date fecCrea) {
		this.fecCrea = fecCrea;
	}

	public String getFecModi() {
		return this.fecModi;
	}

	public void setFecModi(String fecModi) {
		this.fecModi = fecModi;
	}

	public Date getPostFechaIns() {
		return this.postFechaIns;
	}

	public void setPostFechaIns(Date postFechaIns) {
		this.postFechaIns = postFechaIns;
	}

	public Date getPostFechaPre() {
		return this.postFechaPre;
	}

	public void setPostFechaPre(Date postFechaPre) {
		this.postFechaPre = postFechaPre;
	}

	public BigDecimal getPostMarId() {
		return this.postMarId;
	}

	public void setPostMarId(BigDecimal postMarId) {
		this.postMarId = postMarId;
	}

	public BigDecimal getPostNumIns() {
		return this.postNumIns;
	}

	public void setPostNumIns(BigDecimal postNumIns) {
		this.postNumIns = postNumIns;
	}

	public BigDecimal getPostNumLibro() {
		return this.postNumLibro;
	}

	public void setPostNumLibro(BigDecimal postNumLibro) {
		this.postNumLibro = postNumLibro;
	}

	public String getPostNumPre() {
		return this.postNumPre;
	}

	public void setPostNumPre(String postNumPre) {
		this.postNumPre = postNumPre;
	}

	public BigDecimal getPostSerId() {
		return this.postSerId;
	}

	public void setPostSerId(BigDecimal postSerId) {
		this.postSerId = postSerId;
	}

	public BigDecimal getPostTraId() {
		return this.postTraId;
	}

	public void setPostTraId(BigDecimal postTraId) {
		this.postTraId = postTraId;
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

	public MrcMarca getMrcMarca() {
		return this.mrcMarca;
	}

	public void setMrcMarca(MrcMarca mrcMarca) {
		this.mrcMarca = mrcMarca;
	}

	public MrcMarcasTracking getMrcMarcasTracking() {
		return this.mrcMarcasTracking;
	}

	public void setMrcMarcasTracking(MrcMarcasTracking mrcMarcasTracking) {
		this.mrcMarcasTracking = mrcMarcasTracking;
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
		result = prime * result + (int) (postId ^ (postId >>> 32));
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
		MrcMarcasPost other = (MrcMarcasPost) obj;
		if (postId != other.postId)
			return false;
		return true;
	}

}