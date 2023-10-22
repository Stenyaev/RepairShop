package ru.stenyaev.RepairShop.repo;

import org.springframework.data.repository.CrudRepository;
import ru.stenyaev.RepairShop.entity.Person;


public interface PersonRepo extends CrudRepository<Person, Long> {
    Person findByUsername(String username);
}
