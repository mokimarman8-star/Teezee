package ma;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class i {
    private static final Pattern a = Pattern.compile("^NOTE([ \t].*)?$");

    public static Matcher a(d0 d0Var) {
        String p;
        while (true) {
            String p2 = d0Var.p();
            if (p2 == null) {
                return null;
            }
            if (a.matcher(p2).matches()) {
                do {
                    p = d0Var.p();
                    if (p != null) {
                    }
                } while (!p.isEmpty());
            } else {
                Matcher matcher = f.a.matcher(p2);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }

    public static boolean b(d0 d0Var) {
        String p = d0Var.p();
        return p != null && p.startsWith("WEBVTT");
    }

    public static float c(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long d(String str) {
        String[] T0 = p0.T0(str, "\\.");
        long j = 0;
        for (String str2 : p0.S0(T0[0], ":")) {
            j = (j * 60) + Long.parseLong(str2);
        }
        long j2 = j * 1000;
        if (T0.length == 2) {
            j2 += Long.parseLong(T0[1]);
        }
        return j2 * 1000;
    }

    public static void e(d0 d0Var) {
        int e = d0Var.e();
        if (b(d0Var)) {
            return;
        }
        d0Var.P(e);
        throw ParserException.createForMalformedContainer("Expected WEBVTT. Got " + d0Var.p(), (Throwable) null);
    }
}
