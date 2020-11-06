package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.ConexaoHSQLDB;

public class TestConection {

	
	public static void main (String[] args ) 
	
	{
		ConexaoHSQLDB conn = new ConexaoHSQLDB();
		
		 Connection connection = conn.conectar();
		 
		 System.out.println(connection + "    " + "Conectado com sucesso");
		
		
		//  inserindo  
	 final String SQL_INSERT_PESSOA = "INSERT INTO  PESSOA (NOME,EMAIL) values (?,?)";
		 
		 PreparedStatement  pst;
		 
		 try {
			 
			 pst =  connection.prepareStatement(SQL_INSERT_PESSOA);
			 pst.setString(1,"aaaaa");
			 pst.setString(2,"aaaaa@lsuis.com ");
			  int qtde = pst.executeUpdate();
			  System.out.println("QTDE Inserida :" + qtde);
		     }
		 catch (SQLException e)
		 {
			 e.printStackTrace();
			 
		 }
		
	
	// listar pessoas
	
	final String SQL_SELECT_PESSOA  = "SELECT * FROM  PESSOA";
	
	 //PreparedStatement pst; 
	 
	 try {
		 
		 pst =  connection.prepareStatement(SQL_SELECT_PESSOA);
		ResultSet rs = pst.executeQuery();
				
				while (rs.next()) 
				
				{
					int  id = rs.getInt("ID"); 
					String  nome = rs.getString("NOME");
					String email = rs.getString("EMAIL");
				//	ID NOME , EMAIL 
					
					System.out.println(id  + " "  + nome  +  " " + "email");
				}
	 
	     }
	 catch (SQLException e)
	 {
		 e.printStackTrace();
		 
	 }
	
	 
	 // Fechando conexao 
	 try {
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
			
}
}