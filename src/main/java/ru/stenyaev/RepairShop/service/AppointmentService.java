package ru.stenyaev.RepairShop.service;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;
import ru.stenyaev.RepairShop.entity.Appointment;
import ru.stenyaev.RepairShop.repo.AppointmentRepo;
import ru.stenyaev.RepairShop.repo.UserRepo;
import ru.stenyaev.RepairShop.utils.JwtTokenUtils;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    public Appointment saveAppointment(Appointment appointment, String token) {
        String username = jwtTokenUtils.getUsername(token);
        var user = userRepo.findByUsername(username);
        appointment.setUser(user.get());

        return appointmentRepo.save(appointment);
    }
}
