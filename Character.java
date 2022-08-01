//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class Character {
    static boolean g = false;
    private static boolean D;
    static Vector ad = G();
    private static final Integer aj = Integer.valueOf(0);
    private static final Integer am = Integer.valueOf(1);
    private static final Integer o = Integer.valueOf(-1);
    static boolean S = false;
    static short B;
    static short al;
    static String[] Classes;
    static String[] Races;
    static String[] Skills;
    static short[][] ClassPreset;
    static String[] CritAtt;
    static String[] Attributes;
    static short[] c;
    static int[][] StartingGear = new int[][]{{1, 27}, {7, 27}, {7, 22}, {17, 27}, {12, 22}, {17, 27}, {12, 22}};
    private static final String[] Ailments = new String[]{"Stone Blood", "Delusions", "Blind", "Vampirism", "Mana Burn", "Grievous Harm", "Terrified", "Haunted"};
    public static int ag = -1;
    ESGame Game;
    public static String UsrID = null;
    String CharName;
    short CharClass;
    short CharRace;
    short[] CharCritAtt;
    byte N;
    int n;
    short[] AttLvl;
    short V;
    short[] aq;
    short[][] CharSkills;
    byte InventoryCount;
    byte[] Inventory;
    int[] P;
    byte[] T;
    int x;
    byte b;
    short GiftPoints;
    short Y;
    short m;
    byte A;
    short ah;
    short F;
    short ap;
    boolean f;
    byte CurDung;
    byte l;
    byte Ka;
    byte DirFacing;
    byte C;
    byte ao;
    byte an;
    byte Z;
    byte[] G;
    short t;
    short aa;
    boolean s = false;
    boolean L = false;
    boolean I = false;
    byte XPos;
    byte YPos;
    byte e;
    byte ab;
    boolean i;
    boolean Q;
    boolean u;
    boolean O;
    byte[][] ae;
    byte d;
    byte a;

    int b(boolean var1) {
        return var1 ? 400 : 200;
    }

    public Character(ESGame game) {
        g = false;
        LoadCharData();
        this.CharName = null;
        this.CharCritAtt = new short[10];
        this.AttLvl = new short[16];
        this.aq = new short[2];
        this.CharSkills = new short[14][3];
        this.InventoryCount = 0;
        this.Inventory = new byte[24];
        this.P = new int[24];
        this.T = new byte[7];
        this.G = new byte[25];
        this.ae = new byte[9][5];
        this.Game = game;
        this.Q = false;
    }

    void a(short[] var1) {
        var1[2] = var1[3];
        var1[4] = var1[5];
        var1[6] = var1[7];
        var1[8] = 0;
    }

    void c(int clss) {
        this.CharClass = (short)clss;
        this.CharRace = ClassPreset[this.CharClass][1];
        byte var2 = 8;

        int var4;
        for(int i = 0; i < var2; ++i) {
            var4 = 2 * i;
            this.AttLvl[var4] = ClassPreset[this.CharClass][2 + i];
            this.AttLvl[var4 + 1] = 0;
        }

        this.V = ClassPreset[this.CharClass][10];
        this.aq[0] = ClassPreset[this.CharClass][11];
        this.aq[1] = ClassPreset[this.CharClass][12];
        this.CharCritAtt[0] = 1;
        this.CharCritAtt[1] = 0;
        this.g();
        this.CharCritAtt[2] = this.CharCritAtt[3];
        this.CharCritAtt[4] = this.CharCritAtt[5];
        this.CharCritAtt[6] = this.CharCritAtt[7];
        this.CharCritAtt[8] = 0;
        this.CharCritAtt[9] = 0;
        this.N = 0;
        this.n = 0;
        var4 = 13;

        for(int i = 0; i < 14; ++i) {
            this.CharSkills[i][0] = ClassPreset[this.CharClass][var4++];
            this.CharSkills[i][1] = ClassPreset[this.CharClass][var4++];
            this.CharSkills[i][2] = 0;
        }

        for(int i = 0; i < 24; ++i) {
            this.Inventory[i] = 0;
            this.P[i] = 0;
        }

        for(int i = 0; i < 7; ++i) {
            this.T[i] = 0;
        }

        this.x = this.A();
    }

    void g() {
        this.CharCritAtt[3] = (short)((this.AttLvl[0] + this.AttLvl[10]) / 2);
        this.CharCritAtt[5] = (short)(this.V * this.AttLvl[2] / 4);
        this.CharCritAtt[7] = (short)(this.AttLvl[0] + this.AttLvl[4] + this.AttLvl[6] + this.AttLvl[10]);
    }

    private int A() {
        int var1 = 0;
        int var2 = 13;
        boolean var3 = true;
        boolean var4 = true;

        for(int i = 0; i < 14; ++i) {
            short var6 = ClassPreset[this.CharClass][var2++];
            short var7 = ClassPreset[this.CharClass][var2++];
            byte var8;
            switch (i) {
                case 1:
                    var8 = 0;
                    break;
                case 2:
                case 5:
                case 7:
                case 8:
                case 9:
                default:
                    var8 = -1;
                    break;
                case 3:
                    var8 = 5;
                    break;
                case 4:
                    var8 = 10;
                    break;
                case 6:
                    var8 = 15;
                    break;
                case 10:
                    var8 = 20;
            }

            if (var8 != -1 && var6 > 0) {
                var1 |= 1 << var8;
                if (var4) {
                    this.b = (byte)(var8 + 1);
                    var4 = false;
                }
            }
        }

        return var1;
    }

    public void d(int var1) {
        this.c(var1, false);
    }

    public void c(int var1, boolean var2) {
        if (!var2) {
            this.GiftPoints = 0;
            this.Y = 0;
            this.m = 0;
        }

        this.A = 0;
        this.ah = 0;
        this.F = 0;
        this.ap = 0;
        this.f = false;
        this.c(var2);
        this.w();
        if (!var2) {
            this.C = 0;
            this.ao = 0;
            this.an = 0;
            this.Z = 0;
        }

        for(int i = 0; i < 25; ++i) {
            this.G[i] = 0;
        }

        this.t = 0;
        this.aa = 0;
        this.s = false;
        this.L = false;
        this.I = false;
        if (!var2) {
            this.C();
        }

    }

    private void c(boolean var1) {
        if (!var1) {
            this.CurDung = this.ab = 1;
            this.l = this.XPos = 9;
            this.Ka = this.YPos = 10;
            this.DirFacing = this.e = 1;
        } else {
            this.CurDung = this.ab = 1;
            this.l = this.XPos = 12;
            this.Ka = this.YPos = 14;
            this.DirFacing = this.e = 1;
        }

    }

    String m() {
        StringBuffer var1 = new StringBuffer(300);
        String var2 = " ";
        String var3 = ": ";
        var1.append(Races[this.CharRace]);
        var1.append(var2);
        var1.append(Classes[this.CharClass]);
        var1.append('\n');
        var1.append(CritAtt[0]);
        var1.append(var3);
        var1.append(this.CharCritAtt[0]);
        var1.append('\n');
        var1.append(CritAtt[2]);
        var1.append(var3);
        var1.append(this.GetCritAtt(2));
        var1.append('\n');
        var1.append(CritAtt[4]);
        var1.append(var3);
        var1.append(this.GetCritAtt(4));
        var1.append('\n');
        var1.append(CritAtt[6]);
        var1.append(var3);
        var1.append(this.GetCritAtt(6));
        var1.append('\n');

        int var5;
        for(int i = 0; i < 8; ++i) {
            var5 = 2 * i;
            var1.append(Attributes[var5]);
            var1.append(var3);
            var1.append(this.AttLvl[var5]);
            var1.append('\n');
        }

        for(var5 = 0; var5 < 14; ++var5) {
            if (this.CharSkills[var5][0] > 0) {
                var1.append(Skills[var5]);
                var1.append(var3);
                var1.append(this.CharSkills[var5][0]);
                var1.append('\n');
            }
        }

        String var6 = var1.toString();
        return var6;
    }

    static void LoadCharData() {
        if (!S) {
            try {
                LoadCharData("/charin.dat");
                S = true;
            } catch (Exception err) {
                System.out.println("Error: could not load character data");
                System.out.println("Exception: " + err);
            }
        }

    }

    private static void LoadCharData(String File) throws Exception {
        DataInputStream data = ESGame.LoadDatRaw(File);
        int available = data.available();
        CritAtt = GetFields(data);
        Attributes = GetFields(data);
        Classes = GetFields(data);
        B = (short) Classes.length;
        Races = GetFields(data);
        al = (short) Classes.length;
        Skills = GetFields(data);
        short skillslen = (short) Skills.length;
        if (skillslen != 14) {
            throw new Exception("Error: mismatch between input number of skill types and that specified in code");
        } else {
            c = new short[skillslen];

            for(int i = 0; i < skillslen; ++i) {
                c[i] = data.readShort();
            }

            int resetRows = 13 + 2 * skillslen;
            ClassPreset = new short[B][resetRows];

            for(int i = 0; i < B; ++i) {
                for(int j = 0; j < resetRows; ++j) {
                    ClassPreset[i][j] = data.readShort();
                }
            }

        }
    }

    private static String[] GetFields(DataInputStream strm) throws Exception {
        short strCnt = strm.readShort();
        String[] strings = new String[strCnt];

        for(int i = 0; i < strCnt; ++i) {
            strings[i] = strm.readUTF();
        }

        return strings;
    }

    static Character LoadChar(byte[] btarr, boolean var1) throws Exception {
        Character NewChar = null;
        DataInputStream data = new DataInputStream(new ByteArrayInputStream(btarr, 0, btarr.length));
        NewChar = new Character((ESGame)null);
        NewChar.CharName = data.readUTF();
        NewChar.CharClass = data.readShort();
        if (!var1) {
            NewChar.c(NewChar.CharClass);
            NewChar.d(NewChar.CharClass);
        }

        NewChar.CharRace = data.readShort();

        for(int i = 0; i < 10; ++i) {
            NewChar.CharCritAtt[i] = data.readShort();
        }

        if (var1) {
            NewChar.N = data.readByte();
        }

        NewChar.n = data.readInt();

        for(int i = 0; i < 16; ++i) {
            NewChar.AttLvl[i] = data.readShort();
        }

        NewChar.V = data.readShort();
        NewChar.aq[0] = data.readShort();
        NewChar.aq[1] = data.readShort();

        int j;
        for(int i = 0; i < 14; ++i) {
            for(j = 0; j < 3; ++j) {
                NewChar.CharSkills[i][j] = data.readShort();
            }
        }

        if (var1) {
            NewChar.InventoryCount = data.readByte();

            for(j = 0; j < 24; ++j) {
                NewChar.Inventory[j] = data.readByte();
            }

            for(int var8 = 0; var8 < 24; ++var8) {
                NewChar.P[var8] = data.readInt();
            }

            for(int var9 = 0; var9 < 7; ++var9) {
                NewChar.T[var9] = data.readByte();
            }

            NewChar.x = data.readInt();
            NewChar.b = data.readByte();
        } else {
            NewChar.x = data.readInt();
        }

        if (var1) {
            NewChar.GiftPoints = data.readShort();
            NewChar.Y = data.readShort();
            NewChar.m = data.readShort();
            NewChar.A = data.readByte();
            NewChar.ah = data.readShort();
            NewChar.F = data.readShort();
            NewChar.ap = data.readShort();
            NewChar.f = data.readBoolean();
            NewChar.CurDung = data.readByte();
            NewChar.l = data.readByte();
            NewChar.Ka = data.readByte();
            NewChar.DirFacing = data.readByte();
            NewChar.C = data.readByte();
            NewChar.ao = data.readByte();
            NewChar.an = data.readByte();
            NewChar.Z = data.readByte();

            for(j = 0; j < 25; ++j) {
                NewChar.G[j] = data.readByte();
            }

            NewChar.t = data.readShort();
            NewChar.aa = data.readShort();
            NewChar.s = data.readBoolean();
            NewChar.L = data.readBoolean();
            NewChar.I = data.readBoolean();
        }

        return NewChar;
    }

    byte[] g(boolean var1) throws Exception {
        int var2 = this.b(var1);
        ByteArrayOutputStream var3 = new ByteArrayOutputStream(var2);
        DataOutputStream var4 = new DataOutputStream(var3);
        var4.writeUTF(this.CharName);
        var4.writeShort(this.CharClass);
        var4.writeShort(this.CharRace);
        int i;
        int j;
        int k;
        if (var1) {
            for(i = 0; i < 10; ++i) {
                var4.writeShort(this.CharCritAtt[i]);
            }

            var4.writeByte(this.N);
        } else {
            short[] var10 = new short[10];

            for(j = 0; j < 10; ++j) {
                var10[j] = this.CharCritAtt[j];
            }

            this.a(var10);

            for(k = 0; k < 10; ++k) {
                var4.writeShort(var10[k]);
            }
        }

        var4.writeInt(this.n);

        for(i = 0; i < 16; ++i) {
            var4.writeShort(this.AttLvl[i]);
        }

        var4.writeShort(this.V);
        var4.writeShort(this.aq[0]);
        var4.writeShort(this.aq[1]);

        for(j = 0; j < 14; ++j) {
            for(k = 0; k < 3; ++k) {
                var4.writeShort(this.CharSkills[j][k]);
            }
        }

        if (var1) {
            var4.writeByte(this.InventoryCount);

            for(k = 0; k < 24; ++k) {
                var4.writeByte(this.Inventory[k]);
            }

            for(int var8 = 0; var8 < 24; ++var8) {
                var4.writeInt(this.P[var8]);
            }

            for(int var9 = 0; var9 < 7; ++var9) {
                var4.writeByte(this.T[var9]);
            }

            var4.writeInt(this.x);
            var4.writeByte(this.b);
        } else {
            k = this.A();
            var4.writeInt(k);
        }

        if (var1) {
            var4.writeShort(this.GiftPoints);
            var4.writeShort(this.Y);
            var4.writeShort(this.m);
            var4.writeByte(this.A);
            var4.writeShort(this.ah);
            var4.writeShort(this.F);
            var4.writeShort(this.ap);
            var4.writeBoolean(this.f);
            var4.writeByte(this.CurDung);
            var4.writeByte(this.l);
            var4.writeByte(this.Ka);
            var4.writeByte(this.DirFacing);
            var4.writeByte(this.C);
            var4.writeByte(this.ao);
            var4.writeByte(this.an);
            var4.writeByte(this.Z);

            for(k = 0; k < 25; ++k) {
                var4.writeByte(this.G[k]);
            }

            var4.writeShort(this.t);
            var4.writeShort(this.aa);
            var4.writeBoolean(this.s);
            var4.writeBoolean(this.L);
            var4.writeBoolean(this.I);
        }

        byte[] var11 = var3.toByteArray();
        return var11;
    }

    void g(int var1) {
        byte var2 = -1;
        switch (var1) {
            case 1:
                var2 = 1;
            case 2:
                this.e = this.DirFacing;
                if (this.DirFacing == 1) {
                    this.XPos = this.l;
                    this.YPos = (byte)(this.Ka - var2);
                } else if (this.DirFacing == 3) {
                    this.XPos = this.l;
                    this.YPos = (byte)(this.Ka + var2);
                } else if (this.DirFacing == 2) {
                    this.XPos = (byte)(this.l + var2);
                    this.YPos = this.Ka;
                } else if (this.DirFacing == 4) {
                    this.XPos = (byte)(this.l - var2);
                    this.YPos = this.Ka;
                }

                Dungeon var3 = ESGame.dungeons[this.CurDung - 1];
                Dungeon var4;
                if (this.XPos < 0) {
                    this.i = true;
                    this.ab = var3.Geomin[3];
                    var4 = ESGame.dungeons[this.ab - 1];
                    if (this.ab != 1 && this.CurDung != 1) {
                        this.XPos = (byte)(var4.Width - 1);
                    } else {
                        this.XPos = (byte)(var4.Width - 1);
                        this.YPos = (byte)(this.YPos + (var4.Height - var3.Height) / 2);
                    }
                } else if (this.XPos >= var3.Width) {
                    this.i = true;
                    this.ab = var3.Geomin[1];
                    var4 = ESGame.dungeons[this.ab - 1];
                    if (this.ab != 1 && this.CurDung != 1) {
                        this.XPos = 0;
                    } else {
                        this.XPos = 0;
                        this.YPos = (byte)(this.YPos + (var4.Height - var3.Height) / 2);
                    }
                } else if (this.YPos < 0) {
                    this.i = true;
                    this.ab = var3.Geomin[0];
                    var4 = ESGame.dungeons[this.ab - 1];
                    if (this.ab != 1 && this.CurDung != 1) {
                        this.YPos = (byte)(var4.Height - 1);
                    } else {
                        this.XPos = (byte)(this.XPos + (var4.Width - var3.Width) / 2);
                        this.YPos = (byte)(var4.Height - 1);
                    }
                } else if (this.YPos >= var3.Height) {
                    this.i = true;
                    this.ab = ESGame.dungeons[this.CurDung - 1].Geomin[2];
                    var4 = ESGame.dungeons[this.ab - 1];
                    if (this.ab != 1 && this.CurDung != 1) {
                        this.YPos = 0;
                    } else {
                        this.XPos = (byte)(this.XPos + (var4.Width - var3.Width) / 2);
                        this.YPos = 0;
                    }
                } else {
                    this.i = false;
                    this.ab = this.CurDung;
                }
                break;
            case 3:
                this.ab = this.CurDung;
                this.i = false;
                this.e = (byte)(this.DirFacing + 1);
                if (this.e > 4) {
                    this.e = 1;
                }

                this.XPos = this.l;
                this.YPos = this.Ka;
                break;
            case 4:
                this.ab = this.CurDung;
                this.i = false;
                this.e = (byte)(this.DirFacing - 1);
                if (this.e < 1) {
                    this.e = 4;
                }

                this.XPos = this.l;
                this.YPos = this.Ka;
        }

    }

    boolean a(int var1, boolean var2) {
        Dungeon var3 = this.b();
        var3.a(this.l, this.Ka);
        if (this.CharCritAtt[6] <= 0) {
            return false;
        } else {
            boolean var4 = false;
            boolean var5;
            if (var2 && var1 == 4) {
                this.q(4);
                var5 = this.q(1);
                var4 = this.i;
                var5 = this.q(3);
                this.i = var4;
                return var5;
            } else if (var2 && var1 == 3) {
                this.q(3);
                var5 = this.q(1);
                var4 = this.i;
                var5 = this.q(4);
                this.i = var4;
                return var5;
            } else {
                return this.q(var1);
            }
        }
    }

    boolean q(int var1) {
        if (this.CharCritAtt[6] <= 0) {
            return false;
        } else if (var1 == 0) {
            return false;
        } else {
            this.g(var1);
            boolean var2 = false;
            if (var1 == 1 || var1 == 2) {
                var2 = true;
            }

            if (this.ab <= 0) {
                return false;
            } else {
                Dungeon var3 = ESGame.dungeons[this.ab - 1];
                if (!var3.k) {
                    return false;
                } else {
                    byte var4 = var3.DngnVec[this.XPos][this.YPos];
                    if (!this.a(var4)) {
                        return false;
                    } else {
                        if (this.ab == 37 && this.CurDung != 37) {
                            Enumeration var5 = ESGame.G[this.ab - 1].elements();

                            while(var5.hasMoreElements()) {
                                byte[] var6 = (byte[])var5.nextElement();
                                Monster var7 = Monster.a(var6);
                                if (var7.l == 41) {
                                    var7.g = (byte)var7.c(14);
                                    var7.d();
                                }
                            }

                            var5 = null;
                        }

                        if (!this.a(this.CurDung, this.l, this.Ka) && this.a(this.ab, this.XPos, this.YPos)) {
                            this.u = true;
                        } else {
                            this.u = false;
                        }

                        if (this.a(this.CurDung, this.l, this.Ka) && !this.a(this.ab, this.XPos, this.YPos)) {
                            this.O = true;
                        } else {
                            this.O = false;
                        }

                        this.CurDung = this.ab;
                        this.d = this.l;
                        this.a = this.Ka;
                        this.l = this.XPos;
                        this.Ka = this.YPos;
                        this.DirFacing = this.e;
                        var3.h = true;
                        if (var1 == 1 || var1 == 2) {
                            if (NPC.l) {
                                NPC.l = false;
                            }

                            short[] var10000 = this.CharCritAtt;
                            var10000[6] = (short)(var10000[6] - 1 * this.c());
                            this.CharCritAtt[6] = (short)Math.max(this.CharCritAtt[6], 0);
                        }

                        boolean var12 = (var4 & 4) != 0;
                        if (var12) {
                            int var13 = var3.f(this.l, this.Ka);
                            if (var13 == 1) {
                                byte[] var14 = var3.e(this.l, this.Ka);
                                if ((var14[6] & 4) != 0) {
                                    g = true;
                                    this.w();
                                    return true;
                                }

                                System.out.println(">>>>>>Found a dropped item item: " + d(var14));
                                boolean var8 = this.c(var14);
                                if (var8) {
                                    var3.d(var14);
                                    if ((var14[6] & 2) == 0) {
                                        System.out.println("Dropped item not possessed before");
                                        int var9 = var14[2] - 1;
                                        System.out.println("item index=" + var9);
                                        if (Item.Type[var9] == 11) {
                                            this.GiftPoints += (short) Item.Level[var9];
                                            int var10 = ESGame.d(this.GiftPoints);
                                            this.Game.PopulateDungeons(var10);
                                        }
                                    }
                                }
                            } else if (var13 > 1) {
                                System.out.println("Found several items in square");
                                Vector var15 = var3.b(this.l, this.Ka);
                                Enumeration var16 = var15.elements();

                                while(var16.hasMoreElements()) {
                                    byte[] var17 = (byte[])var16.nextElement();
                                    if ((var17[6] & 4) != 0) {
                                        g = true;
                                        this.w();
                                        return true;
                                    }

                                    boolean var18 = this.c(var17);
                                    if (var18) {
                                        var3.d(var17);
                                        if ((var17[6] & 2) != 0) {
                                            int var11 = var17[2] - 1;
                                            System.out.println("item index=" + var11);
                                            if (Item.Type[var11] == 11) {
                                                this.GiftPoints += (short) Item.Level[var11];
                                                this.Game.PopulateDungeons(ESGame.d(this.GiftPoints));
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        this.w();
                        if (var2 && (var4 & 8) != 0) {
                            this.p();
                        }

                        return true;
                    }
                }
            }
        }
    }

    boolean a(byte var1) {
        if ((var1 & 1) != 0) {
            return false;
        } else if ((var1 & 32) != 0) {
            return false;
        } else {
            return (var1 & 2) == 0;
        }
    }

    void a(Monster var1) {
        this.t = var1.a;
        byte var2 = var1.l;
        int var3 = this.h(true);
        int var4 = var1.c(7);
        int var5 = var3 - var4;
        var5 = Math.min(var5, var1.c(2));
        if (this.t(10)) {
            if (var1.c[8] == 0) {
                this.x(10);
            } else {
                var5 += var1.c[8];
            }
        }

        int var6 = var1.c(6) - var5 * 5;
        int var7 = this.s() + var5 * 5;
        var6 = Math.min(Math.max(var6, 10), 95);
        var7 = Math.min(Math.max(var7, 10), 95);
        int var8 = d(var7, var6);
        if (var8 != 0) {
            int var9 = this.z();
            int var10 = var1.c(8);
            if (this.t(13)) {
                if (var1.c[5] == 0) {
                    this.G[12] = 0;
                } else {
                    var10 -= var1.c[5];
                }
            }

            if (var8 == 1) {
                var10 = 2 * var10;
            } else if (var8 == 3) {
                var9 = 2 * var9;
            }

            int var11 = var9 - var10;
            var11 = Math.max(var11, 4);
            int var12 = var11 * var1.c(14) / 100;
            var1.b(var12);
            var1.d();
            if (this.t(7)) {
                if (var1.c[1] == 0) {
                    this.x(7);
                } else {
                    byte var14 = var1.c[1];
                    var11 = Math.max(var14, 4);
                    var12 = var11 * var1.c(14) / 100;
                    var1.b(var12);
                }
            }

            if (var8 >= 2) {
                this.a(this.F(), 1);
            }

            short[] var10000;
            if (!this.t(7)) {
                var10000 = this.CharCritAtt;
                var10000[6] = (short)(var10000[6] - 7 * this.c());
                this.CharCritAtt[6] = (short)Math.max(this.CharCritAtt[6], 0);
            }

            if (this.k(6)) {
                int var13 = 2 * this.CharCritAtt[3] / 100;
                if (var13 < 1) {
                    var13 = 1;
                }

                var10000 = this.CharCritAtt;
                var10000[2] -= (short)var13;
            }

        }
    }

    int b(Object var1) {
        boolean var2 = false;
        boolean var3 = false;
        Object var4 = null;
        int var5 = Integer.MAX_VALUE;
        byte[] var9 = (byte[])var1;
        byte var7;
        byte var8;
        if (var9.length == 28) {
            Monster var6 = Monster.a(var9);
            var7 = var6.o;
            var8 = var6.m;
        } else {
            var7 = var9[0];
            var8 = var9[1];
        }

        if (this.DirFacing == 1) {
            var5 = this.Ka - var8;
        } else if (this.DirFacing == 3) {
            var5 = var8 - this.Ka;
        } else if (this.DirFacing == 2) {
            var5 = var7 - this.l;
        } else {
            var5 = this.l - var7;
        }

        if (var5 < 0) {
            var5 = Integer.MAX_VALUE;
        }

        return var5;
    }

    void b(int var1, Object var2) {
        Object var3 = null;
        String var4 = null;
        byte[] var6;
        switch (var1) {
            case 1:
                var6 = (byte[])var2;
                var6[6] = 1;
                Monster var5 = Monster.a(var6);
                var4 = String.valueOf(var5.a);
                var5.ia = true;
                var5.d();
                break;
            case 2:
                var6 = (byte[])var2;
                var6[6] = (byte)(var6[6] | 1);
        }

    }

    void d(boolean var1) {
        this.i();
        Vector var2 = ESGame.au[this.CurDung - 1];
        if (var2 != null) {
            Enumeration var3 = var2.elements();

            while(var3.hasMoreElements()) {
                byte[] var4 = (byte[])var3.nextElement();
                this.a(2, var4, var1);
            }
        }

        Hashtable var7 = ESGame.S[this.CurDung - 1];
        if (var7 != null) {
            Enumeration var8 = var7.elements();

            while(var8.hasMoreElements()) {
                byte[] var5 = (byte[])var8.nextElement();
                this.a(4, var5, var1);
            }
        }

        Hashtable var9 = ESGame.G[this.CurDung - 1];
        if (var9 != null) {
            Enumeration var10 = var9.elements();

            while(var10.hasMoreElements()) {
                byte[] var6 = (byte[])var10.nextElement();
                this.a(1, var6, var1);
            }
        }

        if (this.CurDung == 1 && NPC.WardenPresent) {
            this.a(5, (Object)"W");
        }

    }

    boolean a(int var1, Object var2, boolean var3) {
        Object var4 = null;
        Object var5 = null;
        boolean var6 = false;
        boolean var7 = false;
        boolean var8 = false;
        int var9 = this.b(var2);
        boolean var10 = this.a(var1, var2);
        if (!var10) {
            return false;
        } else if (var1 != 4 && var9 != 1) {
            this.b(var1, var2);
            return true;
        } else {
            this.b(var1, var2);
            return true;
        }
    }

    void i() {
        Dungeon var1 = this.b();
        boolean var2 = false;

        for(int i = 0; i < 13; ++i) {
            ad.setElementAt(aj, i);
        }

        byte var5 = var1.a(-1, 1, this.ae);
        if (func.a((byte)1, var5)) {
            ad.setElementAt(am, 0);
        }

        var5 = var1.a(0, 1, this.ae);
        if (func.a((byte)1, var5)) {
            ad.setElementAt(am, 1);
        }

        var5 = var1.a(1, 1, this.ae);
        if (func.a((byte)1, var5)) {
            ad.setElementAt(am, 2);
        }

        var5 = var1.a(-2, 2, this.ae);
        if (func.a((byte)1, var5)) {
            ad.setElementAt(am, 3);
        }

        var5 = var1.a(-1, 2, this.ae);
        if (func.a((byte)1, var5)) {
            ad.setElementAt(am, 4);
        }

        var5 = var1.a(0, 2, this.ae);
        if (func.a((byte)1, var5)) {
            ad.setElementAt(am, 5);
        }

        var5 = var1.a(1, 2, this.ae);
        if (func.a((byte)1, var5)) {
            ad.setElementAt(am, 6);
        }

        var5 = var1.a(2, 2, this.ae);
        if (func.a((byte)1, var5)) {
            ad.setElementAt(am, 7);
        }

        var5 = var1.a(-2, 3, this.ae);
        if (func.a((byte)1, var5)) {
            ad.setElementAt(am, 8);
        }

        var5 = var1.a(-1, 3, this.ae);
        if (func.a((byte)1, var5)) {
            ad.setElementAt(am, 9);
        }

        var5 = var1.a(0, 3, this.ae);
        if (func.a((byte)1, var5)) {
            ad.setElementAt(am, 10);
        }

        var5 = var1.a(1, 3, this.ae);
        if (func.a((byte)1, var5)) {
            ad.setElementAt(am, 11);
        }

        var5 = var1.a(2, 3, this.ae);
        if (func.a((byte)1, var5)) {
            ad.setElementAt(am, 12);
        }

        if (IsOne(ad.elementAt(0))) {
            ad.setElementAt(o, 4);
            ad.setElementAt(o, 8);
            ad.setElementAt(o, 9);
        }

        if (IsOne(ad.elementAt(1))) {
            for(int i = 0; i < 13; ++i) {
                if (i != 1) {
                    ad.setElementAt(o, i);
                }
            }
        }

        if (IsOne(ad.elementAt(2))) {
            ad.setElementAt(o, 6);
            ad.setElementAt(o, 11);
            ad.setElementAt(o, 12);
        }

        if (IsOne(ad.elementAt(3))) {
            ad.setElementAt(o, 8);
        }

        if (IsOne(ad.elementAt(4))) {
            ad.setElementAt(o, 8);
            ad.setElementAt(o, 9);
        }

        if (IsOne(ad.elementAt(5))) {
            ad.setElementAt(o, 9);
            ad.setElementAt(o, 10);
            ad.setElementAt(o, 11);
            ad.setElementAt(o, 4);
            ad.setElementAt(o, 6);
        }

        if (IsOne(ad.elementAt(6))) {
            ad.setElementAt(o, 11);
            ad.setElementAt(o, 12);
        }

        if (IsOne(ad.elementAt(7))) {
            ad.setElementAt(o, 12);
        }

        if (IsOne(ad.elementAt(9))) {
            ad.setElementAt(o, 8);
        }

        if (IsOne(ad.elementAt(10))) {
            ad.setElementAt(o, 9);
            ad.setElementAt(o, 11);
        }

        if (IsOne(ad.elementAt(11))) {
            ad.setElementAt(o, 12);
        }

    }

    boolean a(int var1, Object var2) {
        Dungeon var3 = this.b();
        Object var4 = null;
        Object var5 = null;
        Object var6 = null;
        Object var7 = null;
        boolean var8 = false;
        boolean var9 = false;
        byte var15;
        byte var16;
        if (var1 == 1) {
            byte[] var12 = (byte[])var2;
            var15 = var12[4];
            var16 = var12[5];
        } else if (var1 == 4) {
            byte[] var14 = (byte[])var2;
            var15 = var14[0];
            var16 = var14[1];
        } else if (var1 == 5) {
            var15 = NPC.NPCXPos[6];
            var16 = NPC.NPCYPos[6];
        } else {
            byte[] var13 = (byte[])var2;
            var15 = var13[0];
            var16 = var13[1];
        }

        int[] var10 = var3.a(this.l, this.Ka, this.DirFacing, var15, var16);
        boolean var11 = false;
        if (a(var10[0], var10[1], 3, 2)) {
            var11 = true;
            ad.setElementAt(var2, 1);
        } else if (a(var10[0], var10[1], 2, 1)) {
            if (!IsOne(ad.elementAt(0)) && !IsOne(ad.elementAt(1)) && !IsOne(ad.elementAt(5))) {
                var11 = true;
                ad.setElementAt(var2, 4);
            }
        } else if (a(var10[0], var10[1], 3, 1)) {
            if (!IsOne(ad.elementAt(1))) {
                var11 = true;
                ad.setElementAt(var2, 5);
            }
        } else if (a(var10[0], var10[1], 4, 1)) {
            if (!IsOne(ad.elementAt(1)) && !IsOne(ad.elementAt(2)) && !IsOne(ad.elementAt(5))) {
                var11 = true;
                ad.setElementAt(var2, 6);
            }
        } else if (a(var10[0], var10[1], 1, 0)) {
            if (!IsOne(ad.elementAt(0)) && !IsOne(ad.elementAt(1)) && !IsOne(ad.elementAt(3)) && !IsOne(ad.elementAt(4)) && !IsOne(ad.elementAt(9))) {
                var11 = true;
                ad.setElementAt(var2, 8);
            }
        } else if (a(var10[0], var10[1], 2, 0)) {
            if (!IsOne(ad.elementAt(0)) && !IsOne(ad.elementAt(1)) && !IsOne(ad.elementAt(4)) && !IsOne(ad.elementAt(5)) && !IsOne(ad.elementAt(10))) {
                var11 = true;
                ad.setElementAt(var2, 9);
            }
        } else if (a(var10[0], var10[1], 3, 0)) {
            if (!IsOne(ad.elementAt(1)) && !IsOne(ad.elementAt(5))) {
                var11 = true;
                ad.setElementAt(var2, 10);
            }
        } else if (a(var10[0], var10[1], 4, 0)) {
            if (!IsOne(ad.elementAt(1)) && !IsOne(ad.elementAt(2)) && !IsOne(ad.elementAt(5)) && !IsOne(ad.elementAt(6)) && !IsOne(ad.elementAt(10))) {
                var11 = true;
                ad.setElementAt(var2, 11);
            }
        } else if (a(var10[0], var10[1], 5, 0) && !IsOne(ad.elementAt(1)) && !IsOne(ad.elementAt(2)) && !IsOne(ad.elementAt(6)) && !IsOne(ad.elementAt(7)) && !IsOne(ad.elementAt(11))) {
            var11 = true;
            ad.setElementAt(var2, 12);
        }

        return var11;
    }

    private static boolean a(int var0, int var1, int var2, int var3) {
        return var0 == var2 && var1 == var3;
    }

    private static boolean IsOne(Object obj) {
        if (obj instanceof Integer) {
            Integer var1 = (Integer)obj;
            if (var1 == 1) {
                return true;
            }

            if (var1 == -1) {
                return true;
            }
        }

        return false;
    }

    void a(byte[] var1) {
        Dungeon var2 = ESGame.dungeons[this.CurDung - 1];
        var2.c(var1);
    }

    static int d(int var0, int var1) {
        int var2 = func.a(100);
        int var3 = func.a(100);
        boolean var4 = var2 <= var1;
        D = var3 <= var0;
        boolean var5 = false;
        byte var6;
        if (D && !var4) {
            var6 = 3;
        } else if (D && var4) {
            if (var3 >= var2) {
                var6 = 2;
            } else {
                var6 = 1;
            }
        } else if (!D && !var4) {
            if (var3 >= var2) {
                var6 = 2;
            } else {
                var6 = 1;
            }
        } else {
            var6 = 0;
        }

        return var6;
    }

    int b(int var1, boolean var2) {
        int var3 = this.CharSkills[var1][0];
        if (var2) {
            int var4 = 1 + c[var1];
            var3 += this.AttLvl[var4] / 3;
        }

        if (var1 == 11 && this.t(3)) {
            var3 += this.CharSkills[1][0];
        }

        if (this.CharCritAtt[6] < 7) {
            --var3;
        }

        return var3;
    }

    int z(int var1) {
        short var2 = this.CharSkills[var1][1];
        return var2;
    }

    int f(boolean var1) {
        if (this.T[1] != 0) {
            int var2 = Item.a(1, this.T[1]);
            var2 = Math.abs(var2);
            return var2 == 5 ? this.b(5, var1) : this.b(7, var1);
        } else {
            return 0;
        }
    }

    int I() {
        if (this.T[1] != 0) {
            int var1 = Item.a(1, this.T[1]);
            var1 = Math.abs(var1);
            return var1 == 5 ? this.z(5) : this.z(7);
        } else {
            return 20;
        }
    }

    int t() {
        byte var1 = 0;
        int var2 = this.b(0, false);
        int var3 = this.b(2, false);
        if (var3 > var2) {
            var2 = var3;
            var1 = 2;
        }

        var3 = this.b(8, false);
        if (var3 > var2) {
            var2 = var3;
            var1 = 8;
        }

        var3 = this.b(12, false);
        if (var3 > var2) {
            var1 = 12;
        }

        return var1;
    }

    int F() {
        if (this.t(6)) {
            return this.t();
        } else if (this.T[0] != 0) {
            int var1 = Item.a(1, this.T[0]);
            var1 = Math.abs(var1);
            if (var1 == 1) {
                return 0;
            } else if (var1 == 2) {
                return 2;
            } else {
                return var1 == 3 ? 8 : 12;
            }
        } else {
            return -1;
        }
    }

    int h(boolean var1) {
        if (this.t(14)) {
            return 5 + this.b(4, false);
        } else {
            int var4;
            if (this.t(6)) {
                var4 = this.t();
                return this.b(var4, var1);
            } else {
                boolean var2 = false;
                if (this.T[0] != 0) {
                    int var3 = Item.a(1, this.T[0]);
                    var3 = Math.abs(var3);
                    if (var3 == 1) {
                        var4 = this.b(0, var1);
                    } else if (var3 == 2) {
                        var4 = this.b(2, var1);
                    } else if (var3 == 3) {
                        var4 = this.b(8, var1);
                    } else {
                        var4 = this.b(12, var1);
                    }
                } else {
                    var4 = 0;
                }

                if (this.t(5)) {
                    var4 += this.b(1, false);
                }

                return var4;
            }
        }
    }

    int s() {
        int var1;
        if (!this.t(6) && !this.t(14)) {
            if (this.T[0] != 0) {
                var1 = Item.a(1, this.T[0]);
                var1 = Math.abs(var1);
                if (var1 == 1) {
                    return this.z(0);
                } else if (var1 == 2) {
                    return this.z(2);
                } else {
                    return var1 == 3 ? this.z(8) : this.z(12);
                }
            } else {
                return 20;
            }
        } else {
            var1 = this.t();
            return this.z(var1);
        }
    }

    int z() {
        boolean var1 = false;
        int var2;
        if (this.t(14)) {
            var2 = 5 + this.b(4, false);
        } else if (this.t(6)) {
            var2 = 20 + this.b(3, false);
        } else if (this.T[0] != 0) {
            var2 = Item.a(3, this.T[0]);
        } else {
            var2 = 0;
        }

        if (this.t(1)) {
            var2 += 10 + this.b(1, false);
        }

        if (this.s) {
            var2 += 25;
        }

        return var2;
    }

    int y() {
        if (this.T[1] != 0) {
            int var1 = Item.a(1, this.T[1]);
            var1 = Math.abs(var1);
            return var1 == 5 ? 5 : 7;
        } else {
            return -1;
        }
    }

    int v() {
        int var1 = 0;
        boolean var2 = false;
        int var3;
        if (this.T[1] != 0) {
            var3 = Item.a(3, this.T[1]);
            var1 += 4 * var3;
        }

        if (this.T[2] != 0) {
            var3 = Item.a(3, this.T[2]);
            var1 += 2 * var3;
        }

        if (this.T[3] != 0) {
            var3 = Item.a(3, this.T[3]);
            var1 += 2 * var3;
        }

        if (this.T[4] != 0) {
            var3 = Item.a(3, this.T[4]);
            var1 += var3;
        }

        if (this.T[5] != 0) {
            var3 = Item.a(3, this.T[5]);
            var1 += var3;
        }

        var1 /= 10;
        if (this.t(2)) {
            var1 += 10 + this.b(1, false);
        }

        if (this.t(17)) {
            var1 += this.aa;
        }

        if (this.L) {
            var1 += 15;
        }

        return var1;
    }

    int b(byte[] var1) {
        var1[2] = 2;
        if (this.InventoryNotFull()) {
            byte var7 = var1[4];
            int var3 = (var1[5] << 8) + var1[6];
            byte var4 = var1[7];
            this.AddToInventory(var7, var3, var4);
            ESGame.dungeons[this.CurDung - 1].b(var1);
            System.out.println("Chest item not possessed before");
            int var5 = var7 - 1;
            System.out.println("item index=" + var5);
            if (Item.Type[var5] == 11) {
                this.GiftPoints += (short) Item.Level[var5];
                int var6 = ESGame.d(this.GiftPoints);
                this.Game.PopulateDungeons(var6);
            }

            return 1;
        } else {
            byte[] var2 = new byte[]{var1[0], var1[1], var1[4], var1[5], var1[6], var1[7], 1};
            this.a(var2);
            ESGame.dungeons[this.CurDung - 1].b(var1);
            return 0;
        }
    }

    private boolean t(int var1) {
        if (this.G[var1 - 1] == -1) {
            return true;
        } else if (this.G[var1 - 1] == -2) {
            return this.t != 0;
        } else {
            return this.G[var1 - 1] > 0;
        }
    }

    void x(int var1) {
        this.G[var1 - 1] = 0;
    }

    Monster n() {
        this.g(1);
        if (this.ab <= 0) {
            return null;
        } else {
            Dungeon var1 = ESGame.dungeons[this.ab - 1];
            Monster var2 = var1.c(this.XPos, this.YPos);
            if (var2 != null) {
                var2.c();
            }

            return var2;
        }
    }

    byte[] h() {
        this.g(1);
        if (this.ab <= 0) {
            return null;
        } else {
            byte var1 = this.ab;
            Hashtable var2 = ESGame.S[var1 - 1];
            if (var2 == null) {
                return null;
            } else {
                Object var3 = var2.get(func.b(this.XPos, this.YPos));
                if (var3 == null) {
                    return null;
                } else {
                    byte[] var4 = (byte[])var3;
                    return var4;
                }
            }
        }
    }

    int r() {
        this.g(1);
        if (this.ab <= 0) {
            return -1;
        } else {
            byte var1 = this.ab;
            return var1 != 1 ? -1 : NPC.a(this.XPos, this.YPos);
        }
    }

    int u(int var1) {
        if (var1 <= 5) {
            return 1;
        } else if (var1 <= 10) {
            return 3;
        } else if (var1 <= 15) {
            return 4;
        } else {
            return var1 <= 20 ? 6 : 10;
        }
    }

    void CastSpell(int var1) {
        System.out.println("start of castSpell");
        int var2 = this.u(var1);
        int var3 = this.b(var2, true);
        int var4 = this.z(var2);
        byte g1 = Spell.GetSpell(var1).g;
        byte j1 = Spell.GetSpell(var1).J;
        byte cost = Spell.GetSpell(var1).Cost;
        byte f1 = Spell.GetSpell(var1).f;
        int var9 = var3 - g1;
        int var10 = var4 + var9 * 5;
        int var11 = j1 - var9 * 5;
        var10 = Math.min(Math.max(var10, 10), 95);
        var11 = Math.min(Math.max(var11, 10), 95);
        int var12 = d(var10, var11);
        byte var13 = 1;
        short[] var10000;
        if (var12 == 0) {
            var10000 = this.CharCritAtt;
            var10000[4] = (short)(var10000[4] - 3 * cost);
        } else if (var12 == 1) {
            var10000 = this.CharCritAtt;
            var10000[4] = (short)(var10000[4] - 3 * cost / 2);
        } else if (var12 == 2) {
            var10000 = this.CharCritAtt;
            var10000[4] = (short)(var10000[4] - cost);
        } else if (var12 == 3) {
            var10000 = this.CharCritAtt;
            var10000[4] = (short)(var10000[4] - cost);
            var13 = 2;
        }

        this.CharCritAtt[4] = (short)Math.max(this.CharCritAtt[4], 0);
        if (var12 >= 2) {
            this.a(var2, 1);
        }

        switch (var1) {
            case 1:
            case 2:
            case 3:
            case 5:
                this.G[var1 - 1] = (byte)(f1 * var13);
            case 4:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 22:
            default:
                break;
            case 6:
                byte var14 = 0;
                if (this.c(109, var14) && this.a(true)) {
                    this.G[var1 - 1] = (byte)(f1 * var13);
                }
                break;
            case 21:
                int var15 = 6 + this.b(10, false);
                var10000 = this.CharCritAtt;
                var10000[2] = (short)(var10000[2] + var13 * var15);
                this.CharCritAtt[2] = (short)Math.min(this.CharCritAtt[2], this.CharCritAtt[3]);
                break;
            case 23:
                this.G[var1 - 1] = -2;
                break;
            case 24:
                this.G[var1 - 1] = -4;
                break;
            case 25:
                for(int i = 1; i <= var13; ++i) {
                    this.H();
                }
        }

        var10000 = this.CharCritAtt;
        var10000[6] = (short)(var10000[6] - 5 * this.c());
        this.CharCritAtt[6] = (short)Math.max(this.CharCritAtt[6], 0);
        if (this.k(6)) {
            int var17 = 2 * this.CharCritAtt[3] / 100;
            if (var17 < 1) {
                var17 = 1;
            }

            var10000 = this.CharCritAtt;
            var10000[2] -= (short)var17;
        }

    }

    void b(int var1, Monster var2) {
        int var3 = this.u(var1);
        int var4 = this.b(var3, true);
        int var5 = this.z(var3);
        int var6 = var2.c(10);
        int var7 = var2.c(9);
        byte cost = Spell.GetSpell(var1).Cost;
        byte var9 = Spell.GetSpell(var1).f;
        int var10 = var4 - var6;
        int var11 = var2.c(2);
        var10 = Math.min(var10, var11);
        int var12 = var5 + var10 * 5;
        int var13 = var7 - var10 * 5;
        var12 = Math.min(Math.max(var12, 10), 95);
        var13 = Math.min(Math.max(var13, 10), 95);
        int var14 = d(var12, var13);
        byte var15 = 1;
        short[] var10000;
        if (var14 == 0) {
            var10000 = this.CharCritAtt;
            var10000[4] = (short)(var10000[4] - 3 * cost);
        } else if (var14 == 1) {
            var10000 = this.CharCritAtt;
            var10000[4] = (short)(var10000[4] - 3 * cost / 2);
        } else if (var14 == 2) {
            var10000 = this.CharCritAtt;
            var10000[4] = (short)(var10000[4] - cost);
        } else if (var14 == 3) {
            var10000 = this.CharCritAtt;
            var10000[4] = (short)(var10000[4] - cost);
            var15 = 2;
        }

        this.CharCritAtt[4] = (short)Math.max(this.CharCritAtt[4], 0);
        if (var14 >= 2) {
            this.a(var3, 1);
        }

        int var16;
        int var17;
        int var18;
        int var19;
        switch (var1) {
            case 4:
                var2.c[9] = -2;
                var2.d();
            case 5:
            case 6:
            default:
                break;
            case 7:
                var16 = 10 + this.b(3, false);
                var2.c[1] = (byte)var16;
                break;
            case 8:
                var16 = this.b(3, false);
                var17 = 12 + 2 * var16;
                var2.b(var17);
                var10000 = this.CharCritAtt;
                var10000[6] = (short)(var10000[6] + var16);
                this.CharCritAtt[6] = (short)Math.min(this.CharCritAtt[6], this.CharCritAtt[7]);
                var10000 = this.CharCritAtt;
                var10000[2] = (short)(var10000[2] + var16);
                this.CharCritAtt[2] = (short)Math.min(this.CharCritAtt[2], this.CharCritAtt[3]);
                var10000 = this.CharCritAtt;
                var10000[4] = (short)(var10000[4] + 12);
                this.CharCritAtt[4] = (short)Math.min(this.CharCritAtt[4], this.CharCritAtt[5]);
                break;
            case 9:
                if (var2.e()) {
                    var16 = 60 * var15;
                    var17 = var16 - var2.c(8);
                    var17 = Math.max(var17, 4);
                    var18 = var17 * var2.c(14) / 100;
                    var2.b(var18);
                }
                break;
            case 10:
                this.G[var1 - 1] = -2;
                var2.c[8] = (byte)(2 * var15);
                break;
            case 11:
                var16 = 25 + this.b(4, false);
                var17 = var16 * var15;
                var18 = var17 - var2.c(8);
                var18 = Math.max(var18, 4);
                var19 = var18 * var2.c(14) / 100;
                var2.b(var19);
                var2.d();
                break;
            case 12:
                this.G[var1 - 1] = -2;
                var16 = var15 * (10 + this.b(4, false));
                var16 = Math.min(var16, 255);
                var2.c[4] = (byte)var16;
                var2.d();
                break;
            case 13:
                this.G[var1 - 1] = -2;
                var16 = var15 * (10 + this.b(4, false));
                var16 = Math.min(var16, 255);
                var2.c[5] = (byte)var16;
                var2.d();
                break;
            case 14:
                this.G[var1 - 1] = -1;
                this.a(var2);
                this.G[var1 - 1] = 0;
                break;
            case 15:
                this.G[var1 - 1] = -2;
                var2.c[2] = 1;
                var2.d();
                break;
            case 16:
                var16 = 10 - var6;
                if (var16 > 0) {
                    var16 = var15 * var16;
                    this.G[var1 - 1] = (byte)var16;
                    var2.c[6] = 1;
                }
                break;
            case 17:
                this.G[var1 - 1] = -2;
                this.aa = (short)(10 + this.b(6, false));
                break;
            case 18:
                this.G[var1 - 1] = -2;
                var2.c[0] = (byte)(3 * var15);
                break;
            case 19:
                this.G[var1 - 1] = -2;
                var17 = var15 * (60 - 5 * var6);
                var17 = Math.min(Math.max(var17, 0), 100);
                var2.c[3] = (byte)var17;
                break;
            case 20:
                var18 = 80 - 5 * var6;
                var19 = var18 * var15;
                int var20 = var19 - var2.c(8);
                var20 = Math.max(var20, 4);
                int var21 = var20 * var2.c(14) / 100;
                var2.b(var21);
        }

        var10000 = this.CharCritAtt;
        var10000[6] = (short)(var10000[6] - 5 * this.c());
        this.CharCritAtt[6] = (short)Math.max(this.CharCritAtt[6], 0);
        if (this.k(6)) {
            int var22 = 2 * this.CharCritAtt[3] / 100;
            if (var22 < 1) {
                var22 = 1;
            }

            var10000 = this.CharCritAtt;
            var10000[2] -= (short)var22;
        }

    }

    void a(int var1, int var2) {
        if (var1 >= 0) {
            short[] var10000 = this.CharSkills[var1];
            var10000[2] = (short)(var10000[2] + var2);
        }

    }

    boolean c(byte[] var1) {
        byte var2 = var1[2];
        int var3 = (var1[3] << 8) + var1[4];
        byte var4 = var1[5];
        return this.AddToInventory(var2, var3, var4);
    }

    boolean c(int var1, int var2) {
        return this.AddToInventory(var1, var2, 0);
    }

    boolean AddToInventory(int var1, int var2, int var3) {
        if (this.InventoryCount < 24) {
            this.Inventory[this.InventoryCount] = (byte)var1;
            int var4 = (var2 << 16) + (byte)var3;
            this.P[this.InventoryCount] = var4;
            ++this.InventoryCount;
            return true;
        } else {
            return false;
        }
    }

    boolean y(int var1) {
        if (var1 >= this.InventoryCount) {
            return false;
        } else {
            this.A(var1);
            this.Inventory[var1] = 0;

            for(int i = var1; i < this.InventoryCount - 1; ++i) {
                this.Inventory[i] = this.Inventory[i + 1];
                this.P[i] = this.P[i + 1];
            }

            --this.InventoryCount;
            return true;
        }
    }

    void i(int var1) {
        int var2 = Math.abs(this.Inventory[var1]);
        if (var2 != 109) {
            byte[] var3 = new byte[]{this.l, this.Ka, (byte)var2, 0, 0, (byte)(this.P[var1] & 255), 0};
            int var4 = this.P[var1] >>> 16 & '\uffff';
            var3[3] = (byte)(var4 >> 8 & 255);
            var3[4] = (byte)(var4 & 255);
            var3[6] = 3;
            this.b().c(var3);
            this.y(var1);
        } else {
            this.y(var1);
        }

    }

    boolean C(int var1) {
        byte var2 = this.Inventory[var1];
        if (!Item.c(Math.abs(var2))) {
            return false;
        } else {
            return var2 < 0;
        }
    }

    boolean d(int var1, boolean var2) {
        byte var3 = this.Inventory[var1];
        if (var3 < 0) {
            return false;
        } else if (!Item.c(var3)) {
            return false;
        } else {
            int var4 = Item.a(var3);
            if (this.T[var4] != 0) {
                if (!var2) {
                    return false;
                }

                this.f(var4);
            }

            this.T[var4] = var3;
            this.Inventory[var1] = (byte)(-Math.abs(this.Inventory[var1]));
            return true;
        }
    }

    private void f(int var1) {
        for(int i = 0; i < this.InventoryCount; ++i) {
            byte var3 = this.Inventory[i];
            var3 = (byte)Math.abs(var3);
            int var4 = Item.a(var3);
            if (var4 == var1) {
                this.A(i);
            }
        }

    }

    boolean a(boolean var1) {
        int var2 = this.InventoryCount - 1;
        return this.d(var2, var1);
    }

    void A(int var1) {
        if (this.C(var1)) {
            if (var1 >= 0 && var1 <= 23) {
                byte var2 = this.Inventory[var1];
                var2 = (byte)Math.abs(var2);
                this.Inventory[var1] = var2;

                for(int i = 0; i < 7; ++i) {
                    if (this.T[i] == var2) {
                        this.T[i] = 0;
                        break;
                    }
                }

            }
        }
    }

    boolean h(int var1) {
        byte var2 = this.Inventory[var1];
        var2 = (byte)Math.abs(var2);
        if (Item.b(var2)) {
            byte var3 = (byte)(this.P[var1] & 255);
            var3 = 3;
            int[] var10000 = this.P;
            var10000[var1] &= -256;
            var10000 = this.P;
            var10000[var1] |= var3;
            return true;
        } else {
            return false;
        }
    }

    boolean j(int var1) {
        byte var2 = this.Inventory[var1];
        var2 = (byte)Math.abs(var2);
        byte var3 = (byte)(this.P[var1] & 255);
        return var3 == 3;
    }

    int D(int var1) {
        byte var2 = this.Inventory[var1];
        var2 = (byte)Math.abs(var2);
        return Item.Level[var2 - 1];
    }

    int o(int var1) {
        int var2 = -1;
        int var3 = -Math.abs(var1);

        for(int i = 0; i < this.InventoryCount; ++i) {
            if (var3 == this.Inventory[i]) {
                var2 = i;
                break;
            }
        }

        return var2;
    }

    boolean InventoryNotFull() {
        return this.InventoryCount < 24;
    }

    String ItemString(int indx) {
        int ItemID = Math.abs(this.Inventory[indx]);
        byte type = Item.Type[ItemID - 1];
        String var4 = null;
        switch (type) {
            case 1:
            case 2:
            case 3:
            case 4:
                var4 = Item.ItemName[ItemID - 1] + '\n' + Item.ItemType[type - 1];
                int var5 = Item.Rating[ItemID - 1] + (this.P[indx] & 255);
                var4 = var4 + "\nWeapon value: " + var5;
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                var4 = Item.ItemName[ItemID - 1] + '\n' + Item.ItemType[type - 1];
                int var6 = Item.Rating[ItemID - 1] + (this.P[indx] & 255);
                var4 = var4 + "\nArmor value: " + var6;
                break;
            case 11:
                var4 = Item.ItemName[ItemID - 1] + '\n' + Item.ItemType[type - 1];
                break;
            case 12:
                var4 = Item.ItemName[ItemID - 1] + '\n' + "Spell: ";
                int var7 = this.P[indx] & 255;
                var4 = var4 + Spell.spells[var7 - 1].Name;
                break;
            case 13:
                int var8 = ItemID - 87;
                String[] var9 = Item.l[var8];
                var4 = Item.ItemName[ItemID - 1] + '\n' + Item.ItemType[type - 1] + '\n' + var9[0];
                if (var9[1].length() > 0) {
                    var4 = var4 + '\n' + var9[1];
                }
                break;
            case 14:
            case 15:
            case 16:
            default:
                var4 = Item.ItemName[ItemID - 1] + '\n' + Item.ItemType[type - 1];
                break;
            case 17:
                var4 = Item.ItemName[ItemID - 1] + '\n' + Item.ItemType[type - 1];
                int var10 = this.b(3, false);
                int var11 = 20 + var10;
                var4 = var4 + "\nWeapon value: " + var11;
        }

        return var4;
    }

    boolean r(int indx) {
        int item = Math.abs(this.Inventory[indx]);
        byte itemtype = Item.Type[item - 1];
        int var4 = this.P[indx] & 255;
        int var5 = var4 - 1;
        this.x = func.a(var5, this.x);
        this.y(indx);
        return true;
    }

    void a(int var1) {
        this.a(var1, GameCanvas.j);
    }

    boolean w(int var1) {
        int var2 = Math.abs(this.Inventory[var1]);
        byte var3 = Item.Type[var2 - 1];
        switch (var3) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 17:
                return true;
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            default:
                return false;
        }
    }

    boolean v(int var1) {
        int var2 = Math.abs(this.Inventory[var1]);
        byte var3 = Item.Type[var2 - 1];
        switch (var3) {
            case 13:
            case 15:
                return true;
            default:
                return false;
        }
    }

    boolean e(int var1) {
        int var2 = Math.abs(this.Inventory[var1]);
        byte var3 = Item.Type[var2 - 1];
        switch (var3) {
            case 12:
                int var4 = this.P[var1] & 255;
                byte var5 = Spell.spells[var4 - 1].School;
                if (this.CharSkills[var5][0] > 0) {
                    return true;
                }

                return false;
            default:
                return false;
        }
    }

    int GetCritAtt(int attr) {
        int var2 = this.CharCritAtt[attr];
        if (this.t(23)) {
            if (attr == 2) {
                var2 += this.b(10, false);
                if (var2 > this.CharCritAtt[3]) {
                    var2 = this.CharCritAtt[3];
                }
            } else if (attr == 6) {
                var2 += this.b(10, false);
                if (var2 > this.CharCritAtt[7]) {
                    var2 = this.CharCritAtt[7];
                }
            } else if (attr == 4) {
                var2 += this.b(10, false);
                if (var2 > this.CharCritAtt[5]) {
                    var2 = this.CharCritAtt[5];
                }
            }
        }

        return var2;
    }

    boolean x() {
        return this.C > 0;
    }

    void D() {
        this.C = this.CurDung;
        this.ao = this.l;
        this.an = this.Ka;
        this.Z = this.DirFacing;
        this.c(true);
        this.w();
        this.Q = true;
    }

    void e() {
        this.CurDung = this.ab = this.C;
        this.l = this.XPos = this.ao;
        this.Ka = this.YPos = this.an;
        this.w();
        this.Q = true;
    }

    int E() {
        int var1 = 0;

        for(int i = 0; i < 8; ++i) {
            int var3 = this.A >> i & 1;
            if (var3 != 0) {
                ++var1;
            }
        }

        return var1;
    }

    void H() {
        int var1 = this.E();
        if (var1 > 0) {
            boolean var2 = false;
            int var6;
            if (var1 == 1) {
                var6 = 1;
            } else {
                var6 = func.a(var1);
            }

            int var3 = 0;

            for(int i = 0; i < 8; ++i) {
                int var5 = this.A >> i & 1;
                if (var5 == 1) {
                    ++var3;
                    if (var3 == var6) {
                        this.A = (byte)func.c(i, this.A);
                        break;
                    }
                }
            }
        }

    }

    int c() {
        return (this.A & 1) == 1 ? 3 : 1;
    }

    Dungeon b() {
        return ESGame.dungeons[this.CurDung - 1];
    }

    void w() {
        this.b().b(this.l, this.Ka, this.DirFacing, this.ae);
    }

    String GetStatsString() {
        StringBuffer StatsString = new StringBuffer(450);
        String var2 = " ";
        String var3 = ": ";
        StatsString.append(this.CharName);
        StatsString.append('\n');
        StatsString.append(Classes[this.CharClass]);
        StatsString.append('\n');
        StatsString.append("Level ");
        StatsString.append(this.CharCritAtt[0]);
        StatsString.append(" (");
        StatsString.append(this.CharCritAtt[1]);
        StatsString.append("/10)");
        StatsString.append('\n');
        StatsString.append("Health: ");
        StatsString.append(this.GetCritAtt(2));
        StatsString.append('/');
        StatsString.append(this.CharCritAtt[3]);
        StatsString.append('\n');
        StatsString.append("Magic: ");
        StatsString.append(this.GetCritAtt(4));
        StatsString.append('/');
        StatsString.append(this.CharCritAtt[5]);
        StatsString.append('\n');
        StatsString.append("Fatigue: ");
        StatsString.append(this.GetCritAtt(6));
        StatsString.append('/');
        StatsString.append(this.CharCritAtt[7]);
        StatsString.append('\n');
        StatsString.append('\n');
        StatsString.append("Status ailments: ");
        int AilCount = 0;

        for(int i = 1; i <= 8; ++i) {
            if (this.k(i)) {
                StatsString.append('\n');
                StatsString.append(Ailments[i - 1]);
                ++AilCount;
            }
        }

        if (AilCount == 0) {
            StatsString.append('\n');
            StatsString.append("None");
        }

        StatsString.append('\n');
        StatsString.append('\n');
        StatsString.append("Gift points found: ");
        StatsString.append(this.GiftPoints);
        StatsString.append('\n');
        StatsString.append('\n');
        StatsString.append("Attributes:");
        StatsString.append('\n');

        for(int i = 0; i < 8; ++i) {
            int var7 = 2 * i;
            StatsString.append(Attributes[var7]);
            StatsString.append(var3);
            StatsString.append(this.AttLvl[var7]);
            StatsString.append('\n');
        }

        String var8 = StatsString.toString();
        System.out.println("Length of stats string is " + var8.length());
        return var8;
    }

    static Vector G() {
        Vector var0 = new Vector();

        for(int i = 0; i < 13; ++i) {
            var0.addElement(new Object());
        }

        return var0;
    }

    static String d(byte[] var0) {
        String var1 = "X = " + var0[0] + '\n';
        var1 = var1 + "Y = " + var0[1] + '\n';
        var1 = var1 + "Type = " + var0[2] + '\n';
        var1 = var1 + "ID(MSB) = " + var0[3] + '\n';
        var1 = var1 + "ID(LSB) = " + var0[4] + '\n';
        var1 = var1 + "value = " + var0[5] + '\n';
        var1 = var1 + "flags = " + var0[6] + '\n';
        return var1;
    }

    Vector GetSkillList() {
        Vector var1 = new Vector();

        for(int i = 0; i < 14; ++i) {
            if (this.CharSkills[i][0] > 0) {
                String var3 = Skills[i] + ": " + this.CharSkills[i][0];
                var1.addElement(var3);
            }
        }

        return var1;
    }

    int l(int var1) {
        int var2 = 0;

        for(int i = 0; i < 14; ++i) {
            if (this.CharSkills[i][0] > 0) {
                if (var2 == var1) {
                    return i;
                }

                ++var2;
            }
        }

        return -1;
    }

    String GetSkillString(int var1) {
        String var2 = Skills[var1] + '\n' + "Rank: " + this.CharSkills[var1][0] + '\n' + "Exp: " + this.CharSkills[var1][2] + "/10";
        return var2;
    }

    Vector J() {
        Vector var1 = new Vector();

        for(int i = 0; i < Spell.SpellCount; ++i) {
            if ((this.x & 1 << i) != 0) {
                int var3 = i + 1;
                String var4 = Spell.spells[i].Name;
                if (var3 == this.b) {
                    var4 = "R: " + var4;
                }

                var1.addElement(var4);
            }
        }

        return var1;
    }

    int B(int var1) {
        int var2 = 0;

        for(int i = 0; i < Spell.SpellCount; ++i) {
            if ((this.x & 1 << i) != 0) {
                int var4 = i + 1;
                if (var2 == var1) {
                    return i;
                }

                ++var2;
            }
        }

        return -1;
    }

    int l() {
        int var1;
        if (!Spell.ValidateSpellNum(this.b)) {
            var1 = this.B(0);
            return var1 < 0 ? 0 : var1 + 1;
        } else {
            var1 = this.b - 1;
            int var2 = var1 + 1;
            if (var2 == Spell.SpellCount) {
                var2 = 0;
            }

            while(var2 != var1) {
                if ((this.x & 1 << var2) != 0) {
                    return var2 + 1;
                }

                ++var2;
                if (var2 == Spell.SpellCount) {
                    var2 = 0;
                }
            }

            return this.b;
        }
    }

    String s(int var1) {
        String var3 = Spell.spells[var1].Name + '\n';
        var3 = var3 + Skills[Spell.spells[var1].School] + '\n';
        var3 = var3 + "Cost: " + Spell.spells[var1].Cost + '\n';
        var3 = var3 + Spell.spells[var1].Description;
        return var3;
    }

    void e(boolean var1) {
        short var2 = (short)(this.CharCritAtt[3] - this.CharCritAtt[2]);
        short var3 = (short)(this.CharCritAtt[5] - this.CharCritAtt[4]);
        short var4 = (short)(this.CharCritAtt[7] - this.CharCritAtt[6]);
        if (!var1) {
            var2 = (short)(2 * var2 / 3);
            var3 = (short)(2 * var3 / 3);
            var4 = (short)(2 * var4 / 3);
        }

        if (this.k(8)) {
            var2 = (short)(3 * var2 / 4);
            var3 = (short)(3 * var3 / 4);
            var4 = (short)(3 * var4 / 4);
        }

        short[] var10000 = this.CharCritAtt;
        var10000[2] += var2;
        var10000 = this.CharCritAtt;
        var10000[4] += var3;
        var10000 = this.CharCritAtt;
        var10000[6] += var4;
        this.s = false;
        this.L = false;
        this.I = false;
        int var5 = func.a(100);
        int var6;
        int var7;
        if (var5 <= 10) {
            for(var6 = 0; var6 < this.InventoryCount; ++var6) {
                var7 = Math.abs(this.Inventory[var6]);
                if (var7 == 96) {
                    this.y(var6);
                    break;
                }
            }
        }

        for(var6 = 0; var6 < 8; ++var6) {
            var7 = var6 + 1;
            if (var7 != 4 && var7 != 5) {
                var5 = func.a(100);
                if (var5 <= 25) {
                    this.A = (byte)func.c(var6, this.A);
                }
            }
        }

    }

    boolean k(int var1) {
        int var2 = var1 - 1;
        return (this.A & 1 << var2) != 0;
    }

    void a(int var1, Monster var2) {
        int var3 = Math.abs(this.Inventory[var1]);
        byte var4 = Item.Type[var3 - 1];
        if (var4 == 13 || var4 == 15) {
            boolean var5 = true;
            int var6;
            int var7;
            switch (var3) {
                case 87:
                    if (this.CurDung == 1 && this.x()) {
                        this.e();
                        break;
                    }

                    this.D();
                    break;
                case 88:
                    this.H();
                    break;
                case 89:
                    this.CharCritAtt[2] = this.CharCritAtt[3];
                    break;
                case 90:
                    this.CharCritAtt[4] = this.CharCritAtt[5];
                    break;
                case 91:
                    short[] var10000 = this.CharCritAtt;
                    var10000[6] = (short)(var10000[6] + 3 * this.CharCritAtt[5]);
                    break;
                case 92:
                    ++this.CharCritAtt[1];
                    break;
                case 93:
                    this.CharCritAtt[2] = this.CharCritAtt[3];
                    this.CharCritAtt[4] = this.CharCritAtt[5];
                    break;
                case 94:
                    this.s = true;
                    break;
                case 95:
                    this.L = true;
                    break;
                case 96:
                    this.I = true;
                    var5 = false;
                    break;
                case 97:
                    if (var2 != null) {
                        var6 = var2.c(4);
                        var7 = var2.c(10);
                        if (var6 <= 13 && var7 <= 13) {
                            var2.g = 0;
                            var2.d();
                        }
                    }
                    break;
                case 98:
                    if (var2 != null) {
                        var6 = var2.c(4);
                        var7 = var2.c(10);
                        if (var6 <= 22 && var7 <= 22) {
                            var2.g = 0;
                            var2.d();
                        }
                    }
                    break;
                case 99:
                    if (var2 != null) {
                        var6 = var2.c(4);
                        var7 = var2.c(10);
                        if (var6 <= 29 && var7 <= 29) {
                            var2.g = 0;
                            var2.d();
                        }
                    }
            }

            if (var5) {
                this.y(var1);
            }
        }

    }

    boolean o() {
        for(int i = 0; i < 14; ++i) {
            if (this.CharSkills[i][2] >= 10) {
                short[] var10000 = this.CharSkills[i];
                var10000[2] = (short)(var10000[2] - 10);
                ++this.CharSkills[i][0];
                short var2 = c[i];
                int var3 = var2 / 2;
                this.N = (byte)(this.N | 1 << var3);
                ++this.CharCritAtt[1];
            }
        }

        if (this.CharCritAtt[1] >= 10) {
            ++this.CharCritAtt[0];
            return true;
        } else {
            return false;
        }
    }

    void d() {
        NPC.d();
        short[] var10000 = this.CharCritAtt;
        var10000[1] = (short)(var10000[1] - 10);
    }

    String[] q() {
        Vector var1 = new Vector();

        int var3;
        for(int i = 0; i < 8; ++i) {
            if ((this.N & 1 << i) != 0) {
                var3 = i * 2;
                var1.addElement(Attributes[var3]);
            }
        }

        var3 = var1.size();
        if (var3 == 0) {
            return null;
        } else {
            String[] var4 = new String[var3];

            for(int i = 0; i < var3; ++i) {
                var4[i] = (String)var1.elementAt(i);
            }

            return var4;
        }
    }

    private void C() {
        short var1 = Item.a();
        int[] var2 = StartingGear[this.CharClass];

        for(int i = 0; i < var2.length; ++i) {
            this.c(var2[i], var1);
            int var4 = this.InventoryCount - 1;
            this.d(var4, true);
        }

    }

    void a(long var1) {
        int var3 = (int)(var1 * (long)(this.AttLvl[10] + this.AttLvl[11]) / 2000L);
        short[] var10000 = this.CharCritAtt;
        var10000[6] = (short)(var10000[6] + var3);
        if (this.CharCritAtt[6] > this.CharCritAtt[7]) {
            this.CharCritAtt[6] = this.CharCritAtt[7];
        }

    }

    private boolean a(int var1, int var2, int var3) {
        if (var1 != 1) {
            return false;
        } else if (var2 >= 6 && var2 <= 12) {
            return var3 >= 6 && var3 <= 12;
        } else {
            return false;
        }
    }

    private void p() {
        this.D();
        if (this.Q) {
            this.Q = false;
        }

    }

    int b(int var1, int var2) {
        int var3 = this.b(13, true);
        if (var2 == 3) {
            var3 += 3;
        }

        short var4 = NPC.r[var1];
        int var5 = var3 - var4;
        int var6 = 20 - var5 * 5;
        int var7 = 20 + this.AttLvl[12] / 2 + var5 * 5;
        var6 = Math.min(Math.max(var6, 10), 95);
        var7 = Math.min(Math.max(var7, 10), 95);
        int var8 = d(var7, var6);
        return var8;
    }

    private void B() {
        --this.DirFacing;
        if (this.DirFacing <= 0) {
            this.DirFacing = 4;
        }

    }

    private void a() {
        ++this.DirFacing;
        if (this.DirFacing >= 5) {
            this.DirFacing = 1;
        }

    }

    String K() {
        byte var1 = this.DirFacing;
        StringBuffer var2 = new StringBuffer(1000);
        System.out.println("here 1");
        String[] var3 = this.b().a();
        var2.append("Current dungeon is " + var3[0] + " " + var3[1] + "\n");

        for(int i = 1; i <= 4; ++i) {
            if (i <= 2) {
                this.g(i);
            } else if (i == 3) {
                this.a();
                this.g(1);
            } else if (i == 4) {
                this.B();
                this.g(1);
            }

            System.out.println("here 2, i =" + i);
            if (i == 1) {
                var2.append("FORWARD SQUARE: \n");
            } else if (i == 2) {
                var2.append("BACKWARD SQUARE: \n");
            } else if (i == 3) {
                var2.append("RIGHT SIDE SQUARE: \n");
            } else if (i == 4) {
                var2.append("LEFT SIDE SQUARE: \n");
            }

            var2.append("x,y = " + this.XPos + ", " + this.YPos + "\n");
            System.out.println("New a and y are " + this.XPos + ", " + this.YPos);
            var2.append("map value = " + this.b().DngnVec[this.XPos][this.YPos] + "\n");
            System.out.println("New dungeon id is " + this.ab);
            Hashtable var5 = ESGame.G[this.ab - 1];
            Enumeration var6;
            byte[] var7;
            if (var5 != null) {
                var6 = var5.elements();

                while(var6.hasMoreElements()) {
                    var7 = (byte[])var6.nextElement();
                    System.out.println("Found a monster");
                    if (var7[4] == this.XPos && var7[5] == this.YPos) {
                        var2.append("Found monster in square \n");
                        var2.append("type=" + var7[2] + ", health=" + var7[3] + ", dungeon id = " + var7[7] + "\n");
                    }
                }
            }

            System.out.println("here 3, i =" + i);
            var5 = ESGame.S[this.ab - 1];
            if (var5 != null) {
                var6 = var5.elements();

                while(var6.hasMoreElements()) {
                    var7 = (byte[])var6.nextElement();
                    if (var7[0] == this.XPos && var7[1] == this.YPos) {
                        var2.append("Found chest in square \n");
                        var2.append("item type=" + var7[4] + ", value=" + var7[7] + "\n");
                    }
                }
            }

            System.out.println("here 4, i =" + i);
            var6 = ESGame.au[this.ab - 1].elements();

            while(var6.hasMoreElements()) {
                var7 = (byte[])var6.nextElement();
                if (var7[0] == this.XPos && var7[1] == this.YPos) {
                    var2.append("Found dropped item in square \n");
                    var2.append("item type=" + var7[2] + ", value=" + var7[5] + " flags = " + var7[6] + "\n");
                }
            }

            this.DirFacing = var1;
        }

        if (NPC.WardenPresent) {
            var2.append("Warden IS visiting now\n");
        } else {
            var2.append("Warden IS NOT visiting now\n");
        }

        var2.append("Player inventory: nitems=" + this.InventoryCount);
        return var2.toString();
    }
}
