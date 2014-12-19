
package Facade;

import Classes.*;
import java.util.List;

import org.hibernate.Session;

public class DomaineArtisteFacade {

    private Session session;

    public DomaineArtisteFacade(Session session) {
        this.session = session;
    }
    /**
     * Création d'une liaison Artiste-domaine
     */  
    public void creer(DomaineArtiste domaineArtiste) {
        session.persist(domaineArtiste);
    }
    /**
     * Modification d'un Artiste-domaine
     */  
    public void modifier(DomaineArtiste domaineArtiste) {
        DomaineArtiste entity = (DomaineArtiste) session.merge(domaineArtiste);
        session.persist(entity);
    }
    /**
     * Suppression d'un Artiste sur un domaine
     */  
    public void supprimer(DomaineArtiste domaineArtiste) {
        session.delete(domaineArtiste);
    }

    public List<DomaineArtiste> lister() {
        return session.createQuery("from DomaineArtiste").list();
    }
    
    /**
     * liste des domaines d'un artiste
     * @param identifiant identifiant de l'artiste
     * @return 
     */      
    public List<Domaine> listerDomaineParArtiste(int identifiant) {
        return session.createQuery("from Domaine where Artiste.identifiant = :identifiant").setInteger("identifiant", identifiant).list();
    }    
    
    /**
     * liste des artistes d'un Domaine
     * @param identifiant identitifiant du domaine
     * @return 
     */      
    public List<Artiste> listerArtisteParDomaine(int identifiant) {
        return session.createQuery("from Artiste where Domaine.identifiant = :identifiant").setInteger("identifiant", identifiant).list();
    }    
        
    
}
