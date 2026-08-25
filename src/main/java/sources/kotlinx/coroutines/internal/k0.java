package kotlinx.coroutines.internal;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class k0 {
    private static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(k0.class, "_size$volatile");
    private volatile /* synthetic */ int _size$volatile;
    private l0[] a;

    private final l0[] g() {
        l0[] l0VarArr = this.a;
        if (l0VarArr == null) {
            l0[] l0VarArr2 = new l0[4];
            this.a = l0VarArr2;
            return l0VarArr2;
        }
        if (c() < l0VarArr.length) {
            return l0VarArr;
        }
        Object[] copyOf = Arrays.copyOf(l0VarArr, c() * 2);
        Intrinsics.g(copyOf, "copyOf(...)");
        l0[] l0VarArr3 = (l0[]) copyOf;
        this.a = l0VarArr3;
        return l0VarArr3;
    }

    private final void k(int i) {
        b.set(this, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0028, code lost:
    
        if (((java.lang.Comparable) r3).compareTo(r4) < 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void l(int i) {
        while (true) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            if (i3 >= c()) {
                return;
            }
            l0[] l0VarArr = this.a;
            Intrinsics.e(l0VarArr);
            int i4 = i2 + 2;
            if (i4 < c()) {
                l0 l0Var = l0VarArr[i4];
                Intrinsics.e(l0Var);
                l0 l0Var2 = l0VarArr[i3];
                Intrinsics.e(l0Var2);
            }
            i4 = i3;
            l0 l0Var3 = l0VarArr[i];
            Intrinsics.e(l0Var3);
            l0 l0Var4 = l0VarArr[i4];
            Intrinsics.e(l0Var4);
            if (((Comparable) l0Var3).compareTo(l0Var4) <= 0) {
                return;
            }
            n(i, i4);
            i = i4;
        }
    }

    private final void m(int i) {
        while (i > 0) {
            l0[] l0VarArr = this.a;
            Intrinsics.e(l0VarArr);
            int i2 = (i - 1) / 2;
            l0 l0Var = l0VarArr[i2];
            Intrinsics.e(l0Var);
            l0 l0Var2 = l0VarArr[i];
            Intrinsics.e(l0Var2);
            if (((Comparable) l0Var).compareTo(l0Var2) <= 0) {
                return;
            }
            n(i, i2);
            i = i2;
        }
    }

    private final void n(int i, int i2) {
        l0[] l0VarArr = this.a;
        Intrinsics.e(l0VarArr);
        l0 l0Var = l0VarArr[i2];
        Intrinsics.e(l0Var);
        l0 l0Var2 = l0VarArr[i];
        Intrinsics.e(l0Var2);
        l0VarArr[i] = l0Var;
        l0VarArr[i2] = l0Var2;
        l0Var.setIndex(i);
        l0Var2.setIndex(i2);
    }

    public final void a(l0 l0Var) {
        l0Var.setHeap(this);
        l0[] g = g();
        int c = c();
        k(c + 1);
        g[c] = l0Var;
        l0Var.setIndex(c);
        m(c);
    }

    public final l0 b() {
        l0[] l0VarArr = this.a;
        if (l0VarArr != null) {
            return l0VarArr[0];
        }
        return null;
    }

    public final int c() {
        return b.get(this);
    }

    public final boolean e() {
        return c() == 0;
    }

    public final l0 f() {
        l0 b2;
        synchronized (this) {
            b2 = b();
        }
        return b2;
    }

    public final boolean h(l0 l0Var) {
        boolean z;
        synchronized (this) {
            if (l0Var.getHeap() == null) {
                z = false;
            } else {
                i(l0Var.getIndex());
                z = true;
            }
        }
        return z;
    }

    public final l0 i(int i) {
        l0[] l0VarArr = this.a;
        Intrinsics.e(l0VarArr);
        k(c() - 1);
        if (i < c()) {
            n(i, c());
            int i2 = (i - 1) / 2;
            if (i > 0) {
                l0 l0Var = l0VarArr[i];
                Intrinsics.e(l0Var);
                l0 l0Var2 = l0VarArr[i2];
                Intrinsics.e(l0Var2);
                if (((Comparable) l0Var).compareTo(l0Var2) < 0) {
                    n(i, i2);
                    m(i2);
                }
            }
            l(i);
        }
        l0 l0Var3 = l0VarArr[c()];
        Intrinsics.e(l0Var3);
        l0Var3.setHeap(null);
        l0Var3.setIndex(-1);
        l0VarArr[c()] = null;
        return l0Var3;
    }

    public final l0 j() {
        l0 i;
        synchronized (this) {
            i = c() > 0 ? i(0) : null;
        }
        return i;
    }
}
