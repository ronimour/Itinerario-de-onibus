package br.ufrn.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.ufrn.controller.service.PontoService;
import br.ufrn.exceptions.ServiceException;
import br.ufrn.model.entity.Ponto;


@ManagedBean
@SessionScoped
public class PontoBean {
	
	private Ponto ponto = new Ponto();
	private DataModel<Ponto> pontos;
	private PontoService service = new PontoService();
	
	public PontoBean() {
		service = new PontoService();
		ponto = new Ponto();
	}
		
	
	public void prepararAdicionarPonto(ActionEvent actionEvent){
		this.ponto = new Ponto();
	}
	
	public void prepararAlterarPonto(ActionEvent actionEvent){
		this.ponto = (Ponto) (this.pontos.getRowData());
	}
	
	public void adicionarPonto(ActionEvent actionEvent){
		try {

			service.create(ponto);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@SuppressWarnings("finally")
	public String adicionar(){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = null;
		try {
			
			service.create(ponto);			
			message = new FacesMessage("Ponto salvo com sucesso!");
			message.setSeverity(FacesMessage.SEVERITY_INFO);
		} catch (ServiceException e) {

			message = new FacesMessage("Nao foi possivel salvar o ponto! "+e.getMessage());
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			e.printStackTrace();
		} finally{
			context.addMessage("addPonto", message);
			this.ponto = new Ponto();
			return null;
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
			Ponto pontoTemp = (Ponto)(this.pontos.getRowData());
			service.destroy(pontoTemp);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String gerenciarPonto(){
		return "ponto";
	}
	
	public Ponto getPonto() {
		return ponto;
	}

	public void setPonto(Ponto ponto) {
		this.ponto = ponto;
	}

	public DataModel<Ponto> getpontos() {	
		List<Ponto> pontosList = null;
		try {
			if(service == null){
					System.out.println("Service null");
					service = new PontoService();
				}
			pontosList = service.list();
		
			this.pontos = new ListDataModel<Ponto>(pontosList);
			
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.pontos;
	}
	
	
	
	

}
