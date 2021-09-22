package com.cd.backend.dto;

import java.io.Serializable;

import com.cd.backend.domain.Resultado;
import com.cd.backend.domain.Votacao;
import com.cd.backend.domain.enums.Indicador;

public class ResultadoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private FuncionarioDTO funcionarioGanhador;
	private Integer anoMes;
	private Integer funcionarioDoAno;
	
	public ResultadoDTO() {
	}
	
	public ResultadoDTO(Resultado obj) {
		this.funcionarioGanhador = new FuncionarioDTO(obj.getFuncionarioGanhador());
		this.anoMes = obj.getAnoMes();
		this.funcionarioDoAno = obj.getFuncionarioDoAno().getCod();
	}

	public ResultadoDTO(FuncionarioDTO funcionarioGanhador, Integer anoMes, Votacao votacao, Indicador funcionarioDoAno) {
		super();
		this.funcionarioGanhador = funcionarioGanhador;
		this.anoMes = anoMes;
		this.funcionarioDoAno = funcionarioDoAno.getCod();
	}

	public FuncionarioDTO getFuncionarioGanhador() {
		return funcionarioGanhador;
	}

	public void setFuncionarioGanhador(FuncionarioDTO funcionarioGanhador) {
		this.funcionarioGanhador = funcionarioGanhador;
	}

	public Integer getAnoMes() {
		return anoMes;
	}

	public void setAnoMes(Integer anoMes) {
		this.anoMes = anoMes;
	}

	public Indicador getFuncionarioDoAno() {
		return Indicador.toEnum(funcionarioDoAno);
	}

	public void setFuncionarioDoAno(Indicador funcionarioDoAno) {
		this.funcionarioDoAno = funcionarioDoAno.getCod();
	}
}
