package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;

public class TestLibretto {
	
	public static void main(String [] args) {
		
		System.out.println("Test metodi di Libretto");
		Libretto libretto = new Libretto();
		
		Voto voto1 = new Voto("Analisi 1", 30, LocalDate.of(2019, 2, 15)) ;
		
		libretto.add(voto1) ;
		
		Voto voto2 = new Voto("Fisica 1", 28, LocalDate.of(2019, 7, 15)) ;
		Voto voto3 = new Voto("Informatica", 24, LocalDate.of(2019, 9, 15)) ;
		libretto.add(voto2) ;
		libretto.add(voto3) ;
		
		System.out.println(libretto);
		
	}
	
}
