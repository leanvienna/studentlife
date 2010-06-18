package com.leanvienna.studentlife.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@Entity
@RooJavaBean
@RooToString
@RooEntity
public class Country {

    @NotNull
    @Size(min = 2, max = 50)
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<com.leanvienna.studentlife.domain.Province> provinces = new java.util.HashSet<com.leanvienna.studentlife.domain.Province>();
}
