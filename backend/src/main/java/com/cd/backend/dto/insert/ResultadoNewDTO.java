package com.cd.backend.dto.insert;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.cd.backend.domain.enums.Indicador;

public class ResultadoNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotNull(message="Campo Id Funcionário Ganhador é obrigatório!")
	private Integer funcionarioGanhador;
	@NotNull(message="Campo Ano/Mês é obrigatório!")
	private Integer anoMes;
	@NotNull(message="Campo Id Votação é obrigatório!")
	private Integer votacaoId;
	@NotNull(message="Campo Indicador Funcionário Ano é obrigatório!")
	private Integer funcionarioDoAno;
	
	public ResultadoNewDTO() {
	}

	public ResultadoNewDTO(Integer funcionarioGanhador, Integer anoMes, Integer votacaoId, Indicador funcionarioDoAno) {
		super();
		this.funcionarioGanhador = funcionarioGanhador;
		this.anoMes = anoMes;
		this.votacaoId = votacaoId;
		this.funcionarioDoAno = funcionarioDoAno.getCod();
	}

	public Integer getFuncionarioGanhador() {
		return funcionarioGanhador;
	}

	public void setFuncionarioGanhador(Integer funcionarioGanhador) {
		this.funcionarioGanhador = funcionarioGanhador;
	}

	public Integer getAnoMes() {
		return anoMes;
	}

	public void setAnoMes(Integer anoMes) {
		this.anoMes = anoMes;
	}

	public Integer getVotacao() {
		return votacaoId;
	}

	public void setVotacao(Integer votacaoId) {
		this.votacaoId = votacaoId;
	}

	public Indicador getFuncionarioDoAno() {
		return Indicador.toEnum(funcionarioDoAno);
	}

	public void setFuncionarioDoAno(Indicador funcionarioDoAno) {
		this.funcionarioDoAno = funcionarioDoAno.getCod();
	}
}
