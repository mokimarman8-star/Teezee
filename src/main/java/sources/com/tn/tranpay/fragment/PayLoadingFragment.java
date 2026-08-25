package com.tn.tranpay.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.c0;
import androidx.lifecycle.v;
import com.cloud.tmc.kernel.bridge.RenderCallContext;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.tn.lib.tranpay.R;
import com.tn.tranpay.BillingParams;
import com.tn.tranpay.bean.LoadConfigContent;
import com.tn.tranpay.bean.MediumInputBean;
import com.tn.tranpay.e;
import com.tn.tranpay.fragment.PayFragment;
import com.tn.tranpay.report.b;
import com.tn.tranpay.viewmodel.PaymentViewModel;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001/B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u0004J+\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\u0004J\u0017\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010 \u001a\u00020\u00052\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u001e¢\u0006\u0004\b \u0010!J-\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010#\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b)\u0010*J!\u0010,\u001a\u00020\u00052\u0006\u0010+\u001a\u00020(2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b,\u0010-R\u001b\u00103\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u001e\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u001d\u0010E\u001a\u0004\u0018\u00010\u00168VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bC\u00100\u001a\u0004\bD\u0010\u0018¨\u0006G"}, d2 = {"Lcom/tn/tranpay/fragment/PayLoadingFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/tn/tranpay/report/b;", "<init>", "()V", "", "c0", "logResume", "logPause", "showLoading", "hideLoading", "", "billingResponseCode", "", "message", "serverCode", "d0", "(ILjava/lang/String;Ljava/lang/String;)V", "g0", "j0", TmcConstants.NAVIGATION_ON_START, "onPause", "Lcom/tn/tranpay/report/c;", "h0", "()Lcom/tn/tranpay/report/c;", "onResume", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "Lkotlin/Function0;", "listener", "i0", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/tn/tranpay/BillingParams;", "a", "Lkotlin/Lazy;", "f0", "()Lcom/tn/tranpay/BillingParams;", "params", "Landroid/widget/ProgressBar;", "b", "Landroid/widget/ProgressBar;", "loadingView", "Lcom/tn/tranpay/d;", "c", "Lcom/tn/tranpay/d;", RenderCallContext.TYPE_CALLBACK, "d", "Lkotlin/jvm/functions/Function0;", "onDismissListener", "Lcom/tn/tranpay/viewmodel/PaymentViewModel;", "e", "Lcom/tn/tranpay/viewmodel/PaymentViewModel;", "viewModel", "f", "getLogViewConfig", "logViewConfig", "g", "lib_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class PayLoadingFragment extends DialogFragment implements com.tn.tranpay.report.b {

    /* renamed from: g, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: from kotlin metadata */
    private ProgressBar loadingView;

    /* renamed from: c, reason: from kotlin metadata */
    private com.tn.tranpay.d callback;

    /* renamed from: d, reason: from kotlin metadata */
    private Function0 onDismissListener;

    /* renamed from: a, reason: from kotlin metadata */
    private final Lazy params = LazyKt.b(new Function0<BillingParams>() { // from class: com.tn.tranpay.fragment.PayLoadingFragment$params$2
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final BillingParams m131invoke() {
            Bundle arguments = PayLoadingFragment.this.getArguments();
            BillingParams billingParams = arguments != null ? (BillingParams) arguments.getParcelable("paymentParams") : null;
            Intrinsics.e(billingParams);
            return billingParams;
        }
    });

    /* renamed from: e, reason: from kotlin metadata */
    private final PaymentViewModel viewModel = new PaymentViewModel();

    /* renamed from: f, reason: from kotlin metadata */
    private final Lazy logViewConfig = LazyKt.b(new Function0<com.tn.tranpay.report.c>() { // from class: com.tn.tranpay.fragment.PayLoadingFragment$logViewConfig$2
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final com.tn.tranpay.report.c m130invoke() {
            return PayLoadingFragment.this.h0();
        }
    });

    /* renamed from: com.tn.tranpay.fragment.PayLoadingFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PayLoadingFragment a(BillingParams billingParams, com.tn.tranpay.d dVar) {
            Intrinsics.h(billingParams, "params");
            PayLoadingFragment payLoadingFragment = new PayLoadingFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("paymentParams", billingParams);
            payLoadingFragment.setArguments(bundle);
            payLoadingFragment.callback = dVar;
            return payLoadingFragment;
        }
    }

    static final class b implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        b(Function1 function1) {
            Intrinsics.h(function1, "function");
            this.a = function1;
        }

        public final Function a() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.a.invoke(obj);
        }
    }

    public static final class c implements PayFragment.b {
        c() {
        }

        @Override // com.tn.tranpay.fragment.PayFragment.b
        public void a() {
            PayLoadingFragment.this.hideLoading();
            PayLoadingFragment.this.dismissAllowingStateLoss();
        }

        @Override // com.tn.tranpay.fragment.PayFragment.b
        public void b() {
            if (PayLoadingFragment.this.isAdded()) {
                PayLoadingFragment.this.dismissAllowingStateLoss();
            }
        }
    }

    private final void c0() {
        Dialog dialog;
        Window window;
        if (getResources().getConfiguration().orientation != 2 || (dialog = getDialog()) == null || (window = dialog.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        Intrinsics.g(attributes, "window.attributes");
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        attributes.width = (int) (i * 0.75d);
        attributes.height = (int) (i2 * 0.75d);
        attributes.gravity = 17;
        window.setAttributes(attributes);
        window.setBackgroundDrawable(new ColorDrawable(0));
    }

    private final void d0(int billingResponseCode, String message, String serverCode) {
        com.tn.tranpay.b a = com.tn.tranpay.b.c.a(billingResponseCode, message, serverCode);
        lh.a.e(lh.a.a, "loading error, code: " + billingResponseCode + ", message: " + message + ", serverCode: " + serverCode, null, 2, null);
        com.tn.tranpay.d dVar = this.callback;
        if (dVar != null) {
            dVar.a(a, null);
        }
        this.callback = null;
        com.tn.tranpay.report.c logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.j(false);
        }
        com.tn.tranpay.report.h hVar = com.tn.tranpay.report.h.a;
        String orderDesc = f0().getOrderDesc();
        if (orderDesc == null) {
            orderDesc = "";
        }
        hVar.j(false, orderDesc, f0().getPayByLocalCurrency(), f0().getTxnId());
        g0();
    }

    static /* synthetic */ void e0(PayLoadingFragment payLoadingFragment, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        payLoadingFragment.d0(i, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BillingParams f0() {
        return (BillingParams) this.params.getValue();
    }

    private final void g0() {
        hideLoading();
        dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideLoading() {
        ProgressBar progressBar = this.loadingView;
        if (progressBar == null) {
            return;
        }
        progressBar.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0() {
        PayFragment a = PayFragment.INSTANCE.a(f0(), (LoadConfigContent) this.viewModel.q().f(), this.callback);
        a.v0(new c());
        a.show(getParentFragmentManager(), "pay_fragment");
    }

    private final void logPause() {
        b.a.b(this);
    }

    private final void logResume() {
        b.a.c(this);
    }

    private final void showLoading() {
        if (com.tn.tranpay.e.c.b().c()) {
            ProgressBar progressBar = this.loadingView;
            if (progressBar == null) {
                return;
            }
            progressBar.setVisibility(0);
            return;
        }
        ProgressBar progressBar2 = this.loadingView;
        if (progressBar2 == null) {
            return;
        }
        progressBar2.setVisibility(8);
    }

    @Override // com.tn.tranpay.report.b
    public com.tn.tranpay.report.c getLogViewConfig() {
        return (com.tn.tranpay.report.c) this.logViewConfig.getValue();
    }

    public com.tn.tranpay.report.c h0() {
        return new com.tn.tranpay.report.c("cashier_page", false, 2, null);
    }

    public final void i0(Function0 listener) {
        Intrinsics.h(listener, "listener");
        this.onDismissListener = listener;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.h(inflater, "inflater");
        return inflater.inflate(R.layout.tran_fragment_loading_layout, container, false);
    }

    public void onDismiss(DialogInterface dialog) {
        Intrinsics.h(dialog, "dialog");
        super.onDismiss(dialog);
        Function0 function0 = this.onDismissListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        if (isHidden()) {
            return;
        }
        logPause();
    }

    public void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        logResume();
    }

    public void onStart() {
        Window window;
        Window window2;
        super.onStart();
        if (!com.tn.tranpay.e.c.b().c()) {
            Dialog dialog = getDialog();
            if (dialog == null || (window = dialog.getWindow()) == null) {
                return;
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.0f;
            attributes.flags |= 2;
            window.setAttributes(attributes);
            return;
        }
        Dialog dialog2 = getDialog();
        if (dialog2 == null || (window2 = dialog2.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes2 = window2.getAttributes();
        Intrinsics.g(attributes2, "it.attributes");
        attributes2.width = -1;
        attributes2.height = -1;
        window2.setAttributes(attributes2);
        window2.setBackgroundDrawable(new ColorDrawable(0));
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        e.a aVar = com.tn.tranpay.e.c;
        if (!aVar.b().c()) {
            setStyle(1, R.style.loading_empty_dialog);
        }
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.loading_progress);
        this.loadingView = progressBar;
        if (progressBar != null) {
            progressBar.setIndeterminateTintList(ColorStateList.valueOf(aVar.b().d()));
        }
        c0();
        showLoading();
        this.viewModel.q().j(getViewLifecycleOwner(), new b(new Function1<LoadConfigContent, Unit>() { // from class: com.tn.tranpay.fragment.PayLoadingFragment$onViewCreated$1

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 8, 0})
            @DebugMetadata(c = "com.tn.tranpay.fragment.PayLoadingFragment$onViewCreated$1$1", f = "PayLoadingFragment.kt", l = {}, m = "invokeSuspend")
            /* renamed from: com.tn.tranpay.fragment.PayLoadingFragment$onViewCreated$1$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ PayLoadingFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(PayLoadingFragment payLoadingFragment, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = payLoadingFragment;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, continuation);
                }

                public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
                    return create(n0Var, continuation).invokeSuspend(Unit.a);
                }

                public final Object invokeSuspend(Object obj) {
                    BillingParams f0;
                    BillingParams f02;
                    BillingParams f03;
                    IntrinsicsKt.f();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    com.tn.tranpay.report.c logViewConfig = this.this$0.getLogViewConfig();
                    if (logViewConfig != null) {
                        logViewConfig.j(true);
                    }
                    com.tn.tranpay.report.h hVar = com.tn.tranpay.report.h.a;
                    f0 = this.this$0.f0();
                    String orderDesc = f0.getOrderDesc();
                    if (orderDesc == null) {
                        orderDesc = "";
                    }
                    f02 = this.this$0.f0();
                    boolean payByLocalCurrency = f02.getPayByLocalCurrency();
                    f03 = this.this$0.f0();
                    hVar.j(true, orderDesc, payByLocalCurrency, f03.getTxnId());
                    this.this$0.j0();
                    return Unit.a;
                }
            }

            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LoadConfigContent) obj);
                return Unit.a;
            }

            public final void invoke(LoadConfigContent loadConfigContent) {
                BillingParams f0;
                BillingParams f02;
                BillingParams f03;
                if (loadConfigContent != null && Intrinsics.c(loadConfigContent.getCode(), "0000")) {
                    List<MediumInputBean> medium = loadConfigContent.getMedium();
                    if (medium != null && !medium.isEmpty()) {
                        kotlinx.coroutines.i.d(v.a(PayLoadingFragment.this), y0.c(), (CoroutineStart) null, new AnonymousClass1(PayLoadingFragment.this, null), 2, (Object) null);
                        return;
                    }
                    com.tn.tranpay.report.c logViewConfig = PayLoadingFragment.this.getLogViewConfig();
                    if (logViewConfig != null) {
                        logViewConfig.j(false);
                    }
                    PayLoadingFragment.e0(PayLoadingFragment.this, 3, "Unavailable pay method", null, 4, null);
                    return;
                }
                com.tn.tranpay.report.c logViewConfig2 = PayLoadingFragment.this.getLogViewConfig();
                if (logViewConfig2 != null) {
                    logViewConfig2.j(false);
                }
                com.tn.tranpay.report.h hVar = com.tn.tranpay.report.h.a;
                f0 = PayLoadingFragment.this.f0();
                String orderDesc = f0.getOrderDesc();
                if (orderDesc == null) {
                    orderDesc = "";
                }
                f02 = PayLoadingFragment.this.f0();
                boolean payByLocalCurrency = f02.getPayByLocalCurrency();
                f03 = PayLoadingFragment.this.f0();
                hVar.j(false, orderDesc, payByLocalCurrency, f03.getTxnId());
                PayLoadingFragment.e0(PayLoadingFragment.this, -1, "loading data is null", null, 4, null);
            }
        }));
        kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new PayLoadingFragment$onViewCreated$2(this, null), 3, (Object) null);
    }
}
