//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Random;

public class Monster { // d
    private static int MonCount;
    private static String[] MonNames;
    private static byte[][] MonAttributes;
    short a;
    byte l;
    byte g;
    byte o;
    byte m;
    boolean ia;
    byte n;
    byte[] c;
    byte b;
    byte f;
    long k;
    static Monster Mon = new Monster();
    static short J;

    static short b() {
        ++J;
        return J;
    }

    byte[] f() {
        byte[] btarr = new byte[28];
        btarr[0] = (byte)(this.a >>> 8 & 255);
        btarr[1] = (byte)(this.a & 255);
        btarr[2] = this.l;
        btarr[3] = this.g;
        btarr[4] = this.o;
        btarr[5] = this.m;
        btarr[6] = (byte)(this.ia ? 1 : 0);
        btarr[7] = this.n;
        btarr[8] = this.b;
        btarr[9] = this.f;
        btarr[10] = (byte)((int)(this.k >>> 56 & 255L));
        btarr[11] = (byte)((int)(this.k >>> 48 & 255L));
        btarr[12] = (byte)((int)(this.k >>> 40 & 255L));
        btarr[13] = (byte)((int)(this.k >>> 32 & 255L));
        btarr[14] = (byte)((int)(this.k >>> 24 & 255L));
        btarr[15] = (byte)((int)(this.k >>> 16 & 255L));
        btarr[16] = (byte)((int)(this.k >>> 8 & 255L));
        btarr[17] = (byte)((int)(this.k & 255L));

        for(int i = 0; i < 10; ++i) {
            btarr[18 + i] = this.c[i];
        }

        return btarr;
    }

    public Monster() {
        this.c = new byte[10];
        this.ia = false;
    }

    public Monster(int var1, int var2, int var3) {
        this.a = (short)var1;
        this.l = (byte)var2;
        this.g = MonAttributes[this.l - 1][14];
        this.c = new byte[10];
        this.ia = false;
        this.n = (byte)var3;
        this.f = 0;
    }

    static Monster a(byte[] var0) {
        short var1 = (short)(var0[0] & 255);
        short var2 = (short)(var0[1] & 255);
        Mon.a = (short)(var1 << 8 | var2);
        Mon.l = var0[2];
        Mon.g = var0[3];
        Mon.o = var0[4];
        Mon.m = var0[5];
        Mon.ia = var0[6] != 0;
        Mon.n = var0[7];
        Mon.b = var0[8];
        Mon.f = var0[9];
        Mon.k = func.a(var0, 10);

        for(int i = 0; i < 10; ++i) {
            Mon.c[i] = var0[18 + i];
        }

        return Mon;
    }

    static Monster a(Monster var0, byte[] var1) {
        short var2 = (short)(var1[0] & 255);
        short var3 = (short)(var1[1] & 255);
        var0.a = (short)(var2 << 8 | var3);
        var0.l = var1[2];
        var0.g = var1[3];
        var0.o = var1[4];
        var0.m = var1[5];
        var0.ia = var1[6] != 0;
        var0.n = var1[7];
        var0.b = var1[8];
        var0.f = var1[9];
        var0.k = func.a(var1, 10);

        for(int i = 0; i < 10; ++i) {
            var0.c[i] = var1[18 + i];
        }

        return var0;
    }

    void d() {
        ESGame.G[this.n - 1].put(String.valueOf(this.a), this.f());
    }

    String a() {
        return MonNames[this.l - 1];
    }

    int c(int var1) {
        return MonAttributes[this.l - 1][var1] & 255;
    }

    boolean e() {
        return this.l >= 6 && this.l <= 8;
    }

    void b(int var1) {
        int var2 = this.g & 255;
        if (var1 > var2) {
            var1 = var2;
        }

        var2 -= var1;
        this.g = (byte)var2;
    }

    boolean a(int var1) {
        byte var2 = 1;
        byte var3 = this.o;
        byte var4 = this.m;
        Dungeon var5 = ESGame.dungeons[this.n - 1];
        switch (var1) {
            case 1:
                var2 = -1;
            case 3:
                var3 = this.o;
                var4 = (byte)(this.m + var2);
                break;
            case 4:
                var2 = -1;
            case 2:
                var4 = this.m;
                var3 = (byte)(this.o + var2);
                break;
            default:
                return false;
        }

        if (var3 >= 0 && var4 >= 0) {
            if (var3 < var5.Width && var4 < var5.Height) {
                if (this.a(var3, var4)) {
                    return false;
                } else if (!var5.d(var3, var4)) {
                    return false;
                } else {
                    var5.DngnVec[this.o][this.m] = func.c((byte)2, var5.DngnVec[this.o][this.m]);
                    var5.DngnVec[var3][var4] = func.b((byte)2, var5.DngnVec[var3][var4]);
                    this.o = var3;
                    this.m = var4;
                    return true;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    void a(Character var1) {
        if (this.d(var1)) {
            if (this.b == 0) {
                this.e(var1);
                ++this.b;
            } else if (this.b >= 4) {
                this.b = 0;
            } else {
                ++this.b;
            }
        }

    }

    private void e(Character var1) {
        int var6 = Math.abs(var1.l - this.o);
        int var7 = Math.abs(var1.Ka - this.m);
        byte var2;
        if (this.o < var1.l) {
            var2 = 2;
        } else if (this.o > var1.l) {
            var2 = 4;
        } else {
            var2 = -1;
        }

        byte var3;
        if (this.m < var1.Ka) {
            var3 = 3;
        } else if (this.m > var1.Ka) {
            var3 = 1;
        } else {
            var3 = -1;
        }

        byte var4;
        byte var5;
        if (var6 > var7) {
            var4 = var2;
            var5 = var3;
        } else if (var6 < var7) {
            var4 = var3;
            var5 = var2;
        } else {
            int var8 = ESGame.h(2);
            if (var8 == 0) {
                var4 = var2;
                var5 = var3;
            } else {
                var4 = var3;
                var5 = var2;
            }
        }

        if (!this.a(var4)) {
            if (!this.a(var5)) {
                ;
            }
        }
    }

    private boolean a(int var1, int var2) {
        Dungeon var3 = ESGame.dungeons[this.n - 1];
        if (var3.s != 1 && var3.v != 1) {
            if (var3.s != 3 && var3.v != 3) {
                if (var3.s != 4 && var3.v != 4) {
                    if ((var3.s == 2 || var3.v == 2) && var1 == 30 && var2 == 17) {
                        return true;
                    }
                } else if (var1 == 5 && var2 == 17) {
                    return true;
                }
            } else if (var1 == 17 && var2 == 30) {
                return true;
            }
        } else if (var1 == 17 && var2 == 5) {
            return true;
        }

        return false;
    }

    boolean d(Character var1) {
        return this.c(var1) <= 3;
    }

    int c(Character var1) {
        int var2 = Math.abs(var1.l - this.o);
        int var3 = Math.abs(var1.Ka - this.m);
        return var2 + var3;
    }

    boolean b(Character var1) {
        if (this.c(var1) == 1) {
            return true;
        } else {
            this.f = 0;
            return false;
        }
    }

    void a(Character var1, long var2) {
        this.f = 2;
        this.k = var2;
        byte var4 = MonAttributes[this.l - 1][4];
        int var5 = var1.f(true);
        int var6 = var5 - var4;
        var6 = Math.min(var6, MonAttributes[this.l - 1][2]);
        int var7 = MonAttributes[this.l - 1][3] - var6 * 5;
        int var8 = var1.I() + var6 * 5;
        var7 = Math.min(Math.max(var7, 10), 95);
        var8 = Math.min(Math.max(var8, 10), 95);
        int var9 = func.a(100);
        int var10 = func.a(100);
        boolean var11 = var9 <= var7;
        boolean var12 = var10 <= var8;
        boolean var13 = false;
        byte var21;
        if (var11 && !var12) {
            var21 = 3;
        } else if (var11 && var12) {
            if (var9 >= var10) {
                var21 = 2;
            } else {
                var21 = 1;
            }
        } else if (!var11 && !var12) {
            if (var9 >= var10) {
                var21 = 2;
            } else {
                var21 = 1;
            }
        } else {
            var21 = 0;
        }

        if (var21 == 0) {
            this.f = 1;
        } else {
            byte var14 = MonAttributes[this.l - 1][5];
            int var15 = var1.v();
            if (var21 == 1) {
                var15 = 2 * var15;
            }

            int var16 = var14 - var15;
            var16 = Math.max(var16, 4);
            int var17 = var16 * var1.CharCritAtt[3] / 100;
            short[] var10000 = var1.CharCritAtt;
            var10000[2] = (short)(var10000[2] - var17);
            var1.CharCritAtt[2] = (short)Math.max(var1.CharCritAtt[2], 0);
            if (var12) {
                var1.a(var1.y(), 1);
            }

            if (var21 < 3) {
                this.f = 1;
            } else {
                if (func.a(100) <= 30) {
                    byte var18 = MonAttributes[this.l - 1][11];
                    if (var18 > 0) {
                        int var19 = var18 - 1;
                        var1.A = (byte)(var1.A | 1 << var19);
                        if (var18 != 1) {
                            if (var18 == 2) {
                                Dungeon var20 = ESGame.dungeons[this.n - 1];
                                var20.c(3);
                            } else if (var18 != 3) {
                                if (var18 == 4) {
                                    var1.ah = 30000;
                                } else if (var18 == 5) {
                                    var1.F = 30000;
                                } else if (var18 != 6 && var18 != 7 && var18 == 8) {
                                }
                            }
                        }
                    }
                }

                this.f = 1;
            }
        }
    }

    static void LoadMonsters() throws Exception {
        DataInputStream data = func.LoadDatStream("/monstersin.dat");
        J = 0;
        MonCount = data.readInt();
        MonNames = new String[MonCount];
        MonAttributes = new byte[MonCount][17];

        for(int i = 0; i < MonCount; ++i) {
            MonNames[i] = data.readUTF();
        }

        for(int i = 0; i < MonCount; ++i) {
            for(int j = 0; j < 17; ++j) {
                MonAttributes[i][j] = data.readByte();
            }
        }

    }

    static Monster a(DataInputStream stream) throws Exception {
        Monster var1 = new Monster();
        var1.a = stream.readShort();
        var1.l = stream.readByte();
        var1.g = stream.readByte();
        var1.o = stream.readByte();
        var1.m = stream.readByte();
        var1.ia = stream.readBoolean();
        var1.n = stream.readByte();
        var1.b = stream.readByte();
        var1.f = stream.readByte();
        var1.k = stream.readLong();

        for(int i = 0; i < 10; ++i) {
            var1.c[i] = stream.readByte();
        }

        return var1;
    }

    void a(DataOutputStream var1) throws Exception {
        var1.writeShort(this.a);
        var1.writeByte(this.l);
        var1.writeByte(this.g);
        var1.writeByte(this.o);
        var1.writeByte(this.m);
        var1.writeBoolean(this.ia);
        var1.writeByte(this.n);
        var1.writeByte(this.b);
        var1.writeByte(this.f);
        var1.writeLong(this.k);

        for(int i = 0; i < 10; ++i) {
            var1.writeByte(this.c[i]);
        }

    }

    void c() {
    }

    void a(boolean var1) {
        byte var2 = MonAttributes[this.l - 1][15];
        if (var1) {
            var2 = 100;
        }

        byte var3 = MonAttributes[this.l - 1][16];
        int var4 = func.a(100);
        boolean var5 = var4 <= var2;
        if (var5 || var1) {
            Dungeon var6 = ESGame.dungeons[this.n - 1];
            byte var7 = var6.a;
            int var8 = Item.a(ESGame.P, var7, var3);
            byte var9 = (byte)(var8 & 255);
            byte var10 = 0;
            if (var9 == 86) {
                var10 = (byte)(var8 >>> 8 & 255);
            }

            byte[] var11 = new byte[]{this.o, this.m, var9, 0, 0, var10, 0};
            short var12 = Item.a();
            var9 = (byte)(var12 >>> 8 & 255);
            var10 = (byte)(var12 & 255);
            var11[3] = var9;
            var11[4] = var10;
            var11[6] = 1;
            if (var1) {
                var11[6] = (byte)(var11[6] | 4);
            }

            var6.c(var11);
        }

    }

    static Monster a(Dungeon var0) {
        return a(ESGame.P, var0, -1);
    }

    static Monster a(Random var0, Dungeon var1, int var2) {
        short var3 = b();
        int var4 = var2;
        if (var2 < 0) {
            int var5 = var1.a - 1;
            if (var5 < 0) {
                var5 = 0;
            }

            if (var5 > 36) {
                var5 = 36;
            }

            int var6 = ESGame.a(var0, 10);
            boolean var7 = false;
            byte var9;
            if (var6 <= 4) {
                var9 = 0;
            } else if (var6 <= 7) {
                var9 = 1;
            } else if (var6 <= 9) {
                var9 = 2;
            } else {
                var9 = 3;
            }

            var4 = Dungeon.l[var5][var9];
        }

        Monster var8 = new Monster(var3, var4, var1.DngNum);
        return var8;
    }
}
