package i9;

import com.google.android.exoplayer2.p1;
import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface e0 {

    public static final class a {
        public final int a;
        public final byte[] b;
        public final int c;
        public final int d;

        public a(int i, byte[] bArr, int i2, int i3) {
            this.a = i;
            this.b = bArr;
            this.c = i2;
            this.d = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.c == aVar.c && this.d == aVar.d && Arrays.equals(this.b, aVar.b);
        }

        public int hashCode() {
            return (((((this.a * 31) + Arrays.hashCode(this.b)) * 31) + this.c) * 31) + this.d;
        }
    }

    int a(com.google.android.exoplayer2.upstream.g gVar, int i, boolean z, int i2);

    int b(com.google.android.exoplayer2.upstream.g gVar, int i, boolean z);

    void c(com.google.android.exoplayer2.util.d0 d0Var, int i);

    void d(p1 p1Var);

    void e(long j, int i, int i2, int i3, a aVar);

    void f(com.google.android.exoplayer2.util.d0 d0Var, int i, int i2);
}
