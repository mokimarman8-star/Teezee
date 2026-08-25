package q0;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class b {
    public static final float a(float f5) {
        float intBitsToFloat = Float.intBitsToFloat(((int) ((Float.floatToRawIntBits(f5) & 8589934591L) / 3)) + 709952852);
        float f6 = intBitsToFloat - ((intBitsToFloat - (f5 / (intBitsToFloat * intBitsToFloat))) * 0.33333334f);
        return f6 - ((f6 - (f5 / (f6 * f6))) * 0.33333334f);
    }

    public static final float b(float f5, float f6, float f7) {
        return ((1 - f7) * f5) + (f7 * f6);
    }
}
