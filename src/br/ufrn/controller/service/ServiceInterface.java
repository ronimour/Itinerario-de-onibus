package br.ufrn.controller.service;

import java.util.List;

import br.ufrn.exceptions.CampoInvalidoException;
import br.ufrn.exceptions.CampoNuloException;
import br.ufrn.exceptions.EntityNotDeletedException;
import br.ufrn.exceptions.EntityNotFoundException;
import br.ufrn.exceptions.EntityNotSavedException;
import br.ufrn.exceptions.EntityNotUpdatedException;
import br.ufrn.exceptions.ServiceException;

public interface ServiceInterface<E> {
	
	public void create(E entity) throws ServiceException;
	public void update(E entity)throws ServiceException;
	public void destroy(E entity)throws ServiceException;
	public E retrieve(Long id)throws ServiceException;
	public List<E> list()throws ServiceException;

}
