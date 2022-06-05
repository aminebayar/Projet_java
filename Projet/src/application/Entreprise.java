package application;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Entreprise {
	private String nomE ; 
 HashMap<Integer, Salarie> liste;
	public Entreprise() {
		liste = new HashMap();
	}
public Entreprise(String nomE) {
	super();
	this.nomE = nomE;
}
public String getNomE() {
	return nomE;
}
public void setNomE(String nomE) {
	this.nomE = nomE;
}

@Override
public String toString() {
	return "Entreprise [nomE=" + nomE + ", liste=" + liste + "]";
}
int getNBemployes() {

	return liste.size();
}
void affiche() {
	
	liste.forEach((key,value)->{
		System.out.println(key+" = "+value);
	});
	System.out.println("la taille de HashMap : "+ this.getNBemployes());

	

}

}
