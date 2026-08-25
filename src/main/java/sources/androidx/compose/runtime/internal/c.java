package androidx.compose.runtime.internal;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private int f2760a;

    public c() {
        this(0, 1, null);
    }

    public c(int i5) {
        this.f2760a = i5;
    }

    public /* synthetic */ c(int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 0 : i5);
    }

    public final int a() {
        return this.f2760a;
    }

    public final void b(int i5) {
        this.f2760a = i5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IntRef(element = ");
        sb.append(this.f2760a);
        sb.append(")@");
        String num = Integer.toString(hashCode(), CharsKt.a(16));
        Intrinsics.g(num, "toString(this, checkRadix(radix))");
        sb.append(num);
        return sb.toString();
    }
}
