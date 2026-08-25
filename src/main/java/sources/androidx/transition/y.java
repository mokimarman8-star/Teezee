package androidx.transition;

import android.os.Build;
import android.view.ViewGroup;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class y {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f13591a = true;

    static class a {
        static int a(ViewGroup viewGroup, int i5) {
            return viewGroup.getChildDrawingOrder(i5);
        }

        static void b(ViewGroup viewGroup, boolean z5) {
            viewGroup.suppressLayout(z5);
        }
    }

    private static void a(ViewGroup viewGroup, boolean z5) {
        if (f13591a) {
            try {
                a.b(viewGroup, z5);
            } catch (NoSuchMethodError unused) {
                f13591a = false;
            }
        }
    }

    static void b(ViewGroup viewGroup, boolean z5) {
        if (Build.VERSION.SDK_INT >= 29) {
            a.b(viewGroup, z5);
        } else {
            a(viewGroup, z5);
        }
    }
}
