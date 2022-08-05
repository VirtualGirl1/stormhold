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
    byte Target;
    byte J;
    byte g;
    String Description;
    static int SpellCount;
    static Spell[] spells;

    Spell() {
    }

    static int FormatIndex(int indx) {
        return indx - 1;
    }

    static Spell GetSpell(int spellnum) {
        return spells[FormatIndex(spellnum)];
    }

    static boolean ValidateSpellNum(int spellnum) {
        return spellnum >= 1 && spellnum <= SpellCount;
    }

    static boolean DoesTargetMonster(int indx0) {
        int indx = FormatIndex(indx0);
        Spell spell = spells[indx];
        return spell.Target == 2;
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
                spells[i].Target = data.readByte();
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
