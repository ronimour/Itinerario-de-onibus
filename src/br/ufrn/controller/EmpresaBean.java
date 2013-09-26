package br.ufrn.controller;

import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.ufrn.controller.service.EmpresaService;
import br.ufrn.exceptions.ServiceException;
import br.ufrn.model.entity.Empresa;

@ManagedBean
@SessionScoped
public class EmpresaBean {
	
	private EmpresaService service;
	private Empresa empresa = new Empresa();
	private DataModel<Empresa> empresas;
	
	
	public EmpresaBean(){
		service = new EmpresaService();
		empresa = new Empresa();
	}
	
	public void prepararAdicionarEmpresa(ActionEvent actionEvent){
		this.empresa = new Empresa();
	}
	
	public void prepararAlterarEmpresa(ActionEvent actionEvent){
		this.empresa = (Empresa) (this.empresas.getRowData());
	}
	
	public void prepararExcluirEmpresa(ActionEvent actionEvent){
		this.empresa = (Empresa) (this.empresas.getRowData());
	}
	
	public void adicionarEmpresa(ActionEvent actionEvent){
		try {
			service.create(empresa);
			FacesContext.getCurrentInstance()
			.addMessage("messages", 
					new FacesMessage(
							FacesMessage.SEVERITY_INFO,
							"Sucesso!", 
							"A empresa de nome "+empresa.getNome()+" foi cadastrada com sucesso."));
			empresa = new Empresa();
		} catch (ServiceException e) {
			FacesContext.getCurrentInstance()
			.addMessage("messages", 
					new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"Erro!", 
							"A empresa de nome "+empresa.getNome()+" não foi cadastrada pelo seguinte motivo: "+e.getMessage()));
		}
	}
	
	public void alterarEmpresa(ActionEvent actionEvent){
		try {
			service.update(empresa);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void excluirEmpresa(ActionEvent actionEvent){
		try {
			service.destroy(empresa);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public DataModel<Empresa> getEmpresas() {	
		List<Empresa> empresasList = null;
		try {
			if(service == null){
					System.out.println("Service null");
					service = new EmpresaService();
				}
			empresasList = service.list();
		
			this.empresas = new ListDataModel<Empresa>(empresasList);
			
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.empresas;
	}

	
	
	

}
