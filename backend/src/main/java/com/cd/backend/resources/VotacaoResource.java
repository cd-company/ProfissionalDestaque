package com.cd.backend.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
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

import com.cd.backend.domain.Votacao;
import com.cd.backend.dto.VotacaoDTO;
import com.cd.backend.dto.insert.VotacaoNewDTO;
import com.cd.backend.services.FuncionarioService;
import com.cd.backend.services.VotacaoService;

@RestController
@RequestMapping(value="/votacoes")
public class VotacaoResource {

	private VotacaoService service;
	private FuncionarioService funcionarioService;
	
	@Autowired
	public VotacaoResource(VotacaoService service,FuncionarioService funcionarioService) {
		this.service = service;
		this.funcionarioService = funcionarioService;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<VotacaoDTO> find(@PathVariable Integer id) {
		Votacao obj = service.find(id);
		obj.setVotos(service.getVotosPorVotacao(obj));
		VotacaoDTO objDto = new VotacaoDTO(obj);
		return ResponseEntity.ok().body(objDto);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<VotacaoDTO>> findAll() {
		List<Votacao> list = service.findAll();
		List<VotacaoDTO> listDto = new ArrayList<VotacaoDTO>();
		if(list != null && !list.isEmpty()) {
			for(Votacao votacao : list) {
				votacao.setVotos(service.getVotosPorVotacao(votacao));
				VotacaoDTO votacaoDto = new VotacaoDTO(votacao);
				listDto.add(votacaoDto);
			}
		}
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody VotacaoNewDTO objNewDto){
		Votacao votacao = new Votacao(objNewDto);
		votacao.setFuncionarioAbertura(funcionarioService.find(objNewDto.getFuncionarioAbertura()));
		votacao.setDataAbertura(new Date());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(votacao.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody Votacao obj){
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Votacao>> findPage(
			@RequestParam(value="page", defaultValue = "0")Integer page, 
			@RequestParam(value="linesPerPage", defaultValue = "24")Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue = "nome")String orderBy, 
			@RequestParam(value="direction", defaultValue = "ASC")String direction) {
		Page<Votacao> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
}
