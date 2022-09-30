package sk.stuba.fei.asos;

import sk.stuba.fei.asos.frontend.gui.GuiApplication;
import sk.stuba.fei.asos.frontend.tui.TuiApplication;
import sk.stuba.fei.asos.guts.Facade;
import sk.stuba.fei.asos.guts.FacadeFactory;

public class Main {
    public static void main(String[] args) {
        Facade facade = FacadeFactory.defaultFacade();
        TuiApplication tui = new TuiApplication(facade);
        tui.run();
        // GuiApplication gui = new GuiApplication(facade);
        // gui.run();

        // System.out.println(facade.getSchedule());
    }
}