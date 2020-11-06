package com.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.db.ConexaoHSQLDB;
import com.entity.Pessoa;

import dao.PessoaDAO;
import view.ControllerPessoa;

class PessoaDaoTest {
PessoaDAO pd;
Pessoa p;
ControllerPessoa c;

	@BeforeEach
	public void setUp(){
		
		// INSTÂNCIA  DAS CLASSES PARA USAR COMO OBJETOS
		p = new Pessoa();
		pd = new PessoaDAO();
		c = new ControllerPessoa();
	}

	
	@Test
	public void testConectar() {
	Connection connection = new ConexaoHSQLDB().conectar();
	
	try {
		assertTrue(connection.isValid(1));
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	
	@Test
	public void testInserir() {
		p.setId(1);
		p.setNome("Paulo");
		p.setEmail("paulo@gmail.com");
		p.setChoiceBoxSexo("M");
		p.setdatePickerId(null);
		p.setTextfieldPeso(70);

		 assertEquals(1, pd.inserir(p));
		
	}

	@Test
	public void testListAllNull() {
		List<Pessoa> listaPessoas = new ArrayList<Pessoa>(); 
		listaPessoas = pd.listAll();
		
		assertNotNull(listaPessoas);
		
	}
	
	@Test
	public void testListAll() {
		List<Pessoa> listaPessoas = new ArrayList<Pessoa>(); 
		listaPessoas = pd.listAll();
		
		assertEquals(listaPessoas,pd.listAll());
	}

	@Test
	public void testFindByID() {
		p = this.pd.findByID(24);
		assertEquals(24, p.getId());
	}

	
	
	@Test
	public void testAlterar() {	
		p.setId(24);	
		assertEquals(1,pd.Alterar(p));
		
		
	}

	@Test
	public void testDeleta() {
	p.setId(24);
	assertEquals(0,pd.Deleta(p));

     }
}