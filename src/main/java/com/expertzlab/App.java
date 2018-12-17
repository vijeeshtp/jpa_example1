package com.expertzlab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class App 

{
    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main( String[] args )
    {
            PersonRepositoryImpl repository = null;

            Person person = new Person();
            person.setFirstName("ANOOP");
            person.setLastName("KUMAR");
            person.setCreatedDate(LocalDateTime.now());
            person.setDateOfBirth(LocalDate.of(1990, Month.APRIL, 4));

            repository = new PersonRepositoryImpl();
            // Create person
            repository.create(person);

            person = null;
            // Hibernate generates id of 1
            person = repository.read(1L);

            log.info("Person from database: {}", person);

            person.setModifiedDate(LocalDateTime.now());
            person.setFirstName("XXXXX");
            // Update person record
            repository.update(person);

            person = null;
            // Read updated record
            person = repository.read(1L);

            log.info("Person updated: {}", person);
            // Delete person
            //repository.delete(person);

            //person = repository.read(1L);

            log.info("Person deleted: {}", person);

    }
}
