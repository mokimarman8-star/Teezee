package com.transsion.push.tpush;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.baselib.db.notification.MsgBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.bean.ServerMatchListItemData;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.n0;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.push.tpush.PushRegisterManager$handleTransData$1$2$1", f = "PushRegisterManager.kt", l = {346}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PushRegisterManager$handleTransData$1$2$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ MsgBean $msg;
    final /* synthetic */ Ref.ObjectRef<String> $userId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PushRegisterManager$handleTransData$1$2$1(Ref.ObjectRef<String> objectRef, MsgBean msgBean, Continuation<? super PushRegisterManager$handleTransData$1$2$1> continuation) {
        super(2, continuation);
        this.$userId = objectRef;
        this.$msg = msgBean;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PushRegisterManager$handleTransData$1$2$1 pushRegisterManager$handleTransData$1$2$1 = new PushRegisterManager$handleTransData$1$2$1(this.$userId, this.$msg, continuation);
        pushRegisterManager$handleTransData$1$2$1.L$0 = obj;
        return pushRegisterManager$handleTransData$1$2$1;
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        MsgBean msgBean;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
            try {
                if (i == 0) {
                    ResultKt.b(obj);
                    Ref.ObjectRef<String> objectRef = this.$userId;
                    MsgBean msgBean2 = this.$msg;
                    Result.Companion companion = Result.Companion;
                    uo.a k = PushRegisterManager.k(PushRegisterManager.a);
                    String a = gg.a.a.a();
                    String valueOf = String.valueOf(objectRef.element);
                    this.L$0 = msgBean2;
                    this.label = 1;
                    obj = k.a(a, valueOf, this);
                    if (obj == f) {
                        return f;
                    }
                    msgBean = msgBean2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    msgBean = (MsgBean) this.L$0;
                    ResultKt.b(obj);
                }
                BaseDto baseDto = (BaseDto) obj;
                ServerMatchListItemData serverMatchListItemData = (ServerMatchListItemData) baseDto.getData();
                a.a.f(wf.a.a, "PushRegisterManager", "SportsLive getMatchData " + baseDto, false, 4, (Object) null);
                com.transsion.push.helper.e eVar = com.transsion.push.helper.e.a;
                Application a2 = Utils.a();
                Intrinsics.g(a2, "getApp(...)");
                eVar.h(a2, msgBean, serverMatchListItemData);
                obj2 = Result.constructor-impl(Unit.a);
            } catch (Exception e) {
                a.a.f(wf.a.a, "PushRegisterManager", "exception:" + e, false, 4, (Object) null);
                return Unit.a;
            }
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th2));
        }
        if (Result.exceptionOrNull-impl(obj2) != null) {
            a.a.f(wf.a.a, "PushRegisterManager", "赛事信息接口请求失败", false, 4, (Object) null);
        }
        return Unit.a;
    }
}
