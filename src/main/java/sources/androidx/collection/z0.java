package androidx.collection;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class z0 {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f1364a = new Object();

    public static final Object c(y0 y0Var, int i5) {
        Object obj;
        Intrinsics.h(y0Var, "<this>");
        int a5 = n.a.a(y0Var.f1361b, y0Var.f1363d, i5);
        if (a5 < 0 || (obj = y0Var.f1362c[a5]) == f1364a) {
            return null;
        }
        return obj;
    }

    public static final Object d(y0 y0Var, int i5, Object obj) {
        Object obj2;
        Intrinsics.h(y0Var, "<this>");
        int a5 = n.a.a(y0Var.f1361b, y0Var.f1363d, i5);
        return (a5 < 0 || (obj2 = y0Var.f1362c[a5]) == f1364a) ? obj : obj2;
    }

    public static final void e(y0 y0Var, int i5) {
        Intrinsics.h(y0Var, "<this>");
        int a5 = n.a.a(y0Var.f1361b, y0Var.f1363d, i5);
        if (a5 >= 0) {
            Object[] objArr = y0Var.f1362c;
            Object obj = objArr[a5];
            Object obj2 = f1364a;
            if (obj != obj2) {
                objArr[a5] = obj2;
                y0Var.f1360a = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(y0 y0Var) {
        int i5 = y0Var.f1363d;
        int[] iArr = y0Var.f1361b;
        Object[] objArr = y0Var.f1362c;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            Object obj = objArr[i7];
            if (obj != f1364a) {
                if (i7 != i6) {
                    iArr[i6] = iArr[i7];
                    objArr[i6] = obj;
                    objArr[i7] = null;
                }
                i6++;
            }
        }
        y0Var.f1360a = false;
        y0Var.f1363d = i6;
    }
}
