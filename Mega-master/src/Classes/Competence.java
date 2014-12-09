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
    @ManyToOne(cascade=CascadeType.ALL)
    private Artiste artiste;

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

    public Artiste getArtiste() {
        return artiste;
    }

    public void setArtiste(Artiste artiste) {
        this.artiste = artiste;
    }
    // Constructors

    public Competence() {
    }
    
    public Competence(TypeCompetence typeCompetence, int niveauCompetence, String description, Artiste artiste) {
        this.typeCompetence = typeCompetence;
        this.niveauCompetence = niveauCompetence;
        this.description = description;
        this.artiste = artiste;
    }
	// Methods
    
    
@Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.typeCompetence);
        hash = 37 * hash + Objects.hashCode(this.artiste);
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
        final Competence other = (Competence) obj;
        if (!Objects.equals(this.typeCompetence, other.typeCompetence)) {
            return false;
        }
        if (!Objects.equals(this.artiste, other.artiste)) {
            return false;
        }
        return true;
    }

}
