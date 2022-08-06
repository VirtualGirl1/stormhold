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
    static boolean GameDone = false;
    private static boolean D;
    static Vector ad = G();
    private static final Integer aj = Integer.valueOf(0);
    private static final Integer am = Integer.valueOf(1);
    private static final Integer o = Integer.valueOf(-1);
    static boolean CharLoaded = false;
    static short B;
    static short al;
    static String[] Classes;
    static String[] Races;
    static String[] Skills;
    static short[][] ClassPreset;
    static String[] CritAtt;
    static String[] Attributes;
    static short[] SkillTies;
    static int[][] StartingGear = new int[][]{{1, 27}, {7, 27}, {7, 22}, {17, 27}, {12, 22}, {17, 27}, {12, 22}};
    private static final String[] AilmentStr = new String[]{"Stone Blood", "Delusions", "Blind", "Vampirism", "Mana Burn", "Grievous Harm", "Terrified", "Haunted"};
    public static int ag = -1;
    ESGame Game;
    public static String UsrID = null;
    String CharName;
    short CharClass;
    short CharRace;
    short[] CharCritAtt;
    byte AttIncreases;
    int n;
    short[] AttLvl;
    short MagicModifier;
    short[] aq;
    short[][] CharSkills;
    byte InventoryCount;
    byte[] Inventory;
    int[] P;
    byte[] Equiped;
    int KnownSpells;
    byte CurSpell;
    short GiftPoints;
    short Y;
    short m;
    byte Ailments;
    short ah;
    short F;
    short ap;
    boolean f;
    byte CurDung;
    byte XPos;
    byte YPos;
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
    byte NewXPos;
    byte NewYPos;
    byte NewDirection;
    byte NextDung;
    boolean i;
    boolean Q;
    boolean EnteringWC;
    boolean EnteringOC;
    byte[][] ae;
    byte OldXPos;
    byte OldYPos;

    int DataLen(boolean encode) {
        return encode ? 400 : 200;
    }

    public Character(ESGame game) {
        GameDone = false;
        LoadCharData();
        this.CharName = null;
        this.CharCritAtt = new short[10];
        this.AttLvl = new short[16];
        this.aq = new short[2];
        this.CharSkills = new short[14][3];
        this.InventoryCount = 0;
        this.Inventory = new byte[24];
        this.P = new int[24];
        this.Equiped = new byte[7];
        this.G = new byte[25];
        this.ae = new byte[9][5];
        this.Game = game;
        this.Q = false;
    }

    void Recover(short[] arr) {
        arr[2] = arr[3]; // full health
        arr[4] = arr[5]; // full magic
        arr[6] = arr[7]; // full fatigue
        arr[8] = 0; // reset corruption
    }

    void LoadClassDefaults(int clss) {
        this.CharClass = (short)clss;
        this.CharRace = ClassPreset[this.CharClass][1];
        byte AttCount = 8;

        int AttIndx;
        for(int i = 0; i < AttCount; ++i) {
            AttIndx = 2 * i;
            this.AttLvl[AttIndx] = ClassPreset[this.CharClass][2 + i];
            this.AttLvl[AttIndx + 1] = 0;
        }

        this.MagicModifier = ClassPreset[this.CharClass][10];
        this.aq[0] = ClassPreset[this.CharClass][11];
        this.aq[1] = ClassPreset[this.CharClass][12];
        this.CharCritAtt[0] = 1; // Level
        this.CharCritAtt[1] = 0; // Level XP
        this.CalcAttributesMax();
        this.CharCritAtt[2] = this.CharCritAtt[3]; // full health
        this.CharCritAtt[4] = this.CharCritAtt[5]; // full magicka
        this.CharCritAtt[6] = this.CharCritAtt[7]; // full fatigue
        this.CharCritAtt[8] = 0; // Corruption
        this.CharCritAtt[9] = 0; // Corruption Progress
        this.AttIncreases = 0;
        this.n = 0;
        AttIndx = 13;

        for(int i = 0; i < 14; ++i) {
            this.CharSkills[i][0] = ClassPreset[this.CharClass][AttIndx++];
            this.CharSkills[i][1] = ClassPreset[this.CharClass][AttIndx++];
            this.CharSkills[i][2] = 0;
        }

        for(int i = 0; i < 24; ++i) {
            this.Inventory[i] = 0;
            this.P[i] = 0;
        }

        for(int i = 0; i < 7; ++i) {
            this.Equiped[i] = 0;
        }

        this.KnownSpells = this.GetDefaultSpells();
    }

    void CalcAttributesMax() {
        this.CharCritAtt[3] = (short)((this.AttLvl[0] + this.AttLvl[10]) / 2);
        this.CharCritAtt[5] = (short)(this.MagicModifier * this.AttLvl[2] / 4);
        this.CharCritAtt[7] = (short)(this.AttLvl[0] + this.AttLvl[4] + this.AttLvl[6] + this.AttLvl[10]);
    }

    private int GetDefaultSpells() {
        int defaultsplls = 0;
        int SkillOffset = 13;
        boolean var3 = true;
        boolean first = true;

        for(int i = 0; i < 14; ++i) {
            short SkillRank = ClassPreset[this.CharClass][SkillOffset++];
            short SkillLevel = ClassPreset[this.CharClass][SkillOffset++];
            byte spllindx;
            switch (i) {
                case 1:
                    spllindx = 0;
                    break;
                case 2:
                case 5:
                case 7:
                case 8:
                case 9:
                default:
                    spllindx = -1;
                    break;
                case 3:
                    spllindx = 5;
                    break;
                case 4:
                    spllindx = 10;
                    break;
                case 6:
                    spllindx = 15;
                    break;
                case 10:
                    spllindx = 20;
            }

            if (spllindx != -1 && SkillRank > 0) {
                defaultsplls |= 1 << spllindx;
                if (first) {
                    this.CurSpell = (byte)(spllindx + 1);
                    first = false;
                }
            }
        }

        return defaultsplls;
    }

    public void InitDefaultChar(int clss) {
        this.ResetChar(clss, false);
    }

    public void ResetChar(int clss, boolean respawn) {
        if (!respawn) {
            this.GiftPoints = 0;
            this.Y = 0;
            this.m = 0;
        }

        this.Ailments = 0;
        this.ah = 0;
        this.F = 0;
        this.ap = 0;
        this.f = false;
        this.TeleportPlayer(respawn);
        this.w();
        if (!respawn) {
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
        if (!respawn) {
            this.C();
        }

    }

    private void TeleportPlayer(boolean teleport) {
        if (!teleport) {
            this.CurDung = this.NextDung = 1;
            this.XPos = this.NewXPos = 9;
            this.YPos = this.NewYPos = 10;
            this.DirFacing = this.NewDirection = 1;
        } else {
            this.CurDung = this.NextDung = 1;
            this.XPos = this.NewXPos = 12;
            this.YPos = this.NewYPos = 14;
            this.DirFacing = this.NewDirection = 1;
        }

    }

    String GetClassInfoStr() {
        StringBuffer str = new StringBuffer(300);
        String SpcStr = " ";
        String ColStr = ": ";
        str.append(Races[this.CharRace]);
        str.append(SpcStr);
        str.append(Classes[this.CharClass]);
        str.append('\n');
        str.append(CritAtt[0]);
        str.append(ColStr);
        str.append(this.CharCritAtt[0]);
        str.append('\n');
        str.append(CritAtt[2]);
        str.append(ColStr);
        str.append(this.GetCritAtt(2));
        str.append('\n');
        str.append(CritAtt[4]);
        str.append(ColStr);
        str.append(this.GetCritAtt(4));
        str.append('\n');
        str.append(CritAtt[6]);
        str.append(ColStr);
        str.append(this.GetCritAtt(6));
        str.append('\n');

        int var5;
        for(int i = 0; i < 8; ++i) {
            var5 = 2 * i;
            str.append(Attributes[var5]);
            str.append(ColStr);
            str.append(this.AttLvl[var5]);
            str.append('\n');
        }

        for(var5 = 0; var5 < 14; ++var5) {
            if (this.CharSkills[var5][0] > 0) {
                str.append(Skills[var5]);
                str.append(ColStr);
                str.append(this.CharSkills[var5][0]);
                str.append('\n');
            }
        }

        String var6 = str.toString();
        return var6;
    }

    static void LoadCharData() {
        if (!CharLoaded) {
            try {
                LoadCharData("/charin.dat");
                CharLoaded = true;
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
            SkillTies = new short[skillslen];

            for(int i = 0; i < skillslen; ++i) {
                SkillTies[i] = data.readShort();
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
            NewChar.LoadClassDefaults(NewChar.CharClass);
            NewChar.InitDefaultChar(NewChar.CharClass);
        }

        NewChar.CharRace = data.readShort();

        for(int i = 0; i < 10; ++i) {
            NewChar.CharCritAtt[i] = data.readShort();
        }

        if (var1) {
            NewChar.AttIncreases = data.readByte();
        }

        NewChar.n = data.readInt();

        for(int i = 0; i < 16; ++i) {
            NewChar.AttLvl[i] = data.readShort();
        }

        NewChar.MagicModifier = data.readShort();
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
                NewChar.Equiped[var9] = data.readByte();
            }

            NewChar.KnownSpells = data.readInt();
            NewChar.CurSpell = data.readByte();
        } else {
            NewChar.KnownSpells = data.readInt();
        }

        if (var1) {
            NewChar.GiftPoints = data.readShort();
            NewChar.Y = data.readShort();
            NewChar.m = data.readShort();
            NewChar.Ailments = data.readByte();
            NewChar.ah = data.readShort();
            NewChar.F = data.readShort();
            NewChar.ap = data.readShort();
            NewChar.f = data.readBoolean();
            NewChar.CurDung = data.readByte();
            NewChar.XPos = data.readByte();
            NewChar.YPos = data.readByte();
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

    byte[] EncodeCharData(boolean EncodeCrit) throws Exception {
        int arrLen = this.DataLen(EncodeCrit);
        ByteArrayOutputStream btStream = new ByteArrayOutputStream(arrLen);
        DataOutputStream data = new DataOutputStream(btStream);
        data.writeUTF(this.CharName);
        data.writeShort(this.CharClass);
        data.writeShort(this.CharRace);
        int i;
        int j;
        int k;
        if (EncodeCrit) {
            for(i = 0; i < 10; ++i) {
                data.writeShort(this.CharCritAtt[i]);
            }

            data.writeByte(this.AttIncreases);
        } else {
            short[] var10 = new short[10];

            for(j = 0; j < 10; ++j) {
                var10[j] = this.CharCritAtt[j];
            }

            this.Recover(var10);

            for(k = 0; k < 10; ++k) {
                data.writeShort(var10[k]);
            }
        }

        data.writeInt(this.n);

        for(i = 0; i < 16; ++i) {
            data.writeShort(this.AttLvl[i]);
        }

        data.writeShort(this.MagicModifier);
        data.writeShort(this.aq[0]);
        data.writeShort(this.aq[1]);

        for(j = 0; j < 14; ++j) {
            for(k = 0; k < 3; ++k) {
                data.writeShort(this.CharSkills[j][k]);
            }
        }

        if (EncodeCrit) {
            data.writeByte(this.InventoryCount);

            for(k = 0; k < 24; ++k) {
                data.writeByte(this.Inventory[k]);
            }

            for(int var8 = 0; var8 < 24; ++var8) {
                data.writeInt(this.P[var8]);
            }

            for(int var9 = 0; var9 < 7; ++var9) {
                data.writeByte(this.Equiped[var9]);
            }

            data.writeInt(this.KnownSpells);
            data.writeByte(this.CurSpell);
        } else {
            k = this.GetDefaultSpells();
            data.writeInt(k);
        }

        if (EncodeCrit) {
            data.writeShort(this.GiftPoints);
            data.writeShort(this.Y);
            data.writeShort(this.m);
            data.writeByte(this.Ailments);
            data.writeShort(this.ah);
            data.writeShort(this.F);
            data.writeShort(this.ap);
            data.writeBoolean(this.f);
            data.writeByte(this.CurDung);
            data.writeByte(this.XPos);
            data.writeByte(this.YPos);
            data.writeByte(this.DirFacing);
            data.writeByte(this.C);
            data.writeByte(this.ao);
            data.writeByte(this.an);
            data.writeByte(this.Z);

            for(k = 0; k < 25; ++k) {
                data.writeByte(this.G[k]);
            }

            data.writeShort(this.t);
            data.writeShort(this.aa);
            data.writeBoolean(this.s);
            data.writeBoolean(this.L);
            data.writeBoolean(this.I);
        }

        byte[] var11 = btStream.toByteArray();
        return var11;
    }

    void Move(int dir) {
        byte mv = -1;
        switch (dir) {
            case GD.DIR_FORWARD:
                mv = 1;
            case GD.DIR_BACK:
                this.NewDirection = this.DirFacing;
                if (this.DirFacing == GD.DIR_NORTH) {
                    this.NewXPos = this.XPos;
                    this.NewYPos = (byte)(this.YPos - mv);
                } else if (this.DirFacing == GD.DIR_SOUTH) {
                    this.NewXPos = this.XPos;
                    this.NewYPos = (byte)(this.YPos + mv);
                } else if (this.DirFacing == GD.DIR_EAST) {
                    this.NewXPos = (byte)(this.XPos + mv);
                    this.NewYPos = this.YPos;
                } else if (this.DirFacing == GD.DIR_WEST) {
                    this.NewXPos = (byte)(this.XPos - mv);
                    this.NewYPos = this.YPos;
                }

                Dungeon curdung = ESGame.dungeons[this.CurDung - 1];
                Dungeon nextdung;
                if (this.NewXPos < 0) {
                    this.i = true;
                    this.NextDung = curdung.Geomin[3];
                    nextdung = ESGame.dungeons[this.NextDung - 1];
                    if (this.NextDung != 1 && this.CurDung != 1) {
                        this.NewXPos = (byte)(nextdung.Width - 1);
                    } else {
                        this.NewXPos = (byte)(nextdung.Width - 1);
                        this.NewYPos = (byte)(this.NewYPos + (nextdung.Height - curdung.Height) / 2);
                    }
                } else if (this.NewXPos >= curdung.Width) {
                    this.i = true;
                    this.NextDung = curdung.Geomin[1];
                    nextdung = ESGame.dungeons[this.NextDung - 1];
                    if (this.NextDung != 1 && this.CurDung != 1) {
                        this.NewXPos = 0;
                    } else {
                        this.NewXPos = 0;
                        this.NewYPos = (byte)(this.NewYPos + (nextdung.Height - curdung.Height) / 2);
                    }
                } else if (this.NewYPos < 0) {
                    this.i = true;
                    this.NextDung = curdung.Geomin[0];
                    nextdung = ESGame.dungeons[this.NextDung - 1];
                    if (this.NextDung != 1 && this.CurDung != 1) {
                        this.NewYPos = (byte)(nextdung.Height - 1);
                    } else {
                        this.NewXPos = (byte)(this.NewXPos + (nextdung.Width - curdung.Width) / 2);
                        this.NewYPos = (byte)(nextdung.Height - 1);
                    }
                } else if (this.NewYPos >= curdung.Height) {
                    this.i = true;
                    this.NextDung = ESGame.dungeons[this.CurDung - 1].Geomin[2];
                    nextdung = ESGame.dungeons[this.NextDung - 1];
                    if (this.NextDung != 1 && this.CurDung != 1) {
                        this.NewYPos = 0;
                    } else {
                        this.NewXPos = (byte)(this.NewXPos + (nextdung.Width - curdung.Width) / 2);
                        this.NewYPos = 0;
                    }
                } else {
                    this.i = false;
                    this.NextDung = this.CurDung;
                }
                break;
            case GD.DIR_RIGHT: // turn right
                this.NextDung = this.CurDung;
                this.i = false;
                this.NewDirection = (byte)(this.DirFacing + 1);
                if (this.NewDirection > 4) {
                    this.NewDirection = 1;
                }

                this.NewXPos = this.XPos;
                this.NewYPos = this.YPos;
                break;
            case GD.DIR_LEFT: // turn left
                this.NextDung = this.CurDung;
                this.i = false;
                this.NewDirection = (byte)(this.DirFacing - 1);
                if (this.NewDirection < 1) {
                    this.NewDirection = 4;
                }

                this.NewXPos = this.XPos;
                this.NewYPos = this.YPos;
        }

    }

    boolean Move(int dir, boolean strafe) {
        Dungeon dung = this.GetCurrentDungeon();
        dung.a(this.XPos, this.YPos);
        if (this.CharCritAtt[6] <= 0) {
            return false;
        } else {
            boolean var4 = false;
            boolean var5;
            if (strafe && dir == GD.DIR_LEFT) { // Strafe left
                this.q(4);
                var5 = this.q(1);
                var4 = this.i;
                var5 = this.q(3);
                this.i = var4;
                return var5;
            } else if (strafe && dir == GD.DIR_RIGHT) { // strafe right
                this.q(3);
                var5 = this.q(1);
                var4 = this.i;
                var5 = this.q(4);
                this.i = var4;
                return var5;
            } else {
                return this.q(dir);
            }
        }
    }

    boolean q(int var1) {
        if (this.CharCritAtt[6] <= 0) {
            return false;
        } else if (var1 == 0) {
            return false;
        } else {
            this.Move(var1);
            boolean var2 = false;
            if (var1 == 1 || var1 == 2) {
                var2 = true;
            }

            if (this.NextDung <= 0) {
                return false;
            } else {
                Dungeon dung = ESGame.dungeons[this.NextDung - 1];
                if (!dung.k) {
                    return false;
                } else {
                    byte var4 = dung.DngnVec[this.NewXPos][this.NewYPos];
                    if (!this.a(var4)) {
                        return false;
                    } else {
                        if (this.NextDung == 37 && this.CurDung != 37) {
                            Enumeration var5 = ESGame.MonsterTables[this.NextDung - 1].elements();

                            while(var5.hasMoreElements()) {
                                byte[] var6 = (byte[])var5.nextElement();
                                Monster mon = Monster.a(var6);
                                if (mon.MonNum == 41) {
                                    mon.Health = (byte)mon.GetMonAtt(14);
                                    mon.d();
                                }
                            }

                            var5 = null;
                        }

                        if (!this.a(this.CurDung, this.XPos, this.YPos) && this.a(this.NextDung, this.NewXPos, this.NewYPos)) {
                            this.EnteringWC = true;
                        } else {
                            this.EnteringWC = false;
                        }

                        if (this.a(this.CurDung, this.XPos, this.YPos) && !this.a(this.NextDung, this.NewXPos, this.NewYPos)) {
                            this.EnteringOC = true;
                        } else {
                            this.EnteringOC = false;
                        }

                        this.CurDung = this.NextDung;
                        this.OldXPos = this.XPos;
                        this.OldYPos = this.YPos;
                        this.XPos = this.NewXPos;
                        this.YPos = this.NewYPos;
                        this.DirFacing = this.NewDirection;
                        dung.h = true;
                        if (var1 == 1 || var1 == 2) {
                            if (NPC.l) {
                                NPC.l = false;
                            }

                            short[] var10000 = this.CharCritAtt;
                            var10000[6] = (short)(var10000[6] - 1 * this.HasStoneBlood());
                            this.CharCritAtt[6] = (short)Math.max(this.CharCritAtt[6], 0);
                        }

                        boolean var12 = (var4 & 4) != 0;
                        if (var12) {
                            int var13 = dung.f(this.XPos, this.YPos);
                            if (var13 == 1) {
                                byte[] var14 = dung.e(this.XPos, this.YPos);
                                if ((var14[6] & 4) != 0) {
                                    GameDone = true;
                                    this.w();
                                    return true;
                                }

                                System.out.println(">>>>>>Found a dropped item item: " + DroppedItemData(var14));
                                boolean var8 = this.c(var14);
                                if (var8) {
                                    dung.d(var14);
                                    if ((var14[6] & 2) == 0) {
                                        System.out.println("Dropped item not possessed before");
                                        int indx = var14[2] - 1;
                                        System.out.println("item index=" + indx);
                                        if (Item.Type[indx] == 11) {
                                            this.GiftPoints += (short) Item.Level[indx];
                                            int var10 = ESGame.GetGameAdvLevel(this.GiftPoints);
                                            this.Game.PopulateDungeons(var10);
                                        }
                                    }
                                }
                            } else if (var13 > 1) {
                                System.out.println("Found several items in square");
                                Vector var15 = dung.b(this.XPos, this.YPos);
                                Enumeration var16 = var15.elements();

                                while(var16.hasMoreElements()) {
                                    byte[] var17 = (byte[])var16.nextElement();
                                    if ((var17[6] & 4) != 0) {
                                        GameDone = true;
                                        this.w();
                                        return true;
                                    }

                                    boolean var18 = this.c(var17);
                                    if (var18) {
                                        dung.d(var17);
                                        if ((var17[6] & 2) != 0) {
                                            int indx = var17[2] - 1;
                                            System.out.println("item index=" + indx);
                                            if (Item.Type[indx] == 11) {
                                                this.GiftPoints += (short) Item.Level[indx];
                                                this.Game.PopulateDungeons(ESGame.GetGameAdvLevel(this.GiftPoints));
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

    void a(Monster mon) {
        this.t = mon.a;
        byte var2 = mon.MonNum;
        int var3 = this.h(true);
        int var4 = mon.GetMonAtt(7);
        int var5 = var3 - var4;
        var5 = Math.min(var5, mon.GetMonAtt(2));
        if (this.t(10)) {
            if (mon.c[8] == 0) {
                this.x(10);
            } else {
                var5 += mon.c[8];
            }
        }

        int var6 = mon.GetMonAtt(6) - var5 * 5;
        int var7 = this.s() + var5 * 5;
        var6 = Math.min(Math.max(var6, 10), 95);
        var7 = Math.min(Math.max(var7, 10), 95);
        int var8 = d(var7, var6);
        if (var8 != 0) {
            int var9 = this.z();
            int var10 = mon.GetMonAtt(8);
            if (this.t(13)) {
                if (mon.c[5] == 0) {
                    this.G[12] = 0;
                } else {
                    var10 -= mon.c[5];
                }
            }

            if (var8 == 1) {
                var10 = 2 * var10;
            } else if (var8 == 3) {
                var9 = 2 * var9;
            }

            int var11 = var9 - var10;
            var11 = Math.max(var11, 4);
            int var12 = var11 * mon.GetMonAtt(14) / 100;
            mon.b(var12);
            mon.d();
            if (this.t(7)) {
                if (mon.c[1] == 0) {
                    this.x(7);
                } else {
                    byte var14 = mon.c[1];
                    var11 = Math.max(var14, 4);
                    var12 = var11 * mon.GetMonAtt(14) / 100;
                    mon.b(var12);
                }
            }

            if (var8 >= 2) {
                this.a(this.F(), 1);
            }

            short[] var10000;
            if (!this.t(7)) {
                var10000 = this.CharCritAtt;
                var10000[6] = (short)(var10000[6] - 7 * this.HasStoneBlood());
                this.CharCritAtt[6] = (short)Math.max(this.CharCritAtt[6], 0);
            }

            if (this.GetAilment(6)) {
                int var13 = 2 * this.CharCritAtt[3] / 100;
                if (var13 < 1) {
                    var13 = 1;
                }

                var10000 = this.CharCritAtt;
                var10000[2] -= (short)var13;
            }

        }
    }

    int b(Object obj1) {
        boolean var2 = false;
        boolean var3 = false;
        Object obj2 = null;
        int var5 = Integer.MAX_VALUE;
        byte[] var9 = (byte[])obj1;
        byte var7;
        byte var8;
        if (var9.length == 28) {
            Monster mon = Monster.a(var9);
            var7 = mon.XPos;
            var8 = mon.YPos;
        } else {
            var7 = var9[0];
            var8 = var9[1];
        }

        if (this.DirFacing == 1) {
            var5 = this.YPos - var8;
        } else if (this.DirFacing == 3) {
            var5 = var8 - this.YPos;
        } else if (this.DirFacing == 2) {
            var5 = var7 - this.XPos;
        } else {
            var5 = this.XPos - var7;
        }

        if (var5 < 0) {
            var5 = Integer.MAX_VALUE;
        }

        return var5;
    }

    void b(int var1, Object obj1) {
        Object obj2 = null;
        String var4 = null;
        byte[] var6;
        switch (var1) {
            case 1:
                var6 = (byte[])obj1;
                var6[6] = 1;
                Monster mon = Monster.a(var6);
                var4 = String.valueOf(mon.a);
                mon.ia = true;
                mon.d();
                break;
            case 2:
                var6 = (byte[])obj1;
                var6[6] = (byte)(var6[6] | 1);
        }

    }

    void d(boolean var1) {
        this.i();
        Vector ditable = ESGame.DroppedItemsTables[this.CurDung - 1];
        if (ditable != null) {
            Enumeration var3 = ditable.elements();

            while(var3.hasMoreElements()) {
                byte[] var4 = (byte[])var3.nextElement();
                this.a(2, var4, var1);
            }
        }

        Hashtable chesttable = ESGame.ChestTables[this.CurDung - 1];
        if (chesttable != null) {
            Enumeration var8 = chesttable.elements();

            while(var8.hasMoreElements()) {
                byte[] var5 = (byte[])var8.nextElement();
                this.a(4, var5, var1);
            }
        }

        Hashtable montable = ESGame.MonsterTables[this.CurDung - 1];
        if (montable != null) {
            Enumeration var10 = montable.elements();

            while(var10.hasMoreElements()) {
                byte[] var6 = (byte[])var10.nextElement();
                this.a(1, var6, var1);
            }
        }

        if (this.CurDung == 1 && NPC.WardenPresent) {
            this.a(5, (Object)"W");
        }

    }

    boolean a(int var1, Object obj1, boolean var3) {
        Object obj2 = null;
        Object obj3 = null;
        boolean var6 = false;
        boolean var7 = false;
        boolean var8 = false;
        int var9 = this.b(obj1);
        boolean var10 = this.a(var1, obj1);
        if (!var10) {
            return false;
        } else if (var1 != 4 && var9 != 1) {
            this.b(var1, obj1);
            return true;
        } else {
            this.b(var1, obj1);
            return true;
        }
    }

    void i() {
        Dungeon dung = this.GetCurrentDungeon();
        boolean var2 = false;

        for(int i = 0; i < 13; ++i) {
            ad.setElementAt(aj, i);
        }

        byte var5 = dung.a(-1, 1, this.ae);
        if (func.a((byte)1, var5)) {
            ad.setElementAt(am, 0);
        }

        var5 = dung.a(0, 1, this.ae);
        if (func.a((byte)1, var5)) {
            ad.setElementAt(am, 1);
        }

        var5 = dung.a(1, 1, this.ae);
        if (func.a((byte)1, var5)) {
            ad.setElementAt(am, 2);
        }

        var5 = dung.a(-2, 2, this.ae);
        if (func.a((byte)1, var5)) {
            ad.setElementAt(am, 3);
        }

        var5 = dung.a(-1, 2, this.ae);
        if (func.a((byte)1, var5)) {
            ad.setElementAt(am, 4);
        }

        var5 = dung.a(0, 2, this.ae);
        if (func.a((byte)1, var5)) {
            ad.setElementAt(am, 5);
        }

        var5 = dung.a(1, 2, this.ae);
        if (func.a((byte)1, var5)) {
            ad.setElementAt(am, 6);
        }

        var5 = dung.a(2, 2, this.ae);
        if (func.a((byte)1, var5)) {
            ad.setElementAt(am, 7);
        }

        var5 = dung.a(-2, 3, this.ae);
        if (func.a((byte)1, var5)) {
            ad.setElementAt(am, 8);
        }

        var5 = dung.a(-1, 3, this.ae);
        if (func.a((byte)1, var5)) {
            ad.setElementAt(am, 9);
        }

        var5 = dung.a(0, 3, this.ae);
        if (func.a((byte)1, var5)) {
            ad.setElementAt(am, 10);
        }

        var5 = dung.a(1, 3, this.ae);
        if (func.a((byte)1, var5)) {
            ad.setElementAt(am, 11);
        }

        var5 = dung.a(2, 3, this.ae);
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

    boolean a(int var1, Object obj1) {
        Dungeon dung = this.GetCurrentDungeon();
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        Object obj5 = null;
        boolean var8 = false;
        boolean var9 = false;
        byte var15;
        byte var16;
        if (var1 == 1) {
            byte[] var12 = (byte[])obj1;
            var15 = var12[4];
            var16 = var12[5];
        } else if (var1 == 4) {
            byte[] var14 = (byte[])obj1;
            var15 = var14[0];
            var16 = var14[1];
        } else if (var1 == 5) {
            var15 = NPC.NPCXPos[6];
            var16 = NPC.NPCYPos[6];
        } else {
            byte[] var13 = (byte[])obj1;
            var15 = var13[0];
            var16 = var13[1];
        }

        int[] var10 = dung.a(this.XPos, this.YPos, this.DirFacing, var15, var16);
        boolean var11 = false;
        if (a(var10[0], var10[1], 3, 2)) {
            var11 = true;
            ad.setElementAt(obj1, 1);
        } else if (a(var10[0], var10[1], 2, 1)) {
            if (!IsOne(ad.elementAt(0)) && !IsOne(ad.elementAt(1)) && !IsOne(ad.elementAt(5))) {
                var11 = true;
                ad.setElementAt(obj1, 4);
            }
        } else if (a(var10[0], var10[1], 3, 1)) {
            if (!IsOne(ad.elementAt(1))) {
                var11 = true;
                ad.setElementAt(obj1, 5);
            }
        } else if (a(var10[0], var10[1], 4, 1)) {
            if (!IsOne(ad.elementAt(1)) && !IsOne(ad.elementAt(2)) && !IsOne(ad.elementAt(5))) {
                var11 = true;
                ad.setElementAt(obj1, 6);
            }
        } else if (a(var10[0], var10[1], 1, 0)) {
            if (!IsOne(ad.elementAt(0)) && !IsOne(ad.elementAt(1)) && !IsOne(ad.elementAt(3)) && !IsOne(ad.elementAt(4)) && !IsOne(ad.elementAt(9))) {
                var11 = true;
                ad.setElementAt(obj1, 8);
            }
        } else if (a(var10[0], var10[1], 2, 0)) {
            if (!IsOne(ad.elementAt(0)) && !IsOne(ad.elementAt(1)) && !IsOne(ad.elementAt(4)) && !IsOne(ad.elementAt(5)) && !IsOne(ad.elementAt(10))) {
                var11 = true;
                ad.setElementAt(obj1, 9);
            }
        } else if (a(var10[0], var10[1], 3, 0)) {
            if (!IsOne(ad.elementAt(1)) && !IsOne(ad.elementAt(5))) {
                var11 = true;
                ad.setElementAt(obj1, 10);
            }
        } else if (a(var10[0], var10[1], 4, 0)) {
            if (!IsOne(ad.elementAt(1)) && !IsOne(ad.elementAt(2)) && !IsOne(ad.elementAt(5)) && !IsOne(ad.elementAt(6)) && !IsOne(ad.elementAt(10))) {
                var11 = true;
                ad.setElementAt(obj1, 11);
            }
        } else if (a(var10[0], var10[1], 5, 0) && !IsOne(ad.elementAt(1)) && !IsOne(ad.elementAt(2)) && !IsOne(ad.elementAt(6)) && !IsOne(ad.elementAt(7)) && !IsOne(ad.elementAt(11))) {
            var11 = true;
            ad.setElementAt(obj1, 12);
        }

        return var11;
    }

    private static boolean a(int var0, int var1, int var2, int var3) {
        return var0 == var2 && var1 == var3;
    }

    private static boolean IsOne(Object obj) {
        if (obj instanceof Integer) {
            Integer num = (Integer)obj;
            if (num == 1) {
                return true;
            }

            if (num == -1) {
                return true;
            }
        }

        return false;
    }

    void a(byte[] var1) {
        Dungeon dung = ESGame.dungeons[this.CurDung - 1];
        dung.c(var1);
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

    int GetSkillVal(int skill, boolean getbonus) {
        int skllRnk = this.CharSkills[skill][0];
        if (getbonus) { // get skill bonus
            int attindx = 1 + SkillTies[skill];
            skllRnk += this.AttLvl[attindx] / 3;
        }

        if (skill == 11 && this.t(3)) {
            skllRnk += this.CharSkills[1][0];
        }

        if (this.CharCritAtt[6] < 7) {
            --skllRnk;
        }

        return skllRnk;
    }

    int GetSkillLevel(int Skill) {
        short lvl = this.CharSkills[Skill][1];
        return lvl;
    }

    int f(boolean var1) {
        if (this.Equiped[1] != 0) {
            int var2 = Item.GetItemProperty(1, this.Equiped[1]);
            var2 = Math.abs(var2);
            return var2 == 5 ? this.GetSkillVal(5, var1) : this.GetSkillVal(7, var1);
        } else {
            return 0;
        }
    }

    int I() {
        if (this.Equiped[1] != 0) {
            int var1 = Item.GetItemProperty(1, this.Equiped[1]);
            var1 = Math.abs(var1);
            return var1 == 5 ? this.GetSkillLevel(5) : this.GetSkillLevel(7);
        } else {
            return 20;
        }
    }

    int t() {
        byte var1 = 0;
        int var2 = this.GetSkillVal(0, false);
        int var3 = this.GetSkillVal(2, false);
        if (var3 > var2) {
            var2 = var3;
            var1 = 2;
        }

        var3 = this.GetSkillVal(8, false);
        if (var3 > var2) {
            var2 = var3;
            var1 = 8;
        }

        var3 = this.GetSkillVal(12, false);
        if (var3 > var2) {
            var1 = 12;
        }

        return var1;
    }

    int F() {
        if (this.t(6)) {
            return this.t();
        } else if (this.Equiped[0] != 0) {
            int var1 = Item.GetItemProperty(1, this.Equiped[0]);
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
            return 5 + this.GetSkillVal(4, false);
        } else {
            int var4;
            if (this.t(6)) {
                var4 = this.t();
                return this.GetSkillVal(var4, var1);
            } else {
                boolean var2 = false;
                if (this.Equiped[0] != 0) {
                    int var3 = Item.GetItemProperty(1, this.Equiped[0]);
                    var3 = Math.abs(var3);
                    if (var3 == 1) {
                        var4 = this.GetSkillVal(0, var1);
                    } else if (var3 == 2) {
                        var4 = this.GetSkillVal(2, var1);
                    } else if (var3 == 3) {
                        var4 = this.GetSkillVal(8, var1);
                    } else {
                        var4 = this.GetSkillVal(12, var1);
                    }
                } else {
                    var4 = 0;
                }

                if (this.t(5)) {
                    var4 += this.GetSkillVal(1, false);
                }

                return var4;
            }
        }
    }

    int s() {
        int var1;
        if (!this.t(6) && !this.t(14)) {
            if (this.Equiped[0] != 0) {
                var1 = Item.GetItemProperty(1, this.Equiped[0]);
                var1 = Math.abs(var1);
                if (var1 == 1) {
                    return this.GetSkillLevel(0);
                } else if (var1 == 2) {
                    return this.GetSkillLevel(2);
                } else {
                    return var1 == 3 ? this.GetSkillLevel(8) : this.GetSkillLevel(12);
                }
            } else {
                return 20;
            }
        } else {
            var1 = this.t();
            return this.GetSkillLevel(var1);
        }
    }

    int z() {
        boolean var1 = false;
        int var2;
        if (this.t(14)) {
            var2 = 5 + this.GetSkillVal(4, false);
        } else if (this.t(6)) {
            var2 = 20 + this.GetSkillVal(3, false);
        } else if (this.Equiped[0] != 0) {
            var2 = Item.GetItemProperty(3, this.Equiped[0]);
        } else {
            var2 = 0;
        }

        if (this.t(1)) {
            var2 += 10 + this.GetSkillVal(1, false);
        }

        if (this.s) {
            var2 += 25;
        }

        return var2;
    }

    int y() {
        if (this.Equiped[1] != 0) {
            int var1 = Item.GetItemProperty(1, this.Equiped[1]);
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
        if (this.Equiped[1] != 0) {
            var3 = Item.GetItemProperty(3, this.Equiped[1]);
            var1 += 4 * var3;
        }

        if (this.Equiped[2] != 0) {
            var3 = Item.GetItemProperty(3, this.Equiped[2]);
            var1 += 2 * var3;
        }

        if (this.Equiped[3] != 0) {
            var3 = Item.GetItemProperty(3, this.Equiped[3]);
            var1 += 2 * var3;
        }

        if (this.Equiped[4] != 0) {
            var3 = Item.GetItemProperty(3, this.Equiped[4]);
            var1 += var3;
        }

        if (this.Equiped[5] != 0) {
            var3 = Item.GetItemProperty(3, this.Equiped[5]);
            var1 += var3;
        }

        var1 /= 10;
        if (this.t(2)) {
            var1 += 10 + this.GetSkillVal(1, false);
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
            int indx = var7 - 1;
            System.out.println("item index=" + indx);
            if (Item.Type[indx] == 11) {
                this.GiftPoints += (short) Item.Level[indx];
                int var6 = ESGame.GetGameAdvLevel(this.GiftPoints);
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
        this.Move(1);
        if (this.NextDung <= 0) {
            return null;
        } else {
            Dungeon dung = ESGame.dungeons[this.NextDung - 1];
            Monster mon = dung.c(this.NewXPos, this.NewYPos);
            if (mon != null) {
                mon.c();
            }

            return mon;
        }
    }

    byte[] h() {
        this.Move(1);
        if (this.NextDung <= 0) {
            return null;
        } else {
            byte var1 = this.NextDung;
            Hashtable chesttable = ESGame.ChestTables[var1 - 1];
            if (chesttable == null) {
                return null;
            } else {
                Object obj = chesttable.get(func.b(this.NewXPos, this.NewYPos));
                if (obj == null) {
                    return null;
                } else {
                    byte[] var4 = (byte[])obj;
                    return var4;
                }
            }
        }
    }

    int GetNPCInfront() {
        this.Move(1);
        if (this.NextDung <= 0) {
            return -1;
        } else {
            byte var1 = this.NextDung;
            return var1 != 1 ? -1 : NPC.a(this.NewXPos, this.NewYPos);
        }
    }

    int GetSpellSchool(int spellindx) {
        if (spellindx <= 5) {
            return 1;
        } else if (spellindx <= 10) {
            return 3;
        } else if (spellindx <= 15) {
            return 4;
        } else {
            return spellindx <= 20 ? 6 : 10;
        }
    }

    void CastOnSelf(int spellindx) {
        System.out.println("start of castSpell");
        int var2 = this.GetSpellSchool(spellindx);
        int var3 = this.GetSkillVal(var2, true);
        int var4 = this.GetSkillLevel(var2);
        byte g1 = Spell.GetSpell(spellindx).g;
        byte j1 = Spell.GetSpell(spellindx).J;
        byte cost = Spell.GetSpell(spellindx).Cost;
        byte f1 = Spell.GetSpell(spellindx).f;
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

        switch (spellindx) {
            case 1:
            case 2:
            case 3:
            case 5:
                this.G[spellindx - 1] = (byte)(f1 * var13);
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
                if (this.AddSpecialItem(109, var14) && this.a(true)) {
                    this.G[spellindx - 1] = (byte)(f1 * var13);
                }
                break;
            case 21:
                int var15 = 6 + this.GetSkillVal(10, false);
                var10000 = this.CharCritAtt;
                var10000[2] = (short)(var10000[2] + var13 * var15);
                this.CharCritAtt[2] = (short)Math.min(this.CharCritAtt[2], this.CharCritAtt[3]);
                break;
            case 23:
                this.G[spellindx - 1] = -2;
                break;
            case 24:
                this.G[spellindx - 1] = -4;
                break;
            case 25:
                for(int i = 1; i <= var13; ++i) {
                    this.H();
                }
        }

        var10000 = this.CharCritAtt;
        var10000[6] = (short)(var10000[6] - 5 * this.HasStoneBlood());
        this.CharCritAtt[6] = (short)Math.max(this.CharCritAtt[6], 0);
        if (this.GetAilment(6)) {
            int var17 = 2 * this.CharCritAtt[3] / 100;
            if (var17 < 1) {
                var17 = 1;
            }

            var10000 = this.CharCritAtt;
            var10000[2] -= (short)var17;
        }

    }

    void CastOnMonster(int spellindx, Monster mon) {
        int school = this.GetSpellSchool(spellindx);
        int spellval = this.GetSkillVal(school, true);
        int skillLevel = this.GetSkillLevel(school);
        int var6 = mon.GetMonAtt(10);
        int var7 = mon.GetMonAtt(9);
        byte cost = Spell.GetSpell(spellindx).Cost;
        byte var9 = Spell.GetSpell(spellindx).f;
        int var10 = spellval - var6;
        int var11 = mon.GetMonAtt(2);
        var10 = Math.min(var10, var11);
        int var12 = skillLevel + var10 * 5;
        int var13 = var7 - var10 * 5;
        var12 = Math.min(Math.max(var12, 10), 95);
        var13 = Math.min(Math.max(var13, 10), 95);
        int var14 = d(var12, var13);
        byte var15 = 1;
        short[] attarr;
        if (var14 == 0) {
            attarr = this.CharCritAtt;
            attarr[4] = (short)(attarr[4] - 3 * cost);
        } else if (var14 == 1) {
            attarr = this.CharCritAtt;
            attarr[4] = (short)(attarr[4] - 3 * cost / 2);
        } else if (var14 == 2) {
            attarr = this.CharCritAtt;
            attarr[4] = (short)(attarr[4] - cost);
        } else if (var14 == 3) {
            attarr = this.CharCritAtt;
            attarr[4] = (short)(attarr[4] - cost);
            var15 = 2;
        }

        this.CharCritAtt[4] = (short)Math.max(this.CharCritAtt[4], 0);
        if (var14 >= 2) {
            this.a(school, 1);
        }

        int var16;
        int var17;
        int var18;
        int var19;
        switch (spellindx) {
            case 4:
                mon.c[9] = -2;
                mon.d();
            case 5:
            case 6:
            default:
                break;
            case 7:
                var16 = 10 + this.GetSkillVal(3, false);
                mon.c[1] = (byte)var16;
                break;
            case 8:
                var16 = this.GetSkillVal(3, false);
                var17 = 12 + 2 * var16;
                mon.b(var17);
                attarr = this.CharCritAtt;
                attarr[6] = (short)(attarr[6] + var16);
                this.CharCritAtt[6] = (short)Math.min(this.CharCritAtt[6], this.CharCritAtt[7]);
                attarr = this.CharCritAtt;
                attarr[2] = (short)(attarr[2] + var16);
                this.CharCritAtt[2] = (short)Math.min(this.CharCritAtt[2], this.CharCritAtt[3]);
                attarr = this.CharCritAtt;
                attarr[4] = (short)(attarr[4] + 12);
                this.CharCritAtt[4] = (short)Math.min(this.CharCritAtt[4], this.CharCritAtt[5]);
                break;
            case 9:
                if (mon.e()) {
                    var16 = 60 * var15;
                    var17 = var16 - mon.GetMonAtt(8);
                    var17 = Math.max(var17, 4);
                    var18 = var17 * mon.GetMonAtt(14) / 100;
                    mon.b(var18);
                }
                break;
            case 10:
                this.G[spellindx - 1] = -2;
                mon.c[8] = (byte)(2 * var15);
                break;
            case 11:
                var16 = 25 + this.GetSkillVal(4, false);
                var17 = var16 * var15;
                var18 = var17 - mon.GetMonAtt(8);
                var18 = Math.max(var18, 4);
                var19 = var18 * mon.GetMonAtt(14) / 100;
                mon.b(var19);
                mon.d();
                break;
            case 12:
                this.G[spellindx - 1] = -2;
                var16 = var15 * (10 + this.GetSkillVal(4, false));
                var16 = Math.min(var16, 255);
                mon.c[4] = (byte)var16;
                mon.d();
                break;
            case 13:
                this.G[spellindx - 1] = -2;
                var16 = var15 * (10 + this.GetSkillVal(4, false));
                var16 = Math.min(var16, 255);
                mon.c[5] = (byte)var16;
                mon.d();
                break;
            case 14:
                this.G[spellindx - 1] = -1;
                this.a(mon);
                this.G[spellindx - 1] = 0;
                break;
            case 15:
                this.G[spellindx - 1] = -2;
                mon.c[2] = 1;
                mon.d();
                break;
            case 16:
                var16 = 10 - var6;
                if (var16 > 0) {
                    var16 = var15 * var16;
                    this.G[spellindx - 1] = (byte)var16;
                    mon.c[6] = 1;
                }
                break;
            case 17:
                this.G[spellindx - 1] = -2;
                this.aa = (short)(10 + this.GetSkillVal(6, false));
                break;
            case 18:
                this.G[spellindx - 1] = -2;
                mon.c[0] = (byte)(3 * var15);
                break;
            case 19:
                this.G[spellindx - 1] = -2;
                var17 = var15 * (60 - 5 * var6);
                var17 = Math.min(Math.max(var17, 0), 100);
                mon.c[3] = (byte)var17;
                break;
            case 20:
                var18 = 80 - 5 * var6;
                var19 = var18 * var15;
                int var20 = var19 - mon.GetMonAtt(8);
                var20 = Math.max(var20, 4);
                int var21 = var20 * mon.GetMonAtt(14) / 100;
                mon.b(var21);
        }

        attarr = this.CharCritAtt;
        attarr[6] = (short)(attarr[6] - 5 * this.HasStoneBlood());
        this.CharCritAtt[6] = (short)Math.max(this.CharCritAtt[6], 0);
        if (this.GetAilment(6)) {
            int var22 = 2 * this.CharCritAtt[3] / 100;
            if (var22 < 1) {
                var22 = 1;
            }

            attarr = this.CharCritAtt;
            attarr[2] -= (short)var22;
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

    boolean AddSpecialItem(int itemindx, int var2) {
        return this.AddToInventory(itemindx, var2, 0);
    }

    boolean AddToInventory(int itemindx, int var2, int var3) {
        if (this.InventoryCount < 24) {
            this.Inventory[this.InventoryCount] = (byte)itemindx;
            int var4 = (var2 << 16) + (byte)var3;
            this.P[this.InventoryCount] = var4;
            ++this.InventoryCount;
            return true;
        } else {
            return false;
        }
    }

    boolean RemoveFromInv(int invindx) {
        if (invindx >= this.InventoryCount) {
            return false;
        } else {
            this.UneqpuipItem(invindx);
            this.Inventory[invindx] = 0;

            for(int i = invindx; i < this.InventoryCount - 1; ++i) {
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
            byte[] var3 = new byte[]{this.XPos, this.YPos, (byte)var2, 0, 0, (byte)(this.P[var1] & 255), 0};
            int var4 = this.P[var1] >>> 16 & '\uffff';
            var3[3] = (byte)(var4 >> 8 & 255);
            var3[4] = (byte)(var4 & 255);
            var3[6] = 3;
            this.GetCurrentDungeon().c(var3);
            this.RemoveFromInv(var1);
        } else {
            this.RemoveFromInv(var1);
        }

    }

    boolean IsEquiped(int invindx) {
        byte itemindx = this.Inventory[invindx];
        if (!Item.IsEquipable(Math.abs(itemindx))) {
            return false;
        } else {
            return itemindx < 0;
        }
    }

    boolean EquipItem(int invid, boolean UnequipOther) {
        byte var3 = this.Inventory[invid];
        if (var3 < 0) {
            return false;
        } else if (!Item.IsEquipable(var3)) {
            return false;
        } else {
            int var4 = Item.GetItemSlot(var3);
            if (this.Equiped[var4] != 0) {
                if (!UnequipOther) {
                    return false;
                }

                this.f(var4);
            }

            this.Equiped[var4] = var3;
            this.Inventory[invid] = (byte)(-Math.abs(this.Inventory[invid]));
            return true;
        }
    }

    private void f(int var1) {
        for(int i = 0; i < this.InventoryCount; ++i) {
            byte var3 = this.Inventory[i];
            var3 = (byte)Math.abs(var3);
            int var4 = Item.GetItemSlot(var3);
            if (var4 == var1) {
                this.UneqpuipItem(i);
            }
        }

    }

    boolean a(boolean var1) {
        int var2 = this.InventoryCount - 1;
        return this.EquipItem(var2, var1);
    }

    void UneqpuipItem(int var1) {
        if (this.IsEquiped(var1)) {
            if (var1 >= 0 && var1 <= 23) {
                byte var2 = this.Inventory[var1];
                var2 = (byte)Math.abs(var2);
                this.Inventory[var1] = var2;

                for(int i = 0; i < 7; ++i) {
                    if (this.Equiped[i] == var2) {
                        this.Equiped[i] = 0;
                        break;
                    }
                }

            }
        }
    }

    boolean h(int var1) {
        byte var2 = this.Inventory[var1];
        var2 = (byte)Math.abs(var2);
        if (Item.IsEquipment(var2)) {
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

    int FindItemInInv(int itemindx) {
        int invindx = -1;
        int var3 = -Math.abs(itemindx);

        for(int i = 0; i < this.InventoryCount; ++i) {
            if (var3 == this.Inventory[i]) {
                invindx = i;
                break;
            }
        }

        return invindx;
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
                int var10 = this.GetSkillVal(3, false);
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
        this.KnownSpells = func.a(var5, this.KnownSpells);
        this.RemoveFromInv(indx);
        return true;
    }

    void a(int var1) {
        this.a(var1, GameCanvas.Mon1);
    }

    boolean IsEquipable(int Invindx) {
        int indx = Math.abs(this.Inventory[Invindx]);
        byte type = Item.Type[indx - 1];
        switch (type) {
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
                var2 += this.GetSkillVal(10, false);
                if (var2 > this.CharCritAtt[3]) {
                    var2 = this.CharCritAtt[3];
                }
            } else if (attr == 6) {
                var2 += this.GetSkillVal(10, false);
                if (var2 > this.CharCritAtt[7]) {
                    var2 = this.CharCritAtt[7];
                }
            } else if (attr == 4) {
                var2 += this.GetSkillVal(10, false);
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
        this.ao = this.XPos;
        this.an = this.YPos;
        this.Z = this.DirFacing;
        this.TeleportPlayer(true);
        this.w();
        this.Q = true;
    }

    void e() {
        this.CurDung = this.NextDung = this.C;
        this.XPos = this.NewXPos = this.ao;
        this.YPos = this.NewYPos = this.an;
        this.w();
        this.Q = true;
    }

    int GetAilmentCount() {
        int ailcount = 0;

        for(int i = 0; i < 8; ++i) {
            int ail = this.Ailments >> i & 1;
            if (ail != 0) {
                ++ailcount;
            }
        }

        return ailcount;
    }

    void H() {
        int var1 = this.GetAilmentCount();
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
                int var5 = this.Ailments >> i & 1;
                if (var5 == 1) {
                    ++var3;
                    if (var3 == var6) {
                        this.Ailments = (byte)func.c(i, this.Ailments);
                        break;
                    }
                }
            }
        }

    }

    int HasStoneBlood() {
        return (this.Ailments & 1) == 1 ? 3 : 1;
    }

    Dungeon GetCurrentDungeon() {
        return ESGame.dungeons[this.CurDung - 1];
    }

    void w() {
        this.GetCurrentDungeon().b(this.XPos, this.YPos, this.DirFacing, this.ae);
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
            if (this.GetAilment(i)) {
                StatsString.append('\n');
                StatsString.append(AilmentStr[i - 1]);
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

        String statsFinalStr = StatsString.toString();
        System.out.println("Length of stats string is " + statsFinalStr.length());
        return statsFinalStr;
    }

    static Vector G() {
        Vector vec = new Vector();

        for(int i = 0; i < 13; ++i) {
            vec.addElement(new Object());
        }

        return vec;
    }

    static String DroppedItemData(byte[] item) {
        String itemstr = "X = " + item[0] + '\n';
        itemstr = itemstr + "Y = " + item[1] + '\n';
        itemstr = itemstr + "Type = " + item[2] + '\n';
        itemstr = itemstr + "ID(MSB) = " + item[3] + '\n';
        itemstr = itemstr + "ID(LSB) = " + item[4] + '\n';
        itemstr = itemstr + "value = " + item[5] + '\n';
        itemstr = itemstr + "flags = " + item[6] + '\n';
        return itemstr;
    }

    Vector GetSkillList() {
        Vector vec = new Vector();

        for(int i = 0; i < 14; ++i) {
            if (this.CharSkills[i][0] > 0) {
                String skillStr = Skills[i] + ": " + this.CharSkills[i][0];
                vec.addElement(skillStr);
            }
        }

        return vec;
    }

    int GetSkillIndx(int skillindx) {
        int knownindx = 0;

        for(int i = 0; i < 14; ++i) {
            if (this.CharSkills[i][0] > 0) {
                if (knownindx == skillindx) {
                    return i;
                }

                ++knownindx;
            }
        }

        return -1;
    }

    String GetSkillString(int skill) {
        String skillstr = Skills[skill] + '\n' + "Rank: " + this.CharSkills[skill][0] + '\n' + "Exp: " + this.CharSkills[skill][2] + "/10";
        return skillstr;
    }

    Vector GetKnownSpells() {
        Vector vec = new Vector();

        for(int i = 0; i < Spell.SpellCount; ++i) {
            if ((this.KnownSpells & 1 << i) != 0) {
                int spellindx = i + 1;
                String spllStr = Spell.spells[i].Name;
                if (spellindx == this.CurSpell) {
                    spllStr = "R: " + spllStr;
                }

                vec.addElement(spllStr);
            }
        }

        return vec;
    }

    int IsSpellKnown(int indx) {
        int spell = 0;

        for(int i = 0; i < Spell.SpellCount; ++i) {
            if ((this.KnownSpells & 1 << i) != 0) {
                int var4 = i + 1;
                if (spell == indx) {
                    return i;
                }

                ++spell;
            }
        }

        return -1;
    }

    int l() {
        int var1;
        if (!Spell.ValidateSpellNum(this.CurSpell)) {
            var1 = this.IsSpellKnown(0);
            return var1 < 0 ? 0 : var1 + 1;
        } else {
            var1 = this.CurSpell - 1;
            int var2 = var1 + 1;
            if (var2 == Spell.SpellCount) {
                var2 = 0;
            }

            while(var2 != var1) {
                if ((this.KnownSpells & 1 << var2) != 0) {
                    return var2 + 1;
                }

                ++var2;
                if (var2 == Spell.SpellCount) {
                    var2 = 0;
                }
            }

            return this.CurSpell;
        }
    }

    String GetSpellInfoStr(int indx) {
        String SpellInfo = Spell.spells[indx].Name + '\n';
        SpellInfo = SpellInfo + Skills[Spell.spells[indx].School] + '\n';
        SpellInfo = SpellInfo + "Cost: " + Spell.spells[indx].Cost + '\n';
        SpellInfo = SpellInfo + Spell.spells[indx].Description;
        return SpellInfo;
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

        if (this.GetAilment(8)) {
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
                    this.RemoveFromInv(var6);
                    break;
                }
            }
        }

        for(var6 = 0; var6 < 8; ++var6) {
            var7 = var6 + 1;
            if (var7 != 4 && var7 != 5) {
                var5 = func.a(100);
                if (var5 <= 25) {
                    this.Ailments = (byte)func.c(var6, this.Ailments);
                }
            }
        }

    }

    boolean GetAilment(int indx0) {
        int AilNum = indx0 - 1;
        return (this.Ailments & 1 << AilNum) != 0;
    }

    void a(int var1, Monster mon) {
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
                    if (mon != null) {
                        var6 = mon.GetMonAtt(4);
                        var7 = mon.GetMonAtt(10);
                        if (var6 <= 13 && var7 <= 13) {
                            mon.Health = 0;
                            mon.d();
                        }
                    }
                    break;
                case 98:
                    if (mon != null) {
                        var6 = mon.GetMonAtt(4);
                        var7 = mon.GetMonAtt(10);
                        if (var6 <= 22 && var7 <= 22) {
                            mon.Health = 0;
                            mon.d();
                        }
                    }
                    break;
                case 99:
                    if (mon != null) {
                        var6 = mon.GetMonAtt(4);
                        var7 = mon.GetMonAtt(10);
                        if (var6 <= 29 && var7 <= 29) {
                            mon.Health = 0;
                            mon.d();
                        }
                    }
            }

            if (var5) {
                this.RemoveFromInv(var1);
            }
        }

    }

    boolean IsLvlIncrease() {
        for(int i = 0; i < 14; ++i) {
            if (this.CharSkills[i][2] >= 10) {
                short[] skill = this.CharSkills[i];
                skill[2] = (short)(skill[2] - 10);
                ++this.CharSkills[i][0];
                short var2 = SkillTies[i];
                int var3 = var2 / 2;
                this.AttIncreases = (byte)(this.AttIncreases | 1 << var3);
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

    void ResetLvlProg() {
        NPC.d();
        short[] critAtt = this.CharCritAtt;
        critAtt[1] = (short)(critAtt[1] - 10);
    }

    String[] GetSkillIncreases() {
        Vector vec = new Vector();

        int indx;
        for(int i = 0; i < 8; ++i) {
            if ((this.AttIncreases & 1 << i) != 0) {
                indx = i * 2;
                vec.addElement(Attributes[indx]);
            }
        }

        indx = vec.size();
        if (indx == 0) {
            return null;
        } else {
            String[] skillupstrs = new String[indx];

            for(int i = 0; i < indx; ++i) {
                skillupstrs[i] = (String)vec.elementAt(i);
            }

            return skillupstrs;
        }
    }

    private void C() {
        short var1 = Item.a();
        int[] strtgear = StartingGear[this.CharClass];

        for(int i = 0; i < strtgear.length; ++i) {
            this.AddSpecialItem(strtgear[i], var1);
            int var4 = this.InventoryCount - 1;
            this.EquipItem(var4, true);
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
        int skillVal = this.GetSkillVal(13, true);
        if (var2 == 3) {
            skillVal += 3;
        }

        short var4 = NPC.r[var1];
        int var5 = skillVal - var4;
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

    String GetDebugString() {
        byte facing = this.DirFacing;
        StringBuffer strBuff = new StringBuffer(1000);
        System.out.println("here 1");
        String[] dungName = this.GetCurrentDungeon().GetDungName();
        strBuff.append("Current dungeon is " + dungName[0] + " " + dungName[1] + "\n");

        for(int i = 1; i <= 4; ++i) {
            if (i <= 2) {
                this.Move(i);
            } else if (i == 3) {
                this.a();
                this.Move(1);
            } else if (i == 4) {
                this.B();
                this.Move(1);
            }

            System.out.println("here 2, i =" + i);
            if (i == 1) {
                strBuff.append("FORWARD SQUARE: \n");
            } else if (i == 2) {
                strBuff.append("BACKWARD SQUARE: \n");
            } else if (i == 3) {
                strBuff.append("RIGHT SIDE SQUARE: \n");
            } else if (i == 4) {
                strBuff.append("LEFT SIDE SQUARE: \n");
            }

            strBuff.append("x,y = " + this.NewXPos + ", " + this.NewYPos + "\n");
            System.out.println("New a and y are " + this.NewXPos + ", " + this.NewYPos);
            strBuff.append("map value = " + this.GetCurrentDungeon().DngnVec[this.NewXPos][this.NewYPos] + "\n");
            System.out.println("New dungeon id is " + this.NextDung);
            Hashtable hash = ESGame.MonsterTables[this.NextDung - 1];
            Enumeration vec;
            byte[] objbuff;
            if (hash != null) {
                vec = hash.elements();

                while(vec.hasMoreElements()) {
                    objbuff = (byte[])vec.nextElement();
                    System.out.println("Found a monster");
                    if (objbuff[4] == this.NewXPos && objbuff[5] == this.NewYPos) {
                        strBuff.append("Found monster in square \n");
                        strBuff.append("type=" + objbuff[2] + ", health=" + objbuff[3] + ", dungeon id = " + objbuff[7] + "\n");
                    }
                }
            }

            System.out.println("here 3, i =" + i);
            hash = ESGame.ChestTables[this.NextDung - 1];
            if (hash != null) {
                vec = hash.elements();

                while(vec.hasMoreElements()) {
                    objbuff = (byte[])vec.nextElement();
                    if (objbuff[0] == this.NewXPos && objbuff[1] == this.NewYPos) {
                        strBuff.append("Found chest in square \n");
                        strBuff.append("item type=" + objbuff[4] + ", value=" + objbuff[7] + "\n");
                    }
                }
            }

            System.out.println("here 4, i =" + i);
            vec = ESGame.DroppedItemsTables[this.NextDung - 1].elements();

            while(vec.hasMoreElements()) {
                objbuff = (byte[])vec.nextElement();
                if (objbuff[0] == this.NewXPos && objbuff[1] == this.NewYPos) {
                    strBuff.append("Found dropped item in square \n");
                    strBuff.append("item type=" + objbuff[2] + ", value=" + objbuff[5] + " flags = " + objbuff[6] + "\n");
                }
            }

            this.DirFacing = facing;
        }

        if (NPC.WardenPresent) {
            strBuff.append("Warden IS visiting now\n");
        } else {
            strBuff.append("Warden IS NOT visiting now\n");
        }

        strBuff.append("Player inventory: nitems=" + this.InventoryCount);
        return strBuff.toString();
    }
}
