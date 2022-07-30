//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Random;

public class func { // f
    private static Object b = new Object();
    static int a = 0;

    private func() {
    }

    static byte[] LoadBytes(int var0, InputStream var1) throws Exception {
        if (var0 > 0) {
            byte[] var5 = new byte[var0];
            var1.read(var5);
            return var5;
        } else {
            ByteArrayOutputStream var2 = new ByteArrayOutputStream();

            int var3;
            while((var3 = var1.read()) != -1) {
                var2.write(var3);
            }

            byte[] var4 = var2.toByteArray();
            return var4;
        }
    }

    static String FormatString(String var0) {
        return var0.startsWith("/") ? var0 : "/" + var0;
    }

    static DataInputStream LoadDatStream(String var0) throws Exception {
        return ESGame.LoadDatRaw(var0);
    }

    static int a(int var0) {
        return ESGame.f(var0);
    }

    static int a(Random var0, int var1) {
        return ESGame.a(var0, var1);
    }

    static String StrCatComma(int var0, int var1) {
        return var0 + "," + var1;
    }

    static String StringInsert(String string, String del, int value) {
        String var3 = "" + value;
        return StringInsert(string, del, var3);
    }

    static String StringInsert(String string, String del, String[] values) {
        int var3 = values.length;
        String FinalString = string;

        for(int i = 0; i < var3; ++i) {
            String var6 = values[i];
            FinalString = StringInsert(FinalString, del, var6);
        }

        return FinalString;
    }

    static String StringInsert(String string, String del, String value) {
        if (string != null && del != null) {
            int var3 = string.indexOf(del);
            if (var3 < 0) {
                return string;
            } else {
                String var4 = string.substring(0, var3);
                if (var4 == null) {
                    var4 = "";
                }

                String var5 = string.substring(var3 + del.length());
                if (var5 == null) {
                    var5 = "";
                }

                String FinalString = var4 + value + var5;
                return FinalString;
            }
        } else {
            return string;
        }
    }

    static int a(int var0, int var1) {
        var1 |= 1 << var0;
        return var1;
    }

    static int c(int var0, int var1) {
        var1 &= ~(1 << var0);
        return var1;
    }

    static byte b(byte var0, byte var1) {
        var1 |= var0;
        return var1;
    }

    static byte c(byte var0, byte var1) {
        var1 = (byte)(var1 & ~var0);
        return var1;
    }

    static boolean a(byte var0, byte var1) {
        return (var1 & var0) != 0;
    }

    static long a(byte[] var0, int var1) {
        long var2 = 0L;

        for(int i = 0; i < 8; ++i) {
            long var5 = (long)(var0[i + var1] & 255);
            int var7 = (7 - i) * 8;
            var2 |= var5 << var7;
        }

        return var2;
    }

    public static String[] c(String var0) {
        var0 = var0.trim();
        int var1 = 1;
        int var2 = var0.length();
        boolean var3 = false;

        for(int i = 0; i < var2; ++i) {
            if (var0.charAt(i) == ' ') {
                if (!var3) {
                    ++var1;
                    var3 = true;
                }
            } else {
                var3 = false;
            }
        }

        String[] var5 = new String[var1];
        int var6 = 0;
        int var7 = 0;

        for(int i = 0; i < var2; ++i) {
            if (var0.charAt(i) == ' ') {
                if (!var3) {
                    var5[var7++] = var0.substring(var6, i);
                    var6 = i + 1;
                    var3 = true;
                } else {
                    ++var6;
                }
            } else {
                var3 = false;
            }
        }

        var5[var7] = var0.substring(var6, var2);
        return var5;
    }
}
