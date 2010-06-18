package com.leanvienna.studentlife.domain;

import com.leanvienna.studentlife.domain.Province;
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

privileged aspect Province_Roo_Entity {
    
    @PersistenceContext
    transient EntityManager Province.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Province.id;
    
    @Version
    @Column(name = "version")
    private Integer Province.version;
    
    public Long Province.getId() {
        return this.id;
    }
    
    public void Province.setId(Long id) {
        this.id = id;
    }
    
    public Integer Province.getVersion() {
        return this.version;
    }
    
    public void Province.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void Province.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Province.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Province attached = this.entityManager.find(this.getClass(), this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Province.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public Province Province.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Province merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager Province.entityManager() {
        EntityManager em = new Province().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Province.countProvinces() {
        return ((Number) entityManager().createQuery("select count(o) from Province o").getSingleResult()).longValue();
    }
    
    @SuppressWarnings("unchecked")
    public static List<Province> Province.findAllProvinces() {
        return entityManager().createQuery("select o from Province o").getResultList();
    }
    
    public static Province Province.findProvince(Long id) {
        if (id == null) return null;
        return entityManager().find(Province.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public static List<Province> Province.findProvinceEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("select o from Province o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
