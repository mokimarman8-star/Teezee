package y;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class c {
    public static final String a(float f5, int i5) {
        if (Float.isNaN(f5)) {
            return "NaN";
        }
        if (Float.isInfinite(f5)) {
            return f5 < 0.0f ? "-Infinity" : "Infinity";
        }
        int max = Math.max(i5, 0);
        float pow = (float) Math.pow(10.0f, max);
        float f6 = f5 * pow;
        int i6 = (int) f6;
        if (f6 - i6 >= 0.5f) {
            i6++;
        }
        float f7 = i6 / pow;
        return max > 0 ? String.valueOf(f7) : String.valueOf((int) f7);
    }
}
