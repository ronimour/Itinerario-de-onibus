package br.ufrn.controller;

import java.util.ArrayList;
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
public class EmpresaMB {
	
	private EmpresaService service;
	private Empresa empresa = new Empresa();
	//private DataModel<Empresa> empresas;
	
	
	public EmpresaMB(){
		service = new EmpresaService();
		empresa = new Empresa();
	}
	
	public String prepararAdicionarEmpresa(){
		this.empresa = new Empresa();
		return null;
	}
	
	public String prepararAlterarEmpresa(){
	//	this.empresa = (Empresa) (this.empresas.getRowData());
		return null;
	}
	
	public String adicionarEmpresa(){
		
		try {
			service.create(empresa);
			System.out.println("passou do create!");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String alterarEmpresa(){
		try {
			service.update(empresa);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String excluirEmpresa(){
		/*try {
			Empresa empresaTemp = (Empresa)(this.empresas.getRowData());
			service.destroy(empresaTemp);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return null;
	}
	
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public DataModel<Empresa> getEmpresas() {	
		/*List<Empresa> empresasList = null;
		try {
			empresasList = service.list();
			this.empresas = new ListDataModel<Empresa>(empresasList);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.empresas;*/
		return null;
	}

	
	
	

}
