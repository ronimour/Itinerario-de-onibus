package br.ufrn.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.ufrn.controller.service.PontoReferenciaService;
import br.ufrn.exceptions.ServiceException;
import br.ufrn.model.entity.Ponto;
import br.ufrn.model.entity.PontoReferencia;

@ManagedBean
@SessionScoped
public class PontoReferenciaBean {
	
	private PontoReferencia ponto = new PontoReferencia();
	private DataModel pontos;
	private PontoReferenciaService service = new PontoReferenciaService();
	private List<Ponto> pontosOnibus = new ArrayList<Ponto>();
	
	public void prepararAdicionarPonto(ActionEvent actionEvent){
		try {
			pontosOnibus = service.listarPontosDeOnibus();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.ponto = new PontoReferencia();
	}
	
	public void prepararAlterarPonto(ActionEvent actionEvent){
		this.ponto = (PontoReferencia) (this.pontos.getRowData());
		
		try {
			pontosOnibus = service.listarPontosDeOnibus();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void adicionarPonto(ActionEvent actionEvent){
		try {
			
			service.create(ponto);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void alterarPonto(ActionEvent actionEvent){
		try {
			service.update(ponto);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void excluirPonto(ActionEvent actionEvent){
		try {
			PontoReferencia pontoTemp = (PontoReferencia)(this.pontos.getRowData());
			service.destroy(pontoTemp);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String gerenciarPonto(){
		return "ponto";
	}
	
	public PontoReferencia getPonto() {
		return ponto;
	}

	public void setPonto(PontoReferencia ponto) {
		this.ponto = ponto;
	}

	public DataModel<PontoReferencia> getpontos() {	
		List<PontoReferencia> pontosList = null;
		try {
			if(service == null){
					System.out.println("Service null");
					service = new PontoReferenciaService();
				}
			pontosList = service.list();
		
			this.pontos = new ListDataModel<PontoReferencia>(pontosList);
			
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.pontos;
	}
	
	public void alterarPontoOnibus(ValueChangeEvent e){
		Long id = (Long) e.getNewValue();
		try {
			ponto.setPonto(service.findtPontoOnibus(id));
		} catch (ServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("alterou ponto de onibus " + ponto.getPonto().getDescricao());
	}


	public List<Ponto> getPontosOnibus() {
		return pontosOnibus;
	}


}
