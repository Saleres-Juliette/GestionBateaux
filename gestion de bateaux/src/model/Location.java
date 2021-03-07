package model;

public class Location {
	private Bateau bateauloue;
	private String nomClient;
	private String duree;
	public Bateau getBateauloue() {
		return bateauloue;
	}
	public void setBateauloue(Bateau bateauloue) {
		this.bateauloue = bateauloue;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getDuree() {
		return duree;
	}
	public void setDuree(String duree) {
		this.duree = duree;
	}
	

	public void afficherInfosLocation() {
		System.out.print("-----------------------------------------"+"\n");
		System.out.print("Locations de bâteaux"+"\n");
		System.out.print("Le bateau " + this.getBateauloue().getNom() + " a été loué par "
				+ this.getNomClient()+ " pour une durée de "+ this.getDuree() + " minutes.");
	}


}
