import org.joda.time.LocalDate;
import java.util.List;

public class CourseProg {
    public String name;
    private List<Module> modules;
    private LocalDate startLocalDate;
    private LocalDate endLocalDate;

    public CourseProg(String name, List<Module> initalModules, LocalDate startLocalDate, LocalDate endLocalDate) {
        this.modules = initalModules;
        this.name = name;
        this.startLocalDate = startLocalDate;
        this.endLocalDate = endLocalDate;
    }

    public CourseProg(String name, LocalDate startLocalDate, LocalDate endLocalDate) {
        this.name = name;
        this.startLocalDate = startLocalDate;
        this.endLocalDate = endLocalDate;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void addModule(Module module) {
        if(!modules.contains(module)) {
            modules.add(module);
        }
    }

    public void addModules(List<Module> newModules) {
        // early optimisation in case we try to add a bunch of already added modules
        if(modules.containsAll(newModules)) {
            return;
        }
        for(Module module: newModules) {
            addModule(module);
        }
    }

    public LocalDate getStartLocalDate() {
        return startLocalDate;
    }

    public LocalDate getEndLocalDate() {
        return endLocalDate;
    }
}
