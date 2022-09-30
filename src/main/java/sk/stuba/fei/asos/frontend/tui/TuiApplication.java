package sk.stuba.fei.asos.frontend.tui;

import sk.stuba.fei.asos.frontend.AbstractApplication;
import sk.stuba.fei.asos.guts.Facade;

import java.util.Scanner;

public final class TuiApplication extends AbstractApplication {

    private final Scanner scanner;

    public TuiApplication(Facade facade) {
        super(facade);
        scanner = new Scanner(System.in);
    }
    @Override
    public void run() {
        boolean running = true;

        System.out.println("   _____      _              _       _                             _ _           _   _             " +
                System.lineSeparator() +
                "  / ____|    | |            | |     | |          /\\               | (_)         | | (_)            " +
                System.lineSeparator() +
                " | (___   ___| |__   ___  __| |_   _| | ___     /  \\   _ __  _ __ | |_  ___ __ _| |_ _  ___  _ __  " +
                System.lineSeparator() +
                "  \\___ \\ / __| '_ \\ / _ \\/ _` | | | | |/ _ \\   / /\\ \\ | '_ \\| '_ \\| | |/ __/ _` | __| |/ _ \\| '_ \\ " +
                System.lineSeparator() +
                "  ____) | (__| | | |  __/ (_| | |_| | |  __/  / ____ \\| |_) | |_) | | | (_| (_| | |_| | (_) | | | |" +
                System.lineSeparator() +
                " |_____/ \\___|_| |_|\\___|\\__,_|\\__,_|_|\\___| /_/    \\_\\ .__/| .__/|_|_|\\___\\__,_|\\__|_|\\___/|_| |_|" +
                System.lineSeparator() +
                "                                                      | |   | |                                    " +
                System.lineSeparator() +
                "                                                      |_|   |_|                                    ");

        System.out.println();
        System.out.println();

        while (running) {
            System.out.print("Enter your choice (h for help): ");
            String input = scanner.nextLine();

            switch (input.toLowerCase()) {
                case "h":
                case "help":
                    System.out.println(getHelp());
                    break;
                case "q":
                case "quit":
                    System.out.println("Exiting!");
                    running = false;
                    break;
                case "s":
                case "sched":
                case "schedule":
                    System.out.println(facade.getSchedule());
                    break;
                case "l":
                case "hierarchy":
                    System.out.println(facade.getCoursesHierarchy());
                    break;
                default:
                    System.out.println("Input " + input + " is not a valid selection!");
                    break;
            }

        }
    }

    private String getHelp() {
        return "h / help ---> print this help text" + System.lineSeparator() +
                "q / quit ---> exit the application" + System.lineSeparator() +
                "s / sched / schedule ---> print the schedule" + System.lineSeparator() +
                "l / hierarchy ---> print the hierarchy of courses";
    }
}
