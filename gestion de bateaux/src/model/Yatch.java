package model;

public class Yatch extends BateauMoteur{
	
	// Constructeur
	public Yatch(String ni, String p, String n, String m){
		super();
		this.setNumImat(ni);
		this.setPoids(p);
		this.setNom(n);
		this.setMarque(m);
	}
	
	public String toString() {
		String chaine = super.toString();
		chaine = chaine + " C'est un yatch prêt à la navigation.";
		return chaine;
	}
	
	public void demarrer() {
		System.out.print(" C'est un yatch prêt à naviguer \n");
	}

}
