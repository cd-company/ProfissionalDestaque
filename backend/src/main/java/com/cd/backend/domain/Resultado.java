package com.cd.backend.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.cd.backend.domain.enums.Indicador;
import com.cd.backend.dto.insert.ResultadoNewDTO;

@Entity
public class Resultado implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "funcionario_ganhador_id")
	private Funcionario funcionarioGanhador;
	private Integer anoMes;
	@OneToOne(mappedBy = "resultado")
	private Votacao votacao;
	private Integer funcionarioDoAno;
	
	public Resultado() {
	}
	
	public Resultado (ResultadoNewDTO objNewDto) {
		this.anoMes = objNewDto.getAnoMes();
		this.funcionarioDoAno = objNewDto.getFuncionarioDoAno().getCod();
	}

	public Resultado(Integer id, Funcionario funcionarioGanhador, Integer anoMes, Votacao votacao,
			Indicador funcionarioDoAno) {
		super();
		this.id = id;
		this.funcionarioGanhador = funcionarioGanhador;
		this.anoMes = anoMes;
		this.votacao = votacao;
		this.funcionarioDoAno = funcionarioDoAno.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Funcionario getFuncionarioGanhador() {
		return funcionarioGanhador;
	}

	public void setFuncionarioGanhador(Funcionario funcionarioGanhador) {
		this.funcionarioGanhador = funcionarioGanhador;
	}

	public Integer getAnoMes() {
		return anoMes;
	}

	public void setAnoMes(Integer anoMes) {
		this.anoMes = anoMes;
	}

	public Votacao getVotacao() {
		return votacao;
	}

	public void setVotacao(Votacao votacao) {
		this.votacao = votacao;
	}

	public Indicador getFuncionarioDoAno() {
		return Indicador.toEnum(funcionarioDoAno);
	}

	public void setFuncionarioDoAno(Indicador funcionarioDoAno) {
		this.funcionarioDoAno = funcionarioDoAno.getCod();
	}
}
