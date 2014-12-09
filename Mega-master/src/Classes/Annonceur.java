package Classes;


import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ANNONCEUR")
public class Annonceur {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int identifiant;
    private int nom;
    private int mail;
    private int telephone;
    @ManyToOne(cascade=CascadeType.ALL)
    private Abonnement abonnement;

	// Getters and setters
    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public int getNom() {
        return nom;
    }

    public void setNom(int nom) {
        this.nom = nom;
    }

    public int getMail() {
        return mail;
    }

    public void setMail(int mail) {
        this.mail = mail;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public Abonnement getAbonnement() {
        return abonnement;
    }

    public void setAbonnement(Abonnement abonnement) {
        this.abonnement = abonnement;
    }
    // Constructors

    public Annonceur() {
    }

    public Annonceur(int nom, int mail, int telephone, Abonnement abonnement) {
        this.nom = nom;
        this.mail = mail;
        this.telephone = telephone;
        this.abonnement = abonnement;
    }       
	// Methods
    
    
    
@Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.nom);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Annonceur other = (Annonceur) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }

        return true;
    }    
}
