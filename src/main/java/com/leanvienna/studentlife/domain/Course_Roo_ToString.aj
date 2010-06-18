package com.leanvienna.studentlife.domain;

import java.lang.String;

privileged aspect Course_Roo_ToString {
    
    public String Course.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("Name: ").append(getName());
        return sb.toString();
    }
    
}
