/*
 * OperationFacade.java
 *
 * Created on 8 decembre 2006, 12:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package Facade;

import Classes.Contrat;
import java.util.List;

import org.hibernate.Session;

public class ContratFacade {

    private Session session;

    public ContratFacade(Session session) {
        this.session = session;
    }

    public void creer(Contrat contrat) {
        session.persist(contrat);
    }

    public void modifier(Contrat contrat) {
        Contrat entity = (Contrat) session.merge(contrat);
        session.persist(entity);
    }

    public void supprimer(Contrat contrat) {
        session.delete(contrat);
    }

    public List<Contrat> lister() {
        return session.createQuery("from Contrat").list();
    }

    public Contrat litParId(Integer id) {
        try {
            return (Contrat) session.createQuery("from Contrat a where a.identifiant = :identifiant").setInteger("identifiant", id).uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }
}
