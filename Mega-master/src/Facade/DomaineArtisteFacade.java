/*
 * OperationFacade.java
 *
 * Created on 8 decembre 2006, 12:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package Facade;

import Classes.DomaineArtiste;
import java.util.List;

import org.hibernate.Session;

public class DomaineArtisteFacade {

    private Session session;

    public DomaineArtisteFacade(Session session) {
        this.session = session;
    }

    public void creer(DomaineArtiste domaineArtiste) {
        session.persist(domaineArtiste);
    }

    public void modifier(DomaineArtiste domaineArtiste) {
        DomaineArtiste entity = (DomaineArtiste) session.merge(domaineArtiste);
        session.persist(entity);
    }

    public void supprimer(DomaineArtiste domaineArtiste) {
        session.delete(domaineArtiste);
    }

    public List<DomaineArtiste> lister() {
        return session.createQuery("from DomaineArtiste").list();
    }
}
