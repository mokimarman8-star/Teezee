package com.transsion.moviedetail.viewmodel;

import androidx.lifecycle.b0;
import com.google.gson.JsonObject;
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
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;
import mg.b;
import okhttp3.RequestBody;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.moviedetail.viewmodel.MovieDetailViewModel$wantToSee$1", f = "MovieDetailViewModel.kt", l = {124}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class MovieDetailViewModel$wantToSee$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ JsonObject $json;
    int label;
    final /* synthetic */ MovieDetailViewModel this$0;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Lcom/tn/lib/net/bean/BaseDto;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.moviedetail.viewmodel.MovieDetailViewModel$wantToSee$1$1", f = "MovieDetailViewModel.kt", l = {118, 119}, m = "invokeSuspend")
    /* renamed from: com.transsion.moviedetail.viewmodel.MovieDetailViewModel$wantToSee$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.b, Continuation<? super Unit>, Object> {
        final /* synthetic */ JsonObject $json;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ MovieDetailViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(JsonObject jsonObject, MovieDetailViewModel movieDetailViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$json = jsonObject;
            this.this$0 = movieDetailViewModel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$json, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(kotlinx.coroutines.flow.b bVar, Continuation<? super Unit> continuation) {
            return create(bVar, continuation).invokeSuspend(Unit.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x006f A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            RequestBody a;
            om.a N;
            kotlinx.coroutines.flow.b bVar;
            Object f = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                kotlinx.coroutines.flow.b bVar2 = (kotlinx.coroutines.flow.b) this.L$0;
                b.a aVar = mg.b.a;
                String jsonElement = this.$json.toString();
                Intrinsics.g(jsonElement, "toString(...)");
                a = aVar.a(jsonElement);
                if (a != null) {
                    N = this.this$0.N();
                    String a2 = gg.a.a.a();
                    this.L$0 = bVar2;
                    this.L$1 = a;
                    this.label = 1;
                    Object c = N.c(a2, a, this);
                    if (c == f) {
                        return f;
                    }
                    bVar = bVar2;
                    obj = c;
                    this.L$0 = a;
                    this.L$1 = null;
                    this.label = 2;
                    if (bVar.emit((BaseDto) obj, this) == f) {
                    }
                }
            } else if (i == 1) {
                a = (RequestBody) this.L$1;
                bVar = (kotlinx.coroutines.flow.b) this.L$0;
                ResultKt.b(obj);
                this.L$0 = a;
                this.L$1 = null;
                this.label = 2;
                if (bVar.emit((BaseDto) obj, this) == f) {
                    return f;
                }
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.a;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Lcom/tn/lib/net/bean/BaseDto;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "it", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.moviedetail.viewmodel.MovieDetailViewModel$wantToSee$1$2", f = "MovieDetailViewModel.kt", l = {123}, m = "invokeSuspend")
    /* renamed from: com.transsion.moviedetail.viewmodel.MovieDetailViewModel$wantToSee$1$2, reason: invalid class name */
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
                a.a.f(wf.a.a, "MovieDetailViewModel", "failed", false, 4, (Object) null);
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
        public final Object emit(BaseDto baseDto, Continuation continuation) {
            b0 R;
            a.a.f(wf.a.a, "MovieDetailViewModel", "end", false, 4, (Object) null);
            R = this.a.R();
            R.q(baseDto);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MovieDetailViewModel$wantToSee$1(JsonObject jsonObject, MovieDetailViewModel movieDetailViewModel, Continuation<? super MovieDetailViewModel$wantToSee$1> continuation) {
        super(2, continuation);
        this.$json = jsonObject;
        this.this$0 = movieDetailViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MovieDetailViewModel$wantToSee$1(this.$json, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.a e = kotlinx.coroutines.flow.c.e(kotlinx.coroutines.flow.c.t(kotlinx.coroutines.flow.c.r(new AnonymousClass1(this.$json, this.this$0, null)), y0.b()), new AnonymousClass2(null));
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
