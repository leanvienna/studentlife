package com.leanvienna.studentlife.domain;

import com.leanvienna.studentlife.domain.Country;
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

privileged aspect Country_Roo_Entity {
    
    @PersistenceContext
    transient EntityManager Country.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Country.id;
    
    @Version
    @Column(name = "version")
    private Integer Country.version;
    
    public Long Country.getId() {
        return this.id;
    }
    
    public void Country.setId(Long id) {
        this.id = id;
    }
    
    public Integer Country.getVersion() {
        return this.version;
    }
    
    public void Country.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void Country.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Country.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Country attached = this.entityManager.find(this.getClass(), this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Country.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public Country Country.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Country merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager Country.entityManager() {
        EntityManager em = new Country().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Country.countCountrys() {
        return ((Number) entityManager().createQuery("select count(o) from Country o").getSingleResult()).longValue();
    }
    
    @SuppressWarnings("unchecked")
    public static List<Country> Country.findAllCountrys() {
        return entityManager().createQuery("select o from Country o").getResultList();
    }
    
    public static Country Country.findCountry(Long id) {
        if (id == null) return null;
        return entityManager().find(Country.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public static List<Country> Country.findCountryEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("select o from Country o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
