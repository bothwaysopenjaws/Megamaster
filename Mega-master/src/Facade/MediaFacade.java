
package Facade;

import Classes.Media;
import java.util.List;

import org.hibernate.Session;

public class MediaFacade {

    private Session session;

    public MediaFacade(Session session) {
        this.session = session;
    }
    /**
     * AJout d'un media
     */  
    public void creer(Media media) {
        session.persist(media);
    }
    /**
     * Modification d'un media
     */  
    public void modifier(Media media) {
        Media entity = (Media) session.merge(media);
        session.persist(entity);
    }
    /**
     * Suppression d'un media
     */  
    public void supprimer(Media media) {
        session.delete(media);
    }
    /**
     * liste des medias
     */  
    public List<Media> lister() {
        return session.createQuery("from Media").list();
    }
    /**
     * Recherche d'un media par son identifiant
     */  
    public Media litParId(Integer id) {
        try {
            return (Media) session.createQuery("from Media a where a.identifiant = :identifiant").setInteger("identifiant", id).uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }
}
