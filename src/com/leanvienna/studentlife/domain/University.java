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
public class University implements Serializable, SharedGetters{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String id;

    private String name;
    
//    private Student creator;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Course> courses = new java.util.HashSet<Course>();

    public void addCourse(Course course) {
    	courses.add(course);
    }
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public Set<Course> getCourses() {
		return courses;
	}
}
