package com.transsion.room.viewmodel;

import com.transsion.baselib.db.room.RoomItemBean;
import com.transsion.flow.bean.RoomItem;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.room.viewmodel.RoomDetailViewModel$insertRecentlyRoom$1", f = "RoomDetailViewModel.kt", l = {142, 143, 146}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class RoomDetailViewModel$insertRecentlyRoom$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ RoomItem $roomItem;
    int label;
    final /* synthetic */ RoomDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RoomDetailViewModel$insertRecentlyRoom$1(RoomItem roomItem, RoomDetailViewModel roomDetailViewModel, Continuation<? super RoomDetailViewModel$insertRecentlyRoom$1> continuation) {
        super(2, continuation);
        this.$roomItem = roomItem;
        this.this$0 = roomDetailViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RoomDetailViewModel$insertRecentlyRoom$1(this.$roomItem, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0069, code lost:
    
        r7 = r20.this$0.o();
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b2 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        RoomItemBean roomItemBean;
        aj.a o;
        aj.a o2;
        Object a;
        aj.a o3;
        RoomItemBean roomItemBean2;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        List list = null;
        if (i == 0) {
            ResultKt.b(obj);
            String groupId = this.$roomItem.getGroupId();
            if (groupId != null) {
                RoomItem roomItem = this.$roomItem;
                roomItemBean = new RoomItemBean(groupId, roomItem.getName(), roomItem.getAvatar(), roomItem.getHasJoin(), roomItem.getNewPostCount(), roomItem.getDescription(), roomItem.getPostCount(), roomItem.getUserCount(), roomItem.getLevel(), System.currentTimeMillis());
            } else {
                roomItemBean = null;
            }
            if (roomItemBean != null && o != null) {
                this.label = 1;
                if (o.b(roomItemBean, this) == f) {
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
                    return Unit.a;
                }
                ResultKt.b(obj);
                a = obj;
                list = (List) a;
                if (list != null && list.size() > 5 && o3 != null) {
                    roomItemBean2 = (RoomItemBean) list.get(list.size() - 1);
                    this.label = 3;
                    if (o3.c(roomItemBean2, this) == f) {
                        return f;
                    }
                }
                return Unit.a;
            }
            ResultKt.b(obj);
        }
        o2 = this.this$0.o();
        if (o2 != null) {
            this.label = 2;
            a = o2.a(this);
            if (a == f) {
                return f;
            }
            list = (List) a;
        }
        if (list != null) {
            o3 = this.this$0.o();
            roomItemBean2 = (RoomItemBean) list.get(list.size() - 1);
            this.label = 3;
            if (o3.c(roomItemBean2, this) == f) {
            }
        }
        return Unit.a;
    }
}
