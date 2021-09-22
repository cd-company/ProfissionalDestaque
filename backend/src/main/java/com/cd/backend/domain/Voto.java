package com.cd.backend.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cd.backend.dto.VotoDTO;
import com.cd.backend.dto.insert.VotoNewDTO;

@Entity
public class Voto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "votacao_id")
	private Votacao votacao;
	@ManyToOne
	@JoinColumn(name = "funcionario_eleitor_id")
	private Funcionario eleitor;
	@ManyToOne
	@JoinColumn(name = "funcionario_eleito_id")
	private Funcionario eleito;
	private Date dataVoto;
	
	public Voto() {
	}
	
	public Voto(VotoDTO objDto) {
		this.eleitor = new Funcionario(objDto.getEleitor());
		this.eleito = new Funcionario(objDto.getEleito());
		this.dataVoto = objDto.getDataVoto();
	}
	
	public Voto(VotoNewDTO objNewDto) {
		this.dataVoto = objNewDto.getDataVoto();
	}

	public Voto(Integer id, Votacao votacao, Funcionario eleitor, Funcionario eleito, Date dataVoto) {
		super();
		this.id = id;
		this.votacao = votacao;
		this.eleitor = eleitor;
		this.eleito = eleito;
		this.dataVoto = dataVoto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Votacao getVotacao() {
		return votacao;
	}

	public void setVotacao(Votacao votacao) {
		this.votacao = votacao;
	}

	public Funcionario getEleitor() {
		return eleitor;
	}

	public void setEleitor(Funcionario eleitor) {
		this.eleitor = eleitor;
	}

	public Funcionario getEleito() {
		return eleito;
	}

	public void setEleito(Funcionario eleito) {
		this.eleito = eleito;
	}

	public Date getDataVoto() {
		return dataVoto;
	}

	public void setDataVoto(Date dataVoto) {
		this.dataVoto = dataVoto;
	}
}
