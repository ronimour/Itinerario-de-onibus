package br.ufrn.controller.service;

import java.util.List;

import br.ufrn.exceptions.CampoInvalidoException;
import br.ufrn.exceptions.CampoNuloException;
import br.ufrn.exceptions.DAOException;
import br.ufrn.exceptions.EntityNotFoundException;
import br.ufrn.exceptions.EntityNotSavedException;
import br.ufrn.exceptions.EntityNotUpdatedException;
import br.ufrn.exceptions.ServiceException;
import br.ufrn.model.dao.PontoReferenciaDAO;
import br.ufrn.model.entity.Linha;
import br.ufrn.model.entity.Ponto;
import br.ufrn.model.entity.PontoReferencia;

public class PontoReferenciaService extends Service<PontoReferencia> {
	

	private PontoReferenciaDAO dao;
	
	public PontoReferenciaService() {
		dao = factory.getPontoReferenciaDAO();
	}

	private void verificacaoValidacao(PontoReferencia entity) throws ServiceException{

		if(entity.getPonto() == null){
			throw new ServiceException("o pontos de referencia nao referencia nenhum ponto de onibus");
		}
		if(entity.getNome().equals("") || entity.getNome() == null){
			throw new ServiceException("O valor nome do ponto de referencia nao foi informado.");
		}
		if(entity.getDescricao().equals("") || entity.getDescricao() == null){
			throw new ServiceException("A descricao do ponto de referencia nao foi informada.");
		}
		
	}

	@Override
	public void create(PontoReferencia entity) throws ServiceException {
		verificacaoValidacao(entity);
		try {
			dao.save(entity);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		
	}

	@Override
	public void update(PontoReferencia entity) throws ServiceException {
		if(entity.getId() == null){
			throw new ServiceException("O valor id do ponto de referência não foi informado.");
		}
		System.out.println("tentando alterar " + entity.getNome());
		try {
			dao.update(entity);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		System.out.println("alterou ponto de onibus " + entity.getNome());
	}

	@Override
	public void destroy(PontoReferencia entity) throws ServiceException {
		if(entity.getId() == null){
			throw new ServiceException("O valor id do ponto de referência não foi informado.");
		}
		
		try {
			dao.delete(entity);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		
	}

	@Override
	public PontoReferencia retrieve(Long id) throws ServiceException {
	
		try {
			return dao.findById(PontoReferencia.class, id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		
	}

	@Override
	public List<PontoReferencia> list() throws ServiceException {
		try {
			return dao.findAll(PontoReferencia.class);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	public List<Ponto> listarPontosDeOnibus() throws ServiceException{
		return dao.listarPontosDeOnibus();
				
	}
	
	public Ponto findtPontoOnibus(Long id)throws ServiceException{
		return dao.getPontoOnibus(id);
	}
	
	

	
}
