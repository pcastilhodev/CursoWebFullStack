package com.example.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "NOTA_FISCAL_COMPRA")
@SequenceGenerator(name = "SEQ_NOTA_FISCAL_COMPRA", sequenceName = "SEQ_NOTA_FISCAL_COMPRA", allocationSize = 1, initialValue = 1)
public class NotaFiscalCompra implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_NOTA_FISCAL_COMPRA")
	private Long id;
	
	private String NumeroNota;
	private String SerieNota;
	private String descricao;
	private BigDecimal ValorTotal;
	private BigDecimal ValorDesconto;
	private BigDecimal ValorICMS;
	
	@ManyToOne(targetEntity = pessoa.class)
	@JoinColumn(name = "PESSOA_ID", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_PESSOAS_ID"))
	private pessoa pessoa;
	
	@ManyToOne(targetEntity = ContasPagar.class)
	@JoinColumn(name = "CONTAS_PAGAR_ID", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_CONTAS_PAGAR_ID"))
	private ContasPagar ContasPagar;
	
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValorTotal() {
		return ValorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		ValorTotal = valorTotal;
	}

	public BigDecimal getValorDesconto() {
		return ValorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		ValorDesconto = valorDesconto;
	}

	public BigDecimal getValorICMS() {
		return ValorICMS;
	}

	public void setValorICMS(BigDecimal valorICMS) {
		ValorICMS = valorICMS;
	}

	public Date getDataCompra() {
		return DataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		DataCompra = dataCompra;
	}

	@Temporal(TemporalType.DATE)
	private Date DataCompra;

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
		NotaFiscalCompra other = (NotaFiscalCompra) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
