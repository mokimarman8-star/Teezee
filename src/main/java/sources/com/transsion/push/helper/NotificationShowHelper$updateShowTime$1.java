package com.transsion.push.helper;

import android.content.Context;
import com.transsion.baselib.db.notification.MsgBean;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.push.helper.NotificationShowHelper$updateShowTime$1", f = "NotificationShowHelper.kt", l = {783}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class NotificationShowHelper$updateShowTime$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ MsgBean $msgBean;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NotificationShowHelper$updateShowTime$1(Context context, MsgBean msgBean, Continuation<? super NotificationShowHelper$updateShowTime$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$msgBean = msgBean;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationShowHelper$updateShowTime$1(this.$context, this.$msgBean, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            RoomHelper roomHelper = RoomHelper.a;
            Context context = this.$context;
            MsgBean msgBean = this.$msgBean;
            this.label = 1;
            if (roomHelper.h(context, msgBean, this) == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.a;
    }
}
