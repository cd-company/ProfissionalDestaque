package com.cd.backend.dto.insert;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.cd.backend.domain.enums.Indicador;
import com.cd.backend.domain.enums.TipoFuncionario;

public class FuncionarioNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotEmpty(message="Preenchimento do campo nome obrigatório!")
	@Length(min=5, max=120, message="O tamanho do nome deve ser entre 5 e 120 caracteres.")
	private String nome;
	private String senha;
	private String cargo;
	@NotNull(message="Preenchimento do campo Tipo de Funcionário obrigatório!")
	private Integer tipoFuncionario;
	@NotNull(message="Preenchimento do campo Indicador Ativo obrigatório!")
	private Integer icAtivo;
	@NotNull(message="Preenchimento do campo Indicador Elegível obrigatório!")
	private Integer icElegivel;
	@NotNull(message="Preenchimento do campo Indicador Eleição obrigatório!")
	private Integer icEleicao;
	
	public FuncionarioNewDTO() {
	}

	public FuncionarioNewDTO(String nome, String senha, String cargo, TipoFuncionario tipoFuncionario, Indicador icAtivo,
			Indicador icElegivel, Indicador icEleicao) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.cargo = cargo;
		this.tipoFuncionario = tipoFuncionario.getCod();
		this.icAtivo = icAtivo.getCod();
		this.icElegivel = icElegivel.getCod();
		this.icEleicao = icEleicao.getCod();
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
}
