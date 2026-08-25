package n;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class d {
    public static final void a(String str) {
        Intrinsics.h(str, "message");
        throw new IllegalArgumentException(str);
    }

    public static final void b(String str) {
        Intrinsics.h(str, "message");
        throw new IllegalStateException(str);
    }
}
