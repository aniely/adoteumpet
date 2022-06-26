package com.adoteumpet.adocao.dtos;

import java.io.Serializable;

import com.adoteumpet.adocao.enums.PorteEnum;
import com.adoteumpet.adocao.enums.SexoEnum;
import com.adoteumpet.adocao.enums.StatusEnum;

public class CreateAnimalDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	//private LocalDateTime data_nascimento;
	private PorteEnum porte;
	private SexoEnum genero;
	private StatusEnum status;
	private Integer idade;
	private Long idRaca;
	private String cor;
	private String descricao;
	private Long idCidade;

	public CreateAnimalDTO() {
	}

 

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

/*	public LocalDateTime getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(LocalDateTime data_nascimento) {
		this.data_nascimento = data_nascimento;
	} */

	public PorteEnum getPorte() {
		return porte;
	}

	public void setPorte(PorteEnum porte) {
		this.porte = porte;
	}

	public SexoEnum getGenero() {
		return genero;
	}

	public void setGenero(SexoEnum genero) {
		this.genero = genero;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Long getIdRaca() {
		return idRaca;
	}

	public void setIdRaca(Long idRaca) {
		this.idRaca = idRaca;
	}

	public Long getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Long idCidade) {
		this.idCidade = idCidade;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}