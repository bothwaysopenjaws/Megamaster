/*
 * OperationFacade.java
 *
 * Created on 8 decembre 2006, 12:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package Facade;

import Classes.Candidature;
import java.util.List;

import org.hibernate.Session;

public class CompetenceFacade {

    private Session session;

    public CompetenceFacade(Session session) {
        this.session = session;
    }

    public void creer(Candidature candidature) {
        session.persist(candidature);
    }

    public void modifier(Candidature candidature) {
        Candidature entity = (Candidature) session.merge(candidature);
        session.persist(entity);
    }

    public void supprimer(Candidature candidature) {
        session.delete(candidature);
    }

    public List<Candidature> lister() {
        return session.createQuery("from Candidature").list();
    }

    public Candidature litParId(Integer id) {
        try {
            return (Candidature) session.createQuery("from Candidature a where a.identifiant = :identifiant").setInteger("identifiant", id).uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }
}
