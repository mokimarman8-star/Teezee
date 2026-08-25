package androidx.compose.animation.core;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract /* synthetic */ class r {
    public static /* synthetic */ int a(double d5) {
        long doubleToLongBits = Double.doubleToLongBits(d5);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }
}
