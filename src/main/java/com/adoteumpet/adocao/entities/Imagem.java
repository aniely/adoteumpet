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
@Table(name = Imagem.TABLE_NAME)
public class Imagem implements Serializable {

 
	private static final long serialVersionUID = 1L;
	
    public static final String TABLE_NAME = "tb_imagem";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "gen_" + TABLE_NAME)
	@SequenceGenerator(name = "gen_" + TABLE_NAME, sequenceName = "sq_" + TABLE_NAME, allocationSize = 1)
	private Long id;
	
	@Column(name = "descricao", nullable = false)
	private String descricao;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_animal", nullable = false)
	private Animal animal;
	
	@Column(name = "img", nullable = false)
	private byte[] img;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}
	
	
}