package pd;

import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class d {
    static final d[] i;
    private static d[] j;
    private final boolean a;
    private final int b;
    private final int c;
    public final int d;
    public final int e;
    private final int f;
    private final int g;
    private final int h;

    static {
        d[] dVarArr = {new d(false, 3, 5, 8, 8, 1), new d(false, 5, 7, 10, 10, 1), new d(true, 5, 7, 16, 6, 1), new d(false, 8, 10, 12, 12, 1), new d(true, 10, 11, 14, 6, 2), new d(false, 12, 12, 14, 14, 1), new d(true, 16, 14, 24, 10, 1), new d(false, 18, 14, 16, 16, 1), new d(false, 22, 18, 18, 18, 1), new d(true, 22, 18, 16, 10, 2), new d(false, 30, 20, 20, 20, 1), new d(true, 32, 24, 16, 14, 2), new d(false, 36, 24, 22, 22, 1), new d(false, 44, 28, 24, 24, 1), new d(true, 49, 28, 22, 14, 2), new d(false, 62, 36, 14, 14, 4), new d(false, 86, 42, 16, 16, 4), new d(false, 114, 48, 18, 18, 4), new d(false, 144, 56, 20, 20, 4), new d(false, 174, 68, 22, 22, 4), new d(false, 204, 84, 24, 24, 4, 102, 42), new d(false, 280, 112, 14, 14, 16, 140, 56), new d(false, 368, 144, 16, 16, 16, 92, 36), new d(false, 456, PsExtractor.AUDIO_STREAM, 18, 18, 16, 114, 48), new d(false, 576, 224, 20, 20, 16, 144, 56), new d(false, 696, 272, 22, 22, 16, 174, 68), new d(false, 816, 336, 24, 24, 16, 136, 56), new d(false, 1050, 408, 18, 18, 36, 175, 68), new d(false, 1304, 496, 20, 20, 36, 163, 62), new a()};
        i = dVarArr;
        j = dVarArr;
    }

    public d(boolean z, int i2, int i3, int i4, int i5, int i6) {
        this(z, i2, i3, i4, i5, i6, i2, i3);
    }

    d(boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.a = z;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = i7;
        this.h = i8;
    }

    private int e() {
        int i2 = this.f;
        int i3 = 1;
        if (i2 != 1) {
            i3 = 2;
            if (i2 != 2 && i2 != 4) {
                if (i2 == 16) {
                    return 4;
                }
                if (i2 == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return i3;
    }

    private int k() {
        int i2 = this.f;
        if (i2 == 1 || i2 == 2) {
            return 1;
        }
        if (i2 == 4) {
            return 2;
        }
        if (i2 == 16) {
            return 4;
        }
        if (i2 == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    public static d l(int i2, SymbolShapeHint symbolShapeHint, com.google.zxing.c cVar, com.google.zxing.c cVar2, boolean z) {
        for (d dVar : j) {
            if (!(symbolShapeHint == SymbolShapeHint.FORCE_SQUARE && dVar.a) && ((symbolShapeHint != SymbolShapeHint.FORCE_RECTANGLE || dVar.a) && i2 <= dVar.b)) {
                return dVar;
            }
        }
        if (!z) {
            return null;
        }
        throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: " + i2);
    }

    public final int a() {
        return this.b;
    }

    public int b(int i2) {
        return this.g;
    }

    public final int c() {
        return this.c;
    }

    public final int d(int i2) {
        return this.h;
    }

    public int f() {
        return this.b / this.g;
    }

    public final int g() {
        return k() * this.e;
    }

    public final int h() {
        return e() * this.d;
    }

    public final int i() {
        return g() + (k() * 2);
    }

    public final int j() {
        return h() + (e() * 2);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.a ? "Rectangular Symbol:" : "Square Symbol:");
        sb2.append(" data region ");
        sb2.append(this.d);
        sb2.append('x');
        sb2.append(this.e);
        sb2.append(", symbol size ");
        sb2.append(j());
        sb2.append('x');
        sb2.append(i());
        sb2.append(", symbol data size ");
        sb2.append(h());
        sb2.append('x');
        sb2.append(g());
        sb2.append(", codewords ");
        sb2.append(this.b);
        sb2.append('+');
        sb2.append(this.c);
        return sb2.toString();
    }
}
