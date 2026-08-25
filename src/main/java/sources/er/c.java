package er;

import com.bumptech.glide.util.LruCache;
import com.transsion.gslb.BuildConfig;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c {
    public static final c a = new c();
    private static Integer[] b = {120, 180, 240, 360, 540, 720, 1080};
    private static LruCache c = new LruCache(600);

    private c() {
    }

    private final int f(int i) {
        int intValue = ((Number) ArraysKt.n0(b)).intValue();
        for (Integer num : b) {
            int intValue2 = num.intValue();
            if (i <= intValue2) {
                return intValue2;
            }
        }
        return intValue;
    }

    private final boolean g(String str) {
        return StringsKt.c0(str, "?x-oss-process=image", false, 2, (Object) null) || StringsKt.c0(str, "x-server-image=1", false, 2, (Object) null);
    }

    public final String a(String str, int i, boolean z, boolean z2, int i2, boolean z3, boolean z4, int i3) {
        Intrinsics.h(str, "url");
        if (g(str)) {
            return BuildConfig.FLAVOR;
        }
        StringBuilder sb = new StringBuilder(str);
        if (StringsKt.c0(str, "?", false, 2, (Object) null)) {
            sb.append("&x-oss-process=image");
        } else {
            sb.append("?x-oss-process=image");
        }
        sb.append("/resize,w_");
        sb.append(i);
        if (z3) {
            sb.append(",h_");
            sb.append(i2);
        }
        if (z) {
            sb.append("/format,webp");
        }
        if (z2) {
            sb.append("/quality,Q_50");
        }
        if (z4) {
            sb.append("/blur,r_" + i3 + ",s_" + i3);
        }
        String sb2 = sb.toString();
        Intrinsics.g(sb2, "toString(...)");
        return sb2;
    }

    public final int c(String str) {
        Intrinsics.h(str, "url");
        Integer num = (Integer) c.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final String d(String str, int i, boolean z, boolean z2, int i2, boolean z3, boolean z4, boolean z5, int i3) {
        Intrinsics.h(str, "url");
        if (g(str)) {
            return str;
        }
        int f = f(i);
        Integer num = (Integer) c.get(str);
        int intValue = num != null ? num.intValue() : 0;
        if (intValue >= f) {
            f = intValue;
        }
        int i4 = (int) (((f * 1.0f) / i) * i2);
        if (intValue != f && !z4) {
            c.put(str, Integer.valueOf(f));
        }
        return a(str, f, z, z2, i4, z3, z5, i3);
    }
}
