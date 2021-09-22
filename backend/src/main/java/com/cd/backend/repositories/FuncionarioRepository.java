package com.cd.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cd.backend.domain.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Integer>{

}
