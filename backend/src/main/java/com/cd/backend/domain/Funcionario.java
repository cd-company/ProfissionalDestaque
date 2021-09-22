package com.cd.backend.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.cd.backend.domain.enums.Indicador;
import com.cd.backend.domain.enums.TipoFuncionario;
import com.cd.backend.dto.FuncionarioDTO;
import com.cd.backend.dto.insert.FuncionarioNewDTO;

@Entity
public class Funcionario implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer id;
	private String nome;
	private String senha;
	private String cargo;
	private Integer tipoFuncionario;
	private Integer icAtivo;
	private Integer icElegivel;
	private Integer icEleicao;
	private Integer icPrimeiroAcesso;
	
	public Funcionario() {
	}
	
	public Funcionario(FuncionarioDTO objDto) {
		this.id = objDto.getId();
		this.nome = objDto.getNome();
		this.cargo = objDto.getCargo();
		this.tipoFuncionario = objDto.getTipoFuncionario().getCod();
		this.icAtivo = objDto.getIcAtivo().getCod();
		
	}
	
	public Funcionario(FuncionarioNewDTO objNewDto) {
		this.nome = objNewDto.getNome();
		this.cargo = objNewDto.getCargo();
		this.tipoFuncionario = objNewDto.getTipoFuncionario().getCod();
		this.icAtivo = objNewDto.getIcAtivo().getCod();
		this.icElegivel = objNewDto.getIcElegivel().getCod();
		this.icEleicao = objNewDto.getIcEleicao().getCod();
		this.icPrimeiroAcesso = Indicador.SIM.getCod();
	}

	public Funcionario(Integer id, String nome, String senha, String cargo, TipoFuncionario tipoFuncionario,
			Indicador icAtivo, Indicador icElegivel, Indicador icEleicao, Indicador icPrimeiroAcesso) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.cargo = cargo;
		this.tipoFuncionario = tipoFuncionario.getCod();
		this.icAtivo = icAtivo.getCod();
		this.icElegivel = icElegivel.getCod();
		this.icEleicao = icEleicao.getCod();
		this.icPrimeiroAcesso = icPrimeiroAcesso.getCod();
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public Indicador getIcElegivel() {
		return Indicador.toEnum(icElegivel);
	}

	public void setIcElegivel(Indicador icElegivel) {
		this.icElegivel = icElegivel.getCod();
	}

	public Indicador getIcEleicao() {
		return Indicador.toEnum(icEleicao);
	}

	public void setIcEleicao(Indicador icEleicao) {
		this.icEleicao = icEleicao.getCod();
	}

	public Indicador getIcPrimeiroAcesso() {
		return Indicador.toEnum(icPrimeiroAcesso);
	}

	public void setIcPrimeiroAcesso(Indicador icPrimeiroAcesso) {
		this.icPrimeiroAcesso = icPrimeiroAcesso.getCod();
	}
	
}
