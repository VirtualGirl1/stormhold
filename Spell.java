//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.DataInputStream;

public class Spell { // b
    String Name;
    byte School;
    byte Cost;
    byte f;
    byte d;
    byte j;
    byte g;
    String Description;
    static int SpellCount;
    static Spell[] spells;

    Spell() {
    }

    static int Dcrmnt(int var0) {
        return var0 - 1;
    }

    static Spell GetSpell(int var0) {
        return spells[Dcrmnt(var0)];
    }

    static boolean ValidateSpellNum(int var0) {
        return var0 >= 1 && var0 <= SpellCount;
    }

    static boolean b(int var0) {
        int var1 = Dcrmnt(var0);
        Spell var2 = spells[var1];
        return var2.d == 2;
    }

    static void LoadSpells() {
        try {
            DataInputStream var0 = func.LoadDatStream("/spellsin.dat");
            SpellCount = var0.readShort();
            spells = new Spell[SpellCount];

            for(int var1 = 0; var1 < SpellCount; ++var1) {
                spells[var1] = new Spell();
            }

            System.out.println("Number of spells is " + SpellCount);

            for(int var2 = 0; var2 < SpellCount; ++var2) {
                spells[var2].Name = var0.readUTF();
            }

            for(int var3 = 0; var3 < SpellCount; ++var3) {
                spells[var3].School = var0.readByte();
            }

            for(int var4 = 0; var4 < SpellCount; ++var4) {
                spells[var4].Cost = var0.readByte();
            }

            for(int var5 = 0; var5 < SpellCount; ++var5) {
                spells[var5].f = var0.readByte();
            }

            for(int var6 = 0; var6 < SpellCount; ++var6) {
                spells[var6].d = var0.readByte();
            }

            for(int var7 = 0; var7 < SpellCount; ++var7) {
                spells[var7].j = var0.readByte();
            }

            for(int var8 = 0; var8 < SpellCount; ++var8) {
                spells[var8].g = var0.readByte();
            }

            for(int var9 = 0; var9 < SpellCount; ++var9) {
                spells[var9].Description = var0.readUTF();
            }

            var0.close();
        } catch (Exception var10) {
            System.out.println("ERROR: cannot load spells!");
            System.out.println(var10);
        }

    }
}
