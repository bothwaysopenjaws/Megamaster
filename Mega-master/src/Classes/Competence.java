package Classes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMPETENCE")
public class Competence {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int identifiant;
    @ManyToOne(cascade=CascadeType.ALL)
    private TypeCompetence typeCompetence;
    private int niveauCompetence;
    private String description;
    private int Artiste;

    // Getters and setters

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public TypeCompetence getTypeCompetence() {
        return typeCompetence;
    }

    public void setTypeCompetence(TypeCompetence typeCompetence) {
        this.typeCompetence = typeCompetence;
    }

    public int getNiveauCompetence() {
        return niveauCompetence;
    }

    public void setNiveauCompetence(int niveauCompetence) {
        this.niveauCompetence = niveauCompetence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getArtiste() {
        return Artiste;
    }

    public void setArtiste(int artiste) {
        Artiste = artiste;
    }
    // Constructors

    public Competence() {
    }
    
    public Competence(TypeCompetence typeCompetence, int niveauCompetence, String description, int Artiste) {
        this.typeCompetence = typeCompetence;
        this.niveauCompetence = niveauCompetence;
        this.description = description;
        this.Artiste = Artiste;
    }
	// Methods


}
