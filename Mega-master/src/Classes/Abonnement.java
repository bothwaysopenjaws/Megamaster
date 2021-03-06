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
@Table(name = "ABONNEMENT")
public class Abonnement {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private int identifiant;
    private int restant;
    @ManyToOne(cascade=CascadeType.ALL)
    private TypeAbonnement typeAbonnement;

    // Getters and setters
    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public int getRestant() {
        return restant;
    }

    public void setRestant(int restant) {
        this.restant = restant;
    }

    public TypeAbonnement getTypeAbonnement() {
        return typeAbonnement;
    }

    public void setTypeAbonnement(TypeAbonnement typeAbonnement) {
        this.typeAbonnement = typeAbonnement;
    }

	// Constructors
    public Abonnement() {
    }

    public Abonnement( int restant, TypeAbonnement typeAbonnement) {
        this.restant = restant;
        this.typeAbonnement = typeAbonnement;
    }
    // Methods
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.identifiant);
        return hash;
    }


}
