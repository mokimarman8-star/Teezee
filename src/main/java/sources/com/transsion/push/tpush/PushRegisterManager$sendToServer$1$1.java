package com.transsion.push.tpush;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import okhttp3.RequestBody;
import org.json.JSONObject;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.push.tpush.PushRegisterManager$sendToServer$1$1", f = "PushRegisterManager.kt", l = {174}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PushRegisterManager$sendToServer$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $json;
    final /* synthetic */ String $regHash;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PushRegisterManager$sendToServer$1$1(JSONObject jSONObject, String str, Continuation<? super PushRegisterManager$sendToServer$1$1> continuation) {
        super(2, continuation);
        this.$json = jSONObject;
        this.$regHash = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PushRegisterManager$sendToServer$1$1 pushRegisterManager$sendToServer$1$1 = new PushRegisterManager$sendToServer$1$1(this.$json, this.$regHash, continuation);
        pushRegisterManager$sendToServer$1$1.L$0 = obj;
        return pushRegisterManager$sendToServer$1$1;
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        String str;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.b(obj);
                JSONObject jSONObject = this.$json;
                String str2 = this.$regHash;
                Result.Companion companion = Result.Companion;
                PushRegisterManager pushRegisterManager = PushRegisterManager.a;
                h l = PushRegisterManager.l(pushRegisterManager);
                String a = gg.a.a.a();
                String jSONObject2 = jSONObject.toString();
                Intrinsics.g(jSONObject2, "toString(...)");
                RequestBody m = PushRegisterManager.m(pushRegisterManager, jSONObject2);
                this.L$0 = str2;
                this.label = 1;
                obj = l.a(a, m, this);
                if (obj == f) {
                    return f;
                }
                str = str2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = (String) this.L$0;
                ResultKt.b(obj);
            }
            BaseDto baseDto = (BaseDto) obj;
            if (Intrinsics.c(baseDto.getCode(), "0")) {
                com.transsion.baselib.report.launch.b.a.b().putString("push_ru", str);
                a.a.f(wf.a.a, "PushRegisterManager", "onSuccess, retry:" + PushRegisterManager.n(), false, 4, (Object) null);
            } else {
                a.a.f(wf.a.a, "PushRegisterManager", "onFailure code " + baseDto.getCode() + " retry:" + PushRegisterManager.n(), false, 4, (Object) null);
                PushRegisterManager.q(PushRegisterManager.a);
            }
            obj2 = Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th2));
        }
        String str3 = this.$regHash;
        Throwable th3 = Result.exceptionOrNull-impl(obj2);
        if (th3 != null) {
            a.a.f(wf.a.a, "PushRegisterManager", "send error: " + th3.getMessage() + " retry:" + PushRegisterManager.n() + ",refresh:" + str3, false, 4, (Object) null);
            PushRegisterManager.q(PushRegisterManager.a);
        }
        return Unit.a;
    }
}
