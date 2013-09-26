/**
 * 
 */
package br.ufrn.model.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author logan
 *
 */
public class HibernateDAOFactoryTest {

	 DAOFactory factory = DAOFactory.instance(HibernateDAOFactory.class);

	/**
	 * Test method for {@link br.ufrn.model.dao.HibernateDAOFactory#getEmpresaDAO()}.
	 */
	@Test
	public void testGetEmpresaDAO() {
		EmpresaDAO dao = factory.getEmpresaDAO();
		assertNotNull(dao);
	}

	/**
	 * Test method for {@link br.ufrn.model.dao.HibernateDAOFactory#getPontoOnibusDAO()}.
	 */
	@Test
	public void testGetPontoOnibusDAO() {
		PontoOnibusDAO dao = factory.getPontoOnibusDAO();
		assertNotNull(dao);
	}

	/**
	 * Test method for {@link br.ufrn.model.dao.HibernateDAOFactory#getPontoReferenciaDAO()}.
	 */
	@Test
	public void testGetPontoReferenciaDAO() {
		PontoReferenciaDAO dao = factory.getPontoReferenciaDAO();
		assertNotNull(dao);
	}

	/**
	 * Test method for {@link br.ufrn.model.dao.HibernateDAOFactory#getLinhaDAO()}.
	 */
	@Test
	public void testGetLinhaDAO() {
		LinhaDAO dao = factory.getLinhaDAO();
		assertNotNull(dao);
	}

}
