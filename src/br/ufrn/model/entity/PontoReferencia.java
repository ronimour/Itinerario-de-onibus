package br.ufrn.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class PontoReferencia {

	@Id
	@GeneratedValue
	private Long id;
	private String descricao;
	private String nome;
	@OneToOne//(fetch=FetchType.EAGER)
	private Ponto ponto = new Ponto();
	
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Ponto getPonto() {
		return ponto;
	}
	public void setPonto(Ponto ponto) {
		this.ponto = ponto;
	}
	
	@Override
	public String toString() {
		return "{id: "+id+", descricao: "+descricao+", ponto: "+ponto.getId()+"}";
	}
	
	

}
