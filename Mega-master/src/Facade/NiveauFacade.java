/*
 * OperationFacade.java
 *
 * Created on 8 decembre 2006, 12:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package Facade;

import Classes.Niveau;
import java.util.List;

import org.hibernate.Session;

public class NiveauFacade {

    private Session session;

    public NiveauFacade(Session session) {
        this.session = session;
    }

    public void creer(Niveau niveau) {
        session.persist(niveau);
    }

    public void modifier(Niveau niveau) {
        Niveau entity = (Niveau) session.merge(niveau);
        session.persist(entity);
    }

    public void supprimer(Niveau niveau) {
        session.delete(niveau);
    }

    public List<Niveau> lister() {
        return session.createQuery("from Niveau").list();
    }

    public Niveau litParId(Integer id) {
        try {
            return (Niveau) session.createQuery("from Niveau a where a.identifiant = :identifiant").setInteger("identifiant", id).uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }
}
