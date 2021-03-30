package com.example.readersroom.service.dao;

import com.example.readersroom.entity.Books;
import com.example.readersroom.service.BookService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Profile("jpadao")
public class BookServiceDaoImpl extends AbsJpaDaoService implements BookService {


    @Override
    public List<Books> listAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Books", Books.class).getResultList(); //-> no idea why from is mistake
    }

    @Override
    public Books getById(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Books.class, id);
    }

    @Override
    public Books saveOrUpdate(Books entity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Books savedBook = em.merge(entity);
        em.getTransaction().commit();
        return savedBook;
    }

    @Override
    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Books.class, id));
        em.getTransaction().commit();

    }
}
