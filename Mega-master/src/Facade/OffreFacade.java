
package Facade;

import Classes.Offre;
import java.util.List;

import org.hibernate.Session;

public class OffreFacade {

    private Session session;

    public OffreFacade(Session session) {
        this.session = session;
    }
    /**
     * Création d'une offre
     */  
    public void creer(Offre offre) {
        session.persist(offre);
    }
    /**
     * Modification d'une offre
     */  
    public void modifier(Offre offre) {
        Offre entity = (Offre) session.merge(offre);
        session.persist(entity);
    }
    /**
     * Suppression d'une offre
     */  
    public void supprimer(Offre offre) {
        session.delete(offre);
    }
    /**
     * Liste des offres
     */  
    public List<Offre> lister() {
        return session.createQuery("from Offre").list();
    }
    /**
     * Recherche
     */  
    public Offre litParId(Integer id) {
        try {
            return (Offre) session.createQuery("from Offre a where a.identifiant = :identifiant").setInteger("identifiant", id).uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }
    public List<Offre> listerParDate() {
        return session.createQuery("from Offre orderBy Offre.dateEmission").list();
    }   
}
