package br.ufrn.controller.service;

import java.util.List;

import br.ufrn.exceptions.DAOException;
import br.ufrn.exceptions.ServiceException;
import br.ufrn.model.dao.PontoOnibusDAO;
import br.ufrn.model.entity.Ponto;

public class PontoService extends Service<Ponto> {

	private PontoOnibusDAO dao;
	
	public PontoService() {
		this.dao = factory.getPontoOnibusDAO();
	}

	@Override
	public void create(Ponto entity) throws ServiceException {
		verificacaoValidacao(entity);
		try {
			dao.save(entity);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		
	}

	@Override
	public void update(Ponto entity) throws ServiceException {
		verificacaoValidacao(entity);
		try {
			dao.update(entity);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		
	}

	@Override
	public void destroy(Ponto entity) throws ServiceException {
		if(entity.getId() == null){
			throw new ServiceException("identificador do ponto de onibus vazio");
		}
		 
		try {
			dao.delete(entity);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		
	}

	@Override
	public Ponto retrieve(Long id) throws ServiceException {
		
		try {
			return dao.findById(Ponto.class, id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public List<Ponto> list() throws ServiceException {
		
		try {
			return dao.findAll(Ponto.class);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	
	private void verificacaoValidacao(Ponto ponto) throws ServiceException{
		
		if(ponto.getDescricao() == null || ponto.getDescricao().isEmpty() ){
			throw new ServiceException("A descricao do ponto nao foi informada");
		}
		if(ponto.getLatitude() == null){
			throw new ServiceException("A latitude do ponto nao foi informada");
		}
		if(ponto.getLongitude() == null){
			throw new ServiceException("A longitude do ponto nao foi informada");
		}
		
	}

	

}
