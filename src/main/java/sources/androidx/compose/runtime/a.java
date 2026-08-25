package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class a implements f {

    /* renamed from: a, reason: collision with root package name */
    private final Object f2666a;

    /* renamed from: b, reason: collision with root package name */
    private final List f2667b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private Object f2668c;

    public a(Object obj) {
        this.f2666a = obj;
        this.f2668c = obj;
    }

    @Override // androidx.compose.runtime.f
    public final void clear() {
        this.f2667b.clear();
        l(this.f2666a);
        k();
    }

    @Override // androidx.compose.runtime.f
    public Object d() {
        return this.f2668c;
    }

    @Override // androidx.compose.runtime.f
    public /* synthetic */ void e() {
        e.b(this);
    }

    @Override // androidx.compose.runtime.f
    public void g(Object obj) {
        this.f2667b.add(d());
        l(obj);
    }

    @Override // androidx.compose.runtime.f
    public /* synthetic */ void h() {
        e.a(this);
    }

    @Override // androidx.compose.runtime.f
    public void i() {
        if (this.f2667b.isEmpty()) {
            o1.b("empty stack");
        }
        l(this.f2667b.remove(r0.size() - 1));
    }

    public final Object j() {
        return this.f2666a;
    }

    protected abstract void k();

    protected void l(Object obj) {
        this.f2668c = obj;
    }
}
