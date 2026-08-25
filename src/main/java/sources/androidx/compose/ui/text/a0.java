package androidx.compose.ui.text;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    private final x f5075a;

    /* renamed from: b, reason: collision with root package name */
    private final x f5076b;

    /* renamed from: c, reason: collision with root package name */
    private final x f5077c;

    /* renamed from: d, reason: collision with root package name */
    private final x f5078d;

    public a0() {
        this(null, null, null, null, 15, null);
    }

    public a0(x xVar, x xVar2, x xVar3, x xVar4) {
        this.f5075a = xVar;
        this.f5076b = xVar2;
        this.f5077c = xVar3;
        this.f5078d = xVar4;
    }

    public /* synthetic */ a0(x xVar, x xVar2, x xVar3, x xVar4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? null : xVar, (i5 & 2) != 0 ? null : xVar2, (i5 & 4) != 0 ? null : xVar3, (i5 & 8) != 0 ? null : xVar4);
    }

    public final x a() {
        return this.f5076b;
    }

    public final x b() {
        return this.f5077c;
    }

    public final x c() {
        return this.f5078d;
    }

    public final x d() {
        return this.f5075a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return Intrinsics.c(this.f5075a, a0Var.f5075a) && Intrinsics.c(this.f5076b, a0Var.f5076b) && Intrinsics.c(this.f5077c, a0Var.f5077c) && Intrinsics.c(this.f5078d, a0Var.f5078d);
    }

    public int hashCode() {
        x xVar = this.f5075a;
        int hashCode = (xVar != null ? xVar.hashCode() : 0) * 31;
        x xVar2 = this.f5076b;
        int hashCode2 = (hashCode + (xVar2 != null ? xVar2.hashCode() : 0)) * 31;
        x xVar3 = this.f5077c;
        int hashCode3 = (hashCode2 + (xVar3 != null ? xVar3.hashCode() : 0)) * 31;
        x xVar4 = this.f5078d;
        return hashCode3 + (xVar4 != null ? xVar4.hashCode() : 0);
    }
}
