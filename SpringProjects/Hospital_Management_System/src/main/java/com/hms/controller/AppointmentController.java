
package com.hms.controller;

import com.hms.model.Appointment;
import com.hms.service.AppointmentService;
import com.hms.messaging.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService service;

    @Autowired
    private RabbitMQSender sender;

    @PostMapping
    public Appointment bookAppointment(@RequestBody Appointment appt) {
        Appointment saved = service.book(appt);
        sender.send("New appointment booked for patient ID: " + saved.getPatientId());
        return saved;
    }

    @GetMapping
    public List<Appointment> getAll() {
        return service.getAll();
    }
}
