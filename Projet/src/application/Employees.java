package application;

public class Employees extends Salarie {
	private double Hsupp;
	private double PHsupp;

public Employees(int matricule, String nom, String email, double annee, double salaire,String categorie,double Hsupp,double PHsupp) {
		super(matricule, nom, email, annee,salaire,categorie);
		this.Hsupp=Hsupp;
		this.PHsupp=Hsupp;
		
	}

public double getHsupp() {
	return Hsupp;
}

public void setHsupp(double hsupp) {
	Hsupp = hsupp;
}

public double getPHsupp() {
	return PHsupp;
}

public void setPHsupp(double pHsupp) {
	PHsupp = pHsupp;
}

	
	
}
