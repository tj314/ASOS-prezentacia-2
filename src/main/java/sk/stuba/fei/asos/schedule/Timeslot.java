package sk.stuba.fei.asos.schedule;

public class Timeslot {
    public static final int MIN_TIMESLOT = 0;
    public static final int MAX_TIMESLOT = 14;

    public final Day day;
    public final int hour;


    public Timeslot(Day day, int hour_slot) {
        if (hour_slot < MIN_TIMESLOT || hour_slot > MAX_TIMESLOT) throw new IllegalArgumentException();
        hour = hour_slot;
        this.day = day;
    }

    public String hour() {
        return (7 + hour) + ":00";
    }

    @Override
    public int hashCode() {
        return day.value * 150 + hour;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == this.getClass() && ((Timeslot) obj).day == this.day && ((Timeslot) obj).hour == this.hour;
    }
}
