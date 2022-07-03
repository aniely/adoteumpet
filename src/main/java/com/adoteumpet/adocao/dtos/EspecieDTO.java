package com.adoteumpet.adocao.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EspecieDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotNull(message = "Nome não pode ser nulo")
	@NotBlank(message = "Nome não pode ser em branco")
	@NotEmpty(message = "Nome não pode vazio")
	private String nome;


	public EspecieDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}