package androidx.compose.ui.layout;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class f {
    /* JADX INFO: Access modifiers changed from: private */
    public static final float e(long j5, long j6) {
        return y.m.g(j6) / y.m.g(j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float f(long j5, long j6) {
        return Math.max(h(j5, j6), e(j5, j6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float g(long j5, long j6) {
        return Math.min(h(j5, j6), e(j5, j6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float h(long j5, long j6) {
        return y.m.i(j6) / y.m.i(j5);
    }
}
