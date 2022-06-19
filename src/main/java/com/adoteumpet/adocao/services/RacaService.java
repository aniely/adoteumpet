package com.adoteumpet.adocao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.adoteumpet.adocao.mappers.RacaMapper;
import com.adoteumpet.adocao.repositories.RacaRepository;

@Validated
@Service
public class RacaService {

	private RacaMapper mapper;
	private RacaRepository repository;


	@Autowired
	public RacaService(RacaRepository repository,RacaMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
 

	 
}
