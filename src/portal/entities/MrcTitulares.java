package portal.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "MRC_TITULARES" database table.
 * 
 */
@Entity
@Table(name="\"MRC_TITULARES\"", schema="sismar")
@NamedQuery(name="MrcTitulares.findAll", query="SELECT m FROM MrcTitulares m")
public class MrcTitulares implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name="MRC_TITULARES_SQ", schema="sismar", table="CONTADOR", pkColumnName="CNT_NOMBRE",valueColumnName="CNT_VALOR", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="MRC_TITULARES_SQ")
	@Column(name="\"TIT_ID\"")
	private long titId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"FEC_CREA\"")
	private Date fecCrea;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"FEC_MODI\"")
	private Date fecModi;

	@Column(name="\"REG_ACTIVO\"")
	private BigDecimal regActivo;

	@Column(name="\"TIT_DIRECCION\"")
	private String titDireccion;

	@Column(name="\"TIT_NOMBRE\"")
	private String titNombre;

	@Column(name="\"TIT_PA_ID\"")
	private BigDecimal titPaId;

	@Column(name="\"TIT_REFERENCIA\"")
	private BigDecimal titReferencia;

	@Column(name="\"USU_CREA\"")
	private String usuCrea;

	@Column(name="\"USU_MODI\"")
	private String usuModi;

	//bi-directional many-to-one association to MrcMarca
	@OneToMany(mappedBy="mrcTitulare")
	private List<MrcMarca> mrcMarcas;

	public MrcTitulares() {
	}

	public long getTitId() {
		return this.titId;
	}

	public void setTitId(long titId) {
		this.titId = titId;
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

	public String getTitDireccion() {
		return this.titDireccion;
	}

	public void setTitDireccion(String titDireccion) {
		this.titDireccion = titDireccion;
	}

	public String getTitNombre() {
		return this.titNombre;
	}

	public void setTitNombre(String titNombre) {
		this.titNombre = titNombre;
	}

	public BigDecimal getTitPaId() {
		return this.titPaId;
	}

	public void setTitPaId(BigDecimal titPaId) {
		this.titPaId = titPaId;
	}

	public BigDecimal getTitReferencia() {
		return this.titReferencia;
	}

	public void setTitReferencia(BigDecimal titReferencia) {
		this.titReferencia = titReferencia;
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
		mrcMarca.setMrcTitulare(this);

		return mrcMarca;
	}

	public MrcMarca removeMrcMarca(MrcMarca mrcMarca) {
		getMrcMarcas().remove(mrcMarca);
		mrcMarca.setMrcTitulare(null);

		return mrcMarca;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (titId ^ (titId >>> 32));
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
		MrcTitulares other = (MrcTitulares) obj;
		if (titId != other.titId)
			return false;
		return true;
	}

}