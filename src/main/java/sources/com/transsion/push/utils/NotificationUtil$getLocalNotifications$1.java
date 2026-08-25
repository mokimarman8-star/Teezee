package com.transsion.push.utils;

import android.content.Context;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.baselib.db.notification.MsgConfig;
import com.transsion.baselib.db.notification.PullMsgResp;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.PushConstants;
import com.transsion.push.bean.PushConfigHelper;
import com.transsion.push.bean.ShowOrder;
import com.transsion.push.helper.RoomHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.y0;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.push.utils.NotificationUtil$getLocalNotifications$1", f = "NotificationUtil.kt", l = {464}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class NotificationUtil$getLocalNotifications$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Lcom/transsion/baselib/db/notification/PullMsgResp;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.push.utils.NotificationUtil$getLocalNotifications$1$1", f = "NotificationUtil.kt", l = {445, 452, 457}, m = "invokeSuspend")
    /* renamed from: com.transsion.push.utils.NotificationUtil$getLocalNotifications$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.b, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        float F$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$context = context;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$context, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(kotlinx.coroutines.flow.b bVar, Continuation<? super Unit> continuation) {
            return create(bVar, continuation).invokeSuspend(Unit.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x010a  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0139 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x013a  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00ed  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.b bVar;
            float f;
            BaseDto baseDto;
            kotlinx.coroutines.flow.b bVar2;
            String startTime;
            PullMsgResp pullMsgResp;
            Context context;
            NotificationUtil notificationUtil;
            Object data;
            PullMsgResp pullMsgResp2;
            Object f2 = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                kotlinx.coroutines.flow.b bVar3 = (kotlinx.coroutines.flow.b) this.L$0;
                NotificationUtil notificationUtil2 = NotificationUtil.a;
                float y = notificationUtil2.y();
                MsgConfig e = NotificationUtil.e();
                float parseFloat = ((e == null || (startTime = e.getStartTime()) == null) ? 8.0f : Float.parseFloat(startTime)) + PushConfigHelper.INSTANCE.getHashTime();
                if (y < parseFloat) {
                    return Unit.a;
                }
                if (!yg.l.a.e()) {
                    baseDto = new BaseDto();
                    baseDto.setData(NotificationUtil.d(notificationUtil2).a(this.$context));
                    bVar2 = bVar3;
                    pullMsgResp = (PullMsgResp) baseDto.getData();
                    if (pullMsgResp != null) {
                        context = this.$context;
                        RoomHelper roomHelper = RoomHelper.a;
                        this.L$0 = bVar2;
                        this.L$1 = baseDto;
                        this.L$2 = context;
                        this.L$3 = pullMsgResp;
                        this.label = 2;
                        if (roomHelper.g(context, pullMsgResp, this) == f2) {
                            return f2;
                        }
                        notificationUtil = NotificationUtil.a;
                        if (notificationUtil.G() == null) {
                        }
                        u.a.b().putString(PushConstants.SP_KEY_CONFIG, com.blankj.utilcode.util.o.j(pullMsgResp.getConfig()));
                        data = baseDto.getData();
                        this.L$0 = context;
                        this.L$1 = pullMsgResp;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 3;
                        if (bVar2.emit(data, this) != f2) {
                        }
                    }
                    return Unit.a;
                }
                wf.a.a.c("NotificationUtil", "fetch localPush startTime:" + parseFloat + ", hour" + y, true);
                to.b g = NotificationUtil.g(notificationUtil2);
                String a = gg.a.a.a();
                this.L$0 = bVar3;
                this.F$0 = y;
                this.label = 1;
                Object b = g.b(a, this);
                if (b == f2) {
                    return f2;
                }
                bVar = bVar3;
                obj = b;
                f = y;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        pullMsgResp2 = (PullMsgResp) this.L$1;
                        context = (Context) this.L$0;
                        ResultKt.b(obj);
                        NotificationUtil.h(NotificationUtil.a, context, pullMsgResp2);
                        return Unit.a;
                    }
                    PullMsgResp pullMsgResp3 = (PullMsgResp) this.L$3;
                    Context context2 = (Context) this.L$2;
                    baseDto = (BaseDto) this.L$1;
                    bVar2 = (kotlinx.coroutines.flow.b) this.L$0;
                    ResultKt.b(obj);
                    pullMsgResp = pullMsgResp3;
                    context = context2;
                    notificationUtil = NotificationUtil.a;
                    if (notificationUtil.G() == null) {
                        notificationUtil.u(context, pullMsgResp.getConfig());
                    }
                    u.a.b().putString(PushConstants.SP_KEY_CONFIG, com.blankj.utilcode.util.o.j(pullMsgResp.getConfig()));
                    data = baseDto.getData();
                    this.L$0 = context;
                    this.L$1 = pullMsgResp;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 3;
                    if (bVar2.emit(data, this) != f2) {
                        return f2;
                    }
                    pullMsgResp2 = pullMsgResp;
                    NotificationUtil.h(NotificationUtil.a, context, pullMsgResp2);
                    return Unit.a;
                }
                f = this.F$0;
                bVar = (kotlinx.coroutines.flow.b) this.L$0;
                ResultKt.b(obj);
            }
            BaseDto baseDto2 = (BaseDto) obj;
            if (Intrinsics.c(baseDto2.getCode(), "0")) {
                com.transsion.push.helper.a.a.i(String.valueOf(f));
            }
            bVar2 = bVar;
            baseDto = baseDto2;
            pullMsgResp = (PullMsgResp) baseDto.getData();
            if (pullMsgResp != null) {
            }
            return Unit.a;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Lcom/transsion/baselib/db/notification/PullMsgResp;", BuildConfig.FLAVOR, "it", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.push.utils.NotificationUtil$getLocalNotifications$1$2", f = "NotificationUtil.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.push.utils.NotificationUtil$getLocalNotifications$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.b, Throwable, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        public final Object invoke(kotlinx.coroutines.flow.b bVar, Throwable th2, Continuation<? super Unit> continuation) {
            return new AnonymousClass2(continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            a.a.f(wf.a.a, "NotificationUtil", "get local notification error", false, 4, (Object) null);
            return Unit.a;
        }
    }

    static final class a implements kotlinx.coroutines.flow.b {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(PullMsgResp pullMsgResp, Continuation continuation) {
            a.a.f(wf.a.a, "NotificationUtil", "get local notification =" + pullMsgResp + "}", false, 4, (Object) null);
            if (pullMsgResp != null) {
                Context context = this.a;
                NotificationUtil notificationUtil = NotificationUtil.a;
                if (NotificationUtil.c(notificationUtil)) {
                    NotificationUtil.d0(notificationUtil, context, pullMsgResp.getItems(), (ShowOrder) null, (String) null, 12, (Object) null);
                }
            }
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NotificationUtil$getLocalNotifications$1(Context context, Continuation<? super NotificationUtil$getLocalNotifications$1> continuation) {
        super(2, continuation);
        this.$context = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationUtil$getLocalNotifications$1(this.$context, continuation);
    }

    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.a e = kotlinx.coroutines.flow.c.e(kotlinx.coroutines.flow.c.t(kotlinx.coroutines.flow.c.r(new AnonymousClass1(this.$context, null)), y0.b()), new AnonymousClass2(null));
            a aVar = new a(this.$context);
            this.label = 1;
            if (e.a(aVar, this) == f) {
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
