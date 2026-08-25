package ij;

import android.location.Location;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class s {
    public static final s a = new s();

    private s() {
    }

    public final String a(double d, double d2, double d3, double d4) {
        float f;
        try {
            float[] fArr = new float[1];
            Location.distanceBetween(d, d2, d3, d4, fArr);
            f = fArr[0];
        } catch (Throwable unused) {
            f = -1.0f;
        }
        if (f < 0.1f) {
            return "<0.1m";
        }
        if (f < 1000.0f) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String format = String.format("%.1fm", Arrays.copyOf(new Object[]{Float.valueOf(f)}, 1));
            Intrinsics.g(format, "format(...)");
            return format;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.a;
        String format2 = String.format("%.1fkm", Arrays.copyOf(new Object[]{Float.valueOf(f / 1000)}, 1));
        Intrinsics.g(format2, "format(...)");
        return format2;
    }

    public final float b(double d, double d2, double d3, double d4) {
        try {
            float[] fArr = new float[1];
            Location.distanceBetween(d, d2, d3, d4, fArr);
            return fArr[0];
        } catch (Throwable unused) {
            return -1.0f;
        }
    }
}
