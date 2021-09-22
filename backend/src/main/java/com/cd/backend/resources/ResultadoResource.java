package com.cd.backend.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cd.backend.domain.Funcionario;
import com.cd.backend.domain.Resultado;
import com.cd.backend.domain.Votacao;
import com.cd.backend.dto.ResultadoDTO;
import com.cd.backend.dto.insert.ResultadoNewDTO;
import com.cd.backend.services.FuncionarioService;
import com.cd.backend.services.ResultadoService;
import com.cd.backend.services.VotacaoService;
import com.cd.backend.services.exception.ObjectNotFoundException;

@RestController
@RequestMapping(value="/resultados")
public class ResultadoResource {
	
	private final ResultadoService service;
	private final FuncionarioService funcionarioService;
	private final VotacaoService votacaoService;
	
	@Autowired
	public ResultadoResource(ResultadoService service, FuncionarioService funcionarioService, VotacaoService votacaoService) {
		this.service = service;
		this.funcionarioService = funcionarioService;
		this.votacaoService = votacaoService;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<ResultadoDTO> find(@PathVariable Integer id) {
		Resultado obj = service.find(id);
		ResultadoDTO objDto = new ResultadoDTO(obj);
		return ResponseEntity.ok().body(objDto);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ResultadoDTO>> findAll() {
		List<Resultado> list = service.findAll();
		List<ResultadoDTO> listDto = new ArrayList<>();
		if(list != null && !list.isEmpty()){
			for(Resultado obj : list) {
				ResultadoDTO objDto = new ResultadoDTO(obj);
				listDto.add(objDto);
			}
		}else {
			new ObjectNotFoundException("Nenhum resultado foi encontrado!"); 
		}
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ResultadoNewDTO objNewDto){
		Funcionario fun = funcionarioService.find(objNewDto.getFuncionarioGanhador());
		Votacao vot = votacaoService.find(objNewDto.getVotacao());
		Resultado obj = new Resultado(objNewDto);
		obj.setFuncionarioGanhador(fun);
		obj.setVotacao(vot);
		obj = service.insert(obj);		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Resultado obj){
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Resultado>> findPage(
			@RequestParam(value="page", defaultValue = "0")Integer page, 
			@RequestParam(value="linesPerPage", defaultValue = "24")Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue = "nome")String orderBy, 
			@RequestParam(value="direction", defaultValue = "ASC")String direction) {
		Page<Resultado> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
}
