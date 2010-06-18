package com.leanvienna.studentlife.domain;

import java.lang.String;

privileged aspect Course_Roo_JavaBean {
    
    public String Course.getName() {
        return this.name;
    }
    
    public void Course.setName(String name) {
        this.name = name;
    }
    
}
