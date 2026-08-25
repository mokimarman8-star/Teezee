package com.transsion.ad.strategy;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.ad.db.MbAdDatabase;
import com.transsion.ad.db.mcc.LocalMcc;
import com.transsion.gslb.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "Lcom/transsion/ad/db/mcc/LocalMcc;", "<anonymous>", "(Lkotlinx/coroutines/n0;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.strategy.NationalInformationManager$getNationalInformation$2", f = "NationalInformationManager.kt", l = {88}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class NationalInformationManager$getNationalInformation$2 extends SuspendLambda implements Function2<n0, Continuation<? super List<? extends LocalMcc>>, Object> {
    final /* synthetic */ String $iso;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NationalInformationManager$getNationalInformation$2(String str, Continuation<? super NationalInformationManager$getNationalInformation$2> continuation) {
        super(2, continuation);
        this.$iso = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NationalInformationManager$getNationalInformation$2(this.$iso, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super List<LocalMcc>> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            MbAdDatabase.Companion companion = MbAdDatabase.INSTANCE;
            Application a = Utils.a();
            Intrinsics.g(a, "getApp(...)");
            th.a x0 = companion.b(a).x0();
            String str = this.$iso;
            this.label = 1;
            obj = x0.a(str, this);
            if (obj == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return obj;
    }
}
