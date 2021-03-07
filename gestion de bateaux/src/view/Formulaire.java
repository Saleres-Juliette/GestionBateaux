/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import com.mongodb.client.MongoCollection;
import controller.BateauController;

/**
 * Classe Configuration de la fenetre d'affichage
 */
public class Formulaire extends javax.swing.JFrame {
    
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;

	private javax.swing.JTextArea jTextArea1;
    
    protected BateauController controller;
    /**
     * Creation nouveau Formulaire
     */
    public Formulaire(BateauController controller) {
        initComponents();
        
        this.controller = controller;
    }

    /**
     * Formatage des composants
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);        
        jButton1.setText("1. Creation Centres Nautiques");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        jButton2.setText("2. Affichage Centres Nautiques");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        // Créer automatiquement des espaces vides
        layout.setAutoCreateGaps(true); 
        // Créer automatiquement un conteneur des espaces vides
        layout.setAutoCreateContainerGaps(true); 
        
        // Sert à définir le groupe horizontal
        layout.setHorizontalGroup(layout.createSequentialGroup() 
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING) 		
        .addComponent(jTextArea1) 
        .addComponent(jButton1)
        .addComponent(jButton2)));  

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                		.addComponent(jButton1)
                		.addComponent(jButton2))     
        );
      
       // get the screen size as a java dimension
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height - 100;
        int width = screenSize.width / 2;

        // set the height and width
        this.setPreferredSize(new Dimension(width, height));
        this.setTitle("Centres Nautiques de Juliette");
        this.setResizable(true);
        this.setLocation(100, 60);
        
        pack();
    }

    // Execution de l'action du bouton1
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	controller.creerCentresNautiques();
    	jTextArea1.append("Centres créés" + "\n");   	       
   	 	System.out.println("Centres créés");
    }

    // Execution de l'action du bouton2
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        
    MongoCollection<Document> al = controller.afficherCentresNautiques();
  
  	List<Document> clist = al.find().into(new ArrayList<>());
        
   	 System.out.println("Liste des Centres nautiques ");
   	 	jTextArea1.setText("");
        
   	 	for (Document doc1 : clist) {
       	 System.out.println(doc1.get("IdCentre"));
    	 int id = (int)doc1.get("IdCentre");   	 
    	 String idCentre = String.valueOf(id);
    	 
    	 jTextArea1.append("\n" + "_______________________________________________________" + "\n");   	 
    	 jTextArea1.append("ID CENTRE : " + idCentre + "\n");
    	        	 
       	 System.out.println(doc1.get("nomCentre"));
       	 String nomcentre = (String)doc1.get("nomCentre");
    	 
    	 jTextArea1.append("NOM CENTRE : " + nomcentre + "\n");
    	 jTextArea1.append("_______________________________________________________" + "\n");
       	 
       	 ArrayList<Document> lb = (ArrayList<Document>)doc1.get("bateaux");
            for (Document doc2 : lb) {
              	 if(doc2.get("Puissance") != null)
              		// System.out.println(doc2.get("Immatriculation") + " - " + doc2.get("Marque") + " - " + doc2.get("Poids") + " kg - " + doc2.get("Nom") + " - " + doc2.get("Puissance"));
              	 	jTextArea1.append(doc2.get("Immatriculation") + " - " + doc2.get("Marque") + " - " + doc2.get("Poids") + " kg - " + doc2.get("Nom") + " - Puissance : " + doc2.get("Puissance") + "\n");
              	 else
               	 	jTextArea1.append(doc2.get("Immatriculation") + " - " + doc2.get("Marque") + " - " + doc2.get("Poids") + " kg - " + doc2.get("Nom") + "\n");
              		 // System.out.println(doc2.get("Immatriculation") + " - " + doc2.get("Marque") + " - " + doc2.get("Poids") + " kg - " + doc2.get("Nom"));
           	}
       	 
       	 System.out.println("_____________");
        }
    }
}
