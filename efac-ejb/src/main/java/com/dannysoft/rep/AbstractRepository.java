package com.dannysoft.rep;

import javax.persistence.EntityManager;

import com.mysema.query.jpa.HQLTemplates;
import com.mysema.query.jpa.impl.JPADeleteClause;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.EntityPath;
import com.dannysoft.model.core.Identifiable;

public abstract class AbstractRepository<T extends Identifiable> implements Repository<T, Long> {
    
    private EntityManager em;

    public AbstractRepository() {
    }

    public AbstractRepository(EntityManager em) {
        this.em = em;
    }    
    

    protected JPAQuery query() {
        return new JPAQuery(em, HQLTemplates.DEFAULT);
    }

    protected JPAQuery from(EntityPath<?> entity) {
        return query().from(entity);
    }

    protected JPADeleteClause delete(EntityPath<?> entity) {
        return new JPADeleteClause(em, entity, HQLTemplates.DEFAULT);
    }

    protected void detach(Object entity) {
        em.detach(entity);
    }

    protected <E> E find(Class<E> type, Long id) {
        return em.find(type, id);
    }

    protected void persist(Object entity) {
        em.persist(entity);
    }

    protected <E> E merge(E entity) {
        return em.merge(entity);
    }

    protected <E extends Identifiable> E persistOrMerge(E entity) {
        if (entity.getId() != null) {
            return merge(entity);
        }
        persist(entity);
        return entity;
    }

    protected void remove(Object entity) {
        em.remove(entity);
    }


}