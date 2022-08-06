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

public class GameCanvas extends FullCanvas implements Runnable {
    private static final Font SmallPlain1 = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);
    private static final Font LargeItalic1 = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_ITALIC, Font.SIZE_LARGE);
    private static final Font LargeItalic2 = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_ITALIC, Font.SIZE_LARGE);
    private static final Font LargeBold1 = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_LARGE);
    static final int[][][] n = new int[][][]{{{12, 0, 0, 1}, {11, 0, -1, 1}, {12, 1, -1, 2}, {12, 2, -1, 3}, {11, 2, -2, 3}, {12, 3, -2, 4}}, {{12, 0, 0, 1}, {12, 1, 0, 2}, {11, 1, -1, 2}, {12, 2, -1, 3}, {12, 3, -1, 4}, {12, 3, -1, 4}}, {{12, 0, 0, 1}, {12, 1, 0, 2}, {12, 2, 0, 3}, {11, 2, -1, 3}, {12, 3, -1, 4}, {12, 3, -1, 4}}, {{12, 0, 0, 1}, {12, 1, 0, 2}, {12, 2, 0, 3}, {12, 3, 0, 4}, {11, 3, -1, 4}, {11, 3, -1, 4}}, {{12, 0, 0, 1}, {12, 1, 0, 2}, {12, 2, 0, 3}, {12, 3, 0, 4}, {12, 3, 0, 4}, {12, 3, 0, 4}}};
    private static final byte[][] ae = new byte[][]{{1, 5, 31, 53, 0, 1, 40, -39, 1, 4, 13, -2, 3, 6, 71, 4, 30, 64, 2, 0, 0, 0}, {6, 10, 31, 53, 7, 1, 27, -35, 8, 4, 1, 69, 11, 27, 66, 9, 33, 10, 10, 0, 0, 0}, {11, 25, 31, 20, 14, 1, 0, 0, -1, -1, 2, 25, 15, 81, 8, 16, 9, 0, 17, 60, 57, 18}, {26, 40, 31, 32, 21, 1, 0, 0, -1, -1, 43, 44, 22, 50, 25, 23, -36, 9, 24, -25, 44, 25}};
    private static final byte[][] a = new byte[][]{{0, 0}, {0, 0}, {0, 3}, {0, 3}, {0, 3}, {0, 2}, {0, 2}, {0, 3}, {0, 3}, {0, 3}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}};
    private static final boolean[][] J = new boolean[][]{{false, false, false, false}, {true, false, false, false}, {false, false, false, false}, {false, false, true, false}, {true, false, true, false}, {false, false, false, false}, {false, false, false, false}, {false, true, false, false}, {false, false, true, false}, {false, true, true, false}, {true, false, false, false}, {false, true, false, false}, {true, false, true, false}, {false, true, true, false}, {true, true, true, false}, {true, false, false, false}, {false, true, false, false}, {true, false, true, false}, {false, true, true, false}, {true, true, true, false}, {true, true, false, false}, {true, true, false, false}, {true, true, false, false}, {true, true, true, false}, {true, true, true, false}, {false, false, false, false}, {false, false, false, false}, {false, false, false, false}, {false, false, false, false}, {false, false, false, false}, {false, false, false, false}, {false, false, false, false}, {false, false, false, false}, {false, false, false, false}, {false, false, false, false}, {false, true, false, true}, {false, true, false, true}, {true, false, false, true}, {true, false, true, false}, {false, true, true, false}, {false, false, false, false}};
    private static final char[] MenuNums = new char[]{'1', '3', '5', '7', '9', '0'};
    private static final char[] Directions = new char[]{'0', 'N', 'E', 'S', 'W'};
    private static final int[][] o = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 2, 1}};
    private ESGame Game;
    private int ac;
    private int T;
    private Thread gameThread = new Thread(this);
    private boolean GamePaused;
    private boolean z;
    private boolean aB;
    Character Char;
    byte aD;
    boolean v;
    byte c;
    long aC;
    long s;
    long B;
    long V;
    boolean Strafe;
    int MoveDirection;
    static boolean aa;
    static boolean m;
    static boolean R;
    static boolean FacingNPC;
    static Image floor3;
    static Image newwallsnok;
    static CusImg[] MonImgs;
    static Image[] AttackImgs;
    static CusImg[] ImgChest;
    static CusImg[] ImgBag;
    static CusImg[] ImgCrystal;
    static Image[] MenuIcons;
    private static byte[][] MapVecSmall;
    private static byte[][] MapVecLarge;
    private static int MapState = 1;
    static boolean AnimAttack = false;
    static boolean AnimCastMon = false;
    static boolean AnimCastSelf = false;
    static int aq;
    static boolean Attacking = false;
    static boolean ay = false;
    static boolean I = false;
    static boolean Z = false;
    static boolean ap = false;
    static boolean U = false;
    static boolean ad = false;
    static long as = 0L;
    static String[] CurrentMsg = null;
    private static int X = 0;
    static boolean af = false;
    private static boolean al = true;
    private static boolean at = false;
    static boolean E = false;
    static boolean A = false;
    static final String[] WCMsg = new String[]{"Warden's", "Camp"};
    static final String[] OCMsg = new String[]{"Outer", "Camp"};
    static final String[] NOCampMsg = new String[]{"Cannot", "Camp!"};
    static final String[] NoSpellsMsg = new String[]{"No spells!", ""};
    static final String[] LowMagicMsg = new String[]{"Not enough", "magic!"};
    static final String[] NoMonsterMsg = new String[]{"No monster", "here!"};
    static final String[] RDMsg = new String[]{"Rest", "disturbed!"};
    static final String[] RestedMsg = new String[]{"Rest", "complete!"};
    static final String[] MonDeadMsg = new String[]{"Creature", "is dead!"};
    static final String[] MonAttacksMsg = new String[]{"Creature", "attacks!"};
    static final String[] ChestMsg = new String[]{"Chest", ""};
    static final String[] LChestMsg = new String[]{"Chest", "locked!"};
    static final String[] InvFullMsg = new String[]{"Inventory", "full!"};
    static final String[] ItemFndMsg = new String[]{"Found", "item!"};
    static final String[] MultItemsMsg = new String[]{"Several", "items!"};
    static final String[][] NPCMsg = new String[][]{{"Arantamo", ""}, {"Celegil", ""}, {"Favela Dralor", ""}, {"Vander", ""}, {"Beneca", ""}, {"Helga", ""}, {"Varus", ""}};
    static Monster Mon2 = new Monster();
    static Monster Mon1 = null;
    private static long ai = 0L;
    private static boolean ErrorOccured = false;
    private static String ErrorStr = null;

    public GameCanvas(ESGame game) {
        this.Game = game;
        this.T = 0;
        this.ac = 0;
        this.z = false;
        this.GamePaused = false;
        this.aB = false;
        this.Char = null;
        this.aD = 1;
        this.v = false;
        this.c = 0;
        this.s = 0L;
        this.aC = 0L;
        this.MoveDirection = 0;
        this.Strafe = false;
        aa = false;
        m = false;
        R = false;
        FacingNPC = false;
        MapVecSmall = new byte[7][7];
        MapVecLarge = new byte[17][17];
        aq = 0;
        this.B = 0L;
        this.V = 0L;
    }

    public void paint(Graphics graphics) {
        if (this.aD == 3) {
            this.DeathScreen(graphics);
        } else if (this.c != 1 && this.c != 2) {
            this.DrawGame(graphics);
        } else {
            this.CampingScreen(graphics);
        }

    }

    private void DeathScreen(Graphics graphics) {
        graphics.setColor(0X000000); // Black
        graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
        graphics.setColor(0XFFFFFF); // White
        graphics.setFont(LargeItalic2);
        graphics.drawString("You're Dead!", this.getWidth() / 2, this.getHeight() / 2, 33);
    }

    private void CampingScreen(Graphics graphics) {
        graphics.setColor(0X000000); // Black
        graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
        graphics.setColor(0XFFFFFF); // White
        graphics.setFont(LargeItalic2);
        graphics.drawString("CAMPING", this.getWidth() / 2, this.getHeight() / 2, 33);
    }

    private void DrawGame(Graphics graphics) {
        graphics.setColor(0X000000); // Black
        graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
        this.DrawRoom(graphics);
        this.b(graphics);
        if (FacingNPC) {
            int npcID = this.Char.GetNPCInfront();
            this.DrawNPC(graphics, npcID);
        }

        try {
            this.PaintMonster(graphics);
        } catch (Throwable err) {
            System.out.println("Error in paintMonsters: " + err);
        }

        this.DrawStatBar(graphics);
        this.DrawBottomBar(graphics);
        this.DrawPopUp(graphics);
        this.DrawActionAnimation(graphics);
        if (ErrorOccured) {
            this.DrawErrorStr(graphics);
        }

        if (MapState == GD.MAP_SMALL && !this.Char.GetAilment(3)) {
            this.DrawMiniMap(graphics);
        }

        if (MapState == GD.MAP_LARGE && !this.Char.GetAilment(3)) {
            this.DrawLargeMap(graphics);
        }

    }

    private void DrawErrorStr(Graphics graphics) {
        graphics.setColor(0XFFFFFF); // White
        graphics.drawString(ErrorStr, 60, 10, 17);
    }

    private void DrawActionAnimation(Graphics graphics) {
        int xpos;
        int ypos;
        if (AnimAttack) {
            xpos = 40 + func.a(30);
            ypos = 50 + func.a(20);
            graphics.drawImage(AttackImgs[0], xpos, ypos, 20);
            AnimAttack = false;
        }

        if (AnimCastMon) {
            xpos = 40 + func.a(30);
            ypos = 50 + func.a(22);
            graphics.drawImage(AttackImgs[1], xpos, ypos, 20);
            AnimCastMon = false;
        }

        if (AnimCastSelf) {
            xpos = 50 + func.a(2);
            ypos = 80 + func.a(2);
            graphics.drawImage(AttackImgs[2], xpos, ypos, 20);
            AnimCastSelf = false;
        }

    }

    private void DrawRoom(Graphics graphics) {
        Dungeon dung = this.Char.GetCurrentDungeon();
        byte[][] var3 = this.Char.ae;
        int i;
        if (!this.Char.GetAilment(3)) {
            if (this.Char.GetAilment(4)) {
                graphics.setColor(0XA00000); // Dark Red
                graphics.fillRect(0, 0, this.getWidth(), floor3.getHeight());
            } else {
                for(i = 0; i < 5; ++i) {
                    graphics.drawImage(floor3, i * 36, 0, 20);
                }
            }
        }

        int var4;
        int var5;
        int j;
        int k;
        int var9;
        int var10;
        int var11;
        for(i = 0; i < 5; ++i) {
            var5 = i * 18;

            for(j = 0; j < 6; ++j) {
                k = n[i][j][0];
                var9 = n[i][j][1];
                var10 = n[i][j][2];
                var11 = n[i][j][3];
                if (func.a((byte)1, dung.a(var10, var11, var3))) {
                    var4 = this.a(k, var9, -1);
                    this.DrawWalls(graphics, var4, var5);
                    break;
                }
            }
        }

        for(j = 5; j < 10; ++j) {
            var5 = j * 18;

            for(k = 0; k < 6; ++k) {
                var9 = n[9 - j][k][0];
                var10 = n[9 - j][k][1];
                var11 = -n[9 - j][k][2];
                int var12 = n[9 - j][k][3];
                if (func.a((byte)1, dung.a(var11, var12, var3))) {
                    var4 = this.a(var9, var10, 1);
                    this.DrawWalls(graphics, var4, var5);
                    break;
                }
            }
        }

    }

    private void b(Graphics graphics) {
        for(int i = 8; i <= 12; ++i) {
            Object obj1 = Character.ad.elementAt(i);
            if (obj1 instanceof byte[]) {
                byte[] btarr = (byte[])obj1;
                if (btarr.length == 8 || btarr.length == 7) {
                    this.a(graphics, btarr, i);
                }
            }
        }

        byte[] btarr;
        Object obj2;
        for(int i = 4; i <= 6; ++i) {
            obj2 = Character.ad.elementAt(i);
            if (obj2 instanceof byte[]) {
                btarr = (byte[])obj2;
                if (btarr.length == 8 || btarr.length == 7) {
                    this.a(graphics, btarr, i);
                }
            }
        }

        obj2 = Character.ad.elementAt(1);
        if (obj2 instanceof byte[]) {
            btarr = (byte[])obj2;
            if (btarr.length == 8 || btarr.length == 7) {
                this.a(graphics, btarr, 1);
            }
        }

    }

    private void DrawWalls(Graphics graphics, int var2, int var3) {
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
            CurrentMsg = var1;
            if (var2 < 0) {
                X = 10;
            } else {
                X = var2;
            }

            return true;
        }
    }

    private void c() {
        Dungeon dung = this.Char.GetCurrentDungeon();
        byte[][] var2 = this.Char.ae;
        byte var3 = dung.a(0, 1, var2);
        if (func.a((byte)32, var3)) {
            int var4 = this.Char.GetNPCInfront();
            FacingNPC = true;
            String[] var5 = NPCMsg[var4];
            if (this.a((String[])var5, 1)) {
                as = System.currentTimeMillis();
                ad = true;
            }
        } else {
            FacingNPC = false;
            if (!this.d() && NPC.WardenPresent && this.Char.m == Mon2.f) {
                Mon2.GetMonName();
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

    private void DrawNPC(Graphics graphics, int npcid) {
        boolean var5 = false;
        boolean var6 = false;
        boolean var7 = false;
        boolean var8 = false;
        switch (npcid) {
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
                int var9 = Math.min(Mon2.f, 3) - 1;
                this.a(graphics, var9);
        }

        graphics.setClip(0, 0, this.getWidth(), this.getHeight());
    }

    private void a(Graphics graphics, int var2) {
        byte var3 = 15;
        byte var4 = 32;
        this.DrawCusImg(graphics, MonImgs[28], o[var2][0], 1, var3, var4);
        int var5 = MonImgs[28].GetWidth();
        this.DrawCusImg(graphics, MonImgs[28], o[var2][0], 1, var3 + var5, var4, DirectGraphics.FLIP_HORIZONTAL);
        this.DrawCusImg(graphics, MonImgs[29], o[var2][1], 3, var3 + 45, var4 + -22);
    }

    private void PaintMonster(Graphics graphics) {
        A = false;

        for(int i = 8; i <= 12; ++i) {
            Object obj = Character.ad.elementAt(i);
            if (obj instanceof byte[]) {
                byte[] var4 = (byte[])obj;
                if (var4.length == 28 && var4[6] != 0) {
                    A = true;
                    this.c(graphics, var4[2], i);
                }
            } else if (obj instanceof String) {
                String var7 = (String)obj;
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

    private void a(Graphics graphics, byte[] arr, int var3) {
        if (var3 == 1) {
            this.DrawItemClose(graphics, arr, false);
        } else if (var3 >= 4 && var3 <= 6) {
            this.DrawItemMid(graphics, arr, false, var3);
        } else if (var3 >= 8 && var3 <= 12) {
            this.DrawItemFar(graphics, arr, false, var3);
        }

    }

    private static boolean a(byte[] var0) {
        if (var0.length != 7) {
            return false;
        } else {
            return (var0[6] & 4) != 0;
        }
    }

    private void DrawItemClose(Graphics graphics, byte[] var2, boolean var3) {
        byte var4;
        int var5;
        if (a(var2)) {
            var4 = 45;
            var5 = 65;
            this.DrawCusImg(graphics, ImgCrystal[0], var4, var5);
        } else {
            var4 = 60;
            var5 = 94;
            byte var6 = 0;
            if (var2.length == 8) {
                this.DrawCusImg(graphics, ImgChest[var6], var4, var5);
            } else if (var2.length == 7) {
                var5 += 14;
                this.DrawCusImg(graphics, ImgBag[var6], var4, var5);
            }
        }

    }

    private void DrawItemMid(Graphics graphics, byte[] var2, boolean var3, int var4) {
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
            this.DrawCusImg(graphics, ImgCrystal[var5], var6, var7);
        } else if (var2.length == 8) {
            var7 += 17;
            this.DrawCusImg(graphics, ImgChest[var5], var6, var7);
        } else if (var2.length == 7) {
            var7 += 20;
            this.DrawCusImg(graphics, ImgBag[var5], var6, var7);
        }

    }

    private void DrawItemFar(Graphics graphics, byte[] var2, boolean var3, int var4) {
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
            this.DrawCusImg(graphics, ImgCrystal[var5], var6, var7);
        } else if (var2.length == 8) {
            var7 += 28;
            this.DrawCusImg(graphics, ImgChest[var5], var6, var7);
        } else if (var2.length == 7) {
            var7 += 28;
            this.DrawCusImg(graphics, ImgBag[var5], var6, var7);
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
                this.DrawCusImg(graphics, MonImgs[var8], var14, var9, var6, var7);
                if (var5) {
                    this.DrawCusImg(graphics, MonImgs[var12], var15, var13, var10, var11);
                }

                int var20;
                int var21;
                byte var22;
                if (var16) {
                    var20 = var6 + ae[var4][10];
                    var21 = var7 + ae[var4][11];
                    var22 = ae[var4][12];
                    this.DrawCusImg(graphics, MonImgs[var22], 0, 1, var20, var21);
                }

                if (var17) {
                    var20 = var6 + ae[var4][13];
                    var21 = var7 + ae[var4][14];
                    var22 = ae[var4][15];
                    this.DrawCusImg(graphics, MonImgs[var22], 0, 1, var20, var21);
                }

                if (var18) {
                    var20 = var6 + ae[var4][16];
                    var21 = var7 + ae[var4][17];
                    var22 = ae[var4][18];
                    this.DrawCusImg(graphics, MonImgs[var22], 0, 1, var20, var21);
                }

                if (var19) {
                    var20 = var6 + ae[var4][19];
                    var21 = var7 + ae[var4][20];
                    var22 = ae[var4][21];
                    this.DrawCusImg(graphics, MonImgs[var22], 0, 1, var20, var21);
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

        this.DrawCusImg(graphics, MonImgs[var2], var4, var5, var6, var7);
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

    private void DrawStatBar(Graphics graphics) {
        graphics.setColor(0XFFFF00); // Yellow
        graphics.fillRect(5, 130, 40, 7);
        graphics.fillRect(5, 138, 40, 7);
        graphics.fillRect(5, 146, 40, 7);
        graphics.setColor(0XFF0000); // Red
        int AttrPcnt = this.Char.GetCritAtt(2) * 38 / this.Char.CharCritAtt[3];
        graphics.fillRect(6, 131, AttrPcnt, 5);
        graphics.setColor(0X00FF00); // Green
        AttrPcnt = this.Char.GetCritAtt(4) * 38 / this.Char.CharCritAtt[5];
        graphics.fillRect(6, 139, AttrPcnt, 5);
        graphics.setColor(0X0000FF); // Blue
        AttrPcnt = this.Char.GetCritAtt(6) * 38 / this.Char.CharCritAtt[7];
        if (AttrPcnt > 40) {
            AttrPcnt = 40;
        }

        graphics.fillRect(6, 147, AttrPcnt, 5);
    }

    private void DrawPopUp(Graphics graphics) {
        if (ad) {
            graphics.setColor(0XC79967); // Beige
            graphics.fillRoundRect(96, 118, 75, 35, 5, 5);
            graphics.setFont(SmallPlain1);
            graphics.setColor(0X000000); // Black
            graphics.drawString(CurrentMsg[0], 100, 122, 20);
            if (CurrentMsg.length > 1) {
                graphics.drawString(CurrentMsg[1], 100, 134, 20);
            }

        }
    }

    private void DrawBottomBar(Graphics graphics) {
        graphics.setFont(SmallPlain1);
        graphics.setClip(0, 0, this.getWidth(), this.getHeight());
        graphics.setColor(0X000000); // Black
        graphics.fillRect(0, 156, this.getWidth(), 52);
        graphics.setColor(0XC79967); // beige
        graphics.fillRoundRect(2, 158, this.getWidth() - 4, 48, 5, 5);
        graphics.setColor(0X000000); // Black
        int infront = this.GetBarState();
        aq = infront;
        if (infront == 0) { // nothing infront
            graphics.drawImage(MenuIcons[1], 14, 174, 20);
            graphics.drawImage(MenuIcons[2], 62, 174, 20);
            graphics.drawImage(MenuIcons[3], 104, 174, 20);
            graphics.drawImage(MenuIcons[5], 144, 174, 20);
            graphics.drawChar(MenuNums[1], 5, 180, 20);
            graphics.drawChar(MenuNums[2], 53, 180, 20);
            graphics.drawChar(MenuNums[3], 96, 180, 20);
            graphics.drawChar(MenuNums[5], 135, 180, 20);
        } else if (infront == 1) { // monster
            graphics.drawImage(MenuIcons[0], 14, 174, 20);
            graphics.drawImage(MenuIcons[1], 62, 174, 20);
            graphics.drawImage(MenuIcons[2], 104, 174, 20);
            graphics.drawImage(MenuIcons[3], 144, 174, 20);
            graphics.drawChar(MenuNums[0], 5, 180, 20);
            graphics.drawChar(MenuNums[1], 53, 180, 20);
            graphics.drawChar(MenuNums[2], 96, 180, 20);
            graphics.drawChar(MenuNums[3], 135, 180, 20);
        } else if (infront == 2) { // npc or chest
            graphics.drawImage(MenuIcons[1], 14, 174, 20);
            graphics.drawImage(MenuIcons[2], 62, 174, 20);
            graphics.drawImage(MenuIcons[3], 104, 174, 20);
            graphics.drawImage(MenuIcons[4], 144, 174, 20);
            graphics.drawChar(MenuNums[1], 5, 180, 20);
            graphics.drawChar(MenuNums[2], 53, 180, 20);
            graphics.drawChar(MenuNums[3], 96, 180, 20);
            graphics.drawChar(MenuNums[4], 135, 180, 20);
        }

    }

    private int GetBarState() {
        if (aa) {
            return 1;
        } else if (!m && !R) {
            return FacingNPC && !this.d() ? 2 : 0;
        } else {
            return 2;
        }
    }

    private void DrawCusImg(Graphics graphics, CusImg img, int var3, int var4, int var5, int var6) {
        this.DrawCusImg(graphics, img, var3, var4, var5, var6, 0);
    }

    private void DrawCusImg(Graphics graphics, CusImg img, int var3, int var4, int x, int y, int Manipulation) {
        int var8 = img.GetWidth() / var4;
        int var9 = img.GetHeight();
        graphics.setClip(x, y, var8, var9);
        DirectGraphics var10 = DirectUtils.getDirectGraphics(graphics);
        var10.drawPixels(img.ImgBuf, true, 0, img.ScanLen, x - var3 * var8, y, img.Width, img.Height, Manipulation, DirectGraphics.TYPE_USHORT_4444_ARGB);
    }

    private void DrawMiniMap(Graphics graphics) {
        graphics.setFont(SmallPlain1);
        graphics.setColor(0XFFFFFF); // White
        graphics.drawChar(Directions[this.Char.DirFacing], 16, 10, 20);
        graphics.setColor(0X000000); // Black
        graphics.fillRect(10, 20, 23, 23);
        this.DrawMap(graphics, 10, 20, 7, 3, 1, MapVecSmall);
    }

    private void DrawLargeMap(Graphics graphics) {
        graphics.setFont(LargeBold1);
        graphics.setColor(0XFFFFFF); // White
        graphics.drawChar(Directions[this.Char.DirFacing], 58, 10, 20);
        byte MapSize = 89;
        graphics.fillRect(15, 25, MapSize, MapSize);
        this.DrawMap(graphics, 15, 25, 17, 5, 2, MapVecLarge);
    }

    private void DrawMap(Graphics graphics, int xOffset, int yOffset, int MapSide, int pxlSize, int Border, byte[][] map) {
        int center = MapSide / 2;

        for(int i = 0; i < MapSide; ++i) {
            int x = yOffset + Border + i * pxlSize;

            for(int j = 0; j < MapSide; ++j) {
                int y = xOffset + Border + j * pxlSize;
                if (map[j][i] == 1) {
                    graphics.setColor(0X000000); // Black
                    graphics.fillRect(y, x, pxlSize, pxlSize);
                } else if (map[j][i] == 0) {
                    graphics.setColor(0XFFFFFF); // White
                    graphics.fillRect(y, x, pxlSize, pxlSize);
                } else if ((map[j][i] & 2) != 0) {
                    graphics.setColor(0XFF0000); // Red
                    graphics.fillRect(y, x, pxlSize, pxlSize);
                } else if ((map[j][i] & 4) != 0) {
                    graphics.setColor(0X0000FF); // Blue
                    graphics.fillRect(y, x, pxlSize, pxlSize);
                } else if ((map[j][i] & 8) != 0) {
                    graphics.setColor(0XCC00FF); // magenta
                    graphics.fillRect(y, x, pxlSize, pxlSize);
                }

                if (i == center && j == center) {
                    graphics.setColor(0X00FF00); // Green
                    graphics.fillRect(y, x, pxlSize, pxlSize);
                }
            }
        }

    }

    void UpdateMiniMap() {
        byte xpos = this.Char.XPos;
        byte ypos = this.Char.YPos;
        byte dirFacing = this.Char.DirFacing;
        this.Char.GetCurrentDungeon().UpdateMiniMap(xpos, ypos, dirFacing, MapVecSmall);
    }

    void UpdateMap() {
        byte xpos = this.Char.XPos;
        byte ypos = this.Char.YPos;
        byte dirFacing = this.Char.DirFacing;
        this.Char.GetCurrentDungeon().UpdateMap(xpos, ypos, dirFacing, MapVecLarge);
    }

    public void keyPressed(int key) {
        this.T = this.ac;
        if (key == KEY_NUM1) {
            if (aq == 1) {
                Attacking = true;
            }

        } else if (key == KEY_NUM2) {
            this.MoveDirection = GD.DIR_FORWARD;
        } else if (key == KEY_NUM3) {
            ap = true;
        } else if (key == KEY_NUM4) {
            this.Strafe = true;
            this.MoveDirection = GD.DIR_LEFT;
        } else if (key == KEY_NUM5) {
            U = true;
        } else if (key == KEY_NUM6) {
            this.Strafe = true;
            this.MoveDirection = GD.DIR_RIGHT;
        } else if (key == KEY_NUM7) {
            Z = true;
        } else if (key == KEY_NUM8) {
            this.MoveDirection = GD.DIR_BACK;
        } else if (key == KEY_NUM9) {
            if (aq == 2) {
                ay = true;
            }

        } else if (key == KEY_NUM0) {
            if (aq == 0) {
                I = true;
            }

        } else if (key == KEY_STAR) {
            ++MapState;
            if (MapState > 2) {
                MapState = 1;
            }

        } else {
            this.Strafe = false;
            this.ac = this.getGameAction(key);
            switch (this.ac) {
                case 1:
                    this.MoveDirection = GD.DIR_FORWARD;
                    break;
                case 2:
                    this.MoveDirection = GD.DIR_LEFT;
                case 3:
                case 4:
                default:
                    break;
                case 5:
                    this.MoveDirection = GD.DIR_RIGHT;
                    break;
                case 6:
                    this.MoveDirection = GD.DIR_BACK;
            }

        }
    }

    public void keyReleased(int key) {
        this.getGameAction(key);
        this.T = this.ac;
        this.ac = 0;
    }

    void ClearGameThread() {
        if (this.gameThread != null) {
            this.z = true;
            if (this.gameThread.isAlive()) {
                System.out.println("Killing game thread");
                this.aB = true;

                try {
                    this.gameThread.join();
                } catch (Exception err) {
                }

                System.out.println("Done killing game thread");
            }

            this.gameThread = null;
            System.gc();
        }
    }

    void StartGame() {
        try {
            this.ClearGameThread();
            this.gameThread = new Thread(this);
            this.gameThread.start();
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
                if (this.GamePaused) {
                    var3 = System.currentTimeMillis();

                    try {
                        Thread.sleep(250L);
                    } catch (Exception err1) {
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
                                this.Char.GetCurrentDungeon().a(this.Char);
                                this.aC = 0L;
                                this.v = true;
                                this.Char.e(false);
                                var10 = true;
                                if (this.a((String[]) RDMsg, 1)) {
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
                            this.Char.e(true);
                            if (this.a((String[]) RestedMsg, 1)) {
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
                            this.Char.Recover(this.Char.CharCritAtt);

                            for(int i = this.Char.InventoryCount - 1; i >= 0; --i) {
                                if (!this.Char.IsEquiped(i)) {
                                    this.Char.RemoveFromInv(i);
                                }
                            }

                            this.Char.ResetChar(this.Char.CharClass, true);
                            this.s = 0L;
                            this.aD = 1;
                            NPC.l = true;
                            this.v = true;
                            E = true;
                            var10 = true;
                            if (E) {
                                String[] var12 = null;
                                if (this.Char.EnteringWC) {
                                    var12 = WCMsg;
                                } else if (this.Char.EnteringOC) {
                                    var12 = OCMsg;
                                } else {
                                    var12 = this.Char.GetCurrentDungeon().GetDungName();
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
                        if (Mon2.a(this.Char.GiftPoints)) {
                            Mon2.c();
                        }

                        if (this.d() && Mon2.f > this.Char.m) {
                            String var20 = NPC.GetNPCDialogue(this.Char, 6, -1, -1);
                            this.Game.aV = this.Game.WardenSpeaksMenu(var20);
                            var9 = true;
                        }

                        this.b(time);
                        this.e(time);
                        this.a(time, var5);
                        if (this.Char.IsLvlIncrease()) {
                            this.PauseGame();
                            this.Game.LevelUpMenu = this.Game.LevelUpMenu(1);
                            this.Game.SetDisplayContent(this.Game.LevelUpMenu);
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
                    } catch (Exception err2) {
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
                        this.PauseGame();
                        this.Game.SetDisplayContent(this.Game.aV);
                    }
                }
            }
        } catch (OutOfMemoryError err3) {
            this.Game.OutOfMemErrorScreen();
        } catch (Throwable err4) {
            System.out.println("ERROR: An error was thrown in GameCanvas run method!");
            System.out.println(err4);
            err4.printStackTrace();
            ErrorOccured = true;
            ErrorStr = String.valueOf(err4);
            this.repaint();
            this.serviceRepaints();

            try {
                Thread.sleep(10000L);
            } catch (Throwable err5) {
            }

            this.Game.b();
        }

    }

    private void a(boolean var1) {
        this.Char.d(var1);
        this.UpdateMiniMap();
        if (MapState == GD.MAP_LARGE) {
            this.UpdateMap();
        }

    }

    private void b(long var1) {
        Hashtable var3 = ESGame.MonsterTables[this.Char.CurDung - 1];
        if (var3 != null) {
            Enumeration var4 = var3.elements();

            while(true) {
                while(var4.hasMoreElements()) {
                    byte[] var5 = (byte[])var4.nextElement();
                    Monster mon = Monster.a(var5);
                    if (mon.b(this.Char)) {
                        if (mon.f == 0) {
                            mon.k = var1;
                            mon.f = 1;
                        } else if (mon.f == 1 && var1 - mon.k > 800L) {
                            mon.a(this.Char, var1);
                            if (this.a((String[]) MonAttacksMsg, 2)) {
                                as = var1;
                                ad = true;
                            }
                        } else if (var1 - mon.k > 800L) {
                            mon.a(this.Char, var1);
                        }

                        mon.d();
                    } else {
                        mon.a(this.Char);
                        mon.d();
                    }
                }

                return;
            }
        }
    }

    private void e(long var1) {
        if (I) {
            if (A) {
                if (this.a((String[]) NOCampMsg, 1)) {
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
        } else if (Attacking) {
            this.d(var1);
        } else if (Z) {
            this.f();
        } else if ((this.MoveDirection != GD.DIR_NULL || this.v) && !this.v) {
            this.n();
        }

        this.h();
        this.c();
        this.a();
        this.m();
    }

    private void d(long var1) {
        if (var1 - this.B >= 500L && Mon1 != null) {
            at = true;
            this.Char.a(Mon1);
            System.out.println("monster health is " + Mon1.Health);
            this.B = var1;
            AnimAttack = true;
        }

        Attacking = false;
    }

    private void m() {
        if (Mon1 != null && Mon1.Health <= 0) {
            if (Mon1.MonNum == 41) {
                Mon1.a(true);
            } else {
                Mon1.a(false);
            }

            ESGame.KillMonster(this.Char.CurDung, Mon1.a);
            if (this.Char.GetAilment(4)) {
                short[] var10000 = this.Char.CharCritAtt;
                var10000[2] = (short)(var10000[2] + 3 * this.Char.CharCritAtt[3] / 10);
                this.Char.CharCritAtt[2] = (short)Math.min(this.Char.CharCritAtt[2], this.Char.CharCritAtt[3]);
            }

            if (this.a((String[]) MonDeadMsg, 1)) {
                as = System.currentTimeMillis();
                ad = true;
            }

            Mon1 = null;
            aa = false;
        }

    }

    private void a() {
        Mon1 = this.Char.n();
        if (Mon1 != null) {
            aa = true;
            byte[] var1 = Mon1.f();
            Mon1 = Monster.a(Mon2, var1);
        } else {
            aa = false;
        }

        if (aa) {
            String var4 = Mon1.GetMonName();
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
        byte[] var1 = this.Char.h();
        if (var1 != null) {
            m = true;
        } else {
            m = false;
        }

        if (m && this.a((String[]) ChestMsg, 1)) {
            as = System.currentTimeMillis();
            ad = true;
        }

    }

    private void n() {
        if (this.MoveDirection != GD.DIR_NULL) {
            byte var1 = this.Char.InventoryCount;
            at = true;
            this.Char.Move(this.MoveDirection, this.Strafe);
            if (Character.GameDone) {
                this.Game.EndOfGameMenu = this.Game.EndOfGameMenu();
                this.Game.SetDisplayContent(this.Game.EndOfGameMenu);
                al = false;
            } else {
                if (this.Char.i || this.Char.EnteringWC || this.Char.EnteringOC) {
                    E = true;
                    if (E) {
                        String[] var2 = null;
                        if (this.Char.EnteringWC) {
                            var2 = WCMsg;
                        } else if (this.Char.EnteringOC) {
                            var2 = OCMsg;
                        } else {
                            var2 = this.Char.GetCurrentDungeon().GetDungName();
                        }

                        if (this.a((String[])var2, 1)) {
                            as = System.currentTimeMillis();
                            ad = true;
                        }

                        E = false;
                    }
                }

                if (this.Strafe) {
                    this.Strafe = false;
                }
            }

            this.MoveDirection = 0;
            int var3 = this.Char.InventoryCount - var1;
            if (var3 == 1) {
                if (this.a((String[])this.k(), -1)) {
                    as = System.currentTimeMillis();
                    ad = true;
                }
            } else if (var3 > 1 && this.a((String[]) MultItemsMsg, -1)) {
                as = System.currentTimeMillis();
                ad = true;
            }
        }

    }

    private void h(long var1) {
        if (ap) {
            byte spellID = this.Char.CurSpell;
            if (!Spell.ValidateSpellNum(spellID)) {
                System.out.println("Invalid spell id,= " + spellID);
                ap = false;
                return;
            }

            if (Spell.GetSpell(spellID).Cost > this.Char.GetCritAtt(4)) {
                if (this.a((String[]) LowMagicMsg, 3)) {
                    as = var1;
                    ad = true;
                }
            } else if (var1 - this.V >= 500L && Spell.ValidateSpellNum(spellID)) {
                at = true;
                if (Spell.DoesTargetMonster(spellID)) {
                    if (!aa) {
                        if (this.a((String[]) NoMonsterMsg, 1)) {
                            as = var1;
                            ad = true;
                        }
                    } else {
                        this.Char.CastOnMonster(spellID, Mon1);
                        System.out.println("monster health is " + Mon1.Health);
                        AnimCastMon = true;
                    }
                } else {
                    this.Char.CastOnSelf(spellID);
                    AnimCastSelf = true;
                }

                this.V = var1;
            }

            ap = false;
        }

    }

    private void g(long var1) {
        if (U) {
            int var3 = this.Char.l();
            if (var3 == 0) {
                if (this.a((String[]) NoSpellsMsg, -1)) {
                    as = var1;
                    ad = true;
                }
            } else {
                this.Char.CurSpell = (byte)var3;
                String var4 = Spell.GetSpell(var3).Name;
                String[] var5 = func.SeparateStringBySpace(var4);
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
        int NPCNum = this.Char.GetNPCInfront();
        System.out.println("NPC In front is " + NPCNum);
        if (NPCNum >= 0) {
            this.SpeakToNPC(NPCNum);
            System.out.println("done interacting with NPC, must paint as well");
        } else if (m) {
            byte[] var4 = this.Char.h();
            int var5 = this.Char.b(var4);
            if (var5 == -1) {
                if (this.a((String[]) LChestMsg, 4)) {
                    as = var1;
                    ad = true;
                }
            } else if (var5 == 0) {
                if (this.a((String[]) InvFullMsg, -1)) {
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
        int var1 = this.Char.InventoryCount - 1;
        int var2 = Math.abs(this.Char.Inventory[var1]);
        String[] var3 = func.SeparateStringBySpace(Item.GetItemName(var2));
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
        this.Game.SetDisplayContent(this.Game.OptionsMenu);
        al = false;
        Z = false;
    }

    private void a(long var1) {
        this.c = 1;
        if (this.Char.I) {
            this.c = 2;
        }

        if (this.Char.CurDung == 1) {
            this.c = 2;
        }

        this.aC = var1;
        I = false;
    }

    void SpeakToNPC(int npcid) {
        String var2 = NPC.GetNPCDialogue(this.Char, npcid, 1, 0);
        System.out.println("Just after NPC interaction in game canvas!");
        Menu menu;
        String var4;
        String var5;
        short var6;
        if (var2 != null) {
            this.Game.NPCHelloMenu.SetTitle(NPC.NPCNames[npcid]);
            this.Game.NPCHelloMenu.SetText(var2);
            this.Game.NPCHelloMenu.Next = this.Game.NPCDlgMenus[npcid];
            this.Game.NPCHelloMenu.npcID = npcid;
            menu = (Menu)this.Game.NPCHelloMenu.Next;
            var4 = menu.M;
            var5 = menu.GetText();
            var6 = 0;
            if (NPC.b(npcid)) {
                var6 = NPC.p[npcid];
            } else if (npcid == 4) {
                var6 = Mon2.a;
            } else if (npcid == 5) {
                var6 = Mon2.Health;
            }

            var5 = func.StringInsert(var4, "<TAG>", var6);
            menu.SetText(var5);
            this.Game.SetDisplayContent(this.Game.NPCHelloMenu);
            al = false;
        } else {
            boolean var7;
            if (npcid == 4) {
                System.out.println("BENECA has nothing more to say!");
                menu = this.Game.NPCDlgMenus[4];
                var4 = menu.M;
                var5 = menu.GetText();
                var7 = false;
                var6 = Mon2.a;
                var5 = func.StringInsert(var4, "<TAG>", var6);
                menu.SetText(var5);
                this.Game.SetDisplayContent(menu);
                al = false;
            } else if (npcid == 5) {
                System.out.println("HELGA has nothing more to say!");
                menu = this.Game.NPCDlgMenus[5];
                var4 = menu.M;
                var5 = menu.GetText();
                var7 = false;
                var6 = Mon2.Health;
                var5 = func.StringInsert(var4, "<TAG>", var6);
                menu.SetText(var5);
                this.Game.SetDisplayContent(menu);
                al = false;
            }
        }

    }

    private void a(long var1, long var3) {
        int var5 = this.Char.GetCritAtt(2);
        if (var5 <= 0) {
            aa = false;
            this.aD = 2;
            this.s = var1;
        }

        if (!at) {
            this.Char.a(var3);
        }

    }

    public void PauseGame() {
        this.GamePaused = true;
    }

    public void UnpauseGame() {
        this.GamePaused = false;
    }

    protected void showNotify() {
        this.Char.w();
        this.UpdateMiniMap();
        if (MapState == 2) {
            this.UpdateMap();
        }

        this.c();
        this.a();
        al = true;
        this.UnpauseGame();
        if (E) {
            String[] var1 = null;
            if (this.Char.EnteringWC) {
                var1 = WCMsg;
            } else if (this.Char.EnteringOC) {
                var1 = OCMsg;
            } else {
                var1 = this.Char.GetCurrentDungeon().GetDungName();
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
        Character player;
        byte var3;
        if (this.Char.GetAilment(4)) {
            player = this.Char;
            player.ah = (short)((int)((long)player.ah - var1));
            if (this.Char.ah < 0) {
                this.Char.ah = 0;
                var3 = 3;
                this.Char.Ailments = (byte)func.c(var3, this.Char.Ailments);
            }
        }

        if (this.Char.GetAilment(5)) {
            player = this.Char;
            player.F = (short)((int)((long)player.F - var1));
            if (this.Char.F < 0) {
                this.Char.F = 0;
                var3 = 4;
                this.Char.Ailments = (byte)func.c(var3, this.Char.Ailments);
            }
        }

        if (this.Char.GetAilment(7) && A) {
            player = this.Char;
            player.ap = (short)((int)((long)player.ap - var1));
            if (this.Char.ap < 0) {
                this.Char.ap = 0;
                var3 = 6;
                this.Char.Ailments = (byte)func.c(var3, this.Char.Ailments);
            }
        }

    }

    private void l() {
        short[] var10000;
        int var1;
        if (this.Char.GetAilment(4)) {
            var1 = 2 * this.Char.CharCritAtt[3] / 100;
            var1 = Math.max(var1, 0);
            var10000 = this.Char.CharCritAtt;
            var10000[2] = (short)(var10000[2] - var1);
        }

        int indx;
        if (this.Char.GetAilment(5)) {
            var1 = this.Char.CharCritAtt[5] / 10;
            var10000 = this.Char.CharCritAtt;
            var10000[4] = (short)(var10000[4] + var1);
            if (this.Char.CharCritAtt[4] >= this.Char.CharCritAtt[5]) {
                this.Char.CharCritAtt[4] = 0;
                indx = this.Char.CharCritAtt[5] / 10;
                var10000 = this.Char.CharCritAtt;
                var10000[2] = (short)(var10000[2] - indx);
            }
        }

        for(var1 = 0; var1 < 25; ++var1) {
            if (this.Char.G[var1] > 0) {
                --this.Char.G[var1];
                if (this.Char.G[var1] <= 0) {
                    this.Char.G[var1] = 0;
                    if (var1 == 5) {
                        System.out.println("Removing daedric weapon!");
                        indx = this.Char.FindItemInInv(109);
                        System.out.println("Removing daedric weapon!: index is " + indx);
                        this.Char.RemoveFromInv(indx);
                    }
                }
            }
        }

        Hashtable var6 = ESGame.MonsterTables[this.Char.CurDung - 1];
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
        if (NPC.a(this.Char)) {
            return true;
        } else if (Mon1 == null) {
            return false;
        } else if (this.Char.CurDung == 37 && Mon1.MonNum == 41) {
            int var1 = Math.abs(this.Char.XPos - Mon1.XPos);
            int var2 = Math.abs(this.Char.YPos - Mon1.YPos);
            return var1 + var2 == 1;
        } else {
            return false;
        }
    }

    private void DrawCusImg(Graphics graphics, CusImg img, int x, int y) {
        DirectGraphics var5 = DirectUtils.getDirectGraphics(graphics);
        var5.drawPixels(img.ImgBuf, true, 0, img.ScanLen, x, y, img.Width, img.Height, 0, DirectGraphics.TYPE_USHORT_4444_ARGB);
    }
}
