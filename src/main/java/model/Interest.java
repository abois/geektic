package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Interest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "interest_generator", sequenceName = "INTEREST_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "interest_generator")
	private long id;
	
	private String name;
	
	@ManyToMany(mappedBy="interests")
	private List<Geek> geeks = new ArrayList<Geek>();
	
	public Interest(long id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Geek> getGeeks() {
		return geeks;
	}

	public void setGeeks(List<Geek> geeks) {
		this.geeks = geeks;
	}
	
	
}
