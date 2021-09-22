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

import com.cd.backend.domain.Voto;
import com.cd.backend.dto.VotoDTO;
import com.cd.backend.dto.insert.VotoNewDTO;
import com.cd.backend.services.FuncionarioService;
import com.cd.backend.services.VotacaoService;
import com.cd.backend.services.VotoService;

@RestController
@RequestMapping(value="/votos")
public class VotoResource {

	private final VotoService service;
	private final FuncionarioService funcionarioService;
	private final VotacaoService votacaoService;
	
	@Autowired
	public VotoResource(VotoService service, FuncionarioService funcionarioService, VotacaoService votacaoService) {
		this.service = service;
		this.funcionarioService = funcionarioService;
		this.votacaoService = votacaoService;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<VotoDTO> find(@PathVariable Integer id) {
		Voto obj = service.find(id);
		VotoDTO objDto = new VotoDTO(obj);
		return ResponseEntity.ok().body(objDto);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<VotoDTO>> findAll() {
		List<Voto> list = service.findAll();
		List<VotoDTO> listDto = new ArrayList<VotoDTO>();
		if(list != null && !list.isEmpty()) {
			for(Voto voto : list) {
				VotoDTO votoDto = new VotoDTO(voto);
				listDto.add(votoDto);
			}
		}
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody VotoNewDTO objNewDto){
		Voto obj = new Voto(objNewDto);
		obj.setEleitor(funcionarioService.find(objNewDto.getEleitorId()));
		obj.setEleito(funcionarioService.find(objNewDto.getEleitoId()));
		obj.setVotacao(votacaoService.find(objNewDto.getVotacaoId()));
		service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody Voto obj){
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Voto>> findPage(
			@RequestParam(value="page", defaultValue = "0")Integer page, 
			@RequestParam(value="linesPerPage", defaultValue = "24")Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue = "nome")String orderBy, 
			@RequestParam(value="direction", defaultValue = "ASC")String direction) {
		Page<Voto> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
}
