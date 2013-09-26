package br.ufrn.controller.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.ufrn.exceptions.ServiceException;
import br.ufrn.model.entity.Ponto;
//import br.ufrn.controller.PontosJSON;

import java.util.List;
import java.util.ArrayList;

public class PontosJSONTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFormatJSON() throws ServiceException {
		List<Ponto> pontos = new ArrayList<Ponto>();
		
		Ponto p1 = new Ponto("ponto1",1.1,1.2);
		Ponto p2 = new Ponto("ponto2",2.1,2.2);
		pontos.add(p1);
		pontos.add(p2); 
		
		String expected = "[{\"title\":\"ponto1\",\"lat\":1.1,\"lgt\":1.2},{\"title\":\"ponto2\",\"lat\":2.1,\"lgt\":2.2}]";
		
		//String actual = PontosJSON.formatJSON(pontos);
		
		//Assert.assertEquals(expected, actual);
	
		
	}

}
