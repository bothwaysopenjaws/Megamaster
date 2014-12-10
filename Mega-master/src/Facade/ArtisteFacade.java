
package Facade;

import Classes.Artiste;
import java.util.List;

import org.hibernate.Session;

public class ArtisteFacade {

    private Session session;

    public ArtisteFacade(Session session) {
        this.session = session;
    }
    /**
     * Ajout d'un artiste dans la BDD
     */  
    public void creer(Artiste artiste) {
        session.persist(artiste);
    }
    /**
     * Modification d'un artiste dans la BDD
     * @param artiste
     */  
    public void modifier(Artiste artiste) {
        Artiste entity = (Artiste) session.merge(artiste);
        session.persist(entity);
    }
    /**
     * Suppression d'un Artiste dans la BDD
     * @param artiste
     */  
    public void supprimer(Artiste artiste) {
        session.delete(artiste);
    }
    /**
     * Liste des personnes de la BDD
     * @return 
     */  
    public List<Artiste> lister() {
        return session.createQuery("from Artiste").list();
    }

}
