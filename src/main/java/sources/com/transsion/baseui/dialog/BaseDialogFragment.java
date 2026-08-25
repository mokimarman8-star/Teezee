package com.transsion.baseui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.transsion.baselib.report.g;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseDialogFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.PushConstants;
import f4.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import qi.b;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u0004B)\u0012 \u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J+\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u001eH\u0014¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\bH\u0014¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0010H&¢\u0006\u0004\b$\u0010\u001dJ\u000f\u0010%\u001a\u00020\u0010H&¢\u0006\u0004\b%\u0010\u001dJ\u0011\u0010&\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b&\u0010'J!\u0010)\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b)\u0010\u0012J!\u0010,\u001a\u00020\u00102\b\u0010+\u001a\u0004\u0018\u00010*2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\u0010¢\u0006\u0004\b.\u0010\u001dJ\u000f\u0010/\u001a\u00020\u0010H\u0016¢\u0006\u0004\b/\u0010\u001dJ\u000f\u00100\u001a\u00020\u0010H\u0016¢\u0006\u0004\b0\u0010\u001dJ\u000f\u00101\u001a\u00020\u0010H\u0016¢\u0006\u0004\b1\u0010\u001dR.\u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00106\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u001b\u0010;\u001a\u00028\u00008DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001d\u0010@\u001a\u0004\u0018\u00010<8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b=\u00108\u001a\u0004\b>\u0010?¨\u0006A"}, d2 = {"Lcom/transsion/baseui/dialog/BaseDialogFragment;", "Lf4/a;", "VB", "Landroidx/fragment/app/DialogFragment;", "Lcom/transsion/baselib/report/g;", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", BuildConfig.FLAVOR, "bindingInflater", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", BuildConfig.FLAVOR, "tag", BuildConfig.FLAVOR, "h0", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "inflater", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onStart", "()V", "Landroid/view/Window;", "window", "d0", "(Landroid/view/Window;)V", "Z", "()Z", "initView", "c0", "b0", "()Ljava/lang/String;", "manager", PushConstants.PUSH_SERVICE_TYPE_SHOW, "Landroid/content/Context;", "context", "g0", "(Landroid/content/Context;Ljava/lang/String;)V", "a0", "onResume", "onPause", "onDestroy", "a", "Lkotlin/jvm/functions/Function3;", "b", "Lf4/a;", "_binding", "c", "Lkotlin/Lazy;", "getMViewBinding", "()Lf4/a;", "mViewBinding", "Lqi/b;", "d", "getLogViewConfig", "()Lqi/b;", "logViewConfig", "BaseUI_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class BaseDialogFragment<VB extends a> extends DialogFragment implements g {

    /* renamed from: a, reason: from kotlin metadata */
    private final Function3 bindingInflater;

    /* renamed from: b, reason: from kotlin metadata */
    private a _binding;

    /* renamed from: c, reason: from kotlin metadata */
    private final Lazy mViewBinding;

    /* renamed from: d, reason: from kotlin metadata */
    private final Lazy logViewConfig;

    public BaseDialogFragment(Function3 function3) {
        Intrinsics.h(function3, "bindingInflater");
        this.bindingInflater = function3;
        this.mViewBinding = LazyKt.b(new Function0() { // from class: kj.e
            public final Object invoke() {
                f4.a f0;
                f0 = BaseDialogFragment.f0(BaseDialogFragment.this);
                return f0;
            }
        });
        this.logViewConfig = LazyKt.b(new Function0() { // from class: kj.f
            public final Object invoke() {
                qi.b e0;
                e0 = BaseDialogFragment.e0(BaseDialogFragment.this);
                return e0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b e0(BaseDialogFragment baseDialogFragment) {
        return baseDialogFragment.newLogViewConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a f0(BaseDialogFragment baseDialogFragment) {
        a aVar = baseDialogFragment._binding;
        Intrinsics.e(aVar);
        return aVar;
    }

    private final void h0(FragmentManager fragmentManager, String tag) {
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

    protected boolean Z() {
        return true;
    }

    public final void a0() {
        try {
            dismissAllowingStateLoss();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String b0() {
        return null;
    }

    public abstract void c0();

    protected void d0(Window window) {
        Intrinsics.h(window, "window");
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = -2;
        attributes.width = -2;
        window.setGravity(17);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(Z());
        }
        window.setAttributes(attributes);
    }

    public final void g0(Context context, String tag) {
        if (context instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) context;
            if (fragmentActivity.isFinishing() || fragmentActivity.isDestroyed()) {
                return;
            }
            try {
                FragmentManager supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
                Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
                h0(supportFragmentManager, tag);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.transsion.baselib.report.g
    public b getLogViewConfig() {
        return (b) this.logViewConfig.getValue();
    }

    protected final a getMViewBinding() {
        return (a) this.mViewBinding.getValue();
    }

    public abstract void initView();

    public b newLogViewConfig() {
        return g.a.a(this);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R$style.NormalDialogTheme);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.h(inflater, "inflater");
        this._binding = (a) this.bindingInflater.invoke(inflater, container, Boolean.FALSE);
        initView();
        View root = getMViewBinding().getRoot();
        Intrinsics.g(root, "getRoot(...)");
        return root;
    }

    public void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        kj.g.a.a(b0());
    }

    public void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        g.a.b(this);
    }

    public void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        g.a.c(this);
    }

    public void onStart() {
        Window window;
        super.onStart();
        c0();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        d0(window);
    }

    public void show(FragmentManager manager, String tag) {
        Intrinsics.h(manager, "manager");
        try {
            manager.g0();
            if (!isAdded() && manager.k0(tag) == null) {
                super.show(manager, tag);
                kj.g.a.b(b0());
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
