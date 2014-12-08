/*
 * OperationFacade.java
 *
 * Created on 8 decembre 2006, 12:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package Facade;

import Classes.Artiste;
import java.util.List;

import org.hibernate.Session;

public class ArtisteFacade {

    private Session session;

    public ArtisteFacade(Session session) {
        this.session = session;
    }

    public void creer(Artiste artiste) {
        session.persist(artiste);
    }

    public void modifier(Artiste artiste) {
        Artiste entity = (Artiste) session.merge(artiste);
        session.persist(entity);
    }

    public void supprimer(Artiste artiste) {
        session.delete(artiste);
    }

    public List<Artiste> lister() {
        return session.createQuery("from Artiste").list();
    }

    public Artiste litParId(Integer id) {
        try {
            return (Artiste) session.createQuery("from Artiste a where a.identifiant = :identifiant").setInteger("identifiant", id).uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }
}
