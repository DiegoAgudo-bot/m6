package tutorial;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Vehicle implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    //CLASSE VEHICLE
    @Id @GeneratedValue
    private long id;

    private int kilometros;
    private String marca;
    private String model;
    private boolean aireAcondicionat;
    private long propietariId;

    public Vehicle() {
    }
    
    public Vehicle(long id, int kilometros, String marca, String model, boolean aireAcondicionat) {
		this.kilometros = kilometros;
		this.marca = marca;
		this.model = model;
		this.aireAcondicionat = aireAcondicionat;
		this.propietariId = id;
	}

	public long getPropietariId() {
		return propietariId;
	}

	public void setPropietariId(long propietariId) {
		this.propietariId = propietariId;
	}

	public Long getId() {
        return id;
    }

	public int getKilometros() {
		return kilometros;
	}

	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public boolean isAireAcondicionat() {
		return aireAcondicionat;
	}

	public void setAireAcondicionat(boolean aireAcondicionat) {
		this.aireAcondicionat = aireAcondicionat;
	}

	@Override
    public String toString() {
        return "ID: " + this.id + ", Marca: " + this.marca + ", Model: " + this.model + ", Kilometres: " + this.kilometros + ", Aire acondicionat: " + this.aireAcondicionat + ", Propietari: " + getNomPropietari();
    }

	private String getNomPropietari() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/p2.odb");
	    EntityManager em = emf.createEntityManager();
	    
	    em.getTransaction().begin();
	    if(propietariId != 0) {
	    	Propietaris p = em.find(Propietaris.class, propietariId);
	    	em.close();
		    emf.close();
	    	return p.getNom();
	    } else {
	    	em.close();
		    emf.close();
	    	return "No té propietari";
	    }   
	}

    
}