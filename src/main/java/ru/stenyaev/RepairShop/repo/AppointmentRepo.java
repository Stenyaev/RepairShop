package ru.stenyaev.RepairShop.repo;

import org.springframework.data.repository.CrudRepository;
import ru.stenyaev.RepairShop.entity.Appointment;


public interface AppointmentRepo extends CrudRepository<Appointment, Long> {
}
