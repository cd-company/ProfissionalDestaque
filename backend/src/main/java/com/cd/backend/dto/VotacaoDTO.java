package com.cd.backend.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cd.backend.domain.Resultado;
import com.cd.backend.domain.Votacao;
import com.cd.backend.domain.Voto;
import com.fasterxml.jackson.annotation.JsonFormat;

public class VotacaoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "funcionario_abertura_id")
	private FuncionarioDTO funcionarioAbertura;
	private Integer anoMes;
	private ResultadoDTO resultado;
	@JsonFormat(pattern ="dd/MM/yyyy")
	private Date dataAbertura;
	@JsonFormat(pattern ="dd/MM/yyyy")
	private Date dataPrevistaEncerramento;
	@JsonFormat(pattern ="dd/MM/yyyy")
	private Date dataEncerramento;

	private List<VotoDTO> votos = new ArrayList<VotoDTO>();
	
	public VotacaoDTO() {
	}
	
	public VotacaoDTO(Votacao obj) {
		this.funcionarioAbertura = new FuncionarioDTO(obj.getFuncionarioAbertura());
		this.anoMes = obj.getAnoMes();
		this.resultado = new ResultadoDTO(obj.getResultado());
		this.dataAbertura = obj.getDataAbertura();
		this.dataPrevistaEncerramento = obj.getDataPrevistaEncerramento();
		this.dataEncerramento = obj.getDataEncerramento();
		this.votos = convertVotosToDto(obj.getVotos());
	}

	public VotacaoDTO(FuncionarioDTO funcionarioAbertura, Integer anoMes, Resultado resultado, Date dataAbertura,
			Date dataPrevistaEncerramento, Date dataEncerramento) {
		super();
		this.funcionarioAbertura = funcionarioAbertura;
		this.anoMes = anoMes;
		this.resultado = new ResultadoDTO(resultado);
		this.dataAbertura = dataAbertura;
		this.dataPrevistaEncerramento = dataPrevistaEncerramento;
		this.dataEncerramento = dataEncerramento;
	}

	public FuncionarioDTO getFuncionarioAbertura() {
		return funcionarioAbertura;
	}

	public void setFuncionarioAbertura(FuncionarioDTO funcionarioAbertura) {
		this.funcionarioAbertura = funcionarioAbertura;
	}

	public Integer getAnoMes() {
		return anoMes;
	}

	public void setAnoMes(Integer anoMes) {
		this.anoMes = anoMes;
	}

	public ResultadoDTO getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataPrevistaEncerramento() {
		return dataPrevistaEncerramento;
	}

	public void setDataPrevistaEncerramento(Date dataPrevistaEncerramento) {
		this.dataPrevistaEncerramento = dataPrevistaEncerramento;
	}

	public Date getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(Date dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}

	public List<VotoDTO> getVotos() {
		return votos;
	}

	public void setVotos(List<VotoDTO> votos) {
		this.votos = votos;
	}
	
	public List<VotoDTO> convertVotosToDto(List<Voto> votos){
		List<VotoDTO> votosDto = new ArrayList<VotoDTO>();
		for(Voto voto : votos) {
			VotoDTO votoDto = new VotoDTO(voto);
			votosDto.add(votoDto);
		}
		return votosDto;
	}
}
