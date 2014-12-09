package Classes;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CANDIDATURE")
public class Candidature {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int identifiant;
    private String titre;
    private String mail;
    private String nom;
    private String prenom;
    private String URLCV;
    private String uRLLettreMotive;
    private Date dateEmission;

    // Getters and setters
    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getURLCV() {
        return URLCV;
    }

    public void setURLCV(String uRLCV) {
        URLCV = uRLCV;
    }

    public String getuRLLettreMotive() {
        return uRLLettreMotive;
    }

    public void setuRLLettreMotive(String uRLLettreMotive) {
        this.uRLLettreMotive = uRLLettreMotive;
    }

    public Date getDateEmission() {
        return dateEmission;
    }

    public void setDateEmission(Date dateEmission) {
        this.dateEmission = dateEmission;        
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    
    
    //Constructors

    public Candidature() {
    }

    public Candidature(String titre, String mail, String nom, String prenom, Date dateEmission) {
        this.titre = titre;
        this.mail = mail;
        this.nom = nom;
        this.prenom = prenom;
        this.dateEmission = dateEmission;
    }
	// Methods
    
    
    
    



}
