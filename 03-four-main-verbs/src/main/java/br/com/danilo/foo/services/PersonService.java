package br.com.danilo.foo.services;


import br.com.danilo.foo.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();



    public Person create (Person person) {

        return person;
    }

    public Person update (Person person) {

        return person;
    }

    public void delete (String id) {

    }

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person findById(String id) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Danilo");
        person.setLastName("Almeida");
        person.setAddress("Rua qualquer numero 123");
        person.setGender("male");
        return person;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Last Name " + i);
        person.setAddress("Some address in Brazil " + i);
        person.setGender("gender");
        return person;
    }
}
