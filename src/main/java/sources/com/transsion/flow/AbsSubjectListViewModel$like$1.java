package com.transsion.flow;

import com.google.gson.JsonObject;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.flow.bean.LikeBean;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;
import mg.b;
import okhttp3.RequestBody;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.moviedetailapi.AbsSubjectListViewModel$like$1", f = "AbsSubjectListViewModel.kt", l = {129}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class AbsSubjectListViewModel$like$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $postId;
    final /* synthetic */ int $reqType;
    int label;
    final /* synthetic */ AbsSubjectListViewModel this$0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Lcom/transsion/moviedetailapi/bean/LikeBean;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.moviedetailapi.AbsSubjectListViewModel$like$1$1", f = "AbsSubjectListViewModel.kt", l = {121, 123}, m = "invokeSuspend")
    /* renamed from: com.transsion.moviedetailapi.AbsSubjectListViewModel$like$1$1, reason: from Kotlin metadata */
    static final class b extends SuspendLambda implements Function2<kotlinx.coroutines.flow.b, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $postId;
        final /* synthetic */ int $reqType;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ AbsSubjectListViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, int i, AbsSubjectListViewModel absSubjectListViewModel, Continuation<? super b> continuation) {
            super(2, continuation);
            this.$postId = str;
            this.$reqType = i;
            this.this$0 = absSubjectListViewModel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            b bVar = new b(this.$postId, this.$reqType, this.this$0, continuation);
            bVar.L$0 = obj;
            return bVar;
        }

        public final Object invoke(kotlinx.coroutines.flow.b bVar, Continuation<? super Unit> continuation) {
            return create(bVar, continuation).invokeSuspend(Unit.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x00a3 A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.b bVar;
            String str;
            LikeBean likeBean;
            Object data;
            Object f = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                kotlinx.coroutines.flow.b bVar2 = (kotlinx.coroutines.flow.b) this.L$0;
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("postId", this.$postId);
                jsonObject.addProperty("reqType", Boxing.d(this.$reqType));
                if (this.$postId != null) {
                    gx.b.a.a().g(this.$reqType, this.$postId);
                }
                b.a aVar = mg.b.a;
                String jsonElement = jsonObject.toString();
                Intrinsics.g(jsonElement, "toString(...)");
                RequestBody a = aVar.a(jsonElement);
                if (a != null) {
                    AbsSubjectListViewModel absSubjectListViewModel = this.this$0;
                    String str2 = this.$postId;
                    tm.a i2 = AbsSubjectListViewModel.i(absSubjectListViewModel);
                    String a2 = gg.a.a.a();
                    this.L$0 = bVar2;
                    this.L$1 = str2;
                    this.label = 1;
                    Object a3 = i2.a(a2, a, this);
                    if (a3 == f) {
                        return f;
                    }
                    bVar = bVar2;
                    obj = a3;
                    str = str2;
                    BaseDto baseDto = (BaseDto) obj;
                    likeBean = (LikeBean) baseDto.getData();
                    if (likeBean != null) {
                    }
                    data = baseDto.getData();
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 2;
                    if (bVar.emit(data, this) == f) {
                    }
                }
            } else if (i == 1) {
                str = (String) this.L$1;
                bVar = (kotlinx.coroutines.flow.b) this.L$0;
                ResultKt.b(obj);
                BaseDto baseDto2 = (BaseDto) obj;
                likeBean = (LikeBean) baseDto2.getData();
                if (likeBean != null) {
                    likeBean.setPostId(str);
                }
                data = baseDto2.getData();
                this.L$0 = null;
                this.L$1 = null;
                this.label = 2;
                if (bVar.emit(data, this) == f) {
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

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Lcom/transsion/moviedetailapi/bean/LikeBean;", BuildConfig.FLAVOR, "it", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.moviedetailapi.AbsSubjectListViewModel$like$1$2", f = "AbsSubjectListViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.moviedetailapi.AbsSubjectListViewModel$like$1$2, reason: from Kotlin metadata and case insensitive filesystem */
    static final class C01082 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.b, Throwable, Continuation<? super Unit>, Object> {
        int label;

        C01082(Continuation<? super C01082> continuation) {
            super(3, continuation);
        }

        public final Object invoke(kotlinx.coroutines.flow.b bVar, Throwable th2, Continuation<? super Unit> continuation) {
            return new C01082(continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            a.a.g(wf.a.a, "like error", false, 2, (Object) null);
            return Unit.a;
        }
    }

    static final class a implements kotlinx.coroutines.flow.b {
        public static final a a = new a();

        a() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(LikeBean likeBean, Continuation continuation) {
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AbsSubjectListViewModel$like$1(String str, int i, AbsSubjectListViewModel absSubjectListViewModel, Continuation<? super AbsSubjectListViewModel$like$1> continuation) {
        super(2, continuation);
        this.$postId = str;
        this.$reqType = i;
        this.this$0 = absSubjectListViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AbsSubjectListViewModel$like$1(this.$postId, this.$reqType, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.a e = c.e(c.t(c.r(new b(this.$postId, this.$reqType, this.this$0, null)), y0.b()), new C01082(null));
            a aVar = a.a;
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
