package ij;

import com.transsion.gslb.BuildConfig;
import java.text.DecimalFormat;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class i {
    public static final String a(int i) {
        return "E" + new DecimalFormat("00").format(Integer.valueOf(i));
    }

    public static final String b(int i, int i2, Integer num) {
        DecimalFormat decimalFormat = new DecimalFormat("00");
        boolean z = (num != null && num.intValue() == 2) || (num != null && num.intValue() == 3) || (num != null && num.intValue() == 6);
        if (num != null && num.intValue() == 5) {
            return "Lesson " + i;
        }
        if (i2 <= 0) {
            return (z ? "E" : "Ch") + decimalFormat.format(Integer.valueOf(i));
        }
        return "S" + decimalFormat.format(Integer.valueOf(i2)) + (z ? " E" : " Ch") + decimalFormat.format(Integer.valueOf(i));
    }

    public static final String c(int i, boolean z) {
        return (z ? " E" : " Ch") + new DecimalFormat("00").format(Integer.valueOf(i));
    }

    public static final String d(String str) {
        if (str == null || str.length() == 0) {
            return BuildConfig.FLAVOR;
        }
        return " · " + str;
    }
}
