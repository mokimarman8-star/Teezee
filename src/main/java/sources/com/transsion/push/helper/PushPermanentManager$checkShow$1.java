package com.transsion.push.helper;

import com.transsion.gslb.BuildConfig;
import com.transsion.push.db.PermanentRoom;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.push.helper.PushPermanentManager$checkShow$1", f = "PushPermanentManager.kt", l = {56}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PushPermanentManager$checkShow$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;

    PushPermanentManager$checkShow$1(Continuation<? super PushPermanentManager$checkShow$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PushPermanentManager$checkShow$1(continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        String str;
        CopyOnWriteArrayList copyOnWriteArrayList;
        long j;
        String str2;
        CopyOnWriteArrayList copyOnWriteArrayList2;
        boolean t;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            a.a aVar = wf.a.a;
            str = PushPermanentManager.e;
            copyOnWriteArrayList = PushPermanentManager.c;
            int size = copyOnWriteArrayList.size();
            j = PushPermanentManager.i;
            aVar.c("PUSH_SHOW", "checkShow mPage:" + str + ",size:" + size + ",lastRequestTime:" + j + ", mTitle:" + PushPermanentManager.a.s(), true);
            str2 = PushPermanentManager.e;
            if (str2 == null) {
                PermanentRoom permanentRoom = PermanentRoom.a;
                PushPermanentManager.e = permanentRoom.g();
                PushPermanentManager.d = permanentRoom.f();
                PushPermanentManager.h = permanentRoom.i();
                PushPermanentManager.i = permanentRoom.h();
                this.label = 1;
                obj = permanentRoom.e(this);
                if (obj == f) {
                    return f;
                }
            }
            copyOnWriteArrayList2 = PushPermanentManager.c;
            if (copyOnWriteArrayList2.size() >= 10) {
                PushPermanentManager pushPermanentManager = PushPermanentManager.a;
                t = pushPermanentManager.t();
                if (t) {
                    pushPermanentManager.v();
                    return Unit.a;
                }
            }
            PushPermanentManager.a.q();
            return Unit.a;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        PushPermanentManager.c = new CopyOnWriteArrayList((Collection) obj);
        copyOnWriteArrayList2 = PushPermanentManager.c;
        if (copyOnWriteArrayList2.size() >= 10) {
        }
        PushPermanentManager.a.q();
        return Unit.a;
    }
}
