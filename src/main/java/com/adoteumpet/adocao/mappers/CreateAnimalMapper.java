package com.adoteumpet.adocao.mappers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.adoteumpet.adocao.dtos.CreateAnimalDTO;
import com.adoteumpet.adocao.entities.Animal;
import com.adoteumpet.adocao.entities.Cidade;
import com.adoteumpet.adocao.entities.Imagem;
import com.adoteumpet.adocao.entities.Raca;
import com.adoteumpet.adocao.enums.StatusEnum;
import com.adoteumpet.adocao.repositories.CidadeRepository;
import com.adoteumpet.adocao.repositories.RacaRepository;
@Mapper(componentModel="spring")
 public class CreateAnimalMapper {
   
	 @Autowired
	 CidadeRepository cidadeRepository;
	 @Autowired
	 RacaRepository racaRepository;
  
    public  Animal createToEntity(CreateAnimalDTO dto, Animal entity) {
        if (dto == null) {
            return null;
        }
        if(dto.getIdCidade() != null) {
        	Optional<Cidade> cidade = cidadeRepository.findById(dto.getIdCidade());
            entity.setCidade(cidade.get());
        }
        if(dto.getIdRaca() != null) {
        	Optional<Raca> raca = racaRepository.findById(dto.getIdRaca());
            entity.setRaca(raca.get());
        }
        entity.setCor( dto.getCor() );
        entity.setDataInclusao(LocalDateTime.now());
        entity.setDescricao(dto.getDescricao());
        entity.setGenero(dto.getGenero());
        entity.setNome( dto.getNome() );
        entity.setPorte(dto.getPorte());
        entity.setStatus(StatusEnum.Disponível);
      // entity.setDataNascimento(LocalDateTime.now());
        List<Imagem> imagens = new ArrayList<>();
        for(Imagem img : dto.getImagens()) {
        	img.setAnimal(entity);
        	img.setDescricao(dto.getNome());
        	imagens.add(img);
        }
        entity.setImagens(imagens);
        return entity;
    }
}
