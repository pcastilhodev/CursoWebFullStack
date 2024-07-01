package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table (name = "PESSOA_JURIDICA")
@PrimaryKeyJoinColumn(name = "id")
public class pessoajuridica extends pessoa{

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String CNPJ;
    @Column(nullable = false)
    private String Inscest;
  
    private String InscMun;
    @Column(nullable = false)
    private String NomeFantasia;
    @Column(nullable = false)
    private String RazaoSocial;
    @Column(nullable = false)
    private String Categoria;


    public String getCNPJ() {
        return CNPJ;
    }


    public void setCNPJ(String cNPJ) {
        CNPJ = cNPJ;
    }


    public String getInscEst() {
        return Inscest;
    }


    public void setInscEst(String inscest) {
        Inscest = inscest;
    }


    public String getInscMun() {
        return InscMun;
    }


    public void setInscMun(String inscMun) {
        InscMun = inscMun;
    }


    public String getNomeFantasia() {
        return NomeFantasia;
    }


    public void setNomeFantasia(String nomeFantasia) {
        NomeFantasia = nomeFantasia;
    }


    public String getRazaoSocial() {
        return RazaoSocial;
    }


    public void setRazaoSocial(String razaoSocial) {
        RazaoSocial = razaoSocial;
    }


    public String getCategoria() {
        return Categoria;
    }


    public void setCategoria(String categoria) {
        Categoria = categoria;
    }


    public String getCPF() {
        return CNPJ;
    }


    public String getAuthority() {
        // TODO Auto-generated method stub
        return null;
    }
}