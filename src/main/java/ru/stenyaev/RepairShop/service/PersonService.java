package ru.stenyaev.RepairShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stenyaev.RepairShop.entity.Person;
import ru.stenyaev.RepairShop.repo.PersonRepo;

@Service
public class PersonService {

    @Autowired
    private PersonRepo personRepo;

    public Person registration(Person person) throws Exception {
        if (personRepo.findByUsername(person.getUsername()) != null)
            throw new Exception("такой пользователь уже существует");
//        person.setRoles(List.of(role));
//
        return personRepo.save(person);
    }
}
