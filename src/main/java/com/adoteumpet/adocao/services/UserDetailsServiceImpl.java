package com.adoteumpet.adocao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.adoteumpet.adocao.entities.Usuario;
import com.adoteumpet.adocao.repositories.UsuarioRepository;
import com.adoteumpet.adocao.security.UsuarioSecurity;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	 UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioRepository.findByEmail(email);

	    if (usuario == null) {
	      throw new UsernameNotFoundException(email);
	    }
		
		return new UsuarioSecurity(usuario.getId(), usuario.getEmail(), usuario.getSenha());
	}

}
