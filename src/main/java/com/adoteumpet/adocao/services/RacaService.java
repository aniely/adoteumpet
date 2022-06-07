package com.adoteumpet.adocao.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.adoteumpet.adocao.entities.Raca;
import com.adoteumpet.adocao.mappers.RacaMapper;
import com.adoteumpet.adocao.repositories.RacaRepository;

@Validated
@Service
public class RacaService extends BaseService<Raca> {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private EspecieService especieService;

	private final RacaRepository repository;
//	private final RacaMapper mapper;

	@Autowired
	public RacaService(RacaRepository repository) {
		this.repository = repository;
		//this.mapper = mapper;
	}

	@Override
	protected JpaRepository<Raca, Long> getRepository() {
		return repository;
	}

	 
}
