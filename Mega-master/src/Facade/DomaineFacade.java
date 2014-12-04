/*
 * OperationFacade.java
 *
 * Created on 8 decembre 2006, 12:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package Facade;

import Classes.Domaine;
import java.util.List;

import org.hibernate.Session;

public class DomaineFacade {

    private Session session;

    public DomaineFacade(Session session) {
        this.session = session;
    }

    public void creer(Domaine domaine) {
        session.persist(domaine);
    }

    public void modifier(Domaine domaine) {
        Domaine entity = (Domaine) session.merge(domaine);
        session.persist(entity);
    }

    public void supprimer(Domaine domaine) {
        session.delete(domaine);
    }

    public List<Domaine> lister() {
        return session.createQuery("from Domaine").list();
    }

    public Domaine litParId(Integer id) {
        try {
            return (Domaine) session.createQuery("from Domaine a where a.identifiant = :identifiant").setInteger("identifiant", id).uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }
}
