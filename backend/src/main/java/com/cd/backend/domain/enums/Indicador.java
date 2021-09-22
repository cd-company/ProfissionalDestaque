package com.cd.backend.domain.enums;

public enum Indicador {
	SIM(1, "Sim"),
	NAO(2, "Não");
	
	private int cod;
	private String descricao;
	
	private Indicador(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Indicador toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(Indicador x : Indicador.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: "+ cod);
	}
}
