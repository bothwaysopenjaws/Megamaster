
package Facade;

import Classes.Candidature;
import java.util.List;

import org.hibernate.Session;

public class CandidatureFacade {

    private Session session;


    public CandidatureFacade(Session session) {
        this.session = session;
    }
    /**
     * Ajout d'une candidature dans la BDD
     * @param candidature
     */  
    public void creer(Candidature candidature) {
        session.persist(candidature);
    }
    /**
     * Modification d'une candidature dans la BDD
     * @param candidature
     */  
    public void modifier(Candidature candidature) {
        Candidature entity = (Candidature) session.merge(candidature);
        session.persist(entity);
    }
    /**
     * Suppression d'une candidature dans la BDD
     * @param candidature
     */  
    public void supprimer(Candidature candidature) {
        session.delete(candidature);
    }
    /**
     * Liste des candidatures dans la BDD
     * @return 
     */  
    public List<Candidature> lister() {
        return session.createQuery("from Candidature").list();
    }
    /**
     * Recherche d'une candidature en fonction de son identifiant
     * @return 
     */  
    public Candidature litParId(Integer id) {
        try {
            return (Candidature) session.createQuery("from Candidature a where a.identifiant = :identifiant").setInteger("identifiant", id).uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }
}
