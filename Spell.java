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
            DataInputStream data = func.LoadDatStream("/spellsin.dat");
            SpellCount = data.readShort();
            spells = new Spell[SpellCount];

            for(int i = 0; i < SpellCount; ++i) {
                spells[i] = new Spell();
            }

            System.out.println("Number of spells is " + SpellCount);

            for(int i = 0; i < SpellCount; ++i) {
                spells[i].Name = data.readUTF();
            }

            for(int i = 0; i < SpellCount; ++i) {
                spells[i].School = data.readByte();
            }

            for(int i = 0; i < SpellCount; ++i) {
                spells[i].Cost = data.readByte();
            }

            for(int i = 0; i < SpellCount; ++i) {
                spells[i].f = data.readByte();
            }

            for(int i = 0; i < SpellCount; ++i) {
                spells[i].d = data.readByte();
            }

            for(int i = 0; i < SpellCount; ++i) {
                spells[i].J = data.readByte();
            }

            for(int i = 0; i < SpellCount; ++i) {
                spells[i].g = data.readByte();
            }

            for(int i = 0; i < SpellCount; ++i) {
                spells[i].Description = data.readUTF();
            }

            data.close();
        } catch (Exception err) {
            System.out.println("ERROR: cannot load spells!");
            System.out.println(err);
        }

    }
}
