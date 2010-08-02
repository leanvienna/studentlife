package com.leanvienna.studentlife.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Course {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
}
