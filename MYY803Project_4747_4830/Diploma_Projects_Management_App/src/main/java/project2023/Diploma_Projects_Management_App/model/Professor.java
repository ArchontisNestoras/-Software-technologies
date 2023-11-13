package project2023.Diploma_Projects_Management_App.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="professor")
public class Professor {

	// define fields
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int id;
	
	@Column(name="full_name")
	private String fullname;
	
	@Column(name="speciality")
	private String speciality;

	// define constructors
	
	public Professor() {
		
	}
	
	public Professor(int id) {
		this.id = id;
	}
	
	public Professor(int id, String fullname, String speciality) {
		this.id = id;
		this.fullname = fullname;
		this.speciality = speciality;
	}
	
	// define getter/setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
}
