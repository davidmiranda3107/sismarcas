package portal.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the "MRC_MARCAS_DOCUMENTOS" database table.
 * 
 */
@Entity
@Table(name="\"MRC_MARCAS_DOCUMENTOS\"", schema="sismar")
@NamedQuery(name="MrcMarcasDocumento.findAll", query="SELECT m FROM MrcMarcasDocumento m")
public class MrcMarcasDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name="MRC_MARCAS_COCUMENTOS_SQ", schema="sismar", table="CONTADOR", pkColumnName="CNT_NOMBRE",valueColumnName="CNT_VALOR", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="MRC_MARCAS_COCUMENTOS_SQ")
	@Column(name="\"MDOC_ID\"")
	private long mdocId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"FEC_CREA\"")
	private Date fecCrea;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"FEC_MODI\"")
	private Date fecModi;

	@Column(name="\"MDOC_DOCUMENTO\"")
	private byte[] mdocDocumento;

	@Column(name="\"MDOC_MAR_ID\"")
	private BigDecimal mdocMarId;

	@Column(name="\"MDOC_TRA_ID\"")
	private BigDecimal mdocTraId;

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

	public MrcMarcasDocumento() {
	}

	public long getMdocId() {
		return this.mdocId;
	}

	public void setMdocId(long mdocId) {
		this.mdocId = mdocId;
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

	public byte[] getMdocDocumento() {
		return this.mdocDocumento;
	}

	public void setMdocDocumento(byte[] mdocDocumento) {
		this.mdocDocumento = mdocDocumento;
	}

	public BigDecimal getMdocMarId() {
		return this.mdocMarId;
	}

	public void setMdocMarId(BigDecimal mdocMarId) {
		this.mdocMarId = mdocMarId;
	}

	public BigDecimal getMdocTraId() {
		return this.mdocTraId;
	}

	public void setMdocTraId(BigDecimal mdocTraId) {
		this.mdocTraId = mdocTraId;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (mdocId ^ (mdocId >>> 32));
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
		MrcMarcasDocumento other = (MrcMarcasDocumento) obj;
		if (mdocId != other.mdocId)
			return false;
		return true;
	}

}