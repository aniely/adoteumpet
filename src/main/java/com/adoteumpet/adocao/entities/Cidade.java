package com.adoteumpet.adocao.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = Cidade.TABLE_NAME)
public class Cidade implements Serializable {

 
	private static final long serialVersionUID = 1L;
	
    public static final String TABLE_NAME = "tb_cidade";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "gen_" + TABLE_NAME)
	@SequenceGenerator(name = "gen_" + TABLE_NAME, sequenceName = "sq_" + TABLE_NAME, allocationSize = 1)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
 	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_estado", nullable = false)
	private Estado estado;
	 

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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	  
}
