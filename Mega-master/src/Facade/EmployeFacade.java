
package Facade;

import Classes.Employe;
import java.util.List;

import org.hibernate.Session;

public class EmployeFacade {

    private Session session;

    public EmployeFacade(Session session) {
        this.session = session;
    }
    /**
     * Création d'un employé
     */  
    public void creer(Employe employe) {
        session.persist(employe);
    }
    /**
     * Modification d'un employé
     */  
    public void modifier(Employe employe) {
        Employe entity = (Employe) session.merge(employe);
        session.persist(entity);
    }
    /**
     * Suppression d'un employé
     */  
    public void supprimer(Employe employe) {
        session.delete(employe);
    }
    /**
     * liste des employé
     */  
    public List<Employe> lister() {
        return session.createQuery("from Employe").list();
    }
    /**
     * recherche d'un employé par son identifiant
     */ 
    public Employe litParId(Integer id) {
        try {
            return (Employe) session.createQuery("from Employe a where a.identifiant = :identifiant").setInteger("identifiant", id).uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }
        

    public Employe rechercheIdPw(String id, String pwd) {
        return (Employe) session.createQuery("from Employe a where a.id = :id and a.pwd=:pwd").setString("id", id).setString("pwd", pwd).uniqueResult();
        
        //
    }        
           
        
    }
    
    

