package it.polito.tdp.librettovoti.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Libretto {

	private List<Voto> Voti ;
	
	public Libretto() {
		Voti = new ArrayList<Voto>() ;
	}
	
	public void add(Voto v) {
		Voti.add(v);
	}
	/*
	public void stampaVotiUguali(int punteggio) {
		// il libretto stampa da solo i voti
		System.out.println();
	}
	
	public String votiUguali(int punteggio) {
		// calcola una stringa che contiene i voti
		// sarà poi il chiamante a stamparli
	}
	
	public List<Voto> votiUguali2(int punteggio){
		// calcola una stringa che contiene i voti 
		// sarà poi il chiamante a stamparli
		// -> solo il NOME?
		// -> Tutto il voto.toString() ??
	}
	*/
	
	public List<Voto> listaVotiUguali(int punteggio) {
		List<Voto> risultatoList = new ArrayList<Voto>() ;
		for(Voto v: this.Voti) {
			if(v.getVoto() == punteggio)
				risultatoList.add(v) ;
		}
		return risultatoList ;
	}
	
	public Libretto votiUguali(int punteggio) {
		Libretto risultato = new Libretto();
		for(Voto v: this.Voti) {
			if(v.getVoto() == punteggio)
			risultato.add(v) ;
		}
		return risultato ;
	}
	/**
	 * Ricerca un Voto del corso di cui è specificato il nome 
	 * Se il corso non esiste, restituisce null.
	 * @param nomeCorso
	 * @return
	 */
	public Voto cercaCorso(String nomeCorso) {
		Voto risultato = null ;
		for(Voto voto : this.Voti) {
			if(voto.getNome().equals(nomeCorso)) {
				risultato = voto ;
				break ;
			}
		}
		return risultato;
	}

	public String toString() {
		String s = "" ;
		
		for(Voto voto : Voti) {
			s += voto.toString() + "\n" ;
		}
		return s ; 
	}
}