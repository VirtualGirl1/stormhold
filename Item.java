//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.DataInputStream;
import java.util.Random;

public class Item {
    static int TypeCount;
    static String[] ItemType;
    static int ItemCount;
    static String[] ItemName;
    static byte[] Type;
    static byte[] Level;
    static byte[] Rating;
    static short[] f;
    static short[] a;
    static byte[] Slot;
    static String[][] l = new String[][]{{"Warp to camp", ""}, {"Cures ailment", ""}, {"Restores Health", ""}, {"Restores Magicka", ""}, {"", ""}, {"Grants level", "experience"}, {"Health & Magicka", ""}, {"Increase harm", ""}, {"Increase armor", ""}, {"Safe camping", ""}, {"Kill monster", ""}, {"Kill monster", ""}, {"Kill monster", ""}};
    static byte[][] DroppedItemTable;
    static byte TableRows;
    static short ia;

    Item() {
    }

    static short a() {
        ++ia;
        return ia;
    }

    static int FormatIndex(int indx) {
        return indx - 1;
    }

    static boolean IsEquipable(int indx0) {
        int indx = FormatIndex(indx0);
        return Slot[indx] != -1;
    }

    static boolean IsEquipment(int indx0) {
        int indx = FormatIndex(indx0);
        byte type = Type[indx];
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
                return true;
            default:
                return false;
        }
    }

    static int GetItemSlot(int indx0) {
        int indx = FormatIndex(indx0);
        byte slot = Slot[indx];
        return slot;
    }

    static String GetItemName(int indx0) {
        int indx = FormatIndex(indx0);
        return ItemName[indx];
    }

    static int GetItemProperty(int prop, int indx0) {
        int indx = FormatIndex(indx0);
        short var3;
        switch (prop) {
            case 1:
                var3 = Type[indx];
                break;
            case 2:
                var3 = Level[indx];
                break;
            case 3:
                var3 = Rating[indx];
                break;
            case 4:
                var3 = f[indx];
                break;
            case 5:
                var3 = a[indx];
                break;
            case 6:
                var3 = Slot[indx];
                break;
            default:
                var3 = -1;
        }

        return var3;
    }

    static void LoadAllItems() throws Exception {
        ia = 0;
        LoadItems();
        LoadDroppedItems();
    }

    static void LoadItems() throws Exception {
        DataInputStream data = func.LoadDatStream("/itemsin.dat");
        TypeCount = data.readShort();
        ItemType = new String[TypeCount];

        for(int i = 0; i < TypeCount; ++i) {
            ItemType[i] = data.readUTF();
        }

        ItemCount = data.readShort();
        ItemName = new String[ItemCount];
        Type = new byte[ItemCount];
        Level = new byte[ItemCount];
        Rating = new byte[ItemCount];
        f = new short[ItemCount];
        a = new short[ItemCount];
        Slot = new byte[ItemCount];

        for(int i = 0; i < ItemCount; ++i) {
            ItemName[i] = data.readUTF();
        }

        for(int i = 0; i < ItemCount; ++i) {
            Type[i] = data.readByte();
        }

        for(int i = 0; i < ItemCount; ++i) {
            Level[i] = data.readByte();
        }

        for(int i = 0; i < ItemCount; ++i) {
            Rating[i] = data.readByte();
        }

        for(int i = 0; i < ItemCount; ++i) {
            f[i] = data.readShort();
        }

        for(int i = 0; i < ItemCount; ++i) {
            a[i] = data.readShort();
        }

        for(int i = 0; i < ItemCount; ++i) {
            Slot[i] = data.readByte();
        }

        data.close();
    }

    static void LoadDroppedItems() throws Exception {
        DataInputStream data = func.LoadDatStream("/droppeditemsin.dat");
        short TR = data.readShort();
        TableRows = (byte)TR;
        System.out.println("numTableRows=" + TableRows);
        short TC = data.readShort();
        DroppedItemTable = new byte[TR][TC];

        for(int i = 0; i < TR; ++i) {
            for(int j = 0; j < TC; ++j) {
                DroppedItemTable[i][j] = data.readByte();
            }
        }

        data.close();
    }

    static int a(Random rand, int var1) {
        int var2 = -1;
        int var3 = -1;

        for(int i = 0; i < ItemCount; ++i) {
            if (Type[i] == 11 && Level[i] == (byte)var1) {
                if (var2 == -1) {
                    var2 = i;
                }

                var3 = i;
            }
        }

        int var5 = var3 - var2 + 1;
        int var6 = var2 + Math.abs(rand.nextInt() % var5);
        return 1 + var6;
    }

    static int GetRandItem(Random rand, int var1, int var2) {
        int var3 = func.a(rand, 100);
        int var4 = var3;

        for(int i = 1; i < var2; ++i) {
            var3 = func.a(rand, 100);
            if (var3 > var4) {
                var4 = var3;
            }
        }

        byte var6;
        if (var4 <= 64) {
            var6 = 0;
        } else if (var4 <= 75) {
            var6 = 1;
        } else if (var4 <= 90) {
            var6 = 3;
        } else {
            var6 = 4;
        }

        int var7 = func.a(rand, 10);
        var7 += var1 - 2;
        if (var7 > TableRows - 1) {
            var7 = TableRows - 1;
        }

        if (var7 < 0) {
            var7 = 0;
        }

        byte var8 = DroppedItemTable[var7][var6];
        int var9 = var8;
        if (var6 == 1) {
            byte var10 = DroppedItemTable[var7][2];
            var9 = var8 | var10 << 8;
        }

        System.out.println("in getRandomItem, res = " + var9);
        return var9;
    }

    static String[] GetCrystals() {
        String[] CrystalList = new String[13];

        for(int i = 0; i < 13; ++i) {
            CrystalList[i] = ItemName[86 + i];
        }

        return CrystalList;
    }
}
