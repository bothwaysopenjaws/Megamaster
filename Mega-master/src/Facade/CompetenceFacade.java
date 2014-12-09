/*
 * OperationFacade.java
 *
 * Created on 8 decembre 2006, 12:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package Facade;

import Classes.Competence;
import java.util.List;

import org.hibernate.Session;

public class CompetenceFacade {

    private Session session;

    public CompetenceFacade(Session session) {
        this.session = session;
    }
    /**
     * Ajout d'une competence à la BDD
     */  
    public void creer(Competence competence) {
        session.persist(competence);
    }
    /**
     * Modification d'une competence à la BDD
     */  
    public void modifier(Competence competence) {
        Competence entity = (Competence) session.merge(competence);
        session.persist(entity);
    }
    /**
     * Suppression d'une competence
     */  
    public void supprimer(Competence competence) {
        session.delete(competence);
    }
    /**
     * Liste des competences
     */  
    public List<Competence> lister() {
        return session.createQuery("from Competence").list();
    }


}
