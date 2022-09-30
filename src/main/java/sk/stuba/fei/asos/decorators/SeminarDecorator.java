package sk.stuba.fei.asos.decorators;

import sk.stuba.fei.asos.course.Course;

public class SeminarDecorator extends AbstractCourseDecorator {

    public SeminarDecorator(Course c) {
        super(c);
    }

    @Override
    public String getInfo() {
        return cl.getInfo() + " (SEMINAR)";
    }

    @Override
    public String getInfo(String teacher) {
        return cl.getInfo(teacher) + " (SEMINAR)";
    }
}
