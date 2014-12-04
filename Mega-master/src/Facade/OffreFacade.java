/*
 * OperationFacade.java
 *
 * Created on 8 decembre 2006, 12:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package Facade;

import Classes.Offre;
import java.util.List;

import org.hibernate.Session;

public class OffreFacade {

    private Session session;

    public OffreFacade(Session session) {
        this.session = session;
    }

    public void creer(Offre offre) {
        session.persist(offre);
    }

    public void modifier(Offre offre) {
        Offre entity = (Offre) session.merge(offre);
        session.persist(entity);
    }

    public void supprimer(Offre offre) {
        session.delete(offre);
    }

    public List<Offre> lister() {
        return session.createQuery("from Offre").list();
    }

    public Offre litParId(Integer id) {
        try {
            return (Offre) session.createQuery("from Offre a where a.identifiant = :identifiant").setInteger("identifiant", id).uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }
}
