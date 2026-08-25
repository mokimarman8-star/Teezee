package androidx.core.util;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class g implements f {

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f7126a;

    /* renamed from: b, reason: collision with root package name */
    private int f7127b;

    public g(int i5) {
        if (i5 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f7126a = new Object[i5];
    }

    private final boolean a(Object obj) {
        int i5 = this.f7127b;
        for (int i6 = 0; i6 < i5; i6++) {
            if (this.f7126a[i6] == obj) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.core.util.f
    public Object acquire() {
        int i5 = this.f7127b;
        if (i5 <= 0) {
            return null;
        }
        int i6 = i5 - 1;
        Object obj = this.f7126a[i6];
        Intrinsics.f(obj, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
        this.f7126a[i6] = null;
        this.f7127b--;
        return obj;
    }

    @Override // androidx.core.util.f
    public boolean release(Object obj) {
        Intrinsics.h(obj, "instance");
        if (a(obj)) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i5 = this.f7127b;
        Object[] objArr = this.f7126a;
        if (i5 >= objArr.length) {
            return false;
        }
        objArr[i5] = obj;
        this.f7127b = i5 + 1;
        return true;
    }
}
