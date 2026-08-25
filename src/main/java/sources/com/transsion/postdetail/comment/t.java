package com.transsion.postdetail.comment;

import android.content.Context;
import com.transsion.gslb.BuildConfig;
import com.transsion.postdetail.R;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class t {
    public static final t a = new t();

    private t() {
    }

    private final String b(Context context, long j) {
        if (j == 0) {
            return BuildConfig.FLAVOR;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTimeMillis);
        int i = calendar.get(1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j);
        boolean z = calendar2.get(1) == i;
        boolean z2 = calendar2.get(6) == Calendar.getInstance().get(6);
        if (!z || z2) {
            String format = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date(j));
            Intrinsics.g(format, "format(...)");
            return format;
        }
        String format2 = new SimpleDateFormat("dd/MM", Locale.getDefault()).format(new Date(j));
        Intrinsics.g(format2, "format(...)");
        return format2;
    }

    public final String a(int i) {
        if (i < 1000) {
            return String.valueOf(i);
        }
        if (i < 1000000) {
            BigDecimal divide = new BigDecimal(i).divide(new BigDecimal(1000), 1, 4);
            Intrinsics.g(divide, "divide(...)");
            return divide + " k";
        }
        BigDecimal divide2 = new BigDecimal(i).divide(new BigDecimal(1000000), 1, 4);
        Intrinsics.g(divide2, "divide(...)");
        return divide2 + " m";
    }

    public final String c(Context context, long j) {
        Intrinsics.h(context, "context");
        long currentTimeMillis = System.currentTimeMillis() - j;
        if (currentTimeMillis < -30000) {
            return b(context, j);
        }
        if (-30000 <= currentTimeMillis && currentTimeMillis < 10000) {
            String string = context.getString(R.string.comment_just_now);
            Intrinsics.e(string);
            return string;
        }
        if (10000 <= currentTimeMillis && currentTimeMillis < 60000) {
            return ((int) (currentTimeMillis / 1000)) + "s";
        }
        if (60000 <= currentTimeMillis && currentTimeMillis < 3600000) {
            return ((int) (currentTimeMillis / 60000)) + "min";
        }
        if (3600000 > currentTimeMillis || currentTimeMillis >= 86400000) {
            return b(context, j);
        }
        return ((int) (currentTimeMillis / 3600000)) + "h";
    }
}
