package sk.stuba.fei.asos.guts;

import sk.stuba.fei.asos.course.CourseDirectory;
import sk.stuba.fei.asos.course.CourseFactory;
import sk.stuba.fei.asos.schedule.Day;
import sk.stuba.fei.asos.schedule.Schedule;
import sk.stuba.fei.asos.schedule.Timeslot;

public class FacadeFactory {
    public static Facade defaultFacade() {

        final CourseDirectory root;
        final Schedule schedule = new Schedule();
        final CourseFactory factory = new CourseFactory();

        schedule.add("ASOS", "Kossaczký", new Timeslot(Day.TUE, 2), false, factory);
        schedule.add("ASOS", "Marochok", new Timeslot(Day.THU, 3), true, factory);
        schedule.add("AKOD", "Balogh", new Timeslot(Day.TUE, 4), false, factory);
        schedule.add("AKOD", "Balogh", new Timeslot(Day.WED, 2), true, factory);
        schedule.add("NKS", "Zajac", new Timeslot(Day.WED, 7), false, factory);
        schedule.add("NKS", "Zajac", new Timeslot(Day.WED, 9), true, factory);
        // System.out.println(schedule.toString());

        root = new CourseDirectory("FEI STU");
        CourseDirectory graduate = new CourseDirectory("Graduate courses");
        CourseDirectory first_year = new CourseDirectory("1st year");
        CourseDirectory second_year = new CourseDirectory("2nd year");
        first_year.add(factory.getCourse("ZKRY"));
        first_year.add(factory.getCourse("UPB"));
        second_year.add(factory.getCourse("ASOS"));
        second_year.add(factory.getCourse("AKOD"));
        second_year.add(factory.getCourse("NKS"));
        graduate.add(first_year);
        graduate.add(second_year);
        root.add(graduate);
        // System.out.println(root.getInfo());

        return new Facade(root, schedule, factory);
    }
}
