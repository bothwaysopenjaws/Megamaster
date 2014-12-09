
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
     * Suppression d'une competence
     */  
    public void creer(Contrat contrat) {
        session.persist(contrat);
    }

    public void modifier(Contrat contrat) {
        Contrat entity = (Contrat) session.merge(contrat);
        session.persist(entity);
    }

    public void supprimer(Contrat contrat) {
        session.delete(contrat);
    }

    public List<Contrat> lister() {
        return session.createQuery("from Contrat").list();
    }
    

}
