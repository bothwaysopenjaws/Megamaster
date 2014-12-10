
package Facade;

import Classes.Compagnie;
import java.util.List;

import org.hibernate.Session;

public class CompagnieFacade {

    private Session session;

    public CompagnieFacade(Session session) {
        this.session = session;
    }

    /**
     *  Ajout d'une compagnie dans la BDD
     * @param compagnie
     */
    public void creer(Compagnie compagnie) {
        session.persist(compagnie);
    }
    /**
     * Modification d'une Compagnie
     */  
    public void modifier(Compagnie compagnie) {
        Compagnie entity = (Compagnie) session.merge(compagnie);
        session.persist(entity);
    }

    /**
     * Suppression d'une compagnie
     */      
    public void supprimer(Compagnie compagnie) {
        session.delete(compagnie);
    }
    /**
     * Liste des compagnie de la BDD
     */  
    public List<Compagnie> lister() {
        return session.createQuery("from Compagnie").list();
    }
    /**
     * Recherche d'une compagnie en fonction de son identifiant
     */  
    public Compagnie litParId(Integer id) {
        try {
            return (Compagnie) session.createQuery("from Compagnie a where a.identifiant = :identifiant").setInteger("identifiant", id).uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }    
    /**
     * liste des artistes d'une compagnie
     * @param identifiant
     * @return 
     */      
    public List<Compagnie> listerArtiste(int identifiant) {
        return session.createQuery("from Artiste where compagnie.identifiant = :identifiant").setInteger("identifiant", identifiant).list();
    }
}
