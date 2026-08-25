package com.transsion.shorttv.order;

import android.os.SystemClock;
import androidx.lifecycle.b0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.transsion.shorttv.order.bean.CreatePaynicornOrderReqBean;
import com.transsion.shorttv.order.bean.HttpErrorBodyBean;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PayLoadingVM extends t0 {
    private int a;
    private long b = 3000;
    private long c = 3000;
    private final b0 d = new b0();
    private final b0 e = new b0();
    private final b0 f = new b0();

    private final String k() {
        String simpleName = PayLoadingVM.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(String str, String str2, String str3, String str4, boolean z) {
        int i = this.a;
        if (i >= 3) {
            this.f.n(new HttpErrorBodyBean(str2, str, null, 4, null));
            return;
        }
        this.a = i + 1;
        c.a.a(k() + " --> retry() --> code = " + str + " -- msg = " + str2 + " --> retryCount = " + this.a);
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new PayLoadingVM$retry$1(this, SystemClock.elapsedRealtime(), str3, str4, z, null), 3, (Object) null);
    }

    public final void i(String str, String str2, boolean z) {
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new PayLoadingVM$checkPayOrderId$1(str, str2, z, this, null), 3, (Object) null);
    }

    public final void j(CreatePaynicornOrderReqBean createPaynicornOrderReqBean) {
        kotlinx.coroutines.i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new PayLoadingVM$createPayOrderId$1(createPaynicornOrderReqBean, this, null), 3, (Object) null);
    }

    public final b0 l() {
        return this.d;
    }

    public final b0 m() {
        return this.e;
    }

    public final b0 n() {
        return this.f;
    }
}
