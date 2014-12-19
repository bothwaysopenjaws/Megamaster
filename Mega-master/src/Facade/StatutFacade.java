
package Facade;

import Classes.Statut;
import java.util.List;

import org.hibernate.Session;

public class StatutFacade {

    private Session session;

    public StatutFacade(Session session) {
        this.session = session;
    }

    public void creer(Statut statut) {
        session.persist(statut);
    }

    public void modifier(Statut statut) {
        Statut entity = (Statut) session.merge(statut);
        session.persist(entity);
    }

    public void supprimer(Statut statut) {
        session.delete(statut);
    }

    public List<Statut> lister() {
        return session.createQuery("from Statut").list();
    }

    public Statut litParId(Integer id) {
        try {
            return (Statut) session.createQuery("from Statut a where a.identifiant = :identifiant").setInteger("identifiant", id).uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }
}
