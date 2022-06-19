package com.adoteumpet.adocao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.adoteumpet.adocao.dtos.UsuarioDTO;
import com.adoteumpet.adocao.entities.Usuario;
import com.adoteumpet.adocao.mappers.UsuarioMapper;
import com.adoteumpet.adocao.repositories.UsuarioRepository;
import com.adoteumpet.adocao.security.UsuarioSecurity;

@Service
public class UsuarioService  {

	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	UsuarioMapper usuarioMapper;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	  public UsuarioDTO criar(UsuarioDTO usuarioDTO) {
	    Usuario usuario = usuarioRepository.findByEmail(usuarioDTO.getEmail());
	    if (usuario != null) {
	      throw new Error("E-mail já cadastrado!");
	    }
	    usuario = new Usuario();
	    usuarioDTO.setSenha(bCryptPasswordEncoder.encode(usuarioDTO.getSenha()));
	    Usuario usuarioNovo = usuarioRepository.save(usuarioMapper.toEntity(usuarioDTO, usuario));
	    return usuarioMapper.toDTO(usuarioNovo);
	  }
	  
	  public static UsuarioSecurity authenticated() {
		  try {
			  return (UsuarioSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		  }
		  catch(Exception e) {
			  return null;
		  }
	  }
}
