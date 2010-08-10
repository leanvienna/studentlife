package com.leanvienna.studentlife.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.datanucleus.jpa.annotations.Extension;

@Entity
public class Country implements Serializable, SharedGetters {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String id;

    private String name;
    
//    private Student creator;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Province> provinces = new java.util.HashSet<Province>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Province> getProvinces() {
		return provinces;
	}

	public String getId() {
		return id;
	}

	public void addProvince(Province province) {
		this.provinces.add(province);
	}
}
