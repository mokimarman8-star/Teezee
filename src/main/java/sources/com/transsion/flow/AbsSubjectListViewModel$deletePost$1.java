package com.transsion.flow;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
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
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.n0;
import okhttp3.RequestBody;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.moviedetailapi.AbsSubjectListViewModel$deletePost$1", f = "AbsSubjectListViewModel.kt", l = {147}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class AbsSubjectListViewModel$deletePost$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $postId;
    int label;
    final /* synthetic */ AbsSubjectListViewModel this$0;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Lcom/tn/lib/net/bean/BaseDto;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.moviedetailapi.AbsSubjectListViewModel$deletePost$1$1", f = "AbsSubjectListViewModel.kt", l = {141, 143}, m = "invokeSuspend")
    /* renamed from: com.transsion.moviedetailapi.AbsSubjectListViewModel$deletePost$1$1, reason: from Kotlin metadata */
    static final class b extends SuspendLambda implements Function2<kotlinx.coroutines.flow.b, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $postId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AbsSubjectListViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, AbsSubjectListViewModel absSubjectListViewModel, Continuation<? super b> continuation) {
            super(2, continuation);
            this.$postId = str;
            this.this$0 = absSubjectListViewModel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            b bVar = new b(this.$postId, this.this$0, continuation);
            bVar.L$0 = obj;
            return bVar;
        }

        public final Object invoke(kotlinx.coroutines.flow.b bVar, Continuation<? super Unit> continuation) {
            return create(bVar, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.b bVar;
            Object f = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                bVar = (kotlinx.coroutines.flow.b) this.L$0;
                RequestBody a = mg.b.a.a("{\"postId\": \"" + this.$postId + "\"}");
                tm.a i2 = AbsSubjectListViewModel.i(this.this$0);
                String a2 = gg.a.a.a();
                Intrinsics.e(a);
                this.L$0 = bVar;
                this.label = 1;
                obj = i2.b(a2, a, this);
                if (obj == f) {
                    return f;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    return Unit.a;
                }
                bVar = (kotlinx.coroutines.flow.b) this.L$0;
                ResultKt.b(obj);
            }
            BaseDto baseDto = (BaseDto) obj;
            if (baseDto != null) {
                baseDto.setData(this.$postId);
            }
            this.L$0 = null;
            this.label = 2;
            if (bVar.emit(baseDto, this) == f) {
                return f;
            }
            return Unit.a;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Lcom/tn/lib/net/bean/BaseDto;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "it", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.moviedetailapi.AbsSubjectListViewModel$deletePost$1$2", f = "AbsSubjectListViewModel.kt", l = {146}, m = "invokeSuspend")
    /* renamed from: com.transsion.moviedetailapi.AbsSubjectListViewModel$deletePost$1$2, reason: from Kotlin metadata and case insensitive filesystem */
    static final class C01072 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.b, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        C01072(Continuation<? super C01072> continuation) {
            super(3, continuation);
        }

        public final Object invoke(kotlinx.coroutines.flow.b bVar, Throwable th2, Continuation<? super Unit> continuation) {
            C01072 c01072 = new C01072(continuation);
            c01072.L$0 = bVar;
            c01072.L$1 = th2;
            return c01072.invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            Object f = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                kotlinx.coroutines.flow.b bVar = (kotlinx.coroutines.flow.b) this.L$0;
                Throwable th2 = (Throwable) this.L$1;
                a.a.f(wf.a.a, "AbsSubjectListViewModel", "deletePost " + th2, false, 4, (Object) null);
                this.L$0 = null;
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
        final /* synthetic */ AbsSubjectListViewModel a;

        a(AbsSubjectListViewModel absSubjectListViewModel) {
            this.a = absSubjectListViewModel;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(BaseDto baseDto, Continuation continuation) {
            this.a.p().q(baseDto);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AbsSubjectListViewModel$deletePost$1(String str, AbsSubjectListViewModel absSubjectListViewModel, Continuation<? super AbsSubjectListViewModel$deletePost$1> continuation) {
        super(2, continuation);
        this.$postId = str;
        this.this$0 = absSubjectListViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AbsSubjectListViewModel$deletePost$1(this.$postId, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.a e = c.e(c.r(new b(this.$postId, this.this$0, null)), new C01072(null));
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
