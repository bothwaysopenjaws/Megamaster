/*
 * OperationFacade.java
 *
 * Created on 8 decembre 2006, 12:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package Facade;

import Classes.TypeContrat;
import java.util.List;

import org.hibernate.Session;

public class TypeContratFacade {

    private Session session;

    public TypeContratFacade(Session session) {
        this.session = session;
    }

    public void creer(TypeContrat typeContrat) {
        session.persist(typeContrat);
    }

    public void modifier(TypeContrat typeContrat) {
        TypeContrat entity = (TypeContrat) session.merge(typeContrat);
        session.persist(entity);
    }

    public void supprimer(TypeContrat typeContrat) {
        session.delete(typeContrat);
    }

    public List<TypeContrat> lister() {
        return session.createQuery("from TypeContrat").list();
    }

    public TypeContrat litParId(Integer id) {
        try {
            return (TypeContrat) session.createQuery("from TypeContrat a where a.identifiant = :identifiant").setInteger("identifiant", id).uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }
}
