package sk.stuba.fei.asos.guts;

import sk.stuba.fei.asos.course.CourseDirectory;
import sk.stuba.fei.asos.course.CourseFactory;
import sk.stuba.fei.asos.schedule.Schedule;
import sk.stuba.fei.asos.schedule.Timeslot;

public class Facade {

    private static Facade instance = null;
    private final CourseDirectory root;
    private final Schedule schedule;

    private final CourseFactory factory;

    private Facade(CourseDirectory root, Schedule schedule, CourseFactory factory) {
        if (root == null || schedule == null || factory == null) {
            throw new IllegalArgumentException();
        }
        this.root = root;
        this.schedule = schedule;
        this.factory = factory;
    }

    public String getCoursesHierarchy() {
        return root.getInfo();
    }

    public String getSchedule() {
        return schedule.toString();
    }

    public void addLecture(String courseName, String teacherName, Timeslot timeslot) {
        schedule.add(courseName, teacherName, timeslot, false, factory);
    }

    public void addSeminar(String courseName, String teacherName, Timeslot timeslot) {
        schedule.add(courseName, teacherName, timeslot, true, factory);
    }

    public static Facade getInstance() {
        if (instance == null) {
            instance = new Facade(FacadeFactory.getDefaultCourseDirectory(), FacadeFactory.getDefaultSchedule(), FacadeFactory.getDefaultFactory());
        }
        return instance;
    }

}
