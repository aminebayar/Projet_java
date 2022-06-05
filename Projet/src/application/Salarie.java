package application;

public class Salarie {
 private int Matricule ; 
 private String Nom ; 
 private String Email ; 
 private double Annee ;
 private double Salaire ; 
 private String categorie ; 

public Salarie(int matricule, String nom, String email, double annee , double salaire, String Categorie ) {
	super();
	Matricule = matricule;
	Nom = nom;
	Email = email;
	Annee = annee;
	Salaire=salaire;
	categorie=Categorie;

}
 
public Salarie() {
	// TODO Auto-generated constructor stub
}

public String getCategorie() {
	return categorie;
}

public void setCategorie(String categorie) {
	this.categorie = categorie;
}

public int getMatricule() {
	return Matricule;
}
public void setMatricule(int matricule) {
	Matricule = matricule;
}
public String getNom() {
	return Nom;
}
public void setNom(String nom) {
	Nom = nom;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public double getAnnee() {
	return Annee;
}
public void setAnnee(double annee) {
	Annee = annee;
}

public double getSalaire() {
	return Salaire;
}

public void setSalaire(double salaire) {
	Salaire = salaire;
}
public void CalaculSal(double salEmp) {
	if (this.getAnnee()<2005) {
		salEmp=400;
	}else {
		salEmp=280;

	}
}
@Override
public String toString() {
	return "Salarie [Matricule=" + Matricule + ", Nom=" + Nom + ", Email=" + Email + ", Annee=" + Annee + ", Salaire=" + Salaire + ", categorie=" + categorie + "]";
} 


}
