package androidx.compose.ui.graphics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class f5 {
    public static final long a(float f5, float f6) {
        return e5.b((Float.floatToRawIntBits(f6) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32));
    }
}
