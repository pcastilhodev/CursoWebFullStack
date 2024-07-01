package com.example.demo.model;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.example.demo.enums.StatusContaReceber;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "CONTAS_RECEBER")
@SequenceGenerator(name = "SEQ_CONTAS_RECEBER", sequenceName = "SEQ_CONTAS_RECEBER", allocationSize = 1, initialValue = 1)
public class ContaReceber implements Serializable {

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CONTAS_RECEBER")
private Long id;

@Column(nullable = false)
private  String descricao;

@Column(nullable = false)
@Enumerated(EnumType.STRING)
private StatusContaReceber status;

@Column(nullable = false)
@Temporal(TemporalType.DATE)
private Date dtVencimento;

@Temporal(TemporalType.DATE)
private Date dtPagamento;

@Column(nullable = false)
private BigDecimal ValorTotal;

private BigDecimal ValorDesconto;

@ManyToOne(targetEntity = pessoa.class)
@JoinColumn(name = "PESSOA_ID", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_PESSOAS_ID"))
private pessoa pessoa;

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

}