
package Facade;

import Classes.Domaine;
import java.util.List;

import org.hibernate.Session;

public class DomaineFacade {

    private Session session;

    public DomaineFacade(Session session) {
        this.session = session;
    }
    /**
     * Création d'un domaine
     */  
    public void creer(Domaine domaine) {
        session.persist(domaine);
    }
    /**
     * Modification d'un domaine
     */  
    public void modifier(Domaine domaine) {
        Domaine entity = (Domaine) session.merge(domaine);
        session.persist(entity);
    }
    /**
     * Suppression d'une d'un domaine
     */  
    public void supprimer(Domaine domaine) {
        session.delete(domaine);
    }
    /**
     * Liste de tous les domaines. Pour les domaines par artistes ou les artistes par domaines, utilisez la classe DomaineArtisteFacade
     */  
    public List<Domaine> lister() {
        return session.createQuery("from Domaine").list();
    }
    /**
     * Recherche d'un domaine par son identifiant
     */  
    public Domaine litParId(Integer id) {
        try {
            return (Domaine) session.createQuery("from Domaine a where a.identifiant = :identifiant").setInteger("identifiant", id).uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }
}
