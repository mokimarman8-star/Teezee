package zv;

import java.text.SimpleDateFormat;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b {
    public static final b a = new b();

    private b() {
    }

    public final String a(long j) {
        SimpleDateFormat simpleDateFormat = j >= 3600000 ? new SimpleDateFormat("H:mm:ss") : new SimpleDateFormat("mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        String format = simpleDateFormat.format(Long.valueOf(j));
        Intrinsics.g(format, "format(...)");
        return format;
    }
}
