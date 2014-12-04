package Classes;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTRAT")
public class Contrat {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private int identifiant;
    private String Nom;
    private String Type;
    private String Clause;

    // Getters and setters
    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getClause() {
        return Clause;
    }

    public void setClause(String clause) {
        Clause = clause;
    }
    // Constructors

    public Contrat() {
    }



	// Methods

    public Contrat(String Nom, String Type, String Clause) {
        this.Nom = Nom;
        this.Type = Type;
        this.Clause = Clause;
    }
}
