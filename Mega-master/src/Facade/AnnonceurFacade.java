/*
 * OperationFacade.java
 *
 * Created on 8 decembre 2006, 12:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package Facade;

import Classes.Annonceur;
import java.util.List;

import org.hibernate.Session;

public class AnnonceurFacade {

    private Session session;

    public AnnonceurFacade(Session session) {
        this.session = session;
    }

    public void creer(Annonceur annonceur) {
        session.persist(annonceur);
    }

    public void modifier(Annonceur annonceur) {
        Annonceur entity = (Annonceur) session.merge(annonceur);
        session.persist(entity);
    }

    public void supprimer(Annonceur annonceur) {
        session.delete(annonceur);
    }

    public List<Annonceur> lister() {
        return session.createQuery("from Annonceur").list();
    }

    public Annonceur litParId(Integer id) {
        try {
            return (Annonceur) session.createQuery("from Annonceur a where a.identifiant = :identifiant").setInteger("identifiant", id).uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }
}
