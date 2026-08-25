package androidx.compose.ui.window;

import kotlin.NoWhenBranchMatchedException;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class k {

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5560a;

        static {
            int[] iArr = new int[SecureFlagPolicy.values().length];
            try {
                iArr[SecureFlagPolicy.SecureOff.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SecureFlagPolicy.SecureOn.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SecureFlagPolicy.Inherit.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f5560a = iArr;
        }
    }

    public static final boolean a(SecureFlagPolicy secureFlagPolicy, boolean z5) {
        int i5 = a.f5560a[secureFlagPolicy.ordinal()];
        if (i5 == 1) {
            return false;
        }
        if (i5 == 2) {
            return true;
        }
        if (i5 == 3) {
            return z5;
        }
        throw new NoWhenBranchMatchedException();
    }
}
