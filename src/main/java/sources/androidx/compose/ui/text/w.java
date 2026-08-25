package androidx.compose.ui.text;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    private final v f5448a;

    /* renamed from: b, reason: collision with root package name */
    private final u f5449b;

    public w(v vVar, u uVar) {
        this.f5448a = vVar;
        this.f5449b = uVar;
    }

    public w(boolean z5) {
        this(null, new u(z5));
    }

    public final u a() {
        return this.f5449b;
    }

    public final v b() {
        return this.f5448a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return Intrinsics.c(this.f5449b, wVar.f5449b) && Intrinsics.c(this.f5448a, wVar.f5448a);
    }

    public int hashCode() {
        v vVar = this.f5448a;
        int hashCode = (vVar != null ? vVar.hashCode() : 0) * 31;
        u uVar = this.f5449b;
        return hashCode + (uVar != null ? uVar.hashCode() : 0);
    }

    public String toString() {
        return "PlatformTextStyle(spanStyle=" + this.f5448a + ", paragraphSyle=" + this.f5449b + ')';
    }
}
