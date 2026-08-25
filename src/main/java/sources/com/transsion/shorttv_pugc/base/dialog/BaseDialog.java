package com.transsion.shorttv_pugc.base.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.blankj.utilcode.util.d;
import com.transsion.shorttv_pugc.base.dialog.BaseDialog;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import hr.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import qi.b;
import z0.c;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0003¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001f\u001a\u0004\u0018\u00010\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/transsion/shorttv_pugc/base/dialog/BaseDialog;", "Landroidx/fragment/app/DialogFragment;", "Lhr/e;", "<init>", "()V", HttpUrl.FRAGMENT_ENCODE_SET, "contentLayoutId", "(I)V", HttpUrl.FRAGMENT_ENCODE_SET, "d0", "Landroid/content/Context;", "context", "b0", "(Landroid/content/Context;)I", "Landroidx/fragment/app/FragmentManager;", "manager", HttpUrl.FRAGMENT_ENCODE_SET, "tag", "show", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "onStart", "onResume", "onPause", "onDestroy", "c0", "()Ljava/lang/String;", "Lqi/b;", "a", "Lkotlin/Lazy;", "getLogViewConfig", "()Lqi/b;", "logViewConfig", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class BaseDialog extends DialogFragment implements e {

    /* renamed from: a, reason: from kotlin metadata */
    private final Lazy logViewConfig;

    public BaseDialog() {
        this.logViewConfig = LazyKt.b(new Function0() { // from class: es.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                qi.b g0;
                g0 = BaseDialog.g0(BaseDialog.this);
                return g0;
            }
        });
    }

    public BaseDialog(int i) {
        super(i);
        this.logViewConfig = LazyKt.b(new Function0() { // from class: es.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                qi.b g0;
                g0 = BaseDialog.g0(BaseDialog.this);
                return g0;
            }
        });
    }

    private final int b0(Context context) {
        try {
            return d.a();
        } catch (Exception unused) {
            int i = 0;
            try {
                Resources resources = context.getResources();
                int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
                if (identifier > 0) {
                    i = resources.getDimensionPixelSize(identifier);
                }
            } catch (Exception unused2) {
            }
            return i;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void d0() {
        Window window;
        final View decorView;
        final View view;
        ViewGroup viewGroup;
        Drawable background;
        Drawable background2;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null || (decorView = window.getDecorView()) == null || (view = getView()) == null) {
            return;
        }
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        final int b0 = b0(requireContext);
        boolean z = view instanceof ViewGroup;
        if (z) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            viewGroup2.setFitsSystemWindows(false);
            if (viewGroup2.getBackground() == null) {
                View childAt = viewGroup2.getChildCount() > 0 ? viewGroup2.getChildAt(0) : null;
                if (childAt == null || (background2 = childAt.getBackground()) == null) {
                    view.setBackgroundColor(0);
                } else {
                    viewGroup2.setBackground(background2);
                }
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(decorView, new OnApplyWindowInsetsListener() { // from class: es.c
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat e0;
                e0 = BaseDialog.e0(b0, view, view2, windowInsetsCompat);
                return e0;
            }
        });
        if (b0 > 0) {
            if (z) {
                ViewGroup viewGroup3 = (ViewGroup) view;
                if (viewGroup3.getChildCount() > 0) {
                    View childAt2 = viewGroup3.getChildAt(0);
                    if (childAt2 instanceof ViewGroup) {
                        viewGroup = (ViewGroup) childAt2;
                        if (viewGroup != null) {
                            int paddingLeft = viewGroup.getPaddingLeft();
                            int paddingTop = viewGroup.getPaddingTop();
                            int paddingRight = viewGroup.getPaddingRight();
                            int paddingBottom = viewGroup.getPaddingBottom();
                            if (paddingBottom >= b0) {
                                b0 = paddingBottom;
                            }
                            if (viewGroup.getPaddingBottom() != b0) {
                                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, b0);
                            }
                        }
                        if (z) {
                            ViewGroup viewGroup4 = (ViewGroup) view;
                            if (viewGroup4.getBackground() == null) {
                                View childAt3 = viewGroup4.getChildCount() > 0 ? viewGroup4.getChildAt(0) : null;
                                if (childAt3 != null && (background = childAt3.getBackground()) != null) {
                                    viewGroup4.setBackground(background);
                                }
                            }
                        }
                    }
                    viewGroup = null;
                    if (viewGroup != null) {
                    }
                    if (z) {
                    }
                }
            }
            if (z) {
                viewGroup = (ViewGroup) view;
                if (viewGroup != null) {
                }
                if (z) {
                }
            }
            viewGroup = null;
            if (viewGroup != null) {
            }
            if (z) {
            }
        }
        ViewCompat.requestApplyInsets(decorView);
        decorView.postDelayed(new Runnable() { // from class: es.d
            @Override // java.lang.Runnable
            public final void run() {
                BaseDialog.f0(decorView);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final WindowInsetsCompat e0(int i, View view, View v, WindowInsetsCompat insets) {
        Intrinsics.h(v, "v");
        Intrinsics.h(insets, "insets");
        c insets2 = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
        Intrinsics.g(insets2, "getInsets(...)");
        c insets3 = insets.getInsets(WindowInsetsCompat.Type.systemGestures());
        Intrinsics.g(insets3, "getInsets(...)");
        int i2 = insets2.d;
        if (i2 > 0 || (i2 = insets3.d) > 0) {
            i = i2;
        } else if (i <= 0) {
            i = 0;
        }
        v.setPadding(0, 0, 0, 0);
        if (i > 0) {
            boolean z = view instanceof ViewGroup;
            ViewGroup viewGroup = null;
            if (z) {
                ViewGroup viewGroup2 = (ViewGroup) view;
                if (viewGroup2.getChildCount() > 0) {
                    View childAt = viewGroup2.getChildAt(0);
                    if (childAt instanceof ViewGroup) {
                        viewGroup = (ViewGroup) childAt;
                    }
                    if (viewGroup != null) {
                        int paddingLeft = viewGroup.getPaddingLeft();
                        int paddingTop = viewGroup.getPaddingTop();
                        int paddingRight = viewGroup.getPaddingRight();
                        int paddingBottom = viewGroup.getPaddingBottom();
                        if (paddingBottom >= i) {
                            i = paddingBottom;
                        }
                        if (viewGroup.getPaddingBottom() != i) {
                            viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, i);
                        }
                    }
                }
            }
            if (z) {
                viewGroup = (ViewGroup) view;
            }
            if (viewGroup != null) {
            }
        }
        return insets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(View view) {
        ViewCompat.requestApplyInsets(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b g0(BaseDialog baseDialog) {
        return baseDialog.newLogViewConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(BaseDialog baseDialog) {
        baseDialog.d0();
    }

    public String c0() {
        return null;
    }

    public b getLogViewConfig() {
        return (b) this.logViewConfig.getValue();
    }

    public b newLogViewConfig() {
        return e.a.a(this);
    }

    public void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        es.e.a.a(c0());
    }

    public void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        e.a.b(this);
    }

    public void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        e.a.c(this);
    }

    public void onStart() {
        Dialog dialog;
        Window window;
        super.onStart();
        if (Build.VERSION.SDK_INT < 35 || (dialog = getDialog()) == null || (window = dialog.getWindow()) == null) {
            return;
        }
        WindowCompat.setDecorFitsSystemWindows(window, false);
        window.setNavigationBarColor(0);
        window.setStatusBarColor(0);
        window.getDecorView().post(new Runnable() { // from class: es.b
            @Override // java.lang.Runnable
            public final void run() {
                BaseDialog.h0(BaseDialog.this);
            }
        });
    }

    public void show(FragmentManager manager, String tag) {
        Intrinsics.h(manager, "manager");
        try {
            manager.g0();
            if (!isAdded() && manager.k0(tag) == null) {
                super.show(manager, tag);
                es.e.a.b(c0());
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
