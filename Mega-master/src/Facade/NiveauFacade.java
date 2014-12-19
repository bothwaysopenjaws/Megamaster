
package Facade;

import Classes.Niveau;
import java.util.List;

import org.hibernate.Session;

public class NiveauFacade {

    private Session session;

    public NiveauFacade(Session session) {
        this.session = session;
    }
    /**
     * Création d'un niveau
     */  
    public void creer(Niveau niveau) {
        session.persist(niveau);
    }
    /**
     * Modification d'un niveau
     */  
    public void modifier(Niveau niveau) {
        Niveau entity = (Niveau) session.merge(niveau);
        session.persist(entity);
    }
    /**
     * Suppression d'un niveau
     */  
    public void supprimer(Niveau niveau) {
        session.delete(niveau);
    }
    /**
     * récupère la liste de tous les niveaux
     */  
    public List<Niveau> lister() {
        return session.createQuery("from Niveau").list();
    }
    /**
     *  récupère un niveau en le recherchant par son identifiant
     */  
    public Niveau litParId(Integer id) {
        try {
            return (Niveau) session.createQuery("from Niveau a where a.identifiant = :identifiant").setInteger("identifiant", id).uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }
}
