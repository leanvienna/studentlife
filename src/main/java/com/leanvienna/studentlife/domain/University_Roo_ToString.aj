package com.leanvienna.studentlife.domain;

import java.lang.String;

privileged aspect University_Roo_ToString {
    
    public String University.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("Name: ").append(getName()).append(", ");
        sb.append("Courses: ").append(getCourses() == null ? "null" : getCourses().size());
        return sb.toString();
    }
    
}
