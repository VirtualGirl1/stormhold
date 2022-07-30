//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Random;

public class func { // f
    private static Object obj = new Object();
    static int a = 0;

    private func() {
    }

    static byte[] LoadBytes(int offset, InputStream stream) throws Exception {
        if (offset > 0) {
            byte[] bytearr = new byte[offset];
            stream.read(bytearr);
            return bytearr;
        } else {
            ByteArrayOutputStream bytestream = new ByteArrayOutputStream();

            int bt;
            while((bt = stream.read()) != -1) {
                bytestream.write(bt);
            }

            byte[] bytearr = bytestream.toByteArray();
            return bytearr;
        }
    }

    static String FormatString(String name) {
        return name.startsWith("/") ? name : "/" + name;
    }

    static DataInputStream LoadDatStream(String name) throws Exception {
        return ESGame.LoadDatRaw(name);
    }

    static int a(int var0) {
        return ESGame.f(var0);
    }

    static int a(Random var0, int var1) {
        return ESGame.a(var0, var1);
    }

    static String StrCatComma(int v1, int v2) {
        return v1 + "," + v2;
    }

    static String StringInsert(String string, String del, int value) {
        String str = "" + value;
        return StringInsert(string, del, str);
    }

    static String StringInsert(String string, String del, String[] values) {
        int valCount = values.length;
        String FinalString = string;

        for(int i = 0; i < valCount; ++i) {
            String val = values[i];
            FinalString = StringInsert(FinalString, del, val);
        }

        return FinalString;
    }

    static String StringInsert(String string, String del, String value) {
        if (string != null && del != null) {
            int indx = string.indexOf(del);
            if (indx < 0) {
                return string;
            } else {
                String str1 = string.substring(0, indx);
                if (str1 == null) {
                    str1 = "";
                }

                String str2 = string.substring(indx + del.length());
                if (str2 == null) {
                    str2 = "";
                }

                String FinalString = str1 + value + str2;
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

    public static String[] c(String str) {
        str = str.trim();
        int spcCount = 1;
        int strlen = str.length();
        boolean space = false;

        for(int i = 0; i < strlen; ++i) {
            if (str.charAt(i) == ' ') {
                if (!space) {
                    ++spcCount;
                    space = true;
                }
            } else {
                space = false;
            }
        }

        String[] strList = new String[spcCount];
        int offset = 0;
        int indx = 0;

        for(int i = 0; i < strlen; ++i) {
            if (str.charAt(i) == ' ') {
                if (!space) {
                    strList[indx++] = str.substring(offset, i);
                    offset = i + 1;
                    space = true;
                } else {
                    ++offset;
                }
            } else {
                space = false;
            }
        }

        strList[indx] = str.substring(offset, strlen);
        return strList;
    }
}
