package com.example.demo.model;

import java.io.Serializable;
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

@Entity
@Table(name = "STATUS_RASTREIO")
@SequenceGenerator(name = "SEQ_STATUS_RASTREIO", sequenceName = "SEQ_STATUS_RASTREIO", allocationSize = 1, initialValue = 1)
public class StatusRastreio implements Serializable{

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_STATUS_RASTREIO")
private Long id;

private String CentroDistribuicao;

private String Cidade;

private String Estado;

private String status;

@ManyToOne(targetEntity = VendaCompraLoja.class)
@JoinColumn(name = "VENDA_COMPRA_PRODUTO_ID", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_VENDA_COMPRA_PRODUTO_ID"))
private VendaCompraLoja vendaCompraProduto;

public Long getId() {
return id;
}

public void setId(Long id) {
this.id = id;
}

public String getCentroDistribuicao() {
return CentroDistribuicao;
}

public void setCentroDistribuicao(String centroDistribuicao) {
CentroDistribuicao = centroDistribuicao;
}

public String getCidade() {
return Cidade;
}

public void setCidade(String cidade) {
Cidade = cidade;
}

public String getEstado() {
return Estado;
}

public void setEstado(String estado) {
Estado = estado;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
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
StatusRastreio other = (StatusRastreio) obj;
return Objects.equals(id, other.id);
}}

