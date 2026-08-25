package com.tn.tranpay.fragment;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.c0;
import androidx.lifecycle.m;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import com.blankj.utilcode.util.a0;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.google.gson.Gson;
import com.tencent.mmkv.MMKV;
import com.tn.lib.tranpay.R;
import com.tn.tranpay.BillingParams;
import com.tn.tranpay.TranPay;
import com.tn.tranpay.activity.TranPayWebActivity;
import com.tn.tranpay.b;
import com.tn.tranpay.bean.CreateOrderResultContent;
import com.tn.tranpay.bean.HandleResultType;
import com.tn.tranpay.bean.InputInfoBean;
import com.tn.tranpay.bean.LoadConfigContent;
import com.tn.tranpay.bean.MediumInputBean;
import com.tn.tranpay.bean.QueryOrderResultContent;
import com.tn.tranpay.bean.QueryStatus;
import com.tn.tranpay.event.AppScopeVMlProvider;
import com.tn.tranpay.event.FlowEventBus;
import com.tn.tranpay.fragment.PayFragment;
import com.tn.tranpay.helper.PayUtils;
import com.tn.tranpay.helper.PaymentMMKV;
import com.tn.tranpay.viewmodel.PaymentViewModel;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.t1;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \\2\u00020\u0001:\u00028@B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u0003J+\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010 \u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\n2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u0019\u0010)\u001a\u00020(2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\nH\u0016¢\u0006\u0004\b+\u0010\u0003J-\u00101\u001a\u0004\u0018\u0001002\u0006\u0010-\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u00010.2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b1\u00102J!\u00104\u001a\u00020\n2\u0006\u00103\u001a\u0002002\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b4\u00105J\r\u00106\u001a\u00020\n¢\u0006\u0004\b6\u0010\u0003R$\u0010>\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u001b\u0010T\u001a\u00020O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010[\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010Z¨\u0006]"}, d2 = {"Lcom/tn/tranpay/fragment/PayFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "", "Lcom/tn/tranpay/bean/MediumInputBean;", "list", "", "k0", "(Ljava/util/List;)Z", "", "p0", "s0", "t0", "", "responseCode", "", "message", "serverCode", "i0", "(ILjava/lang/String;Ljava/lang/String;)V", "w0", "Lcom/tn/tranpay/bean/CreateOrderResultContent;", "result", "Lcom/tn/tranpay/bean/HandleResultType;", "q0", "(Lcom/tn/tranpay/bean/CreateOrderResultContent;)Lcom/tn/tranpay/bean/HandleResultType;", "webUrl", "r0", "(Ljava/lang/String;)V", "appLink", "packageName", "n0", "(Ljava/lang/String;Ljava/lang/String;)Z", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", TmcConstants.NAVIGATION_ON_START, "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "o0", "Lcom/tn/tranpay/fragment/PayFragment$b;", "a", "Lcom/tn/tranpay/fragment/PayFragment$b;", "l0", "()Lcom/tn/tranpay/fragment/PayFragment$b;", "v0", "(Lcom/tn/tranpay/fragment/PayFragment$b;)V", "onDismissListener", "Lkotlinx/coroutines/t1;", "b", "Lkotlinx/coroutines/t1;", "paymentEventJob", "Lcom/tn/tranpay/BillingParams;", "c", "Lcom/tn/tranpay/BillingParams;", "paymentParams", "Lcom/tn/tranpay/d;", "d", "Lcom/tn/tranpay/d;", "mCallback", "Lcom/tn/tranpay/bean/LoadConfigContent;", "e", "Lcom/tn/tranpay/bean/LoadConfigContent;", "configBean", "Lcom/tn/tranpay/viewmodel/PaymentViewModel;", "f", "Lkotlin/Lazy;", "m0", "()Lcom/tn/tranpay/viewmodel/PaymentViewModel;", "viewModel", "Landroid/widget/FrameLayout;", "g", "Landroid/widget/FrameLayout;", "loadingLayout", "h", "Z", "canHandleFirstPayMethod", "i", "lib_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class PayFragment extends DialogFragment {

    /* renamed from: i, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private b onDismissListener;

    /* renamed from: b, reason: from kotlin metadata */
    private t1 paymentEventJob;

    /* renamed from: c, reason: from kotlin metadata */
    private BillingParams paymentParams;

    /* renamed from: d, reason: from kotlin metadata */
    private com.tn.tranpay.d mCallback;

    /* renamed from: e, reason: from kotlin metadata */
    private LoadConfigContent configBean;

    /* renamed from: f, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: g, reason: from kotlin metadata */
    private FrameLayout loadingLayout;

    /* renamed from: h, reason: from kotlin metadata */
    private boolean canHandleFirstPayMethod;

    /* renamed from: com.tn.tranpay.fragment.PayFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PayFragment a(BillingParams billingParams, LoadConfigContent loadConfigContent, com.tn.tranpay.d dVar) {
            Intrinsics.h(billingParams, "params");
            PayFragment payFragment = new PayFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("paymentParams", billingParams);
            bundle.putParcelable("configBean", loadConfigContent);
            payFragment.setArguments(bundle);
            payFragment.paymentParams = billingParams;
            payFragment.configBean = loadConfigContent;
            payFragment.mCallback = dVar;
            return payFragment;
        }
    }

    public interface b {
        void a();

        void b();
    }

    static final class c implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        c(Function1 function1) {
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

    public PayFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tn.tranpay.fragment.PayFragment$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Fragment m125invoke() {
                return this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.a(this, Reflection.b(PaymentViewModel.class), new Function0<x0>() { // from class: com.tn.tranpay.fragment.PayFragment$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final x0 m126invoke() {
                x0 viewModelStore = ((y0) function0.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.tn.tranpay.fragment.PayFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final v0.c m127invoke() {
                Object invoke = function0.invoke();
                m mVar = invoke instanceof m ? (m) invoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(int responseCode, String message, String serverCode) {
        BillingParams billingParams;
        com.tn.tranpay.c cVar = (m0().A() == null || (billingParams = this.paymentParams) == null) ? null : new com.tn.tranpay.c(billingParams.getOrderId(), billingParams.getOrderDesc(), billingParams.getAmount(), m0().A(), billingParams.getPayByLocalCurrency());
        if (com.tn.tranpay.a.a.a(responseCode)) {
            com.tn.tranpay.report.h.f(com.tn.tranpay.report.h.a, 1, null, 2, null);
        } else if (responseCode == 1) {
            com.tn.tranpay.report.h.a.e(0, Boolean.TRUE);
        } else {
            com.tn.tranpay.report.h.a.e(0, Boolean.FALSE);
        }
        com.tn.tranpay.b a = com.tn.tranpay.b.c.a(responseCode, message, serverCode);
        com.tn.tranpay.d o = m0().o();
        if (o != null) {
            o.a(a, cVar);
        }
        m0().K(null);
        m0().i();
        dismissAllowingStateLoss();
    }

    static /* synthetic */ void j0(PayFragment payFragment, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        payFragment.i0(i, str, str2);
    }

    private final boolean k0(List list) {
        if (list == null || list.size() != 1) {
            return false;
        }
        List<InputInfoBean> inputs = ((MediumInputBean) list.get(0)).getInputs();
        return inputs == null || inputs.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PaymentViewModel m0() {
        return (PaymentViewModel) this.viewModel.getValue();
    }

    private final boolean n0(String appLink, String packageName) {
        if (packageName != null && packageName.length() != 0) {
            PayUtils payUtils = PayUtils.a;
            if (!PayUtils.e(payUtils, packageName, null, 2, null)) {
                lh.a.g(lh.a.a, "handleAppLink: " + packageName + " not installed", null, 2, null);
                return false;
            }
            if (appLink != null && appLink.length() != 0) {
                return payUtils.g(appLink);
            }
        }
        return false;
    }

    private final void p0() {
        this.canHandleFirstPayMethod = false;
        LoadConfigContent loadConfigContent = this.configBean;
        if (!k0(loadConfigContent != null ? loadConfigContent.getMedium() : null) || m0().t()) {
            return;
        }
        this.canHandleFirstPayMethod = true;
        m0().L(true);
        LoadConfigContent loadConfigContent2 = this.configBean;
        List<MediumInputBean> medium = loadConfigContent2 != null ? loadConfigContent2.getMedium() : null;
        Intrinsics.e(medium);
        String code = medium.get(0).getCode();
        if (code == null) {
            code = "";
        }
        String str = code;
        com.tn.tranpay.report.h.a.a(str, false, false, true);
        PaymentViewModel.k(m0(), str, null, null, true, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HandleResultType q0(CreateOrderResultContent result) {
        String rnUrl = result.getRnUrl();
        jh.a payInstruction = result.getPayInstruction();
        String a = payInstruction != null ? payInstruction.a() : null;
        String webUrl = result.getWebUrl();
        try {
            Result.Companion companion = Result.Companion;
            if (n0(rnUrl, a)) {
                lh.a.g(lh.a.a, "handleAppLink: " + a + " installed", null, 2, null);
                com.tn.tranpay.report.h.a.d(1, webUrl, rnUrl, a, m0().n());
                return HandleResultType.APP_LINK;
            }
            if (webUrl == null) {
                lh.a.g(lh.a.a, "rnUrl and webUrl is null that don't need to handle anything", null, 2, null);
                com.tn.tranpay.report.h.a.d(2, null, rnUrl, a, m0().n());
                return HandleResultType.OPERATOR;
            }
            lh.a.g(lh.a.a, "handleWebUrl: " + webUrl, null, 2, null);
            r0(webUrl);
            com.tn.tranpay.report.h.a.d(0, webUrl, rnUrl, a, m0().n());
            return HandleResultType.WEB;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Throwable th2 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.a(th)));
            if (th2 == null) {
                return HandleResultType.EXCEPTION;
            }
            lh.a.e(lh.a.a, "handleResult: " + th2, null, 2, null);
            com.tn.tranpay.report.h.a.d(-1, webUrl, rnUrl, a, m0().n());
            return HandleResultType.EXCEPTION;
        }
    }

    private final void r0(String webUrl) {
        try {
            Application d = TranPay.a.d();
            Intent intent = new Intent();
            intent.putExtra("url", webUrl);
            BillingParams billingParams = this.paymentParams;
            intent.putExtra("cpFrontPage", billingParams != null ? billingParams.getCpFrontPage() : null);
            BillingParams billingParams2 = this.paymentParams;
            intent.putExtra("shouldOpenCpFrontPage", billingParams2 != null ? Boolean.valueOf(billingParams2.getShouldOpenCpFrontPage()) : null);
            intent.setClass(d, TranPayWebActivity.class);
            intent.addFlags(268435456);
            d.startActivity(intent);
        } catch (Exception e) {
            lh.a.e(lh.a.a, "Failed to handle web URL: " + e.getMessage(), null, 2, null);
        }
    }

    private final void s0() {
        final Gson gson = new Gson();
        Transformations.a(m0().s()).j(getViewLifecycleOwner(), new c(new Function1<CreateOrderResultContent, Unit>() { // from class: com.tn.tranpay.fragment.PayFragment$observeLiveData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((CreateOrderResultContent) obj);
                return Unit.a;
            }

            public final void invoke(CreateOrderResultContent createOrderResultContent) {
                PaymentViewModel m0;
                PaymentViewModel m02;
                PaymentViewModel m03;
                PaymentViewModel m04;
                PaymentViewModel m05;
                PaymentViewModel m06;
                PaymentViewModel m07;
                PaymentViewModel m08;
                PaymentViewModel m09;
                PaymentViewModel m010;
                PaymentViewModel m011;
                PaymentViewModel m012;
                PaymentViewModel m013;
                HandleResultType q0;
                PaymentViewModel m014;
                PaymentViewModel m015;
                lh.a aVar = lh.a.a;
                lh.a.g(aVar, "resultContent is " + gson.toJson(createOrderResultContent) + ", " + (createOrderResultContent != null ? createOrderResultContent.getStatus() : null), null, 2, null);
                PayFragment.b onDismissListener = this.getOnDismissListener();
                if (onDismissListener != null) {
                    onDismissListener.a();
                }
                m0 = this.m0();
                if (m0.u()) {
                    return;
                }
                if (createOrderResultContent == null) {
                    m02 = this.m0();
                    m02.w().n(Boolean.FALSE);
                    com.tn.tranpay.report.h hVar = com.tn.tranpay.report.h.a;
                    m03 = this.m0();
                    String y = m03.y();
                    m04 = this.m0();
                    String p = m04.p();
                    m05 = this.m0();
                    hVar.k(false, y, p, m05.n());
                    PayFragment.j0(this, 5, "Create order failed", null, 4, null);
                    return;
                }
                if (!Intrinsics.c(createOrderResultContent.getCode(), "0000") || Intrinsics.c(createOrderResultContent.getStatus(), "0") || createOrderResultContent.getTxnId() == null) {
                    m06 = this.m0();
                    m06.w().n(Boolean.FALSE);
                    com.tn.tranpay.report.h hVar2 = com.tn.tranpay.report.h.a;
                    m07 = this.m0();
                    String y2 = m07.y();
                    m08 = this.m0();
                    String p2 = m08.p();
                    m09 = this.m0();
                    hVar2.k(false, y2, p2, m09.n());
                    this.i0(5, createOrderResultContent.getMessage(), createOrderResultContent.getCode());
                    return;
                }
                m010 = this.m0();
                m010.M(true);
                lh.a.g(aVar, "createOrderResultLiveData: " + gson.toJson(createOrderResultContent), null, 2, null);
                com.tn.tranpay.report.h hVar3 = com.tn.tranpay.report.h.a;
                m011 = this.m0();
                String y3 = m011.y();
                m012 = this.m0();
                String p3 = m012.p();
                m013 = this.m0();
                hVar3.k(true, y3, p3, m013.n());
                q0 = this.q0(createOrderResultContent);
                if (q0 != HandleResultType.APP_LINK && q0 != HandleResultType.OPERATOR) {
                    m015 = this.m0();
                    m015.w().n(Boolean.FALSE);
                } else {
                    m014 = this.m0();
                    String txnId = createOrderResultContent.getTxnId();
                    Intrinsics.e(txnId);
                    PaymentViewModel.H(m014, txnId, 0L, 0L, 6, null);
                }
            }
        }));
        m0().z().j(getViewLifecycleOwner(), new c(new Function1<jh.b, Unit>() { // from class: com.tn.tranpay.fragment.PayFragment$observeLiveData$2

            public /* synthetic */ class a {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[QueryStatus.values().length];
                    try {
                        iArr[QueryStatus.FAILURE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[QueryStatus.SUCCESS.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[QueryStatus.ERROR.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[QueryStatus.PROCESSING.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[QueryStatus.CANCELLED.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    a = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((jh.b) obj);
                return Unit.a;
            }

            public final void invoke(jh.b bVar) {
                String str;
                PaymentViewModel m0;
                String str2;
                lh.a aVar = lh.a.a;
                lh.a.g(aVar, "resultContent is " + gson.toJson(bVar) + ", " + (bVar != null ? bVar.b() : null), null, 2, null);
                if (bVar != null) {
                    PayFragment payFragment = this;
                    QueryOrderResultContent a2 = bVar.a();
                    int i = a.a[bVar.b().ordinal()];
                    if (i == 1) {
                        lh.a.g(aVar, "支付失败", null, 2, null);
                        if (a2 == null || (str = a2.getMessage()) == null) {
                            str = "Payment failed";
                        }
                        Intrinsics.e(a2);
                        payFragment.i0(6, str, a2.getCode());
                        return;
                    }
                    if (i == 2) {
                        lh.a.g(aVar, "支付成功", null, 2, null);
                        MMKV h = PaymentMMKV.a.h();
                        m0 = payFragment.m0();
                        h.putString("k_pay_method_code", m0.x());
                        if (a2 == null || (str2 = a2.getMessage()) == null) {
                            str2 = "Payment success";
                        }
                        PayFragment.j0(payFragment, 0, str2, null, 4, null);
                        return;
                    }
                    if (i == 3) {
                        lh.a.g(aVar, "支付异常", null, 2, null);
                        PayFragment.j0(payFragment, 2, "Payment error", null, 4, null);
                    } else if (i == 4) {
                        lh.a.g(aVar, "支付处理中", null, 2, null);
                        PayFragment.j0(payFragment, 4, "Payment processing", null, 4, null);
                    } else {
                        if (i != 5) {
                            return;
                        }
                        lh.a.g(aVar, "取消轮询", null, 2, null);
                    }
                }
            }
        }));
        Transformations.a(m0().w()).j(getViewLifecycleOwner(), new c(new Function1<Boolean, Unit>() { // from class: com.tn.tranpay.fragment.PayFragment$observeLiveData$3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.a;
            }

            public final void invoke(Boolean bool) {
                FrameLayout frameLayout;
                boolean z;
                FrameLayout frameLayout2;
                Intrinsics.g(bool, "it");
                if (bool.booleanValue()) {
                    z = PayFragment.this.canHandleFirstPayMethod;
                    if (!z) {
                        frameLayout2 = PayFragment.this.loadingLayout;
                        if (frameLayout2 == null) {
                            return;
                        }
                        frameLayout2.setVisibility(0);
                        return;
                    }
                }
                frameLayout = PayFragment.this.loadingLayout;
                if (frameLayout == null) {
                    return;
                }
                frameLayout.setVisibility(8);
            }
        }));
    }

    private final void t0() {
        t1 observeEvent;
        Function1<com.tn.tranpay.event.b, Unit> function1 = new Function1<com.tn.tranpay.event.b, Unit>() { // from class: com.tn.tranpay.fragment.PayFragment$observerEvent$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((com.tn.tranpay.event.b) obj);
                return Unit.a;
            }

            public final void invoke(com.tn.tranpay.event.b bVar) {
                PaymentViewModel m0;
                t1 t1Var;
                PaymentViewModel m02;
                PaymentViewModel m03;
                Intrinsics.h(bVar, "event");
                lh.a aVar = lh.a.a;
                lh.a.c(aVar, "PaymentEvent: " + bVar, null, 2, null);
                if (bVar.a() < 0) {
                    lh.a.g(aVar, "支付取消", null, 2, null);
                    m02 = PayFragment.this.m0();
                    String A = m02.A();
                    if (A != null) {
                        m03 = PayFragment.this.m0();
                        PaymentViewModel.h(m03, A, "USER CANCEL", null, 4, null);
                    }
                    PayFragment.j0(PayFragment.this, 1, "Payment cancelled", null, 4, null);
                } else {
                    lh.a.g(aVar, "三方收银台页面关闭或完成，调整轮询时间继续查询", null, 2, null);
                    m0 = PayFragment.this.m0();
                    m0.J();
                }
                t1Var = PayFragment.this.paymentEventJob;
                if (t1Var != null) {
                    t1.a.b(t1Var, (CancellationException) null, 1, (Object) null);
                }
            }
        };
        if (com.tn.tranpay.event.a.a.c()) {
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = com.tn.tranpay.event.b.class.getName();
            Intrinsics.g(name, "T::class.java.name");
            observeEvent = flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().p(), false, function1);
        } else {
            observeEvent = null;
            lh.a.e(lh.a.a, "TranPay SDK not initialized, cannot observe event. Please call TranPay.configure() in Application.onCreate()", null, 2, null);
        }
        this.paymentEventJob = observeEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean u0(PayFragment payFragment, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Intrinsics.h(payFragment, "this$0");
        if (i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        payFragment.o0();
        return true;
    }

    private final void w0() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        Intrinsics.g(attributes, "it.attributes");
        attributes.gravity = 80;
        attributes.width = -1;
        if (getResources().getConfiguration().orientation == 2) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            attributes.width = (int) (i * 0.75d);
            attributes.height = (int) (i2 * 0.75d);
            attributes.gravity = 17;
        } else {
            attributes.height = a0.a(533.0f);
        }
        window.setAttributes(attributes);
        window.setBackgroundDrawable(new ColorDrawable(0));
    }

    /* renamed from: l0, reason: from getter */
    public final b getOnDismissListener() {
        return this.onDismissListener;
    }

    public final void o0() {
        Context activity = getActivity();
        if (activity != null) {
            PayUtils.a.n(activity, new Function0<Unit>() { // from class: com.tn.tranpay.fragment.PayFragment$handleDismiss$1$1
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m128invoke();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m128invoke() {
                    PaymentViewModel m0;
                    BillingParams billingParams;
                    PaymentViewModel m02;
                    PaymentViewModel m03;
                    PaymentViewModel m04;
                    lh.a.c(lh.a.a, "用户点击了支付后的留存提示", null, 2, null);
                    com.tn.tranpay.report.h.a.i();
                    m0 = PayFragment.this.m0();
                    String A = m0.A();
                    if (A != null) {
                        m04 = PayFragment.this.m0();
                        PaymentViewModel.h(m04, A, "USER CANCEL", null, 4, null);
                    }
                    billingParams = PayFragment.this.paymentParams;
                    if (billingParams != null) {
                        PayFragment payFragment = PayFragment.this;
                        m02 = payFragment.m0();
                        com.tn.tranpay.d o = m02.o();
                        if (o != null) {
                            com.tn.tranpay.b b2 = b.a.b(com.tn.tranpay.b.c, 1, "User cancelled", null, 4, null);
                            String orderId = billingParams.getOrderId();
                            String orderDesc = billingParams.getOrderDesc();
                            String amount = billingParams.getAmount();
                            m03 = payFragment.m0();
                            o.a(b2, new com.tn.tranpay.c(orderId, orderDesc, amount, m03.A(), billingParams.getPayByLocalCurrency()));
                        }
                    }
                    PayFragment.this.dismissAllowingStateLoss();
                }
            }, new Function0<Unit>() { // from class: com.tn.tranpay.fragment.PayFragment$handleDismiss$1$2
                public /* bridge */ /* synthetic */ Object invoke() {
                    m129invoke();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m129invoke() {
                    com.tn.tranpay.report.h.a.g();
                    lh.a.c(lh.a.a, "用户拒绝了支付后的留存提示", null, 2, null);
                }
            });
            com.tn.tranpay.report.h.a.h();
        }
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if (getActivity() == null) {
            throw new IllegalStateException("Activity cannot be null");
        }
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.g(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        onCreateDialog.setCanceledOnTouchOutside(false);
        onCreateDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.tn.tranpay.fragment.a
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                boolean u0;
                u0 = PayFragment.u0(PayFragment.this, dialogInterface, i, keyEvent);
                return u0;
            }
        });
        return onCreateDialog;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.h(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.tran_fragment_payment_layout, container, false);
        if (savedInstanceState == null) {
            LoadConfigContent loadConfigContent = this.configBean;
            if (k0(loadConfigContent != null ? loadConfigContent.getMedium() : null)) {
                com.tn.tranpay.report.h.a.l("main_tab_page");
                return inflate;
            }
            BillingParams billingParams = this.paymentParams;
            if (billingParams != null) {
                getChildFragmentManager().p().s(R.id.fragment_container, PayMainFragment.INSTANCE.a(billingParams, this.configBean)).i();
                b bVar = this.onDismissListener;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }
        return inflate;
    }

    public void onDismiss(DialogInterface dialog) {
        Intrinsics.h(dialog, "dialog");
        super.onDismiss(dialog);
        b bVar = this.onDismissListener;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void onStart() {
        super.onStart();
        w0();
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        BillingParams billingParams;
        Intrinsics.h(view, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null || (billingParams = (BillingParams) arguments.getParcelable("paymentParams")) == null) {
            return;
        }
        this.paymentParams = billingParams;
        Bundle arguments2 = getArguments();
        this.configBean = arguments2 != null ? (LoadConfigContent) arguments2.getParcelable("configBean") : null;
        PaymentViewModel m0 = m0();
        BillingParams billingParams2 = this.paymentParams;
        m0.N(billingParams2 != null ? billingParams2.getOrderId() : null);
        PaymentViewModel m02 = m0();
        BillingParams billingParams3 = this.paymentParams;
        m02.P(billingParams3 != null ? billingParams3.getTxnId() : null);
        if (m0().o() == null) {
            m0().K(this.mCallback);
        }
        this.loadingLayout = (FrameLayout) view.findViewById(R.id.loading_layout);
        ((ProgressBar) view.findViewById(R.id.loading_progress)).setIndeterminateTintList(ColorStateList.valueOf(com.tn.tranpay.e.c.b().d()));
        t0();
        s0();
        p0();
    }

    public final void v0(b bVar) {
        this.onDismissListener = bVar;
    }
}
