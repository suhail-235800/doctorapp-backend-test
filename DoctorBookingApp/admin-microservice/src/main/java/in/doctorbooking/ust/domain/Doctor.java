package in.doctorbooking.ust.domain;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "doctors")
public class Doctor
{
    @Id
    @GeneratedValue
    private int doctorId;
    private String doctorName;
    private String doctorSpecialization;
    private String doctorLocation;
    private int doctorRating;


    public Doctor(int doctorId, String doctorName, String doctorSpecialization, String doctorLocation, int doctorRating) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorSpecialization = doctorSpecialization;
        this.doctorLocation = doctorLocation;
        this.doctorRating = doctorRating;
    }
}