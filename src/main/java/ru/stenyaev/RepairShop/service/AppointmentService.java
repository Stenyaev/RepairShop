package ru.stenyaev.RepairShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stenyaev.RepairShop.entity.Appointment;
import ru.stenyaev.RepairShop.repo.AppointmentRepo;
import ru.stenyaev.RepairShop.repo.UserRepo;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private UserRepo userRepo;

    public Appointment saveAppointment(Appointment appointment) {
//        var user = userRepo.findByUsername("");
//        appointment.setUser(user.get());

        return appointmentRepo.save(appointment);
    }
}
