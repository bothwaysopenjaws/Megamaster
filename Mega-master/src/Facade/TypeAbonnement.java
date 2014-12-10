/*
 * OperationFacade.java
 *
 * Created on 8 decembre 2006, 12:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package Facade;

import java.util.List;

import org.hibernate.Session;

public class TypeAbonnement {

    private Session session;

    public TypeAbonnement(Session session) {
        this.session = session;
    }

    public void creer(TypeAbonnement typeAbonnement) {
        session.persist(typeAbonnement);
    }

    public void modifier(TypeAbonnement typeAbonnement) {
        TypeAbonnement entity = (TypeAbonnement) session.merge(typeAbonnement);
        session.persist(entity);
    }

    public void supprimer(TypeAbonnement typeAbonnement) {
        session.delete(typeAbonnement);
    }

    public List<TypeAbonnement> lister() {
        return session.createQuery("from TypeAbonnement").list();
    }

    public TypeAbonnement litParId(Integer id) {
        try {
            return (TypeAbonnement) session.createQuery("from TypeAbonnement a where a.identifiant = :identifiant").setInteger("identifiant", id).uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }
}
