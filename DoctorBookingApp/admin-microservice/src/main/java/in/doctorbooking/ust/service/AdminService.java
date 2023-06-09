package in.doctorbooking.ust.service;

import in.doctorbooking.ust.domain.Doctor;
import in.doctorbooking.ust.dto.DoctorDto;
import in.doctorbooking.ust.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AdminService {

    Doctor save(Doctor doctor);

    List<Doctor> findAllDoctors();

    Doctor findDoctorByName(String doctorName);

    Doctor findById(int id);

    Doctor updateDoctor(Doctor doctor);

    void remove(Doctor doctor);
}
