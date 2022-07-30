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
    byte J;
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

            for(int i = 0; i < SpellCount; ++i) {
                spells[i] = new Spell();
            }

            System.out.println("Number of spells is " + SpellCount);

            for(int i = 0; i < SpellCount; ++i) {
                spells[i].Name = var0.readUTF();
            }

            for(int i = 0; i < SpellCount; ++i) {
                spells[i].School = var0.readByte();
            }

            for(int i = 0; i < SpellCount; ++i) {
                spells[i].Cost = var0.readByte();
            }

            for(int i = 0; i < SpellCount; ++i) {
                spells[i].f = var0.readByte();
            }

            for(int i = 0; i < SpellCount; ++i) {
                spells[i].d = var0.readByte();
            }

            for(int i = 0; i < SpellCount; ++i) {
                spells[i].J = var0.readByte();
            }

            for(int i = 0; i < SpellCount; ++i) {
                spells[i].g = var0.readByte();
            }

            for(int i = 0; i < SpellCount; ++i) {
                spells[i].Description = var0.readUTF();
            }

            var0.close();
        } catch (Exception var10) {
            System.out.println("ERROR: cannot load spells!");
            System.out.println(var10);
        }

    }
}
