package com.adoteumpet.adocao.mappers;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.adoteumpet.adocao.dtos.AnimalDTO;
import com.adoteumpet.adocao.entities.Animal;

@Mapper(componentModel="spring")
public interface AnimalMapper {
	
	@Mapping(target="id", ignore=true) 
	@BeanMapping(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, 
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    public Animal toEntity(AnimalDTO dto, @MappingTarget Animal entity);
	
	public AnimalDTO toDTO(Animal entity);

    public List<AnimalDTO> toDTOList(List<Animal> entity);
    
}
