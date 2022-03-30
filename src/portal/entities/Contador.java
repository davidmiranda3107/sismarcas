package portal.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the "CONTADOR" database table.
 * 
 */
@Entity
@Table(name="\"CONTADOR\"", schema="sismar")
@NamedQuery(name="Contador.findAll", query="SELECT c FROM Contador c")
public class Contador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name="CONTADOR", schema="sismar", table="CONTADOR", pkColumnName="CNT_NOMBRE",valueColumnName="CNT_VALOR", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="CONTADOR")
	@Column(name="\"CNT_ID\"")
	private long cntId;

	@Column(name="\"CNT_DESCRIPCION\"")
	private String cntDescripcion;

	@Column(name="\"CNT_NOMBRE\"")
	private String cntNombre;

	@Column(name="\"CNT_VALOR\"")
	private BigDecimal cntValor;

	public Contador() {
	}

	public long getCntId() {
		return this.cntId;
	}

	public void setCntId(long cntId) {
		this.cntId = cntId;
	}

	public String getCntDescripcion() {
		return this.cntDescripcion;
	}

	public void setCntDescripcion(String cntDescripcion) {
		this.cntDescripcion = cntDescripcion;
	}

	public String getCntNombre() {
		return this.cntNombre;
	}

	public void setCntNombre(String cntNombre) {
		this.cntNombre = cntNombre;
	}

	public BigDecimal getCntValor() {
		return this.cntValor;
	}

	public void setCntValor(BigDecimal cntValor) {
		this.cntValor = cntValor;
	}

}