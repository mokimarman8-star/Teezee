package com.transsion.moviedetail.viewmodel;

import com.google.gson.JsonObject;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.publish.model.PostEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import mg.b;
import okhttp3.RequestBody;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.moviedetail.viewmodel.MovieDetailViewModel$postRequestResource$1", f = "MovieDetailViewModel.kt", l = {259}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class MovieDetailViewModel$postRequestResource$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $before;
    final /* synthetic */ String $subjectId;
    int label;
    final /* synthetic */ MovieDetailViewModel this$0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Lcom/transsion/publish/model/PostEntity;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.moviedetail.viewmodel.MovieDetailViewModel$postRequestResource$1$1", f = "MovieDetailViewModel.kt", l = {251, 253, 255}, m = "invokeSuspend")
    @SourceDebugExtension
    /* renamed from: com.transsion.moviedetail.viewmodel.MovieDetailViewModel$postRequestResource$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.b, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $before;
        final /* synthetic */ String $subjectId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MovieDetailViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, boolean z, MovieDetailViewModel movieDetailViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$subjectId = str;
            this.$before = z;
            this.this$0 = movieDetailViewModel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$subjectId, this.$before, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(kotlinx.coroutines.flow.b bVar, Continuation<? super Unit> continuation) {
            return create(bVar, continuation).invokeSuspend(Unit.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x007a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.b bVar;
            BaseDto baseDto;
            om.a N;
            Object f = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                bVar = (kotlinx.coroutines.flow.b) this.L$0;
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("subjectId", this.$subjectId);
                jsonObject.addProperty("before", Boxing.a(this.$before));
                b.a aVar = mg.b.a;
                String jsonElement = jsonObject.toString();
                Intrinsics.g(jsonElement, "toString(...)");
                RequestBody a = aVar.a(jsonElement);
                if (a == null) {
                    baseDto = null;
                    if (Intrinsics.c(baseDto == null ? baseDto.getCode() : null, "0")) {
                        this.L$0 = null;
                        this.label = 2;
                        if (bVar.emit((Object) null, this) == f) {
                            return f;
                        }
                    } else {
                        Object data = baseDto.getData();
                        this.L$0 = null;
                        this.label = 3;
                        if (bVar.emit(data, this) == f) {
                            return f;
                        }
                    }
                    return Unit.a;
                }
                N = this.this$0.N();
                String a2 = gg.a.a.a();
                this.L$0 = bVar;
                this.label = 1;
                obj = N.f(a2, a, this);
                if (obj == f) {
                    return f;
                }
            } else {
                if (i != 1) {
                    if (i != 2 && i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    return Unit.a;
                }
                bVar = (kotlinx.coroutines.flow.b) this.L$0;
                ResultKt.b(obj);
            }
            baseDto = (BaseDto) obj;
            if (Intrinsics.c(baseDto == null ? baseDto.getCode() : null, "0")) {
            }
            return Unit.a;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Lcom/transsion/publish/model/PostEntity;", BuildConfig.FLAVOR, "it", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.moviedetail.viewmodel.MovieDetailViewModel$postRequestResource$1$2", f = "MovieDetailViewModel.kt", l = {258}, m = "invokeSuspend")
    /* renamed from: com.transsion.moviedetail.viewmodel.MovieDetailViewModel$postRequestResource$1$2, reason: invalid class name */
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
        final /* synthetic */ MovieDetailViewModel a;

        a(MovieDetailViewModel movieDetailViewModel) {
            this.a = movieDetailViewModel;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(PostEntity postEntity, Continuation continuation) {
            this.a.H().n(postEntity);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MovieDetailViewModel$postRequestResource$1(String str, boolean z, MovieDetailViewModel movieDetailViewModel, Continuation<? super MovieDetailViewModel$postRequestResource$1> continuation) {
        super(2, continuation);
        this.$subjectId = str;
        this.$before = z;
        this.this$0 = movieDetailViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MovieDetailViewModel$postRequestResource$1(this.$subjectId, this.$before, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.a e = kotlinx.coroutines.flow.c.e(kotlinx.coroutines.flow.c.r(new AnonymousClass1(this.$subjectId, this.$before, this.this$0, null)), new AnonymousClass2(null));
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
