package in.doctorbooking.ust.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentId;
    private String appointmentDate;
    private String appointmentTime;
    private int doctorId;
    private String doctorName;
    private String doctorSpeciality;
    private String doctorLocation;
    private int userId;

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", appointmentDate=" + appointmentDate +
                ", appointmentTime=" + appointmentTime +
                ", doctorId=" + doctorId +
                ", doctorName='" + doctorName + '\'' +
                ", doctorSpeciality='" + doctorSpeciality + '\'' +
                ", doctorLocation='" + doctorLocation + '\'' +
                ", userId=" + userId +
                '}';
    }
}
