package com.transsion.payment.lib.dialog;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.m;
import androidx.lifecycle.v;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.baseui.dialog.BaseMemberLoadingDialog;
import com.transsion.gslb.BuildConfig;
import com.transsion.payment.lib.PaymentClientHelper;
import com.transsion.payment.lib.PaymentService;
import com.transsion.payment.lib.b;
import com.transsion.payment.lib.bean.CheckPaymentBean;
import com.transsion.payment.lib.bean.CreateOrderReq;
import com.transsion.payment.lib.bean.CreateOrderRes;
import com.transsion.wrapperad.R;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.i;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u001f\u0010\u000f\u001a\u00020\u00042\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0004H\u0016¢\u0006\u0004\b!\u0010\u0003J)\u0010'\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u001d2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u0015\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\u0015\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100R\u0018\u00103\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u001b\u0010?\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001b\u0010D\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010<\u001a\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010J¨\u0006N"}, d2 = {"Lcom/transsion/payment/lib/dialog/PaynicornDuringThePaymentDialog;", "Lcom/transsion/baseui/dialog/BaseMemberLoadingDialog;", "<init>", "()V", BuildConfig.FLAVOR, "O0", "Lcom/transsion/payment/lib/bean/CreateOrderRes;", "createOrderRes", "L0", "(Lcom/transsion/payment/lib/bean/CreateOrderRes;)V", "observe", "H0", "Lcom/tn/lib/net/bean/BaseDto;", "Lcom/transsion/payment/lib/bean/CheckPaymentBean;", "orderCheckResult", "J0", "(Lcom/tn/lib/net/bean/BaseDto;)V", BuildConfig.FLAVOR, "errorCode", BuildConfig.FLAVOR, "msg", "I0", "(ILjava/lang/String;)V", "P0", "(Ljava/lang/String;I)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroy", "viewBg", "Landroid/widget/ProgressBar;", "viewLoad", "Landroid/widget/TextView;", "tvLoading", "o0", "(Landroid/view/View;Landroid/widget/ProgressBar;Landroid/widget/TextView;)V", "Lcom/transsion/payment/lib/b;", "callback", "R0", "(Lcom/transsion/payment/lib/b;)V", "Lcom/transsion/payment/lib/bean/CreateOrderReq;", "orderRequest", "S0", "(Lcom/transsion/payment/lib/bean/CreateOrderReq;)V", "c", "Lcom/transsion/payment/lib/bean/CreateOrderRes;", "mCreateOrderRes", "d", "Lcom/transsion/payment/lib/bean/CreateOrderReq;", "mCreateOrderReq", "e", "Lcom/transsion/payment/lib/b;", "mCallback", "Lcom/transsion/payment/lib/PaymentService;", "f", "Lkotlin/Lazy;", "E0", "()Lcom/transsion/payment/lib/PaymentService;", "paymentService", "Lcom/transsion/payment/lib/dialog/a;", "g", "F0", "()Lcom/transsion/payment/lib/dialog/a;", "viewModel", "h", "I", "retryCount", BuildConfig.FLAVOR, "i", "J", "initialDelayMillis", "j", "currentDelay", "LibPayment_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PaynicornDuringThePaymentDialog extends BaseMemberLoadingDialog {

    /* renamed from: c, reason: from kotlin metadata */
    private CreateOrderRes mCreateOrderRes;

    /* renamed from: d, reason: from kotlin metadata */
    private CreateOrderReq mCreateOrderReq;

    /* renamed from: e, reason: from kotlin metadata */
    private com.transsion.payment.lib.b mCallback;

    /* renamed from: f, reason: from kotlin metadata */
    private final Lazy paymentService = LazyKt.b(new Function0() { // from class: com.transsion.payment.lib.dialog.b
        public final Object invoke() {
            PaymentService K0;
            K0 = PaynicornDuringThePaymentDialog.K0();
            return K0;
        }
    });

    /* renamed from: g, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: h, reason: from kotlin metadata */
    private int retryCount;

    /* renamed from: i, reason: from kotlin metadata */
    private long initialDelayMillis;

    /* renamed from: j, reason: from kotlin metadata */
    private long currentDelay;

    public PaynicornDuringThePaymentDialog() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.payment.lib.dialog.PaynicornDuringThePaymentDialog$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Fragment m67invoke() {
                return this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.a(this, Reflection.b(a.class), new Function0<x0>() { // from class: com.transsion.payment.lib.dialog.PaynicornDuringThePaymentDialog$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final x0 m68invoke() {
                x0 viewModelStore = ((y0) function0.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.payment.lib.dialog.PaynicornDuringThePaymentDialog$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final v0.c m69invoke() {
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
        this.initialDelayMillis = 3000L;
        this.currentDelay = 3000L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PaymentService E0() {
        return (PaymentService) this.paymentService.getValue();
    }

    private final a F0() {
        return (a) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(PaynicornDuringThePaymentDialog paynicornDuringThePaymentDialog, hx.e eVar) {
        Intrinsics.h(eVar, "it");
        if (eVar.a() < 0) {
            paynicornDuringThePaymentDialog.I0(com.transsion.moviedetail.adapter.c.H, "observe() --> 取消支付");
            return Unit.a;
        }
        com.transsion.payment.lib.d.a.a(paynicornDuringThePaymentDialog.getClassTag() + " --> observe() --> paynicorn result --> 轮询Paynicorn支付结果 ....");
        paynicornDuringThePaymentDialog.H0();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H0() {
        i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new PaynicornDuringThePaymentDialog$orderCheck4Paynicorn$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I0(int errorCode, String msg) {
        com.transsion.payment.lib.d.a.b(getClassTag() + " --> payFail() --> msg = " + msg);
        com.transsion.payment.lib.b b = F0().b();
        if (b != null) {
            b.a.a(b, Integer.valueOf(errorCode), getClassTag() + " --> payFail() --> msg = " + msg, false, null, 8, null);
        }
        if (isAdded()) {
            dismissAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J0(BaseDto orderCheckResult) {
        String str;
        String addCoin;
        com.transsion.payment.lib.d.a.a(getClassTag() + " --> orderCheck4Paynicorn() --> paynicorn 发货成功");
        com.transsion.payment.lib.b b = F0().b();
        if (b != null) {
            CheckPaymentBean checkPaymentBean = (CheckPaymentBean) orderCheckResult.getData();
            int parseInt = (checkPaymentBean == null || (addCoin = checkPaymentBean.getAddCoin()) == null) ? 0 : Integer.parseInt(addCoin);
            CheckPaymentBean checkPaymentBean2 = (CheckPaymentBean) orderCheckResult.getData();
            if (checkPaymentBean2 == null || (str = checkPaymentBean2.getBalanceCoin()) == null) {
                str = BuildConfig.FLAVOR;
            }
            CreateOrderRes createOrderRes = this.mCreateOrderRes;
            b.c(parseInt, str, createOrderRes != null ? createOrderRes.getTradingOrderId() : null);
        }
        if (isAdded()) {
            dismissAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PaymentService K0() {
        return new PaymentService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L0(CreateOrderRes createOrderRes) {
        com.transsion.payment.lib.d.a.a(getClassTag() + " --> requestPay() --> 请求到数据 --> realPay() --> 打开端内WebView --> 展示收银台");
        this.mCreateOrderRes = createOrderRes;
        PaymentClientHelper paymentClientHelper = PaymentClientHelper.a;
        FragmentActivity activity = getActivity();
        paymentClientHelper.e(activity instanceof AppCompatActivity ? (AppCompatActivity) activity : null, createOrderRes, new Function2() { // from class: com.transsion.payment.lib.dialog.d
            public final Object invoke(Object obj, Object obj2) {
                Unit M0;
                M0 = PaynicornDuringThePaymentDialog.M0(PaynicornDuringThePaymentDialog.this, ((Integer) obj).intValue(), (String) obj2);
                return M0;
            }
        }, new Function0() { // from class: com.transsion.payment.lib.dialog.e
            public final Object invoke() {
                Unit N0;
                N0 = PaynicornDuringThePaymentDialog.N0(PaynicornDuringThePaymentDialog.this);
                return N0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(PaynicornDuringThePaymentDialog paynicornDuringThePaymentDialog, int i, String str) {
        Intrinsics.h(str, "msg");
        paynicornDuringThePaymentDialog.I0(i, str);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0(PaynicornDuringThePaymentDialog paynicornDuringThePaymentDialog) {
        paynicornDuringThePaymentDialog.H0();
        return Unit.a;
    }

    private final void O0() {
        com.transsion.payment.lib.d.a.a(getClassTag() + " --> requestPay() --> 请求接口创建订单....");
        i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new PaynicornDuringThePaymentDialog$requestPay$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P0(String msg, int errorCode) {
        int i = this.retryCount;
        if (i >= 3) {
            I0(errorCode, msg);
            return;
        }
        this.retryCount = i + 1;
        com.transsion.payment.lib.d.a.a(getClassTag() + " --> retry() --> msg = " + msg + " --> retryCount = " + this.retryCount);
        i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new PaynicornDuringThePaymentDialog$retry$1(this, SystemClock.elapsedRealtime(), null), 3, (Object) null);
    }

    static /* synthetic */ void Q0(PaynicornDuringThePaymentDialog paynicornDuringThePaymentDialog, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 1007;
        }
        paynicornDuringThePaymentDialog.P0(str, i);
    }

    private final void observe() {
        Lifecycle.State state = Lifecycle.State.CREATED;
        Function1 function1 = new Function1() { // from class: com.transsion.payment.lib.dialog.c
            public final Object invoke(Object obj) {
                Unit G0;
                G0 = PaynicornDuringThePaymentDialog.G0(PaynicornDuringThePaymentDialog.this, (hx.e) obj);
                return G0;
            }
        };
        a2 p = kotlinx.coroutines.y0.c().p();
        FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = hx.e.class.getName();
        Intrinsics.g(name, "getName(...)");
        applicationScopeViewModel.observeEvent(this, name, state, p, false, function1);
    }

    public final void R0(com.transsion.payment.lib.b callback) {
        Intrinsics.h(callback, "callback");
        this.mCallback = callback;
    }

    public final void S0(CreateOrderReq orderRequest) {
        Intrinsics.h(orderRequest, "orderRequest");
        this.mCreateOrderReq = orderRequest;
    }

    @Override // com.transsion.baseui.dialog.BaseMemberLoadingDialog
    public void o0(View viewBg, ProgressBar viewLoad, TextView tvLoading) {
        Intrinsics.h(viewLoad, "viewLoad");
        Intrinsics.h(tvLoading, "tvLoading");
        super.o0(viewBg, viewLoad, tvLoading);
        if (viewBg != null) {
            viewBg.setBackgroundResource(R.drawable.ad_shape_dp_8);
        }
        tvLoading.setTextColor(getResources().getColor(com.tn.lib.widget.R.color.color_d6101114));
        viewLoad.setIndeterminateTintList(ColorStateList.valueOf(getResources().getColor(com.tn.lib.widget.R.color.base_color_999999)));
    }

    @Override // com.transsion.baseui.dialog.BaseMemberLoadingDialog
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.transsion.payment.lib.d.a.a(getClassTag() + " --> onCreate()");
    }

    @Override // com.transsion.baseui.dialog.BaseDialog
    public void onDestroy() {
        super.onDestroy();
        this.mCallback = null;
        this.mCreateOrderReq = null;
    }

    @Override // com.transsion.baseui.dialog.BaseMemberLoadingDialog
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (F0().b() == null) {
            F0().c(this.mCallback);
        }
        observe();
        O0();
    }
}
