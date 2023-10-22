package ru.stenyaev.RepairShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stenyaev.RepairShop.entity.Appointment;
import ru.stenyaev.RepairShop.repo.AppointmentRepo;
import ru.stenyaev.RepairShop.repo.PersonRepo;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private PersonRepo personRepo;

    public Appointment save(Appointment appointment) {
        return appointmentRepo.save(appointment);
    }
}
