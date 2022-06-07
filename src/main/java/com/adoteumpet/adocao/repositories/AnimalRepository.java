package com.adoteumpet.adocao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adoteumpet.adocao.entities.Animal;
import com.adoteumpet.adocao.enums.StatusEnum;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
	
	List<Animal> findByStatus(StatusEnum status);

}
	 