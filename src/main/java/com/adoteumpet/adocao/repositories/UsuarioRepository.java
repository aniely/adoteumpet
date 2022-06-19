package com.adoteumpet.adocao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adoteumpet.adocao.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByEmail(String email);
}
	 