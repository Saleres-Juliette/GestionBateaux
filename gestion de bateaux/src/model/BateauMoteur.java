package model;

public class BateauMoteur extends Bateau {
	private String puissance;
	
	public String getPuissance() {
		return puissance;
	}

	public void setPuissance(String puissance) {
		this.puissance = puissance;
	}

	public String toString() {
		String chaine = super.toString();
		chaine = chaine + "C'est un bateau à moteur d'une puissance de " + this.getPuissance() + "."
		;
		return chaine;
	}
	
	public void demarrer() {
		System.out.print("Le bateau à moteur est prêt à naviguer \n");
	}

}