package mh;

import com.cloud.tmc.kernel.constants.TmcConstants;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class l {
    public static final l a = new l();
    private static String[] b = new String[0];
    private static String[] c = new String[0];

    private l() {
    }

    public static final boolean a(String str) {
        Intrinsics.h(str, TmcConstants.EXTRA_PATH);
        return ArraysKt.L(b, str);
    }

    public static final boolean b(String str) {
        Intrinsics.h(str, TmcConstants.EXTRA_PATH);
        return ArraysKt.L(c, str);
    }
}
