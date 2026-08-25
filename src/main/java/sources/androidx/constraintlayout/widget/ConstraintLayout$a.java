package androidx.constraintlayout.widget;

import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
/* synthetic */ class ConstraintLayout$a {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f6534a;

    static {
        int[] iArr = new int[ConstraintWidget.DimensionBehaviour.values().length];
        f6534a = iArr;
        try {
            iArr[ConstraintWidget.DimensionBehaviour.FIXED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f6534a[ConstraintWidget.DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f6534a[ConstraintWidget.DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f6534a[ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
