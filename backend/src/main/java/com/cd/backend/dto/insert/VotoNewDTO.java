package com.cd.backend.dto.insert;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

public class VotoNewDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@NotNull(message="Campo Id Votação é obrigatório!")
	private Integer votacaoId;
	@NotNull(message="Campo Id Funcionário Eleitor é obrigatório!")
	private Integer eleitorId;
	@NotNull(message="Campo Id Funcionário Eleito é obrigatório!")
	private Integer eleitoId;
	@NotNull(message="Campo Data do voto é obrigatório!")
	private Date dataVoto;
	
	public VotoNewDTO() {
	}

	public VotoNewDTO(Integer votacaoId, Integer eleitorId, Integer eleitoId, Date dataVoto) {
		super();
		this.votacaoId = votacaoId;
		this.eleitorId = eleitorId;
		this.eleitoId = eleitoId;
		this.dataVoto = dataVoto;
	}

	public Integer getVotacaoId() {
		return votacaoId;
	}

	public void setVotacaoId(Integer votacaoId) {
		this.votacaoId = votacaoId;
	}

	public Integer getEleitorId() {
		return eleitorId;
	}

	public void setEleitorId(Integer eleitorId) {
		this.eleitorId = eleitorId;
	}

	public Integer getEleitoId() {
		return eleitoId;
	}

	public void setEleitoId(Integer eleitoId) {
		this.eleitoId = eleitoId;
	}

	public Date getDataVoto() {
		return dataVoto;
	}

	public void setDataVoto(Date dataVoto) {
		this.dataVoto = dataVoto;
	}
}
