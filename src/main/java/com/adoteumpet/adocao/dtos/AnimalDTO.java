package com.adoteumpet.adocao.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.adoteumpet.adocao.entities.Imagem;
import com.adoteumpet.adocao.enums.PorteEnum;
import com.adoteumpet.adocao.enums.SexoEnum;
import com.adoteumpet.adocao.enums.StatusEnum;

public class AnimalDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private LocalDateTime dataInclusao;
	private LocalDateTime dataNascimento;
	private PorteEnum porte;
	private SexoEnum genero;
	private StatusEnum status;
	private RacaDTO raca;
	private String cor;
	private String descricao;
	private CidadeDTO cidade;
	private UsuarioDTO tutor;
	private UsuarioDTO adotadoPor;
	private List<Imagem> imagens;

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

	 
  

	public LocalDateTime getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(LocalDateTime dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
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


	public RacaDTO getRaca() {
		return raca;
	}

	public void setRaca(RacaDTO raca) {
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

	public CidadeDTO getCidade() {
		return cidade;
	}

	public void setCidade(CidadeDTO cidade) {
		this.cidade = cidade;
	}

	public UsuarioDTO getTutor() {
		return tutor;
	}

	public void setTutor(UsuarioDTO tutor) {
		this.tutor = tutor;
	}

	public UsuarioDTO getAdotadoPor() {
		return adotadoPor;
	}

	public void setAdotadoPor(UsuarioDTO adotadoPor) {
		this.adotadoPor = adotadoPor;
	}

	public List<Imagem> getImagens() {
		return imagens;
	}

	public void setImagens(List<Imagem> imagens) {
		this.imagens = imagens;
	}
	
	
	
}