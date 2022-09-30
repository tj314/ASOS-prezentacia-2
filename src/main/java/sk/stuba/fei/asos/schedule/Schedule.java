package sk.stuba.fei.asos.schedule;

import sk.stuba.fei.asos.course.AbstractCourse;
import sk.stuba.fei.asos.course.CourseFactory;
import sk.stuba.fei.asos.decorators.SeminarDecorator;

public class Schedule {

    private final Day[] DAYS = new Day[]{Day.MON, Day.TUE, Day.WED, Day.THU, Day.FRI};
    private final ScheduleData[][] schedule;

    public Schedule() {
        schedule = new ScheduleData[DAYS.length][Timeslot.MAX_TIMESLOT];
    }

    public void add(String courseName, String teacher, Timeslot timeslot, boolean isSeminar, CourseFactory cf) {
        ScheduleData sd;
        if (isSeminar) {
            sd = new ScheduleData(new SeminarDecorator(cf.getCourse(courseName)), teacher);
        } else {
            sd = new ScheduleData(cf.getCourse(courseName), teacher);
        }
        schedule[timeslot.day.value][timeslot.hour] = sd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String sep = "";
        for (Day d: DAYS) {
            sb.append(sep);
            sep = System.lineSeparator();
            sb.append(d.toString());
            sb.append(System.lineSeparator());
            for (int j = 0; j < Timeslot.MAX_TIMESLOT; ++j) {
                if (schedule[d.value][j] == null) continue;
                Timeslot ts = new Timeslot(d, j);
                ScheduleData sd = schedule[d.value][j];
                sb.append(sd.course.getInfo(sd.teacher));
                sb.append(", ");
                sb.append(ts.hour());
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}

class ScheduleData {
    public AbstractCourse course;
    public String teacher;

    public ScheduleData(AbstractCourse course, String teacher) {
        this.course = course;
        this.teacher = teacher;
    }
}