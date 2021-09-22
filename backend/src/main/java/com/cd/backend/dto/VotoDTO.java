package com.cd.backend.dto;

import java.io.Serializable;
import java.util.Date;

import com.cd.backend.domain.Votacao;
import com.cd.backend.domain.Voto;
import com.fasterxml.jackson.annotation.JsonFormat;

public class VotoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private FuncionarioDTO eleitor;
	private FuncionarioDTO eleito;
	@JsonFormat(pattern ="dd/MM/yyyy")
	private Date dataVoto;
	
	public VotoDTO() {
	}
	
	public VotoDTO(Voto obj) {
		this.eleitor = new FuncionarioDTO(obj.getEleitor());
		this.eleito = new FuncionarioDTO(obj.getEleito());
		this.dataVoto = obj.getDataVoto();
	}

	public VotoDTO(Votacao votacao, FuncionarioDTO eleitor, FuncionarioDTO eleito, Date dataVoto) {
		super();
		this.eleitor = eleitor;
		this.eleito = eleito;
		this.dataVoto = dataVoto;
	}

	public FuncionarioDTO getEleitor() {
		return eleitor;
	}

	public void setEleitor(FuncionarioDTO eleitor) {
		this.eleitor = eleitor;
	}

	public FuncionarioDTO getEleito() {
		return eleito;
	}

	public void setEleito(FuncionarioDTO eleito) {
		this.eleito = eleito;
	}

	public Date getDataVoto() {
		return dataVoto;
	}

	public void setDataVoto(Date dataVoto) {
		this.dataVoto = dataVoto;
	}
}
