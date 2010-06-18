package com.leanvienna.studentlife.domain;

import com.leanvienna.studentlife.domain.Course;
import java.lang.String;
import java.util.Set;

privileged aspect University_Roo_JavaBean {
    
    public String University.getName() {
        return this.name;
    }
    
    public void University.setName(String name) {
        this.name = name;
    }
    
    public Set<Course> University.getCourses() {
        return this.courses;
    }
    
    public void University.setCourses(Set<Course> courses) {
        this.courses = courses;
    }
    
}
