package com.transsion.push.utils;

import android.content.Context;
import com.blankj.utilcode.util.c0;
import com.transsion.baselib.db.notification.MsgBean;
import com.transsion.baselib.db.notification.PullMsgResp;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.helper.RoomHelper;
import com.transsion.pushapi.TriggerSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.push.utils.NotificationUtil$loadSeekSubjectMsg$1", f = "NotificationUtil.kt", l = {414}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class NotificationUtil$loadSeekSubjectMsg$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ TriggerSource $triggerSource;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NotificationUtil$loadSeekSubjectMsg$1(Context context, TriggerSource triggerSource, Continuation<? super NotificationUtil$loadSeekSubjectMsg$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$triggerSource = triggerSource;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationUtil$loadSeekSubjectMsg$1(this.$context, this.$triggerSource, continuation);
    }

    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object e;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            if (c0.f(u.a.b().getLong("seeking_msg_show_time", 0L))) {
                return Unit.a;
            }
            RoomHelper roomHelper = RoomHelper.a;
            Context context = this.$context;
            this.label = 1;
            e = roomHelper.e(context, this);
            if (e == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            e = obj;
        }
        List list = (List) e;
        if (list != null) {
            Context context2 = this.$context;
            TriggerSource triggerSource = this.$triggerSource;
            if (list.isEmpty()) {
                return Unit.a;
            }
            NotificationUtil notificationUtil = NotificationUtil.a;
            NotificationUtil.i(notificationUtil.G());
            NotificationUtil.j(notificationUtil, context2, new PullMsgResp(list, NotificationUtil.e(), null, 4, null), triggerSource);
            a.a aVar = wf.a.a;
            MsgBean msgBean = (MsgBean) CollectionsKt.k0(list);
            a.a.f(aVar, "NotificationUtil", "show seek notification msg: " + (msgBean != null ? msgBean.getReceiveTime() : null), false, 4, (Object) null);
        }
        return Unit.a;
    }
}
