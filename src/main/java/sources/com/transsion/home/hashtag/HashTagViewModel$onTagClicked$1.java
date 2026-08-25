package com.transsion.home.hashtag;

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
import kotlinx.coroutines.u0;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.hashtag.HashTagViewModel$onTagClicked$1", f = "HashTagViewModel.kt", l = {285}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class HashTagViewModel$onTagClicked$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HashTagViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HashTagViewModel$onTagClicked$1(HashTagViewModel hashTagViewModel, Continuation<? super HashTagViewModel$onTagClicked$1> continuation) {
        super(2, continuation);
        this.this$0 = hashTagViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HashTagViewModel$onTagClicked$1(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            this.label = 1;
            if (u0.a(700L, this) == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        a.a aVar = a.a;
        str = this.this$0.g;
        a.a.f(aVar, "HashTagViewModel", "onTagClicked: debounce delay finished, start refresh, tabSort=" + str, false, 4, (Object) null);
        HashTagViewModel hashTagViewModel = this.this$0;
        str2 = hashTagViewModel.g;
        hashTagViewModel.A(str2);
        return Unit.a;
    }
}
