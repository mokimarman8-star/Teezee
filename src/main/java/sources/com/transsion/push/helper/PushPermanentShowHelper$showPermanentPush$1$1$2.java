package com.transsion.push.helper;

import android.content.Context;
import android.graphics.Bitmap;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.bean.PermanentItemBean;
import java.util.List;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.transsion.push.helper.PushPermanentShowHelper$showPermanentPush$1$1$2", f = "PushPermanentShowHelper.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PushPermanentShowHelper$showPermanentPush$1$1$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Bitmap> $bitmapList;
    final /* synthetic */ Context $context;
    final /* synthetic */ int $curAbType;
    final /* synthetic */ List<PermanentItemBean> $successMsg;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PushPermanentShowHelper$showPermanentPush$1$1$2(Context context, List<PermanentItemBean> list, List<Bitmap> list2, int i, Continuation<? super PushPermanentShowHelper$showPermanentPush$1$1$2> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$successMsg = list;
        this.$bitmapList = list2;
        this.$curAbType = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PushPermanentShowHelper$showPermanentPush$1$1$2(this.$context, this.$successMsg, this.$bitmapList, this.$curAbType, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        PushPermanentShowHelper pushPermanentShowHelper = PushPermanentShowHelper.a;
        Context context = this.$context;
        List<PermanentItemBean> list = this.$successMsg;
        Intrinsics.e(list);
        List<Bitmap> list2 = this.$bitmapList;
        Intrinsics.e(list2);
        pushPermanentShowHelper.o(context, list, list2, this.$curAbType);
        return Unit.a;
    }
}
