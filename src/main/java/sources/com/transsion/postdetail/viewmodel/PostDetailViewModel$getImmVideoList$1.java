package com.transsion.postdetail.viewmodel;

import androidx.lifecycle.b0;
import com.transsion.gslb.BuildConfig;
import com.transsion.postdetail.ui.fragment.preload.VideoDataLoader;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.viewmodel.PostDetailViewModel$getImmVideoList$1", f = "PostDetailViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PostDetailViewModel$getImmVideoList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $postId;
    int label;
    final /* synthetic */ PostDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PostDetailViewModel$getImmVideoList$1(PostDetailViewModel postDetailViewModel, String str, Continuation<? super PostDetailViewModel$getImmVideoList$1> continuation) {
        super(2, continuation);
        this.this$0 = postDetailViewModel;
        this.$postId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PostDetailViewModel$getImmVideoList$1(this.this$0, this.$postId, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        VideoDataLoader videoDataLoader;
        VideoDataLoader videoDataLoader2;
        b0 w;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        videoDataLoader = this.this$0.d;
        if (videoDataLoader != null) {
            videoDataLoader.p(this.$postId);
        }
        videoDataLoader2 = this.this$0.d;
        if (videoDataLoader2 != null) {
            w = this.this$0.w();
            videoDataLoader2.f(w);
        }
        return Unit.a;
    }
}
