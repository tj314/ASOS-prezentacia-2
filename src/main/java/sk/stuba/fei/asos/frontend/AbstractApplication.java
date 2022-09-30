package sk.stuba.fei.asos.frontend;

import sk.stuba.fei.asos.guts.Facade;

public abstract class AbstractApplication implements Runnable {
    protected final Facade facade;

    public AbstractApplication(Facade facade) {
        if (facade == null) throw new IllegalArgumentException();
        this.facade = facade;
    }

}
