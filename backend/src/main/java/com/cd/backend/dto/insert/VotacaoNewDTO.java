package com.cd.backend.dto.insert;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

public class VotacaoNewDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@NotNull(message="Campo Id Funcionário é obrigatório!")
	private Integer funcionarioAbertura;
	@NotNull(message=" Campo Ano/Mês é obrigatório!")
	private Integer anoMes;
	@NotNull(message="Campo Data Prevista é obrigatório!")
	private Date dataPrevistaEncerramento;
	
	public VotacaoNewDTO() {
	}

	public VotacaoNewDTO(@NotNull(message = "Campo Id Funcionário é obrigatório!") Integer funcionarioAbertura,
			@NotNull(message = " Campo Ano/Mês é obrigatório!") Integer anoMes,
			@NotNull(message = "Campo Data Prevista é obrigatório!") Date dataPrevistaEncerramento) {
		super();
		this.funcionarioAbertura = funcionarioAbertura;
		this.anoMes = anoMes;
		this.dataPrevistaEncerramento = dataPrevistaEncerramento;
	}

	public Integer getFuncionarioAbertura() {
		return funcionarioAbertura;
	}

	public void setFuncionarioAbertura(Integer funcionarioAbertura) {
		this.funcionarioAbertura = funcionarioAbertura;
	}

	public Integer getAnoMes() {
		return anoMes;
	}

	public void setAnoMes(Integer anoMes) {
		this.anoMes = anoMes;
	}

	public Date getDataPrevistaEncerramento() {
		return dataPrevistaEncerramento;
	}

	public void setDataPrevistaEncerramento(Date dataPrevistaEncerramento) {
		this.dataPrevistaEncerramento = dataPrevistaEncerramento;
	}
}
