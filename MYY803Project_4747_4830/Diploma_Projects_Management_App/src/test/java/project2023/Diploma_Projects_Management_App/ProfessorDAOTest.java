package project2023.Diploma_Projects_Management_App;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import project2023.Diploma_Projects_Management_App.dao.ProfessorDAO;
import project2023.Diploma_Projects_Management_App.model.Professor;

@SpringBootTest
@TestPropertySource(
  locations = "classpath:application.properties")
public class ProfessorDAOTest {

    @Autowired
    private ProfessorDAO professorDAO;

    @Test
    void testFindById() {
        Professor professor = professorDAO.findById(1);
        Assertions.assertNotNull(professor);
        Assertions.assertEquals(1, professor.getId());
    }

}