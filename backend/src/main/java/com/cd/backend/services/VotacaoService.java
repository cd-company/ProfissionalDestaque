package com.cd.backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cd.backend.domain.Votacao;
import com.cd.backend.domain.Voto;
import com.cd.backend.dto.VotoDTO;
import com.cd.backend.repositories.VotacaoRepository;
import com.cd.backend.repositories.VotoRepository;
import com.cd.backend.services.exception.DataIntegrityException;
import com.cd.backend.services.exception.ObjectNotFoundException;

@Service
public class VotacaoService {

	@Autowired
	private VotacaoRepository repo;
	
	@Autowired
	private VotoRepository votoRepository;
	
	public Votacao find(Integer id) {
		Optional<Votacao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id:" + id + 
																	", Tipo: " + Votacao.class.getName())); 
	}
	
	public List<Votacao> findAll() {
		return repo.findAll(); 
	}
	
	public Votacao insert(Votacao obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Votacao update(Votacao obj) {
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
	
	public List<Voto> getVotosPorVotacao(Votacao votacao){
		List<VotoDTO> votosDto = votoRepository.findByVotacao(votacao);
		return fromDto(votosDto);
	}
	
	public Page<Votacao> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page,linesPerPage,Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public List<Voto> fromDto(List<VotoDTO> listDto){
		List<Voto> list = new ArrayList<Voto>();
		for(VotoDTO objDto : listDto) {
			list.add(new Voto(objDto));
		}
		return list;
	}
}
