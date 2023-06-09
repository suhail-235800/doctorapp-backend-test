package in.doctorbooking.ust.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    private int ratingId;
    private int rating;
    private int doctorId;
    private String doctorName;
    private int appointmentId;
    private String appointmentDate;
    private int userId;


}
