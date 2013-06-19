/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author aymeric
 */
@Entity
@Table(uniqueConstraints=
@UniqueConstraint(columnNames = {"id", "email"})) 
public class Geek implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -8776320965095867751L;

    @Id
    @SequenceGenerator(name = "geek_generator", sequenceName = "GEEK_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "geek_generator")
    private long id;
    
    private String firstname;
    
    private String lastname;
    
    private String email;
    
    private Boolean gender; // 0 male
    
    private String password;
    
    private String description;
	
    private String avatar;

    @ManyToMany(cascade = {CascadeType.ALL})
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE}) 
    @JoinTable(name="geek_interest",
    joinColumns={@JoinColumn(name="id_geek")},
    inverseJoinColumns={@JoinColumn(name="id_interest")})
    @JsonIgnore /* bug fix infinite cycling */
    private List<Interest> interests = new ArrayList<Interest>();

    @OneToMany(mappedBy="geek")
    @JsonIgnore /* bug fix infinite cycling */
    private List<Audit> audits = new ArrayList<Audit>();
    
    @Transient
    private int visitCount;
    
    /* Constructeurs */
    public Geek() {
        super();
    }
    
    public Geek(Long id, String firstname, String lastname, String email, Boolean gender) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.gender = gender;
    }

    /* GETTERS & SETTERS */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public List<Interest> getInterests() {
		return interests;
	}

	public void setInterests(List<Interest> interests) {
		this.interests = interests;
	}
    
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public List<String> getInterestNames() {
		List<String> names = new ArrayList<String>();
		for(Interest interest: interests) {
			names.add(interest.getName());
		}
		return names;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public void setVisitCount(int visitCount) {
		this.visitCount = visitCount;
	}
	
    public int getVisitCount() {
    	return audits.size();
    }

	public List<Audit> getAudits() {
		return audits;
	}

	public void setAudits(List<Audit> audits) {
		this.audits = audits;
	}
    
	@Override
    public String toString() {
		return firstname + " " + lastname;
	}
}
