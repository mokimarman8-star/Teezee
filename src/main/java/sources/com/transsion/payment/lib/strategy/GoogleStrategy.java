package com.transsion.payment.lib.strategy;

import android.app.Activity;
import android.app.Application;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.b0;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.j;
import com.android.billingclient.api.m;
import com.android.billingclient.api.n;
import com.android.billingclient.api.r;
import com.android.billingclient.api.s;
import com.android.billingclient.api.u;
import com.android.billingclient.api.v;
import com.android.billingclient.api.w;
import com.android.billingclient.api.x;
import com.blankj.utilcode.util.Utils;
import com.transsion.gslb.BuildConfig;
import com.transsion.payment.lib.PayUtils;
import com.transsion.payment.lib.PaymentService;
import com.transsion.payment.lib.b;
import com.transsion.payment.lib.bean.CreateOrderReq;
import com.transsion.payment.lib.strategy.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.u0;
import kotlinx.coroutines.y0;
import retrofit2.HttpException;
import retrofit2.j0;
import yg.k;
import yg.m;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class GoogleStrategy implements g, m {
    private final b0 a = new b0();
    private final HashSet b;
    private final HashSet c;
    private final int d;
    private int e;
    private int f;
    private boolean g;
    private boolean h;
    private n0 i;
    private com.transsion.payment.lib.b j;
    private final v k;
    private final com.android.billingclient.api.h l;
    private final Lazy m;
    private long n;

    public GoogleStrategy() {
        HashSet hashSet = new HashSet();
        this.b = hashSet;
        HashSet hashSet2 = new HashSet();
        this.c = hashSet2;
        k.g.a().D(this);
        hashSet.add(3);
        hashSet.add(5);
        hashSet.add(-2);
        hashSet.add(7);
        hashSet2.add(4);
        hashSet2.add(-3);
        hashSet2.add(6);
        hashSet2.add(-1);
        hashSet2.add(2);
        hashSet2.add(12);
        this.d = 3;
        this.f = 2000;
        this.i = o0.a(y0.b());
        v vVar = new v() { // from class: com.transsion.payment.lib.strategy.a
            public final void a(n nVar, List list) {
                GoogleStrategy.F(GoogleStrategy.this, nVar, list);
            }
        };
        this.k = vVar;
        com.android.billingclient.api.h a = com.android.billingclient.api.h.c(Utils.a()).c(vVar).b().a();
        Intrinsics.g(a, "build(...)");
        this.l = a;
        this.m = LazyKt.b(new Function0() { // from class: com.transsion.payment.lib.strategy.b
            public final Object invoke() {
                PaymentService E;
                E = GoogleStrategy.E();
                return E;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(14:0|1|(2:3|(10:5|6|7|8|(1:(4:11|12|13|14)(2:49|50))(8:51|52|(1:54)(1:96)|(1:95)(1:58)|(1:94)(1:62)|(1:64)(1:93)|65|(3:86|(2:(1:89)(1:91)|90)|92)(7:74|75|76|77|78|79|(1:81)))|15|16|(3:18|(2:20|(5:22|(1:24)(1:30)|25|(1:27)(1:29)|28))(2:32|(1:34))|31)|35|36))|101|6|7|8|(0)(0)|15|16|(0)|35|36|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x003c, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x00f4, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0138, code lost:
    
        r1 = kotlin.Result.Companion;
        r0 = kotlin.Result.constructor-impl(kotlin.ResultKt.a(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x003b, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00fa A[Catch: all -> 0x00f4, TryCatch #2 {all -> 0x00f4, blocks: (B:15:0x0131, B:42:0x00f6, B:44:0x00fa, B:45:0x00fd, B:47:0x0101, B:48:0x0108, B:79:0x00ed, B:86:0x0112, B:89:0x0122, B:90:0x012c, B:92:0x012f), top: B:8:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0101 A[Catch: all -> 0x00f4, TryCatch #2 {all -> 0x00f4, blocks: (B:15:0x0131, B:42:0x00f6, B:44:0x00fa, B:45:0x00fd, B:47:0x0101, B:48:0x0108, B:79:0x00ed, B:86:0x0112, B:89:0x0122, B:90:0x012c, B:92:0x012f), top: B:8:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object B(Purchase purchase, Continuation continuation) {
        GoogleStrategy$handlePurchase$1 googleStrategy$handlePurchase$1;
        int i;
        com.transsion.payment.lib.b bVar;
        HttpException httpException;
        String a;
        PayUtils payUtils;
        GoogleStrategy$handlePurchase$2$1 googleStrategy$handlePurchase$2$1;
        boolean z;
        String str;
        com.android.billingclient.api.a a2;
        List d;
        com.transsion.payment.lib.b bVar2;
        com.transsion.payment.lib.b bVar3;
        if (continuation instanceof GoogleStrategy$handlePurchase$1) {
            googleStrategy$handlePurchase$1 = (GoogleStrategy$handlePurchase$1) continuation;
            int i2 = googleStrategy$handlePurchase$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                googleStrategy$handlePurchase$1.label = i2 - Integer.MIN_VALUE;
                GoogleStrategy$handlePurchase$1 googleStrategy$handlePurchase$12 = googleStrategy$handlePurchase$1;
                Object obj = googleStrategy$handlePurchase$12.result;
                Object f = IntrinsicsKt.f();
                i = googleStrategy$handlePurchase$12.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    Result.Companion companion = Result.Companion;
                    String g = purchase != null ? purchase.g() : null;
                    String str2 = (purchase == null || (d = purchase.d()) == null) ? null : (String) d.get(0);
                    a = (purchase == null || (a2 = purchase.a()) == null) ? null : a2.a();
                    String b = purchase != null ? purchase.b() : null;
                    if (TextUtils.isEmpty(g) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(a) || purchase == null || purchase.e() != 1) {
                        bVar = null;
                        com.transsion.payment.lib.d.a.b("handlePurchase 失败");
                        com.transsion.payment.lib.b bVar4 = this.j;
                        if (bVar4 != null) {
                            bVar4.a(purchase != null ? Boxing.d(purchase.e()) : null, BuildConfig.FLAVOR, false, a);
                        }
                        this.j = null;
                    } else {
                        com.transsion.payment.lib.d.a.a("handlePurchase 支付结果 orderId:" + a + " purchaseToken " + g + " productId " + str2 + " gpOrderId " + b);
                        try {
                            payUtils = PayUtils.a;
                            googleStrategy$handlePurchase$2$1 = new GoogleStrategy$handlePurchase$2$1(this, str2, g, a, b, null);
                            googleStrategy$handlePurchase$12.L$0 = a;
                            googleStrategy$handlePurchase$12.label = 1;
                            bVar = null;
                            z = false;
                            str = BuildConfig.FLAVOR;
                        } catch (Exception unused) {
                            bVar = null;
                            z = false;
                            str = BuildConfig.FLAVOR;
                            bVar2 = this.j;
                            if (bVar2 != null) {
                                bVar2.b(z);
                            }
                            bVar3 = this.j;
                            if (bVar3 != null) {
                                bVar3.a(Boxing.d(-30), str, z, a);
                            }
                            this.j = bVar;
                            com.transsion.payment.lib.d.a.b("handlePurchase 发货进行中ing");
                            Object obj2 = Result.constructor-impl(Unit.a);
                            httpException = Result.exceptionOrNull-impl(obj2);
                            if (httpException != null) {
                            }
                            return Unit.a;
                        }
                        try {
                            if (PayUtils.b(payUtils, 0L, 0, googleStrategy$handlePurchase$2$1, googleStrategy$handlePurchase$12, 3, null) == f) {
                                return f;
                            }
                        } catch (Exception unused2) {
                            bVar2 = this.j;
                            if (bVar2 != null) {
                            }
                            bVar3 = this.j;
                            if (bVar3 != null) {
                            }
                            this.j = bVar;
                            com.transsion.payment.lib.d.a.b("handlePurchase 发货进行中ing");
                            Object obj22 = Result.constructor-impl(Unit.a);
                            httpException = Result.exceptionOrNull-impl(obj22);
                            if (httpException != null) {
                            }
                            return Unit.a;
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    String str3 = (String) googleStrategy$handlePurchase$12.L$0;
                    try {
                        ResultKt.b(obj);
                        bVar = null;
                    } catch (Exception unused3) {
                        a = str3;
                        bVar = null;
                        z = false;
                        str = BuildConfig.FLAVOR;
                        bVar2 = this.j;
                        if (bVar2 != null) {
                        }
                        bVar3 = this.j;
                        if (bVar3 != null) {
                        }
                        this.j = bVar;
                        com.transsion.payment.lib.d.a.b("handlePurchase 发货进行中ing");
                        Object obj222 = Result.constructor-impl(Unit.a);
                        httpException = Result.exceptionOrNull-impl(obj222);
                        if (httpException != null) {
                        }
                        return Unit.a;
                    }
                }
                Object obj2222 = Result.constructor-impl(Unit.a);
                httpException = Result.exceptionOrNull-impl(obj2222);
                if (httpException != null) {
                    if (httpException instanceof HttpException) {
                        com.transsion.payment.lib.b bVar5 = this.j;
                        if (bVar5 != null) {
                            HttpException httpException2 = httpException;
                            j0 response = httpException2.response();
                            Integer d2 = response != null ? Boxing.d(response.b()) : bVar;
                            j0 response2 = httpException2.response();
                            b.a.a(bVar5, d2, response2 != null ? response2.f() : bVar, false, null, 8, null);
                        }
                    } else {
                        com.transsion.payment.lib.b bVar6 = this.j;
                        if (bVar6 != null) {
                            b.a.a(bVar6, Boxing.d(-30), httpException.getMessage(), false, null, 8, null);
                        }
                    }
                    com.transsion.payment.lib.d.a.b("throwable " + httpException);
                    this.j = bVar;
                }
                return Unit.a;
            }
        }
        googleStrategy$handlePurchase$1 = new GoogleStrategy$handlePurchase$1(this, continuation);
        GoogleStrategy$handlePurchase$1 googleStrategy$handlePurchase$122 = googleStrategy$handlePurchase$1;
        Object obj3 = googleStrategy$handlePurchase$122.result;
        Object f2 = IntrinsicsKt.f();
        i = googleStrategy$handlePurchase$122.label;
        if (i != 0) {
        }
        Object obj22222 = Result.constructor-impl(Unit.a);
        httpException = Result.exceptionOrNull-impl(obj22222);
        if (httpException != null) {
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(GoogleStrategy googleStrategy, n nVar, List list) {
        Intrinsics.h(nVar, "billingResult");
        Intrinsics.h(list, "purchaseList");
        i.d(googleStrategy.i, (CoroutineContext) null, (CoroutineStart) null, new GoogleStrategy$orderCheck$1$1(list, googleStrategy, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PaymentService E() {
        return new PaymentService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(GoogleStrategy googleStrategy, n nVar, List list) {
        Intrinsics.h(nVar, "billingResult");
        com.transsion.payment.lib.d dVar = com.transsion.payment.lib.d.a;
        dVar.a("PurchasesUpdatedListener responseCode:" + nVar.b() + " " + (list != null ? Integer.valueOf(list.size()) : null));
        StringBuilder sb = new StringBuilder();
        sb.append("purchases: ");
        sb.append(list);
        dVar.a(sb.toString());
        if (nVar.b() == 0 && list != null) {
            googleStrategy.e = 0;
            com.transsion.payment.lib.b bVar = googleStrategy.j;
            if (bVar != null) {
                bVar.b(true);
            }
            i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new GoogleStrategy$purchasesUpdatedListener$1$1(list, googleStrategy, null), 3, (Object) null);
            return;
        }
        if (nVar.b() != 1) {
            com.transsion.payment.lib.b bVar2 = googleStrategy.j;
            if (bVar2 != null) {
                b.a.a(bVar2, Integer.valueOf(nVar.b()), nVar.a(), false, null, 8, null);
            }
            googleStrategy.j = null;
            return;
        }
        dVar.a("PurchasesUpdatedListener USER_CANCELED");
        com.transsion.payment.lib.b bVar3 = googleStrategy.j;
        if (bVar3 != null) {
            b.a.a(bVar3, 1, "User Cancelled", false, null, 8, null);
        }
        googleStrategy.j = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(final Activity activity, String str, final String str2, final boolean z, final com.transsion.payment.lib.b bVar) {
        w.b a = w.b.a().b(str).c(z ? "subs" : "inapp").a();
        Intrinsics.g(a, "build(...)");
        w a2 = w.a().b(CollectionsKt.q(new w.b[]{a})).a();
        Intrinsics.g(a2, "build(...)");
        this.l.d(a2, new s() { // from class: com.transsion.payment.lib.strategy.f
            public final void a(n nVar, List list) {
                GoogleStrategy.H(z, str2, this, bVar, activity, nVar, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(boolean z, String str, GoogleStrategy googleStrategy, com.transsion.payment.lib.b bVar, Activity activity, n nVar, List list) {
        String str2;
        r.d dVar;
        Intrinsics.h(nVar, "billingResult");
        Intrinsics.h(list, "productDetailsList");
        com.transsion.payment.lib.d dVar2 = com.transsion.payment.lib.d.a;
        dVar2.a("queryProductDetailsAsync resultCode: " + nVar.b() + " result size: " + list.size());
        if (list.size() <= 0) {
            bVar.a(Integer.valueOf(nVar.b()), nVar.a(), false, str);
            dVar2.b("queryProductDetailsAsync failed list: " + list + ", code: " + nVar.b() + ", message: " + nVar.a());
            return;
        }
        r rVar = (r) list.get(0);
        if (rVar == null) {
            dVar2.b("billingFlowParams productDetail null");
            bVar.a(Integer.valueOf(nVar.b()), nVar.a(), false, str);
            return;
        }
        ArrayList arrayList = new ArrayList();
        dVar2.a("productDetail is " + rVar);
        m.b.a c = m.b.a().c(rVar);
        Intrinsics.g(c, "setProductDetails(...)");
        if (z) {
            List d = rVar.d();
            if (d == null || (dVar = (r.d) CollectionsKt.i0(d)) == null || (str2 = dVar.a()) == null) {
                str2 = BuildConfig.FLAVOR;
            }
            c.b(str2);
        }
        m.b a = c.a();
        Intrinsics.g(a, "build(...)");
        arrayList.add(a);
        com.android.billingclient.api.m a2 = com.android.billingclient.api.m.a().c(arrayList).b(str).a();
        Intrinsics.g(a2, "build(...)");
        googleStrategy.j = bVar;
        dVar2.a("Launch billing flow");
        googleStrategy.l.b(activity, a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(GoogleStrategy googleStrategy, AppCompatActivity appCompatActivity, CreateOrderReq createOrderReq, boolean z, com.transsion.payment.lib.b bVar) {
        googleStrategy.a(appCompatActivity, createOrderReq, z, bVar);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0071 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x006f -> B:17:0x0044). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object J(long j, Function1 function1, Continuation continuation) {
        GoogleStrategy$retryCheck$1 googleStrategy$retryCheck$1;
        int i;
        int i2;
        if (continuation instanceof GoogleStrategy$retryCheck$1) {
            googleStrategy$retryCheck$1 = (GoogleStrategy$retryCheck$1) continuation;
            int i3 = googleStrategy$retryCheck$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                googleStrategy$retryCheck$1.label = i3 - Integer.MIN_VALUE;
                Object obj = googleStrategy$retryCheck$1.result;
                Object f = IntrinsicsKt.f();
                i = googleStrategy$retryCheck$1.label;
                if (i != 0) {
                    if (i == 1) {
                        j = googleStrategy$retryCheck$1.J$0;
                        function1 = (Function1) googleStrategy$retryCheck$1.L$0;
                        ResultKt.b(obj);
                        googleStrategy$retryCheck$1.L$0 = function1;
                        googleStrategy$retryCheck$1.J$0 = j;
                        googleStrategy$retryCheck$1.label = 2;
                        if (function1.invoke(googleStrategy$retryCheck$1) == f) {
                            return f;
                        }
                        i2 = this.e;
                        this.e = i2 + 1;
                        if (i2 < this.d || this.h) {
                            return Unit.a;
                        }
                        if (j > 0) {
                            googleStrategy$retryCheck$1.L$0 = function1;
                            googleStrategy$retryCheck$1.J$0 = j;
                            googleStrategy$retryCheck$1.label = 1;
                            if (u0.a(j, googleStrategy$retryCheck$1) == f) {
                                return f;
                            }
                        }
                        googleStrategy$retryCheck$1.L$0 = function1;
                        googleStrategy$retryCheck$1.J$0 = j;
                        googleStrategy$retryCheck$1.label = 2;
                        if (function1.invoke(googleStrategy$retryCheck$1) == f) {
                        }
                        i2 = this.e;
                        this.e = i2 + 1;
                        if (i2 < this.d) {
                        }
                        return Unit.a;
                    }
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j = googleStrategy$retryCheck$1.J$0;
                    function1 = (Function1) googleStrategy$retryCheck$1.L$0;
                }
                ResultKt.b(obj);
                i2 = this.e;
                this.e = i2 + 1;
                if (i2 < this.d) {
                }
                return Unit.a;
            }
        }
        googleStrategy$retryCheck$1 = new GoogleStrategy$retryCheck$1(this, continuation);
        Object obj2 = googleStrategy$retryCheck$1.result;
        Object f2 = IntrinsicsKt.f();
        i = googleStrategy$retryCheck$1.label;
        if (i != 0) {
        }
        ResultKt.b(obj2);
        i2 = this.e;
        this.e = i2 + 1;
        if (i2 < this.d) {
        }
        return Unit.a;
    }

    private final void K() {
        com.android.billingclient.api.h hVar = this.l;
        if (hVar == null || hVar.a()) {
            return;
        }
        g.a.b(this, null, null, new Function0() { // from class: com.transsion.payment.lib.strategy.c
            public final Object invoke() {
                Unit L;
                L = GoogleStrategy.L(GoogleStrategy.this);
                return L;
            }
        }, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(GoogleStrategy googleStrategy) {
        List list;
        if (googleStrategy.a.f() == null || ((list = (List) googleStrategy.a.f()) != null && list.isEmpty())) {
            googleStrategy.w();
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PaymentService z() {
        return (PaymentService) this.m.getValue();
    }

    public final long A() {
        return this.n;
    }

    public void C() {
        x.a b = x.a().b("inapp");
        Intrinsics.g(b, "setProductType(...)");
        this.l.e(b.a(), new u() { // from class: com.transsion.payment.lib.strategy.e
            public final void a(n nVar, List list) {
                GoogleStrategy.D(GoogleStrategy.this, nVar, list);
            }
        });
    }

    @Override // com.transsion.payment.lib.strategy.g
    public void a(final AppCompatActivity appCompatActivity, final CreateOrderReq createOrderReq, final boolean z, final com.transsion.payment.lib.b bVar) {
        Object obj;
        Intrinsics.h(appCompatActivity, "activity");
        Intrinsics.h(createOrderReq, "createOrderReq");
        Intrinsics.h(bVar, "payCallback");
        com.transsion.payment.lib.d.a.a(x() + " --> requestPay() --> 请求接口创建订单....");
        bVar.b(true);
        try {
            Result.Companion companion = Result.Companion;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        if (!this.l.a()) {
            b(Boolean.FALSE, bVar, new Function0() { // from class: com.transsion.payment.lib.strategy.d
                public final Object invoke() {
                    Unit I;
                    I = GoogleStrategy.I(GoogleStrategy.this, appCompatActivity, createOrderReq, z, bVar);
                    return I;
                }
            });
            return;
        }
        obj = Result.constructor-impl(i.d(this.i, (CoroutineContext) null, (CoroutineStart) null, new GoogleStrategy$requestPay$1$2(this, createOrderReq, appCompatActivity, z, bVar, null), 3, (Object) null));
        HttpException httpException = Result.exceptionOrNull-impl(obj);
        if (httpException == null) {
            return;
        }
        if (!(httpException instanceof HttpException)) {
            b.a.a(bVar, -10, httpException.getMessage(), false, null, 8, null);
            return;
        }
        HttpException httpException2 = httpException;
        j0 response = httpException2.response();
        Integer valueOf = response != null ? Integer.valueOf(response.b()) : null;
        j0 response2 = httpException2.response();
        b.a.a(bVar, valueOf, response2 != null ? response2.f() : null, false, null, 8, null);
    }

    @Override // com.transsion.payment.lib.strategy.g
    public void b(final Boolean bool, final com.transsion.payment.lib.b bVar, final Function0 function0) {
        if (this.g) {
            return;
        }
        this.g = true;
        com.transsion.payment.lib.d.a.a("startBillingConnection start");
        this.n = SystemClock.elapsedRealtime();
        this.l.f(new j() { // from class: com.transsion.payment.lib.strategy.GoogleStrategy$startConnectPlatform$1
            public void a(n nVar) {
                int i;
                int i2;
                int i3;
                n0 n0Var;
                Intrinsics.h(nVar, "billingResult");
                GoogleStrategy.this.g = false;
                GoogleStrategy.this.h = true;
                GoogleStrategy.this.e = 0;
                if (nVar.b() == 0) {
                    com.transsion.payment.lib.d.a.a("content Billing response OK");
                    GoogleStrategy.this.w();
                    Function0 function02 = function0;
                    if (function02 != null) {
                        function02.invoke();
                    }
                    GoogleStrategy.this.C();
                    return;
                }
                if (!GoogleStrategy.this.y().contains(Integer.valueOf(nVar.b()))) {
                    com.transsion.payment.lib.b bVar2 = bVar;
                    if (bVar2 != null) {
                        b.a.a(bVar2, Integer.valueOf(nVar.b()), nVar.a(), false, null, 8, null);
                        return;
                    }
                    return;
                }
                com.transsion.payment.lib.d.a.c("connect error code " + nVar.b() + " msg " + nVar.a());
                i = GoogleStrategy.this.f;
                long elapsedRealtime = ((long) i) - (SystemClock.elapsedRealtime() - GoogleStrategy.this.A());
                if (!Intrinsics.c(bool, Boolean.TRUE)) {
                    com.transsion.payment.lib.b bVar3 = bVar;
                    if (bVar3 != null) {
                        b.a.a(bVar3, Integer.valueOf(nVar.b()), nVar.a(), false, null, 8, null);
                        return;
                    }
                    return;
                }
                i2 = GoogleStrategy.this.e;
                i3 = GoogleStrategy.this.d;
                if (i2 <= i3) {
                    n0Var = GoogleStrategy.this.i;
                    i.d(n0Var, (CoroutineContext) null, (CoroutineStart) null, new GoogleStrategy$startConnectPlatform$1$onBillingSetupFinished$1(GoogleStrategy.this, elapsedRealtime, function0, null), 3, (Object) null);
                } else {
                    com.transsion.payment.lib.b bVar4 = bVar;
                    if (bVar4 != null) {
                        b.a.a(bVar4, Integer.valueOf(nVar.b()), nVar.a(), false, null, 8, null);
                    }
                }
            }

            public void b() {
                int i;
                n0 n0Var;
                GoogleStrategy.this.g = false;
                GoogleStrategy.this.h = false;
                com.transsion.payment.lib.d.a.c("content Service disconnected");
                i = GoogleStrategy.this.f;
                long elapsedRealtime = i - (SystemClock.elapsedRealtime() - GoogleStrategy.this.A());
                n0Var = GoogleStrategy.this.i;
                i.d(n0Var, (CoroutineContext) null, (CoroutineStart) null, new GoogleStrategy$startConnectPlatform$1$onBillingServiceDisconnected$1(GoogleStrategy.this, elapsedRealtime, function0, null), 3, (Object) null);
            }
        });
    }

    @Override // com.transsion.payment.lib.strategy.g
    public void init(Application application) {
        Intrinsics.h(application, "application");
        k.g.a().D(this);
    }

    public void onConnected() {
        m.a.a(this);
    }

    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
        K();
    }

    public void onDisconnected() {
    }

    public void w() {
        i.d(this.i, (CoroutineContext) null, (CoroutineStart) null, new GoogleStrategy$fetchSkuList$1(this, null), 3, (Object) null);
    }

    public String x() {
        return g.a.a(this);
    }

    public final HashSet y() {
        return this.c;
    }
}
