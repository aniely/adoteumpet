package com.adoteumpet.adocao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = Especie.TABLE_NAME)
public class Especie implements Serializable {

 
	private static final long serialVersionUID = 1L;
	
    public static final String TABLE_NAME = "tb_especie";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "gen_" + TABLE_NAME)
	@SequenceGenerator(name = "gen_" + TABLE_NAME, sequenceName = "sq_" + TABLE_NAME, allocationSize = 1)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;

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
