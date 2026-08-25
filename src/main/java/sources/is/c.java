package is;

import com.bumptech.glide.util.LruCache;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
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
        return StringsKt.c0(str, "?x-oss-process=image", false, 2, null) || StringsKt.c0(str, "x-server-image=1", false, 2, null);
    }

    public final String a(String url, int i, boolean z, boolean z2, int i2, boolean z3, boolean z4, int i3) {
        Intrinsics.h(url, "url");
        if (g(url)) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        StringBuilder sb = new StringBuilder(url);
        if (StringsKt.c0(url, "?", false, 2, null)) {
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

    public final int c(String url) {
        Intrinsics.h(url, "url");
        Integer num = (Integer) c.get(url);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final String d(String url, int i, boolean z, boolean z2, int i2, boolean z3, boolean z4, boolean z5, int i3) {
        Intrinsics.h(url, "url");
        if (g(url)) {
            return url;
        }
        int f = f(i);
        Integer num = (Integer) c.get(url);
        int intValue = num != null ? num.intValue() : 0;
        if (intValue >= f) {
            f = intValue;
        }
        int i4 = (int) (((f * 1.0f) / i) * i2);
        if (intValue != f && !z4) {
            c.put(url, Integer.valueOf(f));
        }
        return a(url, f, z, z2, i4, z3, z5, i3);
    }
}
