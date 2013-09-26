package br.ufrn.controller.service;

import java.util.List;

import br.ufrn.exceptions.DAOException;
import br.ufrn.exceptions.ServiceException;
import br.ufrn.model.dao.LinhaDAO;
import br.ufrn.model.entity.Linha;
import br.ufrn.model.entity.Ponto;

public class LinhaService extends Service<Linha>{
	
	private LinhaDAO dao = factory.getLinhaDAO();

	
	private void verificacaoValidacao(Linha linha) throws ServiceException{
		
		//linha.setIdLinha(this.getIdAutoIncrement());
		
		if(linha.getCodigoLinha().equals("") ){
			throw new ServiceException("codigo da linha invalido.");
		}
		if(linha.getCodigoLinha() == null){
			throw new ServiceException("O valor codigo da linha não foi informado");
		}
		if(linha.getDistancia() <= 0){
			throw new ServiceException("A distancia do percurso realizado por uma linha deve ser um valor positivo");
		}
		if(linha.getDistancia() == null){
			throw new ServiceException("O valor distancia do percurso nao foi informado");
		}
		if(linha.getQtdOnibus() <= 0){
			throw new ServiceException("A quantidade de onibus disponiveis para uma linha deve ser maior que 0");
		}
		if(linha.getQtdOnibus() == null){
			throw new ServiceException("O valor quantidade de onibus nao foi informado");
		}
		if(linha.getTarifa() < 0){
			throw new ServiceException("o valor da tarifa nao pode ser negativa");
		}
		if(linha.getTarifa() == null){
			throw new ServiceException("O valor da tarifa nao foi informado");
		}
		
	}

	@Override
	public void create(Linha entity) throws ServiceException {
		verificacaoValidacao(entity);
		
		
		try {
			dao.save(entity);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		
	}

	@Override
	public void update(Linha entity) throws ServiceException {
		verificacaoValidacao(entity);
		if(entity.getId() == null){
			throw new ServiceException("O identificador da linha não foi informado");
		}
		try {
			dao.update(entity);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		
	}

	@Override
	public void destroy(Linha entity) throws ServiceException {
		if(entity.getId() == null){
			throw new ServiceException("O identificador da linha não foi informado");
		}
		try {
			dao.delete(entity);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		
	}

	@Override
	public Linha retrieve(Long id) throws ServiceException {
		try {
			return dao.findById(Linha.class, id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public List<Linha> list() throws ServiceException {
		try {
			return dao.findAll(Linha.class);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public List<Ponto> listarAllPontosOnibus(){
		return dao.listAllPontosOnibus();
	}

	public List<Linha> pesquisarPorLinha(String linhaPesquisa) {		
		return dao.findByCodigoLinha(linhaPesquisa);
	}
	


}
