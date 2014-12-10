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
@Table(name = "DOMAINE_ARTISTE")
public class DomaineArtiste {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private int identifiant;
    @ManyToOne(cascade=CascadeType.ALL)
    private Niveau niveau;
    @ManyToOne(cascade=CascadeType.ALL)
    private Domaine domaine;
    @ManyToOne(cascade=CascadeType.ALL )
    private Artiste artiste;

    // Getters and setters

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public Domaine getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }

    public Artiste getArtiste() {
        return artiste;
    }

    public void setArtiste(Artiste artiste) {
        this.artiste = artiste;
    }
 
	// Constructors
    public DomaineArtiste() {
    }

    public DomaineArtiste(int identifiant, Niveau niveau, Domaine domaine, Artiste artiste) {
        this.identifiant = identifiant;
        this.niveau = niveau;
        this.domaine = domaine;
        this.artiste = artiste;
    }
    // Methods
@Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.artiste);
        hash = 37 * hash + Objects.hashCode(this.niveau);
        hash = 37 * hash + Objects.hashCode(this.domaine);
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
        final DomaineArtiste other = (DomaineArtiste) obj;
        if (!Objects.equals(this.artiste, other.artiste) && !Objects.equals(this.niveau, other.niveau) && !Objects.equals(this.domaine, other.domaine)) {
            return false;
        }

        return true;
    }    

}
