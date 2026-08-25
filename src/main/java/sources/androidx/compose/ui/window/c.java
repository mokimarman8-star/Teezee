package androidx.compose.ui.window;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f5554a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f5555b;

    /* renamed from: c, reason: collision with root package name */
    private final SecureFlagPolicy f5556c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f5557d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f5558e;

    public c() {
        this(false, false, null, false, false, 31, null);
    }

    public c(boolean z5, boolean z6, SecureFlagPolicy secureFlagPolicy, boolean z7, boolean z8) {
        this.f5554a = z5;
        this.f5555b = z6;
        this.f5556c = secureFlagPolicy;
        this.f5557d = z7;
        this.f5558e = z8;
    }

    public /* synthetic */ c(boolean z5, boolean z6, SecureFlagPolicy secureFlagPolicy, boolean z7, boolean z8, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? true : z5, (i5 & 2) != 0 ? true : z6, (i5 & 4) != 0 ? SecureFlagPolicy.Inherit : secureFlagPolicy, (i5 & 8) != 0 ? true : z7, (i5 & 16) != 0 ? true : z8);
    }

    public c(boolean z5, boolean z6, boolean z7) {
        this(z5, z6, SecureFlagPolicy.Inherit, z7, true);
    }

    public /* synthetic */ c(boolean z5, boolean z6, boolean z7, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? true : z5, (i5 & 2) != 0 ? true : z6, (i5 & 4) != 0 ? true : z7);
    }

    public final boolean a() {
        return this.f5558e;
    }

    public final boolean b() {
        return this.f5554a;
    }

    public final boolean c() {
        return this.f5555b;
    }

    public final SecureFlagPolicy d() {
        return this.f5556c;
    }

    public final boolean e() {
        return this.f5557d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f5554a == cVar.f5554a && this.f5555b == cVar.f5555b && this.f5556c == cVar.f5556c && this.f5557d == cVar.f5557d && this.f5558e == cVar.f5558e;
    }

    public int hashCode() {
        return (((((((androidx.compose.foundation.e.a(this.f5554a) * 31) + androidx.compose.foundation.e.a(this.f5555b)) * 31) + this.f5556c.hashCode()) * 31) + androidx.compose.foundation.e.a(this.f5557d)) * 31) + androidx.compose.foundation.e.a(this.f5558e);
    }
}
