
package Facade;

import Classes.Historique;
import java.util.List;

import org.hibernate.Session;

public class HistoriqueFacade {

    private Session session;

    public HistoriqueFacade(Session session) {
        this.session = session;
    }
    /**
     * Création d'un historique
     */  
    public void creer(Historique historique) {
        session.persist(historique);
    }
    /**
     * modification d'un historique
     */  
    public void modifier(Historique historique) {
        Historique entity = (Historique) session.merge(historique);
        session.persist(entity);
    }
    /**
     * Suppression d'un historique
     */  
    public void supprimer(Historique historique) {
        session.delete(historique);
    }
    /**
     * Liste des  historiques
     */  
    public List<Historique> lister() {
        return session.createQuery("from Historique").list();
    }
    /**
     * Recherche d'un historique par son identifiant
     */  
    public Historique litParId(Integer id) {
        try {
            return (Historique) session.createQuery("from Historique a where a.identifiant = :identifiant").setInteger("identifiant", id).uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * liste des historiques d'un Artiste
     * @param identifiant identitifiant de l'artiste
     * @return 
     */      
    public List<Historique> listerHistoriqueParArtiste(int identifiant) {
        return session.createQuery("from Historique where Artiste.identifiant = :identifiant").setInteger("identifiant", identifiant).list();
    }    
            
}
