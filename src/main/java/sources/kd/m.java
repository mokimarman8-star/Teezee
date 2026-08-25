package kd;

import com.google.protobuf.h1;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class m implements h {
    private final int[] a;
    private final int b;

    private static final class b {
        private final char a;
        private final int b;
        private final b c;
        private final int d;

        private b(char c, g gVar, int i, b bVar, int i2) {
            char c2 = c == i2 ? (char) 1000 : c;
            this.a = c2;
            this.b = i;
            this.c = bVar;
            int length = c2 == 1000 ? 1 : gVar.b(c, i).length;
            length = (bVar == null ? 0 : bVar.b) != i ? length + 3 : length;
            this.d = bVar != null ? length + bVar.d : length;
        }

        boolean e() {
            return this.a == 1000;
        }
    }

    public m(String str, Charset charset, int i) {
        this.b = i;
        g gVar = new g(str, charset, i);
        if (gVar.g() != 1) {
            this.a = e(str, gVar, i);
            return;
        }
        this.a = new int[str.length()];
        for (int i2 = 0; i2 < this.a.length; i2++) {
            char charAt = str.charAt(i2);
            int[] iArr = this.a;
            if (charAt == i) {
                charAt = 1000;
            }
            iArr[i2] = charAt;
        }
    }

    static void c(b[][] bVarArr, int i, b bVar) {
        if (bVarArr[i][bVar.b] == null || bVarArr[i][bVar.b].d > bVar.d) {
            bVarArr[i][bVar.b] = bVar;
        }
    }

    static void d(String str, g gVar, b[][] bVarArr, int i, b bVar, int i2) {
        int i3;
        int i4;
        char charAt = str.charAt(i);
        int g = gVar.g();
        if (gVar.f() < 0 || !(charAt == i2 || gVar.a(charAt, gVar.f()))) {
            i3 = g;
            i4 = 0;
        } else {
            i4 = gVar.f();
            i3 = i4 + 1;
        }
        for (int i5 = i4; i5 < i3; i5++) {
            if (charAt == i2 || gVar.a(charAt, i5)) {
                c(bVarArr, i + 1, new b(charAt, gVar, i5, bVar, i2));
            }
        }
    }

    static int[] e(String str, g gVar, int i) {
        int length = str.length();
        b[][] bVarArr = (b[][]) Array.newInstance((Class<?>) b.class, length + 1, gVar.g());
        d(str, gVar, bVarArr, 0, null, i);
        for (int i2 = 1; i2 <= length; i2++) {
            for (int i3 = 0; i3 < gVar.g(); i3++) {
                b bVar = bVarArr[i2][i3];
                if (bVar != null && i2 < length) {
                    d(str, gVar, bVarArr, i2, bVar, i);
                }
            }
            for (int i4 = 0; i4 < gVar.g(); i4++) {
                bVarArr[i2 - 1][i4] = null;
            }
        }
        int i5 = -1;
        int i6 = h1.READ_DONE;
        for (int i7 = 0; i7 < gVar.g(); i7++) {
            b bVar2 = bVarArr[length][i7];
            if (bVar2 != null && bVar2.d < i6) {
                i6 = bVar2.d;
                i5 = i7;
            }
        }
        if (i5 < 0) {
            throw new IllegalStateException("Failed to encode \"" + str + "\"");
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar3 = bVarArr[length][i5]; bVar3 != null; bVar3 = bVar3.c) {
            if (bVar3.e()) {
                arrayList.add(0, 1000);
            } else {
                byte[] b2 = gVar.b(bVar3.a, bVar3.b);
                for (int length2 = b2.length - 1; length2 >= 0; length2--) {
                    arrayList.add(0, Integer.valueOf(b2[length2] & 255));
                }
            }
            if ((bVar3.c == null ? 0 : bVar3.c.b) != bVar3.b) {
                arrayList.add(0, Integer.valueOf(gVar.e(bVar3.b) + 256));
            }
        }
        int size = arrayList.size();
        int[] iArr = new int[size];
        for (int i8 = 0; i8 < size; i8++) {
            iArr[i8] = ((Integer) arrayList.get(i8)).intValue();
        }
        return iArr;
    }

    @Override // kd.h
    public boolean a(int i) {
        if (i >= 0 && i < length()) {
            int i2 = this.a[i];
            return i2 > 255 && i2 <= 999;
        }
        throw new IndexOutOfBoundsException(TtmlNode.ANONYMOUS_REGION_ID + i);
    }

    @Override // kd.h
    public int b(int i) {
        if (i < 0 || i >= length()) {
            throw new IndexOutOfBoundsException(TtmlNode.ANONYMOUS_REGION_ID + i);
        }
        if (a(i)) {
            return this.a[i] - 256;
        }
        throw new IllegalArgumentException("value at " + i + " is not an ECI but a character");
    }

    @Override // kd.h
    public char charAt(int i) {
        if (i < 0 || i >= length()) {
            throw new IndexOutOfBoundsException(TtmlNode.ANONYMOUS_REGION_ID + i);
        }
        if (!a(i)) {
            return (char) (h(i) ? this.b : this.a[i]);
        }
        throw new IllegalArgumentException("value at " + i + " is not a character but an ECI");
    }

    public int f() {
        return this.b;
    }

    public boolean g(int i, int i2) {
        if ((i + i2) - 1 >= this.a.length) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (a(i + i3)) {
                return false;
            }
        }
        return true;
    }

    public boolean h(int i) {
        if (i >= 0 && i < length()) {
            return this.a[i] == 1000;
        }
        throw new IndexOutOfBoundsException(TtmlNode.ANONYMOUS_REGION_ID + i);
    }

    @Override // kd.h
    public int length() {
        return this.a.length;
    }

    @Override // kd.h
    public CharSequence subSequence(int i, int i2) {
        if (i < 0 || i > i2 || i2 > length()) {
            throw new IndexOutOfBoundsException(TtmlNode.ANONYMOUS_REGION_ID + i);
        }
        StringBuilder sb2 = new StringBuilder();
        while (i < i2) {
            if (a(i)) {
                throw new IllegalArgumentException("value at " + i + " is not a character but an ECI");
            }
            sb2.append(charAt(i));
            i++;
        }
        return sb2;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < length(); i++) {
            if (i > 0) {
                sb2.append(", ");
            }
            if (a(i)) {
                sb2.append("ECI(");
                sb2.append(b(i));
                sb2.append(')');
            } else if (charAt(i) < 128) {
                sb2.append('\'');
                sb2.append(charAt(i));
                sb2.append('\'');
            } else {
                sb2.append((int) charAt(i));
            }
        }
        return sb2.toString();
    }
}
