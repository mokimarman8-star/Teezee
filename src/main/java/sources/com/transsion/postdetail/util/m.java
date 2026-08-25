package com.transsion.postdetail.util;

import com.blankj.utilcode.util.c0;
import com.transsion.gslb.BuildConfig;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class m {
    public static final String a(long j) {
        int i = Calendar.getInstance().get(1);
        String j2 = c0.j(j, c0.d("yyyy-MM-dd HH:mm:ss"));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(c0.k(j2));
        if (i == calendar.get(1)) {
            String j3 = c0.j(j, c0.d("MM-dd HH:mm"));
            Intrinsics.e(j3);
            return j3;
        }
        String j4 = c0.j(j, c0.d("yyyy-MM-dd HH:mm"));
        Intrinsics.e(j4);
        return j4;
    }

    public static final String b(long j) {
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
        if (z && z2) {
            String format = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(j));
            Intrinsics.g(format, "format(...)");
            return format;
        }
        if (!z || z2) {
            String format2 = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date(j));
            Intrinsics.g(format2, "format(...)");
            return format2;
        }
        String format3 = new SimpleDateFormat("dd/MM", Locale.getDefault()).format(new Date(j));
        Intrinsics.g(format3, "format(...)");
        return format3;
    }

    public static final String c(int i) {
        Object valueOf;
        Object valueOf2;
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        if (i5 <= 0) {
            String valueOf3 = i4 > 0 ? Integer.valueOf(i4) : "0";
            if (i3 < 10) {
                valueOf = "0" + i3;
            } else {
                valueOf = Integer.valueOf(i3);
            }
            return valueOf3 + ":" + valueOf;
        }
        if (i3 < 10) {
            valueOf2 = "0" + i3;
        } else {
            valueOf2 = Integer.valueOf(i3);
        }
        return i5 + ":" + i4 + ":" + valueOf2;
    }

    public static final String d(long j) {
        SimpleDateFormat simpleDateFormat = j >= 3600000 ? new SimpleDateFormat("H:mm:ss") : new SimpleDateFormat("mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        String format = simpleDateFormat.format(Long.valueOf(j));
        Intrinsics.g(format, "format(...)");
        return format;
    }
}
