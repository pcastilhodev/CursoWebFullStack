package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table (name = "pessoa_fisica")
@PrimaryKeyJoinColumn(name = "id")
public class pessoafisica extends pessoa{

	private static final long serialVersionUID = 1L;
   
	@Column(nullable = false)
	private String cpf;
	
	@Temporal(TemporalType.DATE)
	private Date datanascimento;

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return null;
	}

	}
