package br.ufrn.model.dao;

import java.util.Iterator;
import java.util.List;

import br.ufrn.model.entity.Empresa;
import br.ufrn.model.entity.Linha;
import br.ufrn.model.entity.Ponto;

public class LinhaDAOHibernate extends GenericHibernateDAO<Linha, Long> implements LinhaDAO{

	@Override
	public List<Ponto> listAllPontosOnibus() {
		return getInstance().createQuery(
				"select o from " + Ponto.class.getSimpleName() + " o")
				.getResultList();
	}

	@Override
	public List<Linha> findByCodigoLinha(String codigo) {
		List<Linha> lista = getInstance().createQuery(
				"select e from " + Linha.class.getSimpleName() + " e where e.codigoLinha like :pcod").setParameter("pcod",codigo).getResultList();
		for (Iterator<Linha> iterator = lista.iterator(); iterator.hasNext();) {
			Linha linha = iterator.next();
			System.out.println(linha);
			
		}
		return lista;
	}

}
