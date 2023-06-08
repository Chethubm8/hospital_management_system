package dto;
import java.sql.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   int id;
   String name;
Date dob;
int age;
long mobile;
@Lob
byte[] Picture;
	
@OneToMany
List<Appointment> appointment;
}	
	



