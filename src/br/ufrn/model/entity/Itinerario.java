package br.ufrn.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Itinerario {
	
	@Id
	@GeneratedValue
	private Long idItinerario;
	@OneToMany
	private List<Ponto> pontos ;
	
	public Long getIdItinerario() {
		return idItinerario;
	}
	public void setIdItinerario(Long idIntinerario) {
		this.idItinerario = idIntinerario;
	}
	public List<Ponto> getPontos() {
		return pontos;
	}
	public void setPontos(List<Ponto> pontos) {
		this.pontos = pontos;
	}
	
	

}
