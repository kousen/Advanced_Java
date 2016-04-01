package database.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JpaPersonDAO implements PersonDAO {
    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("hr");

    @Override
    public List<Person> findAll() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Person> people = em.createQuery(
                "select p from Person p", Person.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return people;
    }

    @Override
    public Person findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, id);
        em.getTransaction().commit();
        em.close();
        return person;
    }

    @Override
    public Integer save(Person p) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        return p.getId();
    }

    @Override
    public void delete(Person p) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Person.class, p.getId()));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Integer> getIds() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Integer> ids = em.createQuery("select p.id from Person p", Integer.class)
                .getResultList();
        return ids;
    }
}
