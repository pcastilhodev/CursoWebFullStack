package com.example.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "NOTA_FISCAL_VENDA")
@SequenceGenerator(name = "SEQ_NOTA_FISCAL_VENDA", sequenceName = "SEQ_NOTA_FISCAL_VENDA", allocationSize = 1, initialValue = 1)
public class NotaFiscalVenda implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_NOTA_FISCAL_VENDA")
	private Long id;
	
	private String NumeroNota;
	
	private String SerieNota;
	
	private String tipo;
	
	@Column(columnDefinition = "text", nullable = false)
	private String xml;
	
	@Column(columnDefinition = "text", nullable = false)
	private String pdf;
	
	private BigDecimal ValorICMS;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroNota() {
		return NumeroNota;
	}

	public void setNumeroNota(String numeroNota) {
		NumeroNota = numeroNota;
	}

	public String getSerieNota() {
		return SerieNota;
	}

	public void setSerieNota(String serieNota) {
		SerieNota = serieNota;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	public BigDecimal getValorICMS() {
		return ValorICMS;
	}

	public void setValorICMS(BigDecimal valorICMS) {
		ValorICMS = valorICMS;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotaFiscalVenda other = (NotaFiscalVenda) obj;
		return Objects.equals(id, other.id);
	}
	
}