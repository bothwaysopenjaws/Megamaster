/*
 * OperationFacade.java
 *
 * Created on 8 decembre 2006, 12:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package Facade;

import Classes.Compagnie;
import java.util.List;

import org.hibernate.Session;

public class CompagnieFacade {

    private Session session;

    public CompagnieFacade(Session session) {
        this.session = session;
    }

    public void creer(Compagnie compagnie) {
        session.persist(compagnie);
    }

    public void modifier(Compagnie compagnie) {
        Compagnie entity = (Compagnie) session.merge(compagnie);
        session.persist(entity);
    }

    public void supprimer(Compagnie compagnie) {
        session.delete(compagnie);
    }

    public List<Compagnie> lister() {
        return session.createQuery("from Compagnie").list();
    }

    public Compagnie litParId(Integer id) {
        try {
            return (Compagnie) session.createQuery("from Compagnie a where a.identifiant = :identifiant").setInteger("identifiant", id).uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }
}
