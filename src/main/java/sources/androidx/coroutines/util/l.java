package androidx.coroutines.util;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f13307a = new String[0];

    public static final void a(StringBuilder sb, int i5) {
        Intrinsics.h(sb, "builder");
        for (int i6 = 0; i6 < i5; i6++) {
            sb.append("?");
            if (i6 < i5 - 1) {
                sb.append(",");
            }
        }
    }

    public static final StringBuilder b() {
        return new StringBuilder();
    }
}
