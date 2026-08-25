package com.transsion.room.sub.viewmodel.likes;

import com.google.gson.JsonObject;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import mg.b;
import okhttp3.RequestBody;
import op.a;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.room.sub.viewmodel.likes.UgcLikesViewModel$postLikeUgcVideo$1", f = "UgcLikesViewModel.kt", l = {100}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class UgcLikesViewModel$postLikeUgcVideo$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isLike;
    final /* synthetic */ String $ugcVideoId;
    Object L$0;
    int label;
    final /* synthetic */ UgcLikesViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UgcLikesViewModel$postLikeUgcVideo$1(String str, boolean z, UgcLikesViewModel ugcLikesViewModel, Continuation<? super UgcLikesViewModel$postLikeUgcVideo$1> continuation) {
        super(2, continuation);
        this.$ugcVideoId = str;
        this.$isLike = z;
        this.this$0 = ugcLikesViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UgcLikesViewModel$postLikeUgcVideo$1(this.$ugcVideoId, this.$isLike, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar;
        UgcLikesViewModel ugcLikesViewModel;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
        } catch (Exception e) {
            e.printStackTrace();
            a.a aVar2 = wf.a.a;
            String simpleName = UgcLikesViewModel.class.getSimpleName();
            Intrinsics.g(simpleName, "getSimpleName(...)");
            aVar2.i(simpleName, "exceptionHandler " + e.getMessage(), true);
        }
        if (i == 0) {
            ResultKt.b(obj);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("ugcVideoId", this.$ugcVideoId);
            jsonObject.addProperty("reqType", Boxing.d(!this.$isLike ? 1 : 0));
            b.a aVar3 = b.a;
            String jsonElement = jsonObject.toString();
            Intrinsics.g(jsonElement, "toString(...)");
            RequestBody a = aVar3.a(jsonElement);
            if (a != null) {
                UgcLikesViewModel ugcLikesViewModel2 = this.this$0;
                aVar = ugcLikesViewModel2.d;
                String a2 = gg.a.a.a();
                this.L$0 = ugcLikesViewModel2;
                this.label = 1;
                obj = aVar.a(a2, a, this);
                if (obj == f) {
                    return f;
                }
                ugcLikesViewModel = ugcLikesViewModel2;
            }
            return Unit.a;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ugcLikesViewModel = (UgcLikesViewModel) this.L$0;
        ResultKt.b(obj);
        ugcLikesViewModel.e().n(((BaseDto) obj).getData());
        return Unit.a;
    }
}
