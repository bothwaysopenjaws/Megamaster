/*
 * OperationFacade.java
 *
 * Created on 8 decembre 2006, 12:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package Facade;

import Classes.TypeCompetence;
import java.util.List;

import org.hibernate.Session;

public class TypeCompetenceFacade {

    private Session session;

    public TypeCompetenceFacade(Session session) {
        this.session = session;
    }

    public void creer(TypeCompetence typeCompetence) {
        session.persist(typeCompetence);
    }

    public void modifier(TypeCompetence typeCompetence) {
        TypeCompetence entity = (TypeCompetence) session.merge(typeCompetence);
        session.persist(entity);
    }

    public void supprimer(TypeCompetence typeCompetence) {
        session.delete(typeCompetence);
    }

    public List<TypeCompetence> lister() {
        return session.createQuery("from TypeCompetence").list();
    }

    public TypeCompetence litParId(Integer id) {
        try {
            return (TypeCompetence) session.createQuery("from TypeCompetence a where a.identifiant = :identifiant").setInteger("identifiant", id).uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }
}
