package com.transsion.postdetail.viewmodel;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.postdetail.bean.CommentListBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.viewmodel.CommentViewModel$getCommentList$1", f = "CommentViewModel.kt", l = {85}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class CommentViewModel$getCommentList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $locCommentId;
    final /* synthetic */ String $page;
    final /* synthetic */ int $perPage;
    final /* synthetic */ String $postId;
    final /* synthetic */ String $rootCommentId;
    final /* synthetic */ String $topicType;
    int label;
    final /* synthetic */ CommentViewModel this$0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Lcom/transsion/postdetail/bean/CommentListBean;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.postdetail.viewmodel.CommentViewModel$getCommentList$1$1", f = "CommentViewModel.kt", l = {78, 79}, m = "invokeSuspend")
    /* renamed from: com.transsion.postdetail.viewmodel.CommentViewModel$getCommentList$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.b, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $locCommentId;
        final /* synthetic */ String $page;
        final /* synthetic */ int $perPage;
        final /* synthetic */ String $postId;
        final /* synthetic */ String $rootCommentId;
        final /* synthetic */ String $topicType;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CommentViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CommentViewModel commentViewModel, String str, String str2, String str3, String str4, String str5, int i, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = commentViewModel;
            this.$postId = str;
            this.$topicType = str2;
            this.$rootCommentId = str3;
            this.$page = str4;
            this.$locCommentId = str5;
            this.$perPage = i;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$postId, this.$topicType, this.$rootCommentId, this.$page, this.$locCommentId, this.$perPage, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(kotlinx.coroutines.flow.b bVar, Continuation<? super Unit> continuation) {
            return create(bVar, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.b bVar;
            ao.a i;
            Object f = IntrinsicsKt.f();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.b(obj);
                bVar = (kotlinx.coroutines.flow.b) this.L$0;
                i = this.this$0.i();
                String a = gg.a.a.a();
                String str = this.$postId;
                String str2 = this.$topicType;
                String str3 = this.$rootCommentId;
                String str4 = this.$page;
                String str5 = this.$locCommentId;
                int i3 = this.$perPage;
                this.L$0 = bVar;
                this.label = 1;
                obj = i.g(a, str, str2, str3, str4, str5, i3, this);
                if (obj == f) {
                    return f;
                }
            } else {
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    return Unit.a;
                }
                bVar = (kotlinx.coroutines.flow.b) this.L$0;
                ResultKt.b(obj);
            }
            Object data = ((BaseDto) obj).getData();
            this.L$0 = null;
            this.label = 2;
            if (bVar.emit(data, this) == f) {
                return f;
            }
            return Unit.a;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Lcom/transsion/postdetail/bean/CommentListBean;", BuildConfig.FLAVOR, "it", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.postdetail.viewmodel.CommentViewModel$getCommentList$1$2", f = "CommentViewModel.kt", l = {83}, m = "invokeSuspend")
    /* renamed from: com.transsion.postdetail.viewmodel.CommentViewModel$getCommentList$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.b, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        public final Object invoke(kotlinx.coroutines.flow.b bVar, Throwable th2, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = bVar;
            return anonymousClass2.invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            Object f = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                kotlinx.coroutines.flow.b bVar = (kotlinx.coroutines.flow.b) this.L$0;
                a.a.f(wf.a.a, "CommentViewModel", "getCommentList error", false, 4, (Object) null);
                this.label = 1;
                if (bVar.emit((Object) null, this) == f) {
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

    static final class a implements kotlinx.coroutines.flow.b {
        final /* synthetic */ CommentViewModel a;

        a(CommentViewModel commentViewModel) {
            this.a = commentViewModel;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(CommentListBean commentListBean, Continuation continuation) {
            this.a.k().q(commentListBean);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CommentViewModel$getCommentList$1(CommentViewModel commentViewModel, String str, String str2, String str3, String str4, String str5, int i, Continuation<? super CommentViewModel$getCommentList$1> continuation) {
        super(2, continuation);
        this.this$0 = commentViewModel;
        this.$postId = str;
        this.$topicType = str2;
        this.$rootCommentId = str3;
        this.$page = str4;
        this.$locCommentId = str5;
        this.$perPage = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CommentViewModel$getCommentList$1(this.this$0, this.$postId, this.$topicType, this.$rootCommentId, this.$page, this.$locCommentId, this.$perPage, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.a e = kotlinx.coroutines.flow.c.e(kotlinx.coroutines.flow.c.t(kotlinx.coroutines.flow.c.r(new AnonymousClass1(this.this$0, this.$postId, this.$topicType, this.$rootCommentId, this.$page, this.$locCommentId, this.$perPage, null)), y0.b()), new AnonymousClass2(null));
            a aVar = new a(this.this$0);
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
