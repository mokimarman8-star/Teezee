package androidx.compose.ui.platform;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class c1 {
    public static final String a(Object obj, String str) {
        if (str == null) {
            str = obj.getClass().isAnonymousClass() ? obj.getClass().getName() : obj.getClass().getSimpleName();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('@');
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String format = String.format("%07x", Arrays.copyOf(new Object[]{Integer.valueOf(System.identityHashCode(obj))}, 1));
        Intrinsics.g(format, "format(format, *args)");
        sb.append(format);
        return sb.toString();
    }
}
