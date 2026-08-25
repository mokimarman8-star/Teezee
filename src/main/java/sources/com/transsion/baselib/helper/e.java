package com.transsion.baselib.helper;

import android.content.Context;
import android.os.Build;
import java.util.Iterator;
import kotlin.jvm.internal.ArrayIteratorKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e {
    public static final e a = new e();
    private static final String[] b;

    static {
        b = Build.VERSION.SDK_INT < 33 ? new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"} : new String[]{"android.permission.READ_MEDIA_VIDEO"};
    }

    private e() {
    }

    public final String[] a() {
        return b;
    }

    public final boolean b(Context context, String[] strArr) {
        if (context == null || strArr == null) {
            return false;
        }
        Iterator a2 = ArrayIteratorKt.a(strArr);
        while (a2.hasNext()) {
            if (androidx.core.content.b.checkSelfPermission(context, (String) a2.next()) != 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean c(Context context) {
        return b(context, b);
    }
}
