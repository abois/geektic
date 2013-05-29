/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author aymeric
 */
@Entity
public class Geek implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -8776320965095867751L;

    @Id
    @SequenceGenerator(name = "geek_generator", sequenceName = "GEEK_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "geek_generator")
    private long id;
    
    private String nom;
    
    private String prenom;
    
    private String email;
    /*
    private String gravatar;
    private List<Interet> interets;
    */

    /* Constructeurs */
    public Geek() {
        super();
    }
    
    public Geek(Long id, String nom, String prenom, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }
    
    /* Getters / Setters */
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    /* M�thodes publiques */
    
    
}
