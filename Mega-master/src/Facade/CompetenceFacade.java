
package Facade;

import Classes.Competence;
import java.util.List;

import org.hibernate.Session;

public class CompetenceFacade {

    private Session session;

    public CompetenceFacade(Session session) {
        this.session = session;
    }
    /**
     * Ajout d'une competence à la BDD
     */  
    public void creer(Competence competence) {
        session.persist(competence);
    }
    /**
     * Modification d'une competence à la BDD
     */  
    public void modifier(Competence competence) {
        Competence entity = (Competence) session.merge(competence);
        session.persist(entity);
    }
    /**
     * Suppression d'une competence
     */  
    public void supprimer(Competence competence) {
        session.delete(competence);
    }
    /**
     * Liste des competences
     */  
    public List<Competence> lister() {
        return session.createQuery("from Competence").list();
    }
    
    /**
     * liste des artistes d'une Competence
     * @param identifiant
     * @return 
     */      
    public List<Competence> listerArtiste(int identifiant) {
        return session.createQuery("from Artiste where Competence.identifiant = :identifiant").setInteger("identifiant", identifiant).list();
    }    
    
    


}
