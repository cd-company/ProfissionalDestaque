package com.cd.backend.domain.enums;

public enum TipoFuncionario {
	
	PADRAO(1, "Padrão"),
	ADMINISTRADOR(2, "Administrador");
	
	private int cod;
	private String descricao;
	
	private TipoFuncionario(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoFuncionario toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(TipoFuncionario x : TipoFuncionario.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: "+ cod);
	}
}
