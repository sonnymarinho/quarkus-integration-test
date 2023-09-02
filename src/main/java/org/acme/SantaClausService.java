package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class SantaClausService {
    @Inject
    EntityManager em;

    @Transactional
    public Gift getGift(Long id) {
        return em.find(Gift.class, id);
    }

    @Transactional
    public void create(Gift gift) {
        em.persist(gift);
    }

    public Gift get(Long id) {
        return getGift(id);
    }
}