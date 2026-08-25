package com.transsion.shorttv.order;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.c0;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.order.bean.CenterCreateTradingOrderRespEntity;
import com.transsion.shorttv.order.bean.CreatePaynicornOrderReqBean;
import com.transsion.shorttv.order.bean.GetPaynicornOrderStatusRespEntity;
import com.transsion.shorttv.order.bean.HttpErrorBodyBean;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u0019\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/transsion/shorttv/order/PurchaseDialog;", "Lcom/transsion/shorttv/order/BasePayLoadingDialog;", "<init>", "()V", "Lcom/transsion/shorttv/order/bean/HttpErrorBodyBean;", "it", BuildConfig.FLAVOR, "D0", "(Lcom/transsion/shorttv/order/bean/HttpErrorBodyBean;)V", "x0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/transsion/shorttv/order/bean/CreatePaynicornOrderReqBean;", "orderReq", "F0", "(Lcom/transsion/shorttv/order/bean/CreatePaynicornOrderReqBean;)Lcom/transsion/shorttv/order/PurchaseDialog;", "d", "Lcom/transsion/shorttv/order/bean/CreatePaynicornOrderReqBean;", "Lcom/transsion/shorttv/order/PayLoadingVM;", "e", "Lkotlin/Lazy;", "w0", "()Lcom/transsion/shorttv/order/PayLoadingVM;", "payVM", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PurchaseDialog extends BasePayLoadingDialog {

    /* renamed from: d, reason: from kotlin metadata */
    private CreatePaynicornOrderReqBean orderReq;

    /* renamed from: e, reason: from kotlin metadata */
    private final Lazy payVM = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.order.l
        public final Object invoke() {
            PayLoadingVM E0;
            E0 = PurchaseDialog.E0();
            return E0;
        }
    });

    static final class a implements c0, FunctionAdapter {
        private final /* synthetic */ Function1 a;

        a(Function1 function1) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(PurchaseDialog purchaseDialog, int i, String str) {
        Intrinsics.h(str, "msg");
        purchaseDialog.D0(new HttpErrorBodyBean(str, String.valueOf(i), null, 4, null));
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(PurchaseDialog purchaseDialog, CenterCreateTradingOrderRespEntity centerCreateTradingOrderRespEntity) {
        PayLoadingVM w0 = purchaseDialog.w0();
        String tradingOrderId = centerCreateTradingOrderRespEntity != null ? centerCreateTradingOrderRespEntity.getTradingOrderId() : null;
        CreatePaynicornOrderReqBean createPaynicornOrderReqBean = purchaseDialog.orderReq;
        String projectName = createPaynicornOrderReqBean != null ? createPaynicornOrderReqBean.getProjectName() : null;
        CreatePaynicornOrderReqBean createPaynicornOrderReqBean2 = purchaseDialog.orderReq;
        w0.i(tradingOrderId, projectName, createPaynicornOrderReqBean2 != null ? createPaynicornOrderReqBean2.isDebug() : false);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(PurchaseDialog purchaseDialog, GetPaynicornOrderStatusRespEntity getPaynicornOrderStatusRespEntity) {
        b callback = purchaseDialog.getCallback();
        if (callback != null) {
            callback.b(getPaynicornOrderStatusRespEntity);
        }
        if (purchaseDialog.isAdded()) {
            purchaseDialog.dismissAllowingStateLoss();
        }
        return Unit.a;
    }

    private final void D0(HttpErrorBodyBean it) {
        c.a.a(getClassTag() + " --> initVM() --> code = " + it.getCode() + " -- message = " + it.getMessage());
        b callback = getCallback();
        if (callback != null) {
            callback.a(it.getCode(), it.getMessage());
        }
        if (isAdded()) {
            dismissAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PayLoadingVM E0() {
        return new PayLoadingVM();
    }

    private final PayLoadingVM w0() {
        return (PayLoadingVM) this.payVM.getValue();
    }

    private final void x0() {
        w0().n().j(this, new a(new Function1() { // from class: com.transsion.shorttv.order.i
            public final Object invoke(Object obj) {
                Unit y0;
                y0 = PurchaseDialog.y0(PurchaseDialog.this, (HttpErrorBodyBean) obj);
                return y0;
            }
        }));
        w0().l().j(this, new a(new Function1() { // from class: com.transsion.shorttv.order.j
            public final Object invoke(Object obj) {
                Unit z0;
                z0 = PurchaseDialog.z0(PurchaseDialog.this, (CenterCreateTradingOrderRespEntity) obj);
                return z0;
            }
        }));
        w0().m().j(this, new a(new Function1() { // from class: com.transsion.shorttv.order.k
            public final Object invoke(Object obj) {
                Unit C0;
                C0 = PurchaseDialog.C0(PurchaseDialog.this, (GetPaynicornOrderStatusRespEntity) obj);
                return C0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(PurchaseDialog purchaseDialog, HttpErrorBodyBean httpErrorBodyBean) {
        Intrinsics.e(httpErrorBodyBean);
        purchaseDialog.D0(httpErrorBodyBean);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(final PurchaseDialog purchaseDialog, final CenterCreateTradingOrderRespEntity centerCreateTradingOrderRespEntity) {
        c.a.a(purchaseDialog.getClassTag() + " --> initVM() --> 创建支付订单成功 --> tradingOrderId = " + (centerCreateTradingOrderRespEntity != null ? centerCreateTradingOrderRespEntity.getTradingOrderId() : null));
        d.a.c(purchaseDialog.getContext(), centerCreateTradingOrderRespEntity, new Function2() { // from class: com.transsion.shorttv.order.m
            public final Object invoke(Object obj, Object obj2) {
                Unit A0;
                A0 = PurchaseDialog.A0(PurchaseDialog.this, ((Integer) obj).intValue(), (String) obj2);
                return A0;
            }
        }, new Function0() { // from class: com.transsion.shorttv.order.n
            public final Object invoke() {
                Unit B0;
                B0 = PurchaseDialog.B0(PurchaseDialog.this, centerCreateTradingOrderRespEntity);
                return B0;
            }
        });
        return Unit.a;
    }

    public final PurchaseDialog F0(CreatePaynicornOrderReqBean orderReq) {
        this.orderReq = orderReq;
        return this;
    }

    @Override // com.transsion.shorttv.order.BasePayLoadingDialog
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x0();
    }

    @Override // com.transsion.shorttv.order.BasePayLoadingDialog
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.onViewCreated(view, savedInstanceState);
        n0(true);
        w0().j(this.orderReq);
    }
}
