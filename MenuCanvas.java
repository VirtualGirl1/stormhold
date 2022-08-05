//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import com.nokia.mid.ui.FullCanvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Graphics;

public class MenuCanvas extends FullCanvas {
    Menu menu = null;

    public MenuCanvas() {
    }

    public void paint(Graphics graphics) {
        if (this.menu != null) {
            this.menu.Paint(graphics);
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

    protected void keyPressed(int key) {
        if (this.menu != null) {
            this.menu.KeyPressed(key);
        }

    }
}

