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
@Table(name = "PRODUTO")
@SequenceGenerator(name = "SEQ_PRODUTO", sequenceName = "SEQ_PRODUTO", allocationSize = 1, initialValue = 1)
public class Produtos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRODUTO")
	@Column (nullable = false)
	private Long id;
	@Column (nullable = false)
	private String TipoUnidade;
	@Column (nullable = false)
	private String nome;
	@Column (nullable = false)
	private Boolean ativo = Boolean.TRUE;
	
	@Column(columnDefinition = "text", length = 2000)
	private String descricao;

	
	@Column (nullable = false)
	private Double peso;
	@Column (nullable = false)
	private Double largura;
	@Column (nullable = false)
	private Double altura;
	@Column (nullable = false)
	private Double profundidade;
	@Column (nullable = false)
	private BigDecimal ValorVenda = BigDecimal.ZERO;
	@Column (nullable = false)
	private Integer QuantidadeEstoque = 0;
	@Column (nullable = false)
	private Integer QuantidadeAlertaEstoque = 0;
	
	private String LinkYoutube;
	
	private Boolean AlertaQuantidadeEstoque = Boolean.FALSE;
	
	private Integer QuantidadeClick = 0;
	
	
	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getLargura() {
		return largura;
	}

	public void setLargura(Double largura) {
		this.largura = largura;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(Double profundidade) {
		this.profundidade = profundidade;
	}

	public BigDecimal getValorVenda() {
		return ValorVenda;
	}

	public void setValorVenda(BigDecimal valorVenda) {
		ValorVenda = valorVenda;
	}

	public Integer getQuantidadeEstoque() {
		return QuantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		QuantidadeEstoque = quantidadeEstoque;
	}

	public Integer getQuantidadeAlertaEstoque() {
		return QuantidadeAlertaEstoque;
	}

	public void setQuantidadeAlertaEstoque(Integer quantidadeAlertaEstoque) {
		QuantidadeAlertaEstoque = quantidadeAlertaEstoque;
	}

	public String getLinkYoutube() {
		return LinkYoutube;
	}

	public void setLinkYoutube(String linkYoutube) {
		LinkYoutube = linkYoutube;
	}

	public Boolean getAlertaQuantidadeEstoque() {
		return AlertaQuantidadeEstoque;
	}

	public void setAlertaQuantidadeEstoque(Boolean alertaQuantidadeEstoque) {
		AlertaQuantidadeEstoque = alertaQuantidadeEstoque;
	}

	public Integer getQuantidadeClick() {
		return QuantidadeClick;
	}

	public void setQuantidadeClick(Integer quantidadeClick) {
		QuantidadeClick = quantidadeClick;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoUnidade() {
		return TipoUnidade;
	}

	public void setTipoUnidade(String tipoUnidade) {
		TipoUnidade = tipoUnidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		Produtos other = (Produtos) obj;
		return Objects.equals(id, other.id);
	}

}
