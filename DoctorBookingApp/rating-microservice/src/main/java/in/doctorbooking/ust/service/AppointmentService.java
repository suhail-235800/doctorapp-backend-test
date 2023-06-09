package in.doctorbooking.ust.service;

import in.doctorbooking.ust.domain.Appointment;
import in.doctorbooking.ust.dto.AppointmentDto;

import java.util.Optional;

public interface AppointmentService {
    AppointmentDto getAppointment(int id);
}
