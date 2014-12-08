/*
 * OperationFacade.java
 *
 * Created on 8 decembre 2006, 12:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package Facade;

import Classes.Adresse;
import java.util.List;

import org.hibernate.Session;

public class AdresseFacade {

    private Session session;

    public AdresseFacade(Session session) {
        this.session = session;
    }

    public void creer(Adresse adresse) {
        session.persist(adresse);
    }

    public void modifier(Adresse adresse) {
        Adresse entity = (Adresse) session.merge(adresse);
        session.persist(entity);
    }

    public void supprimer(Adresse adresse) {
        session.delete(adresse);
    }

    public List<Adresse> lister() {
        return session.createQuery("from Adresse").list();
    }

    public Adresse litParId(Integer id) {
        try {
            return (Adresse) session.createQuery("from Adresse a where a.identifiant = :identifiant").setInteger("identifiant", id).uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }
    public Adresse derniereInsertion() {
        try {
            return (Adresse) session.createQuery("SELECT from ADRESSE a where a.identifiant = MAX(ADRESSE.identifiant)").uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }       
    
    
}
