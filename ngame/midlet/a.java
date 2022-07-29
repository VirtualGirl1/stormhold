//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ngame.midlet;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public abstract class a extends MIDlet implements CommandListener {
    protected boolean Z = true;
    public String name;
    public Display d = Display.getDisplay(this);
    public static final Command aK = new Command("Exit", 7, 1);
    public static final Command r = new Command("Exit", 7, 1);
    public static final Command aX = new Command("Exit", 7, 1);

    public a() {
    }

    protected final void startApp() throws MIDletStateChangeException {
        this.Begin();
    }

    protected abstract void Begin() throws MIDletStateChangeException;

    public void pauseApp() {
    }

    public void destroyApp(boolean var1) {
    }

    public void b() {
        this.n();
    }

    private void n() {
        this.destroyApp(true);
        this.notifyDestroyed();
    }

    public void commandAction(Command var1, Displayable var2) {
        if (var1 == aK) {
            this.b();
        }

    }
}
