package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;


// POJO - Plain Old Java Object
// Java Bean
// Semplice contenitore dati -- non ha 'logica'

/**
 * Memorizza risultato esame singolo
 * 
 * @author ari
 *
 */


public class Voto {
	private String nome ;
	private int voto ; // 30L come lo rappresento?
	private LocalDate data ; // data superamwnto esame 
	
	/**
	 * 
	 * @param nome Nome del corso superato
	 * @param voto Voto ottenuto
	 * @param data Data dell'esame superato
	 */
	
	public Voto(String nome, int voto, LocalDate data) {
		super();
		this.nome = nome;
		this.voto = voto;
		this.data = data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Esame " + nome + " Superato con " + voto + " il " + data;
	}
}
