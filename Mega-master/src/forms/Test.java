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
import java.util.Date;

/**
 *
 * @author msi
 */
public class Test {

    public static void main(String args[]) {
        Transaction tx = null;
        Session session = getSessionFactory().getCurrentSession();
        try {
            if (session.getTransaction() != null
                    && session.getTransaction().isActive()) {
                tx = session.getTransaction();
            } else {
                tx = session.beginTransaction();
            }
            

            Adresse adresse = new Adresse("4", "Rue des cerises", "LAVAL", "53000", "FRANGLETERRE");
            
         Date dateNaissance = new Date(1992, 11, 24);            
            ArtisteFacade artisteFacade = new ArtisteFacade(session);
            
            artisteFacade.creer(new Artiste("Jeanne", "Calman", dateNaissance, "JeanId", "Michelpwd", "jeanne@calmant", adresse));
            
            System.out.println("YES");

           
            
            
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
