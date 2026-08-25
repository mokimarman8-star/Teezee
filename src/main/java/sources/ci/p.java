package ci;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class p {
    public static final p a = new p();

    private p() {
    }

    public static /* synthetic */ String b(p pVar, Long l, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "yyyy-MM-dd";
        }
        return pVar.a(l, str);
    }

    public final String a(Long l, String str) {
        Intrinsics.h(str, "dateFormat");
        String format = new SimpleDateFormat(str, Locale.getDefault()).format(new Date(l != null ? l.longValue() : 0L));
        Intrinsics.g(format, "format(...)");
        return format;
    }

    public final String c() {
        String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Calendar.getInstance().getTime());
        Intrinsics.g(format, "format(...)");
        return format;
    }

    public final long d() {
        return new Date().getTime();
    }

    public final String e(long j, long j2) {
        long abs = Math.abs(j2 - j);
        long j3 = 60;
        return (abs / 86400000) + "天 " + ((abs / 3600000) % 24) + "小时 " + ((abs / 60000) % j3) + "分钟 " + ((abs / 1000) % j3) + "秒";
    }
}
