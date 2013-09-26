package br.ufrn.model.dao;

import java.util.List;

import br.ufrn.exceptions.DAOException;
import br.ufrn.model.entity.Empresa;

public interface EmpresaDAO extends GenericDAO<Empresa, Long> {
	//EXTENSIVEL PARA ADICAO DE OPERACOES
	public List<Empresa> findByNome(String nome)throws DAOException;
	public Empresa findByCNPJ(String cnpj)throws DAOException;
}
