package com.entity;

import java.sql.Date;

public class Pessoa {

	private int  id ;

	private String  nome ;

	private String   email  ;

    private String choiceBoxSexo;
	
    private Date  datePickerId;
    
	//private String  textFieldData;
	
	private float textfieldPeso;
	
	
	//  Constructor Interface 


	/// constructor > BANCO 
	public Pessoa(int id, String nome, String email, String choiceBoxSexo, Date datePickerId, float textfieldPeso) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.choiceBoxSexo = choiceBoxSexo;
		this.datePickerId = datePickerId;
		this.textfieldPeso = textfieldPeso;
	}

	
	
	public Pessoa(String nome, String email, String choiceBoxSexo, Date datePickerId, float textfieldPeso) {
		super();
		this.nome = nome;
		this.email = email;
		this.choiceBoxSexo = choiceBoxSexo;
		this.datePickerId = datePickerId;
		this.textfieldPeso = textfieldPeso;
	}



	public Pessoa(int id, String nome, String email) {
		
		this.id = id;
		this.nome = nome;
		this.email = email;
	}



	public Pessoa(String nome, String email) {
		
		this.nome = nome;
		this.email = email;
	}

	


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getChoiceBoxSexo() {
		return choiceBoxSexo;
	}



	public void setChoiceBoxSexo(String choiceBoxSexo) {
		this.choiceBoxSexo = choiceBoxSexo;
	}



	public Date getdatePickerId() {
		return datePickerId;
	}



	public void setdatePickerId(Date datePickerId) {
		this.datePickerId = datePickerId;
	}



	public float getTextfieldPeso() {
		return textfieldPeso;
	}

	

	public String  getTextfieldPesoString() {
		return Float.toString(textfieldPeso);
	}



	public void setTextfieldPeso(float textfieldPeso) {
		this.textfieldPeso = textfieldPeso;
	}



	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((choiceBoxSexo == null) ? 0 : choiceBoxSexo.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((datePickerId == null) ? 0 : datePickerId.hashCode());
		result = prime * result + Float.floatToIntBits(textfieldPeso);
		return result;
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (choiceBoxSexo == null) {
			if (other.choiceBoxSexo != null)
				return false;
		} else if (!choiceBoxSexo.equals(other.choiceBoxSexo))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (datePickerId == null) {
			if (other.datePickerId != null)
				return false;
		} else if (!datePickerId.equals(other.datePickerId))
			return false;
		if (Float.floatToIntBits(textfieldPeso) != Float.floatToIntBits(other.textfieldPeso))
			return false;
		return true;
	}
	
	
	public Pessoa () 
	{
	
	}

/*

	public Pessoa(String nome, String email, String textFieldData, String choiceBoxSexo, float textfieldPeso) 
	{
		// TODO Auto-generated constructor stub
		
		
		this.nome = nome;
		this.email = email;
		this.choiceBoxSexo = choiceBoxSexo;
		this.textFieldData = textFieldData;
		this.textfieldPeso = textfieldPeso;
		
	}

	
	
/*

	public Pessoa(Integer valueOf,String nome, String email, String textFieldData, String choiceBoxSexo) {
		// TODO Auto-generated constructor stub
		
		this.nome = nome;
		this.email = email;
		this.choiceBoxSexo = choiceBoxSexo;
		this.textFieldData = textFieldData;
	
	}
*/



	public Pessoa(String nome, String email, Date datePickerId , String choiceBoxSexo, float textfieldPeso) {
		this.nome = nome;
		this.email = email;
		this.choiceBoxSexo = choiceBoxSexo;
		this.datePickerId = datePickerId;
		this.textfieldPeso = textfieldPeso;
	}



	@Override
	public String toString() {
		return "Pessoa [ID=" + id + ", NOME=" + nome + ", EMAIL=" + email + ", SEXO=" + choiceBoxSexo
				+ ", DATA =" + datePickerId + ", PESO=" + textfieldPeso + "]";
	}

	
	

}
