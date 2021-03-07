package model;

public class BateauVoile extends Bateau {
	
	
	public String toString() {
		String chaine = super.toString();
		chaine = chaine + " C'est un bateau qui a " + this.getVoiles().size() + " voiles";
		return chaine;
	}
	
	
	
	public void demarrer() {
		System.out.print("Le bateau à voile est prêt à naviguer \n");
	}

}
