package portal.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the "MRC_MARCAS_CLASES" database table.
 * 
 */
@Entity
@Table(name="\"MRC_MARCAS_CLASES\"", schema="sismar")
@NamedQuery(name="MrcMarcasClases.findAll", query="SELECT m FROM MrcMarcasClases m")
public class MrcMarcasClases implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name="MRC_MARCAS_CLASES_SQ", schema="sismar", table="CONTADOR", pkColumnName="CNT_NOMBRE",valueColumnName="CNT_VALOR", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="MRC_MARCAS_CLASES_SQ")
	@Column(name="\"MCL_ID\"")
	private long mclId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"FEC_CREA\"")
	private Date fecCrea;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"FEC_MODI\"")
	private Date fecModi;

	@Column(name="\"MCL_CL_ID\"")
	private BigDecimal mclClId;

	@Column(name="\"MCL_DESCRIPCION\"")
	private String mclDescripcion;

	@Column(name="\"MCL_MAR_ID\"")
	private BigDecimal mclMarId;

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

	public MrcMarcasClases() {
	}

	public long getMclId() {
		return this.mclId;
	}

	public void setMclId(long mclId) {
		this.mclId = mclId;
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

	public BigDecimal getMclClId() {
		return this.mclClId;
	}

	public void setMclClId(BigDecimal mclClId) {
		this.mclClId = mclClId;
	}

	public String getMclDescripcion() {
		return this.mclDescripcion;
	}

	public void setMclDescripcion(String mclDescripcion) {
		this.mclDescripcion = mclDescripcion;
	}

	public BigDecimal getMclMarId() {
		return this.mclMarId;
	}

	public void setMclMarId(BigDecimal mclMarId) {
		this.mclMarId = mclMarId;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (mclId ^ (mclId >>> 32));
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
		MrcMarcasClases other = (MrcMarcasClases) obj;
		if (mclId != other.mclId)
			return false;
		return true;
	}

}