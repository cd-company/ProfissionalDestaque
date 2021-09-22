package com.cd.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cd.backend.domain.Funcionario;
import com.cd.backend.repositories.FuncionarioRepository;
import com.cd.backend.services.exception.DataIntegrityException;
import com.cd.backend.services.exception.ObjectNotFoundException;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository repo;
	
	
	public Funcionario find(Integer id) {
		Optional<Funcionario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id:" + id + 
																	", Tipo: " + Funcionario.class.getName())); 
	}
	
	public List<Funcionario> findAll() {
		return repo.findAll(); 
	}
	
	public Funcionario insert(Funcionario obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Funcionario update(Funcionario obj) {
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		
		find(id);
		
		try {
			repo.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um funcionário que participou de alguma votação.");
		}
		
	}
	
	public Page<Funcionario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page,linesPerPage,Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}	
}
