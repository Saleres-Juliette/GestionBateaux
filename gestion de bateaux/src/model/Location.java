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
		System.out.print("Locations de b�teaux"+"\n");
		System.out.print("Le bateau " + this.getBateauloue().getNom() + " a �t� lou� par "
				+ this.getNomClient()+ " pour une dur�e de "+ this.getDuree() + " minutes.");
	}


}
