package com.transsion.room.viewmodel;

import androidx.lifecycle.b0;
import com.transsion.flow.bean.RoomTabBean;
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
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.room.viewmodel.RoomViewModel$loadRoomTabCache$1", f = "RoomViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class RoomViewModel$loadRoomTabCache$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RoomViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RoomViewModel$loadRoomTabCache$1(RoomViewModel roomViewModel, Continuation<? super RoomViewModel$loadRoomTabCache$1> continuation) {
        super(2, continuation);
        this.this$0 = roomViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RoomViewModel$loadRoomTabCache$1 roomViewModel$loadRoomTabCache$1 = new RoomViewModel$loadRoomTabCache$1(this.this$0, continuation);
        roomViewModel$loadRoomTabCache$1.L$0 = obj;
        return roomViewModel$loadRoomTabCache$1;
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:3|(2:4|5)|(8:7|(1:9)|10|11|12|13|14|15)|20|10|11|12|13|14|15) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        RoomTabBean roomTabBean;
        String string;
        b0 b0Var;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        RoomViewModel roomViewModel = this.this$0;
        try {
            Result.Companion companion = Result.Companion;
            roomTabBean = null;
            string = com.transsion.baselib.report.launch.b.a.b().getString("k_room_tab_cache", (String) null);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
        if (string != null) {
            if (string.length() == 0) {
            }
            roomTabBean = (RoomTabBean) com.blankj.utilcode.util.o.d(string, RoomTabBean.class);
            b0Var = roomViewModel.d;
            b0Var.n(roomTabBean);
            Result.constructor-impl(Unit.a);
            return Unit.a;
        }
        string = roomViewModel.M();
        roomTabBean = (RoomTabBean) com.blankj.utilcode.util.o.d(string, RoomTabBean.class);
        b0Var = roomViewModel.d;
        b0Var.n(roomTabBean);
        Result.constructor-impl(Unit.a);
        return Unit.a;
    }
}
