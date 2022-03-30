package portal.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "MRC_CLIENTES" database table.
 * 
 */
@Entity
@Table(name="\"MRC_CLIENTES\"", schema="sismar")
@NamedQuery(name="MrcCliente.findAll", query="SELECT m FROM MrcCliente m")
public class MrcCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name="MRC_CLIENTES_SQ", schema="sismar", table="CONTADOR", pkColumnName="CNT_NOMBRE",valueColumnName="CNT_VALOR", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="MRC_CLIENTES_SQ")
	@Column(name="\"CLI_ID\"")
	private long cliId;

	@Column(name="\"CLI_CORREO\"")
	private String cliCorreo;

	@Column(name="\"CLI_DIRECCION\"")
	private String cliDireccion;

	@Column(name="\"CLI_FAX\"")
	private String cliFax;

	@Column(name="\"CLI_NOMBRE\"")
	private String cliNombre;

	@Column(name="\"CLI_OBSERVACION\"")
	private String cliObservacion;

	@Column(name="\"CLI_PA_ID\"")
	private BigDecimal cliPaId;

	@Column(name="\"CLI_TELEFONO\"")
	private String cliTelefono;

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

	//bi-directional many-to-one association to MrcMarca
	@OneToMany(mappedBy="mrcCliente")
	private List<MrcMarca> mrcMarcas;

	public MrcCliente() {
	}

	public long getCliId() {
		return this.cliId;
	}

	public void setCliId(long cliId) {
		this.cliId = cliId;
	}

	public String getCliCorreo() {
		return this.cliCorreo;
	}

	public void setCliCorreo(String cliCorreo) {
		this.cliCorreo = cliCorreo;
	}

	public String getCliDireccion() {
		return this.cliDireccion;
	}

	public void setCliDireccion(String cliDireccion) {
		this.cliDireccion = cliDireccion;
	}

	public String getCliFax() {
		return this.cliFax;
	}

	public void setCliFax(String cliFax) {
		this.cliFax = cliFax;
	}

	public String getCliNombre() {
		return this.cliNombre;
	}

	public void setCliNombre(String cliNombre) {
		this.cliNombre = cliNombre;
	}

	public String getCliObservacion() {
		return this.cliObservacion;
	}

	public void setCliObservacion(String cliObservacion) {
		this.cliObservacion = cliObservacion;
	}

	public BigDecimal getCliPaId() {
		return this.cliPaId;
	}

	public void setCliPaId(BigDecimal cliPaId) {
		this.cliPaId = cliPaId;
	}

	public String getCliTelefono() {
		return this.cliTelefono;
	}

	public void setCliTelefono(String cliTelefono) {
		this.cliTelefono = cliTelefono;
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

	public List<MrcMarca> getMrcMarcas() {
		return this.mrcMarcas;
	}

	public void setMrcMarcas(List<MrcMarca> mrcMarcas) {
		this.mrcMarcas = mrcMarcas;
	}

	public MrcMarca addMrcMarca(MrcMarca mrcMarca) {
		getMrcMarcas().add(mrcMarca);
		mrcMarca.setMrcCliente(this);

		return mrcMarca;
	}

	public MrcMarca removeMrcMarca(MrcMarca mrcMarca) {
		getMrcMarcas().remove(mrcMarca);
		mrcMarca.setMrcCliente(null);

		return mrcMarca;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cliId ^ (cliId >>> 32));
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
		MrcCliente other = (MrcCliente) obj;
		if (cliId != other.cliId)
			return false;
		return true;
	}

}