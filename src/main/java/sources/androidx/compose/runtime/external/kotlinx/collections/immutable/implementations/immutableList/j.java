package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class j {
    public static final int a(int i5, int i6) {
        return (i5 >> i6) & 31;
    }

    public static final t.f b() {
        return h.f2715b.a();
    }

    public static final Object[] c(Object obj) {
        Object[] objArr = new Object[32];
        objArr[0] = obj;
        return objArr;
    }

    public static final int d(int i5) {
        return (i5 - 1) & (-32);
    }
}
