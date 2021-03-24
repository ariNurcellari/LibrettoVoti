package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti.model.Libretto;
import it.polito.tdp.librettovoti.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Libretto model;

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
    		txtResult.setText("L'esame inserito non è valido!!");
    	}
    	String votoEsame = txtVoto.getText() ;
    	int votoInt = Integer.parseInt(votoEsame) ;
    	String data = txtData.getText() ;
    	LocalDate date = LocalDate.parse(data) ;
    	
    	// TODO : FARE I VARI CONTROLLI
    	
    	// Esegui l'azione
    	
    	Voto voto = new Voto(nomeEsame, votoInt, date) ;
    	model.add(voto);
    	
    	// Aggiorna i dati(nella View)
    	txtResult.setText(model.toString());

    }
    
    public void setModel(Libretto model) {
    	this.model = model ;
    }

    @FXML
    void initialize() {
        assert txtEsame != null : "fx:id=\"txtEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoto != null : "fx:id=\"txtVoto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtData != null : "fx:id=\"txtData\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}