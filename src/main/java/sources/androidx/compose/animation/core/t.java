package androidx.compose.animation.core;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class t {
    public static final s a(double d5) {
        return d5 < 0.0d ? new s(0.0d, Math.sqrt(Math.abs(d5))) : new s(Math.sqrt(d5), 0.0d);
    }
}
