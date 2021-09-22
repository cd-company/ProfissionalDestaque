package com.cd.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cd.backend.domain.Voto;
import com.cd.backend.repositories.VotoRepository;
import com.cd.backend.services.exception.DataIntegrityException;
import com.cd.backend.services.exception.ObjectNotFoundException;

@Service
public class VotoService {

	@Autowired
	private VotoRepository repo;
	
	public Voto find(Integer id) {
		Optional<Voto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id:" + id + 
																	", Tipo: " + Voto.class.getName())); 
	}
	
	public List<Voto> findAll() {
		return repo.findAll(); 
	}
	
	public Voto insert(Voto obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Voto update(Voto obj) {
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		
		find(id);
		
		try {
			repo.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma votação já tenha resultado.");
		}
		
	}
	
	public Page<Voto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page,linesPerPage,Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}
