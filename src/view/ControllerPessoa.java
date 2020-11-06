package view;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import com.entity.Pessoa;
import dao.PessoaDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import view.ShowAlert;

public class ControllerPessoa implements Initializable {

	   @FXML
	    private TextField textFieldNome;

	    @FXML
	    private TextField textFieldEmail;

	    @FXML
	    private Button btnInserir;

	    @FXML
	    private TextArea textAreaListPessoas;

	    @FXML
	    private TextField textFieldFIndID;

	    @FXML
	    private Label labelID;
	    
	    @FXML
	    private Label label_id;


	    @FXML
	    private Button Buscar;

	    
	    @FXML
	    private Button BtnDeletar;
	    

	    @FXML
	    private TextField textfieldPeso;

	    @FXML
	    private Label labelNascimento;

	    @FXML
	    private Label labelPeso;

	    @FXML
	    private Label labelSexo;

	    @FXML
	    private ChoiceBox<String> choiceBoxSexo;
	    
	    @FXML
	    private DatePicker datePickerId;
	    

///////////////////////////////////////////////////////////////////////////////////////////////////////////

	  // DELETAR PESSOA 
	    @FXML
	    void DeletaPessoa(ActionEvent event) {
	    	
	    	Pessoa pessoa = pegaDadosID();
	    	
	    	LimpaCampos() ;
	    	
	       int qtde  = new PessoaDAO().Deleta(pessoa);
	    	  
	    listarPessoas();
	   
	    	System.out.println(qtde);
	    }
	    
	    
	    
	    
	    
public boolean  confirmationAlert() 
	{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Excluir");
		alert.setHeaderText("Confirmação de Exclusão");
		alert.setContentText("Você tem certeza que deseja excluir:");
		
		Optional<ButtonType> result = alert.showAndWait();
		ButtonType button = result.orElse(ButtonType.CANCEL);

		if (button == ButtonType.OK) {
		    return true;
		} 
		
		return false;
	}
	
			

///////////////////////////////////////////////////////////////////////////////////////////////////////////	    
	    @FXML
	    private Button BtnAlterar;

	    /// ALTERAR  
	    @FXML
	    void AlterarPessoa(ActionEvent event) {

	    	Pessoa pessoa = pegaDadosID();
	    	LimpaCampos() ;
	    	
	       int qtde  = new PessoaDAO().Alterar(pessoa);
	    	  
	    listarPessoas();
	    	
	    	System.out.println(qtde);
	    	
	    }
	    
///////////////////////////////////////////////////////////////////////////////////////////////////////////	    
	    // BUSCAR PESSOA 
	    
	    @FXML
	    void buscarPessoa(ActionEvent event) {
	    
	    	String idString = textFieldFIndID.getText();
	    	Pessoa pessoa = null;
	    	
	    	if (!idString.equals("")) 
	    	{
	    		try  
	    	
	    		{
	    			int id = Integer.valueOf(idString);
	    			 pessoa = new PessoaDAO().findByID(id);
	    			
	    		}
	    		
	    		catch (Exception e)
	    		{
	    			
	    			
	    		}
	    		if (pessoa != null )
	    		{
	    			label_id.setVisible(true);
	    			labelID.setVisible(true);
	    			labelID.setText(pessoa.getId()+"");
	    			textFieldNome.setText(pessoa.getNome());
	    			textFieldEmail.setText(pessoa.getEmail());
	    			datePickerId.setValue(pessoa.getdatePickerId().toLocalDate());
	    			choiceBoxSexo.setValue(pessoa.getChoiceBoxSexo().toString());
	    			textfieldPeso.setText(pessoa.getTextfieldPesoString());
	    			
	    		}
	    		
	    	}
	    	
	    	textFieldFIndID.clear();
	    
	    }   
	    
///////////////////////////////////////////////////////////////////////////////////////////////////////////	
	    // INSERIR PESSOA 
	    
    @FXML
    void InserirPessoa(ActionEvent event) {
    Pessoa pessoa = pegaDados();
    LimpaCampos();
    int qtde  = new PessoaDAO ().inserir(pessoa);
   
    listarPessoas(); 
    sucessoAlert();
    System.out.println(qtde);
    
    }

    
    private void sucessoAlert() {
    	
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Sucesso");
		alert.setContentText("USUARIO CADASTRADO");
		alert.setHeaderText(null);
		alert.showAndWait();
	}


	private Pessoa  pegaDados() 
    {
     
		Pessoa pessoa = new Pessoa (textFieldNome.getText(),textFieldEmail.getText(),Date.valueOf(datePickerId.getValue()),
				choiceBoxSexo.getValue().toString(),Float.parseFloat(textfieldPeso.getText()));
      System.out.println(pessoa);
    	return pessoa;
    } 
    
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////   
    
    private Pessoa pegaDadosID() 
    {
    	Pessoa pessoa =  pegaDados();
    	pessoa.setId(Integer.valueOf(labelID.getText()));
    	
        return pessoa;
    	
    }
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    private void listarPessoas() 
    {
    	textAreaListPessoas.clear();
    	List <Pessoa> listapessoa = new PessoaDAO().listAll();
    	
    	listapessoa.forEach( pessoa -> {
    		
    		textAreaListPessoas.appendText(pessoa.toString() + "\n");
    		
    	});
    	
    	textAreaListPessoas.appendText("Listando um total de " + listapessoa.size() + " pessoas.");
		
    	
    	
    }
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    // Funções 
    private void LimpaCampos() 
    {
    	textFieldNome.clear();
    	textfieldPeso.clear();
    	textFieldEmail.clear();
    	datePickerId.setValue(null);
    	textFieldNome.requestFocus();	
    	label_id.setVisible(false);
		labelID.setVisible(false);
		//labelID.clear();
    }

    
    
    @FXML
    private Button Sair;

    @FXML
    void Exit(ActionEvent event) {

    	new ShowAlert().mensagemAlert();
    	
        
	    System.exit(0);
    	
    	
    }
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
 
    
    
    
    
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	 listarPessoas();
	 choiceBoxSexo.getItems().setAll("MASCULINO", "FEMININO"); 
		
	}
    
    
}
