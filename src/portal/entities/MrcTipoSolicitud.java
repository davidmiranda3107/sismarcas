package portal.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the "MRC_TIPO_SOLICITUD" database table.
 * 
 */
@Entity
@Table(name="\"MRC_TIPO_SOLICITUD\"", schema="sismar" )
@NamedQuery(name="MrcTipoSolicitud.findAll", query="SELECT m FROM MrcTipoSolicitud m")
public class MrcTipoSolicitud implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name="MRC_TIPO_SOLICITUD_SQ", schema="sismar", table="CONTADOR", pkColumnName="CNT_NOMBRE",valueColumnName="CNT_VALOR", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="MRC_TIPO_SOLICITUD_SQ")
	@Column(name="\"TS_ID\"")
	private long tsId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"FEC_CREA\"")
	private Date fecCrea;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"FEC_MODI\"")
	private Date fecModi;

	@Column(name="\"REG_ACTIVO\"")
	private BigDecimal regActivo;

	@Column(name="\"TS_ABREVIATURA\"")
	private String tsAbreviatura;

	@Column(name="\"TS_DESCRIPCION\"")
	private String tsDescripcion;

	@Column(name="\"USU_CREA\"")
	private String usuCrea;

	@Column(name="\"USU_MODI\"")
	private String usuModi;

	public MrcTipoSolicitud() {
	}

	public long getTsId() {
		return this.tsId;
	}

	public void setTsId(long tsId) {
		this.tsId = tsId;
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

	public String getTsAbreviatura() {
		return this.tsAbreviatura;
	}

	public void setTsAbreviatura(String tsAbreviatura) {
		this.tsAbreviatura = tsAbreviatura;
	}

	public String getTsDescripcion() {
		return this.tsDescripcion;
	}

	public void setTsDescripcion(String tsDescripcion) {
		this.tsDescripcion = tsDescripcion;
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
		result = prime * result + (int) (tsId ^ (tsId >>> 32));
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
		MrcTipoSolicitud other = (MrcTipoSolicitud) obj;
		if (tsId != other.tsId)
			return false;
		return true;
	}

}