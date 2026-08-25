package com.transsion.baseui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.blankj.utilcode.util.d;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.PushConstants;
import kj.g;
import kj.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import qi.a;
import qi.b;
import wf.a;
import z0.c;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0007J!\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0017\u0010\u000eJ#\u0010\u0018\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\fH\u0016¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\fH\u0016¢\u0006\u0004\b!\u0010\u0004J\u0011\u0010\"\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\"\u0010\u0015J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\f2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\f2\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001d\u00105\u001a\u0004\u0018\u0001008VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00066"}, d2 = {"Lcom/transsion/baseui/dialog/BaseDialog;", "Landroidx/fragment/app/DialogFragment;", "Lqi/a;", "<init>", "()V", BuildConfig.FLAVOR, "contentLayoutId", "(I)V", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", BuildConfig.FLAVOR, "tag", BuildConfig.FLAVOR, "m0", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "e0", "Landroid/content/Context;", "context", "c0", "(Landroid/content/Context;)I", "getClassTag", "()Ljava/lang/String;", "manager", PushConstants.PUSH_SERVICE_TYPE_SHOW, "k0", "(Landroid/content/Context;Ljava/lang/String;)V", "Landroidx/fragment/app/Fragment;", "fragment", "l0", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "onResume", "onStart", "onPause", "onDestroy", "d0", BuildConfig.FLAVOR, "b0", "()Z", "Landroid/content/DialogInterface$OnDismissListener;", "dismissListener", "j0", "(Landroid/content/DialogInterface$OnDismissListener;)V", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "a", "Landroid/content/DialogInterface$OnDismissListener;", "Lqi/b;", "b", "Lkotlin/Lazy;", "getLogViewConfig", "()Lqi/b;", "logViewConfig", "base-dialog_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class BaseDialog extends DialogFragment implements a {

    /* renamed from: a, reason: from kotlin metadata */
    private DialogInterface.OnDismissListener dismissListener;

    /* renamed from: b, reason: from kotlin metadata */
    private final Lazy logViewConfig;

    public BaseDialog() {
        this.logViewConfig = LazyKt.b(new Function0() { // from class: kj.a
            public final Object invoke() {
                qi.b h0;
                h0 = BaseDialog.h0(BaseDialog.this);
                return h0;
            }
        });
    }

    public BaseDialog(int i) {
        super(i);
        this.logViewConfig = LazyKt.b(new Function0() { // from class: kj.a
            public final Object invoke() {
                qi.b h0;
                h0 = BaseDialog.h0(BaseDialog.this);
                return h0;
            }
        });
    }

    private final int c0(Context context) {
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
    private final void e0() {
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
        final int c0 = c0(requireContext);
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
        ViewCompat.setOnApplyWindowInsetsListener(decorView, new OnApplyWindowInsetsListener() { // from class: kj.c
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat f0;
                f0 = BaseDialog.f0(c0, view, view2, windowInsetsCompat);
                return f0;
            }
        });
        if (c0 > 0) {
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
                            if (paddingBottom >= c0) {
                                c0 = paddingBottom;
                            }
                            if (viewGroup.getPaddingBottom() != c0) {
                                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, c0);
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
        decorView.postDelayed(new Runnable() { // from class: kj.d
            @Override // java.lang.Runnable
            public final void run() {
                BaseDialog.g0(decorView);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final WindowInsetsCompat f0(int i, View view, View view2, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.h(view2, "v");
        Intrinsics.h(windowInsetsCompat, "insets");
        c insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.navigationBars());
        Intrinsics.g(insets, "getInsets(...)");
        c insets2 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemGestures());
        Intrinsics.g(insets2, "getInsets(...)");
        int i2 = insets.d;
        if (i2 > 0 || (i2 = insets2.d) > 0) {
            i = i2;
        } else if (i <= 0) {
            i = 0;
        }
        view2.setPadding(0, 0, 0, 0);
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
        return windowInsetsCompat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(View view) {
        ViewCompat.requestApplyInsets(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b h0(BaseDialog baseDialog) {
        return baseDialog.newLogViewConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(BaseDialog baseDialog) {
        baseDialog.e0();
    }

    private final void m0(FragmentManager fragmentManager, String tag) {
        try {
            fragmentManager.g0();
            if (!isAdded() && fragmentManager.k0(tag) == null) {
                show(fragmentManager, tag);
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean b0() {
        return true;
    }

    public String d0() {
        return null;
    }

    public final String getClassTag() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    @Override // qi.a
    public b getLogViewConfig() {
        return (b) this.logViewConfig.getValue();
    }

    public void j0(DialogInterface.OnDismissListener dismissListener) {
        Intrinsics.h(dismissListener, "dismissListener");
        this.dismissListener = dismissListener;
    }

    public void k0(Context context, String tag) {
        if (context instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) context;
            if (fragmentActivity.isFinishing() || fragmentActivity.isDestroyed()) {
                return;
            }
            try {
                FragmentManager supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
                Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
                m0(supportFragmentManager, tag);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void l0(Fragment fragment, String tag) {
        Intrinsics.h(fragment, "fragment");
        try {
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            Intrinsics.g(childFragmentManager, "getChildFragmentManager(...)");
            show(childFragmentManager, tag);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public b newLogViewConfig() {
        return a.C0089a.a(this);
    }

    public void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        g.a.a(d0());
    }

    public void onDismiss(DialogInterface dialog) {
        Intrinsics.h(dialog, "dialog");
        super.onDismiss(dialog);
        DialogInterface.OnDismissListener onDismissListener = this.dismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialog);
        }
    }

    public void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        a.C0089a.b(this);
    }

    public void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        a.C0089a.c(this);
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
        window.getDecorView().post(new Runnable() { // from class: kj.b
            @Override // java.lang.Runnable
            public final void run() {
                BaseDialog.i0(BaseDialog.this);
            }
        });
    }

    public void show(FragmentManager manager, String tag) {
        Intrinsics.h(manager, "manager");
        try {
            manager.g0();
            if (!isAdded() && manager.k0(tag) == null) {
                a.a aVar = wf.a.a;
                StringBuilder sb = new StringBuilder();
                sb.append("show dialog hasShownAnyDialogInSession ");
                sb.append(this);
                sb.append(" :");
                k kVar = k.a;
                sb.append(kVar.b());
                a.a.g(aVar, sb.toString(), false, 2, (Object) null);
                if (!kVar.b()) {
                    kVar.c(true);
                } else if (!b0()) {
                    return;
                }
                super.show(manager, tag);
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
