
package Facade;

import Classes.Annonceur;
import java.util.List;

import org.hibernate.Session;

public class AnnonceurFacade {

    private Session session;

    public AnnonceurFacade(Session session) {
        this.session = session;
    }
    /**
     * Ajout d'un Annonceur dans la BDD
     */    
    
    /**
     * Ajout d'un Annonceur dans la BDD
     * @param annonceur
     */
    public void creer(Annonceur annonceur) {
        session.persist(annonceur);
    }
    /**
     * Modification d'un Annonceur dans la BDD
     * @param annonceur
     */  
    public void modifier(Annonceur annonceur) {
        Annonceur entity = (Annonceur) session.merge(annonceur);
        session.persist(entity);
    }
    /**
     *  Suppression d'un annonceur dans la BDD
     * @param annonceur
     */  
    public void supprimer(Annonceur annonceur) {
        session.delete(annonceur);
    }
    
    /**
     * Liste des annonceurs
     */      

    public List<Annonceur> lister() {
        return session.createQuery("from Annonceur").list();
    }
    /**
     * Recherche d'un annonceur en fonction de son ID
     * @param id
     * @return 
     */  
    public Annonceur litParId(Integer id) {
        try {
            return (Annonceur) session.createQuery("from Annonceur a where a.identifiant = :identifiant").setInteger("identifiant", id).uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }
    
}
