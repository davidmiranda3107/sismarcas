package portal.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "MRC_TIPO_PROCESO" database table.
 * 
 */
@Entity
@Table(name="\"MRC_TIPO_PROCESO\"", schema="sismar")
@NamedQuery(name="MrcTipoProceso.findAll", query="SELECT m FROM MrcTipoProceso m")
public class MrcTipoProceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name="MRC_TIPO_PROCESO_SQ", schema="sismar", table="CONTADOR", pkColumnName="CNT_NOMBRE",valueColumnName="CNT_VALOR", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="MRC_TIPO_PROCESO_SQ")
	@Column(name="\"PROC_ID\"")
	private long procId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"FEC_CREA\"")
	private Date fecCrea;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"FEC_MODI\"")
	private Date fecModi;

	@Column(name="\"PROC_DESCRIPCION\"")
	private String procDescripcion;

	@Column(name="\"PROC_NOMBRE\"")
	private String procNombre;

	@Column(name="\"REG_ACTIVO\"")
	private BigDecimal regActivo;

	@Column(name="\"USU_CREA\"")
	private String usuCrea;

	@Column(name="\"USU_MODI\"")
	private String usuModi;

	//bi-directional many-to-one association to MrcMarca
	@OneToMany(mappedBy="mrcTipoProceso")
	private List<MrcMarca> mrcMarcas;

	public MrcTipoProceso() {
	}

	public long getProcId() {
		return this.procId;
	}

	public void setProcId(long procId) {
		this.procId = procId;
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

	public String getProcDescripcion() {
		return this.procDescripcion;
	}

	public void setProcDescripcion(String procDescripcion) {
		this.procDescripcion = procDescripcion;
	}

	public String getProcNombre() {
		return this.procNombre;
	}

	public void setProcNombre(String procNombre) {
		this.procNombre = procNombre;
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

	public List<MrcMarca> getMrcMarcas() {
		return this.mrcMarcas;
	}

	public void setMrcMarcas(List<MrcMarca> mrcMarcas) {
		this.mrcMarcas = mrcMarcas;
	}

	public MrcMarca addMrcMarca(MrcMarca mrcMarca) {
		getMrcMarcas().add(mrcMarca);
		mrcMarca.setMrcTipoProceso(this);

		return mrcMarca;
	}

	public MrcMarca removeMrcMarca(MrcMarca mrcMarca) {
		getMrcMarcas().remove(mrcMarca);
		mrcMarca.setMrcTipoProceso(null);

		return mrcMarca;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (procId ^ (procId >>> 32));
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
		MrcTipoProceso other = (MrcTipoProceso) obj;
		if (procId != other.procId)
			return false;
		return true;
	}

}