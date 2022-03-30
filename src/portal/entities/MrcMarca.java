package portal.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "MRC_MARCAS" database table.
 * 
 */
@Entity
@Table(name="\"MRC_MARCAS\"", schema="sismar")
@NamedQuery(name="MrcMarca.findAll", query="SELECT m FROM MrcMarca m")
public class MrcMarca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name="MRC_MARCAS_SQ", schema="sismar", table="CONTADOR", pkColumnName="CNT_NOMBRE",valueColumnName="CNT_VALOR", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="MRC_MARCAS_SQ")
	@Column(name="\"MAR_ID\"")
	private long marId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"FEC_CREA\"")
	private Date fecCrea;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"FEC_MODI\"")
	private Date fecModi;

	@Column(name="\"MAR_CLI_ID\"")
	private BigDecimal marCliId;

	@Column(name="\"MAR_EST_ID\"")
	private BigDecimal marEstId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"MAR_FECHA_EXP\"")
	private Date marFechaExp;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"MAR_FECHA_INSCRIPCION\"")
	private Date marFechaInscripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"MAR_FECHA_OPOSICION\"")
	private Date marFechaOposicion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"MAR_FECHA_PODER\"")
	private Date marFechaPoder;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"MAR_FECHA_PRE\"")
	private Date marFechaPre;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"MAR_FECHA_PRI_PUB\"")
	private Date marFechaPriPub;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"MAR_FECHA_PRIORIDAD\"")
	private Date marFechaPrioridad;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"MAR_FECHA_VENCIMIENTO\"")
	private Date marFechaVencimiento;

	@Column(name="\"MAR_IMG\"")
	private byte[] marImg;

	@Column(name="\"MAR_NOMBRE\"")
	private String marNombre;

	@Column(name="\"MAR_NUM_EXP\"")
	private String marNumExp;

	@Column(name="\"MAR_NUM_INSCRIPCION\"")
	private BigDecimal marNumInscripcion;

	@Column(name="\"MAR_NUM_LIBRO\"")
	private BigDecimal marNumLibro;

	@Column(name="\"MAR_NUM_PRE\"")
	private String marNumPre;

	@Column(name="\"MAR_NUM_PRIORIDAD\"")
	private BigDecimal marNumPrioridad;

	@Column(name="\"MAR_OBSERVACION\"")
	private String marObservacion;

	@Column(name="\"MAR_PA_ID\"")
	private BigDecimal marPaId;

	@Column(name="\"MAR_PA_ID_PRIORIDAD\"")
	private BigDecimal marPaIdPrioridad;

	@Column(name="\"MAR_PROC_ID\"")
	private BigDecimal marProcId;

	@Column(name="\"MAR_SIT_ID\"")
	private BigDecimal marSitId;

	@Column(name="\"MAR_TIP_ID\"")
	private BigDecimal marTipId;

	@Column(name="\"MAR_TIT_ID\"")
	private BigDecimal marTitId;

	@Column(name="\"MAR_TS_ID\"")
	private BigDecimal marTsId;

	@Column(name="\"REG_ACTIVO\"")
	private BigDecimal regActivo;

	@Column(name="\"USU_CREA\"")
	private String usuCrea;

	@Column(name="\"USU_MODI\"")
	private String usuModi;

	//bi-directional many-to-one association to MrcCliente
	@ManyToOne
	@JoinColumns({
		})
	private MrcCliente mrcCliente;

	//bi-directional many-to-one association to MrcTipoProceso
	@ManyToOne
	@JoinColumns({
		})
	private MrcTipoProceso mrcTipoProceso;

	//bi-directional many-to-one association to MrcTipoSituacion
	@ManyToOne
	@JoinColumns({
		})
	private MrcTipoSituacion mrcTipoSituacion;

	//bi-directional many-to-one association to MrcTitulare
	@ManyToOne
	@JoinColumns({
		})
	private MrcTitulares mrcTitulare;

	//bi-directional many-to-one association to MrcMarcasClas
	@OneToMany(mappedBy="mrcMarca")
	private List<MrcMarcasClases> mrcMarcasClases;

	//bi-directional many-to-one association to MrcMarcasDocumento
	@OneToMany(mappedBy="mrcMarca")
	private List<MrcMarcasDocumento> mrcMarcasDocumentos;

	//bi-directional many-to-one association to MrcMarcasPost
	@OneToMany(mappedBy="mrcMarca")
	private List<MrcMarcasPost> mrcMarcasPosts;

	//bi-directional many-to-one association to MrcMarcasTracking
	@OneToMany(mappedBy="mrcMarca")
	private List<MrcMarcasTracking> mrcMarcasTrackings;

	public MrcMarca() {
	}

	public long getMarId() {
		return this.marId;
	}

	public void setMarId(long marId) {
		this.marId = marId;
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

	public BigDecimal getMarCliId() {
		return this.marCliId;
	}

	public void setMarCliId(BigDecimal marCliId) {
		this.marCliId = marCliId;
	}

	public BigDecimal getMarEstId() {
		return this.marEstId;
	}

	public void setMarEstId(BigDecimal marEstId) {
		this.marEstId = marEstId;
	}

	public Date getMarFechaExp() {
		return this.marFechaExp;
	}

	public void setMarFechaExp(Date marFechaExp) {
		this.marFechaExp = marFechaExp;
	}

	public Date getMarFechaInscripcion() {
		return this.marFechaInscripcion;
	}

	public void setMarFechaInscripcion(Date marFechaInscripcion) {
		this.marFechaInscripcion = marFechaInscripcion;
	}

	public Date getMarFechaOposicion() {
		return this.marFechaOposicion;
	}

	public void setMarFechaOposicion(Date marFechaOposicion) {
		this.marFechaOposicion = marFechaOposicion;
	}

	public Date getMarFechaPoder() {
		return this.marFechaPoder;
	}

	public void setMarFechaPoder(Date marFechaPoder) {
		this.marFechaPoder = marFechaPoder;
	}

	public Date getMarFechaPre() {
		return this.marFechaPre;
	}

	public void setMarFechaPre(Date marFechaPre) {
		this.marFechaPre = marFechaPre;
	}

	public Date getMarFechaPriPub() {
		return this.marFechaPriPub;
	}

	public void setMarFechaPriPub(Date marFechaPriPub) {
		this.marFechaPriPub = marFechaPriPub;
	}

	public Date getMarFechaPrioridad() {
		return this.marFechaPrioridad;
	}

	public void setMarFechaPrioridad(Date marFechaPrioridad) {
		this.marFechaPrioridad = marFechaPrioridad;
	}

	public Date getMarFechaVencimiento() {
		return this.marFechaVencimiento;
	}

	public void setMarFechaVencimiento(Date marFechaVencimiento) {
		this.marFechaVencimiento = marFechaVencimiento;
	}

	public byte[] getMarImg() {
		return this.marImg;
	}

	public void setMarImg(byte[] marImg) {
		this.marImg = marImg;
	}

	public String getMarNombre() {
		return this.marNombre;
	}

	public void setMarNombre(String marNombre) {
		this.marNombre = marNombre;
	}

	public String getMarNumExp() {
		return this.marNumExp;
	}

	public void setMarNumExp(String marNumExp) {
		this.marNumExp = marNumExp;
	}

	public BigDecimal getMarNumInscripcion() {
		return this.marNumInscripcion;
	}

	public void setMarNumInscripcion(BigDecimal marNumInscripcion) {
		this.marNumInscripcion = marNumInscripcion;
	}

	public BigDecimal getMarNumLibro() {
		return this.marNumLibro;
	}

	public void setMarNumLibro(BigDecimal marNumLibro) {
		this.marNumLibro = marNumLibro;
	}

	public String getMarNumPre() {
		return this.marNumPre;
	}

	public void setMarNumPre(String marNumPre) {
		this.marNumPre = marNumPre;
	}

	public BigDecimal getMarNumPrioridad() {
		return this.marNumPrioridad;
	}

	public void setMarNumPrioridad(BigDecimal marNumPrioridad) {
		this.marNumPrioridad = marNumPrioridad;
	}

	public String getMarObservacion() {
		return this.marObservacion;
	}

	public void setMarObservacion(String marObservacion) {
		this.marObservacion = marObservacion;
	}

	public BigDecimal getMarPaId() {
		return this.marPaId;
	}

	public void setMarPaId(BigDecimal marPaId) {
		this.marPaId = marPaId;
	}

	public BigDecimal getMarPaIdPrioridad() {
		return this.marPaIdPrioridad;
	}

	public void setMarPaIdPrioridad(BigDecimal marPaIdPrioridad) {
		this.marPaIdPrioridad = marPaIdPrioridad;
	}

	public BigDecimal getMarProcId() {
		return this.marProcId;
	}

	public void setMarProcId(BigDecimal marProcId) {
		this.marProcId = marProcId;
	}

	public BigDecimal getMarSitId() {
		return this.marSitId;
	}

	public void setMarSitId(BigDecimal marSitId) {
		this.marSitId = marSitId;
	}

	public BigDecimal getMarTipId() {
		return this.marTipId;
	}

	public void setMarTipId(BigDecimal marTipId) {
		this.marTipId = marTipId;
	}

	public BigDecimal getMarTitId() {
		return this.marTitId;
	}

	public void setMarTitId(BigDecimal marTitId) {
		this.marTitId = marTitId;
	}

	public BigDecimal getMarTsId() {
		return this.marTsId;
	}

	public void setMarTsId(BigDecimal marTsId) {
		this.marTsId = marTsId;
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

	public MrcCliente getMrcCliente() {
		return this.mrcCliente;
	}

	public void setMrcCliente(MrcCliente mrcCliente) {
		this.mrcCliente = mrcCliente;
	}

	public MrcTipoProceso getMrcTipoProceso() {
		return this.mrcTipoProceso;
	}

	public void setMrcTipoProceso(MrcTipoProceso mrcTipoProceso) {
		this.mrcTipoProceso = mrcTipoProceso;
	}

	public MrcTipoSituacion getMrcTipoSituacion() {
		return this.mrcTipoSituacion;
	}

	public void setMrcTipoSituacion(MrcTipoSituacion mrcTipoSituacion) {
		this.mrcTipoSituacion = mrcTipoSituacion;
	}

	public MrcTitulares getMrcTitulare() {
		return this.mrcTitulare;
	}

	public void setMrcTitulare(MrcTitulares mrcTitulare) {
		this.mrcTitulare = mrcTitulare;
	}

	public List<MrcMarcasClases> getMrcMarcasClases() {
		return this.mrcMarcasClases;
	}

	public void setMrcMarcasClases(List<MrcMarcasClases> mrcMarcasClases) {
		this.mrcMarcasClases = mrcMarcasClases;
	}

	public MrcMarcasClases addMrcMarcasClas(MrcMarcasClases mrcMarcasClas) {
		getMrcMarcasClases().add(mrcMarcasClas);
		mrcMarcasClas.setMrcMarca(this);

		return mrcMarcasClas;
	}

	public MrcMarcasClases removeMrcMarcasClas(MrcMarcasClases mrcMarcasClas) {
		getMrcMarcasClases().remove(mrcMarcasClas);
		mrcMarcasClas.setMrcMarca(null);

		return mrcMarcasClas;
	}

	public List<MrcMarcasDocumento> getMrcMarcasDocumentos() {
		return this.mrcMarcasDocumentos;
	}

	public void setMrcMarcasDocumentos(List<MrcMarcasDocumento> mrcMarcasDocumentos) {
		this.mrcMarcasDocumentos = mrcMarcasDocumentos;
	}

	public MrcMarcasDocumento addMrcMarcasDocumento(MrcMarcasDocumento mrcMarcasDocumento) {
		getMrcMarcasDocumentos().add(mrcMarcasDocumento);
		mrcMarcasDocumento.setMrcMarca(this);

		return mrcMarcasDocumento;
	}

	public MrcMarcasDocumento removeMrcMarcasDocumento(MrcMarcasDocumento mrcMarcasDocumento) {
		getMrcMarcasDocumentos().remove(mrcMarcasDocumento);
		mrcMarcasDocumento.setMrcMarca(null);

		return mrcMarcasDocumento;
	}

	public List<MrcMarcasPost> getMrcMarcasPosts() {
		return this.mrcMarcasPosts;
	}

	public void setMrcMarcasPosts(List<MrcMarcasPost> mrcMarcasPosts) {
		this.mrcMarcasPosts = mrcMarcasPosts;
	}

	public MrcMarcasPost addMrcMarcasPost(MrcMarcasPost mrcMarcasPost) {
		getMrcMarcasPosts().add(mrcMarcasPost);
		mrcMarcasPost.setMrcMarca(this);

		return mrcMarcasPost;
	}

	public MrcMarcasPost removeMrcMarcasPost(MrcMarcasPost mrcMarcasPost) {
		getMrcMarcasPosts().remove(mrcMarcasPost);
		mrcMarcasPost.setMrcMarca(null);

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
		mrcMarcasTracking.setMrcMarca(this);

		return mrcMarcasTracking;
	}

	public MrcMarcasTracking removeMrcMarcasTracking(MrcMarcasTracking mrcMarcasTracking) {
		getMrcMarcasTrackings().remove(mrcMarcasTracking);
		mrcMarcasTracking.setMrcMarca(null);

		return mrcMarcasTracking;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (marId ^ (marId >>> 32));
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
		MrcMarca other = (MrcMarca) obj;
		if (marId != other.marId)
			return false;
		return true;
	}

}