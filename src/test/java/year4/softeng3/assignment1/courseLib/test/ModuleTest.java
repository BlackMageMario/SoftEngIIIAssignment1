package year4.softeng3.assignment1.courseLib.test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.joda.time.LocalDate;
import org.junit.jupiter.api.Test;
import year4.softeng3.assignment1.courseLib.Module;
import year4.softeng3.assignment1.courseLib.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModuleTest {

    private String testName = "TestModule";
    private String testId = "GY350";
    private Student testStudent = new Student("TestName", new LocalDate(1997, 8, 1), "15310091");
    private Module testModule = new Module(testName, testId, List.of(testStudent));
    @Test
    void shouldThrowExceptionOnInitilisationIfIdInIncorrectFormat() {
        assertThrows(IllegalArgumentException.class, () -> new Module(testName, "NotValidID"));
    }

    @Test
    void shouldGetId() {
        assertThat(testId, is(testModule.getId()));
    }

    @Test
    void shouldGetStudents() {
        assertThat(List.of(testStudent), is(testModule.getStudents()));
    }

    @Test
    void shouldAddStudentIfNotPreviouslyAdded() {
        Module modifiedModule = new Module(testName, testId, List.of(testStudent));
        Student newStudent = new Student("Student", new LocalDate(1998, 8, 2), "testId");
        ArrayList<Student> modifiedList = new ArrayList<>(List.of(testStudent, newStudent));
        modifiedModule.addStudent(newStudent);
        assertThat(modifiedList, is(modifiedModule.getStudents()));
    }

    @Test
    void shouldNotAddStudentIfPreviouslyAdded() {
        Student newStudent = new Student("Student", new LocalDate(1998, 8, 2), "testId");
        ArrayList<Student> modifiedList = new ArrayList<>(List.of(testStudent, newStudent));
        Module modifiedModule = new Module(testName, testId, modifiedList);
        modifiedModule.addStudent(newStudent);
        assertThat(modifiedList, is(modifiedModule.getStudents()));
    }
}
