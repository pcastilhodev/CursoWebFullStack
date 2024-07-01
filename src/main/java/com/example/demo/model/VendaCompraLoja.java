package com.example.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "VENDA_COMPRA_LOJA")
@SequenceGenerator(name = "SEQ_VENDA_COMPRA_LOJA", sequenceName = "SEQ_VENDA_COMPRA_LOJA", allocationSize = 1, initialValue = 1)
public class VendaCompraLoja implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VENDA_COMPRA_LOJA")
	private Long id;

	@ManyToOne(targetEntity = pessoa.class)
	@JoinColumn(name = "PESSOA_ID", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_PESSOAS_ID"))
	private pessoa pessoa;
	
	@ManyToOne(targetEntity = pessoa.class)
	@JoinColumn(name = "ENDERECO_ID", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_ENDERECO_ID"))
	private endereco endereco;
	
	@ManyToOne(targetEntity = endereco.class)
	@JoinColumn(name = "ENDERECO_COBRANCA_ID", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_ENDERECO_COBRANCA_ID"))
	private endereco EnderecoCobranca;
	@Column (nullable = false)
	private BigDecimal ValorTotal;
	
	private BigDecimal ValorDesconto;
	
	@ManyToOne(targetEntity = FormaPagamento.class)
	@JoinColumn(name = "FORMA_PAGAMENTO_ID", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_FORMA_PAGAMENTO_ID"))
	private FormaPagamento FormaPagamento;

	@OneToOne(targetEntity = NotaFiscalVenda.class)
	@JoinColumn(name = "NOTA_FISCAL_VENDA__ID", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_NOTA_FISCAL_VENDA_ID"))
	private NotaFiscalVenda notaFiscalVenda;

	@OneToOne(targetEntity = CupomDesconto.class)
	@JoinColumn(name = "CUPOM_DESCONTO", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_CUPOM_DESCONTO"))
	private CupomDesconto cupomDesconto;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(endereco endereco) {
		this.endereco = endereco;
	}

	public endereco getEnderecoCobranca() {
		return EnderecoCobranca;
	}

	public void setEnderecoCobranca(endereco enderecoCobranca) {
		EnderecoCobranca = enderecoCobranca;
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

	public FormaPagamento getFormaPagamento() {
		return FormaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		FormaPagamento = formaPagamento;
	}

	public NotaFiscalVenda getNotaFiscalVenda() {
		return notaFiscalVenda;
	}

	public void setNotaFiscalVenda(NotaFiscalVenda notaFiscalVenda) {
		this.notaFiscalVenda = notaFiscalVenda;
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
		VendaCompraLoja other = (VendaCompraLoja) obj;
		return Objects.equals(id, other.id);
	}
	
}