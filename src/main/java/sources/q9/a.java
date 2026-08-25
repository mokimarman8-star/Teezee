package q9;

import com.google.android.exoplayer2.util.d0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
abstract class a {
    public final int a;

    /* renamed from: q9.a$a, reason: collision with other inner class name */
    static final class C0062a extends a {
        public final long b;
        public final List c;
        public final List d;

        public C0062a(int i, long j) {
            super(i);
            this.b = j;
            this.c = new ArrayList();
            this.d = new ArrayList();
        }

        public void d(C0062a c0062a) {
            this.d.add(c0062a);
        }

        public void e(b bVar) {
            this.c.add(bVar);
        }

        public C0062a f(int i) {
            int size = this.d.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0062a c0062a = (C0062a) this.d.get(i2);
                if (c0062a.a == i) {
                    return c0062a;
                }
            }
            return null;
        }

        public b g(int i) {
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = (b) this.c.get(i2);
                if (bVar.a == i) {
                    return bVar;
                }
            }
            return null;
        }

        @Override // q9.a
        public String toString() {
            return a.a(this.a) + " leaves: " + Arrays.toString(this.c.toArray()) + " containers: " + Arrays.toString(this.d.toArray());
        }
    }

    static final class b extends a {
        public final d0 b;

        public b(int i, d0 d0Var) {
            super(i);
            this.b = d0Var;
        }
    }

    public a(int i) {
        this.a = i;
    }

    public static String a(int i) {
        return "" + ((char) ((i >> 24) & 255)) + ((char) ((i >> 16) & 255)) + ((char) ((i >> 8) & 255)) + ((char) (i & 255));
    }

    public static int b(int i) {
        return i & 16777215;
    }

    public static int c(int i) {
        return (i >> 24) & 255;
    }

    public String toString() {
        return a(this.a);
    }
}
