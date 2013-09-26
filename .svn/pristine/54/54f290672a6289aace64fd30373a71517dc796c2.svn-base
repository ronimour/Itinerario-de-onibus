package br.ufrn.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Ponto {

	@Id
	@GeneratedValue
	private Long id;
	private Double latitude;
	private Double longitude;
	private String descricao;
	@OneToMany(mappedBy = "ponto")
	private List<PontoReferencia> pontosReferencia;
	@ManyToMany//(mappedBy = "pontosIda")
	private List<Linha> linhas;
	
	
	public Ponto() {
	}
	
	public Ponto(String descricao, double lat, double lgt) {
		this.descricao = descricao;
		this.latitude = lat;
		this.longitude = lgt;
	}
	public List<Linha> getLinhas() {
		return linhas;
	}
	public void setLinhas(List<Linha> linhas) {
		this.linhas = linhas;
	}
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
	public List<PontoReferencia> getPontosReferencia() {
		return pontosReferencia;
	}
	public void setPontosReferencia(List<PontoReferencia> pontosReferencia) {
		this.pontosReferencia = pontosReferencia;
	}
	
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	@Override
	public String toString() {
		return "{id: "+id+", descricao: "+descricao+", latitude: "+latitude+", longitude: "+longitude+"}";
	}
	
}
