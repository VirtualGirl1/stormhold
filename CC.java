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

    public void paint(Graphics graphics) {
        if (this.menu != null) {
            this.menu.e(graphics);
        }

    }

    public void addCommand(Command comm) {
        if (this.menu != null) {
            this.menu.AddElement(comm);
        }

    }

    public void removeCommand(Command comm) {
        if (this.menu != null) {
            this.menu.RemoveElement(comm);
        }

    }

    public void setCommandListener(CommandListener listener) {
        if (this.menu != null) {
            this.menu.SetListener(listener);
        }

    }

    protected void keyPressed(int var1) {
        if (this.menu != null) {
            this.menu.b(var1);
        }

    }
}

