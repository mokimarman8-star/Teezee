package g9;

import android.util.Base64;
import com.google.android.exoplayer2.l3;
import com.google.android.exoplayer2.source.o;
import g9.c;
import g9.t1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class r1 implements t1 {
    public static final com.google.common.base.q h = new com.google.common.base.q() { // from class: g9.q1
        public final Object get() {
            String k;
            k = r1.k();
            return k;
        }
    };
    private static final Random i = new Random();
    private final l3.d a;
    private final l3.b b;
    private final HashMap c;
    private final com.google.common.base.q d;
    private t1.a e;
    private l3 f;
    private String g;

    private final class a {
        private final String a;
        private int b;
        private long c;
        private o.b d;
        private boolean e;
        private boolean f;

        public a(String str, int i, o.b bVar) {
            this.a = str;
            this.b = i;
            this.c = bVar == null ? -1L : bVar.d;
            if (bVar == null || !bVar.b()) {
                return;
            }
            this.d = bVar;
        }

        private int l(l3 l3Var, l3 l3Var2, int i) {
            if (i >= l3Var.t()) {
                if (i < l3Var2.t()) {
                    return i;
                }
                return -1;
            }
            l3Var.r(i, r1.this.a);
            for (int i2 = r1.this.a.o; i2 <= r1.this.a.p; i2++) {
                int f = l3Var2.f(l3Var.q(i2));
                if (f != -1) {
                    return l3Var2.j(f, r1.this.b).c;
                }
            }
            return -1;
        }

        public boolean i(int i, o.b bVar) {
            if (bVar == null) {
                return i == this.b;
            }
            o.b bVar2 = this.d;
            return bVar2 == null ? !bVar.b() && bVar.d == this.c : bVar.d == bVar2.d && bVar.b == bVar2.b && bVar.c == bVar2.c;
        }

        public boolean j(c.a aVar) {
            long j = this.c;
            if (j == -1) {
                return false;
            }
            o.b bVar = aVar.d;
            if (bVar == null) {
                return this.b != aVar.c;
            }
            if (bVar.d > j) {
                return true;
            }
            if (this.d == null) {
                return false;
            }
            int f = aVar.b.f(bVar.a);
            int f2 = aVar.b.f(this.d.a);
            o.b bVar2 = aVar.d;
            if (bVar2.d < this.d.d || f < f2) {
                return false;
            }
            if (f > f2) {
                return true;
            }
            if (!bVar2.b()) {
                int i = aVar.d.e;
                return i == -1 || i > this.d.b;
            }
            o.b bVar3 = aVar.d;
            int i2 = bVar3.b;
            int i3 = bVar3.c;
            o.b bVar4 = this.d;
            int i4 = bVar4.b;
            return i2 > i4 || (i2 == i4 && i3 > bVar4.c);
        }

        public void k(int i, o.b bVar) {
            if (this.c == -1 && i == this.b && bVar != null) {
                this.c = bVar.d;
            }
        }

        public boolean m(l3 l3Var, l3 l3Var2) {
            int l = l(l3Var, l3Var2, this.b);
            this.b = l;
            if (l == -1) {
                return false;
            }
            o.b bVar = this.d;
            return bVar == null || l3Var2.f(bVar.a) != -1;
        }
    }

    public r1() {
        this(h);
    }

    public r1(com.google.common.base.q qVar) {
        this.d = qVar;
        this.a = new l3.d();
        this.b = new l3.b();
        this.c = new HashMap();
        this.f = l3.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String k() {
        byte[] bArr = new byte[12];
        i.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    private a l(int i2, o.b bVar) {
        a aVar = null;
        long j = Long.MAX_VALUE;
        for (a aVar2 : this.c.values()) {
            aVar2.k(i2, bVar);
            if (aVar2.i(i2, bVar)) {
                long j2 = aVar2.c;
                if (j2 == -1 || j2 < j) {
                    aVar = aVar2;
                    j = j2;
                } else if (j2 == j && ((a) com.google.android.exoplayer2.util.p0.j(aVar)).d != null && aVar2.d != null) {
                    aVar = aVar2;
                }
            }
        }
        if (aVar != null) {
            return aVar;
        }
        String str = (String) this.d.get();
        a aVar3 = new a(str, i2, bVar);
        this.c.put(str, aVar3);
        return aVar3;
    }

    private void m(c.a aVar) {
        if (aVar.b.u()) {
            this.g = null;
            return;
        }
        a aVar2 = (a) this.c.get(this.g);
        a l = l(aVar.c, aVar.d);
        this.g = l.a;
        b(aVar);
        o.b bVar = aVar.d;
        if (bVar == null || !bVar.b()) {
            return;
        }
        if (aVar2 != null && aVar2.c == aVar.d.d && aVar2.d != null && aVar2.d.b == aVar.d.b && aVar2.d.c == aVar.d.c) {
            return;
        }
        o.b bVar2 = aVar.d;
        this.e.k(aVar, l(aVar.c, new o.b(bVar2.a, bVar2.d)).a, l.a);
    }

    @Override // g9.t1
    public synchronized String a() {
        return this.g;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
    
        if (r25.d.d < r2.c) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00df A[Catch: all -> 0x0037, TryCatch #0 {all -> 0x0037, blocks: (B:4:0x0005, B:9:0x0014, B:12:0x0024, B:14:0x002e, B:19:0x003a, B:22:0x0048, B:24:0x0054, B:25:0x005a, B:27:0x005f, B:29:0x0065, B:31:0x007e, B:32:0x00d9, B:34:0x00df, B:35:0x00f5, B:37:0x0101, B:39:0x0107), top: B:3:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f1  */
    @Override // g9.t1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(c.a aVar) {
        a aVar2;
        c.a aVar3;
        a aVar4;
        try {
            com.google.android.exoplayer2.util.a.e(this.e);
        } finally {
        }
        if (aVar.b.u()) {
            return;
        }
        a aVar5 = (a) this.c.get(this.g);
        if (aVar.d != null && aVar5 != null) {
            if (aVar5.c == -1) {
                if (aVar5.b != aVar.c) {
                    return;
                }
            }
        }
        a l = l(aVar.c, aVar.d);
        if (this.g == null) {
            this.g = l.a;
        }
        o.b bVar = aVar.d;
        if (bVar != null && bVar.b()) {
            o.b bVar2 = aVar.d;
            o.b bVar3 = new o.b(bVar2.a, bVar2.d, bVar2.b);
            a l2 = l(aVar.c, bVar3);
            if (!l2.e) {
                l2.e = true;
                aVar.b.l(aVar.d.a, this.b);
                aVar2 = l;
                this.e.v(new c.a(aVar.a, aVar.b, aVar.c, bVar3, Math.max(0L, com.google.android.exoplayer2.util.p0.e1(this.b.i(aVar.d.b)) + this.b.p()), aVar.f, aVar.g, aVar.h, aVar.i, aVar.j), l2.a);
                if (aVar2.e) {
                    aVar4 = aVar2;
                    aVar4.e = true;
                    aVar3 = aVar;
                    this.e.v(aVar3, aVar4.a);
                } else {
                    aVar3 = aVar;
                    aVar4 = aVar2;
                }
                if (aVar4.a.equals(this.g) && !aVar4.f) {
                    aVar4.f = true;
                    this.e.V(aVar3, aVar4.a);
                }
            }
        }
        aVar2 = l;
        if (aVar2.e) {
        }
        if (aVar4.a.equals(this.g)) {
            aVar4.f = true;
            this.e.V(aVar3, aVar4.a);
        }
    }

    @Override // g9.t1
    public void c(t1.a aVar) {
        this.e = aVar;
    }

    @Override // g9.t1
    public synchronized void d(c.a aVar) {
        try {
            com.google.android.exoplayer2.util.a.e(this.e);
            l3 l3Var = this.f;
            this.f = aVar.b;
            Iterator it = this.c.values().iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                if (aVar2.m(l3Var, this.f) && !aVar2.j(aVar)) {
                }
                it.remove();
                if (aVar2.e) {
                    if (aVar2.a.equals(this.g)) {
                        this.g = null;
                    }
                    this.e.x(aVar, aVar2.a, false);
                }
            }
            m(aVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // g9.t1
    public synchronized void e(c.a aVar, int i2) {
        try {
            com.google.android.exoplayer2.util.a.e(this.e);
            boolean z = i2 == 0;
            Iterator it = this.c.values().iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                if (aVar2.j(aVar)) {
                    it.remove();
                    if (aVar2.e) {
                        boolean equals = aVar2.a.equals(this.g);
                        boolean z2 = z && equals && aVar2.f;
                        if (equals) {
                            this.g = null;
                        }
                        this.e.x(aVar, aVar2.a, z2);
                    }
                }
            }
            m(aVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // g9.t1
    public synchronized String f(l3 l3Var, o.b bVar) {
        return l(l3Var.l(bVar.a, this.b).c, bVar).a;
    }

    @Override // g9.t1
    public synchronized void g(c.a aVar) {
        t1.a aVar2;
        this.g = null;
        Iterator it = this.c.values().iterator();
        while (it.hasNext()) {
            a aVar3 = (a) it.next();
            it.remove();
            if (aVar3.e && (aVar2 = this.e) != null) {
                aVar2.x(aVar, aVar3.a, false);
            }
        }
    }
}
