
package Facade;

import Classes.Contrat;
import java.util.List;

import org.hibernate.Session;

public class ContratFacade {

    private Session session;

    public ContratFacade(Session session) {
        this.session = session;
    }
    /**
     * Création d'un contrat
     * @param contrat
     */  
    public void creer(Contrat contrat) {
        session.persist(contrat);
    }
    /**
     * Modification d'un contrat
     * @param contrat
     */  
    public void modifier(Contrat contrat) {
        Contrat entity = (Contrat) session.merge(contrat);
        session.persist(entity);
    }
    /**
     * Suppression d'un contrat
     */  
    public void supprimer(Contrat contrat) {
        session.delete(contrat);
    }
    /**
     * Suppression des contrats
     */  
    public List<Contrat> lister() {
        return session.createQuery("from Contrat").list();
    }
    

}
