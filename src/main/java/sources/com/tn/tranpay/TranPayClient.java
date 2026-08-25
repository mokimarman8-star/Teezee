package com.tn.tranpay;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.cloud.tmc.kernel.bridge.RenderCallContext;
import com.tn.tranpay.activity.TranPayTransparentActivity;
import com.tn.tranpay.fragment.PayLoadingFragment;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class TranPayClient {
    public static final TranPayClient a = new TranPayClient();
    private static boolean b;

    private TranPayClient() {
    }

    public final void b(Context context, BillingParams billingParams, d dVar) {
        Intrinsics.h(context, "context");
        Intrinsics.h(billingParams, "params");
        Intrinsics.h(dVar, RenderCallContext.TYPE_CALLBACK);
        if (!TranPayConfiguration.a.q()) {
            lh.a.e(lh.a.a, "TranPay must be initialized!", null, 2, null);
            dVar.a(new b(-1, "TranPay must be initialized!"), null);
            return;
        }
        if (!com.tn.tranpay.helper.b.a.a()) {
            lh.a.e(lh.a.a, "Network is not available!", null, 2, null);
            dVar.a(new b(-2, "Network is not available. Please check your network connection."), null);
        } else {
            if (b) {
                return;
            }
            lh.a.g(lh.a.a, "launchBillingFlow with context and params is " + billingParams, null, 2, null);
            TranPayTransparentActivity.INSTANCE.a(context, billingParams, dVar);
        }
    }

    public final void c(AppCompatActivity appCompatActivity, BillingParams billingParams, d dVar) {
        Intrinsics.h(appCompatActivity, "activity");
        Intrinsics.h(billingParams, "params");
        Intrinsics.h(dVar, RenderCallContext.TYPE_CALLBACK);
        TranPayConfiguration tranPayConfiguration = TranPayConfiguration.a;
        if (!tranPayConfiguration.q()) {
            lh.a.e(lh.a.a, "TranPay must be initialized!", null, 2, null);
            dVar.a(new b(-1, "TranPay must be initialized!"), null);
            return;
        }
        if (!com.tn.tranpay.helper.b.a.a()) {
            lh.a.e(lh.a.a, "Network is not available!", null, 2, null);
            dVar.a(new b(-2, "Network is not available. Please check your network connection."), null);
            return;
        }
        if (b || appCompatActivity.isFinishing() || appCompatActivity.isDestroyed()) {
            return;
        }
        lh.a.g(lh.a.a, "launchBillingFlow and params is " + billingParams, null, 2, null);
        try {
            Result.Companion companion = Result.Companion;
            PayLoadingFragment a2 = PayLoadingFragment.INSTANCE.a(billingParams, dVar);
            a2.show(appCompatActivity.getSupportFragmentManager(), "pay_loading_fragment");
            b = true;
            a2.i0(new Function0<Unit>() { // from class: com.tn.tranpay.TranPayClient$launchBillingFlow$1$1
                public /* bridge */ /* synthetic */ Object invoke() {
                    m119invoke();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m119invoke() {
                    TranPayClient.b = false;
                }
            });
            tranPayConfiguration.D(billingParams);
            Result.constructor-impl(Unit.a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th));
        }
    }
}
