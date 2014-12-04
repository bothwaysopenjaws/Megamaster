package Classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMPAGNIE")
public class Compagnie {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private int identifiant;
    private String libelle;

    // Getters and setters
    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    // Constructors

    public Compagnie() {
    }

    public Compagnie( String libelle) {
        this.libelle = libelle;
    }

	// Methods
}
