
package com.hms.service;

import com.hms.model.Appointment;
import com.hms.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository repository;

    public Appointment book(Appointment appt) {
        appt.setStatus("BOOKED");
        return repository.save(appt);
    }

    public List<Appointment> getAll() {
        return repository.findAll();
    }
}
