package pl.akademiakodu.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.akademiakodu.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Person person) {
        entityManager.persist(person);
    }

    @Override
    @Transactional
    public List<Person> getAll() {
        Query query=entityManager.createQuery("Select p from Person p");
        return query.getResultList();
    }
    @Override
    @Transactional
    public List<Person> findBySurname(String surname) {
        Query query = entityManager.createQuery("Select p from Person p WHERE p.surname='"+surname+"'");
        return query.getResultList();
    }
}
