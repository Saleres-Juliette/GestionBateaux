package model;
public class Catamaran extends BateauVoile {

	// Constructeur
	public Catamaran(String ni, String p, String n, String m){
		this.setNumImat(ni);
		this.setPoids(p);
		this.setNom(n);
		this.setMarque(m);
	}

	
	public String toString() {
		String chaine = super.toString();
		chaine = chaine + ". C'est un catamaran prêt à la navigation.";
		return chaine;
	}
	
	public void demarrer() {
		System.out.print("Le catamaran est prêt à naviguer \n");
	}
	
	
}

