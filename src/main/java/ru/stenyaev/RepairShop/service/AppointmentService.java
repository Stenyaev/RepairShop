package ru.stenyaev.RepairShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;
import ru.stenyaev.RepairShop.entity.Appointment;
import ru.stenyaev.RepairShop.entity.User;
import ru.stenyaev.RepairShop.repo.AppointmentRepo;
import ru.stenyaev.RepairShop.repo.UserRepo;
import ru.stenyaev.RepairShop.utils.JwtTokenUtils;

import java.util.Optional;

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

//    public Appointment saveAppointment(Appointment appointment, String token) {
//        String username = jwtTokenUtils.getUsername(token);
//        Optional<User> user = userRepo.findByUsername(username);
//
//        appointment.setUser(user.get());
//
//        return appointmentRepo.save(appointment);
//    }

    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepo.save(appointment);
    }
}
