package in.doctorbooking.ust.controller;

import in.doctorbooking.ust.domain.Appointment;
import in.doctorbooking.ust.dto.AppointmentDto;
import in.doctorbooking.ust.dto.RequestDto;
import in.doctorbooking.ust.service.AppointmentService;
import in.doctorbooking.ust.service.DoctorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/appointments")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    DoctorService doctorService;
    private Logger logger = LoggerFactory.getLogger(AppointmentController.class);

    @GetMapping("")
    public ResponseEntity<List<AppointmentDto>> getAppointments(){
        List<Appointment> list = appointmentService.findAllAppointments();
        if(list.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        List<AppointmentDto> AppointmentList = list.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(AppointmentList);

    }
    @PostMapping("")
    public ResponseEntity<AppointmentDto> bookAppointment(@RequestBody RequestDto requestDto){
        var doctordto = doctorService.getDoctorById(requestDto.doctorId());
        logger.info(String.valueOf(doctordto));
        if(doctordto == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(requestDto.appointmentDate());
        appointment.setAppointmentTime(requestDto.appointmentTime());
        appointment.setDoctorId(doctordto.doctorId());
        appointment.setDoctorName(doctordto.doctorName());
        appointment.setDoctorSpeciality(doctordto.doctorSpecialization());
        appointment.setDoctorLocation(doctordto.doctorLocation());
        appointment.setUserId(0);
        appointmentService.saveAppointment(appointment);
        return ResponseEntity.ok(convertToDto(appointment));

    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable int id) {
        var appointment = appointmentService.getAppointmentById(id);
        return ResponseEntity.ok(convertToDto(appointment));

    }


    public AppointmentDto convertToDto(Appointment appointment){
        return new AppointmentDto(appointment.getAppointmentId(),appointment.getAppointmentDate(),appointment.getAppointmentTime(),appointment.getDoctorId(),appointment.getDoctorName(),appointment.getDoctorSpeciality(),appointment.getDoctorLocation(),appointment.getUserId());
    }
    public Appointment convertToEntity(AppointmentDto dto){
        return new Appointment(dto.appointmentId(),dto.appointmentDate(),dto.appointmentTime(),dto.doctorId(),dto.doctorName(),dto.doctorSpeciality(),dto.doctorLocation(),dto.userId());
    }

}
