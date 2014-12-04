package Classes;


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
    @ManyToOne
    private Niveau niveau;
    @ManyToOne
    private Domaine domaine;
    @ManyToOne
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

}
