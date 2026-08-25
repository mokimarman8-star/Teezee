package androidx.compose.ui.input.pointer;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private boolean f3977a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f3978b;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public d() {
        this(r2, r2, 3, null);
        boolean z5 = false;
    }

    public d(boolean z5, boolean z6) {
        this.f3977a = z5;
        this.f3978b = z6;
    }

    public /* synthetic */ d(boolean z5, boolean z6, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? false : z5, (i5 & 2) != 0 ? false : z6);
    }

    public final boolean a() {
        return this.f3978b;
    }

    public final boolean b() {
        return this.f3977a;
    }

    public final void c(boolean z5) {
        this.f3978b = z5;
    }

    public final void d(boolean z5) {
        this.f3977a = z5;
    }
}
