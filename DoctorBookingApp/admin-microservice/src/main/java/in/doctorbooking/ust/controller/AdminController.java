package in.doctorbooking.ust.controller;

import in.doctorbooking.ust.domain.Doctor;
import in.doctorbooking.ust.dto.DoctorDto;
import in.doctorbooking.ust.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    //Add/Update/Delete/View Doctors
    @Autowired
    private AdminService adminService;


    @GetMapping("/home")
    public String showAdminHome() {
        return "admin-home";
    }

    @PostMapping("")
    public ResponseEntity<DoctorDto> addNewDoctor(@RequestBody DoctorDto doctorDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDto(adminService.save(convertToEntity(doctorDto))));

    }

    @GetMapping("")
    public ResponseEntity<List<DoctorDto>> getDoctor() {
        List<Doctor> doctorList = adminService.findAllDoctors();
        if (doctorList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<DoctorDto> doctorDtoList = doctorList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(doctorDtoList);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable int id){
        final var doctor = adminService.findById(id);
        if(doctor!=null){
        return ResponseEntity.ok(convertToDto(doctor));}
        else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping("/{doctorName}")
    public ResponseEntity<DoctorDto> updateDoctor(@PathVariable String doctorName) {
        Optional<Doctor> newdoctor = Optional.of(adminService.findDoctorByName(doctorName));
        if (newdoctor.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(convertToDto(newdoctor.get()));

    }

    @PutMapping("/{doctorName}")
    public ResponseEntity<DoctorDto> updateDoctor(@PathVariable String doctorName,@RequestBody DoctorDto doctorDto){
        Optional<Doctor> newdoctor = Optional.of(adminService.findDoctorByName(doctorName));
        if(newdoctor.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(convertToDto(adminService.updateDoctor(convertToEntity(doctorDto))));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDoctor(@PathVariable int id) {
        Optional<Doctor> newdoctor = Optional.of(adminService.findById(id));
        if(newdoctor.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        adminService.remove(newdoctor.get());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public DoctorDto convertToDto(Doctor doctor){
        return new DoctorDto(doctor.getDoctorId(),doctor.getDoctorName(),doctor.getDoctorSpecialization(), doctor.getDoctorLocation());
    }

    public Doctor convertToEntity(DoctorDto doctorDto){
        return new Doctor(doctorDto.doctorId(),doctorDto.doctorName(),doctorDto.doctorSpecialization(),doctorDto.doctorLocation());
    }


}
