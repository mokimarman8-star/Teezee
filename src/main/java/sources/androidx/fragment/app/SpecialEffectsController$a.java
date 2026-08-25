package androidx.fragment.app;

import androidx.fragment.app.SpecialEffectsController;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
/* synthetic */ class SpecialEffectsController$a {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f8180a;

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ int[] f8181b;

    static {
        int[] iArr = new int[SpecialEffectsController.Operation.LifecycleImpact.values().length];
        f8181b = iArr;
        try {
            iArr[SpecialEffectsController.Operation.LifecycleImpact.ADDING.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f8181b[SpecialEffectsController.Operation.LifecycleImpact.REMOVING.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f8181b[SpecialEffectsController.Operation.LifecycleImpact.NONE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        int[] iArr2 = new int[SpecialEffectsController.Operation.State.values().length];
        f8180a = iArr2;
        try {
            iArr2[SpecialEffectsController.Operation.State.REMOVED.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f8180a[SpecialEffectsController.Operation.State.VISIBLE.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f8180a[SpecialEffectsController.Operation.State.GONE.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f8180a[SpecialEffectsController.Operation.State.INVISIBLE.ordinal()] = 4;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
