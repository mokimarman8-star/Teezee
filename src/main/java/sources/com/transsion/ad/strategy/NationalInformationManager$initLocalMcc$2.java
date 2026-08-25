package com.transsion.ad.strategy;

import android.content.Context;
import com.google.gson.reflect.TypeToken;
import com.transsion.ad.db.MbAdDatabase;
import com.transsion.ad.db.mcc.LocalMcc;
import com.transsion.gslb.BuildConfig;
import java.util.List;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.strategy.NationalInformationManager$initLocalMcc$2", f = "NationalInformationManager.kt", l = {39, 49}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class NationalInformationManager$initLocalMcc$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NationalInformationManager$initLocalMcc$2(Context context, Continuation<? super NationalInformationManager$initLocalMcc$2> continuation) {
        super(2, continuation);
        this.$context = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NationalInformationManager$initLocalMcc$2(this.$context, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Throwable th2;
        String c;
        Context context;
        String c2;
        String c3;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
        } catch (Throwable th3) {
            Result.Companion companion = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th3));
        }
        if (i == 0) {
            ResultKt.b(obj);
            context = this.$context;
            Result.Companion companion2 = Result.Companion;
            th.a x0 = MbAdDatabase.INSTANCE.b(context).x0();
            this.L$0 = context;
            this.label = 1;
            obj = x0.d(this);
            if (obj == f) {
                return f;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                xh.a aVar = xh.a.a;
                c3 = NationalInformationManager.a.c();
                xh.a.c(aVar, c3 + " --> initLocalMcc() --> assets数据 -- 保存数据库成功 -- success", 0, false, 6, null);
                obj2 = Result.constructor-impl(Unit.a);
                th2 = Result.exceptionOrNull-impl(obj2);
                if (th2 != null) {
                    xh.a aVar2 = xh.a.a;
                    c = NationalInformationManager.a.c();
                    xh.a.c(aVar2, c + " --> initLocalMcc() --> assets数据 -- 保存数据库失败 -- error -- it = " + th2, 6, false, 4, null);
                }
                return Unit.a;
            }
            context = (Context) this.L$0;
            ResultKt.b(obj);
        }
        if (((LocalMcc) obj) != null) {
            xh.a aVar3 = xh.a.a;
            c2 = NationalInformationManager.a.c();
            xh.a.c(aVar3, c2 + " --> initLocalMcc() --> 数据库已存在 --> success", 0, false, 6, null);
            return Unit.a;
        }
        List list = (List) com.blankj.utilcode.util.o.e(ci.f.a.b("local_mcc.json"), new TypeToken<List<? extends LocalMcc>>() { // from class: com.transsion.ad.strategy.NationalInformationManager$initLocalMcc$2$1$listType$1
        }.getType());
        th.a x02 = MbAdDatabase.INSTANCE.b(context).x0();
        Intrinsics.e(list);
        this.L$0 = null;
        this.label = 2;
        if (x02.b(list, this) == f) {
            return f;
        }
        xh.a aVar4 = xh.a.a;
        c3 = NationalInformationManager.a.c();
        xh.a.c(aVar4, c3 + " --> initLocalMcc() --> assets数据 -- 保存数据库成功 -- success", 0, false, 6, null);
        obj2 = Result.constructor-impl(Unit.a);
        th2 = Result.exceptionOrNull-impl(obj2);
        if (th2 != null) {
        }
        return Unit.a;
    }
}
