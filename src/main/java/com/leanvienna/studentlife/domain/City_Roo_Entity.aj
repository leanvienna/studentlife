package com.leanvienna.studentlife.domain;

import com.leanvienna.studentlife.domain.City;
import java.lang.Integer;
import java.lang.Long;
import java.lang.SuppressWarnings;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import org.springframework.transaction.annotation.Transactional;

privileged aspect City_Roo_Entity {
    
    @PersistenceContext
    transient EntityManager City.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long City.id;
    
    @Version
    @Column(name = "version")
    private Integer City.version;
    
    public Long City.getId() {
        return this.id;
    }
    
    public void City.setId(Long id) {
        this.id = id;
    }
    
    public Integer City.getVersion() {
        return this.version;
    }
    
    public void City.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void City.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void City.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            City attached = this.entityManager.find(this.getClass(), this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void City.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public City City.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        City merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager City.entityManager() {
        EntityManager em = new City().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long City.countCitys() {
        return ((Number) entityManager().createQuery("select count(o) from City o").getSingleResult()).longValue();
    }
    
    @SuppressWarnings("unchecked")
    public static List<City> City.findAllCitys() {
        return entityManager().createQuery("select o from City o").getResultList();
    }
    
    public static City City.findCity(Long id) {
        if (id == null) return null;
        return entityManager().find(City.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public static List<City> City.findCityEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("select o from City o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
