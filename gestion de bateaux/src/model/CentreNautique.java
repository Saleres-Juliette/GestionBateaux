package model;

import java.util.LinkedList;

/**
 * Classe modele Centre Nautique
 */
public class CentreNautique {


	private LinkedList<Bateau> bateaux = new LinkedList<Bateau>();

	public LinkedList<Bateau> getBateaux() {
		return bateaux;
	}
	
	public void ajouter(Bateau b) {
		this.getBateaux().add(b);
	}
	
	public void supprimerBateau(Bateau b) {
		this.getBateaux().remove(b);
	}
	
	public void listingBateaux() {
		System.out.print("Listing des bâteaux du centre nautique"+"\n");
		System.out.print("-----------------------------------------"+"\n");
		for (Bateau b : this.getBateaux()) {
			b.afficherInfos();
		}
	}
	public int nbBateaux() {
		return this.getBateaux().size();
	}
	
	public void afficherInfos() {
		System.out.print("Le centre de bateaux de Luc sur Mer heberge " + this.nbBateaux() + " bateaux." + "\n");
	}
}
