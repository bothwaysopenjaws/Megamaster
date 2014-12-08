package Classes;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MEDIA")
public class Media {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int identifiant;
    private int nom;
    private String url;
    @ManyToOne(cascade=CascadeType.ALL)
    private TypeMedia typeMedia;
    @ManyToOne(cascade=CascadeType.ALL)
    private Artiste artiste;
    @ManyToOne(cascade=CascadeType.ALL)
    private Categorie categorie;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // Constructors
    
    public Media() {
    }

    public Media(int nom, String url, TypeMedia typeMedia, Artiste artiste, Categorie categorie) {
        this.nom = nom;
        this.url = url;
        this.typeMedia = typeMedia;
        this.artiste = artiste;
        this.categorie = categorie;
    }
    // Methods
}
