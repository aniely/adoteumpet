package com.adoteumpet.adocao.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.adoteumpet.adocao.entities.Raca;
import com.adoteumpet.adocao.enums.PorteEnum;
import com.adoteumpet.adocao.enums.SexoEnum;
import com.adoteumpet.adocao.enums.StatusEnum;

public class AnimalDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private LocalDateTime data_inclusao;
	private LocalDateTime data_nascimento;
	private PorteEnum porte;
	private SexoEnum genero;
	private StatusEnum status;
	private Integer idade;
	private Raca raca;
	private String cor;
	private String descricao;

	public AnimalDTO() {
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

	public LocalDateTime getData_inclusao() {
		return data_inclusao;
	}

	public void setData_inclusao(LocalDateTime data_inclusao) {
		this.data_inclusao = data_inclusao;
	}

	public LocalDateTime getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(LocalDateTime data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

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

	public Raca getRaca() {
		return raca;
	}

	public void setRaca(Raca raca) {
		this.raca = raca;
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