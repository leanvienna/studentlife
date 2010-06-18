package com.leanvienna.studentlife.domain;

import com.leanvienna.studentlife.domain.City;
import java.lang.String;
import java.util.Set;

privileged aspect Province_Roo_JavaBean {
    
    public String Province.getName() {
        return this.name;
    }
    
    public void Province.setName(String name) {
        this.name = name;
    }
    
    public Set<City> Province.getCities() {
        return this.cities;
    }
    
    public void Province.setCities(Set<City> cities) {
        this.cities = cities;
    }
    
}
