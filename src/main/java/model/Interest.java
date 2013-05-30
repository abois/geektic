package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Interest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private long id;
	
	private String nom;
	
	@ManyToMany(mappedBy="interests")
	private Set<Geek> geeks = new HashSet<Geek>();
	
	public Interest(long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public Interest() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<Geek> getGeeks() {
		return geeks;
	}

	public void setGeeks(Set<Geek> geeks) {
		this.geeks = geeks;
	}
	
	
	
}
