package androidx.compose.ui.platform;

import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b2 implements androidx.compose.ui.node.z0 {

    /* renamed from: a, reason: collision with root package name */
    private final int f4734a;

    /* renamed from: b, reason: collision with root package name */
    private final List f4735b;

    /* renamed from: c, reason: collision with root package name */
    private Float f4736c;

    /* renamed from: d, reason: collision with root package name */
    private Float f4737d;

    /* renamed from: e, reason: collision with root package name */
    private androidx.compose.ui.semantics.g f4738e;

    /* renamed from: f, reason: collision with root package name */
    private androidx.compose.ui.semantics.g f4739f;

    public b2(int i5, List list, Float f5, Float f6, androidx.compose.ui.semantics.g gVar, androidx.compose.ui.semantics.g gVar2) {
        this.f4734a = i5;
        this.f4735b = list;
        this.f4736c = f5;
        this.f4737d = f6;
        this.f4738e = gVar;
        this.f4739f = gVar2;
    }

    public final androidx.compose.ui.semantics.g a() {
        return this.f4738e;
    }

    public final Float b() {
        return this.f4736c;
    }

    public final Float c() {
        return this.f4737d;
    }

    public final int d() {
        return this.f4734a;
    }

    public final androidx.compose.ui.semantics.g e() {
        return this.f4739f;
    }

    public final void f(androidx.compose.ui.semantics.g gVar) {
        this.f4738e = gVar;
    }

    public final void g(Float f5) {
        this.f4736c = f5;
    }

    public final void h(Float f5) {
        this.f4737d = f5;
    }

    public final void i(androidx.compose.ui.semantics.g gVar) {
        this.f4739f = gVar;
    }

    @Override // androidx.compose.ui.node.z0
    public boolean isValidOwnerScope() {
        return this.f4735b.contains(this);
    }
}
