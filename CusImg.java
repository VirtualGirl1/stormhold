//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.InputStream;

public class CusImg { // g
    int e;
    int a;
    int h;
    boolean c;
    short d;
    short f;
    short[] g;
    static short[] b = new short[256];

    private CusImg() {
        this.e = this.a = 0;
        this.g = null;
        this.f = -1;
    }

    static CusImg LoadCus(String var0) throws Exception {
        InputStream var1 = (new Object()).getClass().getResourceAsStream(FormatString(var0));
        if (var1 == null) {
            throw new Exception("Image " + var0 + " is null!");
        } else {
            CusImg var2 = new CusImg();
            var2.e = b(var1);
            var2.a = b(var1);
            var2.h = var2.e;
            int var3 = var1.read() & 255;
            if (var3 != 0) {
                var2.c = true;
            } else {
                var2.c = false;
            }

            var2.d = a(var1);
            int var4 = var1.read() & 255;
            if (var4 > 255) {
                throw new Exception("Too many colors in image " + var0);
            } else {
                int var6;
                for(int i = 0; i < var4; ++i) {
                    var6 = a(var1);
                    b[i] = (short)var6;
                    if (var2.c && var2.f < 0 && var2.d == var6) {
                        var2.f = (short)i;
                    }
                }

                var6 = var2.e * var2.a;
                var2.g = new short[var6];

                for(int i = 0; i < var6; ++i) {
                    int var8 = var1.read() & 255;
                    short var9 = b[var8];
                    if (var2.c && var8 == var2.f) {
                        var9 = (short)(var9 & -61441);
                    } else {
                        var9 = (short)(var9 | '\uf000');
                    }

                    var2.g[i] = var9;
                }

                return var2;
            }
        }
    }

    int a() {
        return this.e;
    }

    int b() {
        return this.a;
    }

    private static String FormatString(String var0) {
        return var0.startsWith("/") ? var0 : "/" + var0;
    }

    private static int b(InputStream var0) throws Exception {
        int var5 = 0;
        int var1 = var0.read();
        var5 |= var1 << 24;
        int var2 = var0.read();
        var5 |= var2 << 16;
        int var3 = var0.read();
        var5 |= var3 << 8;
        int var4 = var0.read();
        var5 |= var4;
        return var5;
    }

    private static short a(InputStream var0) throws Exception {
        int var5 = 0;
        int var1 = var0.read();
        var5 |= var1 << 8;
        int var2 = var0.read();
        var5 |= var2;
        var5 &= 65535;
        return (short)var5;
    }
}
