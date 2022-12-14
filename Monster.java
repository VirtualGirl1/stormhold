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
    byte MonNum;
    byte Health;
    byte XPos;
    byte YPos;
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
        btarr[2] = this.MonNum;
        btarr[3] = this.Health;
        btarr[4] = this.XPos;
        btarr[5] = this.YPos;
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

    public Monster(int var1, int monnum, int var3) {
        this.a = (short)var1;
        this.MonNum = (byte)monnum;
        this.Health = MonAttributes[this.MonNum - 1][14];
        this.c = new byte[10];
        this.ia = false;
        this.n = (byte)var3;
        this.f = 0;
    }

    static Monster a(byte[] btarr) {
        short var1 = (short)(btarr[0] & 255);
        short var2 = (short)(btarr[1] & 255);
        Mon.a = (short)(var1 << 8 | var2);
        Mon.MonNum = btarr[2];
        Mon.Health = btarr[3];
        Mon.XPos = btarr[4];
        Mon.YPos = btarr[5];
        Mon.ia = btarr[6] != 0;
        Mon.n = btarr[7];
        Mon.b = btarr[8];
        Mon.f = btarr[9];
        Mon.k = func.a(btarr, 10);

        for(int i = 0; i < 10; ++i) {
            Mon.c[i] = btarr[18 + i];
        }

        return Mon;
    }

    static Monster a(Monster mon, byte[] btarr) {
        short var2 = (short)(btarr[0] & 255);
        short var3 = (short)(btarr[1] & 255);
        mon.a = (short)(var2 << 8 | var3);
        mon.MonNum = btarr[2];
        mon.Health = btarr[3];
        mon.XPos = btarr[4];
        mon.YPos = btarr[5];
        mon.ia = btarr[6] != 0;
        mon.n = btarr[7];
        mon.b = btarr[8];
        mon.f = btarr[9];
        mon.k = func.a(btarr, 10);

        for(int i = 0; i < 10; ++i) {
            mon.c[i] = btarr[18 + i];
        }

        return mon;
    }

    void d() {
        ESGame.MonsterTables[this.n - 1].put(String.valueOf(this.a), this.f());
    }

    String GetMonName() {
        return MonNames[this.MonNum - 1];
    }

    int GetMonAtt(int AttIndx) {
        return MonAttributes[this.MonNum - 1][AttIndx] & 255;
    }

    boolean e() {
        return this.MonNum >= 6 && this.MonNum <= 8;
    }

    void b(int var1) {
        int var2 = this.Health & 255;
        if (var1 > var2) {
            var1 = var2;
        }

        var2 -= var1;
        this.Health = (byte)var2;
    }

    boolean a(int var1) {
        byte var2 = 1;
        byte var3 = this.XPos;
        byte var4 = this.YPos;
        Dungeon dung = ESGame.dungeons[this.n - 1];
        switch (var1) {
            case 1:
                var2 = -1;
            case 3:
                var3 = this.XPos;
                var4 = (byte)(this.YPos + var2);
                break;
            case 4:
                var2 = -1;
            case 2:
                var4 = this.YPos;
                var3 = (byte)(this.XPos + var2);
                break;
            default:
                return false;
        }

        if (var3 >= 0 && var4 >= 0) {
            if (var3 < dung.Width && var4 < dung.Height) {
                if (this.a(var3, var4)) {
                    return false;
                } else if (!dung.d(var3, var4)) {
                    return false;
                } else {
                    dung.DngnVec[this.XPos][this.YPos] = func.c((byte)2, dung.DngnVec[this.XPos][this.YPos]);
                    dung.DngnVec[var3][var4] = func.b((byte)2, dung.DngnVec[var3][var4]);
                    this.XPos = var3;
                    this.YPos = var4;
                    return true;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    void a(Character player) {
        if (this.d(player)) {
            if (this.b == 0) {
                this.e(player);
                ++this.b;
            } else if (this.b >= 4) {
                this.b = 0;
            } else {
                ++this.b;
            }
        }

    }

    private void e(Character player) {
        int var6 = Math.abs(player.XPos - this.XPos);
        int var7 = Math.abs(player.YPos - this.YPos);
        byte var2;
        if (this.XPos < player.XPos) {
            var2 = 2;
        } else if (this.XPos > player.XPos) {
            var2 = 4;
        } else {
            var2 = -1;
        }

        byte var3;
        if (this.YPos < player.YPos) {
            var3 = 3;
        } else if (this.YPos > player.YPos) {
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
        Dungeon dung = ESGame.dungeons[this.n - 1];
        if (dung.s != 1 && dung.v != 1) {
            if (dung.s != 3 && dung.v != 3) {
                if (dung.s != 4 && dung.v != 4) {
                    if ((dung.s == 2 || dung.v == 2) && var1 == 30 && var2 == 17) {
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

    boolean d(Character player) {
        return this.c(player) <= 3;
    }

    int c(Character player) {
        int var2 = Math.abs(player.XPos - this.XPos);
        int var3 = Math.abs(player.YPos - this.YPos);
        return var2 + var3;
    }

    boolean b(Character player) {
        if (this.c(player) == 1) {
            return true;
        } else {
            this.f = 0;
            return false;
        }
    }

    void a(Character player, long var2) {
        this.f = 2;
        this.k = var2;
        byte var4 = MonAttributes[this.MonNum - 1][4];
        int var5 = player.f(true);
        int var6 = var5 - var4;
        var6 = Math.min(var6, MonAttributes[this.MonNum - 1][2]);
        int var7 = MonAttributes[this.MonNum - 1][3] - var6 * 5;
        int var8 = player.I() + var6 * 5;
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
            byte var14 = MonAttributes[this.MonNum - 1][5];
            int var15 = player.v();
            if (var21 == 1) {
                var15 = 2 * var15;
            }

            int var16 = var14 - var15;
            var16 = Math.max(var16, 4);
            int var17 = var16 * player.CharCritAtt[3] / 100;
            short[] var10000 = player.CharCritAtt;
            var10000[2] = (short)(var10000[2] - var17);
            player.CharCritAtt[2] = (short)Math.max(player.CharCritAtt[2], 0);
            if (var12) {
                player.a(player.y(), 1);
            }

            if (var21 < 3) {
                this.f = 1;
            } else {
                if (func.a(100) <= 30) {
                    byte var18 = MonAttributes[this.MonNum - 1][11];
                    if (var18 > 0) {
                        int var19 = var18 - 1;
                        player.Ailments = (byte)(player.Ailments | 1 << var19);
                        if (var18 != 1) {
                            if (var18 == 2) {
                                Dungeon var20 = ESGame.dungeons[this.n - 1];
                                var20.c(3);
                            } else if (var18 != 3) {
                                if (var18 == 4) {
                                    player.ah = 30000;
                                } else if (var18 == 5) {
                                    player.F = 30000;
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

    static Monster a(DataInputStream data) throws Exception {
        Monster mon = new Monster();
        mon.a = data.readShort();
        mon.MonNum = data.readByte();
        mon.Health = data.readByte();
        mon.XPos = data.readByte();
        mon.YPos = data.readByte();
        mon.ia = data.readBoolean();
        mon.n = data.readByte();
        mon.b = data.readByte();
        mon.f = data.readByte();
        mon.k = data.readLong();

        for(int i = 0; i < 10; ++i) {
            mon.c[i] = data.readByte();
        }

        return mon;
    }

    void a(DataOutputStream data) throws Exception {
        data.writeShort(this.a);
        data.writeByte(this.MonNum);
        data.writeByte(this.Health);
        data.writeByte(this.XPos);
        data.writeByte(this.YPos);
        data.writeBoolean(this.ia);
        data.writeByte(this.n);
        data.writeByte(this.b);
        data.writeByte(this.f);
        data.writeLong(this.k);

        for(int i = 0; i < 10; ++i) {
            data.writeByte(this.c[i]);
        }

    }

    void c() {
    }

    void a(boolean var1) {
        byte var2 = MonAttributes[this.MonNum - 1][15];
        if (var1) {
            var2 = 100;
        }

        byte var3 = MonAttributes[this.MonNum - 1][16];
        int var4 = func.a(100);
        boolean var5 = var4 <= var2;
        if (var5 || var1) {
            Dungeon dung = ESGame.dungeons[this.n - 1];
            byte var7 = dung.a;
            int var8 = Item.GetRandItem(ESGame.P, var7, var3);
            byte var9 = (byte)(var8 & 255);
            byte var10 = 0;
            if (var9 == 86) {
                var10 = (byte)(var8 >>> 8 & 255);
            }

            byte[] var11 = new byte[]{this.XPos, this.YPos, var9, 0, 0, var10, 0};
            short var12 = Item.a();
            var9 = (byte)(var12 >>> 8 & 255);
            var10 = (byte)(var12 & 255);
            var11[3] = var9;
            var11[4] = var10;
            var11[6] = 1;
            if (var1) {
                var11[6] = (byte)(var11[6] | 4);
            }

            dung.c(var11);
        }

    }

    static Monster a(Dungeon dung) {
        return a(ESGame.P, dung, -1);
    }

    static Monster a(Random rand, Dungeon dung, int var2) {
        short var3 = b();
        int var4 = var2;
        if (var2 < 0) {
            int var5 = dung.a - 1;
            if (var5 < 0) {
                var5 = 0;
            }

            if (var5 > 36) {
                var5 = 36;
            }

            int var6 = ESGame.a(rand, 10);
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

        Monster mon = new Monster(var3, var4, dung.DngNum);
        return mon;
    }
}
