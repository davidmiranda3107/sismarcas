package portal.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the "MRC_TIPOS_MARCA" database table.
 * 
 */
@Entity
@Table(name="\"MRC_TIPOS_MARCA\"", schema="sismar")
@NamedQuery(name="MrcTiposMarca.findAll", query="SELECT m FROM MrcTiposMarca m")
public class MrcTiposMarca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name="MRC_TIPOS_MARCA_SQ", schema="sismar", table="CONTADOR", pkColumnName="CNT_NOMBRE",valueColumnName="CNT_VALOR", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="MRC_TIPOS_MARCA_SQ")
	@Column(name="\"TIP_ID\"")
	private long tipId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"FEC_CREA\"")
	private Date fecCrea;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"FEC_MODI\"")
	private Date fecModi;

	@Column(name="\"REG_ACTIVO\"")
	private BigDecimal regActivo;

	@Column(name="\"TIP_ABREVIATURA\"")
	private String tipAbreviatura;

	@Column(name="\"TIP_NOMBRE_TIPO\"")
	private String tipNombreTipo;

	@Column(name="\"USU_CREA\"")
	private String usuCrea;

	@Column(name="\"USU_MODI\"")
	private String usuModi;

	public MrcTiposMarca() {
	}

	public long getTipId() {
		return this.tipId;
	}

	public void setTipId(long tipId) {
		this.tipId = tipId;
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

	public String getTipAbreviatura() {
		return this.tipAbreviatura;
	}

	public void setTipAbreviatura(String tipAbreviatura) {
		this.tipAbreviatura = tipAbreviatura;
	}

	public String getTipNombreTipo() {
		return this.tipNombreTipo;
	}

	public void setTipNombreTipo(String tipNombreTipo) {
		this.tipNombreTipo = tipNombreTipo;
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
		result = prime * result + (int) (tipId ^ (tipId >>> 32));
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
		MrcTiposMarca other = (MrcTiposMarca) obj;
		if (tipId != other.tipId)
			return false;
		return true;
	}

}