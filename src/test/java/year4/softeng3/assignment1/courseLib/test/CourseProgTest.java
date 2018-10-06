package year4.softeng3.assignment1.courseLib.test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.joda.time.LocalDate;
import org.junit.jupiter.api.Test;
import year4.softeng3.assignment1.courseLib.CourseProg;
import year4.softeng3.assignment1.courseLib.Module;
import year4.softeng3.assignment1.courseLib.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseProgTest {

    private Student testStudent = new Student("Test Student", new LocalDate(1997, 8, 1), "15310091");
    private Module testModule = new Module("Test Module","TM111", List.of(testStudent));
    private List<Module> testModules = List.of(testModule);
    private LocalDate testStartDate = new LocalDate(2018, 10, 6);
    private LocalDate testEndDate = new LocalDate(2022, 10, 6);

    @Test
    void shouldThrowExceptionIfStartDateAfterEndDate() {
        assertThrows(IllegalArgumentException.class, () -> new CourseProg("Test Exception", new LocalDate(2022, 10, 7), testEndDate));
    }
    @Test
    void shouldThrowExceptionIfStartDateEqualsEndDate() {
        assertThrows(IllegalArgumentException.class, () -> new CourseProg("Test Exception", testEndDate, testEndDate));
    }
    @Test
    void shouldAddModuleAddsModuleIfNotAlreadyAdded() {
        CourseProg testCourseProg = new CourseProg("Test Course Program", testStartDate, testEndDate, testModules);
        Module newModule = new Module("Second Test Module", "TY111", new ArrayList<Student>(List.of(testStudent)));
        List expectedModules = List.of(testModule, newModule);
        testCourseProg.addModule(newModule);
        assertThat(testCourseProg.getModules(), is(expectedModules));
    }
    @Test
    void shouldNotAddModuleIfAlreadyAdded() {
        Module newModule = new Module("Second Test Module", "TY111", new ArrayList<>(List.of(testStudent)));
        List<Module> modifiedTestModules = List.of(testModule, newModule);
        CourseProg modifiedCourseProg = new CourseProg("Test Course Program", testStartDate, testEndDate, modifiedTestModules);
        modifiedCourseProg.addModule(newModule);
        assertThat(modifiedCourseProg.getModules(), is(modifiedTestModules));
    }
    @Test
    void shouldGetStartDate() {
        CourseProg testCourseProg = new CourseProg("Test Course Program", testStartDate, testEndDate, testModules);
        assertThat(testCourseProg.getStartLocalDate(), is(testStartDate));
    }
    @Test
    void shouldGetEndDate() {
        CourseProg testCourseProg = new CourseProg("Test Course Program", testStartDate, testEndDate, testModules);
        assertThat(testCourseProg.getEndLocalDate(), is(testEndDate));
    }
}
