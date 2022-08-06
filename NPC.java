//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.DataInputStream;

public class NPC {
    static String[] NPCNames = new String[]{"Arantamo", "Celegil", "Favela Dralor", "Vander", "Beneca", "Helga", "Varus"};
    static byte[] e = new byte[]{1, 1, 1, 1, 2, 2, 3};
    static byte[] NPCXPos = new byte[]{12, 3, 15, 6, 7, 12, 9};
    static byte[] NPCYPos = new byte[]{3, 7, 7, 13, 2, 13, 9};
    static boolean[] b;
    static boolean[] FirstMeet;
    static byte f = 0;
    static boolean WardenPresent = false;
    static byte[] c;
    static byte[] n;
    static short[] r;
    static short[] p;
    static short[] h;
    static short a;
    static short g;
    static boolean l;
    static String[][] NPCStrings;
    static int[] NPCDlgCounts = new int[]{20, 20, 20, 20, 5, 22, 5, 41};
    static boolean StringsLoaded = false;

    public NPC() {
    }

    static void LoadNPCStrings() {
        LoadNPCStrings("/npcstrings.dat");
    }

    static void LoadNPCStrings(String File) {
        try {
            DataInputStream data = func.LoadDatStream(File);
            byte NPCCount = 8;
            NPCStrings = new String[NPCCount][];

            for(int i = 0; i < NPCCount; ++i) {
                LoadNPCStrings(i, NPCDlgCounts[i], data);
            }

            StringsLoaded = true;
        } catch (Exception var4) {
            System.out.println("ERROR loading NPC and generic strings!");
            StringsLoaded = false;
        }

    }

    static boolean a(int var0) {
        if (f == 0 && !WardenPresent && var0 >= 13) {
            return true;
        } else if (f == 1 && !WardenPresent && var0 >= 26) {
            return true;
        } else {
            return f == 2 && !WardenPresent && var0 >= 39;
        }
    }

    static void WardenAppear() {
        System.out.println("WARDEN VISITS!!");
        WardenPresent = true;
        ++f;
        byte X = NPCXPos[6];
        byte Y = NPCYPos[6];
        byte[] XVec = ESGame.dungeons[0].DngnVec[X];
        XVec[Y] = (byte)(XVec[Y] | 32);
    }

    static void WardenLeave() {
        System.out.println("WARDEN LEAVES!!");
        byte X = NPCXPos[6];
        byte Y = NPCYPos[6];
        WardenPresent = false;
        byte WardenPos = ESGame.dungeons[1].DngnVec[X][Y];
        ESGame.dungeons[0].DngnVec[X][Y] = func.c((byte)32, WardenPos);
    }

    static void LoadNPCStrings(int npcNum, int dlgCount, DataInputStream stream) throws Exception {
        int EncodedCount = stream.readInt();
        if (EncodedCount != dlgCount) {
            System.out.println("Unexpected number of messages for whichNPC = " + npcNum);
            throw new Exception("Error in readNPCMessages: npc is " + npcNum);
        } else {
            NPCStrings[npcNum] = new String[EncodedCount];

            for(int i = 0; i < EncodedCount; ++i) {
                NPCStrings[npcNum][i] = stream.readUTF();
            }

        }
    }

    static void InitNPCs () {
        b = new boolean[7];
        FirstMeet = new boolean[7];

        for(int i = 0; i < 7; ++i) {
            b[i] = true;
            FirstMeet[i] = true;
        }

        r = new short[4];
        p = new short[4];
        h = new short[4];
        c = new byte[4];
        n = new byte[4];

        for(int i = 0; i < 4; ++i) {
            r[i] = 0;
            p[i] = 0;
            h[i] = 0;
            c[i] = 0;
            n[i] = 0;
        }

        a = 0;
        g = 0;
        l = false;
    }

    static void d() {
        for(int i = 0; i < 4; ++i) {
            c[i] = 0;
            n[i] = 0;
        }

    }

    static boolean b(int var0) {
        return e[var0] == 1;
    }

    static int a(int var0, int var1) {
        for(int i = 0; i < 7; ++i) {
            if (var0 == NPCXPos[i] && var1 == NPCYPos[i] && b[i]) {
                return i;
            }
        }

        return -1;
    }

    static int d(int var0, int var1) {
        int var2 = Item.GetItemProperty(3, var1);
        if (var0 == 0) {
            return var2 >>> 6 & 3;
        } else if (var0 == 1) {
            return var2 >>> 4 & 3;
        } else if (var0 == 2) {
            return var2 >>> 2 & 3;
        } else {
            return var0 == 3 ? var2 & 3 : 0;
        }
    }

    static String SkillIncreaseStr(Character player, int skill) {
        short SkillRank = player.CharSkills[skill][0];
        String str;
        if (SkillRank == 0) {
            player.CharSkills[skill][0] = 1;
            str = NPCStrings[7][1];
            str = func.StringInsert(str, "<TAG>", Character.Skills[skill]);
            return str;
        } else {
            player.CharSkills[skill][0] = (short)(SkillRank + 1);
            str = NPCStrings[7][2];
            String[] values = new String[]{Character.Skills[skill], String.valueOf(SkillRank), String.valueOf(SkillRank + 1)};
            str = func.StringInsert(str, "<TAG>", values);
            return str;
        }
    }

    static String GetNPCDialogue(Character player, int npc, int var2, int var3) {
        int var4;
        int var5;
        int var6;
        switch (npc) {
            case 0:
            case 1:
            case 2:
            case 3:
                if (var2 == 1) {
                    if (FirstMeet[npc]) {
                        FirstMeet[npc] = false;
                        return NPCStrings[npc][0];
                    } else if (h[npc] > 50) {
                        return NPCStrings[npc][1];
                    } else {
                        if (player.CharCritAtt[8] > 50) {
                            return NPCStrings[npc][2];
                        }

                        var4 = ESGame.h(3);
                        return NPCStrings[npc][3 + var4];
                    }
                } else {
                    short[] var10000;
                    if (var2 == 2) {
                        if (c[npc] != 0) {
                            return NPCStrings[npc][6];
                        }

                        var4 = player.b(npc, var2);
                        if (var4 == 0) {
                            c[npc] = 1;
                        } else if (var4 == 1) {
                            var10000 = player.CharSkills[13];
                            var10000[2] = (short)(var10000[2] + 2);
                        } else if (var4 == 2) {
                            var10000 = player.CharSkills[13];
                            var10000[2] = (short)(var10000[2] + 5);
                            ++p[npc];
                            c[npc] = 1;
                        } else if (var4 == 3) {
                            var10000 = player.CharSkills[13];
                            var10000[2] = (short)(var10000[2] + 8);
                            ++p[npc];
                            c[npc] = 1;
                        }

                        ++r[npc];
                        return NPCStrings[npc][7 + var4];
                    } else if (var2 == 3) {
                        if (n[npc] != 0) {
                            return NPCStrings[npc][6];
                        }

                        var4 = player.b(npc, var2);
                        var5 = var3 <= 1 ? 0 : 1;
                        if (var4 == 0) {
                            n[npc] = 2;
                        } else if (var4 == 1) {
                            var10000 = player.CharSkills[13];
                            var10000[2] = (short)(var10000[2] + 2);
                            n[npc] = 2;
                        } else if (var4 == 2) {
                            var10000 = player.CharSkills[13];
                            var10000[2] = (short)(var10000[2] + 5);
                            ++p[npc];
                            n[npc] = 1;
                        } else if (var4 == 3) {
                            var10000 = player.CharSkills[13];
                            var10000[2] = (short)(var10000[2] + 8);
                            ++p[npc];
                            n[npc] = 1;
                        }

                        ++r[npc];
                        return NPCStrings[npc][11 + var5];
                    } else if (var2 == 4) {
                        if (c[npc] != 2 && n[npc] != 2) {
                            var5 = Math.abs(player.Inventory[var3]);
                            if (Item.GetItemProperty(1, var5) == 15) {
                                player.RemoveFromInv(var3);
                                var6 = Item.GetItemProperty(3, var5);
                                var10000 = h;
                                var10000[npc] = (short)(var10000[npc] - var6);
                                h[npc] = (short)Math.max(h[npc], 0);
                                return NPCStrings[npc][17];
                            }

                            if (Item.GetItemProperty(1, var5) == 11) {
                                var6 = d(npc, var5);
                                if (var6 > 0) {
                                    player.RemoveFromInv(var3);
                                    var10000 = p;
                                    var10000[npc] = (short)(var10000[npc] + var6);
                                    c[npc] = 0;
                                    n[npc] = 0;
                                }

                                return NPCStrings[npc][13 + var6];
                            }

                            return NPCStrings[npc][13];
                        }

                        return NPCStrings[npc][13];
                    } else if (var2 == 5) {
                        if (p[npc] == 0) {
                            return NPCStrings[npc][18];
                        } else if (h[npc] > 50) {
                            return NPCStrings[npc][1];
                        } else {
                            if (player.CharCritAtt[8] > 50) {
                                return NPCStrings[npc][2];
                            }

                            --p[npc];
                            return SkillIncreaseStr(player, var3);
                        }
                    } else {
                        if (var2 == 6) {
                            b[npc] = false;
                            Dungeon var7 = ESGame.dungeons[0];
                            var7.DngnVec[NPCXPos[npc]][NPCYPos[npc]] = func.c((byte)32, var7.DngnVec[NPCXPos[npc]][NPCYPos[npc]]);
                            return NPCStrings[npc][19];
                        }

                        return null;
                    }
                }
            case 4:
                if (var2 == 1) {
                    if (FirstMeet[npc]) {
                        FirstMeet[npc] = false;
                        return NPCStrings[npc][0];
                    }

                    return null;
                } else if (var2 == 4) {
                    var5 = Math.abs(player.Inventory[var3]);
                    var6 = Item.GetItemProperty(1, var5);
                    if (var6 != 13 && var6 != 15 && var6 != 17) {
                        ++a;
                        player.RemoveFromInv(var3);
                        return NPCStrings[npc][2];
                    }

                    return NPCStrings[npc][1];
                } else {
                    if (var2 == 7) {
                        if (a / 3 > 0) {
                            short var8 = Item.a();
                            boolean var9 = player.AddToInventory(var3, var8, 0);
                            if (!var9) {
                                return NPCStrings[7][0];
                            }

                            a = (short)(a - 3);
                            return NPCStrings[npc][3];
                        }

                        return NPCStrings[npc][4];
                    }

                    return null;
                }
            case 5:
                if (var2 == 1) {
                    System.out.println("Greeting Helga");
                    if (FirstMeet[npc]) {
                        System.out.println("first meeting");
                        FirstMeet[npc] = false;
                        player.Y = 0;
                        System.out.println("message[iNPC] length is " + NPCStrings[npc].length);
                        System.out.println(NPCStrings[npc][0]);
                        System.out.println(NPCStrings[npc][2]);
                        if (l) {
                            l = false;
                            return NPCStrings[5][21] + "\n" + NPCStrings[npc][0] + "\n" + NPCStrings[npc][2];
                        }

                        return NPCStrings[npc][0] + "\n" + NPCStrings[npc][2];
                    } else {
                        var4 = ESGame.GetGameAdvLevel(player.GiftPoints);
                        if (var4 > player.Y) {
                            ++player.Y;
                            if (l) {
                                l = false;
                                return NPCStrings[5][21] + "\n" + NPCStrings[npc][2 + player.Y];
                            }

                            return NPCStrings[npc][2 + player.Y];
                        } else {
                            if (l) {
                                l = false;
                                return NPCStrings[5][21];
                            }

                            return null;
                        }
                    }
                } else if (var2 == 13) {
                    return NPCStrings[npc][2 + player.Y];
                } else if (var2 == 4) {
                    var5 = Math.abs(player.Inventory[var3]);
                    if (Item.GetItemProperty(1, var5) == 13) {
                        var6 = player.D(var3);
                        if (var6 > 3) {
                            g = (short)(g + 5);
                        } else {
                            g = (short)(g + 3);
                        }

                        player.RemoveFromInv(var3);
                        return NPCStrings[npc][11];
                    }

                    return NPCStrings[npc][12];
                } else if (var2 == 8) {
                    if (g < 7) {
                        return NPCStrings[npc][1];
                    } else {
                        var5 = Math.abs(player.Inventory[var3]);
                        if (Item.IsEquipment(var5) && !player.j(var3)) {
                            g = (short)(g - 7);
                            player.h(var3);
                            return NPCStrings[npc][13];
                        }

                        return NPCStrings[npc][14];
                    }
                } else if (var2 == 9) {
                    if (g < 2) {
                        return NPCStrings[npc][1];
                    } else {
                        if (player.f) {
                            return NPCStrings[npc][15];
                        }

                        player.f = true;
                        g = (short)(g - 2);
                        return NPCStrings[npc][16];
                    }
                } else if (var2 == 10) {
                    if (g < 1) {
                        return NPCStrings[npc][1];
                    }

                    player.Ailments = 0;
                    --g;
                    return NPCStrings[npc][17];
                } else if (var2 == 11) {
                    if (g < 1) {
                        return NPCStrings[npc][1];
                    } else {
                        if (!player.x()) {
                            return NPCStrings[npc][18];
                        }

                        --g;
                        player.e();
                        return NPCStrings[npc][19];
                    }
                } else {
                    if (var2 == 12) {
                        player.CharCritAtt[2] = player.CharCritAtt[3];
                        player.CharCritAtt[4] = player.CharCritAtt[5];
                        return NPCStrings[npc][20];
                    }

                    return null;
                }
            case 6:
                if (f == 0) {
                    return null;
                } else if (f == 1 && player.m == 0) {
                    player.m = 1;
                    return NPCStrings[npc][0];
                } else if (f == 2 && player.m <= 1) {
                    player.m = 2;
                    return NPCStrings[npc][1];
                } else if (f == 3 && player.m <= 2) {
                    player.m = 3;
                    return NPCStrings[npc][2];
                } else {
                    if (f == 4 && player.m <= 3) {
                        player.m = 4;
                        return NPCStrings[npc][3] + "\n" + NPCStrings[npc][4];
                    }

                    return null;
                }
            default:
                return null;
        }
    }

    static boolean a(Character player) {
        if (player.CurDung != 1) {
            return false;
        } else {
            int var1 = Math.abs(player.XPos - NPCXPos[6]);
            int var2 = Math.abs(player.YPos - NPCYPos[6]);
            return var1 + var2 == 1;
        }
    }

    static boolean c(int var0, int var1) {
        switch (var0) {
            case 0:
                switch (var1) {
                    case 3:
                    case 4:
                    case 13:
                        return true;
                    default:
                        return false;
                }
            case 1:
                switch (var1) {
                    case 7:
                    case 8:
                    case 10:
                        return true;
                    case 9:
                    default:
                        return false;
                }
            case 2:
                switch (var1) {
                    case 1:
                    case 6:
                    case 12:
                        return true;
                    default:
                        return false;
                }
            case 3:
                switch (var1) {
                    case 0:
                    case 2:
                    case 5:
                        return true;
                    default:
                        return false;
                }
            default:
                return false;
        }
    }

    static int b(int var0, int var1) {
        switch (var0) {
            case 0:
                switch (var1) {
                    case 0:
                        return 3;
                    case 1:
                        return 4;
                    case 2:
                        return 13;
                    default:
                        return -1;
                }
            case 1:
                switch (var1) {
                    case 0:
                        return 7;
                    case 1:
                        return 8;
                    case 2:
                        return 10;
                    default:
                        return -1;
                }
            case 2:
                switch (var1) {
                    case 0:
                        return 1;
                    case 1:
                        return 6;
                    case 2:
                        return 12;
                    default:
                        return -1;
                }
            case 3:
                switch (var1) {
                    case 0:
                        return 0;
                    case 1:
                        return 2;
                    case 2:
                        return 5;
                    default:
                        return -1;
                }
            default:
                return -1;
        }
    }

    static {
        InitNPCs();
    }
}
