package in.doctorbooking.ust.service;

import in.doctorbooking.ust.domain.Appointment;
import in.doctorbooking.ust.exceptions.AppointmentNotFoundException;
import in.doctorbooking.ust.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> findAllAppointments() {
        Optional<List<Appointment>> test = Optional.of(appointmentRepository.findAll());
        if(test.isEmpty()){
            throw new AppointmentNotFoundException();
        }
        return test.get();
    }

    @Override
    public void saveAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public Appointment getAppointmentById(int id) {
        var appointment = appointmentRepository.findById(id);
        if(appointment.isEmpty()){
            throw new AppointmentNotFoundException();
        }
        return appointment.get();
    }
}
