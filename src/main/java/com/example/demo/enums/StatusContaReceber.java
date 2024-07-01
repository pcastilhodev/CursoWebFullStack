package com.example.demo.enums;

public enum StatusContaReceber {

    COBRANCA("Pagar"),
    VENCIDA("Vencida"),
    ABERTA("Aberta"),
    QUITADA("Quitada");

    private String descricao;

    private StatusContaReceber(String descricao) {
        this.descricao = descricao;
    }

    public String get (String descricao) {
        return descricao;
    }

    public String toStringr () {
        return this.descricao;
    }

}