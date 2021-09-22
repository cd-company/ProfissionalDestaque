package com.cd.backend.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.cd.backend.dto.insert.VotacaoNewDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Votacao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "funcionario_abertura_id")
	private Funcionario funcionarioAbertura;
	private Integer anoMes;
	@OneToOne
	@JoinColumn(name="resultado_id")
	private Resultado resultado;
	@JsonFormat(pattern ="dd/MM/yyyy")
	private Date dataAbertura;
	@JsonFormat(pattern ="dd/MM/yyyy")
	private Date dataPrevistaEncerramento;
	@JsonFormat(pattern ="dd/MM/yyyy")
	private Date dataEncerramento;
	
	@Transient
	private List<Voto> votos = new ArrayList<Voto>();
	
	public Votacao() {
	}
	
	public Votacao(VotacaoNewDTO objNewDto) {
		this.anoMes = objNewDto.getAnoMes();
		this.dataAbertura = objNewDto.getDataPrevistaEncerramento();
	}

	public Votacao(Integer id, Funcionario funcionarioAbertura, Integer anoMes, Resultado resultado, Date dataAbertura,
			Date dataPrevistaEncerramento, Date dataEncerramento) {
		super();
		this.id = id;
		this.funcionarioAbertura = funcionarioAbertura;
		this.anoMes = anoMes;
		this.resultado = resultado;
		this.dataAbertura = dataAbertura;
		this.dataPrevistaEncerramento = dataPrevistaEncerramento;
		this.dataEncerramento = dataEncerramento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Funcionario getFuncionarioAbertura() {
		return funcionarioAbertura;
	}

	public void setFuncionarioAbertura(Funcionario funcionarioAbertura) {
		this.funcionarioAbertura = funcionarioAbertura;
	}

	public Integer getAnoMes() {
		return anoMes;
	}

	public void setAnoMes(Integer anoMes) {
		this.anoMes = anoMes;
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

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}

}
