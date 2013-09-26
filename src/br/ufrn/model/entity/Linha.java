package br.ufrn.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;



@Entity
public class Linha implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1485584423045340L;
	@Id
	@GeneratedValue
	private Long id;
	private Double tarifa;
	private Double distancia;
	private Integer qtdOnibus;

	@ManyToMany ( cascade = CascadeType.MERGE )
	@JoinTable(name="linha_pontosIda",joinColumns=@JoinColumn(name="Linha_id"),inverseJoinColumns=@JoinColumn(name="pontosIda_id"))

	private List<Ponto> pontosIda = new ArrayList<Ponto>() ;

	@ManyToMany( cascade = CascadeType.MERGE )
	@JoinTable(name="linha_pontosVolta",joinColumns=@JoinColumn(name="Linha_id"),inverseJoinColumns=@JoinColumn(name="pontosVolta_id"))

	private List<Ponto> pontosVolta = new ArrayList<Ponto>() ;
	private String codigoLinha;
	private String inicio;
	private String fim;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	
	
	public String getCodigoLinha() {
		return codigoLinha;
	}
	public void setCodigoLinha(String codigoLinha) {
		this.codigoLinha = codigoLinha;
	}

	public Double getTarifa() {
		return tarifa;
	}
	public void setTarifa(Double tarifa) {
		this.tarifa = tarifa;
	}
	public Double getDistancia() {
		return distancia;
	}
	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}
	public void setQtdOnibus(Integer qtdOnibus) {
		this.qtdOnibus = qtdOnibus;
	}
	public List<Ponto> getPontosIda() {
		return pontosIda;
	}
	public void setPontosIda(List<Ponto> pontosIda) {
		this.pontosIda = pontosIda;
	}
	public List<Ponto> getPontosVolta() {
		return pontosVolta;
	}
	public void setPontosVolta(List<Ponto> pontosVolta) {
		this.pontosVolta = pontosVolta;
	}
	public Integer getQtdOnibus() {
		return qtdOnibus;
	}
	
	public String getInicio() {
		return inicio;
	}
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	public String getFim() {
		return fim;
	}
	public void setFim(String fim) {
		this.fim = fim;
	}
	
	@Override
	public String toString() {
		String output = "\nid: "+id+"\ncodigo-linha: "+codigoLinha;
		output += "\nPontos de Ida: ";
		for (Iterator<Ponto> iterator = pontosIda.iterator(); iterator.hasNext();) {
			Ponto p =  iterator.next();
			output += p.toString(); 
		}
		output += "\nPontos de Volta: ";
		for (Iterator<Ponto> iterator = pontosVolta.iterator(); iterator.hasNext();) {
			Ponto p =  iterator.next();
			output += p.toString(); 
		}
		return output;
	}
	
	

}
