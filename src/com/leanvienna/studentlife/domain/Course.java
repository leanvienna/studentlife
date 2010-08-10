package com.leanvienna.studentlife.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.datanucleus.jpa.annotations.Extension;

@Entity
public class Course implements Serializable, SharedGetters {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String id;

    private String name;
    
    private String professor;
    
    private String identifier;
    
    private Student creator;
    
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Event> events = new java.util.HashSet<Event>();
    
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Task> tasks = new java.util.HashSet<Task>();
    
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Message> messages = new java.util.HashSet<Message>();

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getId() {
		return id;
	}
}
