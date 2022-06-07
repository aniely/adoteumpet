package com.adoteumpet.adocao.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.adoteumpet.adocao.entities.Especie;
import com.adoteumpet.adocao.mappers.EspecieMapper;
import com.adoteumpet.adocao.repositories.EspecieRepository;

@Validated
@Service
public class EspecieService extends BaseService<Especie> {

	@PersistenceContext
	private EntityManager entityManager;

	private final EspecieRepository repository;
	//private final EspecieMapper mapper;

	@Autowired
	public EspecieService(EspecieRepository repository) {

		this.repository = repository;
		//this.mapper = mapper;
	}

	@Override
	protected JpaRepository<Especie, Long> getRepository() {
		return repository;
	}

}
