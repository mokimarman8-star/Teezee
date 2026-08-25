package com.transsion.ad.hi;

import android.app.Application;
import android.content.Context;
import com.blankj.utilcode.util.Utils;
import com.cloud.hisavana.net.CommonOkHttpClient;
import com.hisavana.mediation.config.TAdManager;
import com.transsion.gslb.BuildConfig;
import kg.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import okhttp3.OkHttpClient;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/n0;", "Lkotlin/Result;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)Lkotlin/Result;"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.hi.HiSavanaAdManager$initHiAdSdk$2", f = "HiSavanaAdManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class HiSavanaAdManager$initHiAdSdk$2 extends SuspendLambda implements Function2<n0, Continuation<? super Result<? extends Unit>>, Object> {
    final /* synthetic */ boolean $adTestDevice;
    final /* synthetic */ String $hisavanaAppId;
    final /* synthetic */ boolean $isDebug;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HiSavanaAdManager$initHiAdSdk$2(String str, boolean z, boolean z2, Continuation<? super HiSavanaAdManager$initHiAdSdk$2> continuation) {
        super(2, continuation);
        this.$hisavanaAppId = str;
        this.$isDebug = z;
        this.$adTestDevice = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(int i, String str) {
        i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new HiSavanaAdManager$initHiAdSdk$2$1$1$1$1(null), 3, (Object) null);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HiSavanaAdManager$initHiAdSdk$2(this.$hisavanaAppId, this.$isDebug, this.$adTestDevice, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Result<Unit>> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Context applicationContext;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        String str = this.$hisavanaAppId;
        boolean z = this.$isDebug;
        boolean z2 = this.$adTestDevice;
        try {
            Result.Companion companion = Result.Companion;
            OkHttpClient g = c.e.a().g();
            Unit unit = null;
            CommonOkHttpClient.r(g != null ? g.dispatcher() : null);
            Application a = Utils.a();
            if (a != null && (applicationContext = a.getApplicationContext()) != null) {
                boolean z3 = false;
                TAdManager.AdConfigBuilder debug = new TAdManager.AdConfigBuilder().setAppId(str).setAppIconId(com.blankj.utilcode.util.c.a()).setDebug(z);
                if (z && z2) {
                    z3 = true;
                }
                TAdManager.init(applicationContext, debug.testDevice(z3).setMuteVideo(true).setCloudCompleteListener(new TAdManager.OnCloudCompleteListener() { // from class: com.transsion.ad.hi.a
                    public final void onCloudComplete(int i, String str2) {
                        HiSavanaAdManager$initHiAdSdk$2.d(i, str2);
                    }
                }).build());
                unit = Unit.a;
            }
            obj2 = Result.constructor-impl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th2));
        }
        return Result.box-impl(obj2);
    }
}
