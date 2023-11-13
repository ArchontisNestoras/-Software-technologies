package project2023.Diploma_Projects_Management_App;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import project2023.Diploma_Projects_Management_App.dao.StudentDAO;
import project2023.Diploma_Projects_Management_App.model.Student;

@SpringBootTest
@TestPropertySource(
  locations = "classpath:application.properties")
public class StudentDAOTest {

    @Autowired
    private StudentDAO studentDAO;

    @Test
    void testFindById() {
        Student student = studentDAO.findById(2);
        Assertions.assertNotNull(student);
        Assertions.assertEquals(2, student.getId());
    }

    @Test
    void testFindByIdAndAssignedFalse() {
        Student student = studentDAO.findByIdAndAssignedFalse(5);
        Assertions.assertNotNull(student);
        Assertions.assertEquals(5, student.getId());
        Assertions.assertEquals(false, student.getAssigned());
    }

   
}