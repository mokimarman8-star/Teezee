package androidx.fragment.app;

import android.view.View;
import android.view.WindowInsets;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class FragmentContainerView$a {

    /* renamed from: a, reason: collision with root package name */
    public static final FragmentContainerView$a f8109a = new FragmentContainerView$a();

    private FragmentContainerView$a() {
    }

    public final WindowInsets a(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener, View view, WindowInsets windowInsets) {
        Intrinsics.h(onApplyWindowInsetsListener, "onApplyWindowInsetsListener");
        Intrinsics.h(view, "v");
        Intrinsics.h(windowInsets, "insets");
        WindowInsets onApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        Intrinsics.g(onApplyWindowInsets, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
        return onApplyWindowInsets;
    }
}
