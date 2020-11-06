package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.db.ConexaoHSQLDB;
import com.entity.Pessoa;

public class PessoaDAO extends ConexaoHSQLDB {
	
	final String SQL_INSERT_PESSOA = "INSERT INTO  PESSOA (NOME,EMAIL,DATA,SEXO,PESO) values (?,?,?,?,?)";
	final String SQL_SELECT_PESSOA  = "SELECT * FROM  PESSOA";
	final String SQL_SELECT_PESSOA_ID  = "SELECT * FROM  PESSOA WHERE ID = ? ";
	final String SQL_SELECT_ALTERA_PESSOA  = "UPDATE PESSOA SET NOME =?,EMAIL =?,DATA =?,SEXO =?,PESO =?  WHERE ID = ? " ;
	final String SQL_DELETA_REGISTRO  = "DELETE FROM  PESSOA WHERE ID = ? ";
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	// INSERIR OK
	public int inserir (Pessoa pessoa ) 

	{
		
		int qtde  =0;
		
		 
		 try (Connection  connection = this.conectar();
			PreparedStatement  pst =  connection.prepareStatement(SQL_INSERT_PESSOA);){
			 
	
			 pst.setString(1,pessoa.getNome());
			 pst.setString(2,pessoa.getEmail());
			 pst.setDate(3,pessoa.getdatePickerId());
			 pst.setString(4,pessoa.getChoiceBoxSexo());
			 pst.setFloat(5,pessoa.getTextfieldPeso());
		
			  qtde = pst.executeUpdate();
			  System.out.println("QTDE Inserida :" + qtde);
		     }
		 catch (SQLException e)
		 {
			 e.printStackTrace();
			 
		 }
		
		 return qtde;
		
	}
	
	
	
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// LISTAR PESSOA 
	    public List<Pessoa> listAll(){
	
		List<Pessoa> listaPessoas= new ArrayList<Pessoa>(); 
	 
	 try (Connection  connection = this.conectar();
		PreparedStatement  pst =  connection.prepareStatement(SQL_SELECT_PESSOA);) {
		 
		 
		ResultSet rs = pst.executeQuery();
				
				while (rs.next()) 
				
				{
					Pessoa pessoa = new Pessoa ();
					pessoa.setId(rs.getInt("id")); 
					pessoa.setNome(rs.getString("nome"));
					pessoa.setEmail(rs.getString("email"));
					pessoa.setdatePickerId(rs.getDate("data"));
					pessoa.setChoiceBoxSexo(rs.getString("sexo"));
					pessoa.setTextfieldPeso(rs.getFloat("peso"));
			
					listaPessoas.add(pessoa);
				}
	 
	     }
	 catch (SQLException e)
	 {
		 e.printStackTrace();
		 
	 }
	 
	 return listaPessoas;
	 
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////
	    
	    // PROCURA POR ID 
		public Pessoa findByID(int id) {
			Pessoa pessoa = null;
		
			try (Connection  connection = this.conectar();
					PreparedStatement  pst =  connection.prepareStatement(SQL_SELECT_PESSOA_ID);) {
					 
					 pst.setInt(1, id);
					ResultSet rs = pst.executeQuery();
							
							while (rs.next()) 
							
							{
								pessoa = new Pessoa();
								pessoa.setId(rs.getInt("id")); 
								pessoa.setNome(rs.getString("nome"));
								pessoa.setEmail(rs.getString("email"));
								pessoa.setdatePickerId(rs.getDate("data"));
								pessoa.setChoiceBoxSexo(rs.getString("sexo"));
								pessoa.setTextfieldPeso(rs.getFloat("peso"));
						
						
							
							}
				 
				     }
				 catch (SQLException e)
				 {
					 e.printStackTrace();
					 
				 }
			return pessoa;
			
				
		}

		
///////////////////////////////////////////////////////////////////////////////////////////////////////////
		// ALTERAR 
		public int Alterar(Pessoa pessoa) {
			

			int qtde  =0;
			
			 
			 try (Connection  connection = this.conectar();
				PreparedStatement  pst =  connection.prepareStatement(SQL_SELECT_ALTERA_PESSOA);){
				 
		
				 pst.setString(1,pessoa.getNome());
				 pst.setString(2,pessoa.getEmail());
				 pst.setDate(3,pessoa.getdatePickerId());
				 pst.setString(4,pessoa.getChoiceBoxSexo());
				 pst.setFloat(5,pessoa.getTextfieldPeso());
				 pst.setInt(6,pessoa.getId());
			
				 
				  qtde = pst.executeUpdate();
				  System.out.println("QTDE Inserida :" + qtde);
			     }
			 catch (SQLException e)
			 {
				 e.printStackTrace();
				 
			 }
			
			 return qtde;
			
		}

///////////////////////////////////////////////////////////////////////////////////////////////////////////
		// DELETAR 
		public int Deleta(Pessoa pessoa) {

			
			
			 
			 try (Connection  connection = this.conectar();
				PreparedStatement  pst =  connection.prepareStatement(SQL_DELETA_REGISTRO);){
				
				 pst.setInt(1,pessoa.getId());
				 pst.execute();
				  
			     }
			 catch (SQLException e)
			 {
				 e.printStackTrace();
				 
			 }
			return 0;
			
			
		}
		

}
