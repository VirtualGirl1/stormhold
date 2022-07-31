//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.InputStream;

public class CusImg { // g
    int Width;
    int Height;
    int ScanLen;
    boolean c;
    short d;
    short f;
    short[] ImgBuf;
    static short[] b = new short[256];

    private CusImg() {
        this.Width = this.Height = 0;
        this.ImgBuf = null;
        this.f = -1;
    }

    static CusImg LoadCus(String file) throws Exception {
        InputStream stream = (new Object()).getClass().getResourceAsStream(FormatString(file));
        if (stream == null) {
            throw new Exception("Image " + file + " is null!");
        } else {
            CusImg img = new CusImg();
            img.Width = ReadInt(stream);
            img.Height = ReadInt(stream);
            img.ScanLen = img.Width;
            int var3 = stream.read() & 255;
            if (var3 != 0) {
                img.c = true;
            } else {
                img.c = false;
            }

            img.d = ReadPixel(stream);
            int var4 = stream.read() & 255;
            if (var4 > 255) {
                throw new Exception("Too many colors in image " + file);
            } else {
                int var6;
                for(int i = 0; i < var4; ++i) {
                    var6 = ReadPixel(stream);
                    b[i] = (short)var6;
                    if (img.c && img.f < 0 && img.d == var6) {
                        img.f = (short)i;
                    }
                }

                var6 = img.Width * img.Height;
                img.ImgBuf = new short[var6];

                for(int i = 0; i < var6; ++i) {
                    int var8 = stream.read() & 255;
                    short var9 = b[var8];
                    if (img.c && var8 == img.f) {
                        var9 = (short)(var9 & -61441);
                    } else {
                        var9 = (short)(var9 | '\uf000');
                    }

                    img.ImgBuf[i] = var9;
                }

                return img;
            }
        }
    }

    int GetWidth() {
        return this.Width;
    }

    int GetHeight() {
        return this.Height;
    }

    private static String FormatString(String FileName) {
        return FileName.startsWith("/") ? FileName : "/" + FileName;
    }

    private static int ReadInt(InputStream stream) throws Exception {
        int EndVal = 0;
        int b1 = stream.read();
        EndVal |= b1 << 24;
        int b2 = stream.read();
        EndVal |= b2 << 16;
        int b3 = stream.read();
        EndVal |= b3 << 8;
        int b4 = stream.read();
        EndVal |= b4;
        return EndVal;
    }

    private static short ReadPixel(InputStream stream) throws Exception {
        int EndVal = 0;
        int b1 = stream.read();
        EndVal |= b1 << 8;
        int b2 = stream.read();
        EndVal |= b2;
        EndVal &= 65535;
        return (short)EndVal;
    }
}
