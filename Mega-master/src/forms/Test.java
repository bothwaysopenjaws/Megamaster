/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import Classes.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Facade.*;
import static Hibernate.HibernateUtil.getSessionFactory;
import java.util.List;

/**
 *
 * @author msi
 */
public class Test {


    
    
    public static void main(String args[]) {
        
        LoadingFrame loadingFrame = new LoadingFrame();
        loadingFrame.setVisible(true);
        loadingFrame.ChangeStatementLabel("Connexion à la base de données...");        
       Transaction tx = null;
        Session session = getSessionFactory().getCurrentSession();
        try {
            if (session.getTransaction() != null
                    && session.getTransaction().isActive()) {
                tx = session.getTransaction();
            } else {
                
                tx = session.beginTransaction();
            }
            
            loadingFrame.ChangeStatementLabel("Connexion réussie...");
            loadingFrame.setVisible(false);
            
            Identification identification = new Identification();
            identification.setVisible(true);
          

//            Adresse adresse = new Adresse("4", "Rue des cerises", "LAVAL", "53000", "FRANGLETERRE");
//            
//         Date dateNaissance = new Date(1992, 11, 24);            
//            ArtisteFacade artisteFacade = new ArtisteFacade(session);
//            
//            artisteFacade.creer(new Artiste("Jeanne", "Calman", dateNaissance, "JeanId", "Michelpwd", "jeanne@calmant", adresse));
//            
//            System.out.println("YES");
//            
//            
//            
//           AdresseFacade adresseFacade = new AdresseFacade(session);
                
            
            //session.flush();
            tx.commit();

        } catch (Exception re) {
            
            re.printStackTrace();
            
       
            if (tx != null && tx.isActive()) {
                try {
                    tx.rollback();
                } catch (HibernateException he) {
                    he.printStackTrace();
                }
            }
        } 
    }
}
