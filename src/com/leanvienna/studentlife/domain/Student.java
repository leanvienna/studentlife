package com.leanvienna.studentlife.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.datanucleus.jpa.annotations.Extension;

@Entity
public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String id;

	private String name;

	private String facebookId;
	
	private Date lastLogin;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<University> universities = new java.util.HashSet<University>();

	@OneToMany(cascade = CascadeType.ALL)
	private Set<Inscription> inscriptions = new java.util.HashSet<Inscription>();
}
