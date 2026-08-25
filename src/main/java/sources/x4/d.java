package x4;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class d {
    private static float a(float f5) {
        return f5 <= 0.04045f ? f5 / 12.92f : (float) Math.pow((f5 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    private static float b(float f5) {
        return f5 <= 0.0031308f ? f5 * 12.92f : (float) ((Math.pow(f5, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int c(float f5, int i5, int i6) {
        if (i5 == i6 || f5 <= 0.0f) {
            return i5;
        }
        if (f5 >= 1.0f) {
            return i6;
        }
        float f6 = ((i5 >> 24) & 255) / 255.0f;
        float a5 = a(((i5 >> 16) & 255) / 255.0f);
        float a6 = a(((i5 >> 8) & 255) / 255.0f);
        float a7 = a((i5 & 255) / 255.0f);
        float a8 = a(((i6 >> 16) & 255) / 255.0f);
        float f7 = f6 + (((((i6 >> 24) & 255) / 255.0f) - f6) * f5);
        float a9 = a6 + ((a(((i6 >> 8) & 255) / 255.0f) - a6) * f5);
        float a10 = a7 + (f5 * (a((i6 & 255) / 255.0f) - a7));
        return (Math.round(b(a5 + ((a8 - a5) * f5)) * 255.0f) << 16) | (Math.round(f7 * 255.0f) << 24) | (Math.round(b(a9) * 255.0f) << 8) | Math.round(b(a10) * 255.0f);
    }
}
