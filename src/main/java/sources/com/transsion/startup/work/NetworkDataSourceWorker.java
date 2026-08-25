package com.transsion.startup.work;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import androidx.work.i;
import bm.e;
import com.transsion.ad.monopoly.manager.AdPlansRequestManager;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.coroutines.u0;
import wf.a;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/transsion/startup/work/NetworkDataSourceWorker;", "Landroidx/work/CoroutineWorker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Landroidx/work/i$a;", "r", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "h", "Companion", "Startup_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class NetworkDataSourceWorker extends CoroutineWorker {

    /* renamed from: h, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:20:0x007d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x003a  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
        /* JADX WARN: Type inference failed for: r4v0, types: [com.transsion.startup.work.NetworkDataSourceWorker$Companion$realWork$1, kotlin.coroutines.Continuation] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object a(Continuation continuation) {
            NetworkDataSourceWorker$Companion$realWork$1 networkDataSourceWorker$Companion$realWork$1;
            ?? r4;
            Object f;
            int i;
            AdPlansRequestManager adPlansRequestManager;
            if (continuation instanceof NetworkDataSourceWorker$Companion$realWork$1) {
                networkDataSourceWorker$Companion$realWork$1 = (NetworkDataSourceWorker$Companion$realWork$1) continuation;
                int i2 = networkDataSourceWorker$Companion$realWork$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    networkDataSourceWorker$Companion$realWork$1.label = i2 - Integer.MIN_VALUE;
                    r4 = networkDataSourceWorker$Companion$realWork$1;
                    Object obj = r4.result;
                    f = IntrinsicsKt.f();
                    i = r4.label;
                    if (i != 0) {
                        ResultKt.b(obj);
                        int nextInt = Random.Default.nextInt(0, 60);
                        a.a.f(wf.a.a, "NetworkDataSourceWorker", "doWork random * " + nextInt, false, 4, (Object) null);
                        r4.label = 1;
                        if (u0.a(nextInt * 1000, r4) == f) {
                            return f;
                        }
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.b(obj);
                            e.p(e.a, (String) null, (String) null, 3, (Object) null);
                            return Unit.a;
                        }
                        ResultKt.b(obj);
                    }
                    adPlansRequestManager = AdPlansRequestManager.a;
                    r4.label = 2;
                    if (AdPlansRequestManager.u(adPlansRequestManager, "/wefeed-mobile-bff/ad/config", (Function1) null, (Continuation) r4, 2, (Object) null) == f) {
                        return f;
                    }
                    e.p(e.a, (String) null, (String) null, 3, (Object) null);
                    return Unit.a;
                }
            }
            networkDataSourceWorker$Companion$realWork$1 = new NetworkDataSourceWorker$Companion$realWork$1(this, continuation);
            r4 = networkDataSourceWorker$Companion$realWork$1;
            Object obj2 = r4.result;
            f = IntrinsicsKt.f();
            i = r4.label;
            if (i != 0) {
            }
            adPlansRequestManager = AdPlansRequestManager.a;
            r4.label = 2;
            if (AdPlansRequestManager.u(adPlansRequestManager, "/wefeed-mobile-bff/ad/config", (Function1) null, (Continuation) r4, 2, (Object) null) == f) {
            }
            e.p(e.a, (String) null, (String) null, 3, (Object) null);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkDataSourceWorker(Context context, WorkerParameters params) {
        super(context, params);
        Intrinsics.h(context, "context");
        Intrinsics.h(params, "params");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.transsion.startup.work.NetworkDataSourceWorker$doWork$1, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object r(Continuation continuation) {
        ?? r0;
        int i;
        try {
            if (continuation instanceof NetworkDataSourceWorker$doWork$1) {
                NetworkDataSourceWorker$doWork$1 networkDataSourceWorker$doWork$1 = (NetworkDataSourceWorker$doWork$1) continuation;
                int i2 = networkDataSourceWorker$doWork$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    networkDataSourceWorker$doWork$1.label = i2 - Integer.MIN_VALUE;
                    r0 = networkDataSourceWorker$doWork$1;
                    Object obj = r0.result;
                    Object f = IntrinsicsKt.f();
                    i = r0.label;
                    if (i != 0) {
                        ResultKt.b(obj);
                        Companion companion = INSTANCE;
                        r0.label = 1;
                        if (companion.a(r0) == f) {
                            return f;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                    }
                    i.a c = i.a.c();
                    Intrinsics.g(c, "success(...)");
                    return c;
                }
            }
            if (i != 0) {
            }
            i.a c2 = i.a.c();
            Intrinsics.g(c2, "success(...)");
            return c2;
        } catch (Exception e) {
            e.printStackTrace();
            i.a a = i.a.a();
            Intrinsics.g(a, "failure(...)");
            return a;
        }
        r0 = new NetworkDataSourceWorker$doWork$1(this, continuation);
        Object obj2 = r0.result;
        Object f2 = IntrinsicsKt.f();
        i = r0.label;
    }
}
