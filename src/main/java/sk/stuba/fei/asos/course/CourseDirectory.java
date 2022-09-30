package sk.stuba.fei.asos.course;

import java.util.HashSet;

public class CourseDirectory implements CourseListing {

    private final String name;
    private final HashSet<CourseListing> contents;

    public CourseDirectory(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException();
        this.name = name;
        contents = new HashSet<>();
    }

    public void add(CourseListing cl) {
        if (cl != null) contents.add(cl);
    }

    public void remove(CourseListing cl) {
        if (cl != null) contents.remove(cl);
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder(name);
        for (CourseListing cl: contents) {
            //sb.append(System.lineSeparator());
            sb.append("    ");
            String[] lines = cl.getInfo().split(System.lineSeparator());
            String sep = System.lineSeparator();
            for (String line: lines) {
                sb.append(sep).append("    ").append(line);
                sep = System.lineSeparator();
            }
        }
        return sb.toString();
    }
}
