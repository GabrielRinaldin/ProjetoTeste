package view;


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;




public class ShowAlert {

		
		public void sucessoAlert(String message) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Sucesso");
			alert.setHeaderText(null);
			alert.setContentText(message);
			alert.showAndWait();
		}
		
		public void mensagemAlert() {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Logout");
			alert.setHeaderText(null);
			alert.setContentText("O sistema será encerrado!");
			alert.showAndWait();
		}
		
		public void erroAlert() {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro");
			alert.setHeaderText(null);
			alert.setContentText("Cliente não existe!");
			alert.showAndWait();
		}
		
		
		
		
		
	}

	
	
	
