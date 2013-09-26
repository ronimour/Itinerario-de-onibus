/**
 * 
 */
package br.ufrn.model.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import antlr.collections.List;
import br.ufrn.model.entity.Linha;
import br.ufrn.model.entity.Ponto;

/**
 * @author logan
 *
 */
public class LinhaDAOHibernateTest {
	
	static final DAOFactory factory = DAOFactory.instance(HibernateDAOFactory.class);
	static LinhaDAO dao;	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = factory.getLinhaDAO();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link br.ufrn.model.dao.GenericHibernateDAO#save(java.lang.Object)}.
	 */
	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link br.ufrn.model.dao.GenericHibernateDAO#update(java.lang.Object)}.
	 */
	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link br.ufrn.model.dao.GenericHibernateDAO#delete(java.lang.Object)}.
	 */
	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link br.ufrn.model.dao.GenericHibernateDAO#findById(java.lang.Class, java.io.Serializable)}.
	 */
	@Test
	public void testFindById() {
		Linha linha = dao.findById(Linha.class, 1L);
		System.out.println(linha);
		/*
		System.out.println("Pontos de Volta: ");
		for (Iterator<Ponto> iterator =  linha.getPontosIda().iterator(); iterator.hasNext();) {
			Ponto p = iterator.next();
			System.out.println(p);
			
		}
		System.out.println("Pontos de Volta: ");
		for (Iterator<Ponto> iterator =  linha.getPontosVolta().iterator(); iterator.hasNext();) {
			Ponto p = iterator.next();
			System.out.println(p);
			
		}
		*/
		assertEquals(linha.getId(),new Long(1));
	}
	@Test
	public void testFindByCodigo() {
		
		for (Iterator<Linha> iterator =  dao.findByCodigoLinha("33A").iterator(); iterator.hasNext();) {
			Linha l = iterator.next();
			System.out.println(l);
			
		}
	}
	/**
	 * Test method for {@link br.ufrn.model.dao.GenericHibernateDAO#findAll(java.lang.Class)}.
	 */
	@Test
	public void testFindAll() {
		int cont = 0;
		for (Iterator<Linha> it = dao.findAll(Linha.class).iterator(); it.hasNext();) {
			Linha t = it.next();
			System.out.println(t.toString());
			cont++;
			
		}		
		assertTrue(cont==76);
	}

}
