package year4.softeng3.assignment1.courseLib;

import org.joda.time.LocalDate;
import org.joda.time.Years;

public class Student {
    // no special rules around name, so it can be public
    private String name;
    private int age;
    private LocalDate dob;
    private String id;
    private String username;

    public Student(String name, LocalDate dob, String id) {
        this.id = id;
        this.name = name;

        // check if trying to implement a date into the future
        if(dob.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date is in the future.");
        }
        // create age automatically
        this.age = Years.yearsBetween(dob, LocalDate.now()).getYears();
        if(this.age < 17) {
            throw new IllegalArgumentException("Student is under 17 years old.");
        }
        this.dob = dob;
        this.username = name + age;
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
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
        if(date.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date is in the future.");
        }
        // create age automatically
        int tempAge = Years.yearsBetween(date, LocalDate.now()).getYears();
        if(tempAge < 17) {
            throw new IllegalArgumentException("Student is under 17 years old.");
        }
        this.age = tempAge;
        this.dob = date;
    }

    public String getID() {
        return id;
    }
}
