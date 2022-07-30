//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.DataInputStream;

public class NPC {
    static String[] NPCNames = new String[]{"Arantamo", "Celegil", "Favela Dralor", "Vander", "Beneca", "Helga", "Varus"};
    static byte[] e = new byte[]{1, 1, 1, 1, 2, 2, 3};
    static byte[] J = new byte[]{12, 3, 15, 6, 7, 12, 9};
    static byte[] ia = new byte[]{3, 7, 7, 13, 2, 13, 9};
    static boolean[] b;
    static boolean[] q;
    static byte f = 0;
    static boolean d = false;
    static byte[] c;
    static byte[] n;
    static short[] r;
    static short[] p;
    static short[] h;
    static short a;
    static short g;
    static boolean l;
    static String[][] NPCStrings;
    static int[] o = new int[]{20, 20, 20, 20, 5, 22, 5, 41};
    static boolean m = false;

    public NPC() {
    }

    static void LoadNPCStrings() {
        LoadNPCStrings("/npcstrings.dat");
    }

    static void LoadNPCStrings(String var0) {
        try {
            DataInputStream var1 = func.LoadDatStream(var0);
            byte var2 = 8;
            NPCStrings = new String[var2][];

            for(int i = 0; i < var2; ++i) {
                GetNPCDialogue(i, o[i], var1);
            }

            m = true;
        } catch (Exception var4) {
            System.out.println("ERROR loading NPC and generic strings!");
            m = false;
        }

    }

    static boolean a(int var0) {
        if (f == 0 && !d && var0 >= 13) {
            return true;
        } else if (f == 1 && !d && var0 >= 26) {
            return true;
        } else {
            return f == 2 && !d && var0 >= 39;
        }
    }

    static void c() {
        System.out.println("WARDEN VISITS!!");
        d = true;
        ++f;
        byte var0 = J[6];
        byte var1 = ia[6];
        byte[] var10000 = ESGame.dungeons[0].DngnVec[var0];
        var10000[var1] = (byte)(var10000[var1] | 32);
    }

    static void a() {
        System.out.println("WARDEN LEAVES!!");
        byte var0 = J[6];
        byte var1 = ia[6];
        d = false;
        byte var2 = ESGame.dungeons[1].DngnVec[var0][var1];
        ESGame.dungeons[0].DngnVec[var0][var1] = func.c((byte)32, var2);
    }

    static void GetNPCDialogue(int var0, int var1, DataInputStream var2) throws Exception {
        int var3 = var2.readInt();
        if (var3 != var1) {
            System.out.println("Unexpected number of messages for whichNPC = " + var0);
            throw new Exception("Error in readNPCMessages: npc is " + var0);
        } else {
            NPCStrings[var0] = new String[var3];

            for(int i = 0; i < var3; ++i) {
                NPCStrings[var0][i] = var2.readUTF();
            }

        }
    }

    static void b() {
        b = new boolean[7];
        q = new boolean[7];

        for(int i = 0; i < 7; ++i) {
            b[i] = true;
            q[i] = true;
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
            if (var0 == J[i] && var1 == ia[i] && b[i]) {
                return i;
            }
        }

        return -1;
    }

    static int d(int var0, int var1) {
        int var2 = Item.a(3, var1);
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

    static String a(Character var0, int var1) {
        short var2 = var0.R[var1][0];
        String var3;
        if (var2 == 0) {
            var0.R[var1][0] = 1;
            var3 = NPCStrings[7][1];
            var3 = func.StringInsert(var3, "<TAG>", Character.Skills[var1]);
            return var3;
        } else {
            var0.R[var1][0] = (short)(var2 + 1);
            var3 = NPCStrings[7][2];
            String[] var4 = new String[]{Character.Skills[var1], String.valueOf(var2), String.valueOf(var2 + 1)};
            var3 = func.StringInsert(var3, "<TAG>", var4);
            return var3;
        }
    }

    static String a(Character var0, int var1, int var2, int var3) {
        int var4;
        int var5;
        int var6;
        switch (var1) {
            case 0:
            case 1:
            case 2:
            case 3:
                if (var2 == 1) {
                    if (q[var1]) {
                        q[var1] = false;
                        return NPCStrings[var1][0];
                    } else if (h[var1] > 50) {
                        return NPCStrings[var1][1];
                    } else {
                        if (var0.U[8] > 50) {
                            return NPCStrings[var1][2];
                        }

                        var4 = ESGame.h(3);
                        return NPCStrings[var1][3 + var4];
                    }
                } else {
                    short[] var10000;
                    if (var2 == 2) {
                        if (c[var1] != 0) {
                            return NPCStrings[var1][6];
                        }

                        var4 = var0.b(var1, var2);
                        if (var4 == 0) {
                            c[var1] = 1;
                        } else if (var4 == 1) {
                            var10000 = var0.R[13];
                            var10000[2] = (short)(var10000[2] + 2);
                        } else if (var4 == 2) {
                            var10000 = var0.R[13];
                            var10000[2] = (short)(var10000[2] + 5);
                            ++p[var1];
                            c[var1] = 1;
                        } else if (var4 == 3) {
                            var10000 = var0.R[13];
                            var10000[2] = (short)(var10000[2] + 8);
                            ++p[var1];
                            c[var1] = 1;
                        }

                        ++r[var1];
                        return NPCStrings[var1][7 + var4];
                    } else if (var2 == 3) {
                        if (n[var1] != 0) {
                            return NPCStrings[var1][6];
                        }

                        var4 = var0.b(var1, var2);
                        var5 = var3 <= 1 ? 0 : 1;
                        if (var4 == 0) {
                            n[var1] = 2;
                        } else if (var4 == 1) {
                            var10000 = var0.R[13];
                            var10000[2] = (short)(var10000[2] + 2);
                            n[var1] = 2;
                        } else if (var4 == 2) {
                            var10000 = var0.R[13];
                            var10000[2] = (short)(var10000[2] + 5);
                            ++p[var1];
                            n[var1] = 1;
                        } else if (var4 == 3) {
                            var10000 = var0.R[13];
                            var10000[2] = (short)(var10000[2] + 8);
                            ++p[var1];
                            n[var1] = 1;
                        }

                        ++r[var1];
                        return NPCStrings[var1][11 + var5];
                    } else if (var2 == 4) {
                        if (c[var1] != 2 && n[var1] != 2) {
                            var5 = Math.abs(var0.H[var3]);
                            if (Item.a(1, var5) == 15) {
                                var0.y(var3);
                                var6 = Item.a(3, var5);
                                var10000 = h;
                                var10000[var1] = (short)(var10000[var1] - var6);
                                h[var1] = (short)Math.max(h[var1], 0);
                                return NPCStrings[var1][17];
                            }

                            if (Item.a(1, var5) == 11) {
                                var6 = d(var1, var5);
                                if (var6 > 0) {
                                    var0.y(var3);
                                    var10000 = p;
                                    var10000[var1] = (short)(var10000[var1] + var6);
                                    c[var1] = 0;
                                    n[var1] = 0;
                                }

                                return NPCStrings[var1][13 + var6];
                            }

                            return NPCStrings[var1][13];
                        }

                        return NPCStrings[var1][13];
                    } else if (var2 == 5) {
                        if (p[var1] == 0) {
                            return NPCStrings[var1][18];
                        } else if (h[var1] > 50) {
                            return NPCStrings[var1][1];
                        } else {
                            if (var0.U[8] > 50) {
                                return NPCStrings[var1][2];
                            }

                            --p[var1];
                            return a(var0, var3);
                        }
                    } else {
                        if (var2 == 6) {
                            b[var1] = false;
                            Dungeon var7 = ESGame.dungeons[0];
                            var7.DngnVec[J[var1]][ia[var1]] = func.c((byte)32, var7.DngnVec[J[var1]][ia[var1]]);
                            return NPCStrings[var1][19];
                        }

                        return null;
                    }
                }
            case 4:
                if (var2 == 1) {
                    if (q[var1]) {
                        q[var1] = false;
                        return NPCStrings[var1][0];
                    }

                    return null;
                } else if (var2 == 4) {
                    var5 = Math.abs(var0.H[var3]);
                    var6 = Item.a(1, var5);
                    if (var6 != 13 && var6 != 15 && var6 != 17) {
                        ++a;
                        var0.y(var3);
                        return NPCStrings[var1][2];
                    }

                    return NPCStrings[var1][1];
                } else {
                    if (var2 == 7) {
                        if (a / 3 > 0) {
                            short var8 = Item.a();
                            boolean var9 = var0.b(var3, var8, 0);
                            if (!var9) {
                                return NPCStrings[7][0];
                            }

                            a = (short)(a - 3);
                            return NPCStrings[var1][3];
                        }

                        return NPCStrings[var1][4];
                    }

                    return null;
                }
            case 5:
                if (var2 == 1) {
                    System.out.println("Greeting Helga");
                    if (q[var1]) {
                        System.out.println("first meeting");
                        q[var1] = false;
                        var0.Y = 0;
                        System.out.println("message[iNPC] length is " + NPCStrings[var1].length);
                        System.out.println(NPCStrings[var1][0]);
                        System.out.println(NPCStrings[var1][2]);
                        if (l) {
                            l = false;
                            return NPCStrings[5][21] + "\n" + NPCStrings[var1][0] + "\n" + NPCStrings[var1][2];
                        }

                        return NPCStrings[var1][0] + "\n" + NPCStrings[var1][2];
                    } else {
                        var4 = ESGame.d(var0.W);
                        if (var4 > var0.Y) {
                            ++var0.Y;
                            if (l) {
                                l = false;
                                return NPCStrings[5][21] + "\n" + NPCStrings[var1][2 + var0.Y];
                            }

                            return NPCStrings[var1][2 + var0.Y];
                        } else {
                            if (l) {
                                l = false;
                                return NPCStrings[5][21];
                            }

                            return null;
                        }
                    }
                } else if (var2 == 13) {
                    return NPCStrings[var1][2 + var0.Y];
                } else if (var2 == 4) {
                    var5 = Math.abs(var0.H[var3]);
                    if (Item.a(1, var5) == 13) {
                        var6 = var0.D(var3);
                        if (var6 > 3) {
                            g = (short)(g + 5);
                        } else {
                            g = (short)(g + 3);
                        }

                        var0.y(var3);
                        return NPCStrings[var1][11];
                    }

                    return NPCStrings[var1][12];
                } else if (var2 == 8) {
                    if (g < 7) {
                        return NPCStrings[var1][1];
                    } else {
                        var5 = Math.abs(var0.H[var3]);
                        if (Item.b(var5) && !var0.j(var3)) {
                            g = (short)(g - 7);
                            var0.h(var3);
                            return NPCStrings[var1][13];
                        }

                        return NPCStrings[var1][14];
                    }
                } else if (var2 == 9) {
                    if (g < 2) {
                        return NPCStrings[var1][1];
                    } else {
                        if (var0.f) {
                            return NPCStrings[var1][15];
                        }

                        var0.f = true;
                        g = (short)(g - 2);
                        return NPCStrings[var1][16];
                    }
                } else if (var2 == 10) {
                    if (g < 1) {
                        return NPCStrings[var1][1];
                    }

                    var0.A = 0;
                    --g;
                    return NPCStrings[var1][17];
                } else if (var2 == 11) {
                    if (g < 1) {
                        return NPCStrings[var1][1];
                    } else {
                        if (!var0.x()) {
                            return NPCStrings[var1][18];
                        }

                        --g;
                        var0.e();
                        return NPCStrings[var1][19];
                    }
                } else {
                    if (var2 == 12) {
                        var0.U[2] = var0.U[3];
                        var0.U[4] = var0.U[5];
                        return NPCStrings[var1][20];
                    }

                    return null;
                }
            case 6:
                if (f == 0) {
                    return null;
                } else if (f == 1 && var0.m == 0) {
                    var0.m = 1;
                    return NPCStrings[var1][0];
                } else if (f == 2 && var0.m <= 1) {
                    var0.m = 2;
                    return NPCStrings[var1][1];
                } else if (f == 3 && var0.m <= 2) {
                    var0.m = 3;
                    return NPCStrings[var1][2];
                } else {
                    if (f == 4 && var0.m <= 3) {
                        var0.m = 4;
                        return NPCStrings[var1][3] + "\n" + NPCStrings[var1][4];
                    }

                    return null;
                }
            default:
                return null;
        }
    }

    static boolean a(Character var0) {
        if (var0.j != 1) {
            return false;
        } else {
            int var1 = Math.abs(var0.l - J[6]);
            int var2 = Math.abs(var0.Ka - ia[6]);
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
        b();
    }
}
