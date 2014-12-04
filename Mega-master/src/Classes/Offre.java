package Classes;

import java.util.Date;
import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OFFRE")

public class Offre {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int identifiant;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private int nbPoste;
    private int duree;
    @ManyToOne
    private Annonceur annonceur;
    @ManyToOne
    private Metier metier;
    @ManyToOne
    private Contrat contrat;

    // Getters and setters

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getNbPoste() {
        return nbPoste;
    }

    public void setNbPoste(int nbPoste) {
        this.nbPoste = nbPoste;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Annonceur getAnnonceur() {
        return annonceur;
    }

    public void setAnnonceur(Annonceur annonceur) {
        this.annonceur = annonceur;
    }

    public Metier getMetier() {
        return metier;
    }

    public void setMetier(Metier metier) {
        this.metier = metier;
    }

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }

	// Constructors
    public Offre() {
    }

    public Offre(String description, Date dateDebut, Date dateFin, int nbPoste, int duree, Annonceur annonceur, Metier metier, Contrat contrat) {
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbPoste = nbPoste;
        this.duree = duree;
        this.annonceur = annonceur;
        this.metier = metier;
        this.contrat = contrat;
    }
	// Methods

}
