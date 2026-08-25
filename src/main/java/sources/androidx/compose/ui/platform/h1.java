package androidx.compose.ui.platform;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class h1 {
    private static final float a(float f5) {
        return (float) (f5 >= 0.0f ? Math.ceil(f5) : Math.floor(f5));
    }

    public static final int b(float f5) {
        return ((int) a(f5)) * (-1);
    }
}
