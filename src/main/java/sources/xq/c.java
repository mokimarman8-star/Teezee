package xq;

import android.content.Context;
import android.graphics.Typeface;
import com.transsion.shorttv.R;
import kotlin.jvm.internal.Intrinsics;
import y0.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class c {
    public static final Typeface a(Context context) {
        Intrinsics.h(context, "context");
        try {
            return Typeface.create(h.g(context.getApplicationContext(), R.font.mulish_bold), 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final Typeface b(Context context) {
        Intrinsics.h(context, "context");
        try {
            return Typeface.create(h.g(context.getApplicationContext(), R.font.mulish_extra_bold), 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final Typeface c(Context context) {
        Intrinsics.h(context, "context");
        try {
            return Typeface.create(h.g(context.getApplicationContext(), R.font.mulish_semi_bold), 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final Typeface d(Context context) {
        Intrinsics.h(context, "context");
        try {
            return Typeface.create(h.g(context.getApplicationContext(), R.font.mulish_regular), 0);
        } catch (Throwable unused) {
            return null;
        }
    }
}
