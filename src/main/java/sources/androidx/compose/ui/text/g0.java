package androidx.compose.ui.text;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    private final String f5174a;

    public g0(String str) {
        this.f5174a = str;
    }

    public final String a() {
        return this.f5174a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g0) && Intrinsics.c(this.f5174a, ((g0) obj).f5174a);
    }

    public int hashCode() {
        return this.f5174a.hashCode();
    }

    public String toString() {
        return "UrlAnnotation(url=" + this.f5174a + ')';
    }
}
