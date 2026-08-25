package androidx.window.layout;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    private final List f13803a;

    public a0(List list) {
        Intrinsics.h(list, "displayFeatures");
        this.f13803a = list;
    }

    public final List a() {
        return this.f13803a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.c(a0.class, obj.getClass())) {
            return false;
        }
        return Intrinsics.c(this.f13803a, ((a0) obj).f13803a);
    }

    public int hashCode() {
        return this.f13803a.hashCode();
    }

    public String toString() {
        return CollectionsKt.s0(this.f13803a, ", ", "WindowLayoutInfo{ DisplayFeatures[", "] }", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
    }
}
