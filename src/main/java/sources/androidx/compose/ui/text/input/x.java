package androidx.compose.ui.text.input;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    private final String f5277a;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public x() {
        this(r0, 1, r0);
        String str = null;
    }

    public x(String str) {
        this.f5277a = str;
    }

    public /* synthetic */ x(String str, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? null : str);
    }

    public final String a() {
        return this.f5277a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof x) && Intrinsics.c(this.f5277a, ((x) obj).f5277a);
    }

    public int hashCode() {
        String str = this.f5277a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "PlatformImeOptions(privateImeOptions=" + this.f5277a + ')';
    }
}
