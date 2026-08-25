package com.transsion.push.utils;

import android.content.Context;
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
@DebugMetadata(c = "com.transsion.push.utils.NotificationUtil$loadNotificationMsg$1", f = "NotificationUtil.kt", l = {371, 382}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class NotificationUtil$loadNotificationMsg$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ TriggerSource $triggerSource;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NotificationUtil$loadNotificationMsg$1(TriggerSource triggerSource, Context context, Continuation<? super NotificationUtil$loadNotificationMsg$1> continuation) {
        super(2, continuation);
        this.$triggerSource = triggerSource;
        this.$context = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationUtil$loadNotificationMsg$1(this.$triggerSource, this.$context, continuation);
    }

    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00be A[Catch: Exception -> 0x001b, TRY_LEAVE, TryCatch #0 {Exception -> 0x001b, blocks: (B:7:0x0014, B:9:0x0094, B:12:0x009e, B:14:0x00a6, B:16:0x00ac, B:18:0x00b4, B:22:0x00be, B:25:0x0026, B:27:0x004d, B:29:0x0051, B:31:0x005b, B:32:0x0084, B:37:0x002f, B:39:0x0035, B:41:0x003d, B:43:0x0040), top: B:2:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object a;
        Object f;
        List list;
        MsgBean msgBean;
        Object f2 = IntrinsicsKt.f();
        int i = this.label;
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (i == 0) {
            ResultKt.b(obj);
            if (this.$triggerSource == TriggerSource.NETWORK_CONNECTED && !com.transsion.baselib.report.k.a.q()) {
                return Unit.a;
            }
            RoomHelper roomHelper = RoomHelper.a;
            Context context = this.$context;
            this.label = 1;
            a = roomHelper.a(context, this);
            if (a == f2) {
                return f2;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = (List) this.L$0;
                ResultKt.b(obj);
                f = obj;
                if (((Boolean) f).booleanValue()) {
                    NotificationUtil.f(NotificationUtil.a, this.$context, this.$triggerSource);
                    a.a.f(wf.a.a, "NotificationUtil", "get notification from network", false, 4, (Object) null);
                } else if (list != null && (msgBean = (MsgBean) CollectionsKt.k0(list)) != null && msgBean.getBuiltIn() && yg.l.a.e()) {
                    NotificationUtil.f(NotificationUtil.a, this.$context, this.$triggerSource);
                }
                return Unit.a;
            }
            ResultKt.b(obj);
            a = obj;
        }
        List list2 = (List) a;
        if (list2 != null) {
            Context context2 = this.$context;
            TriggerSource triggerSource = this.$triggerSource;
            if (!list2.isEmpty()) {
                NotificationUtil notificationUtil = NotificationUtil.a;
                NotificationUtil.i(notificationUtil.G());
                NotificationUtil.j(notificationUtil, context2, new PullMsgResp(list2, NotificationUtil.e(), null, 4, null), triggerSource);
                a.a.f(wf.a.a, "NotificationUtil", " show notification from db", false, 4, (Object) null);
            }
        }
        RoomHelper roomHelper2 = RoomHelper.a;
        Context context3 = this.$context;
        this.L$0 = list2;
        this.label = 2;
        f = roomHelper2.f(context3, this);
        if (f == f2) {
            return f2;
        }
        list = list2;
        if (((Boolean) f).booleanValue()) {
        }
        return Unit.a;
    }
}
