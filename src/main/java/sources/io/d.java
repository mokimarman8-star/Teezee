package io;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d {
    public static final d a = new d();
    private static final Map b = new LinkedHashMap();

    private d() {
    }

    public final void a() {
        b.clear();
    }

    public final Long b(String str) {
        Intrinsics.h(str, "postId");
        return (Long) b.remove(str);
    }

    public final void c(String str, long j) {
        Intrinsics.h(str, "postId");
        b.put(str, Long.valueOf(j));
    }
}
