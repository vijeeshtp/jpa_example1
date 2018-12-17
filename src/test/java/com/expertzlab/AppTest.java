package com.expertzlab;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import org.junit.*;
public class AppTest
{
private static PersonRepository repository;

    @BeforeClass
    public static void beforeClass() throws SQLException {
        repository = new PersonRepositoryImpl();
    }

    @Before
    public void before() {
        Person person = new Person();
        person.setFirstName("Julius");
        person.setLastName("Krah");
        person.setCreatedDate(LocalDateTime.now());
        person.setDateOfBirth(LocalDate.of(1990, Month.APRIL, 4));

        repository.create(person);
    }

    @Test
    public void testCreate() {
        Person person = new Person();
        person.setFirstName("Loretta");
        person.setLastName("Krah");
        person.setCreatedDate(LocalDateTime.now());
        person.setDateOfBirth(LocalDate.of(1992, Month.AUGUST, 12));
        person = repository.create(person);

        assertThat(person.getId(), is(3L));
    }

    @Test
    public void testUpdate() {
        Person person = repository.read(1L);
        person.setModifiedDate(LocalDateTime.now());
        person.setFirstName("Abeiku");

        person = repository.update(person);
        person = null;

        person = repository.read(1L);
        assertNotNull(person);
        assertThat(person.getFirstName(), is("Abeiku"));
    }

    @Test
    public void testRead() {
        Person person = repository.read(1L);
        assertNotNull(person);
        assertThat(person.getFirstName(), is("Julius"));
    }

    @Test
    public void testDelete() {
        Person person = repository.read(2L);
        assertNotNull(person);
        repository.delete(person);
        person = repository.read(2L);
        assertNull(person);
    }

    @AfterClass
    public static void afterClass() {
    }
}
