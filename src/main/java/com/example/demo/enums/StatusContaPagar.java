package com.example.demo.enums;

public enum StatusContaPagar {

        COBRANCA("Pagar"),
        VENCIDA("Vencida"),
        ABERTA("Aberta"),
        QUITADA("Quitada"),
        ALUGUEL("Aluguel"),
        FUNCIONARIO("Funcioinário"),
        NEGOCIADA("Renegociada");

        private String descricao;

        private StatusContaPagar(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao(String descricao) {
            return descricao;
        }

        @Override
    	public String toString() {
            return this.descricao;
        }

}