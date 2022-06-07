package com.adoteumpet.adocao.mappers;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.adoteumpet.adocao.dtos.RacaDTO;
import com.adoteumpet.adocao.entities.Raca;

@Mapper(componentModel="spring")
public interface RacaMapper {
	
	@Mapping(target="id", ignore=true) 
	@BeanMapping(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, 
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    public Raca toEntity(RacaDTO dto, @MappingTarget Raca entity);
	
	public RacaDTO toDTO(Raca entity);

    public List<RacaDTO> toDTOList(List<Raca> entity);
}


