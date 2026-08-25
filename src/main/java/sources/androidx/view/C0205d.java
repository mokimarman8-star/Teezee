package androidx.view;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: androidx.savedstate.d, reason: case insensitive filesystem */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class C0205d {

    /* renamed from: d, reason: collision with root package name */
    public static final a f13351d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC0206e f13352a;

    /* renamed from: b, reason: collision with root package name */
    private final C0204c f13353b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f13354c;

    /* renamed from: androidx.savedstate.d$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final C0205d a(InterfaceC0206e interfaceC0206e) {
            Intrinsics.h(interfaceC0206e, "owner");
            return new C0205d(interfaceC0206e, null);
        }
    }

    private C0205d(InterfaceC0206e interfaceC0206e) {
        this.f13352a = interfaceC0206e;
        this.f13353b = new C0204c();
    }

    public /* synthetic */ C0205d(InterfaceC0206e interfaceC0206e, DefaultConstructorMarker defaultConstructorMarker) {
        this(interfaceC0206e);
    }

    public static final C0205d a(InterfaceC0206e interfaceC0206e) {
        return f13351d.a(interfaceC0206e);
    }

    public final C0204c b() {
        return this.f13353b;
    }

    public final void c() {
        Lifecycle lifecycle = this.f13352a.getLifecycle();
        if (lifecycle.b() != Lifecycle.State.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        lifecycle.a(new androidx.savedstate.a(this.f13352a));
        this.f13353b.e(lifecycle);
        this.f13354c = true;
    }

    public final void d(Bundle bundle) {
        if (!this.f13354c) {
            c();
        }
        Lifecycle lifecycle = this.f13352a.getLifecycle();
        if (!lifecycle.b().isAtLeast(Lifecycle.State.STARTED)) {
            this.f13353b.f(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.b()).toString());
    }

    public final void e(Bundle bundle) {
        Intrinsics.h(bundle, "outBundle");
        this.f13353b.g(bundle);
    }
}
