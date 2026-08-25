package androidx.compose.ui.text;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class h0 extends f0 {

    /* renamed from: a, reason: collision with root package name */
    private final String f5175a;

    public h0(String str) {
        super(null);
        this.f5175a = str;
    }

    public final String a() {
        return this.f5175a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h0) && Intrinsics.c(this.f5175a, ((h0) obj).f5175a);
    }

    public int hashCode() {
        return this.f5175a.hashCode();
    }

    public String toString() {
        return "VerbatimTtsAnnotation(verbatim=" + this.f5175a + ')';
    }
}
