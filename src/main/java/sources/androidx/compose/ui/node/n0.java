package androidx.compose.ui.node;

import java.util.List;
import kotlin.jvm.functions.Function0;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class n0 {

    /* renamed from: c, reason: collision with root package name */
    public static final int f4412c = androidx.compose.runtime.collection.b.f2677d;

    /* renamed from: a, reason: collision with root package name */
    private final androidx.compose.runtime.collection.b f4413a;

    /* renamed from: b, reason: collision with root package name */
    private final Function0 f4414b;

    public n0(androidx.compose.runtime.collection.b bVar, Function0 function0) {
        this.f4413a = bVar;
        this.f4414b = function0;
    }

    public final void a(int i5, Object obj) {
        this.f4413a.a(i5, obj);
        this.f4414b.invoke();
    }

    public final List b() {
        return this.f4413a.g();
    }

    public final void c() {
        this.f4413a.h();
        this.f4414b.invoke();
    }

    public final Object d(int i5) {
        return this.f4413a.m()[i5];
    }

    public final int e() {
        return this.f4413a.n();
    }

    public final androidx.compose.runtime.collection.b f() {
        return this.f4413a;
    }

    public final Object g(int i5) {
        Object v5 = this.f4413a.v(i5);
        this.f4414b.invoke();
        return v5;
    }
}
