
package Facade;

import Classes.Abonnement;
import java.util.List;

import org.hibernate.Session;

public class AbonnementFacade {

    private Session session;

    public AbonnementFacade(Session session) {
        this.session = session;
    }
    /**
     * Ajout d'un abonnement dans la BDD
     * @param abonnement
     */
    public void creer(Abonnement abonnement) {
        session.persist(abonnement);
    }
    /**
     * modification d'un abonnement dans la BDD
     * @param abonnement
     */
    public void modifier(Abonnement abonnement) {
        Abonnement entity = (Abonnement) session.merge(abonnement);
        session.persist(entity);
    }
    /**
     * Ajout d'un supprimer dans la BDD
     * @param abonnement
     */
    public void supprimer(Abonnement abonnement) {
        session.delete(abonnement);
    }
    /**
     * liste de tous les abonnements dans la BDD
     * @return 
     */
    public List<Abonnement> lister() {
        return session.createQuery("from Abonnement").list();
    }
    /**
     * Recherche d'un abonnement
     * @param id
     * @return 
     */
    public Abonnement litParId(Integer id) {
        try {
            return (Abonnement) session.createQuery("from Abonnement a where a.identifiant = :identifiant").setInteger("identifiant", id).uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }

}
