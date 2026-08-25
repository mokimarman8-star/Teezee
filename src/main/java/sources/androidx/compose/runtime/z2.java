package androidx.compose.runtime;

import java.util.ArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class z2 {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f3079a = new ArrayList();

    public final void a() {
        this.f3079a.clear();
    }

    public final int b() {
        return this.f3079a.size();
    }

    public final boolean c() {
        return this.f3079a.isEmpty();
    }

    public final boolean d() {
        return !c();
    }

    public final Object e() {
        return this.f3079a.get(b() - 1);
    }

    public final Object f(int i5) {
        return this.f3079a.get(i5);
    }

    public final Object g() {
        return this.f3079a.remove(b() - 1);
    }

    public final boolean h(Object obj) {
        return this.f3079a.add(obj);
    }

    public final Object[] i() {
        int size = this.f3079a.size();
        Object[] objArr = new Object[size];
        for (int i5 = 0; i5 < size; i5++) {
            objArr[i5] = this.f3079a.get(i5);
        }
        return objArr;
    }
}
