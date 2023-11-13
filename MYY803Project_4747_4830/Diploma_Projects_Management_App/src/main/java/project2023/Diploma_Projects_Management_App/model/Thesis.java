package project2023.Diploma_Projects_Management_App.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="thesis")
public class Thesis {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="subjectsid")
	private int subjectsid;
	
	@Column(name="studentid")
	private int studentid;
	
	@Column(name="implementationgrade")
	private Float implementationgrade;
	
	@Column(name="reportgrade")
	private Float reportgrade;
	
	@Column(name="presentationgrade")
	private Float presentationgrade;

	@Column(name="grade")
	private Float grade;
	
	// define constructors
	
	public Thesis() {
		
	}
	
	public Thesis(int subjectsid, int studentid) {
		super();
		this.subjectsid = subjectsid;
		this.studentid = studentid;
	}
	
	public Thesis(int id, int subjectsid, int studentid, Float implementationgrade, Float reportgrade, Float presentationgrade, Float grade) {
		super();
		this.id = id;
		this.subjectsid = subjectsid;
		this.studentid = studentid;
		this.implementationgrade = implementationgrade;
		this.reportgrade = reportgrade;
		this.presentationgrade = presentationgrade;
		this.grade = grade;
	}
	
	// define getter/setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSubjectsid() {
		return subjectsid;
	}

	public void setSubjectsid(int subjectsid) {
		this.subjectsid = subjectsid;
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public Float getImplementationgrade() {
		return implementationgrade;
	}

	public void setImplementationgrade(Float implementationgrade) {
		this.implementationgrade = implementationgrade;
	}

	public Float getReportgrade() {
		return reportgrade;
	}

	public void setReportgrade(Float reportgrade) {
		this.reportgrade = reportgrade;
	}

	public Float getPresentationgrade() {
		return presentationgrade;
	}

	public void setPresentationgrade(Float presentationgrade) {
		this.presentationgrade = presentationgrade;
	}
	
	public Float getGrade() {
		return grade;
	}

	public void setGrade(Float grade) {
		this.grade = grade;
	}
	
}
