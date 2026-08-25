package mh;

import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class d {
    public static final d a = new d();
    private static String[] b = new String[0];
    private static String[] c = new String[0];
    private static String[] d = new String[0];

    private d() {
    }

    public static final boolean a(String str) {
        Intrinsics.h(str, "host");
        return ArraysKt.L(d, str);
    }

    public static final boolean b(String str) {
        Intrinsics.h(str, "host");
        return ArraysKt.L(b, str);
    }

    public static final boolean c(String str) {
        Intrinsics.h(str, "host");
        return ArraysKt.L(c, str);
    }

    public static final boolean d() {
        return d.length == 0;
    }

    public final void e(String[] strArr) {
        Intrinsics.h(strArr, "hosts");
        d = strArr;
    }
}
