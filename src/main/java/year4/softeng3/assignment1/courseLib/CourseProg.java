package year4.softeng3.assignment1.courseLib;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

public class CourseProg {
    public String name;
    private List<Module> modules;
    private LocalDate startLocalDate;
    private LocalDate endLocalDate;

    public CourseProg(String name, LocalDate startLocalDate, LocalDate endLocalDate) {
        this.name = name;
        // need to make sure that the endDate is not before the startDate or that they are equal
        if (endLocalDate.isBefore(startLocalDate)) {
            throw new IllegalArgumentException("End date is before the start date.");
        }
        if (startLocalDate.isEqual(endLocalDate)) {
            throw new IllegalArgumentException("Start date and end date are equivalent, the same day.");
        }
        this.startLocalDate = startLocalDate;
        this.endLocalDate = endLocalDate;
        this.modules = new ArrayList<Module>();
    }

    public CourseProg(String name, LocalDate startLocalDate, LocalDate endLocalDate, List<Module> initalModules) {
        this(name, startLocalDate, endLocalDate);
        this.modules = initalModules;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void addModule(Module module) {
        if(!modules.contains(module)) {
            modules.add(module);
        }
    }

    public LocalDate getStartLocalDate() {
        return startLocalDate;
    }

    public LocalDate getEndLocalDate() {
        return endLocalDate;
    }
}
