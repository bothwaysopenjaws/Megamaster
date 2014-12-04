/*
 * OperationFacade.java
 *
 * Created on 8 decembre 2006, 12:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package Facade;

import Classes.Media;
import java.util.List;

import org.hibernate.Session;

public class MediaFacade {

    private Session session;

    public MediaFacade(Session session) {
        this.session = session;
    }

    public void creer(Media media) {
        session.persist(media);
    }

    public void modifier(Media media) {
        Media entity = (Media) session.merge(media);
        session.persist(entity);
    }

    public void supprimer(Media media) {
        session.delete(media);
    }

    public List<Media> lister() {
        return session.createQuery("from Media").list();
    }

    public Media litParId(Integer id) {
        try {
            return (Media) session.createQuery("from Media a where a.identifiant = :identifiant").setInteger("identifiant", id).uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }
}
