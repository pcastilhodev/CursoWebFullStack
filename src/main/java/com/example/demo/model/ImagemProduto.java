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
@Table(name = "IMAGEM_PRODUTO")
@SequenceGenerator(name = "SEQ_IMAGEM_PRODUTO", sequenceName = "SEQ_IMAGEM_PRODUTO", allocationSize = 1, initialValue = 1)
public class ImagemProduto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_IMAGEM_PRODUTO")
	private Long id;
	
	
	@Column(columnDefinition = "text", nullable = false)
	private String ImagemOriginal;
	

	@Column(columnDefinition = "text", nullable = false)
	private String ImagemMiniatura;
	
	@ManyToOne
	@JoinColumn(name = "PRODUTO_ID", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_PRODUTO_ID"))
	private Produtos produtos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImagemOriginal() {
		return ImagemOriginal;
	}

	public void setImagemOriginal(String imagemOriginal) {
		ImagemOriginal = imagemOriginal;
	}

	public String getImagemMiniatura() {
		return ImagemMiniatura;
	}

	public void setImagemMiniatura(String imagemMiniatura) {
		ImagemMiniatura = imagemMiniatura;
	}

	public Produtos getProdutos() {
		return produtos;
	}

	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
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
		ImagemProduto other = (ImagemProduto) obj;
		return Objects.equals(id, other.id);
	}
	
}
