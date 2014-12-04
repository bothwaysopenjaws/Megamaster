/*
 * OperationFacade.java
 *
 * Created on 8 decembre 2006, 12:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package Facade;

import Classes.Abonnement;
import java.util.List;

import org.hibernate.Session;

public class AbonnementFacade {

    private Session session;

    public AbonnementFacade(Session session) {
        this.session = session;
    }

    public void creer(Abonnement abonnement) {
        session.persist(abonnement);
    }

    public void modifier(Abonnement abonnement) {
        Abonnement entity = (Abonnement) session.merge(abonnement);
        session.persist(entity);
    }

    public void supprimer(Abonnement abonnement) {
        session.delete(abonnement);
    }

    public List<Abonnement> lister() {
        return session.createQuery("from Abonnement").list();
    }

    public Abonnement litParId(Integer id) {
        try {
            return (Abonnement) session.createQuery("from Abonnement a where a.identifiant = :identifiant").setInteger("identifiant", id).uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }
    public Abonnement derniereInsertion() {
        try {
            return (Abonnement) session.createQuery("from Abonnement a where a.identifiant = max(Abonnement.identifiant)").uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }    
}
