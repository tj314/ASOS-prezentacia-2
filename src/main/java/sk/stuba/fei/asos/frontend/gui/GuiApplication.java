package sk.stuba.fei.asos.frontend.gui;

import sk.stuba.fei.asos.frontend.AbstractApplication;
import sk.stuba.fei.asos.guts.Facade;

import javax.swing.*;
import java.awt.*;

public final class GuiApplication extends AbstractApplication {

    private final JFrame window;
    private final JPanel panel;

    private static final float FONT_SIZE = 18f;

    public GuiApplication(Facade facade) {
        super(facade);
        window = new JFrame("Schedule Application");
        panel = new JPanel(new GridLayout(1, 2));
        window.setLayout(new BorderLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        layout();
    }

    private void layout() {
        window.setLayout(new BorderLayout());
        JTextArea areaLeft = new JTextArea(facade.getCoursesHierarchy());
        areaLeft.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2),
                BorderFactory.createEmptyBorder(10,10,10,10)
        ));
        areaLeft.setEditable(false);
        areaLeft.setFont(areaLeft.getFont().deriveFont(FONT_SIZE));
        panel.add(areaLeft);
        JTextArea areaRight = new JTextArea(facade.getSchedule());
        areaRight.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2),
                BorderFactory.createEmptyBorder(10,10,10,10)
        ));
        areaRight.setEditable(false);
        areaRight.setFont(areaRight.getFont().deriveFont(FONT_SIZE));
        panel.add(areaRight);
        window.add(panel);
        window.setResizable(false);
        window.pack();
    }

    @Override
    public void run() {
        window.setVisible(true);
    }
}
