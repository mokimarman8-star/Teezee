package androidx.compose.ui.text;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private final o f5293a;

    /* renamed from: b, reason: collision with root package name */
    private final int f5294b;

    /* renamed from: c, reason: collision with root package name */
    private final int f5295c;

    public n(o oVar, int i5, int i6) {
        this.f5293a = oVar;
        this.f5294b = i5;
        this.f5295c = i6;
    }

    public final int a() {
        return this.f5295c;
    }

    public final o b() {
        return this.f5293a;
    }

    public final int c() {
        return this.f5294b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return Intrinsics.c(this.f5293a, nVar.f5293a) && this.f5294b == nVar.f5294b && this.f5295c == nVar.f5295c;
    }

    public int hashCode() {
        return (((this.f5293a.hashCode() * 31) + this.f5294b) * 31) + this.f5295c;
    }

    public String toString() {
        return "ParagraphIntrinsicInfo(intrinsics=" + this.f5293a + ", startIndex=" + this.f5294b + ", endIndex=" + this.f5295c + ')';
    }
}
