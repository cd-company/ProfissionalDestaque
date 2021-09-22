package com.cd.backend;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cd.backend.domain.Funcionario;
import com.cd.backend.domain.Resultado;
import com.cd.backend.domain.Votacao;
import com.cd.backend.domain.Voto;
import com.cd.backend.domain.enums.Indicador;
import com.cd.backend.domain.enums.TipoFuncionario;
import com.cd.backend.repositories.FuncionarioRepository;
import com.cd.backend.repositories.ResultadoRepository;
import com.cd.backend.repositories.VotacaoRepository;
import com.cd.backend.repositories.VotoRepository;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner{
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private VotacaoRepository votacaoRepository;
	
	@Autowired
	private VotoRepository votoRepository;
	
	@Autowired
	private ResultadoRepository resultadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);		
	}

	@Override
	public void run(String... args) throws Exception {
		
		Funcionario fun1 = new Funcionario(null, "Douglas de Souza Zapelini", "", "Programador", TipoFuncionario.PADRAO, Indicador.SIM, Indicador.SIM, Indicador.SIM, Indicador.SIM);
		Funcionario fun2 = new Funcionario(null, "Caio Henrrique May Mendes", "", "Programador Estagiário", TipoFuncionario.PADRAO, Indicador.SIM, Indicador.SIM, Indicador.SIM, Indicador.SIM);
		funcionarioRepository.saveAll(Arrays.asList(fun1,fun2));
		
		Votacao votacao1 =  new Votacao(null, fun1, 202109, null, new Date(), new Date(), null);
		votacaoRepository.saveAll(Arrays.asList(votacao1));
		
		Voto voto1 = new Voto(null, votacao1, fun1, fun2, new Date());
		Voto voto2 = new Voto(null, votacao1, fun2, fun2, new Date());
		votoRepository.saveAll(Arrays.asList(voto1,voto2));
		
		Resultado result1 = new Resultado(null, fun2, 202109, votacao1, Indicador.NAO);
		resultadoRepository.saveAll(Arrays.asList(result1));
		
		votacao1.setResultado(result1);
		votacaoRepository.save(votacao1);
	}
}
