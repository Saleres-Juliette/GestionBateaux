package model;

import java.util.LinkedList;

/**
 * Classe modele mere
 */
public abstract class Bateau {

		private String numImat;
		private String poids;
		private String nom;
		private String marque;
		private Boolean loue;

		// Constructeur
		public Bateau(String ni, String p, String n, String m){
			this.numImat = ni;
			this.poids=p;
			this.nom=n;
			this.marque=m;
		}
		
		public Boolean getLoue() {
			return loue;
		}

		public void setLoue(Boolean loue) {
			this.loue = loue;
		}

		private CentreNautique centrenautique;
		
		
		public String getPoids() {
			return poids;
		}

		public void setPoids(String poids) {
			this.poids = poids;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getMarque() {
			return marque;
		}

		public void setMarque(String marque) {
			this.marque = marque;
		}

		public CentreNautique getCentrenautique() {
			return centrenautique;
		}

		public void setCentrenautique(CentreNautique centrenautique) {
			this.centrenautique = centrenautique;
		}

		public String getNumImat() {
			return numImat;
		}

		public void setNumImat(String numImat) {
			this.numImat = numImat;
		}
		
		
		//1 bateau à voile peut avoir plusieurs voiles
		
		private LinkedList<Voile> voiles = new LinkedList<Voile>();

		public LinkedList<Voile> getVoiles() {
			return voiles;
		}
		
		public void hisserVoile(Voile b) {
			this.getVoiles().add(b);
		}
		
		public Bateau() {
			super(); // 1. execution du constructeur de la classe Object
		}
		
		
		
		public String toString() {
			String str = "Bateau immatriculé " + this.getNumImat() + " nommé " + this.getNom() +
					" de marque " + this.getMarque();
			str = str +  " ayant un poids de " + this.getPoids() + " poids.";
			
			return str;
		}
		
		
		public void afficherInfos() {
			System.out.print(this.toString() + "\n");
		}

	

		public abstract void demarrer();
	}



