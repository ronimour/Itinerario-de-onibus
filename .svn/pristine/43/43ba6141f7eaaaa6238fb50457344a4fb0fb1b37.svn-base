/**
 * 
 */
package br.ufrn.controller.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.ufrn.exceptions.ServiceException;
import br.ufrn.model.entity.Empresa;

/**
 * @author ronimour
 *
 */
public class EmpresaServiceTest {

	private static EmpresaService service;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
				
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		/*
		Empresa deleted = service.retrieve(1L);
		service.destroy(deleted);
		deleted = service.retrieve(2L);
		service.destroy(deleted);
		deleted = service.retrieve(4L);
		service.destroy(deleted);
		*/
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		service = new EmpresaService();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link br.ufrn.controller.service.EmpresaService#create(br.ufrn.model.entity.Empresa)}.
	 * @throws ServiceException 
	 */
	@Test
	public void testCreate() throws ServiceException {
		Empresa expected = new Empresa();
		
		expected.setId(1L);
		expected.setCnpj("33.087.156/0001-00");
		expected.setNome("nome-1");
		
		service.create(expected);
		
		Empresa actual = service.retrieve(1L);
		
		assertEquals(expected,actual);
	}

	/**
	 * Test method for {@link br.ufrn.controller.service.EmpresaService#update(br.ufrn.model.entity.Empresa)}.
	 * @throws ServiceException 
	 */
	@Test
	public void testUpdate() throws ServiceException {
		Empresa expected = new Empresa();
		
		expected.setId(2L);
		expected.setCnpj("33.087.156/0001-00");
		expected.setNome("nome-2");
		
		service.create(expected);
		
		expected.setNome("nome-alterado");
		
		service.update(expected);
		
		Empresa actual = service.retrieve(2L);
		
		assertEquals(expected.getNome(),actual.getNome());
	}

	/**
	 * Test method for {@link br.ufrn.controller.service.EmpresaService#destroy(br.ufrn.model.entity.Empresa)}.
	 * @throws ServiceException 
	 */
	@Test
	public void testDestroy() throws ServiceException {
		Empresa expected = new Empresa();
		
		expected.setId(3L);
		expected.setCnpj("33.087.156/0001-00");
		expected.setNome("nome-3");
		
		service.create(expected);
		
		Empresa temp = service.retrieve(3L);
		
		if(temp == null){
			fail("falha no retrieve da empresa 3!");
		}
		
		service.destroy(temp);
		
		Empresa actual = service.retrieve(3L);
		
		if(actual != null){
			fail("Empresa nao deletada!");
		}
		
	}

	/**
	 * Test method for {@link br.ufrn.controller.service.EmpresaService#retrieve(java.lang.Long)}.
	 * @throws ServiceException 
	 */
	@Test
	public void testRetrieve() throws ServiceException {
		Empresa expected = new Empresa();
		
		expected.setId(4L);
		expected.setCnpj("33.087.156/0001-00");
		expected.setNome("nome-4");
		
		service.create(expected);
		
		Empresa actual = service.retrieve(4L);
		
		if(actual == null){
			fail("falha no retrieve da empresa 4!");
		}
		
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link br.ufrn.controller.service.EmpresaService#list()}.
	 */
	@Test
	public void testList() {
	}

}
