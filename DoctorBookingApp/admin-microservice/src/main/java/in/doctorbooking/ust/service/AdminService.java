package in.doctorbooking.ust.service;

import in.doctorbooking.ust.domain.Doctor;

import java.util.List;

public interface AdminService {

    Doctor save(Doctor doctor);

    List<Doctor> findAllDoctors();

    Doctor findDoctorByName(String doctorName);
    
    Doctor updateDoctor(Doctor doctor);

    void remove(Doctor doctor);

    List<Doctor> getDoctorBySpecializations(String specialization);

    Doctor findById(int id);
}
