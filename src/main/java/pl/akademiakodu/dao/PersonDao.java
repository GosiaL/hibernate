package pl.akademiakodu.dao;

import pl.akademiakodu.model.Person;

import java.util.List;

public interface PersonDao {
    void save (Person person);
    List<Person> getAll();
    List<Person> findBySurname(String surname);
}
