/*
 * OperationFacade.java
 *
 * Created on 8 decembre 2006, 12:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package Facade;

import Classes.Metier;
import java.util.List;

import org.hibernate.Session;

public class MetierFacade {

    private Session session;

    public MetierFacade(Session session) {
        this.session = session;
    }
    /**
     * Création d'un métier 
     */  
    public void creer(Metier metier) {
        session.persist(metier);
    }
    /**
     * Modification d'un metier 
     */  
    public void modifier(Metier metier) {
        Metier entity = (Metier) session.merge(metier);
        session.persist(entity);
    }
    /**
     * Suppression d'un metier
     */  
    public void supprimer(Metier metier) {
        session.delete(metier);
    }
    /**
     * Suppression des metiers
     */  
    public List<Metier> lister() {
        return session.createQuery("from Metier").list();
    }
    /**
     * Recherche d'un metier par son identfiant
     */  
    public Metier litParId(Integer id) {
        try {
            return (Metier) session.createQuery("from Metier a where a.identifiant = :identifiant").setInteger("identifiant", id).uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }
}
