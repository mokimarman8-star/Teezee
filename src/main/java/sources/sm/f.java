package sm;

import java.text.DecimalFormat;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class f {
    public static final String a(int i) {
        String format = new DecimalFormat("00").format(Integer.valueOf(i));
        Intrinsics.g(format, "format(...)");
        return format;
    }
}
