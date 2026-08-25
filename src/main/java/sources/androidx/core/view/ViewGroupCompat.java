package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.R;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class ViewGroupCompat {
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;
    private static final WindowInsets CONSUMED = WindowInsetsCompat.CONSUMED.toWindowInsets();
    static boolean sCompatInsetsDispatchInstalled = false;

    static class a {
        static int a(ViewGroup viewGroup) {
            return viewGroup.getNestedScrollAxes();
        }

        static boolean b(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }

        static void c(ViewGroup viewGroup, boolean z5) {
            viewGroup.setTransitionGroup(z5);
        }
    }

    private ViewGroupCompat() {
    }

    static WindowInsets dispatchApplyWindowInsets(View view, WindowInsets windowInsets) {
        Object tag = view.getTag(R.id.tag_on_apply_window_listener);
        Object tag2 = view.getTag(R.id.tag_window_insets_animation_callback);
        final View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = tag instanceof View.OnApplyWindowInsetsListener ? (View.OnApplyWindowInsetsListener) tag : tag2 instanceof View.OnApplyWindowInsetsListener ? (View.OnApplyWindowInsetsListener) tag2 : null;
        final WindowInsets[] windowInsetsArr = new WindowInsets[1];
        view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: androidx.core.view.m0
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets2) {
                WindowInsets lambda$dispatchApplyWindowInsets$1;
                lambda$dispatchApplyWindowInsets$1 = ViewGroupCompat.lambda$dispatchApplyWindowInsets$1(windowInsetsArr, onApplyWindowInsetsListener, view2, windowInsets2);
                return lambda$dispatchApplyWindowInsets$1;
            }
        });
        view.dispatchApplyWindowInsets(windowInsets);
        Object tag3 = view.getTag(R.id.tag_compat_insets_dispatch);
        if (tag3 instanceof View.OnApplyWindowInsetsListener) {
            onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) tag3;
        }
        view.setOnApplyWindowInsetsListener(onApplyWindowInsetsListener);
        WindowInsets windowInsets2 = windowInsetsArr[0];
        if (windowInsets2 != null && !windowInsets2.isConsumed() && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                dispatchApplyWindowInsets(viewGroup.getChildAt(i5), windowInsetsArr[0]);
            }
        }
        return windowInsetsArr[0];
    }

    @Deprecated
    public static int getLayoutMode(ViewGroup viewGroup) {
        return viewGroup.getLayoutMode();
    }

    public static int getNestedScrollAxes(ViewGroup viewGroup) {
        return a.a(viewGroup);
    }

    public static void installCompatInsetsDispatch(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return;
        }
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = new View.OnApplyWindowInsetsListener() { // from class: androidx.core.view.n0
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                WindowInsets lambda$installCompatInsetsDispatch$0;
                lambda$installCompatInsetsDispatch$0 = ViewGroupCompat.lambda$installCompatInsetsDispatch$0(view2, windowInsets);
                return lambda$installCompatInsetsDispatch$0;
            }
        };
        view.setTag(R.id.tag_compat_insets_dispatch, onApplyWindowInsetsListener);
        view.setOnApplyWindowInsetsListener(onApplyWindowInsetsListener);
        sCompatInsetsDispatchInstalled = true;
    }

    public static boolean isTransitionGroup(ViewGroup viewGroup) {
        return a.b(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ WindowInsets lambda$dispatchApplyWindowInsets$1(WindowInsets[] windowInsetsArr, View.OnApplyWindowInsetsListener onApplyWindowInsetsListener, View view, WindowInsets windowInsets) {
        windowInsetsArr[0] = onApplyWindowInsetsListener != null ? onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets) : view.onApplyWindowInsets(windowInsets);
        return CONSUMED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ WindowInsets lambda$installCompatInsetsDispatch$0(View view, WindowInsets windowInsets) {
        dispatchApplyWindowInsets(view, windowInsets);
        return CONSUMED;
    }

    @Deprecated
    public static boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return viewGroup.onRequestSendAccessibilityEvent(view, accessibilityEvent);
    }

    @Deprecated
    public static void setLayoutMode(ViewGroup viewGroup, int i5) {
        viewGroup.setLayoutMode(i5);
    }

    @Deprecated
    public static void setMotionEventSplittingEnabled(ViewGroup viewGroup, boolean z5) {
        viewGroup.setMotionEventSplittingEnabled(z5);
    }

    public static void setTransitionGroup(ViewGroup viewGroup, boolean z5) {
        a.c(viewGroup, z5);
    }
}
