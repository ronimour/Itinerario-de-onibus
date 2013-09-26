package br.ufrn.model.dao;

import java.util.List;

import br.ufrn.model.entity.Ponto;
import br.ufrn.model.entity.PontoReferencia;

public class PontoRefernciaDaoHibernate extends 
GenericHibernateDAO<PontoReferencia, Long> implements PontoReferenciaDAO {

	@Override
	public List<Ponto> listarPontosDeOnibus() {
		return getInstance().createQuery(
				"select o from " + Ponto.class.getSimpleName() + " o")
				.getResultList();
	}

	@Override
	public Ponto getPontoOnibus(Long id) {
		return getInstance().find(Ponto.class, id);
		
	}

}
