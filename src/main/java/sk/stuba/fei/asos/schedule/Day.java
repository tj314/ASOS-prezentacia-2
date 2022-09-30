package sk.stuba.fei.asos.schedule;

public enum Day {
    MON(0),
    TUE(1),
    WED(2),
    THU(3),
    FRI(4);
    public final int value;
    Day(int value) {
        this.value = value;
    }

    public static Day intToDay(int value) {
        switch (value) {
            case 0: return MON;
            case 1: return TUE;
            case 2: return WED;
            case 3: return THU;
            case 4: return FRI;
            default: throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case MON: return "Monday";
            case TUE: return "Tuesday";
            case WED: return "Wednesday";
            case THU: return "Thursday";
            case FRI: return "Friday";
            default: return "I am a very dumb compiler!";
        }
    }
}
