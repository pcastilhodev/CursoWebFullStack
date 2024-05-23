package com.example.demo.model;


	import java.io.Serializable;
	import java.math.BigDecimal;
	import java.util.Date;
	import java.util.Objects;

	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.SequenceGenerator;
	import jakarta.persistence.Table;
	import jakarta.persistence.Temporal;
	import jakarta.persistence.TemporalType;

	@Entity
	@Table(name = "CUPOM_DESCONTO")
	@SequenceGenerator(name = "SEQ_CUPOM_DESCONTO", sequenceName = "SEQ_CUPOM_DESCONTO", allocationSize = 1, initialValue = 1)
	public class CupomDesconto implements Serializable{

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CUPOM_DESCONTO")
	private Long id;

	private String CodigoDescricao;

	private BigDecimal ValorRealDescricao;

	private BigDecimal ValorPorcentoDescricao;


	@Temporal(TemporalType.DATE)
	private Date ValidadeCupom;

	public Long getId() {
	return id;
	}

	public void setId(Long id) {
	this.id = id;
	}

	public String getCodigoDescricao() {
	return CodigoDescricao;
	}

	public void setCodigoDescricao(String codigoDescricao) {
	CodigoDescricao = codigoDescricao;
	}

	public BigDecimal getValorRealDescricao() {
	return ValorRealDescricao;
	}

	public void setValorRealDescricao(BigDecimal valorRealDescricao) {
	ValorRealDescricao = valorRealDescricao;
	}

	public BigDecimal getValorPorcentoDescricao() {
	return ValorPorcentoDescricao;
	}

	public void setValorPorcentoDescricao(BigDecimal valorPorcentoDescricao) {
	ValorPorcentoDescricao = valorPorcentoDescricao;
	}

	public Date getValidadeCupom() {
	return ValidadeCupom;
	}

	public void setValidadeCupom(Date validadeCupom) {
	ValidadeCupom = validadeCupom;
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
	CupomDesconto other = (CupomDesconto) obj;
	return Objects.equals(id, other.id);
	}

	}
