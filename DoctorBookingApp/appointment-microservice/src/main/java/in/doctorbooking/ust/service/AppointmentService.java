package in.doctorbooking.ust.service;

import in.doctorbooking.ust.domain.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> findAllAppointments();

    void saveAppointment(Appointment appointment);

    Appointment getAppointmentById(int id);
}
