package com.transsion.baseui.util;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.c0;
import com.transsion.baseui.R;
import com.transsion.baseui.R$plurals;
import com.transsion.gslb.BuildConfig;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class TimeUtilKt {
    public static final String a(Integer num) {
        String str;
        String valueOf;
        String valueOf2;
        if (num == null) {
            return "00:00";
        }
        if (num.intValue() <= 0) {
            return "00:01";
        }
        int intValue = num.intValue() / 3600;
        int intValue2 = (num.intValue() / 60) % 60;
        int intValue3 = num.intValue() % 60;
        if (intValue > 0) {
            str = intValue + ":";
        } else {
            str = BuildConfig.FLAVOR;
        }
        if (intValue2 < 10) {
            valueOf = "0" + intValue2;
        } else {
            valueOf = String.valueOf(intValue2);
        }
        if (intValue3 < 10) {
            valueOf2 = "0" + intValue3;
        } else {
            valueOf2 = String.valueOf(intValue3);
        }
        return str + valueOf + ":" + valueOf2;
    }

    public static final t1 b(int i, n0 n0Var, Function1 function1, Function0 function0) {
        Intrinsics.h(n0Var, "scope");
        Intrinsics.h(function1, "onTick");
        return kotlinx.coroutines.flow.c.u(kotlinx.coroutines.flow.c.w(kotlinx.coroutines.flow.c.x(kotlinx.coroutines.flow.c.t(kotlinx.coroutines.flow.c.r(new TimeUtilKt$countdownByFlow$1(i, null)), y0.c()), new TimeUtilKt$countdownByFlow$2(function1, null)), new TimeUtilKt$countdownByFlow$3(function0, null)), n0Var);
    }

    public static final int c() {
        Calendar calendar = Calendar.getInstance();
        return (calendar.get(1) * 10000) + ((calendar.get(2) + 1) * 100) + calendar.get(5);
    }

    public static final int d(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return (calendar.get(1) * 10000) + ((calendar.get(2) + 1) * 100) + calendar.get(5);
    }

    public static final String e(long j) {
        String j2 = c0.j(j, c0.d("yyyy/MM/dd HH:mm:ss"));
        Intrinsics.g(j2, "millis2String(...)");
        return j2;
    }

    public static final String f(int i) {
        int i2 = i / 3600;
        int i3 = (i % 3600) / 60;
        int i4 = i % 60;
        StringBuilder sb = new StringBuilder();
        if (i2 > 0) {
            sb.append(i3);
            sb.append(" h ");
        }
        if (i3 > 0) {
            sb.append(i3);
            sb.append(" min ");
        }
        if (i4 > 0) {
            sb.append(i4);
            sb.append(" sec");
        }
        String sb2 = sb.toString();
        Intrinsics.g(sb2, "toString(...)");
        return sb2;
    }

    public static final String g(int i) {
        int i2 = i / 3600;
        int i3 = (i % 3600) / 60;
        StringBuilder sb = new StringBuilder();
        if (i2 > 0) {
            sb.append(i2);
            sb.append("h");
        }
        if (i3 > 0) {
            sb.append(i3);
            sb.append("m");
        }
        String sb2 = sb.toString();
        Intrinsics.g(sb2, "toString(...)");
        return sb2;
    }

    public static final String h(long j) {
        long j2 = j / 1000;
        long j3 = 60;
        long j4 = j2 % j3;
        long j5 = (j2 / j3) % j3;
        long j6 = j2 / 3600;
        if (j6 > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j6), Long.valueOf(j5), Long.valueOf(j4)}, 3));
            Intrinsics.g(format, "format(...)");
            return format;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.a;
        String format2 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j5), Long.valueOf(j4)}, 2));
        Intrinsics.g(format2, "format(...)");
        return format2;
    }

    private static final String i(long j, Integer num) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        Application a = Utils.a();
        if (currentTimeMillis < TimeUnit.MINUTES.toMillis(1L)) {
            String string = a.getString(R.string.time_just_now);
            Intrinsics.g(string, "getString(...)");
            return string;
        }
        if (currentTimeMillis < TimeUnit.HOURS.toMillis(1L)) {
            int minutes = (int) TimeUnit.MILLISECONDS.toMinutes(currentTimeMillis);
            String quantityString = a.getResources().getQuantityString(R$plurals.time_minutes_ago, minutes, Integer.valueOf(minutes));
            Intrinsics.e(quantityString);
            return quantityString;
        }
        TimeUnit timeUnit = TimeUnit.DAYS;
        if (currentTimeMillis < timeUnit.toMillis(1L)) {
            int hours = (int) TimeUnit.MILLISECONDS.toHours(currentTimeMillis);
            String quantityString2 = a.getResources().getQuantityString(R$plurals.time_hours_ago, hours, Integer.valueOf(hours));
            Intrinsics.e(quantityString2);
            return quantityString2;
        }
        if (currentTimeMillis < timeUnit.toMillis(7L)) {
            int days = (int) TimeUnit.MILLISECONDS.toDays(currentTimeMillis);
            String quantityString3 = a.getResources().getQuantityString(R$plurals.time_days_ago, days, Integer.valueOf(days));
            Intrinsics.e(quantityString3);
            return quantityString3;
        }
        if (currentTimeMillis < timeUnit.toMillis(30L)) {
            int days2 = (int) (TimeUnit.MILLISECONDS.toDays(currentTimeMillis) / 7);
            String quantityString4 = a.getResources().getQuantityString(R$plurals.time_weeks_ago, days2, Integer.valueOf(days2));
            Intrinsics.e(quantityString4);
            return quantityString4;
        }
        int days3 = (int) (TimeUnit.MILLISECONDS.toDays(currentTimeMillis) / 30);
        if (num != null) {
            days3 = RangesKt.h(days3, num.intValue());
        }
        String quantityString5 = a.getResources().getQuantityString(R$plurals.time_months_ago, days3, Integer.valueOf(days3));
        Intrinsics.e(quantityString5);
        return quantityString5;
    }

    public static final String j(long j) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        Application a = Utils.a();
        if (currentTimeMillis < TimeUnit.MINUTES.toMillis(1L)) {
            String string = a.getString(R.string.time_just_now);
            Intrinsics.g(string, "getString(...)");
            return string;
        }
        if (currentTimeMillis < TimeUnit.HOURS.toMillis(1L)) {
            int minutes = (int) TimeUnit.MILLISECONDS.toMinutes(currentTimeMillis);
            String quantityString = a.getResources().getQuantityString(R$plurals.time_minutes_ago, minutes, Integer.valueOf(minutes));
            Intrinsics.e(quantityString);
            return quantityString;
        }
        TimeUnit timeUnit = TimeUnit.DAYS;
        if (currentTimeMillis < timeUnit.toMillis(1L)) {
            int hours = (int) TimeUnit.MILLISECONDS.toHours(currentTimeMillis);
            String quantityString2 = a.getResources().getQuantityString(R$plurals.time_hours_ago, hours, Integer.valueOf(hours));
            Intrinsics.e(quantityString2);
            return quantityString2;
        }
        if (currentTimeMillis < timeUnit.toMillis(7L)) {
            int days = (int) TimeUnit.MILLISECONDS.toDays(currentTimeMillis);
            String quantityString3 = a.getResources().getQuantityString(R$plurals.time_days_ago, days, Integer.valueOf(days));
            Intrinsics.e(quantityString3);
            return quantityString3;
        }
        if (currentTimeMillis < timeUnit.toMillis(30L)) {
            int days2 = (int) (TimeUnit.MILLISECONDS.toDays(currentTimeMillis) / 7);
            String quantityString4 = a.getResources().getQuantityString(R$plurals.time_weeks_ago, days2, Integer.valueOf(days2));
            Intrinsics.e(quantityString4);
            return quantityString4;
        }
        if (currentTimeMillis < timeUnit.toMillis(365L)) {
            int days3 = (int) (TimeUnit.MILLISECONDS.toDays(currentTimeMillis) / 30);
            String quantityString5 = a.getResources().getQuantityString(R$plurals.time_months_ago, days3, Integer.valueOf(days3));
            Intrinsics.e(quantityString5);
            return quantityString5;
        }
        int days4 = (int) (TimeUnit.MILLISECONDS.toDays(currentTimeMillis) / 365);
        String quantityString6 = a.getResources().getQuantityString(R$plurals.time_years_ago, days4, Integer.valueOf(days4));
        Intrinsics.e(quantityString6);
        return quantityString6;
    }

    public static final String k(long j) {
        return i(j, 6);
    }

    public static final String l(long j) {
        int i = Calendar.getInstance().get(1);
        String j2 = c0.j(j, c0.d("yyyy-MM-dd HH:mm:ss"));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(c0.k(j2));
        if (i == calendar.get(1)) {
            String j3 = c0.j(j, c0.d("MM-dd"));
            Intrinsics.e(j3);
            return j3;
        }
        String j4 = c0.j(j, c0.d("yyyy-MM-dd"));
        Intrinsics.e(j4);
        return j4;
    }

    public static final String m(String str) {
        long parseLong;
        if (str != null) {
            try {
                parseLong = Long.parseLong(str);
            } catch (Exception unused) {
                return "0";
            }
        } else {
            parseLong = 0;
        }
        return l(parseLong);
    }

    public static final String n(long j) {
        String j2 = c0.j(j, c0.d("yyyy-MM-dd"));
        Intrinsics.g(j2, "millis2String(...)");
        return j2;
    }

    public static final String o(long j) {
        if (j == 0) {
            return BuildConfig.FLAVOR;
        }
        SimpleDateFormat simpleDateFormat = j >= 3600000 ? new SimpleDateFormat("HH:mm:ss") : new SimpleDateFormat("mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        String format = simpleDateFormat.format(Long.valueOf(j));
        Intrinsics.g(format, "format(...)");
        return format;
    }

    public static final String p(long j) {
        StringBuilder sb = new StringBuilder();
        if (j > 3600) {
            long j2 = 3600;
            long j3 = j / j2;
            j -= j2 * j3;
            if (j3 < 10) {
                sb.append("0");
            }
            sb.append(j3);
            sb.append(":");
        }
        if (j > 60) {
            long j4 = 60;
            long j5 = j / j4;
            j -= j4 * j5;
            if (j5 < 10) {
                sb.append("0");
            }
            sb.append(j5);
            sb.append(":");
        } else {
            sb.append("00:");
        }
        if (j <= 0) {
            sb.append("00");
        } else if (j > 60) {
            sb.append("59");
        } else if (j < 10) {
            sb.append("0" + j);
        } else {
            sb.append(j);
        }
        String sb2 = sb.toString();
        Intrinsics.g(sb2, "toString(...)");
        return sb2;
    }

    public static final int q(long j) {
        long currentTimeMillis = j - System.currentTimeMillis();
        if (currentTimeMillis < 0) {
            return -1;
        }
        return (int) TimeUnit.MILLISECONDS.toDays(currentTimeMillis);
    }

    public static final String r(long j) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        long hours = timeUnit.toHours(j);
        long j2 = 60;
        long minutes = timeUnit.toMinutes(j) % j2;
        long j3 = j % j2;
        if (hours > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String format = String.format(Locale.ROOT, "%d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(hours), Long.valueOf(minutes), Long.valueOf(j3)}, 3));
            Intrinsics.g(format, "format(...)");
            return format;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.a;
        String format2 = String.format(Locale.ROOT, "%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(minutes), Long.valueOf(j3)}, 2));
        Intrinsics.g(format2, "format(...)");
        return format2;
    }
}
