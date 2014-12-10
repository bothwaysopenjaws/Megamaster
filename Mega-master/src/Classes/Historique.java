package Classes;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HISTORIQUE")


public class Historique {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int identifiant;
    private String societe;
    private Date dateDebut;
    private Date dateFin;
    private String description;
    @ManyToOne(cascade=CascadeType.ALL)
    private TypeContrat typeContrat;
    @ManyToOne(cascade=CascadeType.ALL)
    private Artiste artiste;

    // Getters and setters

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeContrat getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(TypeContrat typeContrat) {
        this.typeContrat = typeContrat;
    }

    public Artiste getArtiste() {
        return artiste;
    }

    public void setArtiste(Artiste artiste) {
        this.artiste = artiste;
    }

    // Constructors
    
    public Historique() {
    }

    public Historique(String societe, Date dateDebut, Date dateFin, String description, TypeContrat typeContrat, Artiste artiste) {
        this.societe = societe;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.description = description;
        this.typeContrat = typeContrat;
        this.artiste = artiste;
    }
    // Methods
    
    
}
