package sk.stuba.fei.asos.course;

import java.util.HashMap;
import java.util.List;

public class CourseFactory {
    private final HashMap<String, Course> courses;

    public CourseFactory() {
        courses = new HashMap<>();
    }

    public Course getCourse(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException();
        Course c = courses.get(name);
        if (c == null) {
            c = new Course(name);
            courses.put(name, c);
        }
        return c;
    }
}
