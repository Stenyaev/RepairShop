package ru.stenyaev.RepairShop.repo;



import org.springframework.data.repository.CrudRepository;
import ru.stenyaev.RepairShop.entity.Role;

import java.util.Optional;

public interface RoleRepo extends CrudRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
