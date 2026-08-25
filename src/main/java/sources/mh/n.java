package mh;

import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class n {
    public static final n a = new n();
    private static String[] b = new String[0];
    private static String[] c = new String[0];

    private n() {
    }

    public static final boolean a(String str) {
        Intrinsics.h(str, "serverApi");
        return ArraysKt.L(b, str);
    }

    public static final boolean b(String str) {
        Intrinsics.h(str, "serverApi");
        return ArraysKt.L(c, str);
    }
}
