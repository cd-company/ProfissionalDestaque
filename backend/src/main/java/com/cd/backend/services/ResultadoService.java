package com.cd.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cd.backend.domain.Resultado;
import com.cd.backend.repositories.ResultadoRepository;
import com.cd.backend.services.exception.ObjectNotFoundException;

@Service
public class ResultadoService {
	
	@Autowired
	private ResultadoRepository repo;
	
	public Resultado find(Integer id) {
		Optional<Resultado> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id:" + id + 
																	", Tipo: " + Resultado.class.getName())); 
	}
	
	public List<Resultado> findAll() {
		return repo.findAll(); 
	}
	
	public Resultado insert(Resultado obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Resultado update(Resultado obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public Page<Resultado> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page,linesPerPage,Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

}
