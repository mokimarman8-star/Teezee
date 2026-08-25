package androidx.fragment.app;

import androidx.fragment.app.SpecialEffectsController;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
/* synthetic */ class DefaultSpecialEffectsController$a {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f8043a;

    static {
        int[] iArr = new int[SpecialEffectsController.Operation.State.values().length];
        f8043a = iArr;
        try {
            iArr[SpecialEffectsController.Operation.State.GONE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f8043a[SpecialEffectsController.Operation.State.INVISIBLE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f8043a[SpecialEffectsController.Operation.State.REMOVED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f8043a[SpecialEffectsController.Operation.State.VISIBLE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
