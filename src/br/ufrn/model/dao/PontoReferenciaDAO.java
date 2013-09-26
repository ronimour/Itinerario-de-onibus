package br.ufrn.model.dao;

import java.util.List;

import javax.persistence.NoResultException;

import br.ufrn.model.entity.Ponto;
import br.ufrn.model.entity.PontoReferencia;

public interface PontoReferenciaDAO extends GenericDAO<PontoReferencia, Long> {
	
	List<Ponto> listarPontosDeOnibus();
	
	public Ponto getPontoOnibus(Long id);

		
}
