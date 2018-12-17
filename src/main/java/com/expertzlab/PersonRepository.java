package com.expertzlab;

public interface PersonRepository {
    Person create(Person person);
    Person read(Long id);
    Person update(Person person);
    void delete(Person person);

}
