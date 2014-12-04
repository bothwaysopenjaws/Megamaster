/*
 * OperationFacade.java
 *
 * Created on 8 decembre 2006, 12:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package Facade;

import Classes.TypeMedia;
import java.util.List;

import org.hibernate.Session;

public class TypeMediaFacade {

    private Session session;

    public TypeMediaFacade(Session session) {
        this.session = session;
    }

    public void creer(TypeMedia typeMedia) {
        session.persist(typeMedia);
    }

    public void modifier(TypeMedia typeMedia) {
        TypeMedia entity = (TypeMedia) session.merge(typeMedia);
        session.persist(entity);
    }

    public void supprimer(TypeMedia typeMedia) {
        session.delete(typeMedia);
    }

    public List<TypeMedia> lister() {
        return session.createQuery("from TypeMedia").list();
    }

    public TypeMedia litParId(Integer id) {
        try {
            return (TypeMedia) session.createQuery("from TypeMedia a where a.identifiant = :identifiant").setInteger("identifiant", id).uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }
}
