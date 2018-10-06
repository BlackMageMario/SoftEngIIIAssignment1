package year4.softeng3.assignment1.courseLib.test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.junit.jupiter.api.Test;
import year4.softeng3.assignment1.courseLib.Student;

public class StudentTest {
    private String testName = "Testy";
    private LocalDate testDate = new LocalDate(1997, 5, 11);
    private String testId = "15310091";
    private int testAge = Years.yearsBetween(testDate, LocalDate.now()).getYears();
    private Student testStudent = new Student(testName, testDate, testId);
    @Test
    void shouldThrowExceptionOnInitialisationIfDateIsInFuture() {
        assertThrows(IllegalArgumentException.class, ()-> new Student(testName, LocalDate.now().plusDays(1), testId));
    }

    @Test
    void shouldThrowExceptionOnInitialisationIfStudentYoungerThanSeventeen() {
        assertThrows(IllegalArgumentException.class, ()-> new Student(testName, LocalDate.now(), testId));
    }

    @Test
    void shouldGetName() {
        assertThat(testName, is(testStudent.getName()));
    }

    @Test
    void shouldSetName() {
        Student modifiedStudent = new Student(testName, testDate, testId);
        modifiedStudent.setName("New Name");
        assertThat("New Name", is(modifiedStudent.getName()));
    }

    @Test
    void shouldGetUsername() {
        assertThat(testName + testAge, is(testStudent.getUsername()));
    }

    @Test
    void shouldGetAge() {
        assertThat(testAge, is(testStudent.getAge()));
    }

    @Test
    void shouldGetDOB() {
        assertThat(testDate, is(testStudent.getDOB()));
    }

    @Test
    void shouldSetDOBIfConditionsMet() {
        Student modifiedStudent = new Student(testName, testDate, testId);
        LocalDate methodTestDate = new LocalDate(1996, 7, 8);
        modifiedStudent.setDOB(methodTestDate);
        assertThat(methodTestDate, is(modifiedStudent.getDOB()));
    }

    @Test
    void shouldThrowExceptionOnSetDOBIfDateAfterCurrentDate() {
        Student modifiedStudent = new Student(testName, testDate, testId);
        assertThrows(IllegalArgumentException.class, ()-> modifiedStudent.setDOB(LocalDate.now().plusDays(1)));
    }

    @Test
    void shouldThrowExceptionOnSetDOBIfRecalculatedAgeIsUnderSeventeen() {
        Student modifiedStudent = new Student(testName, testDate, testId);
        assertThrows(IllegalArgumentException.class, ()-> modifiedStudent.setDOB(LocalDate.now()));
    }

    @Test
    void shouldGetID() {
        assertThat(testId, is(testStudent.getID()));
    }
}