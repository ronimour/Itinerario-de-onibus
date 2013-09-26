package br.ufrn.controller.service;

import java.util.Iterator;
import java.util.List;

import br.ufrn.controller.service.validator.CNPJValidator;
import br.ufrn.controller.service.validator.ValidatorInterface;
import br.ufrn.exceptions.ServiceException;
import br.ufrn.exceptions.ValidationException;
import br.ufrn.model.dao.GenericDAO;
import br.ufrn.model.entity.Empresa;

public class EmpresaService extends Service<Empresa> {

	private GenericDAO<Empresa,Long> dao;

	public EmpresaService() {
		this.dao = factory.getEmpresaDAO();
	}

	@Override
	public void create(Empresa entity) throws ServiceException {
		veficacaoValidacao(entity);				
		try {
			this.dao.save(entity);
			System.out.println("passou do save!");
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public void update(Empresa entity) throws ServiceException{
		veficacaoValidacao(entity);				
		try {
			this.dao.update(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public void destroy(Empresa entity) throws ServiceException {
		  try {
			this.dao.delete(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		
	}

	@Override
	public Empresa retrieve(Long id) throws ServiceException {
		Empresa output = null;
		try {
			output = this.dao.findById(Empresa.class, id);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return output;
	}

	@Override
	public List<Empresa> list() throws ServiceException {
		List<Empresa> output;
		try {
			output = this.dao.findAll(Empresa.class);
			/*
			for (Iterator<Empresa> iterator = output.iterator(); iterator.hasNext();) {
				Empresa empresa = iterator.next();
				System.out.println(empresa);
				
			}
			*/
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return output;
	}
	
	
	
	
	private void veficacaoValidacao(Empresa entity) throws ServiceException {
		// Regras de negocio

		// Verificacao de campos em branco
		//entity.setIdEmpresa(this.getIdAutoIncrement());
		if (entity.getNome().isEmpty() || entity.getCnpj().isEmpty()) {
			String message = "";
			if (entity.getNome().isEmpty()) {
				message += "Campo Nome em Branco! ";
			}
			if (entity.getCnpj().isEmpty()) {
				message += "Campo CNPJ em Branco! ";
			}

			throw new ServiceException(message);
		}

		/*// Validacao dos campos
		/*ValidatorInterface validator = new CNPJValidator();
		try {
			validator.validate(entity.getCnpj());
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage());
		}*/
		
	}

}
