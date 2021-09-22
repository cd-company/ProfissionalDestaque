package com.cd.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cd.backend.domain.Votacao;
import com.cd.backend.domain.Voto;
import com.cd.backend.dto.VotoDTO;

public interface VotoRepository extends JpaRepository<Voto,Integer>{
	
	@Transactional(readOnly = true)
	List<VotoDTO> findByVotacao(Votacao votacao);
}
