import org.joda.time.LocalDate;
import org.joda.time.Years;

public class Student {
    // no special rules around name, so it can be public
    public String name;
    private int age;
    private LocalDate dob; // repalce with Joda time classes
    private String id;
    private String username;

    public Student(String name, LocalDate dob, String id) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        // check if trying to implement a date into the future
        // create age automatically
        this.age = Years.yearsBetween(dob, LocalDate.now()).getYears();
        this.username = name + age;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getDOB() {
        return dob;
    }

    public void setDOB(LocalDate date) {
        this.dob = date;
        this.age = Years.yearsBetween(dob, LocalDate.now()).getYears();
        // recalculate age here
    }

    public String getID() {
        return id;
    }
}
