import java.util.List;

public class Module {
    public String name;
    private String id;
    private List<Student> students;

    public Module(String name, String id)
    {
        this.name = name;
        this.id = id;
    }

    public Module(String name, String id, List<Student> initalStudents)
    {
        this.name = name;
        // do checking to make sure that the name is in a correct format
        this.id = id;
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

    public void addStudents(List<Student> students) {
        // early optimisation incase we try to add a bunch of students already added
        if(students.containsAll(students)) {
            return;
        }
        for(Student student: students) {
           addStudent(student);
        }
    }
}
