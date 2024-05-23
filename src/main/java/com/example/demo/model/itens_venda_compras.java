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
@Table(name = "ITEM_VENDA")
@SequenceGenerator(name = "SEQ_ITEM_VENDA", sequenceName = "SEQ_ITEM_VENDA", allocationSize = 1, initialValue = 1)
public class itens_venda_compras implements Serializable{

private static final long serialVersionUID = 4499231176004999390L;

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ITEM_VENDA")
private Long id;

@Column(nullable = false)
private Double quantidade;

@ManyToOne(targetEntity = VendaCompraLoja.class)
@JoinColumn(name = "VENDA_ID", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_PRODUTO_ID"))
private Produtos Produtos;

@ManyToOne(targetEntity = VendaCompraLoja.class)
@JoinColumn(name = "VENDA_COMPRA_PRODUTO_ID", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_VENDA_COMPRA_PRODUTO_ID"))
private VendaCompraLoja vendaCompraProduto;

public Long getId() {
return id;
}

public void setId(Long id) {
this.id = id;
}

public Double getQuantidade() {
return quantidade;
}

public void setQuantidade(Double quantidade) {
this.quantidade = quantidade;
}

public Produtos getProdutos() {
return Produtos;
}

public void setProdutos(Produtos produtos) {
Produtos = produtos;
}

public VendaCompraLoja getVendaCompraProduto() {
return vendaCompraProduto;
}

public void setVendaCompraProduto(VendaCompraLoja vendaCompraProduto) {
this.vendaCompraProduto = vendaCompraProduto;
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
itens_venda_compras other = (itens_venda_compras) obj;
return Objects.equals(id, other.id);
}

}
