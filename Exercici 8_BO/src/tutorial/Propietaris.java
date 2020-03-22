package tutorial;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Propietaris implements Serializable {
    private static final long serialVersionUID = 1L;
    
    //CLASE PROPIETARI
    
    @Id @GeneratedValue
    private long id;

    private int edad;
    private String nom;
    private boolean haPagat;

    public Propietaris() {
    }

    Propietaris(int edad, String nom, boolean haPagat) {
        this.edad = edad;
        this.nom = nom;
        this.haPagat = haPagat;
    }

    public Long getId() {
        return id;
    }

    public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public boolean isHaPagat() {
		return haPagat;
	}

	public void setHaPagat(boolean haPagat) {
		this.haPagat = haPagat;
	}

	@Override
    public String toString() {
        return "ID: " + this.id + ", Nom: " + this.nom + ", Edat: " + this.edad + ", Ha pagat? " + this.haPagat;
    }
}