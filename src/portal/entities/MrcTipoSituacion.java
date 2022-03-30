package portal.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "MRC_TIPO_SITUACION" database table.
 * 
 */
@Entity
@Table(name="\"MRC_TIPO_SITUACION\"", schema="sismar")
@NamedQuery(name="MrcTipoSituacion.findAll", query="SELECT m FROM MrcTipoSituacion m")
public class MrcTipoSituacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name="MRC_TIPO_SITUACION_SQ", schema="sismar", table="CONTADOR", pkColumnName="CNT_NOMBRE",valueColumnName="CNT_VALOR", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="MRC_TIPO_SITUACION_SQ")
	@Column(name="\"SIT_ID\"")
	private long sitId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"FEC_CREA\"")
	private Date fecCrea;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"FEC_MODI\"")
	private Date fecModi;

	@Column(name="\"REG_ACTIVO\"")
	private BigDecimal regActivo;

	@Column(name="\"SIT_DESCRIPCION\"")
	private String sitDescripcion;

	@Column(name="\"SIT_NOMBRE\"")
	private String sitNombre;

	@Column(name="\"USU_CREA\"")
	private String usuCrea;

	@Column(name="\"USU_MODI\"")
	private String usuModi;

	//bi-directional many-to-one association to MrcMarca
	@OneToMany(mappedBy="mrcTipoSituacion")
	private List<MrcMarca> mrcMarcas;

	public MrcTipoSituacion() {
	}

	public long getSitId() {
		return this.sitId;
	}

	public void setSitId(long sitId) {
		this.sitId = sitId;
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

	public String getSitDescripcion() {
		return this.sitDescripcion;
	}

	public void setSitDescripcion(String sitDescripcion) {
		this.sitDescripcion = sitDescripcion;
	}

	public String getSitNombre() {
		return this.sitNombre;
	}

	public void setSitNombre(String sitNombre) {
		this.sitNombre = sitNombre;
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
		mrcMarca.setMrcTipoSituacion(this);

		return mrcMarca;
	}

	public MrcMarca removeMrcMarca(MrcMarca mrcMarca) {
		getMrcMarcas().remove(mrcMarca);
		mrcMarca.setMrcTipoSituacion(null);

		return mrcMarca;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (sitId ^ (sitId >>> 32));
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
		MrcTipoSituacion other = (MrcTipoSituacion) obj;
		if (sitId != other.sitId)
			return false;
		return true;
	}

}