/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import Classes.Adresse;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Facade.*;
import static Hibernate.HibernateUtil.getSessionFactory;

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
            
            AdresseFacade adresseFacade = new AdresseFacade(session);
            adresseFacade.creer(new Adresse("4", "Rue des cerises", "LAVAL", "53000", "FRANGLETERRE"));
            
            System.out.println("YES");

            Adresse adresse = adresseFacade.litParId(2);
            System.out.println("voilà" + adresse.getVille());
            
            
            
            
            
            
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
