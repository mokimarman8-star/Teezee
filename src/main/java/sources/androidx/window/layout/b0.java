package androidx.window.layout;

import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.window.core.b f13805a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b0(Rect rect) {
        this(new androidx.window.core.b(rect));
        Intrinsics.h(rect, "bounds");
    }

    public b0(androidx.window.core.b bVar) {
        Intrinsics.h(bVar, "_bounds");
        this.f13805a = bVar;
    }

    public final Rect a() {
        return this.f13805a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.c(b0.class, obj.getClass())) {
            return false;
        }
        return Intrinsics.c(this.f13805a, ((b0) obj).f13805a);
    }

    public int hashCode() {
        return this.f13805a.hashCode();
    }

    public String toString() {
        return "WindowMetrics { bounds: " + a() + " }";
    }
}
