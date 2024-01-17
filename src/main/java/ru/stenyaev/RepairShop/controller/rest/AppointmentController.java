package ru.stenyaev.RepairShop.controller.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.stenyaev.RepairShop.entity.AppToken;
import ru.stenyaev.RepairShop.entity.Appointment;
import ru.stenyaev.RepairShop.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;


    // Исправить

//    @PostMapping
//    public ResponseEntity save(@RequestBody AppToken appToken) {
//
//        try {
//            var appointment = appToken.getAppointment();
//            var token = appToken.getToken();
//            appointmentService.saveAppointment(appointment, token);
//            return new ResponseEntity(HttpStatus.OK);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }

    @PostMapping
    public ResponseEntity save(@RequestBody Appointment appointment) {

        try {

            appointmentService.saveAppointment(appointment);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
