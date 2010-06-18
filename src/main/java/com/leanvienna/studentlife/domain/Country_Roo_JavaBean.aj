package com.leanvienna.studentlife.domain;

import com.leanvienna.studentlife.domain.Province;
import java.lang.String;
import java.util.Set;

privileged aspect Country_Roo_JavaBean {
    
    public String Country.getName() {
        return this.name;
    }
    
    public void Country.setName(String name) {
        this.name = name;
    }
    
    public Set<Province> Country.getProvinces() {
        return this.provinces;
    }
    
    public void Country.setProvinces(Set<Province> provinces) {
        this.provinces = provinces;
    }
    
}
