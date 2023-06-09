package in.doctorbooking.ust.service;

import in.doctorbooking.ust.domain.Doctor;
import in.doctorbooking.ust.dto.DoctorDto;
import in.doctorbooking.ust.exceptions.DoctorAlreadyExistsException;
import in.doctorbooking.ust.exceptions.DoctorNotFoundException;
import in.doctorbooking.ust.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminRepository doctorRepository;

    @Override
    public Doctor save(Doctor doctor) {
        Optional<Doctor> test = doctorRepository.findById(doctor.getDoctorId());
        if(test.isPresent()){
            throw new DoctorAlreadyExistsException();
        }
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> findAllDoctors() {
        Optional<List<Doctor>> test = Optional.of(doctorRepository.findAll());
        if(test.isEmpty()){
            throw new DoctorNotFoundException();
        }
        return test.get();
    }

    @Override
    public Doctor findDoctorByName(String doctorName) {
        Optional<Doctor> test = Optional.of(doctorRepository.findByDoctorName(doctorName));
        if(test.isEmpty()){
            throw new DoctorNotFoundException();
        }
        return test.get();
    }

    @Override
    public Doctor findById(int id) {
        return doctorRepository.findByDoctorId(id);
    }


    @Override
    public Doctor updateDoctor(Doctor doctor) {
        Optional<Doctor> test = doctorRepository.findById(doctor.getDoctorId());
        if(test.isEmpty()){
            throw new DoctorNotFoundException();
        }
        return doctorRepository.save(doctor);
    }

    @Override
    public void remove(Doctor doctor) {
        doctorRepository.delete(doctor);
    }
}
