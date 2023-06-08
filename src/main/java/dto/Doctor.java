package dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Doctor {
	@Id
	@GeneratedValue( generator="doctorid")
	@SequenceGenerator(initialValue=560002,allocationSize=1,name="doctorid",sequenceName="doctorid")
	private int id;
	private String name;
	private long mobile;
	private String email;
	private String password;
	private Date  dob;
	private int age;
	private boolean status;
	private String qualification;
	private String specilization;
	private String gender;
  
		@OneToMany
		List<Appointment>appointments;
		
	}
	

