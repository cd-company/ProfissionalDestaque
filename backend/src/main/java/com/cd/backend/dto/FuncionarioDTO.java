package com.cd.backend.dto;

import java.io.Serializable;

import com.cd.backend.domain.Funcionario;
import com.cd.backend.domain.enums.Indicador;
import com.cd.backend.domain.enums.TipoFuncionario;

public class FuncionarioDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String cargo;
	private Integer tipoFuncionario;
	private Integer icAtivo;
	
	public FuncionarioDTO(){
	}
	
	public FuncionarioDTO(Funcionario obj){
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cargo = obj.getCargo();
		this.tipoFuncionario = obj.getTipoFuncionario().getCod();
		this.icAtivo = obj.getIcAtivo().getCod();
	}

	public FuncionarioDTO(Integer id, String nome, String cargo, TipoFuncionario tipoFuncionario, Indicador icAtivo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargo = cargo;
		this.tipoFuncionario = tipoFuncionario.getCod();
		this.icAtivo = icAtivo.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public TipoFuncionario getTipoFuncionario() {
		return TipoFuncionario.toEnum(tipoFuncionario);
	}

	public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario.getCod();
	}

	public Indicador getIcAtivo() {
		return Indicador.toEnum(icAtivo);
	}

	public void setIcAtivo(Indicador icAtivo) {
		this.icAtivo = icAtivo.getCod();
	}
}
