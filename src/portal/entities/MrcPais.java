package portal.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the "MRC_PAISES" database table.
 * 
 */
@Entity
@Table(name="\"MRC_PAISES\"", schema="sismar")
@NamedQuery(name="MrcPais.findAll", query="SELECT m FROM MrcPais m")
public class MrcPais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name="MRC_PAISES_SQ", schema="sismar", table="CONTADOR", pkColumnName="CNT_NOMBRE",valueColumnName="CNT_VALOR", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="MRC_PAISES_SQ")
	@Column(name="\"PA_ID\"")
	private long paId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"FEC_CREA\"")
	private Date fecCrea;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"FEC_MODI\"")
	private Date fecModi;

	@Column(name="\"PA_CODIGO\"")
	private String paCodigo;

	@Column(name="\"PA_NOMBRE\"")
	private String paNombre;

	@Column(name="\"REG_ACTIVO\"")
	private BigDecimal regActivo;

	@Column(name="\"USU_CREA\"")
	private String usuCrea;

	@Column(name="\"USU_MODI\"")
	private String usuModi;

	public MrcPais() {
	}

	public long getPaId() {
		return this.paId;
	}

	public void setPaId(long paId) {
		this.paId = paId;
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

	public String getPaCodigo() {
		return this.paCodigo;
	}

	public void setPaCodigo(String paCodigo) {
		this.paCodigo = paCodigo;
	}

	public String getPaNombre() {
		return this.paNombre;
	}

	public void setPaNombre(String paNombre) {
		this.paNombre = paNombre;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (paId ^ (paId >>> 32));
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
		MrcPais other = (MrcPais) obj;
		if (paId != other.paId)
			return false;
		return true;
	}

}