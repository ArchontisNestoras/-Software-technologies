package project2023.Diploma_Projects_Management_App.model;

public enum Role {
	STUDENT("Student"),
    PROFESSOR("Professor");

    private final String value;

    private Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}