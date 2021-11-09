package br.com.danilo.foo.services;


import br.com.danilo.foo.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();

    public Person findById( String id) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        return person;
    }
}
