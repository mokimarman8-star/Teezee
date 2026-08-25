package fv;

import android.content.Context;
import com.transsion.usercenter.R$string;
import com.vungle.ads.internal.signals.SignalManager;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b {
    private static DateFormat b;
    public static final a a = new a(null);
    private static final int c = R$string.minute_ago;
    private static final int d = R$string.hour_ago;
    private static final int e = R$string.just_now;
    private static final int f = R$string.day_ago;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final DateFormat c(Context context) {
            if (b.b == null) {
                DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();
                dateFormatSymbols.setShortMonths(new String[]{context.getString(R$string.month_jan), context.getString(R$string.month_feb), context.getString(R$string.month_mar), context.getString(R$string.month_apr), context.getString(R$string.month_may), context.getString(R$string.month_june), context.getString(R$string.month_july), context.getString(R$string.month_aug), context.getString(R$string.month_sept), context.getString(R$string.month_oct), context.getString(R$string.month_nov), context.getString(R$string.month_dec)});
                b.b = new SimpleDateFormat("dd MMM", dateFormatSymbols);
            }
            return b.b;
        }

        private final String d(Long l) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Intrinsics.e(l);
            return simpleDateFormat.format(new Date(l.longValue()));
        }

        private final String e(Context context, long j, long j2) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                long time = simpleDateFormat.parse(d(Long.valueOf(j2))).getTime() - simpleDateFormat.parse(d(Long.valueOf(j))).getTime();
                long j3 = (time % SignalManager.TWENTY_FOUR_HOURS_MILLIS) / 3600000;
                long j4 = ((time % SignalManager.TWENTY_FOUR_HOURS_MILLIS) % 3600000) / 60000;
                if (time / SignalManager.TWENTY_FOUR_HOURS_MILLIS > 0) {
                    DateFormat c = c(context);
                    if (c != null) {
                        return c.format(new Date(j));
                    }
                    return null;
                }
                if (j3 > 0) {
                    String string = context.getString(b.d);
                    Intrinsics.g(string, "getString(...)");
                    StringBuilder sb = new StringBuilder();
                    sb.append(j3);
                    return StringsKt.Q(string, "{$target}", sb.toString(), false, 4, null);
                }
                if (j4 <= 0) {
                    return context.getString(b.e);
                }
                String string2 = context.getString(b.c);
                Intrinsics.g(string2, "getString(...)");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(j4);
                return StringsKt.Q(string2, "{$target}", sb2.toString(), false, 4, null);
            } catch (Exception e) {
                e.printStackTrace();
                return HttpUrl.FRAGMENT_ENCODE_SET;
            }
        }

        public final String a(Context context, String timestamp) {
            Intrinsics.h(context, "context");
            Intrinsics.h(timestamp, "timestamp");
            try {
                long parseLong = Long.parseLong(timestamp);
                Calendar calendar = Calendar.getInstance();
                long timeInMillis = calendar.getTimeInMillis();
                int i = calendar.get(7);
                int i2 = calendar.get(4);
                int i3 = calendar.get(2) + 1;
                int i4 = calendar.get(1);
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTimeInMillis(parseLong);
                long timeInMillis2 = calendar2.getTimeInMillis();
                int i5 = calendar2.get(7);
                int i6 = calendar2.get(4);
                int i7 = calendar2.get(2) + 1;
                int i8 = calendar2.get(1);
                if (Math.abs(i4 - i8) > 0) {
                    return new SimpleDateFormat("MM-dd-yyyy").format(Long.valueOf(timeInMillis2));
                }
                if (i4 != i8) {
                    return HttpUrl.FRAGMENT_ENCODE_SET;
                }
                if (Math.abs(i3 - i7) > 0) {
                    return e(context, parseLong, timeInMillis);
                }
                if (i3 != i7) {
                    return HttpUrl.FRAGMENT_ENCODE_SET;
                }
                if (Math.abs(i2 - i6) > 0) {
                    return e(context, parseLong, timeInMillis);
                }
                if (i2 != i6) {
                    return HttpUrl.FRAGMENT_ENCODE_SET;
                }
                int i9 = i - i5;
                if (Math.abs(i9) <= 1 && Math.abs(i9) == 1) {
                    return e(context, parseLong, timeInMillis);
                }
                return e(context, parseLong, timeInMillis);
            } catch (Exception e) {
                e.printStackTrace();
                return HttpUrl.FRAGMENT_ENCODE_SET;
            }
        }

        public final String b(long j) {
            if (j == 0) {
                return HttpUrl.FRAGMENT_ENCODE_SET;
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
    }
}
