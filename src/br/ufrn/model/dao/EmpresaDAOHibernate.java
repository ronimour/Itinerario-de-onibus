package br.ufrn.model.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import br.ufrn.exceptions.DAOException;
import br.ufrn.model.entity.Empresa;

public class EmpresaDAOHibernate 
	extends GenericHibernateDAO<Empresa, Long> 
	implements EmpresaDAO {

	@Override
	public List<Empresa> findByNome(String nome) throws DAOException{
		
		List<Empresa> resultList = null;
		try {
			Query q = getInstance().createQuery(
					"select e from " + Empresa.class.getSimpleName() + " e where e.nome like :pnome");
			q.setParameter("pnome",nome);
			resultList = q.getResultList();
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
		return resultList;
	}

	@Override
	public Empresa findByCNPJ(String cnpj) throws DAOException{
		
		try {
			return (Empresa)getInstance().createQuery(
					"select e from " + Empresa.class.getSimpleName() + " e where e.cnpj = :pcnpj").setParameter("pcnpj",cnpj).getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch(NonUniqueResultException e){
			System.out.println("existem mais de uma empresa com esse cnpj!");
			return null;
		}
		
		
		
	}

	


}
