package project2023.Diploma_Projects_Management_App.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="subjects")
public class Subject {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="objectives")
	private String objectives;
	
	@Column(name="supervisor")
	private int supervisor;
	
	@Column(name="assigned")
	private Boolean assigned;
	
	// define constructors
	
	public Subject() {
		
	}
	
	public Subject(int supervisor, Boolean assigned) {
		this.supervisor = supervisor;
		this.assigned = assigned;
	}
	
	public Subject(int id, String title, String objectives, int supervisor, Boolean assigned) {
		super();
		this.id = id;
		this.title = title;
		this.objectives = objectives;
		this.supervisor = supervisor;
		this.assigned = assigned;
	}

	// define getter/setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getObjectives() {
		return objectives;
	}

	public void setObjectives(String objectives) {
		this.objectives = objectives;
	}

	public int getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(int supervisor) {
		this.supervisor = supervisor;
	}

	public Boolean getAssigned() {
		return assigned;
	}

	public void setAssigned(Boolean assigned) {
		this.assigned = assigned;
	}
	
}
