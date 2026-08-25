package na;

import android.util.Pair;
import com.google.android.exoplayer2.a3;
import com.google.android.exoplayer2.b3;
import com.google.android.exoplayer2.l3;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.z2;
import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class u extends b0 {
    private a c;

    public static final class a {
        private final int a;
        private final String[] b;
        private final int[] c;
        private final v9.y[] d;
        private final int[] e;
        private final int[][][] f;
        private final v9.y g;

        a(String[] strArr, int[] iArr, v9.y[] yVarArr, int[] iArr2, int[][][] iArr3, v9.y yVar) {
            this.b = strArr;
            this.c = iArr;
            this.d = yVarArr;
            this.f = iArr3;
            this.e = iArr2;
            this.g = yVar;
            this.a = iArr.length;
        }

        public int a(int i, int i2, boolean z) {
            int i3 = this.d[i].b(i2).a;
            int[] iArr = new int[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                int g = g(i, i2, i5);
                if (g == 4 || (z && g == 3)) {
                    iArr[i4] = i5;
                    i4++;
                }
            }
            return b(i, i2, Arrays.copyOf(iArr, i4));
        }

        public int b(int i, int i2, int[] iArr) {
            int i3 = 0;
            int i4 = 16;
            String str = null;
            boolean z = false;
            int i5 = 0;
            while (i3 < iArr.length) {
                String str2 = this.d[i].b(i2).c(iArr[i3]).l;
                int i6 = i5 + 1;
                if (i5 == 0) {
                    str = str2;
                } else {
                    z |= !p0.c(str, str2);
                }
                i4 = Math.min(i4, z2.d(this.f[i][i2][i3]));
                i3++;
                i5 = i6;
            }
            return z ? Math.min(i4, this.e[i]) : i4;
        }

        public int c(int i, int i2, int i3) {
            return this.f[i][i2][i3];
        }

        public int d() {
            return this.a;
        }

        public int e(int i) {
            return this.c[i];
        }

        public v9.y f(int i) {
            return this.d[i];
        }

        public int g(int i, int i2, int i3) {
            return z2.f(c(i, i2, i3));
        }

        public v9.y h() {
            return this.g;
        }
    }

    private static int k(a3[] a3VarArr, v9.w wVar, int[] iArr, boolean z) {
        int length = a3VarArr.length;
        int i = 0;
        boolean z2 = true;
        for (int i2 = 0; i2 < a3VarArr.length; i2++) {
            a3 a3Var = a3VarArr[i2];
            int i3 = 0;
            for (int i4 = 0; i4 < wVar.a; i4++) {
                i3 = Math.max(i3, z2.f(a3Var.a(wVar.c(i4))));
            }
            boolean z3 = iArr[i2] == 0;
            if (i3 > i || (i3 == i && z && !z2 && z3)) {
                length = i2;
                z2 = z3;
                i = i3;
            }
        }
        return length;
    }

    private static int[] l(a3 a3Var, v9.w wVar) {
        int[] iArr = new int[wVar.a];
        for (int i = 0; i < wVar.a; i++) {
            iArr[i] = a3Var.a(wVar.c(i));
        }
        return iArr;
    }

    private static int[] m(a3[] a3VarArr) {
        int length = a3VarArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = a3VarArr[i].supportsMixedMimeTypeAdaptation();
        }
        return iArr;
    }

    @Override // na.b0
    public final void f(Object obj) {
        this.c = (a) obj;
    }

    @Override // na.b0
    public final c0 h(a3[] a3VarArr, v9.y yVar, o.b bVar, l3 l3Var) {
        int[] iArr = new int[a3VarArr.length + 1];
        int length = a3VarArr.length + 1;
        v9.w[][] wVarArr = new v9.w[length][];
        int[][][] iArr2 = new int[a3VarArr.length + 1][][];
        for (int i = 0; i < length; i++) {
            int i2 = yVar.a;
            wVarArr[i] = new v9.w[i2];
            iArr2[i] = new int[i2][];
        }
        int[] m = m(a3VarArr);
        for (int i3 = 0; i3 < yVar.a; i3++) {
            v9.w b = yVar.b(i3);
            int k = k(a3VarArr, b, iArr, b.c == 5);
            int[] l = k == a3VarArr.length ? new int[b.a] : l(a3VarArr[k], b);
            int i4 = iArr[k];
            wVarArr[k][i4] = b;
            iArr2[k][i4] = l;
            iArr[k] = i4 + 1;
        }
        v9.y[] yVarArr = new v9.y[a3VarArr.length];
        String[] strArr = new String[a3VarArr.length];
        int[] iArr3 = new int[a3VarArr.length];
        for (int i5 = 0; i5 < a3VarArr.length; i5++) {
            int i6 = iArr[i5];
            yVarArr[i5] = new v9.y((v9.w[]) p0.G0(wVarArr[i5], i6));
            iArr2[i5] = (int[][]) p0.G0(iArr2[i5], i6);
            strArr[i5] = a3VarArr[i5].getName();
            iArr3[i5] = a3VarArr[i5].getTrackType();
        }
        a aVar = new a(strArr, iArr3, yVarArr, m, iArr2, new v9.y((v9.w[]) p0.G0(wVarArr[a3VarArr.length], iArr[a3VarArr.length])));
        Pair n = n(aVar, iArr2, m, bVar, l3Var);
        return new c0((b3[]) n.first, (s[]) n.second, a0.b(aVar, (v[]) n.second), aVar);
    }

    protected abstract Pair n(a aVar, int[][][] iArr, int[] iArr2, o.b bVar, l3 l3Var);
}
