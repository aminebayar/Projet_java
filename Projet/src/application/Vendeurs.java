package application;

public class Vendeurs extends Salarie {
	private double Vente ; 
	private double Pourcentage ; 

public Vendeurs(int matricule, String nom, String email, double annee, double salaire, String categorie ,double Vente , double Pourcentage ) {
		super(matricule, nom, email, annee,salaire,categorie);
		this.Vente=Vente;
		this.Pourcentage=Pourcentage;
	}

public double getVente() {
	return Vente;
}

public void setVente(double vente) {
	Vente = vente;
}

public double getPourcentage() {
	return Pourcentage;
}

public void setPourcentage(double pourcentage) {
	Pourcentage = pourcentage;
}

}
