package portal.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "MRC_SERVICIOS_MARCA" database table.
 * 
 */
@Entity
@Table(name="\"MRC_SERVICIOS_MARCA\"", schema="sismar")
@NamedQuery(name="MrcServiciosMarca.findAll", query="SELECT m FROM MrcServiciosMarca m")
public class MrcServiciosMarca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name="MRC_SERVICIOS_MARCA_SQ", schema="sismar", table="CONTADOR", pkColumnName="CNT_NOMBRE",valueColumnName="CNT_VALOR", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="MRC_SERVICIOS_MARCA_SQ")
	@Column(name="\"SER_ID\"")
	private long serId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"FEC_CREA\"")
	private Date fecCrea;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"FEC_MODI\"")
	private Date fecModi;

	@Column(name="\"REG_ACTIVO\"")
	private BigDecimal regActivo;

	@Column(name="\"SER_DESCRIPCION\"")
	private String serDescripcion;

	@Column(name="\"SER_NOMBRE\"")
	private String serNombre;

	@Column(name="\"USU_CREA\"")
	private String usuCrea;

	@Column(name="\"USU_MODI\"")
	private String usuModi;

	//bi-directional many-to-one association to MrcMarcasPost
	@OneToMany(mappedBy="mrcServiciosMarca")
	private List<MrcMarcasPost> mrcMarcasPosts;

	//bi-directional many-to-one association to MrcMarcasTracking
	@OneToMany(mappedBy="mrcServiciosMarca")
	private List<MrcMarcasTracking> mrcMarcasTrackings;

	public MrcServiciosMarca() {
	}

	public long getSerId() {
		return this.serId;
	}

	public void setSerId(long serId) {
		this.serId = serId;
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

	public String getSerDescripcion() {
		return this.serDescripcion;
	}

	public void setSerDescripcion(String serDescripcion) {
		this.serDescripcion = serDescripcion;
	}

	public String getSerNombre() {
		return this.serNombre;
	}

	public void setSerNombre(String serNombre) {
		this.serNombre = serNombre;
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

	public List<MrcMarcasPost> getMrcMarcasPosts() {
		return this.mrcMarcasPosts;
	}

	public void setMrcMarcasPosts(List<MrcMarcasPost> mrcMarcasPosts) {
		this.mrcMarcasPosts = mrcMarcasPosts;
	}

	public MrcMarcasPost addMrcMarcasPost(MrcMarcasPost mrcMarcasPost) {
		getMrcMarcasPosts().add(mrcMarcasPost);
		mrcMarcasPost.setMrcServiciosMarca(this);

		return mrcMarcasPost;
	}

	public MrcMarcasPost removeMrcMarcasPost(MrcMarcasPost mrcMarcasPost) {
		getMrcMarcasPosts().remove(mrcMarcasPost);
		mrcMarcasPost.setMrcServiciosMarca(null);

		return mrcMarcasPost;
	}

	public List<MrcMarcasTracking> getMrcMarcasTrackings() {
		return this.mrcMarcasTrackings;
	}

	public void setMrcMarcasTrackings(List<MrcMarcasTracking> mrcMarcasTrackings) {
		this.mrcMarcasTrackings = mrcMarcasTrackings;
	}

	public MrcMarcasTracking addMrcMarcasTracking(MrcMarcasTracking mrcMarcasTracking) {
		getMrcMarcasTrackings().add(mrcMarcasTracking);
		mrcMarcasTracking.setMrcServiciosMarca(this);

		return mrcMarcasTracking;
	}

	public MrcMarcasTracking removeMrcMarcasTracking(MrcMarcasTracking mrcMarcasTracking) {
		getMrcMarcasTrackings().remove(mrcMarcasTracking);
		mrcMarcasTracking.setMrcServiciosMarca(null);

		return mrcMarcasTracking;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (serId ^ (serId >>> 32));
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
		MrcServiciosMarca other = (MrcServiciosMarca) obj;
		if (serId != other.serId)
			return false;
		return true;
	}

}