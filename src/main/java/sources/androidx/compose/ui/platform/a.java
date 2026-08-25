package androidx.compose.ui.platform;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class a implements f {

    /* renamed from: a, reason: collision with root package name */
    protected String f4724a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f4725b = new int[2];

    protected final int[] c(int i5, int i6) {
        if (i5 < 0 || i6 < 0 || i5 == i6) {
            return null;
        }
        int[] iArr = this.f4725b;
        iArr[0] = i5;
        iArr[1] = i6;
        return iArr;
    }

    protected final String d() {
        String str = this.f4724a;
        if (str != null) {
            return str;
        }
        Intrinsics.y("text");
        return null;
    }

    public void e(String str) {
        f(str);
    }

    protected final void f(String str) {
        this.f4724a = str;
    }
}
