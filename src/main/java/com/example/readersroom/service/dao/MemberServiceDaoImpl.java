package com.example.readersroom.service.dao;

import com.example.readersroom.entity.Member;
import com.example.readersroom.service.MemberService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Profile("jpadao")
public class MemberServiceDaoImpl extends AbsJpaDaoService implements MemberService {


    @Override
    public List<Member> listAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Member", Member.class).getResultList(); //-> no idea why from is mistake
    }

    @Override
    public Member getById(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Member.class, id);
    }

    @Override
    public Member saveOrUpdate(Member entity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Member savedMember = em.merge(entity);
        em.getTransaction().commit();
        return savedMember;
    }

    @Override
    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Member.class, id));
        em.getTransaction().commit();

    }
}
