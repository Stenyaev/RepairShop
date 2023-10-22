package ru.stenyaev.RepairShop.repo;



import ru.stenyaev.RepairShop.entity.Role;

import java.util.Optional;

public interface RoleRepo {
    Optional<Role> findByName(String name);
}
