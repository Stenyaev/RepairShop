package ru.stenyaev.RepairShop.repo;

import org.springframework.data.repository.CrudRepository;
import ru.stenyaev.RepairShop.entity.User;

import java.util.Optional;


public interface UserRepo extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
