//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.DataInputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;
import java.util.Vector;

public class Dungeon { // i
    static String[][] DngnNames;
    static final int[][] l = new int[][]{{1, 2, 1, 3}, {6, 7, 8, 6}, {1, 2, 3, 1}, {6, 7, 8, 7}, {3, 4, 11, 12}, {8, 9, 11, 12}, {3, 4, 12, 13}, {8, 9, 12, 13}, {4, 5, 12, 13}, {9, 10, 12, 13}, {4, 5, 13, 14}, {9, 10, 13, 14}, {12, 13, 4, 5}, {12, 13, 9, 10}, {13, 14, 15, 16}, {14, 15, 16, 17}, {15, 16, 17, 18}, {16, 17, 18, 21}, {17, 18, 19, 26}, {18, 19, 20, 21}, {19, 20, 26, 27}, {21, 22, 26, 27}, {21, 22, 27, 28}, {22, 23, 27, 28}, {22, 23, 28, 29}, {23, 24, 28, 29}, {23, 24, 29, 30}, {24, 25, 29, 30}, {26, 27, 28, 31}, {27, 28, 31, 32}, {28, 29, 32, 33}, {29, 30, 33, 34}, {31, 32, 34, 35}, {32, 33, 36, 37}, {34, 35, 37, 38}, {38, 39, 40, 35}, {38, 39, 40, 35}};
    static final byte[] q = new byte[]{1, 5, 9, 13, 14, 15, 22, 23, 24, 2, 6, 10, 19, 20, 21, 31, 32, 33, 3, 7, 11, 16, 17, 18, 28, 29, 30, 4, 8, 12, 25, 26, 27, 34, 35, 36};
    static final int[] n = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 1, 1, 3, 1, 3, 3, 1, 3, 3, 3, 3, 5, 3, 5, 5, 3, 5, 5, 5, 5, 5, 5, 5, 5};
    byte DngNum;
    byte a;
    short Width;
    short Height;
    byte[][] DngnVec;
    short[] f;
    short[] d;
    short p;
    short I;
    short r;
    short b;
    short s;
    short v;
    boolean k;
    Vector m;
    Vector J;
    Vector t;
    Random e;
    byte[] Geomin;
    int[] u;
    boolean h;

    public Dungeon() {
        this.k = false;
        this.u = new int[2];
        this.h = false;
    }

    public Dungeon(byte dng, byte[] geovec) {
        this();
        this.DngNum = dng;
        this.i();
        this.Width = 35;
        this.Height = 35;
        this.f = new short[2];
        this.d = new short[6];
        this.Geomin = geovec;
        this.s = (short)this.Geomin[4];
        this.v = (short)this.Geomin[5];
    }

    public Dungeon(byte dng, byte[] geovec, int width, int height, byte[][] camp) {
        this();
        this.DngNum = dng;
        this.i();
        this.Width = (short)width;
        this.Height = (short)height;
        this.DngnVec = camp;
        this.f = new short[2];
        this.d = new short[6];
        this.Geomin = geovec;
        this.s = (short)this.Geomin[4];
        this.v = (short)this.Geomin[5];
        int NPCCount = 6;
        if (NPC.WardenPresent) {
            ++NPCCount;
        }

        for(int i = 0; i < NPCCount; ++i) {
            byte[] Xarr = this.DngnVec[NPC.NPCXPos[i]];
            byte Ybyte = NPC.NPCYPos[i];
            Xarr[Ybyte] = (byte)(Xarr[Ybyte] | 32);
        }

        this.k = true;
    }

    void i() {
        this.a = 1;
        if (this.DngNum >= 2 && this.DngNum <= 37) {
            this.a = q[this.DngNum - 2];
        }

    }

    void c() {
        int var1 = this.t.size();
        short var2 = (short)(this.DngNum << 8);
        Monster var3 = null;

        for(int i = 0; i < var1; ++i) {
            short[] var5 = (short[])this.t.elementAt(i);
            if (this.DngNum == 37 && i == var1 - 1) {
                var3 = Monster.a(this.e, this, 41);
            } else {
                var3 = Monster.a(this.e, this, -1);
            }

            this.a(var3, var5);
            var3.d();
        }

        System.gc();
    }

    void a(Monster var1, short[] var2) {
        var1.o = (byte)var2[4];
        var1.m = (byte)var2[5];
        byte[] var10000 = this.DngnVec[var1.o];
        byte var10001 = var1.m;
        var10000[var10001] = (byte)(var10000[var10001] | 2);
    }

    void c(int var1) {
        int var2 = this.t.size();
        boolean var3 = false;

        for(int i = 0; i < var1; ++i) {
            Monster var6;
            short var10;
            short var11;
            do {
                int var5 = Math.abs(this.e.nextInt() % var2);
                var6 = Monster.a(this);
                short[] var7 = (short[])this.t.elementAt(var5);
                short var8 = (short)(var7[2] - var7[0] + 1);
                short var9 = (short)(var7[3] - var7[1] + 1);
                var10 = (short)(var7[0] + Math.abs(this.e.nextInt() % var8));
                var11 = (short)(var7[1] + Math.abs(this.e.nextInt() % var9));
            } while(!this.d(var10, var11));

            var6.o = (byte)var10;
            var6.m = (byte)var11;
            this.DngnVec[var6.o][var6.m] = func.b((byte)2, this.DngnVec[var6.o][var6.m]);
            var6.d();
        }

    }

    void a(Character var1) {
        if (this.DngNum != 1) {
            Monster var2 = Monster.a(this);
            byte var3 = var1.l;
            byte var4 = var1.Ka;
            boolean var5 = true;

            for(int i = 0; i <= 4; ++i) {
                int var7 = var3;
                int var8 = var4;
                if (i < 2) {
                    var7 = var3 + (2 * i - 1);
                } else {
                    var8 = var4 + (2 * i - 5);
                }

                if (this.d(var7, var8)) {
                    var2.o = (byte)var7;
                    var2.m = (byte)var8;
                    var2.d();
                    this.DngnVec[var2.o][var2.m] = func.b((byte)2, this.DngnVec[var2.o][var2.m]);
                    break;
                }
            }

        }
    }

    static int a(int var0, int var1, boolean var2) {
        if (var2) {
            if (var0 < var1) {
                return -1;
            } else {
                return var0 > var1 ? 1 : 0;
            }
        } else if (var0 > var1) {
            return -1;
        } else {
            return var0 < var1 ? 1 : 0;
        }
    }

    int[] b(int var1) {
        int var2 = this.t.size();
        int[] var3 = new int[var2];
        int[] var4 = new int[var2];

        int var6;
        for(int i = 0; i < var2; ++i) {
            var3[i] = i;
            var6 = func.a(this.e, 1000);
            var4[i] = var6;
        }

        int var8;
        for(var6 = 1; var6 < var2; ++var6) {
            int var7 = var4[var6];
            var8 = var3[var6];

            int var9;
            for(var9 = var6 - 1; var9 >= 0 && a(var4[var9], var7, false) > 0; --var9) {
                var4[var9 + 1] = var4[var9];
                var3[var9 + 1] = var3[var9];
            }

            var4[var9 + 1] = var7;
            var3[var9 + 1] = var8;
        }

        int[] var10 = new int[var1];

        for(var8 = 0; var8 < var1; ++var8) {
            var10[var8] = var3[var8];
        }

        return var10;
    }

    void j() {
        boolean var1 = false;
        int[] var2 = this.b((int)5);
        int var3 = n[this.a - 1];
        boolean var4 = true;

        for(int i = 0; i < 5; ++i) {
            int var6 = var2[i];
            short[] var7 = (short[])this.t.elementAt(var6);
            boolean var8 = false;
            int var18;
            if (var4) {
                var18 = Item.a(this.e, var3);
                var4 = false;
            } else {
                var18 = Item.a(this.e, this.a, 2);
            }

            short var9 = (short)(var7[2] - var7[0] + 1);
            short var10 = (short)(var7[3] - var7[1] + 1);
            short var11 = (short)(var7[0] + Math.abs(this.e.nextInt() % var9));

            short var12;
            for(var12 = (short)(var7[1] + Math.abs(this.e.nextInt() % var10)); (this.DngnVec[var11][var12] & 8) != 0; var12 = (short)(var7[1] + Math.abs(this.e.nextInt() % var10))) {
                var11 = (short)(var7[0] + Math.abs(this.e.nextInt() % var9));
            }

            byte[] var13 = new byte[8];
            var13[0] = (byte)var11;
            var13[1] = (byte)var12;
            var13[2] = (byte)(var4 ? 1 : 0);
            byte var14 = (byte)(Math.abs(this.e.nextInt() % 3) << 6);
            var13[3] = (byte)(var14 | this.a);
            byte var15 = (byte)(var18 & 255);
            byte var16 = 0;
            if (var15 == 86) {
                var16 = (byte)(var18 >>> 8 & 255);
            }

            var13[4] = var15;
            var13[7] = var16;
            short var17 = Item.a();
            var15 = (byte)(var17 >>> 8 & 255);
            var16 = (byte)(var17 & 255);
            var13[5] = var15;
            var13[6] = var16;
            this.a(var13);
        }

    }

    void a(byte[] var1) {
        byte var2 = var1[0];
        byte var3 = var1[1];
        ESGame.S[this.DngNum - 1].put(func.b(var2, var3), var1);
        byte[] var10000 = this.DngnVec[var2];
        var10000[var3] = (byte)(var10000[var3] | 16);
    }

    void c(byte[] var1) {
        byte var2 = var1[0];
        byte var3 = var1[1];
        ESGame.au[this.DngNum - 1].addElement(var1);
        byte[] var10000 = this.DngnVec[var2];
        var10000[var3] = (byte)(var10000[var3] | 4);
    }

    public void MapGen() {
        long var1 = (long)(this.DngNum * 5000);
        this.DngnVec = new byte[this.Width][this.Height];
        short var3 = (short)this.Geomin[4];
        short var4 = (short)this.Geomin[5];
        this.t = new Vector();
        this.a(var1, var3, var4);
    }

    void e() {
        this.c();
        this.j();
    }

    void h() {
        boolean var1 = false;
        Hashtable var2 = ESGame.G[this.DngNum - 1];
        byte[] var10000;
        Enumeration var3;
        byte[] var4;
        if (var2 != null) {
            byte var10001;
            for(var3 = var2.elements(); var3.hasMoreElements(); var10000[var10001] = (byte)(var10000[var10001] | 2)) {
                var4 = (byte[])var3.nextElement();
                Monster var5 = Monster.a(var4);
                var10000 = this.DngnVec[var5.o];
                var10001 = var5.m;
            }

            System.gc();
        }

        var1 = false;
        var2 = ESGame.S[this.DngNum - 1];
        if (var2 != null) {
            for(var3 = var2.elements(); var3.hasMoreElements(); var10000[var4[1]] = (byte)(var10000[var4[1]] | 16)) {
                var4 = (byte[])var3.nextElement();
                var10000 = this.DngnVec[var4[0]];
            }
        }

        var1 = false;

        for(var3 = ESGame.au[this.DngNum - 1].elements(); var3.hasMoreElements(); var10000[var4[1]] = (byte)(var10000[var4[1]] | 4)) {
            var4 = (byte[])var3.nextElement();
            var10000 = this.DngnVec[var4[0]];
        }

        if (this.DngNum == 1 && NPC.WardenPresent) {
            byte var6 = NPC.NPCXPos[6];
            byte var7 = NPC.NPCYPos[6];
            var10000 = this.DngnVec[var6];
            var10000[var7] = (byte)(var10000[var7] | 32);
        }

    }

    boolean b(short var1) {
        switch (var1) {
            case 1:
            case 2:
            case 3:
            case 4:
                return true;
            default:
                return false;
        }
    }

    public void a(long var1, short var3, short var4) {
        this.s = var3;
        this.v = var4;
        boolean var5 = true;
        this.e = new Random(var1);

        for(int i = 0; i < 35; ++i) {
            for(int j = 0; j < 35; ++j) {
                this.DngnVec[i][j] = 1;
            }
        }

        this.m = new Vector();
        this.J = new Vector();
        this.p = 3;
        this.b = 3;
        this.I = 31;
        this.r = 31;
        int var16;
        if (this.b(var3)) {
            var16 = this.a(var3);
            if (var16 >= 0) {
                this.d(var16);
            }
        }

        if (this.b(var4)) {
            var16 = this.a(var4);
            if (var16 >= 0) {
                this.d(var16);
            }
        }

        boolean var17 = false;
        int var8 = 0;

        while(true) {
            short var10;
            short var11;
            short var14;
            short var15;
            do {
                short var12;
                short var13;
                do {
                    do {
                        do {
                            do {
                                do {
                                    if (var8 >= 15) {
                                        this.d();
                                        return;
                                    }

                                    this.d = this.f();
                                } while(!this.a(this.d));

                                ++var8;
                                int var9 = this.a(this.d[4], this.d[5]);
                                this.d(var9);
                            } while(var8 < 2);
                        } while(var17);

                        var10 = this.d[4];
                        var11 = this.d[5];
                        var12 = (short)(this.d[2] - this.d[0] + 1);
                        var13 = (short)(this.d[3] - this.d[1] + 1);
                    } while(var12 < 3);
                } while(var13 < 3);

                var14 = (short)(this.d[0] + var12 / 2);
                var15 = (short)(this.d[1] + var13 / 2);
            } while(var14 == var10 && var15 == var11);

            byte[] var10000 = this.DngnVec[var14];
            var10000[var15] = (byte)(var10000[var15] | 8);
            var17 = true;
        }
    }

    private short[] f() {
        byte var1 = 4;
        int var2 = 2 + Math.abs(this.e.nextInt()) % var1;
        int var3 = 2 + Math.abs(this.e.nextInt()) % var1;
        int var4 = this.I - this.b + 1 - (var2 - 1);
        int var5 = this.r - this.p + 1 - (var3 - 1);
        this.d[0] = (short)(this.b + Math.abs(this.e.nextInt()) % var4);
        this.d[1] = (short)(this.p + Math.abs(this.e.nextInt()) % var5);
        this.d[2] = (short)(this.d[0] + (var2 - 1));
        this.d[3] = (short)(this.d[1] + (var3 - 1));
        this.d[4] = (short)(this.d[0] + Math.abs(this.e.nextInt()) % var2);
        this.d[5] = (short)(this.d[1] + Math.abs(this.e.nextInt()) % var3);
        return this.d;
    }

    private boolean a(short[] var1) {
        int var2 = var1[0] - 1 >= 0 ? var1[0] - 1 : 0;
        int var3 = var1[2] + 1 <= 34 ? var1[2] + 1 : 34;
        int var4 = var1[1] - 1 >= 0 ? var1[1] - 1 : 0;
        int var5 = var1[3] + 1 <= 34 ? var1[3] + 1 : 34;

        for(int i = var2; i <= var3; ++i) {
            for(int j = var4; j <= var5; ++j) {
                if (this.DngnVec[i][j] == 0) {
                    return false;
                }
            }
        }

        this.a(var1[0], (short)(var1[2] - var1[0] + 1), var1[1], (short)(var1[3] - var1[1] + 1));
        if (var1[2] != var1[0] && var1[3] != var1[1]) {
            short[] var9 = new short[6];

            for(int i = 0; i < 6; ++i) {
                var9[i] = var1[i];
            }

            this.t.addElement(var9);
        }

        return true;
    }

    private void d() {
        Object var1 = null;
        int var2 = this.m.size();

        for(int i = 0; i < var2; ++i) {
            Integer var4 = (Integer)this.m.elementAt(i);
            int var5 = this.J.size();
            int var6 = Integer.MAX_VALUE;
            Integer var7 = null;
            int var8 = -1;

            for(int j = 0; j < var5; ++j) {
                Integer var10 = (Integer)this.J.elementAt(j);
                if (!var10.equals(var4)) {
                    int var11 = this.g(var4, var10);
                    if (var11 < var6) {
                        var6 = var11;
                        var7 = var10;
                    }
                } else {
                    var8 = j;
                }
            }

            if (var7 != null) {
                this.h(var4, var7);
            }

            if (var8 != -1) {
                this.J.removeElementAt(var8);
            }
        }

    }

    private int a(short var1) {
        int var2 = -1;
        if (var1 == 1) {
            this.a(17, 1, 0, 5);
            var2 = this.a((short)17, (short)4);
        } else if (var1 == 3) {
            this.a(17, 1, 30, 5);
            var2 = this.a((short)17, (short)30);
        } else if (var1 == 4) {
            this.a(0, 5, 17, 1);
            var2 = this.a((short)4, (short)17);
        } else if (var1 == 2) {
            this.a(30, 5, 17, 1);
            var2 = this.a((short)30, (short)17);
        }

        return var2;
    }

    private void h(int var1, int var2) {
        short[] var3 = this.a(var1);
        short var4 = var3[0];
        short var5 = var3[1];
        var3 = this.a(var2);
        short var6 = var3[0];
        short var7 = var3[1];
        int var8 = Math.abs(this.e.nextInt() % 2);
        if (var8 == 0) {
            if (var6 > var4) {
                this.a(var4, var6 - var4 + 1, var5, 1);
            } else {
                this.a(var6, var4 - var6 + 1, var5, 1);
            }

            if (var7 > var5) {
                this.a(var6, 1, var5, var7 - var5 + 1);
            } else {
                this.a(var6, 1, var7, var5 - var7 + 1);
            }
        } else {
            if (var7 > var5) {
                this.a(var4, 1, var5, var7 - var5 + 1);
            } else {
                this.a(var4, 1, var7, var5 - var7 + 1);
            }

            if (var6 > var4) {
                this.a(var4, var6 - var4 + 1, var7, 1);
            } else {
                this.a(var6, var4 - var6 + 1, var7, 1);
            }
        }

    }

    private void a(int var1, int var2, int var3, int var4) {
        for(int i = var1; i < var1 + var2; ++i) {
            for(int j = var3; j < var3 + var4; ++j) {
                if (this.DngnVec[i][j] != 8) {
                    this.DngnVec[i][j] = 0;
                }
            }
        }

    }

    private int a(short var1, short var2) {
        return var1 << 16 | var2;
    }

    private short[] a(int var1) {
        this.f[0] = (short)((-65536 & var1) >>> 16);
        this.f[1] = (short)('\uffff' & var1);
        return this.f;
    }

    private void d(int var1) {
        Integer var2 = Integer.valueOf(var1);
        this.m.addElement(var2);
        this.J.addElement(var2);
    }

    private int g(int var1, int var2) {
        short[] var3 = this.a(var1);
        short var4 = var3[0];
        short var5 = var3[1];
        short[] var6 = this.a(var2);
        short var7 = var6[0];
        short var8 = var6[1];
        return (var7 - var4) * (var7 - var4) + (var8 - var5) * (var8 - var5);
    }

    boolean d(int var1, int var2) {
        byte var3 = this.DngnVec[var1][var2];
        if (func.a((byte)1, var3)) {
            return false;
        } else if (func.a((byte)2, var3)) {
            return false;
        } else if (func.a((byte)8, var3)) {
            return false;
        } else {
            return !func.a((byte)32, var3);
        }
    }

    Monster c(int var1, int var2) {
        byte var3 = this.DngnVec[var1][var2];
        if (func.a((byte)1, var3)) {
            return null;
        } else if (!func.a((byte)2, var3)) {
            return null;
        } else {
            Enumeration var4 = ESGame.G[this.DngNum - 1].elements();

            Monster var6;
            do {
                if (!var4.hasMoreElements()) {
                    return null;
                }

                byte[] var5 = (byte[])var4.nextElement();
                var6 = Monster.a(var5);
            } while(var6.o != var1 || var6.m != var2);

            return var6;
        }
    }

    void b(byte[] var1) {
        byte var2 = var1[0];
        byte var3 = var1[1];
        byte var4 = this.DngnVec[var2][var3];
        if (!func.a((byte)1, var4)) {
            if (func.a((byte)16, var4)) {
                ESGame.S[this.DngNum - 1].remove(func.b(var2, var3));
                this.DngnVec[var2][var3] = func.c((byte)16, this.DngnVec[var2][var3]);
            }
        }
    }

    void d(byte[] var1) {
        byte var2 = var1[0];
        byte var3 = var1[1];
        byte var4 = this.DngnVec[var2][var3];
        if (!func.a((byte)1, var4)) {
            if (func.a((byte)4, var4)) {
                ESGame.au[this.DngNum - 1].removeElement(var1);
                if (this.f(var2, var3) == 0) {
                    this.DngnVec[var2][var3] = func.c((byte)4, this.DngnVec[var2][var3]);
                }

            }
        }
    }

    int f(int var1, int var2) {
        int var3 = 0;
        Enumeration var4 = ESGame.au[this.DngNum - 1].elements();

        while(var4.hasMoreElements()) {
            byte[] var5 = (byte[])var4.nextElement();
            if (var5[0] == var1 && var5[1] == var2) {
                ++var3;
            }
        }

        return var3;
    }

    byte[] e(int var1, int var2) {
        Enumeration var3 = ESGame.au[this.DngNum - 1].elements();

        byte[] var4;
        do {
            if (!var3.hasMoreElements()) {
                return null;
            }

            var4 = (byte[])var3.nextElement();
        } while(var4[0] != var1 || var4[1] != var2);

        return var4;
    }

    Vector b(int var1, int var2) {
        Vector var3 = new Vector(5);
        Enumeration var4 = ESGame.au[this.DngNum - 1].elements();

        while(var4.hasMoreElements()) {
            byte[] var5 = (byte[])var4.nextElement();
            if (var5[0] == var1 && var5[1] == var2) {
                var3.addElement(var5);
            }
        }

        return var3;
    }

    void b(int var1, int var2, int var3, byte[][] var4) {
        boolean var5;
        int var6;
        int var7;
        int var8;
        int var9;
        int var10;
        byte var11;
        if (var3 != 1 && var3 != 3) {
            if (var3 == 2 || var3 == 4) {
                var5 = false;
                if (var3 == 2) {
                    var11 = 1;
                } else {
                    var11 = -1;
                }

                var4[0][0] = this.i(var1, var2 - var11);
                var4[1][0] = 0;
                var4[2][0] = this.i(var1, var2 + var11);
                var6 = var1 + var11;

                for(var7 = 0; var7 < 5; ++var7) {
                    var4[var7][1] = this.i(var6, var2 + (var7 - 2) * var11);
                }

                var6 = var1 + 2 * var11;

                for(var8 = 0; var8 < 7; ++var8) {
                    var4[var8][2] = this.i(var6, var2 + (var8 - 3) * var11);
                }

                var6 = var1 + 3 * var11;

                for(var9 = 0; var9 < 9; ++var9) {
                    var4[var9][3] = this.i(var6, var2 + (var9 - 4) * var11);
                }

                var6 = var1 + 4 * var11;

                for(var10 = 0; var10 < 9; ++var10) {
                    var4[var10][4] = this.i(var6, var2 + (var10 - 4) * var11);
                }
            }
        } else {
            var5 = false;
            if (var3 == 1) {
                var11 = 1;
            } else {
                var11 = -1;
            }

            var4[0][0] = this.i(var1 - var11, var2);
            var4[1][0] = this.i(var1, var2);
            var4[2][0] = this.i(var1 + var11, var2);
            var6 = var2 - var11;

            for(var7 = 0; var7 < 5; ++var7) {
                var4[var7][1] = this.i(var1 + (var7 - 2) * var11, var6);
            }

            var6 = var2 - 2 * var11;

            for(var8 = 0; var8 < 7; ++var8) {
                var4[var8][2] = this.i(var1 + (var8 - 3) * var11, var6);
            }

            var6 = var2 - 3 * var11;

            for(var9 = 0; var9 < 9; ++var9) {
                var4[var9][3] = this.i(var1 + (var9 - 4) * var11, var6);
            }

            var6 = var2 - 4 * var11;

            for(var10 = 0; var10 < 9; ++var10) {
                var4[var10][4] = this.i(var1 + (var10 - 4) * var11, var6);
            }
        }

    }

    void c(int var1, int var2, int var3, byte[][] var4) {
        this.a(var1, var2, var3, 7, var4);
    }

    void a(int var1, int var2, int var3, byte[][] var4) {
        this.a(var1, var2, var3, 17, var4);
    }

    void a(int var1, int var2, int var3, int var4, byte[][] var5) {
        int var6 = var4 / 2;
        boolean var7;
        int var8;
        int var9;
        byte[] var10;
        Monster var11;
        int var12;
        int var13;
        boolean var14;
        boolean var15;
        byte var16;
        Enumeration var17;
        Enumeration var18;
        int var19;
        byte[] var20;
        Enumeration var21;
        int var22;
        byte[] var23;
        boolean var24;
        int var25;
        if (var3 != 1 && var3 != 3) {
            if (var3 == 2 || var3 == 4) {
                var7 = false;
                if (var3 == 2) {
                    var16 = 1;
                } else {
                    var16 = -1;
                }

                for(var8 = 0; var8 < var4; ++var8) {
                    for(var9 = 0; var9 < var4; ++var9) {
                        var5[var9][var8] = (byte)(this.i(var1 - (var8 - var6) * var16, var2 + (var9 - var6) * var16) & 1);
                        if ((var5[var9][var8] & 1) == 0) {
                            var5[var9][var8] = (byte)(this.i(var1 - (var8 - var6) * var16, var2 + (var9 - var6) * var16) & 8);
                        }
                    }
                }

                if (this.DngNum > 1) {
                    var17 = ESGame.G[this.DngNum - 1].elements();

                    while(var17.hasMoreElements()) {
                        var10 = (byte[])var17.nextElement();
                        var11 = Monster.a(var10);
                        var12 = var16 * (var11.m - var2) + var6;
                        var13 = var6 - var16 * (var11.o - var1);
                        if (var12 >= 0 && var12 < var4 && var13 >= 0 && var13 < var4 && var11.ia) {
                            var5[var12][var13] = (byte)(var5[var12][var13] | 2);
                        }
                    }

                    var18 = ESGame.S[this.DngNum - 1].elements();

                    while(var18.hasMoreElements()) {
                        var20 = (byte[])var18.nextElement();
                        var12 = var16 * (var20[1] - var2) + var6;
                        var13 = var6 - var16 * (var20[0] - var1);
                        var14 = true;
                        if (var12 >= 0 && var12 < var4 && var13 >= 0 && var13 < var4 && var14) {
                            var5[var12][var13] = (byte)(var5[var12][var13] | 4);
                        }
                    }

                    var21 = ESGame.au[this.DngNum - 1].elements();

                    while(var21.hasMoreElements()) {
                        var23 = (byte[])var21.nextElement();
                        var13 = var16 * (var23[1] - var2) + var6;
                        var25 = var6 - var16 * (var23[0] - var1);
                        var15 = (var23[6] & 1) != 0;
                        if (var13 >= 0 && var13 < var4 && var25 >= 0 && var25 < var4 && var15) {
                            var5[var13][var25] = (byte)(var5[var13][var25] | 4);
                        }
                    }
                } else {
                    for(var9 = 0; var9 < 7 && (var9 != 6 || NPC.WardenPresent); ++var9) {
                        if (NPC.b[var9]) {
                            var19 = var16 * (NPC.NPCYPos[var9] - var2) + var6;
                            var22 = var6 - var16 * (NPC.NPCXPos[var9] - var1);
                            var24 = true;
                            if (var19 >= 0 && var19 < var4 && var22 >= 0 && var22 < var4 && var24) {
                                var5[var19][var22] = (byte)(var5[var19][var22] | 4);
                            }
                        }
                    }
                }
            }
        } else {
            var7 = false;
            if (var3 == 1) {
                var16 = 1;
            } else {
                var16 = -1;
            }

            for(var8 = 0; var8 < var4; ++var8) {
                for(var9 = 0; var9 < var4; ++var9) {
                    var5[var9][var8] = (byte)(this.i(var1 + (var9 - var6) * var16, var2 + (var8 - var6) * var16) & 1);
                    if ((var5[var9][var8] & 1) == 0) {
                        var5[var9][var8] = (byte)(this.i(var1 + (var9 - var6) * var16, var2 + (var8 - var6) * var16) & 8);
                    }
                }
            }

            if (this.DngNum > 1) {
                var17 = ESGame.G[this.DngNum - 1].elements();

                while(var17.hasMoreElements()) {
                    var10 = (byte[])var17.nextElement();
                    var11 = Monster.a(var10);
                    var12 = var16 * (var11.o - var1) + var6;
                    var13 = var16 * (var11.m - var2) + var6;
                    if (var12 >= 0 && var12 < var4 && var13 >= 0 && var13 < var4 && var11.ia) {
                        var5[var12][var13] = (byte)(var5[var12][var13] | 2);
                    }
                }

                var18 = ESGame.S[this.DngNum - 1].elements();

                while(var18.hasMoreElements()) {
                    var20 = (byte[])var18.nextElement();
                    var12 = var16 * (var20[0] - var1) + var6;
                    var13 = var16 * (var20[1] - var2) + var6;
                    var14 = true;
                    if (var12 >= 0 && var12 < var4 && var13 >= 0 && var13 < var4 && var14) {
                        var5[var12][var13] = (byte)(var5[var12][var13] | 4);
                    }
                }

                var21 = ESGame.au[this.DngNum - 1].elements();

                while(var21.hasMoreElements()) {
                    var23 = (byte[])var21.nextElement();
                    var13 = var16 * (var23[0] - var1) + var6;
                    var25 = var16 * (var23[1] - var2) + var6;
                    var15 = (var23[6] & 1) != 0;
                    if (var13 >= 0 && var13 < var4 && var25 >= 0 && var25 < var4 && var15) {
                        var5[var13][var25] = (byte)(var5[var13][var25] | 4);
                    }
                }
            } else {
                for(var9 = 0; var9 < 7 && (var9 != 6 || NPC.WardenPresent); ++var9) {
                    if (NPC.b[var9]) {
                        var19 = var16 * (NPC.NPCXPos[var9] - var1) + var6;
                        var22 = var16 * (NPC.NPCYPos[var9] - var2) + var6;
                        var24 = true;
                        if (var19 >= 0 && var19 < var4 && var22 >= 0 && var22 < var4 && var24) {
                            var5[var19][var22] = (byte)(var5[var19][var22] | 4);
                        }
                    }
                }
            }
        }

    }

    int[] a(int var1, int var2, int var3, int var4, int var5) {
        int var6 = 0;
        int var7 = 0;
        boolean var8;
        byte var9;
        if (var3 != 1 && var3 != 3) {
            if (var3 == 2 || var3 == 4) {
                var8 = false;
                if (var3 == 2) {
                    var9 = 1;
                } else {
                    var9 = -1;
                }

                var6 = var9 * (var5 - var2) + 3;
                var7 = 3 - var9 * (var4 - var1);
            }
        } else {
            var8 = false;
            if (var3 == 1) {
                var9 = 1;
            } else {
                var9 = -1;
            }

            var6 = var9 * (var4 - var1) + 3;
            var7 = var9 * (var5 - var2) + 3;
        }

        this.u[0] = var6;
        this.u[1] = var7;
        return this.u;
    }

    byte i(int var1, int var2) {
        int var3 = var1;
        int var4 = var2;
        byte var5 = this.DngNum;
        Dungeon var6 = null;
        if (var1 < 0) {
            var5 = this.Geomin[3];
            if (var5 <= 0) {
                return 1;
            }

            var6 = ESGame.dungeons[var5 - 1];
            if (var5 != 1 && this.DngNum != 1) {
                var3 = (byte)(var6.Width - 1);
            } else {
                var3 = (byte)(var6.Width - 1);
                var4 = (byte)(var2 + (var6.Height - this.Height) / 2);
            }
        } else if (var1 >= this.Width) {
            var5 = this.Geomin[1];
            if (var5 <= 0) {
                return 1;
            }

            var6 = ESGame.dungeons[var5 - 1];
            if (var5 != 1 && this.DngNum != 1) {
                var3 = 0;
            } else {
                var3 = 0;
                var4 = (byte)(var2 + (var6.Height - this.Height) / 2);
            }
        } else if (var2 < 0) {
            var5 = this.Geomin[0];
            if (var5 <= 0) {
                return 1;
            }

            var6 = ESGame.dungeons[var5 - 1];
            if (var5 != 1 && this.DngNum != 1) {
                var4 = (byte)(var6.Height - 1);
            } else {
                var3 = (byte)(var1 + (var6.Width - this.Width) / 2);
                var4 = (byte)(var6.Height - 1);
            }
        } else if (var2 >= this.Height) {
            var5 = this.Geomin[2];
            if (var5 <= 0) {
                return 1;
            }

            var6 = ESGame.dungeons[var5 - 1];
            if (var5 != 1 && this.DngNum != 1) {
                var4 = 0;
            } else {
                var3 = (byte)(var1 + (var6.Width - this.Width) / 2);
                var4 = 0;
            }
        }

        if (var5 != this.DngNum) {
            if (var3 >= 0 && var3 < var6.Width) {
                if (var4 >= 0 && var4 < var6.Height) {
                    return var6.k ? var6.DngnVec[var3][var4] : 1;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        } else {
            return this.DngnVec[var1][var2];
        }
    }

    byte a(int var1, int var2, byte[][] var3) {
        return var2 < 4 ? var3[var1 + var2 + 1][var2] : var3[var1 + var2][var2];
    }

    String[] a() {
        return DngnNames[this.DngNum - 1];
    }

    static void LoadDungNames() throws Exception {
        DataInputStream data = func.LoadDatStream("/dungnamesin.dat");
        DngnNames = new String[37][2];

        for(int i = 0; i < 37; ++i) {
            for(int j = 0; j < 2; ++j) {
                DngnNames[i][j] = data.readUTF();
            }
        }

    }

    void a(int var1, int var2) {
        int var3 = Math.max(var1 - 4, 0);
        int var4 = Math.min(var1 + 4, this.Width - 1);
        int var5 = Math.max(var2 - 4, 0);
        int var6 = Math.min(var2 + 4, this.Height - 1);

        for(int i = var3; i <= var4; ++i) {
            for(int j = var5; j <= var6; ++j) {
                byte var9 = this.DngnVec[i][j];
                if (!func.a((byte)1, var9)) {
                    this.DngnVec[i][j] = func.c((byte)2, var9);
                }
            }
        }

        Hashtable var13 = ESGame.G[this.DngNum - 1];
        if (var13 != null) {
            Enumeration var14 = var13.elements();

            while(var14.hasMoreElements()) {
                byte[] var10 = (byte[])var14.nextElement();
                byte var11 = var10[4];
                byte var12 = var10[5];
                if (var11 >= var3 && var11 <= var4 && var12 >= var5 && var12 <= var6) {
                    byte[] var10000 = this.DngnVec[var11];
                    var10000[var12] = (byte)(var10000[var12] | 2);
                }
            }
        }

    }
}
