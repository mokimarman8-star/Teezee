package com.transsion.postdetail.viewmodel;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.flow.bean.CommentBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.postdetail.bean.CommentBody;
import com.transsion.postdetailapi.CommentTopicType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;
import mg.b;
import okhttp3.RequestBody;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.viewmodel.CommentViewModel$postComment$1", f = "CommentViewModel.kt", l = {60}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class CommentViewModel$postComment$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ CommentBody $commentBody;
    final /* synthetic */ String $topicType;
    int label;
    final /* synthetic */ CommentViewModel this$0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Lcom/transsion/moviedetailapi/bean/CommentBean;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.postdetail.viewmodel.CommentViewModel$postComment$1$1", f = "CommentViewModel.kt", l = {49, 51, 53}, m = "invokeSuspend")
    /* renamed from: com.transsion.postdetail.viewmodel.CommentViewModel$postComment$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.b, Continuation<? super Unit>, Object> {
        final /* synthetic */ CommentBody $commentBody;
        final /* synthetic */ String $topicType;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ CommentViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CommentBody commentBody, String str, CommentViewModel commentViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$commentBody = commentBody;
            this.$topicType = str;
            this.this$0 = commentViewModel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$commentBody, this.$topicType, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(kotlinx.coroutines.flow.b bVar, Continuation<? super Unit> continuation) {
            return create(bVar, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            RequestBody a;
            ao.a i;
            kotlinx.coroutines.flow.b bVar;
            ao.a i2;
            BaseDto baseDto;
            Object f = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                kotlinx.coroutines.flow.b bVar2 = (kotlinx.coroutines.flow.b) this.L$0;
                b.a aVar = mg.b.a;
                String j = com.blankj.utilcode.util.o.j(this.$commentBody);
                Intrinsics.g(j, "toJson(...)");
                a = aVar.a(j);
                if (a != null) {
                    String str = this.$topicType;
                    CommentViewModel commentViewModel = this.this$0;
                    if (Intrinsics.c(str, CommentTopicType.POST.getValue())) {
                        i2 = commentViewModel.i();
                        String a2 = gg.a.a.a();
                        this.L$0 = bVar2;
                        this.L$1 = a;
                        this.label = 1;
                        Object b = i2.b(a2, a, this);
                        if (b == f) {
                            return f;
                        }
                        bVar = bVar2;
                        obj = b;
                        baseDto = (BaseDto) obj;
                    } else {
                        i = commentViewModel.i();
                        String a3 = gg.a.a.a();
                        this.L$0 = bVar2;
                        this.L$1 = a;
                        this.label = 2;
                        Object e = i.e(a3, a, this);
                        if (e == f) {
                            return f;
                        }
                        bVar = bVar2;
                        obj = e;
                        baseDto = (BaseDto) obj;
                    }
                }
                return Unit.a;
            }
            if (i3 == 1) {
                a = (RequestBody) this.L$1;
                bVar = (kotlinx.coroutines.flow.b) this.L$0;
                ResultKt.b(obj);
                baseDto = (BaseDto) obj;
            } else {
                if (i3 != 2) {
                    if (i3 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    return Unit.a;
                }
                a = (RequestBody) this.L$1;
                bVar = (kotlinx.coroutines.flow.b) this.L$0;
                ResultKt.b(obj);
                baseDto = (BaseDto) obj;
            }
            Object data = baseDto.getData();
            this.L$0 = a;
            this.L$1 = null;
            this.label = 3;
            if (bVar.emit(data, this) == f) {
                return f;
            }
            return Unit.a;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Lcom/transsion/moviedetailapi/bean/CommentBean;", BuildConfig.FLAVOR, "it", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.postdetail.viewmodel.CommentViewModel$postComment$1$2", f = "CommentViewModel.kt", l = {58}, m = "invokeSuspend")
    /* renamed from: com.transsion.postdetail.viewmodel.CommentViewModel$postComment$1$2, reason: invalid class name */
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
                a.a.f(wf.a.a, "CommentViewModel", "post comment error", false, 4, (Object) null);
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
        public final Object emit(CommentBean commentBean, Continuation continuation) {
            this.a.n().q(commentBean);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CommentViewModel$postComment$1(CommentBody commentBody, String str, CommentViewModel commentViewModel, Continuation<? super CommentViewModel$postComment$1> continuation) {
        super(2, continuation);
        this.$commentBody = commentBody;
        this.$topicType = str;
        this.this$0 = commentViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CommentViewModel$postComment$1(this.$commentBody, this.$topicType, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.a e = kotlinx.coroutines.flow.c.e(kotlinx.coroutines.flow.c.t(kotlinx.coroutines.flow.c.r(new AnonymousClass1(this.$commentBody, this.$topicType, this.this$0, null)), y0.b()), new AnonymousClass2(null));
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
