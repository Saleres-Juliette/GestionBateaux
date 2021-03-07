/**
 * 
 */
package db;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import model.Bateau;
import model.BateauMoteur;
import model.Catamaran;
import model.Optimiste;
import model.Yatch;

import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe d'acces a la base de données MongoDB.
 */
public class BateauJsonMongoDB {

    private static final Random rand = new Random();
    
 	public static void main(String[] args) {

		try { 	       
 	       // insererCentresNautiques(); 	       
 	       // RecupererCentresEtBateaux();
          
		} catch(Exception e){
 	       System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
	}

	// Insertion plusieurs centres nautiques
	public static void insererCentresNautiques() {
		//Connexion à la base
		MongoClient mongoClient = new MongoClient( "localhost" , 27017);
	    MongoDatabase BateauDB = mongoClient.getDatabase("bateau");
	    MongoCollection<Document> CentreNautiqueCollection = BateauDB.getCollection("CentresNautiquesCollection");
		
	    //Insertion du 1er centre nautique
		int centreid = rand.nextInt(100);
    	List<Bateau> lb1 = CreerListeBateaux1();
		CentreNautiqueCollection.insertOne(genererNouveauCentre(centreid, "CENTRE NAUTIQUE D'ANNECY", lb1));
        System.out.println("Un Centre a été créé Id : " + centreid);
        
	    //Insertion du 2e centre nautique
        centreid = rand.nextInt(100);
    	List<Bateau> lb2 = CreerListeBateaux2();        
		CentreNautiqueCollection.insertOne(genererNouveauCentre(centreid, "CENTRE NAUTIQUE LAC DU BOURGET", lb2));
        System.out.println("Un Centre a été créé Id : " + centreid);
        
	    //Insertion du 3e centre nautique
        centreid = rand.nextInt(100);
    	List<Bateau> lb3 = CreerListeBateaux3();        
		CentreNautiqueCollection.insertOne(genererNouveauCentre(centreid, "CENTRE NAUTIQUE EVIAN", lb3));
        System.out.println("Un Centre a été créé Id : " + centreid);
        
    }
	   
    
    // Generation du Centre Nautique et de ses bateaux
    private static Document genererNouveauCentre(int IdCentre, String nomCentre, List lb) {
    	
    	List<Bateau> listbateaux = lb;
    	
    	List<Document> bateaux= new ArrayList<Document>();
    	
    	for (int i = 0; i < listbateaux.size(); i++) {
    		Bateau b = listbateaux.get(i);
 
    		Document doc = new Document("Immatriculation", b.getNumImat())
			.append("Poids", b.getPoids())
			.append("Nom", b.getNom())
			.append("Marque", b.getMarque());
			
    		if(b instanceof BateauMoteur)
    			doc.append("Puissance", ((BateauMoteur) b).getPuissance());
    	
    		bateaux.add(doc);	
    	}
        
        return new Document("_id", new ObjectId()).append("IdCentre", IdCentre)
                                                  .append("nomCentre", nomCentre)
                                                  .append("bateaux", bateaux);
    }
    
 
    // Genere la liste des bateaux pour le centre 1
    public static List CreerListeBateaux1() {
    	
    	ArrayList<Bateau> bateaux = new ArrayList<Bateau>();
    	
    	Bateau opt1 = new Optimiste("OPT-123-LSM","90","Optimist 123","SailQube");
    	bateaux.add(opt1);
    	BateauMoteur yac1 = new Yatch("YAC-388-LSM","1250","Yacht 388","Prestige");
    	yac1.setPuissance("66 cv");
    	bateaux.add(yac1);
    	BateauMoteur yac2 = new Yatch("YAC-980-LSM","1250","Yacht 980","Prestige");
    	yac2.setPuissance("899 cv");
    	bateaux.add(yac2);
    	
    	Bateau cat1 = new Catamaran("CAT-100-LSM","420","Yacht 100","Slyder");
    	bateaux.add(cat1);
    	
    	System.out.println(bateaux.size() + " bateaux créés");
    	
    	return bateaux;
    }
    
    // Genere la liste des bateaux pour le centre 2
    public static List CreerListeBateaux2() {
    	
    	ArrayList<Bateau> bateaux = new ArrayList<Bateau>();
    	
    	Bateau opt1 = new Optimiste("OPT-844-LSM","90","Optimist 844","SailQube");
    	bateaux.add(opt1);
      	BateauMoteur yac3 = new Yatch("YAC-555-LSM","655","Yacht 555","Prestige");
    	yac3.setPuissance("78 cv");
    	bateaux.add(yac3);
    	
    	Bateau cat2 = new Catamaran("CAT-650-LSM","350","Yacht 650","Catana");
    	bateaux.add(cat2);

    	System.out.println(bateaux.size() + " bateaux créés");

    	return bateaux;
    }
     
    // Genere la liste des bateaux pour le centre 3
    public static List CreerListeBateaux3() {
    	
    	ArrayList<Bateau> bateaux = new ArrayList<Bateau>();
    	   	
    	Bateau cat1 = new Catamaran("CAT-921-LSM","350","Yacht 921","Cataone");
    	bateaux.add(cat1);
    	Bateau cat2 = new Catamaran("CAT-007-LSM","350","Yacht 007","CataTop");
    	bateaux.add(cat2);
    	
    	System.out.println(bateaux.size() + " bateaux créés");

    	return bateaux;
    }
    
    // Ouverture Connexion a la base MongoDB
    public static MongoCollection<Document> RecupererCentresEtBateaux() {
	     MongoClient mongoClient = new MongoClient( "localhost" , 27017);
	     MongoDatabase BateauDB = mongoClient.getDatabase("bateau");
	     MongoCollection<Document> CentreNautiqueCollection = BateauDB.getCollection("CentresNautiquesCollection");
	     
	     System.out.println("Objet collection contenant Centres nautiques : " + CentreNautiqueCollection.toString());

         return CentreNautiqueCollection;
    }

}
