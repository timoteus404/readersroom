package com.example.readersroom.service.dao;

import com.example.readersroom.entity.Members;
import com.example.readersroom.service.MemberService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Profile("jpadao")
public class MemberServiceDaoImpl extends AbsJpaDaoService implements MemberService {


    @Override
    public List<Members> listAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Members", Members.class).getResultList(); //-> no idea why from is mistake
    }

    @Override
    public Members getById(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Members.class, id);
    }

    @Override
    public Members saveOrUpdate(Members entity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Members savedMember = em.merge(entity);
        em.getTransaction().commit();
        return savedMember;
    }

    @Override
    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Members.class, id));
        em.getTransaction().commit();

    }
}
