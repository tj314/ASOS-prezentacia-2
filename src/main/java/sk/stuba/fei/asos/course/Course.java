package sk.stuba.fei.asos.course;

public class Course extends AbstractCourse {

    private final String name;

    public Course(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException();
        this.name = name;
    }

    @Override
    public String getInfo() {
        return name;
    }

    @Override
    public String getInfo(String teacher) {
        return name + ", " + teacher;
    }
}
