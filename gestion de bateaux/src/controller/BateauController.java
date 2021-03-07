package controller;

import org.bson.Document;
import com.mongodb.client.MongoCollection;
import db.BateauJsonMongoDB;
 
/**
* Classe Controleur de la pattern MVC pour appeler les routes
*/
public class BateauController {
    
    private MongoCollection<Document> centresetbateaux;
    
    // Controleur pour afficher les centres nautiques
    public MongoCollection<Document> afficherCentresNautiques() {
    	
    	BateauJsonMongoDB bjm = new BateauJsonMongoDB();
    	centresetbateaux = bjm.RecupererCentresEtBateaux();
    	return centresetbateaux;
    }
    
    // Controleur pour creer un centre nautique
    public void creerCentresNautiques() {
    	
    	BateauJsonMongoDB bjm = new BateauJsonMongoDB();
    	bjm.insererCentresNautiques();
    }
    
}

