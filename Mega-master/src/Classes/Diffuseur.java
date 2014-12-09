package Classes;


import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DIFFUSEUR")
public class Diffuseur {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int identifiant;
    private String nom;
    private String telephone;
    private String mail;

    // Getters and setters

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    // Constructors

    public Diffuseur() {
    }

    public Diffuseur(String nom, String telephone, String mail) {
        this.nom = nom;
        this.telephone = telephone;
        this.mail = mail;
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
        final Diffuseur other = (Diffuseur) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return true;
    }
}
