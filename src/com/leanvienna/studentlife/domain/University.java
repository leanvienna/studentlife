package com.leanvienna.studentlife.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class University {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    private Student creator;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Course> courses = new java.util.HashSet<Course>();
}
