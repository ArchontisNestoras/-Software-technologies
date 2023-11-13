package project2023.Diploma_Projects_Management_App.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="application")
public class Application {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="subjectsid")
	private int subjectsid;
	
	@Column(name="studentid")
	private int studentid;

	// define constructors

	public Application() {
		
	}

	public Application(int subjectsid, int studentid) {
		super();
		this.subjectsid = subjectsid;
		this.studentid = studentid;
	}

	public Application(int id, int subjectsid, int studentid) {
		super();
		this.id = id;
		this.subjectsid = subjectsid;
		this.studentid = studentid;
	}
	
	// define getter/setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSubjects_id() {
		return subjectsid;
	}

	public void setSubjects_id(int subjectsid) {
		this.subjectsid = subjectsid;
	}

	public int getStudent_id() {
		return studentid;
	}

	public void setStudent_id(int studentid) {
		this.studentid = studentid;
	}
		
}