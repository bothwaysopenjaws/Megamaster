/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate;

import Classes.*;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory object.
 *
 * @author Keloud
 */
public class HibernateConfig {

    public static Configuration getConfiguration() {        
                    return new Configuration()
                            .addPackage("Classes")
                            .addAnnotatedClass(Adresse.class)
                            .addAnnotatedClass(Abonnement.class)
                            .addAnnotatedClass(Annonceur.class)
                            .addAnnotatedClass(Artiste.class)
                            .addAnnotatedClass(Candidature.class)
                            .addAnnotatedClass(Categorie.class)
                            .addAnnotatedClass(Compagnie.class)
                            .addAnnotatedClass(Competence.class)
                            .addAnnotatedClass(Contrat.class)
                            .addAnnotatedClass(Diffuseur.class)
                            .addAnnotatedClass(Domaine.class)
                            .addAnnotatedClass(DomaineArtiste.class)
                            .addAnnotatedClass(Employe.class)
                            .addAnnotatedClass(Historique.class)
                            .addAnnotatedClass(Media.class)
                            .addAnnotatedClass(Metier.class)
                            .addAnnotatedClass(Niveau.class)
                            .addAnnotatedClass(Offre.class)
                            .addAnnotatedClass(Statut.class)
                            .addAnnotatedClass(TypeAbonnement.class)
                            .addAnnotatedClass(TypeCompetence.class)
                            .addAnnotatedClass(TypeContrat.class)
                            .addAnnotatedClass(TypeMedia.class);                    
    }

}
