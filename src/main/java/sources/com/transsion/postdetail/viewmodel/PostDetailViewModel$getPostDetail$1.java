package com.transsion.postdetail.viewmodel;

import androidx.lifecycle.b0;
import com.tn.lib.net.bean.BaseDto;
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
import retrofit2.HttpException;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.viewmodel.PostDetailViewModel$getPostDetail$1", f = "PostDetailViewModel.kt", l = {75}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PostDetailViewModel$getPostDetail$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $postId;
    Object L$0;
    int label;
    final /* synthetic */ PostDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PostDetailViewModel$getPostDetail$1(PostDetailViewModel postDetailViewModel, String str, Continuation<? super PostDetailViewModel$getPostDetail$1> continuation) {
        super(2, continuation);
        this.this$0 = postDetailViewModel;
        this.$postId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PostDetailViewModel$getPostDetail$1(this.this$0, this.$postId, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        b0 z;
        ao.b D;
        PostDetailViewModel postDetailViewModel;
        b0 z2;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.b(obj);
                PostDetailViewModel postDetailViewModel2 = this.this$0;
                String str = this.$postId;
                Result.Companion companion = Result.Companion;
                D = postDetailViewModel2.D();
                String a = gg.a.a.a();
                this.L$0 = postDetailViewModel2;
                this.label = 1;
                Object a2 = D.a(a, str, this);
                if (a2 == f) {
                    return f;
                }
                postDetailViewModel = postDetailViewModel2;
                obj = a2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                postDetailViewModel = (PostDetailViewModel) this.L$0;
                ResultKt.b(obj);
            }
            z2 = postDetailViewModel.z();
            z2.q(((BaseDto) obj).getData());
            obj2 = Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th2));
        }
        PostDetailViewModel postDetailViewModel3 = this.this$0;
        HttpException httpException = Result.exceptionOrNull-impl(obj2);
        if (httpException != null) {
            if (httpException instanceof HttpException) {
                HttpException httpException2 = httpException;
                if (httpException2.code() == 404) {
                    postDetailViewModel3.y().q(String.valueOf(httpException2.code()));
                }
            }
            z = postDetailViewModel3.z();
            z.q((Object) null);
        }
        return Unit.a;
    }
}
