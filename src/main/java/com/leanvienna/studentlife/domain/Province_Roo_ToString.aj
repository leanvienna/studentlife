package com.leanvienna.studentlife.domain;

import java.lang.String;

privileged aspect Province_Roo_ToString {
    
    public String Province.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("Name: ").append(getName()).append(", ");
        sb.append("Cities: ").append(getCities() == null ? "null" : getCities().size());
        return sb.toString();
    }
    
}
