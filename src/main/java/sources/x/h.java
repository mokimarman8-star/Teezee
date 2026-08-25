package x;

import android.view.ViewStructure;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f18221a = new h();

    private h() {
    }

    public final int a(ViewStructure viewStructure, int i5) {
        return viewStructure.addChildCount(i5);
    }

    public final ViewStructure b(ViewStructure viewStructure, int i5) {
        return viewStructure.newChild(i5);
    }

    public final void c(ViewStructure viewStructure, int i5, int i6, int i7, int i8, int i9, int i10) {
        viewStructure.setDimens(i5, i6, i7, i8, i9, i10);
    }

    public final void d(ViewStructure viewStructure, int i5, String str, String str2, String str3) {
        viewStructure.setId(i5, str, str2, str3);
    }
}
