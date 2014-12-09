
package Facade;

import Classes.Adresse;
import java.util.List;

import org.hibernate.Session;

public class AdresseFacade {

    private Session session;

    public AdresseFacade(Session session) {
        this.session = session;
    }
    /**
     * Ajouter une adresse dans la BDD
     * @param adresse
     */
    public void creer(Adresse adresse) {
        session.persist(adresse);
    }
    /**
     * Modification d'une adresse
     * @param adresse
     */
    public void modifier(Adresse adresse) {
        Adresse entity = (Adresse) session.merge(adresse);
        session.persist(entity);
    }

    /**
     * Supression d'une adresse
     * 
     * @param adresse
     */    
    
    public void supprimer(Adresse adresse) {
        session.delete(adresse);
    }
    
    /**
     * Lister les adresses
     * 
     * @return 
     */    
    public List<Adresse> lister() {
        return session.createQuery("from Adresse").list();
    }
    /**
     * Recherche 
     * 

     */    
    public Adresse litParId(Integer id) {
        try {
            return (Adresse) session.createQuery("from Adresse a where a.identifiant = :identifiant").setInteger("identifiant", id).uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    
    
}
