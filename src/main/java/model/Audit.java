package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Audit implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @Id
    @SequenceGenerator(name = "audit_generator", sequenceName = "AUDIT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "audit_generator")
    private long id;
    
    @ManyToOne
    @JoinColumn(name="id_geek", nullable=false)
    private Geek geek;
    
    @Column(name = "visit_date")
    private String visitDate;
    
    private String ip;

    public Audit() {
    	super();
    }
    
	public Audit(Geek geek, String visitDate, String ip) {
		super();
		this.geek = geek;
		this.visitDate = visitDate;
		this.ip = ip;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Geek getGeek() {
		return geek;
	}

	public void setGeek(Geek geek) {
		this.geek = geek;
	}

	public String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
    
    
}
