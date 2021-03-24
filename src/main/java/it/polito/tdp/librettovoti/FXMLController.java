package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti.model.Libretto;
import it.polito.tdp.librettovoti.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Libretto model;
	
    @FXML
    private DatePicker datePicker;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtEsame;

    @FXML
    private TextField txtVoto;

    @FXML
    private TextField txtData;

    @FXML
    private TextArea txtResult;

    @FXML
    void handleInserisci(ActionEvent event) {
    	// Leggi e controlla i dati
    	String nomeEsame = txtEsame.getText();
    	if(nomeEsame.length() == 0) {
    		txtResult.setText("ERRORE : Nome esame vuoto!");
    		return ; 
    	}
    	String votoEsame = txtVoto.getText() ;
    	int votoInt = 0;
    	try {
    		votoInt = Integer.parseInt(votoEsame) ;
			
		} catch (NumberFormatException e) {
			txtResult.setText("ERRORE : Il voto deve essere numerico!");
			return ;
		}
    	if( votoInt < 18 || votoInt > 30) {
			txtResult.setText("ERRORE : Il voto deve essere compreso tra 18 e 30!");
			return ;

    	}
    /*	String data = txtData.getText() ;
    	LocalDate date  ;
    	try {
    		date = LocalDate.parse(data) ;
    	} catch(DateTimeParseException e){
    		txtResult.setText("ERRORE : La data non è nel formato corretto!");
			return ;

    	}*/
    	LocalDate date = datePicker.getValue() ;
    	if(date == null) {
    		txtResult.setText("ERRORE : La data è errata o mancante !");
			return ;
    	}
    	
    	// Esegui l'azione
    	
    	Voto voto = new Voto(nomeEsame, votoInt, date) ;
    	model.add(voto);
    	
    	// Aggiorna i dati(nella View)
    	txtResult.setText(model.toString());
    	txtData.clear();
    	txtVoto.clear();
    	//txtEsame.clear();
    	datePicker.setValue(null);

    }
    
    public void setModel(Libretto model) {
    	this.model = model ;
    }

    @FXML
    void initialize() {
        assert txtEsame != null : "fx:id=\"txtEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoto != null : "fx:id=\"txtVoto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert datePicker != null : "fx:id=\"datePicker\" was not injected: check your FXML file 'Scene.fxml'.";
        //assert txtData != null : "fx:id=\"txtData\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}