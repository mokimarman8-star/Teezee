package androidx.navigation;

import androidx.navigation.l;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class m {

    /* renamed from: b, reason: collision with root package name */
    private boolean f12539b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f12540c;

    /* renamed from: e, reason: collision with root package name */
    private String f12542e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f12543f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f12544g;

    /* renamed from: a, reason: collision with root package name */
    private final l.a f12538a = new l.a();

    /* renamed from: d, reason: collision with root package name */
    private int f12541d = -1;

    private final void j(String str) {
        if (str != null) {
            if (StringsKt.q0(str)) {
                throw new IllegalArgumentException("Cannot pop up to an empty route");
            }
            this.f12542e = str;
            this.f12543f = false;
        }
    }

    public final void a(Function1 function1) {
        Intrinsics.h(function1, "animBuilder");
        a aVar = new a();
        function1.invoke(aVar);
        this.f12538a.b(aVar.a()).c(aVar.b()).e(aVar.c()).f(aVar.d());
    }

    public final l b() {
        l.a aVar = this.f12538a;
        aVar.d(c());
        aVar.j(f());
        if (e() != null) {
            aVar.h(e(), this.f12543f, this.f12544g);
        } else {
            aVar.g(d(), this.f12543f, this.f12544g);
        }
        return aVar.a();
    }

    public final boolean c() {
        return this.f12539b;
    }

    public final int d() {
        return this.f12541d;
    }

    public final String e() {
        return this.f12542e;
    }

    public final boolean f() {
        return this.f12540c;
    }

    public final void g(int i5, Function1 function1) {
        Intrinsics.h(function1, "popUpToBuilder");
        i(i5);
        j(null);
        s sVar = new s();
        function1.invoke(sVar);
        this.f12543f = sVar.a();
        this.f12544g = sVar.b();
    }

    public final void h(boolean z5) {
        this.f12539b = z5;
    }

    public final void i(int i5) {
        this.f12541d = i5;
        this.f12543f = false;
    }
}
