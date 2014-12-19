
package Facade;

import Classes.Diffuseur;
import java.util.List;

import org.hibernate.Session;

public class DiffuseurFacade {

    private Session session;

    public DiffuseurFacade(Session session) {
        this.session = session;
    }
    /**
     * Création d'une competence
     * @param diffuseur
     */  
    public void creer(Diffuseur diffuseur) {
        session.persist(diffuseur);
    }
    /**
     * Modification d'un diffuseur
     * @param diffuseur
     */  
    public void modifier(Diffuseur diffuseur) {
        Diffuseur entity = (Diffuseur) session.merge(diffuseur);
        session.persist(entity);
    }
    /**
     * Suppression d'un diffuseur
     * @param diffuseur
     */  
    public void supprimer(Diffuseur diffuseur) {
        session.delete(diffuseur);
    }

    public List<Diffuseur> lister() {
        return session.createQuery("from Diffuseur").list();
    }

}
