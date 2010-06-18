package com.leanvienna.studentlife.domain;

import com.leanvienna.studentlife.domain.University;
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

privileged aspect University_Roo_Entity {
    
    @PersistenceContext
    transient EntityManager University.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long University.id;
    
    @Version
    @Column(name = "version")
    private Integer University.version;
    
    public Long University.getId() {
        return this.id;
    }
    
    public void University.setId(Long id) {
        this.id = id;
    }
    
    public Integer University.getVersion() {
        return this.version;
    }
    
    public void University.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void University.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void University.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            University attached = this.entityManager.find(this.getClass(), this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void University.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public University University.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        University merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager University.entityManager() {
        EntityManager em = new University().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long University.countUniversitys() {
        return ((Number) entityManager().createQuery("select count(o) from University o").getSingleResult()).longValue();
    }
    
    @SuppressWarnings("unchecked")
    public static List<University> University.findAllUniversitys() {
        return entityManager().createQuery("select o from University o").getResultList();
    }
    
    public static University University.findUniversity(Long id) {
        if (id == null) return null;
        return entityManager().find(University.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public static List<University> University.findUniversityEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("select o from University o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
