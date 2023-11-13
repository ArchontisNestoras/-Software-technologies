package project2023.Diploma_Projects_Management_App.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	// define fields
	
	@Id
	//@OneToOne
	//@JoinColumn(name="user_id", referencedColumnName = "id", nullable = false)
	@Column(name="user_id", unique=true)
	private Integer id;
	
	@Column(name="full_name", unique=true)
	private String fullname;
	
	@Column(name="year_of_studies")
	private Integer yearsofstudies;
	
	@Column(name="current_average_grade")
	private Float currentaveragegrade;
	
	@Column(name="number_of_remaining_courses_for_graduation")
	private Integer numberofremainingcoursesforgraduation;
	
	@Column(name="assigned")
	private Boolean assigned;

	// define constructors
	
	public Student() {
		
	}
	
	public Student(Integer id, Boolean assigned) {
		this.id = id;
		this.assigned = assigned;
	}
	
	public Student(Integer id, String fullname, Integer yearsofstudies, Float currentaveragegrade, Integer numberofremainingcoursesforgraduation, Boolean assigned) {
		this.id = id;
		this.fullname = fullname;
		this.yearsofstudies = yearsofstudies;
		this.currentaveragegrade = currentaveragegrade;
		this.numberofremainingcoursesforgraduation = numberofremainingcoursesforgraduation;
		this.assigned = assigned;
	}

	// define getter/setter
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Integer getYearsofstudies() {
		return yearsofstudies;
	}

	public void setYearsofstudies(Integer yearsofstudies) {
		this.yearsofstudies = yearsofstudies;
	}

	public Float getCurrentaveragegrade() {
		return currentaveragegrade;
	}

	public void setCurrentaveragegrade(Float currentaveragegrade) {
		this.currentaveragegrade = currentaveragegrade;
	}

	public Integer getNumberofremainingcoursesforgraduation() {
		return numberofremainingcoursesforgraduation;
	}

	public void setNumberofremainingcoursesforgraduation(Integer numberofremainingcoursesforgraduation) {
		this.numberofremainingcoursesforgraduation = numberofremainingcoursesforgraduation;
	}

	public Boolean getAssigned() {
		return assigned;
	}

	public void setAssigned(Boolean assigned) {
		this.assigned = assigned;
	}
	
}
