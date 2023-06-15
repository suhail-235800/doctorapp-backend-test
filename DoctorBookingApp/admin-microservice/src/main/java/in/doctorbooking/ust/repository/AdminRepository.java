package in.doctorbooking.ust.repository;

import in.doctorbooking.ust.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AdminRepository extends JpaRepository<Doctor,Integer> {

    Doctor findByDoctorId(int id);

    Doctor findByDoctorName(String doctorName);

    List<Doctor> findByDoctorSpecialization(String specialization);
}