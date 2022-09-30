package sk.stuba.fei.asos;

import sk.stuba.fei.asos.frontend.gui.GuiApplication;
import sk.stuba.fei.asos.frontend.tui.TuiApplication;
import sk.stuba.fei.asos.guts.Facade;
import sk.stuba.fei.asos.guts.FacadeFactory;

public class Main {
    public static void main(String[] args) {
        // TuiApplication tui = new TuiApplication(Facade.getInstance());
        // tui.run();
        GuiApplication gui = new GuiApplication(Facade.getInstance());
        gui.run();

        // System.out.println(facade.getSchedule());
    }
}