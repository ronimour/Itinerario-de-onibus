package br.ufrn.controller.service;

import java.util.concurrent.atomic.AtomicLong;

import br.ufrn.model.dao.DAOFactory;
import br.ufrn.model.dao.HibernateDAOFactory;

public abstract class Service<E> implements ServiceInterface<E> {

	
	protected static final DAOFactory factory = DAOFactory.instance(HibernateDAOFactory.class);
	
	public Service() {
	}
		
	
}
