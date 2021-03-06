package com.leanvienna.studentlife.domain;

import java.lang.String;

privileged aspect Country_Roo_ToString {
    
    public String Country.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("Name: ").append(getName()).append(", ");
        sb.append("Provinces: ").append(getProvinces() == null ? "null" : getProvinces().size());
        return sb.toString();
    }
    
}
