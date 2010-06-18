package com.leanvienna.studentlife.domain;

import com.leanvienna.studentlife.domain.University;
import java.lang.String;
import java.util.Set;

privileged aspect City_Roo_JavaBean {
    
    public String City.getName() {
        return this.name;
    }
    
    public void City.setName(String name) {
        this.name = name;
    }
    
    public Set<University> City.getUniversities() {
        return this.universities;
    }
    
    public void City.setUniversities(Set<University> universities) {
        this.universities = universities;
    }
    
}
