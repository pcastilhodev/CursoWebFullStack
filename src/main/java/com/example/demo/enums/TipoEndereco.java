package com.example.demo.enums;

public enum TipoEndereco {
	
	COBRANCA("cobranca"),
	ENTREGA("entrega");

	private String descricao;
	
	private TipoEndereco(String descricao) {
		this.descricao = descricao;
	}
	


    @Override
    public String toString() {
    	return super.toString();
    }



	public String getDescricao() {
		return descricao;
	}
    
}
