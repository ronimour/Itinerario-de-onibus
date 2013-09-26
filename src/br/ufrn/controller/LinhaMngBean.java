package br.ufrn.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import br.ufrn.model.entity.Linha;
import br.ufrn.model.entity.Ponto;


@ManagedBean
@ViewScoped
public class LinhaMngBean implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = 1458496684785L;
	private double lat;
	private double lng;
	public String title;
	private String itinerario;
	
	private MapModel simpleModel; 
	
	private Linha linha;
	
	public LinhaMngBean() {
		this.linha = new Linha();
		this.simpleModel = new DefaultMapModel();
	}
	
	
	public void addMarker(ActionEvent actionEvent) {
		System.out.println("Metodo invocado!"+" title: "+getTitle()+", lat: "+this.lat+", lng: "+this.lng+", itinerario: "+this.itinerario);
		try {
			Marker marker = new Marker(new LatLng(lat, lng), title);
			Ponto ponto = new Ponto(this.title,lat,lng);
			simpleModel.addOverlay(marker);
			
			if(this.itinerario.equals("ida")){
				linha.getPontosIda().add(ponto);
				System.out.println("Ponto adicionado na ida! "+ponto);
			}
			else if(this.itinerario.equals("volta")){
				linha.getPontosVolta().add(ponto);
				System.out.println("Ponto adicionado na volta! "+ponto);			
			}
		} catch (Exception e) {
			addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro: ",
					e.getMessage()));
		}

		addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Ponto adicionado: ",
				"Lat:" + lat + ", Lng:" + lng));
		
		printInfo();
	}
	
	private void printInfo() {
		System.out.println("Linha: \n"+this.linha);	
		
	}

	public void addMessage(FacesMessage message) {  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    } 
	
	
	// get and set
	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MapModel getSimpleModel() {
		return simpleModel;
	}

	public void setSimpleModel(MapModel simpleModel) {
		this.simpleModel = simpleModel;
	}

	public Linha getLinha() {
		return linha;
	}

	public void setLinha(Linha linha) {
		this.linha = linha;
	}

	public String getItinerario() {
		return itinerario;
	}

	public void setItinerario(String itinerario) {
		this.itinerario = itinerario;
	}
	
	
	
}
