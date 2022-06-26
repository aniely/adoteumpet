package com.adoteumpet.adocao.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adoteumpet.adocao.entities.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	
	 Optional<Cidade> findById(Long id);

}
	 