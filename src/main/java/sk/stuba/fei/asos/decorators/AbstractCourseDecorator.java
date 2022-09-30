package sk.stuba.fei.asos.decorators;

import sk.stuba.fei.asos.course.AbstractCourse;
import sk.stuba.fei.asos.course.Course;

public abstract class AbstractCourseDecorator extends AbstractCourse {
    protected Course cl;
    public AbstractCourseDecorator(Course cl) {
        this.cl = cl;
    }
}
