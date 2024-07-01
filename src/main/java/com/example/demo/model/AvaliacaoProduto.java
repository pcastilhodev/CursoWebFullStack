package com.example.demo.model;

import java.io.Serializable;
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
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "AVALIACAO_PRODUTO")
@SequenceGenerator(name = "SEQ_AVALIACAO_PRODUTO", sequenceName = "SEQ_AVALIACAO_PRODUTO", allocationSize = 1, initialValue = 1)
public class AvaliacaoProduto implements Serializable {

	private static final long serialVersionUID = 1110042163054278971L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_AVALIACAO_PRODUTO")
	private long id;
	
	@Column(nullable = false)
	private Integer nota;
	@Column(nullable = false)
	private String descricao;
	
	@ManyToOne(targetEntity = pessoa.class)
	@JoinColumn(name = "PESSOA_ID", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_PESSOA_ID"))
	private pessoa pessoa;
	
	@ManyToOne(targetEntity = VendaCompraLoja.class)
	@JoinColumn(name = "PRODUTO_ID", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_PRODUTO_ID"))
	private Produtos Produtos;

	public long getId() {
		return id;
	}
 
	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Produtos getProdutos() {
		return Produtos;
	}

	public void setProdutos(Produtos produtos) {
		Produtos = produtos;
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
		AvaliacaoProduto other = (AvaliacaoProduto) obj;
		return Objects.equals(id, other.id);
	}
	
}