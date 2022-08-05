//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Vector;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.Screen;
import javax.microedition.lcdui.StringItem;

public class Menu implements Runnable {
    static MenuCanvas[] MenuCanvases = new MenuCanvas[2];
    static int CanasIndx;
    static Image Img;
    Vector MenuElements;
    CommandListener Listener;
    static final Font SmallBold1;
    private static final Font MedBold1;
    private static final Font SmallPlain;
    static final Font SmallBold2;
    static final Font MedBold2;
    static final Command OKComm;
    static final Command SelectComm;
    static final Command CancelComm;
    static final Command BackComm;
    static final Command ExitComm;
    static final String[] CRStrings;
    int MenuType;
    int MenuID;
    int npcID;
    private ESGame Game;
    Screen Scrn;
    int f;
    private int h;
    Vector n;
    String M;
    String[] E;
    volatile int LoadPct;
    private boolean ja;
    private Thread thread;
    long C;
    Displayable displayable;
    Object Prev;
    Object Next;
    int o;
    int e;
    int G;
    Font CurFont;
    int g;
    int F;
    int w;
    int v;
    int k;
    boolean A = false;

    public Menu(ESGame game, int type, int menuID) {
        this.Game = game;
        this.MenuType = type;
        this.MenuID = menuID;
        this.npcID = 0;
        this.Scrn = null;
        this.f = 0;
        this.Prev = null;
        this.Next = null;
        this.M = null;
        this.E = null;
        this.thread = null;
        this.MenuElements = new Vector(5);
    }

    void SetDisplayableE() {
        this.displayable = MenuCanvases[CanasIndx];
    }

    void SetDisplayableO() {
        this.displayable = MenuCanvases[CanasIndx];
    }

    void BuildMenu(String title, String[] options, Vector vec) {
        this.BuildMenu(title, options, vec, true);
    }

    void BuildMenu(String title, String[] options, Vector vec, boolean bool) {
        List list = new List(title, 3);
        this.Scrn = list;
        this.f = 1;
        int optnlen = options.length;

        for(int i = 0; i < optnlen; ++i) {
            list.append(options[i], (Image)null);
        }

        this.n = vec;
        this.w = 0;
        this.v = 0;
        this.k = 0;
        this.displayable = MenuCanvases[CanasIndx];
        this.AddElement(SelectComm);
        if (bool) {
            this.AddElement(CancelComm);
        }

        this.SetListener((CommandListener)this.Game);
    }

    void BuildEndCreditMenu() {
        String CreditStr = "";

        for(int i = 0; i < CRStrings.length; ++i) {
            CreditStr = CreditStr + CRStrings[i];
        }

        this.BuildMenu("Exiting", CreditStr);
        this.RemoveElement(OKComm);
        this.AddElement(ExitComm);
    }

    void BuildMenu(String title, String content) {
        this.BuildMenu(title, content, false);
    }

    void BuildMenu(String title, String content, boolean bool) {
        Form form = new Form(title);
        this.Scrn = form;
        this.f = 2;
        StringItem contentstr = new StringItem((String)null, content);
        form.append(contentstr);
        this.g = 10;
        this.F = 10;
        this.w = 0;
        this.v = 0;
        this.k = 0;
        this.displayable = MenuCanvases[CanasIndx];
        this.AddElement(OKComm);
        this.SetListener((CommandListener)this.Game);
    }

    void BuildMenu(String title, String header, String[] content, Vector vec) {
        this.BuildMenu(title, header, content, vec, false);
    }

    void BuildMenu(String title, String header, String[] optionsText, Vector vec, boolean bool) {
        Form form = new Form(title);
        this.Scrn = form;
        this.f = 2;
        StringItem headerItem = new StringItem((String)null, header);
        form.append(headerItem);
        this.g = 15;
        this.F = 15;
        ChoiceGroup cgroup = new ChoiceGroup((String)null, 1);
        int choicelen = optionsText.length;

        for(int i = 0; i < choicelen; ++i) {
            cgroup.append(optionsText[i], (Image)null);
        }

        this.h = 1;
        form.append(cgroup);
        this.n = vec;
        this.w = 0;
        this.v = 0;
        this.k = 0;
        this.displayable = MenuCanvases[CanasIndx];
        this.AddElement(SelectComm);
        this.AddElement(CancelComm);
        this.SetListener((CommandListener)this.Game);
        if (header != null && header.indexOf("<TAG>") >= 0) {
            this.M = new String(header);
        }

    }

    void BuildMenu(String title, String header, String subheader, String[] optiontxt, Vector vec) {
        Form form = new Form(title);
        this.Scrn = form;
        this.f = 2;
        StringItem var7 = new StringItem((String)null, header);
        form.append(var7);
        StringItem var8 = new StringItem((String)null, subheader);
        form.append(var8);
        this.g = 15;
        this.F = 15;
        ChoiceGroup var9 = new ChoiceGroup((String)null, 1);
        int var10 = optiontxt.length;

        for(int i = 0; i < var10; ++i) {
            var9.append(optiontxt[i], (Image)null);
        }

        this.h = 2;
        form.append(var9);
        this.n = vec;
        this.displayable = MenuCanvases[CanasIndx];
        this.AddElement(SelectComm);
        this.AddElement(CancelComm);
        this.SetListener((CommandListener)this.Game);
    }

    public void Paint(Graphics graphics) {
        Graphics imgGraphics = Img.getGraphics();
        switch (this.MenuType) {
            case 1:
                System.out.println("        IN CANVAS DOWNLOAD PAINT!");
                break;
            case 2:
                this.PaintSplashScreens(imgGraphics);
                break;
            case 3:
                this.c(imgGraphics);
                break;
            case 4:
                this.d(imgGraphics);
                break;
            case 5:
                this.a(imgGraphics, 1);
                break;
            case 6:
                this.a(imgGraphics, 2);
            case 7:
            default:
                break;
            case 8:
            case 9:
            case 10:
            case 11:
                this.DrawWaitMenu(imgGraphics);
        }

        this.DrawBottomBar(imgGraphics);
        graphics.drawImage(Img, 0, 0, 20);
    }

    private void PaintSplashScreens(Graphics graphics) {
        graphics.setColor(0X000000);
        graphics.fillRect(0, 0, this.GetWidth(), 20 + this.GetHeight());
        if (ESGame.aG) {
            graphics.setColor(0XFFFFFF);
            graphics.fillRect(0, 0, this.GetWidth(), 20 + this.GetHeight());
            graphics.drawImage(ESGame.Vir2lLogo, this.GetWidth() / 2, 10, 17);
            int var2 = 10 + ESGame.Vir2lLogo.getHeight() + 3;
            graphics.setColor(0);

            for(int i = 0; i < CRStrings.length; ++i) {
                graphics.drawString(CRStrings[i], this.GetWidth() / 2, var2, 17);
                var2 += 14;
            }

            graphics.drawString("Distributed by:", this.GetWidth() / 2, 143, 17);
            graphics.drawImage(ESGame.MformLogo, this.GetWidth() / 2, 158, 17);
        } else if (this.Game.ac) {
            graphics.setColor(0X000000);
            graphics.fillRect(0, 0, this.GetWidth(), 20 + this.GetHeight());
            graphics.drawImage(ESGame.SplashTop, this.GetWidth() / 2, 20, 17);
            graphics.drawImage(ESGame.SplashBot, this.GetWidth() / 2, 100, 17);
        } else {
            graphics.setColor(0X000000);
            graphics.fillRect(0, 0, this.GetWidth(), 20 + this.GetHeight());
            graphics.drawImage(ESGame.SplashTop, this.GetWidth() / 2, 20, 17);
            graphics.drawImage(ESGame.SplashBot, this.GetWidth() / 2, 100, 17);
            graphics.setColor(0XFFFFFF);
            graphics.fillRect(12, 165, 152, 22);
            graphics.setColor(0XA00000);
            graphics.fillRect(13, 166, 3 * this.LoadPct / 2, 20);
        }

    }

    private void DrawWaitMenu(Graphics graphics) {
        graphics.setColor(0XAE682E);
        graphics.fillRect(0, 0, this.GetWidth(), 20 + this.GetHeight());
        graphics.setFont(MedBold2);
        graphics.setColor(0XFFFFFF);
        int width = this.GetWidth() / 2;
        if (this.MenuType == 8) {
            graphics.drawString("Creating New Game", width, 30, 17);
        } else if (this.MenuType == 9) {
            graphics.drawString("Loading Game", width, 30, 17);
        } else if (this.MenuType == 10) {
            graphics.drawString("Saving Game", width, 30, 17);
        } else if (this.MenuType == 11) {
            graphics.drawString("Loading Dungeon", width, 30, 17);
        }

        graphics.drawString("Please Wait", width, 45, 17);
        graphics.setColor(0XFFFFFF);
        graphics.fillRect((this.GetWidth() - 90) / 2, 60, 90, 20);
        int loadWidth = this.LoadPct * 88 / 100;
        graphics.setColor(0X0000FF);
        graphics.fillRect((this.GetWidth() - 88) / 2, 61, loadWidth, 18);
    }

    private void DrawTopBar(Graphics graphics, String txt) {
        Font font = graphics.getFont();
        graphics.setFont(MedBold1);
        int color = graphics.getColor();
        graphics.setColor(0X000000);
        graphics.fillRect(0, 0, this.GetWidth(), 14);
        graphics.setColor(0XFFFFFF);
        graphics.drawString(txt, this.GetWidth() / 2, 0, 17);
        graphics.setColor(color);
        graphics.setFont(font);
    }

    private void c(Graphics graphics) {
        graphics.setColor(0XAE682E);
        graphics.fillRect(0, 0, this.GetWidth(), 20 + this.GetHeight());
        this.DrawTopBar(graphics, this.Scrn.getTitle());
        this.CurFont = SmallBold2;
        graphics.setFont(this.CurFont);
        this.o = this.CurFont.getHeight();
        this.e = 20;
        this.G = 15;
        String[] optStrings = this.GetOptStrings();
        int len = optStrings.length;
        byte var4 = 10;
        int var5 = Math.min(len, var4);
        this.v = this.w + var5 - 1;

        for(int i = this.w; i <= this.v; ++i) {
            this.DrawOptionTxt(graphics, optStrings[i], i == this.GetSelectedIndex());
        }

        if (this.w > 0) {
            this.DrawTriangle(graphics, 155, 180, 1);
        }

        if (this.v + 1 < len) {
            this.DrawTriangle(graphics, 165, 180, 2);
        }

    }

    private void a(Graphics graphics, int var2) {
        Form form = (Form)this.Scrn;
        graphics.setColor(0XAE682E);
        graphics.fillRect(0, 0, this.GetWidth(), 20 + this.GetHeight());
        this.DrawTopBar(graphics, form.getTitle());
        this.CurFont = SmallBold2;
        graphics.setFont(this.CurFont);
        this.o = this.CurFont.getHeight();
        this.e = 20;
        this.G = 15;

        int j;
        for(int i = 0; i < var2; ++i) {
            StringItem stritem = (StringItem)form.get(i);
            String text = stritem.getText();
            if (this.A) {
                String[] var7 = this.StrtoList(text);

                for(j = 0; j < var7.length; ++j) {
                    graphics.setColor(0XFFFF00);
                    graphics.drawString(var7[j], this.G, this.e, 20);
                    this.e += this.o;
                }
            } else {
                if (i == 0) {
                    graphics.setColor(0XFFFF00);
                } else {
                    graphics.setColor(0XFFFFFF);
                }

                graphics.drawString(text, this.G, this.e, 20);
                this.e += this.o;
            }
        }

        this.e += 5;
        String[] var10 = this.GetOptStrings();
        int var11 = var10.length;
        byte var12 = 9;
        j = Math.min(var11, var12);
        this.v = this.w + j - 1;

        for(int i = this.w; i <= this.v; ++i) {
            this.DrawOptionTxt(graphics, var10[i], i == this.GetSelectedIndex());
        }

        if (this.w > 0) {
            this.DrawTriangle(graphics, 155, 180, 1);
        }

        if (this.v + 1 < var11) {
            this.DrawTriangle(graphics, 165, 180, 2);
        }

    }

    private void DrawOptionTxt(Graphics graphics, String var2, boolean highlight) {
        if (highlight) {
            graphics.setColor(0X666666);
            int var4 = this.GetWidth() - 2 * (this.G - 10);
            int var5 = this.o + 2;
            graphics.fillRect(this.G - 10, this.e - 1, var4, var5);
        }

        graphics.setColor(0XFFFF00);
        graphics.drawString(var2, this.G, this.e, 20);
        this.e += this.o;
        ++this.e;
    }

    private void d(Graphics graphics) {
        Form form = (Form)this.Scrn;
        graphics.setColor(0XAE682E);
        graphics.fillRect(0, 0, this.GetWidth(), 20 + this.GetHeight());
        this.DrawTopBar(graphics, form.getTitle());
        this.CurFont = SmallBold2;
        graphics.setFont(this.CurFont);
        this.o = this.CurFont.getHeight();
        this.e = 20;
        this.G = 5;
        StringItem var3 = (StringItem)form.get(0);
        String var4 = var3.getText();
        String[] var5 = this.StrtoList(var4);
        this.k = var5.length;
        byte var6 = 11;
        int var7 = Math.min(this.k, var6);
        this.v = this.w + var7 - 1;
        graphics.setColor(0XFFFF00);

        for(int i = this.w; i <= this.v; ++i) {
            String var9 = var5[i];
            graphics.drawString(var9, this.G, this.e, 20);
            this.e += this.o;
        }

        if (this.w > 0) {
            this.DrawTriangle(graphics, 155, 180, 1);
        }

        if (this.v + 1 < this.k) {
            this.DrawTriangle(graphics, 165, 180, 2);
        }

    }

    private void DrawTriangle(Graphics graphics, int xtip, int ytip, int dir) {
        int color = graphics.getColor();
        graphics.setColor(0X000000);
        byte height = 5;
        int i;
        if (dir == 1) {
            for(i = 0; i < height; ++i) {
                graphics.drawLine(xtip - i, ytip + i, xtip + i, ytip + i);
            }
        } else {
            for(i = 0; i < height; ++i) {
                graphics.drawLine(xtip - (height - i), ytip + i, xtip + (height - i), ytip + i);
            }
        }

    }

    String[] StrtoList(String str) {
        Vector strvec = new Vector();
        String[] strlist = this.LinestoList(str);
        int len = strlist.length;

        for(int i = 0; i < len; ++i) {
            String newStr = strlist[i];
            this.a(strvec, newStr);
        }

        return VectoList(strvec);
    }

    private String[] LinestoList(String str) {
        Vector vec = new Vector();
        int strtIndx = 0;
        boolean var4 = false;

        do {
            int indx = str.indexOf('\n', strtIndx);
            if (indx < 0) {
                indx = str.length();
                vec.addElement(str.substring(strtIndx, indx));
                break;
            }

            vec.addElement(str.substring(strtIndx, indx));
            strtIndx = indx + 1;
        } while(strtIndx < str.length());

        return VectoList(vec);
    }

    private void a(Vector vec, String str) {
        int strspace = this.GetWidth() - this.g - this.F;
        String[] strlist = func.SeparateStringBySpace(str);
        int len = strlist.length;
        String var6 = "";

        for(int i = 0; i < len; ++i) {
            String var8 = strlist[i];
            String var9 = var6 + var8;
            if (this.CurFont.stringWidth(var9) > strspace) {
                if (this.CurFont.stringWidth(var8) <= strspace) {
                    vec.addElement(new String(var6));
                    var9 = var8;
                } else {
                    if (var6.length() > 0) {
                        vec.addElement(new String(var6));
                    }

                    String[] var10 = this.d(var8);

                    for(int j = 0; j < var10.length - 1; ++j) {
                        vec.addElement(new String(var10[j]));
                    }

                    var9 = var10[var10.length - 1];
                }
            }

            var6 = var9;
            if (i < len - 1) {
                var9 = var9 + " ";
                if (this.CurFont.stringWidth(var9) > strspace) {
                    vec.addElement(new String(var6));
                    var6 = "";
                } else {
                    var6 = var9;
                }
            }
        }

        vec.addElement(new String(var6));
    }

    private String[] d(String var1) {
        int var2 = this.GetWidth() - this.g - this.F;
        Vector var3 = new Vector();
        int var4 = var1.length();
        String var5 = "";

        for(int i = 0; i < var4; ++i) {
            char var7 = var1.charAt(i);
            String var8 = var5 + var7;
            if (this.CurFont.stringWidth(var8) > var2) {
                var3.addElement(new String(var5));
                var5 = var7 + "";
            } else {
                var5 = var8;
            }
        }

        var3.addElement(new String(var5));
        return VectoList(var3);
    }

    private static String[] VectoList(Vector vec) {
        int len = vec.size();
        String[] strlist = new String[len];

        for(int i = 0; i < len; ++i) {
            strlist[i] = (String)vec.elementAt(i);
        }

        return strlist;
    }

    protected void KeyPressed(int key) {
        Command comm;
        if (key == -6) {
            comm = this.s();
            if (comm != null) {
                this.Listener.commandAction(comm, this.displayable);
                return;
            }
        } else if (key == -7) {
            comm = this.l();
            if (comm != null) {
                this.Listener.commandAction(comm, this.displayable);
                return;
            }
        }

        int actionKey = this.GetGameAction(key);
        int indx;
        switch (actionKey) {
            case 1:
                if (this.MenuType != 3 && this.MenuType != 5 && this.MenuType != 6) {
                    if (this.MenuType == 4) {
                        indx = this.GetSelectedIndex();
                        if (this.w > 0) {
                            --this.w;
                            --this.v;
                            this.Paint();
                            this.ServiceRepaint();
                        }
                    }
                } else {
                    indx = this.GetSelectedIndex();
                    if (indx > 0) {
                        --indx;
                        this.a(indx);
                        if (this.w > indx) {
                            --this.w;
                            --this.v;
                        }

                        this.Paint();
                        this.ServiceRepaint();
                    }
                }
                break;
            case 6:
                if (this.MenuType != 3 && this.MenuType != 5 && this.MenuType != 6) {
                    if (this.MenuType == 4 && this.v < this.k - 1) {
                        ++this.w;
                        ++this.v;
                        this.Paint();
                        this.ServiceRepaint();
                    }
                } else {
                    indx = this.GetSelectedIndex();
                    if (indx < this.d() - 1) {
                        ++indx;
                        this.a(indx);
                        if (this.v < indx) {
                            ++this.w;
                            ++this.v;
                        }

                        this.Paint();
                        this.ServiceRepaint();
                    }
                }
        }

    }

    String[] GetOptStrings() {
        boolean var1 = false;
        int len;
        switch (this.MenuType) {
            case 3:
                List list = (List)this.Scrn;
                len = list.size();
                String[] strList1 = new String[len];

                for(int i = 0; i < len; ++i) {
                    strList1[i] = list.getString(i);
                }

                return strList1;
            case 4:
            default:
                return null;
            case 5:
            case 6:
                Form form = (Form)this.Scrn;
                ChoiceGroup group = (ChoiceGroup)form.get(this.h);
                len = group.size();
                String[] strList2 = new String[len];

                for(int i = 0; i < len; ++i) {
                    strList2[i] = group.getString(i);
                }

                return strList2;
        }
    }

    String p() {
        int indx = this.GetSelectedIndex();
        String[] optStrings = this.GetOptStrings();
        return optStrings[indx];
    }

    int GetSelectedIndex() {
        byte var1 = -1;
        switch (this.MenuType) {
            case 3:
                List list = (List)this.Scrn;
                return list.getSelectedIndex();
            case 4:
            default:
                return var1;
            case 5:
            case 6:
                Form form = (Form)this.Scrn;
                ChoiceGroup group = (ChoiceGroup)form.get(this.h);
                return group.getSelectedIndex();
        }
    }

    void a(int var1) {
        switch (this.MenuType) {
            case 3:
                List list = (List)this.Scrn;
                list.setSelectedIndex(var1, true);
            case 4:
            default:
                break;
            case 5:
            case 6:
                Form form = (Form)this.Scrn;
                ChoiceGroup group = (ChoiceGroup)form.get(this.h);
                group.setSelectedIndex(var1, true);
        }

    }

    protected void StartHelper() {
        switch (this.MenuType) {
            case 2:
                this.RunHelperThread();
            default:
        }
    }

    protected void q() {
        switch (this.MenuType) {
            case 1:
            case 2:
                this.i();
            default:
        }
    }

    private void RunHelperThread() {
        System.out.println("IN START HELPER THREAD IN UICANVAS");
        this.thread = new Thread(this);
        System.out.println("Helper thread in UICanvas: " + this.thread);
        System.out.println("num active threads = " + Thread.activeCount());
        this.ja = true;
        this.thread.start();
    }

    private void i() {
        this.ja = false;
    }

    public void run() {
        if (this.MenuType == 2) {
            this.m();
        } else if (this.MenuType == 1) {
            System.out.println("Running a download helper thread to repaint");
        }

    }

    private void m() {
        try {
            this.C = 0L;
            System.out.println("Just before helper thread loop in UICanvas");

            while(this.ja && (this.LoadPct < 100 || this.C < 4000L)) {
                long var1 = System.currentTimeMillis();
                this.Paint();
                this.ServiceRepaint();
                long var3 = System.currentTimeMillis() - var1;

                try {
                    if (var3 < 500L) {
                        long var5 = 500L - var3;
                        Thread.sleep(500L - var3);
                    }
                } catch (Exception err1) {
                }

                var3 = System.currentTimeMillis() - var1;
                this.C += var3;
                System.out.println("Progress pct is " + this.LoadPct);
            }

            ESGame.aG = true;
            this.Game.ac = false;
            this.a(2000L);
            this.Game.ac = true;
            ESGame.aG = false;
            this.a(1000L);
            this.Game.ac = false;
            ESGame.MformLogo = null;
            ESGame.Vir2lLogo = null;
            ESGame.SplashTop = null;
            ESGame.SplashBot = null;
            this.thread = null;
            ESGame.Log("After nuking splash");
            System.out.println("End of splash, changing to next");
            this.Game.SetDisplayContent(this.Next);
        } catch (Throwable err2) {
            err2.printStackTrace();
            this.Game.SetDisplayContent(this.Game.ErrorForm);
        }

    }

    private void a(long var1) {
        long var3 = 0L;

        do {
            this.Paint();
            this.ServiceRepaint();

            try {
                Thread.sleep(500L);
            } catch (Exception err) {
            }

            var3 += 500L;
        } while(var3 <= var1);

    }

    int d() {
        if (this.MenuType == 3) {
            List list = (List)this.Scrn;
            return list.size();
        } else if (this.MenuType != 5 && this.MenuType != 6) {
            return 0;
        } else {
            Form form = (Form)this.Scrn;
            ChoiceGroup group = (ChoiceGroup)form.get(this.h);
            return group.size();
        }
    }

    void a(int var1, String var2) {
        Form form = (Form)this.Scrn;
        if (this.MenuType == 6) {
            System.out.println("type is form2, size is " + form.size());
        }

        if (this.MenuType == 5 || this.MenuType == 6 || this.MenuType == 4) {
            StringItem var4 = (StringItem)form.get(var1);
            var4.setText(var2);
        }

    }

    void SetTitle(String title) {
        if (this.Scrn != null) {
            this.Scrn.setTitle(title);
        }

    }

    void SetText(String txt) {
        Form form = (Form)this.Scrn;

        try {
            if (form != null) {
                StringItem stritem = (StringItem)form.get(0);
                stritem.setText(txt);
            }
        } catch (Throwable err) {
        }

    }

    String GetText() {
        Form form = (Form)this.Scrn;

        try {
            if (form != null) {
                StringItem stritem = (StringItem)form.get(0);
                return stritem.getText();
            }
        } catch (Throwable err) {
        }

        return null;
    }

    public void AddElement(Command comm) {
        this.MenuElements.addElement(comm);
    }

    public void RemoveElement(Command comm) {
        this.MenuElements.removeElement(comm);
    }

    public void SetListener(CommandListener listener) {
        this.Listener = listener;
    }

    private void DrawBottomBar(Graphics graphics) {
        if (this.MenuElements.size() != 0) {
            graphics.setColor(0XFFFFFF);
            graphics.fillRect(0, 190, this.GetWidth(), 20);
            int var2 = this.MenuElements.size();
            graphics.setColor(0X000000);
            graphics.setFont(SmallBold1);
            Command var3 = this.s();
            if (var3 != null) {
                graphics.drawString(var3.getLabel(), 10, 192, 20);
            }

            Command var4 = this.l();
            if (var4 != null) {
                graphics.drawString(var4.getLabel(), this.GetWidth() - 10, 195, 24);
            }

        }
    }

    private Command l() {
        int elcount = this.MenuElements.size();
        Command comm1 = null;
        if (elcount == 1) {
            comm1 = (Command)this.MenuElements.elementAt(0);
        } else if (elcount == 2) {
            for(int i = 0; i < 2; ++i) {
                Command comm2 = (Command)this.MenuElements.elementAt(i);
                if (comm2 == OKComm || comm2 == SelectComm) {
                    comm1 = comm2;
                    break;
                }
            }
        }

        return comm1;
    }

    private Command s() {
        int var1 = this.MenuElements.size();
        Command comm1 = null;
        if (var1 == 2) {
            for(int i = 0; i < 2; ++i) {
                Command comm2 = (Command)this.MenuElements.elementAt(i);
                if (comm2 == BackComm || comm2 == CancelComm) {
                    comm1 = comm2;
                    break;
                }
            }
        }

        return comm1;
    }

    static MenuCanvas GetCanvas() {
        return MenuCanvases[CanasIndx];
    }

    public void Paint() {
        if (ESGame.CurrentMenu == null || this.MenuID == ESGame.CurrentMenu.MenuID) {
            MenuCanvases[CanasIndx].repaint();
        }
    }

    public void ServiceRepaint() {
        MenuCanvases[CanasIndx].serviceRepaints();
    }

    public int GetWidth() {
        return MenuCanvases[CanasIndx].getWidth();
    }

    public int GetHeight() {
        return MenuCanvases[CanasIndx].getHeight();
    }

    public int GetGameAction(int key) {
        return MenuCanvases[CanasIndx].getGameAction(key);
    }

    static {
        MenuCanvases[0] = new MenuCanvas();
        MenuCanvases[1] = new MenuCanvas();
        CanasIndx = 0;

        try {
            Img = Image.createImage(MenuCanvases[0].getWidth(), MenuCanvases[0].getHeight());
        } catch (Throwable err) {
            System.out.println("Error allocating bufferImage");
        }

        SmallBold1 = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL);
        MedBold1 = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
        SmallPlain = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);
        SmallBold2 = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL);
        MedBold2 = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
        OKComm = new Command("Ok", Command.CANCEL, 0);
        SelectComm = new Command("Select", Command.CANCEL, 0);
        CancelComm = new Command("Cancel", Command.OK, 0);
        BackComm = new Command("Back", Command.OK, 0);
        ExitComm = new Command("Exit", Command.EXIT, 0);
        CRStrings = new String[]{"(c) 2003 Vir2L Studios, ", "a ZeniMax Media company. ", "The Elder Scrolls and Vir2L ", "are registered trademarks ", "of ZeniMax Media Inc. ", "All rights reserved."};
    }
}
