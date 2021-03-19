package it.polito.tdp.librettovoti.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.sun.javafx.geom.AreaOp.AddOp;

public class Libretto {

	private List<Voto> Voti ;
	
	public Libretto() {
		Voti = new ArrayList<Voto>() ;
	}
	
	public void add(Voto v) {
		Voti.add(v);
	}
	
	public String toString() {
		String s = "" ;
		
		for(Voto voto : Voti) {
			s += voto.toString() + "\n" ;
		}
		return s ; 
	}
}
