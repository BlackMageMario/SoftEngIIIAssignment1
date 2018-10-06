package year4.softeng3.assignment1.courseLib;

import java.util.ArrayList;
import java.util.List;

public class Module {
    private static String idPattern = "(^([A-Z]){2,}([0-9])+)";
    public String name;
    private String id;
    private List<Student> students;

    public Module(String name, String id)
    {
        this.name = name;
        if(!id.matches(idPattern)) {
            throw new IllegalArgumentException("id is not in the form [capital characters][0=9]");
        }
        this.id = id;
        this.students = new ArrayList<Student>();
    }

    public Module(String name, String id, List<Student> initalStudents)
    {
        this(name, id);
        students = initalStudents;
    }

    public String getId() {
        return id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        if(!students.contains(student)) {
            students.add(student);
        }
    }

}
