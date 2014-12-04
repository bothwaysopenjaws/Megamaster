/*
 * OperationFacade.java
 *
 * Created on 8 decembre 2006, 12:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package Facade;

import Classes.Historique;
import java.util.List;

import org.hibernate.Session;

public class HistoriqueFacade {

    private Session session;

    public HistoriqueFacade(Session session) {
        this.session = session;
    }

    public void creer(Historique historique) {
        session.persist(historique);
    }

    public void modifier(Historique historique) {
        Historique entity = (Historique) session.merge(historique);
        session.persist(entity);
    }

    public void supprimer(Historique historique) {
        session.delete(historique);
    }

    public List<Historique> lister() {
        return session.createQuery("from Historique").list();
    }

    public Historique litParId(Integer id) {
        try {
            return (Historique) session.createQuery("from Historique a where a.identifiant = :identifiant").setInteger("identifiant", id).uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }
}
