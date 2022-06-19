package com.adoteumpet.adocao.mappers;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.adoteumpet.adocao.dtos.UsuarioDTO;
import com.adoteumpet.adocao.entities.Usuario;

@Mapper(componentModel="spring")
public interface UsuarioMapper {
	
	@Mapping(target="id", ignore=true) 
	@BeanMapping(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, 
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    public Usuario toEntity(UsuarioDTO dto, @MappingTarget Usuario entity);
	
	public UsuarioDTO toDTO(Usuario entity);

    public List<UsuarioDTO> toDTOList(List<Usuario> entity);
}
