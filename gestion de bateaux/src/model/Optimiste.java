package model;
public class Optimiste extends BateauVoile {
	
	// Constructeur
	public Optimiste(String ni, String p, String n, String m){
		this.setNumImat(ni);
		this.setPoids(p);
		this.setNom(n);
		this.setMarque(m);
	}

	
	public String toString() {
		String chaine = super.toString();
		chaine = chaine + ". C'est un optimiste pr�t � la navigation.";
		return chaine;
	}
	
	public void demarrer() {
		System.out.print("L'optimiste est pr�t � naviguer \n");
	}
	
}

