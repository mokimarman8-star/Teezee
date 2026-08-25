package androidx.collection;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    private static final m f1298a = new d0(0);

    public static final m a(int... iArr) {
        Intrinsics.h(iArr, "elements");
        d0 d0Var = new d0(iArr.length);
        d0Var.h(iArr);
        return d0Var;
    }
}
