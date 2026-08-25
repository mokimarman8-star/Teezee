package kotlinx.coroutines.internal;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class x {
    public static Object a(Object obj) {
        return obj;
    }

    public static final w b(Object obj) {
        if (obj == a.a) {
            throw new IllegalStateException("Does not contain segment");
        }
        Intrinsics.f(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (w) obj;
    }

    public static final boolean c(Object obj) {
        return obj == a.a;
    }
}
