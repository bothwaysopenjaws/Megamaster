package Classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADRESSE")
public class Adresse {

    // Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int identifiant;
    private String numero;
    private String rue;
    private String ville;
    private String codePostal;
    private String pays;

    public Adresse() {
    }

	// Constructors
    public Adresse(String numero, String rue, String ville, String codePostal, String Pays) {

        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
        this.pays = Pays;
    }
    
    // Getters and setters
    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

	// Methods
}
