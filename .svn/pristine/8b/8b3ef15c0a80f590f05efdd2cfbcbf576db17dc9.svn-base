/**
 * 
 */
package br.ufrn.model.dao;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.ufrn.exceptions.DAOException;
import br.ufrn.model.entity.Empresa;

/**
 * @author ronimour
 *
 */
public class EmpresaDAOHibernateTest {

	static final DAOFactory factory = DAOFactory.instance(HibernateDAOFactory.class);
	static EmpresaDAO dao;	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = factory.getEmpresaDAO();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//para manter o banco de dados no estado anterior ao teste
		Empresa to_replace_deleted = new Empresa();
		to_replace_deleted.setNome("Empresa para teste de remoção");
		to_replace_deleted.setCnpj("17.273.812/0001-03");
		
		dao.save(to_replace_deleted);
		
		Empresa delete_saved_on_test = dao.findByCNPJ("42.897.518/0001-10");
		
		dao.delete(delete_saved_on_test);
		
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
	 * Test method for {@link br.ufrn.model.dao.EmpresaDAOHibernate#findByNome()}.
	 */
	@Test
	public void testFindByNome() {
		Empresa expected = new Empresa();
		expected.setId(1L);
		expected.setCnpj("65.253.565/0001-26");
		
		List<Empresa> listaEmpresas = null;
		try {
			listaEmpresas = dao.findByNome("Transportes Guanabara Ltda");
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Empresa actual = listaEmpresas.get(0);
		System.out.println(actual);
		
		assertEquals(expected, actual);
		
	}

	/**
	 * Test method for {@link br.ufrn.model.dao.EmpresaDAOHibernate#findByCNPJ()}.
	 */
	@Test
	public void testFindByCNPJ() {
		Empresa expected = new Empresa();
		expected.setId(1L);
		expected.setCnpj("65.253.565/0001-26");
		
		Empresa actual = null;
		try {
			actual = dao.findByCNPJ("65.253.565/0001-26");
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		System.out.println(actual);
		
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link br.ufrn.model.dao.GenericHibernateDAO#save(java.lang.Object)}.
	 */
	@Test
	public void testSave() {
		Empresa expected = new Empresa();
		expected.setCnpj("42.897.518/0001-10");
		
		Empresa saved = dao.save(expected);
		
		expected.setId(saved.getId());
		
		Empresa actual = dao.findByCNPJ("42.897.518/0001-10");
		 
		System.out.println(actual);
		
		assertEquals(expected, actual);
		assertEquals(expected, saved);

		
	}

	/**
	 * Test method for {@link br.ufrn.model.dao.GenericHibernateDAO#update(java.lang.Object)}.
	 */
	@Test
	public void testUpdate() {
		Empresa before_update = null;
		try {
			before_update = (Empresa) dao.findByNome("Empresa para teste de atualização").get(0).clone();
		} catch (CloneNotSupportedException e) {
			fail("metodo clone falhou!");
		}		
		Empresa to_be_updated = dao.findByNome("Empresa para teste de atualização").get(0);
		
		if (before_update == to_be_updated){
			fail("ambos referenciam o mesmo objeto");
		}

		//artifcio para que o teste possa ser executado varias vezes
		if(before_update.getCnpj().equals("86.733.671/0001-87")){
			to_be_updated.setCnpj("22.935.066/0001-06");
		} else if(before_update.getCnpj().equals("22.935.066/0001-06")){
			to_be_updated.setCnpj("86.733.671/0001-87");
		}
		
		
		
		Empresa after_update = dao.update(to_be_updated);		
		
		assertFalse(before_update.equals(after_update));
		
	}

	/**
	 * Test method for {@link br.ufrn.model.dao.GenericHibernateDAO#delete(java.lang.Object)}.
	 */
	@Test
	public void testDelete() {
		Empresa to_be_deleted = dao.findByCNPJ("17.273.812/0001-03");
		
		dao.delete(to_be_deleted);
		
		Empresa actual = dao.findByCNPJ("17.273.812/0001-03");
		
		assertTrue(actual == null);
	}

	/**
	 * Test method for {@link br.ufrn.model.dao.GenericHibernateDAO#findById(java.lang.Class, java.io.Serializable)}.
	 */
	@Test
	public void testFindById() {
		Empresa expected = new Empresa();
		expected.setId(1L);
		expected.setCnpj("65.253.565/0001-26");
		
		Empresa actual = dao.findById(Empresa.class, 1L);
		 
		System.out.println(actual);
		
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link br.ufrn.model.dao.GenericHibernateDAO#findAll(java.lang.Class)}.
	 */
	@Test
	public void testFindAll() {
		List<Empresa> listaEmpresas = dao.findAll(Empresa.class);
		for (Iterator iterator = listaEmpresas.iterator(); iterator.hasNext();) {
			Empresa empresa = (Empresa) iterator.next();
			System.out.println(empresa);			
		}
		
		/*
		 * inicialmente existem 15 empresas no banco
		 * este testecase usa o maior igual a 14 pois 
		 * se o teste do save() for executado antes deste, entao tera uma empresa a mais, logo (15 + 1) --> size() == 16 --> size() >= 14  
		 * mas se o teste do  delete() for executado antes tera uma a menos, logo (15 - 1) --> size() == 14 --> size() >= 14
		 * no caso do delete() e do save() serem executados antes deste teste, logo  (15 + 1 - 1) --> size() == 15 --> size() >= 14 
		 */
		assertTrue(listaEmpresas.size() >= 14);
	}

}
