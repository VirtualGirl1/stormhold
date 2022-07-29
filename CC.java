//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import com.nokia.mid.ui.FullCanvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Graphics;

public class CC extends FullCanvas {
    Menu menu = null;

    public CC() {
    }

    public void paint(Graphics var1) {
        if (this.menu != null) {
            this.menu.e(var1);
        }

    }

    public void addCommand(Command var1) {
        if (this.menu != null) {
            this.menu.a(var1);
        }

    }

    public void removeCommand(Command var1) {
        if (this.menu != null) {
            this.menu.b(var1);
        }

    }

    public void setCommandListener(CommandListener var1) {
        if (this.menu != null) {
            this.menu.a(var1);
        }

    }

    protected void keyPressed(int var1) {
        if (this.menu != null) {
            this.menu.b(var1);
        }

    }
}

