package it.polito.tdp.librettovoti.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Libretto {

	private List<Voto> Voti ;
	private Map<String, Voto> votiMap ; // identity map -> oggetto Voto
	
	public Libretto() {
		this.Voti = new ArrayList<Voto>() ;
		this.votiMap = new LinkedHashMap<String, Voto>() ;
	}
	
	public void add(Voto v) {
		Voti.add(v);
		this.votiMap.put(v.getNome(), v) ;
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
	
	/**
	 * Verifica che nel libretto c'è gia un voto con lo stesso esame
	 * e la stessa votazione
	 * @param voto
	 * @return
	 */
	public boolean esisteDuplicato(Voto v) {
		/*boolean trovato = false ;
		for(Voto voto : Voti) {
			if(voto.getNome().equals(v.getNome()) && voto.getVoto() == v.getVoto())
				trovato = true ;
		}
		return trovato ;*/
		Voto voto = votiMap.get(v.getNome()) ;
		if( voto == null)
			return false ;
		if(voto.getVoto() == v.getVoto())
			return true ;
		else 
			return false ;
	}
	
	/**
	 * Verifica se nel libretto c'è già un voto con lo stesso
	 * votazione diversa.
	 * @param v
	 * @return
	 */
	public boolean esisteConflitto(Voto v) {
	/*	boolean trovato = false ;
		for(Voto voto : Voti) {
			if(voto.getNome().equals(v.getNome()) && voto.getVoto() != v.getVoto())
				trovato = true ;
		}
		return trovato ;
		*/
		Voto voto = votiMap.get(v.getNome()) ;
		if( voto == null)
			return false ;
		if(voto.getVoto() != v.getVoto())
			return true ;
		else 
			return false ;
	}

	public String toString() {
		String s = "" ;
		
		for(Voto voto : Voti) {
			s += voto.toString() + "\n" ;
		}
		return s ; 
	}
}