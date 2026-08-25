package com.transsion.push.utils;

import android.content.Context;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.bean.ShowOrder;
import com.transsion.push.helper.RoomHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.u0;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.push.utils.NotificationUtil$getLast3MsgForPermanent$1", f = "NotificationUtil.kt", l = {613, 616, 618}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class NotificationUtil$getLast3MsgForPermanent$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $messageId;
    final /* synthetic */ boolean $needDelay;
    final /* synthetic */ ShowOrder $showOrder;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NotificationUtil$getLast3MsgForPermanent$1(boolean z, Context context, ShowOrder showOrder, String str, Continuation<? super NotificationUtil$getLast3MsgForPermanent$1> continuation) {
        super(2, continuation);
        this.$needDelay = z;
        this.$context = context;
        this.$showOrder = showOrder;
        this.$messageId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationUtil$getLast3MsgForPermanent$1(this.$needDelay, this.$context, this.$showOrder, this.$messageId, continuation);
    }

    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        List list;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            if (this.$needDelay) {
                this.label = 1;
                if (u0.a(500L, this) == f) {
                    return f;
                }
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    list = (List) obj;
                    if (list != null) {
                        NotificationUtil.k(NotificationUtil.a, this.$context, list, this.$showOrder, this.$messageId);
                    }
                    a.a.f(wf.a.a, "NotificationUtil", " show notification from db", false, 4, (Object) null);
                    return Unit.a;
                }
                ResultKt.b(obj);
                if (((Boolean) obj).booleanValue()) {
                    RoomHelper roomHelper = RoomHelper.a;
                    Context context = this.$context;
                    this.label = 3;
                    obj = roomHelper.a(context, this);
                    if (obj == f) {
                        return f;
                    }
                    list = (List) obj;
                    if (list != null) {
                    }
                    a.a.f(wf.a.a, "NotificationUtil", " show notification from db", false, 4, (Object) null);
                }
                return Unit.a;
            }
            ResultKt.b(obj);
        }
        RoomHelper roomHelper2 = RoomHelper.a;
        Context context2 = this.$context;
        this.label = 2;
        obj = roomHelper2.f(context2, this);
        if (obj == f) {
            return f;
        }
        if (((Boolean) obj).booleanValue()) {
        }
        return Unit.a;
    }
}
