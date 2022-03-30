package portal.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the "MRC_CLASES" database table.
 * 
 */
@Entity
@Table(name="\"MRC_CLASES\"", schema="sismar")
@NamedQuery(name="MrcClases.findAll", query="SELECT m FROM MrcClases m")
public class MrcClases implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name="MRC_CLASES_SQ", schema="sismar", table="CONTADOR", pkColumnName="CNT_NOMBRE",valueColumnName="CNT_VALOR", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="MRC_CLASES_SQ")
	@Column(name="\"CL_ID\"")
	private long clId;

	@Column(name="\"CL_DESCRIPCION\"")
	private String clDescripcion;

	@Column(name="\"CL_NOMBRE\"")
	private String clNombre;

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

	public MrcClases() {
	}

	public long getClId() {
		return this.clId;
	}

	public void setClId(long clId) {
		this.clId = clId;
	}

	public String getClDescripcion() {
		return this.clDescripcion;
	}

	public void setClDescripcion(String clDescripcion) {
		this.clDescripcion = clDescripcion;
	}

	public String getClNombre() {
		return this.clNombre;
	}

	public void setClNombre(String clNombre) {
		this.clNombre = clNombre;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (clId ^ (clId >>> 32));
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
		MrcClases other = (MrcClases) obj;
		if (clId != other.clId)
			return false;
		return true;
	}

}