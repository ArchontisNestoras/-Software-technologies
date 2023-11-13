package project2023.Diploma_Projects_Management_App;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import project2023.Diploma_Projects_Management_App.dao.SubjectDAO;
import project2023.Diploma_Projects_Management_App.model.Subject;

@SpringBootTest
@TestPropertySource(
  locations = "classpath:application.properties")
public class SubjectDAOTest {

    @Autowired
    private SubjectDAO subjectDAO;

    @Test
    void testFindById() {
        Subject subject = subjectDAO.findById(3);
        Assertions.assertNotNull(subject);
        Assertions.assertEquals(3, subject.getId());
    }

    @Test
    void testFindByAssignedFalse() {
        List<Subject> subjects = subjectDAO.findByAssignedFalse();
        Assertions.assertFalse(subjects.isEmpty());
        for (Subject subject : subjects) {
            Assertions.assertEquals(false, subject.getAssigned());
        }
    }



   
}