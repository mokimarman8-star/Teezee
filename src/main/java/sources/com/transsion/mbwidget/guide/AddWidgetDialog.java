package com.transsion.mbwidget.guide;

import android.app.Dialog;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.v;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.report.k;
import com.transsion.baseui.dialog.BaseDialogFragment;
import com.transsion.gslb.BuildConfig;
import com.transsion.mbwidget.HotSubjectWidgetProvider;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.t1;
import wf.a;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0004R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R*\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/transsion/mbwidget/guide/AddWidgetDialog;", "Lcom/transsion/baseui/dialog/BaseDialogFragment;", "Ldm/b;", "<init>", "()V", BuildConfig.FLAVOR, "p0", "n0", "o0", "initView", "onDestroyView", "Landroid/view/Window;", "window", "d0", "(Landroid/view/Window;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "c0", "Lkotlinx/coroutines/t1;", "e", "Lkotlinx/coroutines/t1;", "addWidgetJob", "Lkotlin/Function0;", "f", "Lkotlin/jvm/functions/Function0;", "getOnDismissListener", "()Lkotlin/jvm/functions/Function0;", "t0", "(Lkotlin/jvm/functions/Function0;)V", "onDismissListener", "DeskWidget_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AddWidgetDialog extends BaseDialogFragment<dm.b> {

    /* renamed from: e, reason: from kotlin metadata */
    private t1 addWidgetJob;

    /* renamed from: f, reason: from kotlin metadata */
    private Function0 onDismissListener;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.transsion.mbwidget.guide.AddWidgetDialog$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, dm.b> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, dm.b.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/transsion/mbwidget/databinding/DialogWidgetAddBinding;", 0);
        }

        public final dm.b invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
            Intrinsics.h(layoutInflater, "p0");
            return dm.b.c(layoutInflater, viewGroup, z);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((LayoutInflater) obj, (ViewGroup) obj2, ((Boolean) obj3).booleanValue());
        }
    }

    public AddWidgetDialog() {
        super(AnonymousClass1.INSTANCE);
    }

    private final void n0() {
        Object obj;
        boolean isRequestPinAppWidgetSupported;
        try {
            Result.Companion companion = Result.Companion;
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(Utils.a());
            ComponentName componentName = new ComponentName(Utils.a(), (Class<?>) HotSubjectWidgetProvider.class);
            isRequestPinAppWidgetSupported = appWidgetManager.isRequestPinAppWidgetSupported();
            if (isRequestPinAppWidgetSupported) {
                appWidgetManager.requestPinAppWidget(componentName, null, PendingIntent.getBroadcast(Utils.a(), 0, new Intent(Utils.a(), (Class<?>) WidgetCallbackReceiver.class), 201326592));
                a j = com.transsion.mbwidget.d.a.j();
                if (j != null) {
                    j.a();
                }
                o0();
            }
            obj = Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        Throwable th3 = Result.exceptionOrNull-impl(obj);
        if (th3 != null) {
            a.a.f(wf.a.a, "DeskWidget_", "add-error:" + th3.getMessage(), false, 4, (Object) null);
        }
    }

    private final void o0() {
        if (com.transsion.mbwidget.d.a.n()) {
            this.addWidgetJob = i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new AddWidgetDialog$checkMiUI$1(this, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0() {
        requireContext().startActivity(new Intent(requireContext(), (Class<?>) WidgetGuideActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(AddWidgetDialog addWidgetDialog, View view) {
        Intrinsics.h(view, "it");
        addWidgetDialog.dismiss();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r0(AddWidgetDialog addWidgetDialog, View view) {
        Intrinsics.h(view, "it");
        addWidgetDialog.p0();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(AddWidgetDialog addWidgetDialog, View view) {
        Intrinsics.h(view, "it");
        com.transsion.mbwidget.utils.a.a.b();
        if (Build.VERSION.SDK_INT >= 26) {
            addWidgetDialog.n0();
        } else {
            addWidgetDialog.p0();
        }
        return Unit.a;
    }

    @Override // com.transsion.baseui.dialog.BaseDialogFragment
    public void c0() {
        if (k.a.q()) {
            a0();
            return;
        }
        com.transsion.mbwidget.d dVar = com.transsion.mbwidget.d.a;
        dVar.k().putLong("desk_widget_guide_show_time", System.currentTimeMillis());
        dVar.k().putLong("desk_widget_guide_show_first", 1L);
    }

    @Override // com.transsion.baseui.dialog.BaseDialogFragment
    protected void d0(Window window) {
        Intrinsics.h(window, "window");
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = -2;
        attributes.width = -1;
        window.setGravity(80);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(Z());
        }
        window.setAttributes(attributes);
    }

    @Override // com.transsion.baseui.dialog.BaseDialogFragment
    public void initView() {
        ImageView imageView = ((dm.b) getMViewBinding()).c;
        Intrinsics.g(imageView, "closeIV");
        uf.c.c(imageView, 0L, new Function1() { // from class: com.transsion.mbwidget.guide.c
            public final Object invoke(Object obj) {
                Unit q0;
                q0 = AddWidgetDialog.q0(AddWidgetDialog.this, (View) obj);
                return q0;
            }
        }, 1, (Object) null);
        AppCompatTextView appCompatTextView = ((dm.b) getMViewBinding()).d;
        Intrinsics.g(appCompatTextView, "tipsTv");
        uf.c.c(appCompatTextView, 0L, new Function1() { // from class: com.transsion.mbwidget.guide.d
            public final Object invoke(Object obj) {
                Unit r0;
                r0 = AddWidgetDialog.r0(AddWidgetDialog.this, (View) obj);
                return r0;
            }
        }, 1, (Object) null);
        TextView textView = ((dm.b) getMViewBinding()).b;
        Intrinsics.g(textView, "addTv");
        uf.c.c(textView, 0L, new Function1() { // from class: com.transsion.mbwidget.guide.e
            public final Object invoke(Object obj) {
                Unit s0;
                s0 = AddWidgetDialog.s0(AddWidgetDialog.this, (View) obj);
                return s0;
            }
        }, 1, (Object) null);
        i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new AddWidgetDialog$initView$4(this, null), 3, (Object) null);
    }

    @Override // com.transsion.baseui.dialog.BaseDialogFragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.transsion.mbwidget.utils.a.a.a();
    }

    public void onDestroyView() {
        super.onDestroyView();
        a j = com.transsion.mbwidget.d.a.j();
        if (j != null) {
            j.onDismiss();
        }
        Function0 function0 = this.onDismissListener;
        if (function0 != null) {
            function0.invoke();
        }
        this.onDismissListener = null;
    }

    public final void t0(Function0 function0) {
        this.onDismissListener = function0;
    }
}
