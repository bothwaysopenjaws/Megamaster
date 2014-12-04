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

public class DiffuseurFacade {

    private Session session;

    public DiffuseurFacade(Session session) {
        this.session = session;
    }

    public void creer(Contrat adresse) {
        session.persist(adresse);
    }

    public void modifier(Contrat adresse) {
        Contrat entity = (Contrat) session.merge(adresse);
        session.persist(entity);
    }

    public void supprimer(Contrat adresse) {
        session.delete(adresse);
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
