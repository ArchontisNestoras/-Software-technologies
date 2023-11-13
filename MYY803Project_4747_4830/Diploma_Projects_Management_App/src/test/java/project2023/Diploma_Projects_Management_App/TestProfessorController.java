package project2023.Diploma_Projects_Management_App;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import project2023.Diploma_Projects_Management_App.controller.ProfessorController;
import project2023.Diploma_Projects_Management_App.model.*;
import project2023.Diploma_Projects_Management_App.service.*;

import java.util.*;

class ProfessorControllerTest {

    @Mock
    private ProfessorService professorService;

    @Mock
    private SubjectService subjectService;

    @Mock
    private ApplicationService applicationService;

    @Mock
    private StudentService studentService;

    @Mock
    private ThesisService thesisService;

    @InjectMocks
    private ProfessorController professorController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testListApplications() {
        User user = mock(User.class);
        Model model = mock(Model.class);
        when(user.getId()).thenReturn((int) 1L);
        when(subjectService.findNotAssignedProfessorsSubjects((int) anyLong())).thenReturn(Collections.emptyList());
        when(applicationService.findBySubjectsid(anyList())).thenReturn(Collections.emptyList());
        when(subjectService.findById(anyInt())).thenReturn(null);
        when(studentService.findByIdAndAssignedFalse(anyInt())).thenReturn(null);
        String result = professorController.listApplications(user, model);
        assertEquals("professor/prof_applicationList", result);
    }

    @Test
    void testAssignedDiplomaList() {
        Model model = mock(Model.class);
        when(thesisService.findAll()).thenReturn(Collections.emptyList());
        when(subjectService.findById(anyInt())).thenReturn(null);
        when(studentService.findById(anyInt())).thenReturn(null);
        String result = professorController.assignedDiplomaList(model);
        assertEquals("/professor/assignedDiplomaList", result);
    }

    @Test
    void testSetGrade() {
        Model model = mock(Model.class);
        when(thesisService.findById(anyInt())).thenReturn(null);
        String result = professorController.setGrade(1, model);
        assertEquals("/professor/applyGrade", result);
    }

    @Test
    void testSaveGrade() {
        Thesis theThesis = mock(Thesis.class);
        when(theThesis.getImplementationgrade()).thenReturn(1.0f);
        when(theThesis.getReportgrade()).thenReturn(1.0f);
        when(theThesis.getPresentationgrade()).thenReturn(1.0f);
        Model model = mock(Model.class);
        String result = professorController.saveGrade(theThesis, model);
        assertEquals("redirect:/professor/dashboard/assignedDiplomaList", result);
    }
}
