package w1;

import android.text.TextUtils;
import androidx.media3.common.util.u;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f18119a = Pattern.compile("bytes (\\d+)-(\\d+)/(?:\\d+|\\*)");

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f18120b = Pattern.compile("bytes (?:(?:\\d+-\\d+)|\\*)/(\\d+)");

    public static String a(long j5, long j6) {
        if (j5 == 0 && j6 == -1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("bytes=");
        sb.append(j5);
        sb.append("-");
        if (j6 != -1) {
            sb.append((j5 + j6) - 1);
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long b(String str, String str2) {
        long parseLong;
        if (!TextUtils.isEmpty(str)) {
            try {
                parseLong = Long.parseLong(str);
            } catch (NumberFormatException unused) {
                u.c("HttpUtil", "Unexpected Content-Length [" + str + "]");
            }
            if (!TextUtils.isEmpty(str2)) {
                return parseLong;
            }
            Matcher matcher = f18119a.matcher(str2);
            if (!matcher.matches()) {
                return parseLong;
            }
            try {
                long parseLong2 = (Long.parseLong((String) androidx.media3.common.util.a.e(matcher.group(2))) - Long.parseLong((String) androidx.media3.common.util.a.e(matcher.group(1)))) + 1;
                if (parseLong < 0) {
                    return parseLong2;
                }
                if (parseLong == parseLong2) {
                    return parseLong;
                }
                u.h("HttpUtil", "Inconsistent headers [" + str + "] [" + str2 + "]");
                return Math.max(parseLong, parseLong2);
            } catch (NumberFormatException unused2) {
                u.c("HttpUtil", "Unexpected Content-Range [" + str2 + "]");
                return parseLong;
            }
        }
        parseLong = -1;
        if (!TextUtils.isEmpty(str2)) {
        }
    }

    public static long c(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        Matcher matcher = f18120b.matcher(str);
        if (matcher.matches()) {
            return Long.parseLong((String) androidx.media3.common.util.a.e(matcher.group(1)));
        }
        return -1L;
    }
}
