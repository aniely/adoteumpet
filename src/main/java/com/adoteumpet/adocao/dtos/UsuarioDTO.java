package com.adoteumpet.adocao.dtos;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

 
	private String nome;
	private String nomeUsuario;
	@JsonIgnore
	private String senha;
	private String email;
	

	public UsuarioDTO() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}