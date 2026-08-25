package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewParent;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class p0 implements m0 {

    /* renamed from: a, reason: collision with root package name */
    private final Matrix f4845a = new Matrix();

    /* renamed from: b, reason: collision with root package name */
    private final int[] f4846b = new int[2];

    @Override // androidx.compose.ui.platform.m0
    public void a(View view, float[] fArr) {
        this.f4845a.reset();
        view.transformMatrixToGlobal(this.f4845a);
        ViewParent parent = view.getParent();
        while (parent instanceof View) {
            view = parent;
            parent = view.getParent();
        }
        view.getLocationOnScreen(this.f4846b);
        int[] iArr = this.f4846b;
        int i5 = iArr[0];
        int i6 = iArr[1];
        view.getLocationInWindow(iArr);
        int[] iArr2 = this.f4846b;
        this.f4845a.postTranslate(iArr2[0] - i5, iArr2[1] - i6);
        androidx.compose.ui.graphics.r0.b(fArr, this.f4845a);
    }
}
