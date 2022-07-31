//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import com.nokia.mid.ui.DirectGraphics;
import com.nokia.mid.ui.DirectUtils;
import com.nokia.mid.ui.FullCanvas;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class EE extends FullCanvas implements Runnable {
    private static final Font aj = Font.getFont(64, 0, 8);
    private static final Font M = Font.getFont(64, 2, 16);
    private static final Font w = Font.getFont(64, 2, 16);
    private static final Font K = Font.getFont(64, 1, 16);
    static final int[][][] n = new int[][][]{{{12, 0, 0, 1}, {11, 0, -1, 1}, {12, 1, -1, 2}, {12, 2, -1, 3}, {11, 2, -2, 3}, {12, 3, -2, 4}}, {{12, 0, 0, 1}, {12, 1, 0, 2}, {11, 1, -1, 2}, {12, 2, -1, 3}, {12, 3, -1, 4}, {12, 3, -1, 4}}, {{12, 0, 0, 1}, {12, 1, 0, 2}, {12, 2, 0, 3}, {11, 2, -1, 3}, {12, 3, -1, 4}, {12, 3, -1, 4}}, {{12, 0, 0, 1}, {12, 1, 0, 2}, {12, 2, 0, 3}, {12, 3, 0, 4}, {11, 3, -1, 4}, {11, 3, -1, 4}}, {{12, 0, 0, 1}, {12, 1, 0, 2}, {12, 2, 0, 3}, {12, 3, 0, 4}, {12, 3, 0, 4}, {12, 3, 0, 4}}};
    private static final byte[][] ae = new byte[][]{{1, 5, 31, 53, 0, 1, 40, -39, 1, 4, 13, -2, 3, 6, 71, 4, 30, 64, 2, 0, 0, 0}, {6, 10, 31, 53, 7, 1, 27, -35, 8, 4, 1, 69, 11, 27, 66, 9, 33, 10, 10, 0, 0, 0}, {11, 25, 31, 20, 14, 1, 0, 0, -1, -1, 2, 25, 15, 81, 8, 16, 9, 0, 17, 60, 57, 18}, {26, 40, 31, 32, 21, 1, 0, 0, -1, -1, 43, 44, 22, 50, 25, 23, -36, 9, 24, -25, 44, 25}};
    private static final byte[][] a = new byte[][]{{0, 0}, {0, 0}, {0, 3}, {0, 3}, {0, 3}, {0, 2}, {0, 2}, {0, 3}, {0, 3}, {0, 3}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}};
    private static final boolean[][] J = new boolean[][]{{false, false, false, false}, {true, false, false, false}, {false, false, false, false}, {false, false, true, false}, {true, false, true, false}, {false, false, false, false}, {false, false, false, false}, {false, true, false, false}, {false, false, true, false}, {false, true, true, false}, {true, false, false, false}, {false, true, false, false}, {true, false, true, false}, {false, true, true, false}, {true, true, true, false}, {true, false, false, false}, {false, true, false, false}, {true, false, true, false}, {false, true, true, false}, {true, true, true, false}, {true, true, false, false}, {true, true, false, false}, {true, true, false, false}, {true, true, true, false}, {true, true, true, false}, {false, false, false, false}, {false, false, false, false}, {false, false, false, false}, {false, false, false, false}, {false, false, false, false}, {false, false, false, false}, {false, false, false, false}, {false, false, false, false}, {false, false, false, false}, {false, false, false, false}, {false, true, false, true}, {false, true, false, true}, {true, false, false, true}, {true, false, true, false}, {false, true, true, false}, {false, false, false, false}};
    private static final char[] e = new char[]{'1', '3', '5', '7', '9', '0'};
    private static final char[] O = new char[]{'0', 'N', 'E', 'S', 'W'};
    private static final int[][] o = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 2, 1}};
    private ESGame Game;
    private int ac;
    private int T;
    private Thread thread = new Thread(this);
    private boolean ak;
    private boolean z;
    private boolean aB;
    Character ax;
    byte aD;
    boolean v;
    byte c;
    long aC;
    long s;
    long B;
    long V;
    boolean aw;
    int p;
    static boolean aa;
    static boolean m;
    static boolean R;
    static boolean W;
    static Image floor3;
    static Image newwallsnok;
    static CusImg[] MonImgs;
    static Image[] AttackImgs;
    static CusImg[] ImgChest;
    static CusImg[] ImgBag;
    static CusImg[] ImgCrystal;
    static Image[] MenuIcons;
    private static byte[][] l;
    private static byte[][] F;
    private static int f = 1;
    static boolean S = false;
    static boolean ao = false;
    static boolean am = false;
    static int aq;
    static boolean av = false;
    static boolean ay = false;
    static boolean I = false;
    static boolean Z = false;
    static boolean ap = false;
    static boolean U = false;
    static boolean ad = false;
    static long as = 0L;
    static String[] d = null;
    private static int X = 0;
    static boolean af = false;
    private static boolean al = true;
    private static boolean at = false;
    static boolean E = false;
    static boolean A = false;
    static final String[] r = new String[]{"Warden's", "Camp"};
    static final String[] ag = new String[]{"Outer", "Camp"};
    static final String[] C = new String[]{"Cannot", "Camp!"};
    static final String[] Q = new String[]{"No spells!", ""};
    static final String[] t = new String[]{"Not enough", "magic!"};
    static final String[] g = new String[]{"No monster", "here!"};
    static final String[] N = new String[]{"Rest", "disturbed!"};
    static final String[] b = new String[]{"Rest", "complete!"};
    static final String[] P = new String[]{"Creature", "is dead!"};
    static final String[] ah = new String[]{"Creature", "attacks!"};
    static final String[] x = new String[]{"Chest", ""};
    static final String[] D = new String[]{"Chest", "locked!"};
    static final String[] aA = new String[]{"Inventory", "full!"};
    static final String[] L = new String[]{"Found", "item!"};
    static final String[] an = new String[]{"Several", "items!"};
    static final String[][] i = new String[][]{{"Arantamo", ""}, {"Celegil", ""}, {"Favela Dralor", ""}, {"Vander", ""}, {"Beneca", ""}, {"Helga", ""}, {"Varus", ""}};
    static Monster k = new Monster();
    static Monster j = null;
    private static long ai = 0L;
    private static boolean az = false;
    private static String G = null;

    public EE(ESGame game) {
        this.Game = game;
        this.T = 0;
        this.ac = 0;
        this.z = false;
        this.ak = false;
        this.aB = false;
        this.ax = null;
        this.aD = 1;
        this.v = false;
        this.c = 0;
        this.s = 0L;
        this.aC = 0L;
        this.p = 0;
        this.aw = false;
        aa = false;
        m = false;
        R = false;
        W = false;
        l = new byte[7][7];
        F = new byte[17][17];
        aq = 0;
        this.B = 0L;
        this.V = 0L;
    }

    public void paint(Graphics graphics) {
        if (this.aD == 3) {
            this.DeathScreen(graphics);
        } else if (this.c != 1 && this.c != 2) {
            this.m(graphics);
        } else {
            this.CampingScreen(graphics);
        }

    }

    private void DeathScreen(Graphics graphics) {
        graphics.setColor(0);
        graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
        graphics.setColor(16777215);
        graphics.setFont(w);
        graphics.drawString("You're Dead!", this.getWidth() / 2, this.getHeight() / 2, 33);
    }

    private void CampingScreen(Graphics graphics) {
        graphics.setColor(0);
        graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
        graphics.setColor(16777215);
        graphics.setFont(w);
        graphics.drawString("CAMPING", this.getWidth() / 2, this.getHeight() / 2, 33);
    }

    private void m(Graphics graphics) {
        graphics.setColor(0);
        graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
        this.j(graphics);
        this.b(graphics);
        if (W) {
            int var2 = this.ax.r();
            this.b(graphics, var2);
        }

        try {
            this.g(graphics);
        } catch (Throwable var3) {
            System.out.println("Error in paintMonsters: " + var3);
        }

        this.a(graphics);
        this.d(graphics);
        this.l(graphics);
        this.e(graphics);
        if (az) {
            this.i(graphics);
        }

        if (f == 1 && !this.ax.k(3)) {
            this.k(graphics);
        }

        if (f == 2 && !this.ax.k(3)) {
            this.h(graphics);
        }

    }

    private void i(Graphics graphics) {
        graphics.setColor(16777215);
        graphics.drawString(G, 60, 10, 17);
    }

    private void e(Graphics graphics) {
        int var2;
        int var3;
        if (S) {
            var2 = 40 + func.a(30);
            var3 = 50 + func.a(20);
            graphics.drawImage(AttackImgs[0], var2, var3, 20);
            S = false;
        }

        if (ao) {
            var2 = 40 + func.a(30);
            var3 = 50 + func.a(22);
            graphics.drawImage(AttackImgs[1], var2, var3, 20);
            ao = false;
        }

        if (am) {
            var2 = 50 + func.a(2);
            var3 = 80 + func.a(2);
            graphics.drawImage(AttackImgs[2], var2, var3, 20);
            am = false;
        }

    }

    private void j(Graphics graphics) {
        Dungeon var2 = this.ax.b();
        byte[][] var3 = this.ax.ae;
        int var6;
        if (!this.ax.k(3)) {
            if (this.ax.k(4)) {
                graphics.setColor(10485760);
                graphics.fillRect(0, 0, this.getWidth(), floor3.getHeight());
            } else {
                for(var6 = 0; var6 < 5; ++var6) {
                    graphics.drawImage(floor3, var6 * 36, 0, 20);
                }
            }
        }

        int var4;
        int var5;
        int var7;
        int var8;
        int var9;
        int var10;
        int var11;
        for(var6 = 0; var6 < 5; ++var6) {
            var5 = var6 * 18;

            for(var7 = 0; var7 < 6; ++var7) {
                var8 = n[var6][var7][0];
                var9 = n[var6][var7][1];
                var10 = n[var6][var7][2];
                var11 = n[var6][var7][3];
                if (func.a((byte)1, var2.a(var10, var11, var3))) {
                    var4 = this.a(var8, var9, -1);
                    this.a(graphics, var4, var5);
                    break;
                }
            }
        }

        for(var7 = 5; var7 < 10; ++var7) {
            var5 = var7 * 18;

            for(var8 = 0; var8 < 6; ++var8) {
                var9 = n[9 - var7][var8][0];
                var10 = n[9 - var7][var8][1];
                var11 = -n[9 - var7][var8][2];
                int var12 = n[9 - var7][var8][3];
                if (func.a((byte)1, var2.a(var11, var12, var3))) {
                    var4 = this.a(var9, var10, 1);
                    this.a(graphics, var4, var5);
                    break;
                }
            }
        }

    }

    private void b(Graphics graphics) {
        for(int i = 8; i <= 12; ++i) {
            Object var3 = Character.ad.elementAt(i);
            if (var3 instanceof byte[]) {
                byte[] var4 = (byte[])var3;
                if (var4.length == 8 || var4.length == 7) {
                    this.a(graphics, var4, i);
                }
            }
        }

        byte[] var5;
        Object var7;
        for(int i = 4; i <= 6; ++i) {
            var7 = Character.ad.elementAt(i);
            if (var7 instanceof byte[]) {
                var5 = (byte[])var7;
                if (var5.length == 8 || var5.length == 7) {
                    this.a(graphics, var5, i);
                }
            }
        }

        var7 = Character.ad.elementAt(1);
        if (var7 instanceof byte[]) {
            var5 = (byte[])var7;
            if (var5.length == 8 || var5.length == 7) {
                this.a(graphics, var5, 1);
            }
        }

    }

    private void a(Graphics graphics, int var2, int var3) {
        graphics.setClip(var3, 0, 18, this.getHeight());
        if (var2 > 7) {
            int var4 = var2 - 8;
            DirectGraphics var5 = DirectUtils.getDirectGraphics(graphics);
            var5.drawImage(newwallsnok, var3 - var4 * 18, 0, 20, 8192);
        } else {
            graphics.drawImage(newwallsnok, var3 - var2 * 18, 0, 20);
        }

        graphics.setClip(0, 0, this.getWidth(), this.getHeight());
    }

    private boolean a(String[] var1, int var2) {
        if (var2 <= X && var2 >= 0) {
            return false;
        } else {
            d = var1;
            if (var2 < 0) {
                X = 10;
            } else {
                X = var2;
            }

            return true;
        }
    }

    private void c() {
        Dungeon var1 = this.ax.b();
        byte[][] var2 = this.ax.ae;
        byte var3 = var1.a(0, 1, var2);
        if (func.a((byte)32, var3)) {
            int var4 = this.ax.r();
            W = true;
            String[] var5 = i[var4];
            if (this.a((String[])var5, 1)) {
                as = System.currentTimeMillis();
                ad = true;
            }
        } else {
            W = false;
            if (!this.d() && NPC.WardenPresent && this.ax.m == k.f) {
                k.a();
            }
        }

    }

    private int a(int var1, int var2, int var3) {
        if (var1 == 12) {
            return var2;
        } else {
            return var3 == -1 ? 8 + var2 : 7 - var2;
        }
    }

    private void b(Graphics graphics, int var2) {
        boolean var5 = false;
        boolean var6 = false;
        boolean var7 = false;
        boolean var8 = false;
        switch (var2) {
            case 0:
                this.e(graphics, 1, 1);
                break;
            case 1:
                this.e(graphics, 6, 1);
                break;
            case 2:
                this.e(graphics, 7, 1);
                break;
            case 3:
                this.e(graphics, 2, 1);
                break;
            case 4:
                this.e(graphics, 3, 2);
                break;
            case 5:
                this.e(graphics, 8, 0);
                break;
            case 6:
                int var9 = Math.min(k.f, 3) - 1;
                this.a(graphics, var9);
        }

        graphics.setClip(0, 0, this.getWidth(), this.getHeight());
    }

    private void a(Graphics graphics, int var2) {
        byte var3 = 15;
        byte var4 = 32;
        this.a(graphics, MonImgs[28], o[var2][0], 1, var3, var4);
        int var5 = MonImgs[28].GetWidth();
        this.a(graphics, MonImgs[28], o[var2][0], 1, var3 + var5, var4, 8192);
        this.a(graphics, MonImgs[29], o[var2][1], 3, var3 + 45, var4 + -22);
    }

    private void g(Graphics graphics) {
        A = false;

        for(int i = 8; i <= 12; ++i) {
            Object var3 = Character.ad.elementAt(i);
            if (var3 instanceof byte[]) {
                byte[] var4 = (byte[])var3;
                if (var4.length == 28 && var4[6] != 0) {
                    A = true;
                    this.c(graphics, var4[2], i);
                }
            } else if (var3 instanceof String) {
                String var7 = (String)var3;
                if (var7.equals("W")) {
                    this.b(graphics, 32, i);
                }
            }
        }

        byte[] var5;
        Object var8;
        for(int i = 4; i <= 6; ++i) {
            var8 = Character.ad.elementAt(i);
            if (var8 instanceof byte[]) {
                var5 = (byte[])var8;
                if (var5.length == 28 && var5[6] != 0) {
                    A = true;
                    this.c(graphics, var5[2], i);
                }
            } else if (var8 instanceof String) {
                String var9 = (String)var8;
                if (var9.equals("W")) {
                    this.d(graphics, 31, i);
                }
            }
        }

        var8 = Character.ad.elementAt(1);
        if (var8 instanceof byte[]) {
            var5 = (byte[])var8;
            if (var5.length == 28 && var5[6] != 0) {
                A = true;
                this.c(graphics, var5[2], 1);
            }
        } else if (var8 instanceof String) {
        }

    }

    private void a(Graphics graphics, byte[] var2, int var3) {
        if (var3 == 1) {
            this.a(graphics, var2, false);
        } else if (var3 >= 4 && var3 <= 6) {
            this.b(graphics, var2, false, var3);
        } else if (var3 >= 8 && var3 <= 12) {
            this.a(graphics, var2, false, var3);
        }

    }

    private static boolean a(byte[] var0) {
        if (var0.length != 7) {
            return false;
        } else {
            return (var0[6] & 4) != 0;
        }
    }

    private void a(Graphics graphics, byte[] var2, boolean var3) {
        byte var4;
        int var5;
        if (a(var2)) {
            var4 = 45;
            var5 = 65;
            this.a(graphics, ImgCrystal[0], var4, var5);
        } else {
            var4 = 60;
            var5 = 94;
            byte var6 = 0;
            if (var2.length == 8) {
                this.a(graphics, ImgChest[var6], var4, var5);
            } else if (var2.length == 7) {
                var5 += 14;
                this.a(graphics, ImgBag[var6], var4, var5);
            }
        }

    }

    private void b(Graphics graphics, byte[] var2, boolean var3, int var4) {
        byte var5 = 1;
        short var6 = 0;
        int var7 = 0;
        boolean var8 = a(var2);
        switch (var4) {
            case 4:
                var6 = 14;
                var7 = 80;
                if (var8) {
                    var6 = 14;
                    var7 = 55;
                }
                break;
            case 5:
                var6 = 68;
                var7 = 80;
                if (var8) {
                    var6 = 73;
                    var7 = 55;
                } else if (var2.length == 7) {
                    var6 = 73;
                    var7 = 80;
                }
                break;
            case 6:
                var6 = 122;
                var7 = 80;
                if (var8) {
                    var6 = 125;
                    var7 = 55;
                } else if (var2.length == 7) {
                    var6 = 132;
                    var7 = 80;
                }
        }

        if (var8) {
            var7 += 13;
            this.a(graphics, ImgCrystal[var5], var6, var7);
        } else if (var2.length == 8) {
            var7 += 17;
            this.a(graphics, ImgChest[var5], var6, var7);
        } else if (var2.length == 7) {
            var7 += 20;
            this.a(graphics, ImgBag[var5], var6, var7);
        }

    }

    private void a(Graphics graphics, byte[] var2, boolean var3, int var4) {
        byte var5 = 2;
        short var6 = 0;
        int var7 = 0;
        boolean var8 = a(var2);
        switch (var4) {
            case 8:
                var6 = 10;
                var7 = 59;
                if (var8) {
                    var6 = 10;
                    var7 = 52;
                }
                break;
            case 9:
                var6 = 44;
                var7 = 59;
                if (var8) {
                    var6 = 44;
                    var7 = 52;
                }
                break;
            case 10:
                var6 = 79;
                var7 = 59;
                if (var8) {
                    var6 = 79;
                    var7 = 52;
                }
                break;
            case 11:
                var6 = 112;
                var7 = 59;
                if (var8) {
                    var6 = 112;
                    var7 = 52;
                }
                break;
            case 12:
                var6 = 146;
                var7 = 59;
                if (var8) {
                    var6 = 146;
                    var7 = 52;
                }
        }

        if (var8) {
            var7 += 20;
            this.a(graphics, ImgCrystal[var5], var6, var7);
        } else if (var2.length == 8) {
            var7 += 28;
            this.a(graphics, ImgChest[var5], var6, var7);
        } else if (var2.length == 7) {
            var7 += 28;
            this.a(graphics, ImgBag[var5], var6, var7);
        }

    }

    private int c(int var1) {
        if (var1 >= 1 && var1 <= 5) {
            return 5;
        } else if (var1 >= 6 && var1 <= 10) {
            return 12;
        } else if (var1 >= 11 && var1 <= 25) {
            return 19;
        } else if (var1 >= 26 && var1 <= 40) {
            return 26;
        } else {
            return var1 == 41 ? 31 : -1;
        }
    }

    private int a(int var1) {
        if (var1 >= 1 && var1 <= 5) {
            return 6;
        } else if (var1 >= 6 && var1 <= 10) {
            return 13;
        } else if (var1 >= 11 && var1 <= 25) {
            return 20;
        } else if (var1 >= 26 && var1 <= 40) {
            return 27;
        } else {
            return var1 == 41 ? 32 : -1;
        }
    }

    private void c(Graphics graphics, int var2, int var3) {
        if (var3 == 1) {
            this.c(graphics, var2);
        } else if (var3 >= 4 && var3 <= 6) {
            this.d(graphics, this.c(var2), var3);
        } else if (var3 >= 8 && var3 <= 12) {
            this.b(graphics, this.a(var2), var3);
        }

        graphics.setClip(0, 0, this.getWidth(), this.getHeight());
    }

    private int b(int var1) {
        if (var1 >= 1 && var1 <= 5) {
            return 0;
        } else if (var1 >= 6 && var1 <= 10) {
            return 1;
        } else if (var1 >= 11 && var1 <= 25) {
            return 2;
        } else {
            return var1 >= 26 && var1 <= 40 ? 3 : -1;
        }
    }

    private void c(Graphics graphics, int var2) {
        this.e(graphics, var2, -1);
    }

    private void e(Graphics graphics, int var2, int var3) {
        if (var2 == 41) {
            this.a((Graphics)graphics, 2);
        } else {
            int var4 = this.b(var2);
            if (var4 >= 0) {
                byte var6 = ae[var4][2];
                byte var7 = ae[var4][3];
                byte var8 = ae[var4][4];
                byte var9 = ae[var4][5];
                int var10 = var6 + ae[var4][6];
                int var11 = var7 + ae[var4][7];
                byte var12 = ae[var4][8];
                byte var13 = ae[var4][9];
                boolean var5;
                if (var12 >= 0) {
                    var5 = true;
                } else {
                    var5 = false;
                }

                byte var14 = a[var2 - 1][0];
                int var15 = a[var2 - 1][1];
                if (var3 >= 0) {
                    var15 = var3;
                }

                boolean var16 = J[var2 - 1][0];
                boolean var17 = J[var2 - 1][1];
                boolean var18 = J[var2 - 1][2];
                boolean var19 = J[var2 - 1][3];
                this.a(graphics, MonImgs[var8], var14, var9, var6, var7);
                if (var5) {
                    this.a(graphics, MonImgs[var12], var15, var13, var10, var11);
                }

                int var20;
                int var21;
                byte var22;
                if (var16) {
                    var20 = var6 + ae[var4][10];
                    var21 = var7 + ae[var4][11];
                    var22 = ae[var4][12];
                    this.a(graphics, MonImgs[var22], 0, 1, var20, var21);
                }

                if (var17) {
                    var20 = var6 + ae[var4][13];
                    var21 = var7 + ae[var4][14];
                    var22 = ae[var4][15];
                    this.a(graphics, MonImgs[var22], 0, 1, var20, var21);
                }

                if (var18) {
                    var20 = var6 + ae[var4][16];
                    var21 = var7 + ae[var4][17];
                    var22 = ae[var4][18];
                    this.a(graphics, MonImgs[var22], 0, 1, var20, var21);
                }

                if (var19) {
                    var20 = var6 + ae[var4][19];
                    var21 = var7 + ae[var4][20];
                    var22 = ae[var4][21];
                    this.a(graphics, MonImgs[var22], 0, 1, var20, var21);
                }
            }

        }
    }

    private void d(Graphics graphics, int var2, int var3) {
        this.a(graphics, var2, var3, 0, 1);
    }

    private void a(Graphics graphics, int var2, int var3, int var4, int var5) {
        byte var6 = 0;
        byte var7 = 0;
        switch (var3) {
            case 4:
                var6 = 10;
                var7 = 38;
                break;
            case 5:
                var6 = 62;
                var7 = 38;
                break;
            case 6:
                var6 = 112;
                var7 = 38;
        }

        this.a(graphics, MonImgs[var2], var4, var5, var6, var7);
    }

    private void b(Graphics graphics, int var2, int var3) {
        short var4 = 0;
        byte var5 = 0;
        switch (var3) {
            case 8:
                var4 = 10;
                var5 = 44;
                break;
            case 9:
                var4 = 44;
                var5 = 44;
                break;
            case 10:
                var4 = 79;
                var5 = 44;
                break;
            case 11:
                var4 = 112;
                var5 = 44;
                break;
            case 12:
                var4 = 146;
                var5 = 44;
        }

        DirectGraphics var6 = DirectUtils.getDirectGraphics(graphics);
        var6.drawPixels(MonImgs[var2].ImgBuf, true, 0, MonImgs[var2].ScanLen, var4, var5, MonImgs[var2].Width, MonImgs[var2].Height, 0, DirectGraphics.TYPE_USHORT_4444_ARGB);
    }

    private void a(Graphics graphics) {
        graphics.setColor(16776960);
        graphics.fillRect(5, 130, 40, 7);
        graphics.fillRect(5, 138, 40, 7);
        graphics.fillRect(5, 146, 40, 7);
        graphics.setColor(16711680);
        int var2 = this.ax.n(2) * 38 / this.ax.CharCritAtt[3];
        graphics.fillRect(6, 131, var2, 5);
        graphics.setColor(65280);
        var2 = this.ax.n(4) * 38 / this.ax.CharCritAtt[5];
        graphics.fillRect(6, 139, var2, 5);
        graphics.setColor(255);
        var2 = this.ax.n(6) * 38 / this.ax.CharCritAtt[7];
        if (var2 > 40) {
            var2 = 40;
        }

        graphics.fillRect(6, 147, var2, 5);
    }

    private void l(Graphics graphics) {
        if (ad) {
            graphics.setColor(13080935);
            graphics.fillRoundRect(96, 118, 75, 35, 5, 5);
            graphics.setFont(aj);
            graphics.setColor(0);
            graphics.drawString(d[0], 100, 122, 20);
            if (d.length > 1) {
                graphics.drawString(d[1], 100, 134, 20);
            }

        }
    }

    private void d(Graphics graphics) {
        graphics.setFont(aj);
        graphics.setClip(0, 0, this.getWidth(), this.getHeight());
        graphics.setColor(0);
        graphics.fillRect(0, 156, this.getWidth(), 52);
        graphics.setColor(13080935);
        graphics.fillRoundRect(2, 158, this.getWidth() - 4, 48, 5, 5);
        graphics.setColor(0);
        int var2 = this.j();
        aq = var2;
        if (var2 == 0) {
            graphics.drawImage(MenuIcons[1], 14, 174, 20);
            graphics.drawImage(MenuIcons[2], 62, 174, 20);
            graphics.drawImage(MenuIcons[3], 104, 174, 20);
            graphics.drawImage(MenuIcons[5], 144, 174, 20);
            graphics.drawChar(e[1], 5, 180, 20);
            graphics.drawChar(e[2], 53, 180, 20);
            graphics.drawChar(e[3], 96, 180, 20);
            graphics.drawChar(e[5], 135, 180, 20);
        } else if (var2 == 1) {
            graphics.drawImage(MenuIcons[0], 14, 174, 20);
            graphics.drawImage(MenuIcons[1], 62, 174, 20);
            graphics.drawImage(MenuIcons[2], 104, 174, 20);
            graphics.drawImage(MenuIcons[3], 144, 174, 20);
            graphics.drawChar(e[0], 5, 180, 20);
            graphics.drawChar(e[1], 53, 180, 20);
            graphics.drawChar(e[2], 96, 180, 20);
            graphics.drawChar(e[3], 135, 180, 20);
        } else if (var2 == 2) {
            graphics.drawImage(MenuIcons[1], 14, 174, 20);
            graphics.drawImage(MenuIcons[2], 62, 174, 20);
            graphics.drawImage(MenuIcons[3], 104, 174, 20);
            graphics.drawImage(MenuIcons[4], 144, 174, 20);
            graphics.drawChar(e[1], 5, 180, 20);
            graphics.drawChar(e[2], 53, 180, 20);
            graphics.drawChar(e[3], 96, 180, 20);
            graphics.drawChar(e[4], 135, 180, 20);
        }

    }

    private int j() {
        if (aa) {
            return 1;
        } else if (!m && !R) {
            return W && !this.d() ? 2 : 0;
        } else {
            return 2;
        }
    }

    private void a(Graphics graphics, CusImg var2, int var3, int var4, int var5, int var6) {
        this.a(graphics, var2, var3, var4, var5, var6, 0);
    }

    private void a(Graphics graphics, CusImg var2, int var3, int var4, int var5, int var6, int var7) {
        int var8 = var2.GetWidth() / var4;
        int var9 = var2.GetHeight();
        graphics.setClip(var5, var6, var8, var9);
        DirectGraphics var10 = DirectUtils.getDirectGraphics(graphics);
        var10.drawPixels(var2.ImgBuf, true, 0, var2.ScanLen, var5 - var3 * var8, var6, var2.Width, var2.Height, var7, 4444);
    }

    private void k(Graphics graphics) {
        graphics.setFont(aj);
        graphics.setColor(16777215);
        graphics.drawChar(O[this.ax.ak], 16, 10, 20);
        graphics.setColor(0);
        graphics.fillRect(10, 20, 23, 23);
        this.a(graphics, 10, 20, 7, 3, 1, l);
    }

    private void h(Graphics graphics) {
        graphics.setFont(K);
        graphics.setColor(16777215);
        graphics.drawChar(O[this.ax.ak], 58, 10, 20);
        byte var2 = 89;
        graphics.fillRect(15, 25, var2, var2);
        this.a(graphics, 15, 25, 17, 5, 2, F);
    }

    private void a(Graphics graphics, int var2, int var3, int var4, int var5, int var6, byte[][] var7) {
        int var8 = var4 / 2;

        for(int i = 0; i < var4; ++i) {
            int var10 = var3 + var6 + i * var5;

            for(int j = 0; j < var4; ++j) {
                int var12 = var2 + var6 + j * var5;
                if (var7[j][i] == 1) {
                    graphics.setColor(0);
                    graphics.fillRect(var12, var10, var5, var5);
                } else if (var7[j][i] == 0) {
                    graphics.setColor(16777215);
                    graphics.fillRect(var12, var10, var5, var5);
                } else if ((var7[j][i] & 2) != 0) {
                    graphics.setColor(16711680);
                    graphics.fillRect(var12, var10, var5, var5);
                } else if ((var7[j][i] & 4) != 0) {
                    graphics.setColor(255);
                    graphics.fillRect(var12, var10, var5, var5);
                } else if ((var7[j][i] & 8) != 0) {
                    graphics.setColor(13369599);
                    graphics.fillRect(var12, var10, var5, var5);
                }

                if (i == var8 && j == var8) {
                    graphics.setColor(65280);
                    graphics.fillRect(var12, var10, var5, var5);
                }
            }
        }

    }

    void q() {
        byte var1 = this.ax.l;
        byte var2 = this.ax.Ka;
        byte var3 = this.ax.ak;
        this.ax.b().c(var1, var2, var3, l);
    }

    void p() {
        byte var1 = this.ax.l;
        byte var2 = this.ax.Ka;
        byte var3 = this.ax.ak;
        this.ax.b().a(var1, var2, var3, F);
    }

    public void keyPressed(int var1) {
        this.T = this.ac;
        if (var1 == 49) {
            if (aq == 1) {
                av = true;
            }

        } else if (var1 == 50) {
            this.p = 1;
        } else if (var1 == 51) {
            ap = true;
        } else if (var1 == 52) {
            this.aw = true;
            this.p = 4;
        } else if (var1 == 53) {
            U = true;
        } else if (var1 == 54) {
            this.aw = true;
            this.p = 3;
        } else if (var1 == 55) {
            Z = true;
        } else if (var1 == 56) {
            this.p = 2;
        } else if (var1 == 57) {
            if (aq == 2) {
                ay = true;
            }

        } else if (var1 == 48) {
            if (aq == 0) {
                I = true;
            }

        } else if (var1 == 42) {
            ++f;
            if (f > 2) {
                f = 1;
            }

        } else {
            this.aw = false;
            this.ac = this.getGameAction(var1);
            switch (this.ac) {
                case 1:
                    this.p = 1;
                    break;
                case 2:
                    this.p = 4;
                case 3:
                case 4:
                default:
                    break;
                case 5:
                    this.p = 3;
                    break;
                case 6:
                    this.p = 2;
            }

        }
    }

    public void keyReleased(int var1) {
        this.getGameAction(var1);
        this.T = this.ac;
        this.ac = 0;
    }

    void g() {
        if (this.thread != null) {
            this.z = true;
            if (this.thread.isAlive()) {
                System.out.println("Killing game thread");
                this.aB = true;

                try {
                    this.thread.join();
                } catch (Exception var2) {
                }

                System.out.println("Done killing game thread");
            }

            this.thread = null;
            System.gc();
        }
    }

    void StartGame() {
        try {
            this.g();
            this.thread = new Thread(this);
            this.thread.start();
            ESGame.Log("after starting game thread");
        } catch (Throwable var2) {
            System.out.println(" start error:");
            var2.printStackTrace();
            this.repaint();
            this.serviceRepaints();
        }

    }

    public void run() {
        long time = System.currentTimeMillis();
        long var5 = 0L;
        long var7 = 0L;

        try {
            while(this.z) {
                boolean var9 = false;
                long var3;
                if (this.ak) {
                    var3 = System.currentTimeMillis();

                    try {
                        Thread.sleep(250L);
                    } catch (Exception var16) {
                    }

                    if (this.aB) {
                        this.aB = false;
                        return;
                    }
                } else {
                    boolean var10 = true;
                    at = false;
                    System.gc();
                    if (this.c == 1) {
                        var10 = false;
                        if (time - this.aC > 2500L) {
                            if (this.o()) {
                                this.c = 0;
                                this.ax.b().a(this.ax);
                                this.aC = 0L;
                                this.v = true;
                                this.ax.e(false);
                                var10 = true;
                                if (this.a((String[])N, 1)) {
                                    as = time;
                                    ad = true;
                                }
                            } else {
                                this.c = 2;
                            }
                        }
                    } else if (this.c == 2) {
                        var10 = false;
                        if (time - this.aC > 5000L) {
                            this.c = 0;
                            this.aC = 0L;
                            this.v = true;
                            this.ax.e(true);
                            if (this.a((String[])b, 1)) {
                                as = time;
                                ad = true;
                            }

                            var10 = true;
                        }
                    } else if (this.aD != 1) {
                        if (this.aD == 2) {
                            this.aD = 3;
                            ad = false;
                            X = 0;
                        }

                        var10 = false;
                        if (time - this.s > 5000L) {
                            System.out.println("Restart after dead");
                            this.ax.a(this.ax.CharCritAtt);

                            for(int i = this.ax.InventoryCount - 1; i >= 0; --i) {
                                if (!this.ax.C(i)) {
                                    this.ax.y(i);
                                }
                            }

                            this.ax.c(this.ax.CharClass, true);
                            this.s = 0L;
                            this.aD = 1;
                            NPC.l = true;
                            this.v = true;
                            E = true;
                            var10 = true;
                            if (E) {
                                String[] var12 = null;
                                if (this.ax.u) {
                                    var12 = r;
                                } else if (this.ax.O) {
                                    var12 = ag;
                                } else {
                                    var12 = this.ax.b().a();
                                }

                                if (this.a((String[])var12, 1)) {
                                    as = System.currentTimeMillis();
                                    ad = true;
                                }

                                E = false;
                            }
                        }
                    }

                    if (var10) {
                        if (k.a(this.ax.GiftPoints)) {
                            k.c();
                        }

                        if (this.d() && k.f > this.ax.m) {
                            String var20 = NPC.a(this.ax, 6, -1, -1);
                            this.Game.aV = this.Game.WardenSpeaksMenu(var20);
                            var9 = true;
                        }

                        this.b(time);
                        this.e(time);
                        this.a(time, var5);
                        if (this.ax.o()) {
                            this.e();
                            this.Game.LevelUpMenu = this.Game.LevelUpMenu(1);
                            this.Game.a(this.Game.LevelUpMenu);
                            al = false;
                        }

                        this.v = false;
                    }

                    this.a(false);
                    if (al) {
                        this.repaint();
                        this.serviceRepaints();
                    }

                    long var21 = System.currentTimeMillis() - time;
                    ai = var21;

                    try {
                        if (var21 < 250L) {
                            long var13 = 250L - var21;
                            Thread.sleep(250L - var21);
                        }
                    } catch (Exception var17) {
                    }

                    if (this.aB) {
                        this.aB = false;
                        return;
                    }

                    var3 = time;
                    time = System.currentTimeMillis();
                    var5 = time - var3;
                    this.c(var5);
                    var7 += var5;
                    if (var7 > 1000L) {
                        var7 -= 1000L;
                        this.l();
                    }

                    if (time - as > 3000L) {
                        ad = false;
                        X = 0;
                    }

                    if (var9) {
                        this.e();
                        this.Game.a(this.Game.aV);
                    }
                }
            }
        } catch (OutOfMemoryError var18) {
            this.Game.B();
        } catch (Throwable var19) {
            System.out.println("ERROR: An error was thrown in GameCanvas run method!");
            System.out.println(var19);
            var19.printStackTrace();
            az = true;
            G = String.valueOf(var19);
            this.repaint();
            this.serviceRepaints();

            try {
                Thread.sleep(10000L);
            } catch (Throwable var15) {
            }

            this.Game.b();
        }

    }

    private void a(boolean var1) {
        this.ax.d(var1);
        this.q();
        if (f == 2) {
            this.p();
        }

    }

    private void b(long var1) {
        Hashtable var3 = ESGame.G[this.ax.CurDung - 1];
        if (var3 != null) {
            Enumeration var4 = var3.elements();

            while(true) {
                while(var4.hasMoreElements()) {
                    byte[] var5 = (byte[])var4.nextElement();
                    Monster var6 = Monster.a(var5);
                    if (var6.b(this.ax)) {
                        if (var6.f == 0) {
                            var6.k = var1;
                            var6.f = 1;
                        } else if (var6.f == 1 && var1 - var6.k > 800L) {
                            var6.a(this.ax, var1);
                            if (this.a((String[])ah, 2)) {
                                as = var1;
                                ad = true;
                            }
                        } else if (var1 - var6.k > 800L) {
                            var6.a(this.ax, var1);
                        }

                        var6.d();
                    } else {
                        var6.a(this.ax);
                        var6.d();
                    }
                }

                return;
            }
        }
    }

    private void e(long var1) {
        if (I) {
            if (A) {
                if (this.a((String[])C, 1)) {
                    as = var1;
                    ad = true;
                }

                I = false;
            } else {
                this.a(var1);
            }
        } else if (ay) {
            this.f(var1);
        } else if (ap) {
            this.h(var1);
        } else if (U) {
            this.g(var1);
        } else if (av) {
            this.d(var1);
        } else if (Z) {
            this.f();
        } else if ((this.p != 0 || this.v) && !this.v) {
            this.n();
        }

        this.h();
        this.c();
        this.a();
        this.m();
    }

    private void d(long var1) {
        if (var1 - this.B >= 500L && j != null) {
            at = true;
            this.ax.a(j);
            System.out.println("monster health is " + j.g);
            this.B = var1;
            S = true;
        }

        av = false;
    }

    private void m() {
        if (j != null && j.g <= 0) {
            if (j.l == 41) {
                j.a(true);
            } else {
                j.a(false);
            }

            ESGame.KillMonster(this.ax.CurDung, j.a);
            if (this.ax.k(4)) {
                short[] var10000 = this.ax.CharCritAtt;
                var10000[2] = (short)(var10000[2] + 3 * this.ax.CharCritAtt[3] / 10);
                this.ax.CharCritAtt[2] = (short)Math.min(this.ax.CharCritAtt[2], this.ax.CharCritAtt[3]);
            }

            if (this.a((String[])P, 1)) {
                as = System.currentTimeMillis();
                ad = true;
            }

            j = null;
            aa = false;
        }

    }

    private void a() {
        j = this.ax.n();
        if (j != null) {
            aa = true;
            byte[] var1 = j.f();
            j = Monster.a(k, var1);
        } else {
            aa = false;
        }

        if (aa) {
            String var4 = j.a();
            String[] var2 = new String[2];
            int var3 = var4.indexOf(32);
            if (var3 < 0) {
                var2[0] = var4;
                var2[1] = "";
            } else {
                var2[0] = var4.substring(0, var3);
                var2[1] = var4.substring(var3 + 1);
            }

            if (this.a((String[])var2, 1)) {
                as = System.currentTimeMillis();
                ad = true;
            }
        }

    }

    private void h() {
        byte[] var1 = this.ax.h();
        if (var1 != null) {
            m = true;
        } else {
            m = false;
        }

        if (m && this.a((String[])x, 1)) {
            as = System.currentTimeMillis();
            ad = true;
        }

    }

    private void n() {
        if (this.p != 0) {
            byte var1 = this.ax.InventoryCount;
            at = true;
            this.ax.a(this.p, this.aw);
            if (Character.g) {
                this.Game.EndOfGameMenu = this.Game.EndOfGameMenu();
                this.Game.a(this.Game.EndOfGameMenu);
                al = false;
            } else {
                if (this.ax.i || this.ax.u || this.ax.O) {
                    E = true;
                    if (E) {
                        String[] var2 = null;
                        if (this.ax.u) {
                            var2 = r;
                        } else if (this.ax.O) {
                            var2 = ag;
                        } else {
                            var2 = this.ax.b().a();
                        }

                        if (this.a((String[])var2, 1)) {
                            as = System.currentTimeMillis();
                            ad = true;
                        }

                        E = false;
                    }
                }

                if (this.aw) {
                    this.aw = false;
                }
            }

            this.p = 0;
            int var3 = this.ax.InventoryCount - var1;
            if (var3 == 1) {
                if (this.a((String[])this.k(), -1)) {
                    as = System.currentTimeMillis();
                    ad = true;
                }
            } else if (var3 > 1 && this.a((String[])an, -1)) {
                as = System.currentTimeMillis();
                ad = true;
            }
        }

    }

    private void h(long var1) {
        if (ap) {
            byte var3 = this.ax.b;
            if (!Spell.ValidateSpellNum(var3)) {
                System.out.println("Invalid spell id,= " + var3);
                ap = false;
                return;
            }

            if (Spell.GetSpell(var3).Cost > this.ax.n(4)) {
                if (this.a((String[])t, 3)) {
                    as = var1;
                    ad = true;
                }
            } else if (var1 - this.V >= 500L && Spell.ValidateSpellNum(var3)) {
                at = true;
                if (Spell.b(var3)) {
                    if (!aa) {
                        if (this.a((String[])g, 1)) {
                            as = var1;
                            ad = true;
                        }
                    } else {
                        this.ax.b(var3, j);
                        System.out.println("monster health is " + j.g);
                        ao = true;
                    }
                } else {
                    this.ax.CastSpell(var3);
                    am = true;
                }

                this.V = var1;
            }

            ap = false;
        }

    }

    private void g(long var1) {
        if (U) {
            int var3 = this.ax.l();
            if (var3 == 0) {
                if (this.a((String[])Q, -1)) {
                    as = var1;
                    ad = true;
                }
            } else {
                this.ax.b = (byte)var3;
                String var4 = Spell.GetSpell(var3).Name;
                String[] var5 = func.c(var4);
                String[] var6 = null;
                if (var5.length == 1) {
                    var6 = new String[]{var4, ""};
                } else if (var5.length >= 3) {
                    var6 = new String[]{var5[0] + " " + var5[1], var5[2]};
                } else {
                    var6 = var5;
                }

                if (this.a((String[])var6, -1)) {
                    as = var1;
                    ad = true;
                }
            }

            U = false;
        }

    }

    private void f(long var1) {
        int var3 = this.ax.r();
        System.out.println("NPC In front is " + var3);
        if (var3 >= 0) {
            this.d(var3);
            System.out.println("done interacting with NPC, must paint as well");
        } else if (m) {
            byte[] var4 = this.ax.h();
            int var5 = this.ax.b(var4);
            if (var5 == -1) {
                if (this.a((String[])D, 4)) {
                    as = var1;
                    ad = true;
                }
            } else if (var5 == 0) {
                if (this.a((String[])aA, -1)) {
                    as = var1;
                    ad = true;
                }
            } else if (this.a((String[])this.k(), -1)) {
                as = var1;
                ad = true;
            }
        }

        ay = false;
    }

    private String[] k() {
        int var1 = this.ax.InventoryCount - 1;
        int var2 = Math.abs(this.ax.Inventory[var1]);
        String[] var3 = func.c(Item.GetItemName(var2));
        String[] var4 = new String[]{"", ""};
        if (var3.length >= 3) {
            var4[0] = var3[0] + " " + var3[1];
            var4[1] = var3[2];
        } else {
            for(int i = 0; i < var3.length; ++i) {
                var4[i] = var3[i];
            }
        }

        return var4;
    }

    private void f() {
        this.Game.a(this.Game.OptionsMenu);
        al = false;
        Z = false;
    }

    private void a(long var1) {
        this.c = 1;
        if (this.ax.I) {
            this.c = 2;
        }

        if (this.ax.CurDung == 1) {
            this.c = 2;
        }

        this.aC = var1;
        I = false;
    }

    void d(int var1) {
        String var2 = NPC.a(this.ax, var1, 1, 0);
        System.out.println("Just after NPC interaction in game canvas!");
        Menu var3;
        String var4;
        String var5;
        short var6;
        if (var2 != null) {
            this.Game.NPCHelloMenu.a(NPC.NPCNames[var1]);
            this.Game.NPCHelloMenu.e(var2);
            this.Game.NPCHelloMenu.c = this.Game.NPCDlgMenus[var1];
            this.Game.NPCHelloMenu.npcID = var1;
            var3 = (Menu)this.Game.NPCHelloMenu.c;
            var4 = var3.M;
            var5 = var3.t();
            var6 = 0;
            if (NPC.b(var1)) {
                var6 = NPC.p[var1];
            } else if (var1 == 4) {
                var6 = k.a;
            } else if (var1 == 5) {
                var6 = k.g;
            }

            var5 = func.StringInsert(var4, "<TAG>", var6);
            var3.e(var5);
            this.Game.a(this.Game.NPCHelloMenu);
            al = false;
        } else {
            boolean var7;
            if (var1 == 4) {
                System.out.println("BENECA has nothing more to say!");
                var3 = this.Game.NPCDlgMenus[4];
                var4 = var3.M;
                var5 = var3.t();
                var7 = false;
                var6 = k.a;
                var5 = func.StringInsert(var4, "<TAG>", var6);
                var3.e(var5);
                this.Game.a(var3);
                al = false;
            } else if (var1 == 5) {
                System.out.println("HELGA has nothing more to say!");
                var3 = this.Game.NPCDlgMenus[5];
                var4 = var3.M;
                var5 = var3.t();
                var7 = false;
                var6 = k.g;
                var5 = func.StringInsert(var4, "<TAG>", var6);
                var3.e(var5);
                this.Game.a(var3);
                al = false;
            }
        }

    }

    private void a(long var1, long var3) {
        int var5 = this.ax.n(2);
        if (var5 <= 0) {
            aa = false;
            this.aD = 2;
            this.s = var1;
        }

        if (!at) {
            this.ax.a(var3);
        }

    }

    public void e() {
        this.ak = true;
    }

    public void b() {
        this.ak = false;
    }

    protected void showNotify() {
        this.ax.w();
        this.q();
        if (f == 2) {
            this.p();
        }

        this.c();
        this.a();
        al = true;
        this.b();
        if (E) {
            String[] var1 = null;
            if (this.ax.u) {
                var1 = r;
            } else if (this.ax.O) {
                var1 = ag;
            } else {
                var1 = this.ax.b().a();
            }

            if (this.a((String[])var1, 1)) {
                as = System.currentTimeMillis();
                ad = true;
            }

            E = false;
        }

    }

    private boolean o() {
        int var1 = func.a(10);
        return var1 == 1;
    }

    private void c(long var1) {
        Character var10000;
        byte var3;
        if (this.ax.k(4)) {
            var10000 = this.ax;
            var10000.ah = (short)((int)((long)var10000.ah - var1));
            if (this.ax.ah < 0) {
                this.ax.ah = 0;
                var3 = 3;
                this.ax.A = (byte)func.c(var3, this.ax.A);
            }
        }

        if (this.ax.k(5)) {
            var10000 = this.ax;
            var10000.F = (short)((int)((long)var10000.F - var1));
            if (this.ax.F < 0) {
                this.ax.F = 0;
                var3 = 4;
                this.ax.A = (byte)func.c(var3, this.ax.A);
            }
        }

        if (this.ax.k(7) && A) {
            var10000 = this.ax;
            var10000.ap = (short)((int)((long)var10000.ap - var1));
            if (this.ax.ap < 0) {
                this.ax.ap = 0;
                var3 = 6;
                this.ax.A = (byte)func.c(var3, this.ax.A);
            }
        }

    }

    private void l() {
        short[] var10000;
        int var1;
        if (this.ax.k(4)) {
            var1 = 2 * this.ax.CharCritAtt[3] / 100;
            var1 = Math.max(var1, 0);
            var10000 = this.ax.CharCritAtt;
            var10000[2] = (short)(var10000[2] - var1);
        }

        int var2;
        if (this.ax.k(5)) {
            var1 = this.ax.CharCritAtt[5] / 10;
            var10000 = this.ax.CharCritAtt;
            var10000[4] = (short)(var10000[4] + var1);
            if (this.ax.CharCritAtt[4] >= this.ax.CharCritAtt[5]) {
                this.ax.CharCritAtt[4] = 0;
                var2 = this.ax.CharCritAtt[5] / 10;
                var10000 = this.ax.CharCritAtt;
                var10000[2] = (short)(var10000[2] - var2);
            }
        }

        for(var1 = 0; var1 < 25; ++var1) {
            if (this.ax.G[var1] > 0) {
                --this.ax.G[var1];
                if (this.ax.G[var1] <= 0) {
                    this.ax.G[var1] = 0;
                    if (var1 == 5) {
                        System.out.println("Removing daedric weapon!");
                        var2 = this.ax.o(109);
                        System.out.println("Removing daedric weapon!: index is " + var2);
                        this.ax.y(var2);
                    }
                }
            }
        }

        Hashtable var6 = ESGame.G[this.ax.CurDung - 1];
        if (var6 != null) {
            Enumeration var3 = var6.elements();

            while(var3.hasMoreElements()) {
                byte[] var4 = (byte[])var3.nextElement();
                Monster var5 = Monster.a(var4);
                if (var5.c[6] != 0) {
                    --var5.c[7];
                    if (var5.c[7] < 0) {
                        var5.c[7] = 0;
                        var5.c[6] = 0;
                    }
                }
            }

        }
    }

    private boolean d() {
        if (NPC.a(this.ax)) {
            return true;
        } else if (j == null) {
            return false;
        } else if (this.ax.CurDung == 37 && j.l == 41) {
            int var1 = Math.abs(this.ax.l - j.o);
            int var2 = Math.abs(this.ax.Ka - j.m);
            return var1 + var2 == 1;
        } else {
            return false;
        }
    }

    private void a(Graphics graphics, CusImg var2, int var3, int var4) {
        DirectGraphics var5 = DirectUtils.getDirectGraphics(graphics);
        var5.drawPixels(var2.ImgBuf, true, 0, var2.ScanLen, var3, var4, var2.Width, var2.Height, 0, 4444);
    }
}
