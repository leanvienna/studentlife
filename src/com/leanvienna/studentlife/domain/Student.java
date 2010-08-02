package com.leanvienna.studentlife.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String facebookId;
	
	private Date lastLogin;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<University> universities = new java.util.HashSet<University>();

	@OneToMany(cascade = CascadeType.ALL)
	private Set<Inscription> inscriptions = new java.util.HashSet<Inscription>();
}
