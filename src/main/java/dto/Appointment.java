package dto;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Appointment {
	@Id
	@GeneratedValue( generator="appointmentid")
	
	int id;
	String problems;
	LocalDateTime time;
	
	
	@ManyToOne
	Patient patient;
	
	
@ManyToOne
Doctor doctor;
}
