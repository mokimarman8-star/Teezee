package com.google.common.base;

import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.lang.ref.WeakReference;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class l {
    private static final k a = c();

    private static final class b implements k {
        private b() {
        }
    }

    static String a(String str) {
        if (e(str)) {
            return null;
        }
        return str;
    }

    static Optional b(Class cls, String str) {
        WeakReference weakReference = (WeakReference) d.a(cls).get(str);
        return weakReference == null ? Optional.absent() : Optional.fromNullable((Enum) cls.cast(weakReference.get()));
    }

    private static k c() {
        return new b();
    }

    static String d(String str) {
        return str == null ? TtmlNode.ANONYMOUS_REGION_ID : str;
    }

    static boolean e(String str) {
        return str == null || str.isEmpty();
    }
}
