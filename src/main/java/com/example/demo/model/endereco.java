package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;

import com.example.demo.enums.TipoEndereco;

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
@Table (name = "endereco")
@SequenceGenerator(name = "seq_enderco", sequenceName = "seq_endereco", allocationSize = 1, initialValue = 1)
public class endereco implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_endereco")
	@Column(nullable = false)
	private long id;
	
	@Column(nullable = false)
	private String rualogra;
	@Column(nullable = false)
	
	private String uf;
	
	@Column(nullable = false)
	private String bairro;
	
	@Column(nullable = false)
	private String numero;
	
	
	
	private String complemento;
	
	@Column(nullable = false)
	private String cep;
	
	@Column(nullable = false)
	private String cidade;
    
	@Column(nullable = false)
	private TipoEndereco tipoendereco;
	
	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, cidade, complemento, id, numero, pessoa, rualogra, tipoendereco, uf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		endereco other = (endereco) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(complemento, other.complemento)
				&& id == other.id && Objects.equals(numero, other.numero) && Objects.equals(pessoa, other.pessoa)
				&& Objects.equals(rualogra, other.rualogra) && tipoendereco == other.tipoendereco
				&& Objects.equals(uf, other.uf);
	}

	@ManyToOne(targetEntity = com.example.demo.model.pessoa.class)
	@JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
	private pessoa pessoa;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRualogra() {
		return rualogra;
	}

	public void setRualogra(String rualogra) {
		this.rualogra = rualogra;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public TipoEndereco getTipoendereco() {
		return tipoendereco;
	}

	public void setTipoendereco(TipoEndereco tipoendereco) {
		this.tipoendereco = tipoendereco;
	}

}
