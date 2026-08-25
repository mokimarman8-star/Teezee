package com.transsion.postdetail.viewmodel;

import androidx.lifecycle.b0;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.flow.bean.PostSubjectBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import java.util.Iterator;
import java.util.List;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.viewmodel.RoomPostViewModel$getPostNearby$1", f = "RoomPostViewModel.kt", l = {302}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class RoomPostViewModel$getPostNearby$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isRefresh;
    final /* synthetic */ double $lat;
    final /* synthetic */ double $lon;
    final /* synthetic */ String $page;
    final /* synthetic */ int $perPage;
    int label;
    final /* synthetic */ RoomPostViewModel this$0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Lcom/transsion/moviedetailapi/bean/PostSubjectBean;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.postdetail.viewmodel.RoomPostViewModel$getPostNearby$1$1", f = "RoomPostViewModel.kt", l = {294, 296, 298}, m = "invokeSuspend")
    /* renamed from: com.transsion.postdetail.viewmodel.RoomPostViewModel$getPostNearby$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.b, Continuation<? super Unit>, Object> {
        final /* synthetic */ double $lat;
        final /* synthetic */ double $lon;
        final /* synthetic */ String $page;
        final /* synthetic */ int $perPage;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RoomPostViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RoomPostViewModel roomPostViewModel, String str, int i, double d, double d2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = roomPostViewModel;
            this.$page = str;
            this.$perPage = i;
            this.$lon = d;
            this.$lat = d2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$page, this.$perPage, this.$lon, this.$lat, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(kotlinx.coroutines.flow.b bVar, Continuation<? super Unit> continuation) {
            return create(bVar, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.b bVar;
            ao.c M;
            Object f = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                bVar = (kotlinx.coroutines.flow.b) this.L$0;
                M = this.this$0.M();
                String a = gg.a.a.a();
                String str = this.$page;
                int i2 = this.$perPage;
                double d = this.$lon;
                double d2 = this.$lat;
                this.L$0 = bVar;
                this.label = 1;
                obj = M.d(a, str, i2, d, d2, this);
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
            BaseDto baseDto = (BaseDto) obj;
            if (Intrinsics.c(baseDto.getCode(), "0")) {
                Object data = baseDto.getData();
                this.L$0 = null;
                this.label = 3;
                if (bVar.emit(data, this) == f) {
                    return f;
                }
            } else {
                this.L$0 = null;
                this.label = 2;
                if (bVar.emit((Object) null, this) == f) {
                    return f;
                }
            }
            return Unit.a;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Lcom/transsion/moviedetailapi/bean/PostSubjectBean;", BuildConfig.FLAVOR, "it", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.postdetail.viewmodel.RoomPostViewModel$getPostNearby$1$2", f = "RoomPostViewModel.kt", l = {301}, m = "invokeSuspend")
    /* renamed from: com.transsion.postdetail.viewmodel.RoomPostViewModel$getPostNearby$1$2, reason: invalid class name */
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
        final /* synthetic */ boolean a;
        final /* synthetic */ RoomPostViewModel b;
        final /* synthetic */ double c;
        final /* synthetic */ double d;

        a(boolean z, RoomPostViewModel roomPostViewModel, double d, double d2) {
            this.a = z;
            this.b = roomPostViewModel;
            this.c = d;
            this.d = d2;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(PostSubjectBean postSubjectBean, Continuation continuation) {
            b0 b0Var;
            List<PostSubjectItem> items;
            Iterator it;
            if (postSubjectBean != null) {
                postSubjectBean.setRefresh(this.a);
            }
            if (postSubjectBean != null && (items = postSubjectBean.getItems()) != null) {
                double d = this.c;
                double d2 = this.d;
                Iterator it2 = items.iterator();
                while (it2.hasNext()) {
                    PostSubjectItem postSubjectItem = (PostSubjectItem) it2.next();
                    if (postSubjectItem.getLat() == null || postSubjectItem.getLon() == null) {
                        it = it2;
                    } else {
                        ij.s sVar = ij.s.a;
                        Float lat = postSubjectItem.getLat();
                        Intrinsics.e(lat);
                        double floatValue = lat.floatValue();
                        Intrinsics.e(postSubjectItem.getLon());
                        it = it2;
                        postSubjectItem.setDistanceStr(sVar.a(d, d2, floatValue, r4.floatValue()));
                    }
                    it2 = it;
                }
            }
            b0Var = this.b.f;
            b0Var.n(postSubjectBean);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RoomPostViewModel$getPostNearby$1(RoomPostViewModel roomPostViewModel, String str, int i, double d, double d2, boolean z, Continuation<? super RoomPostViewModel$getPostNearby$1> continuation) {
        super(2, continuation);
        this.this$0 = roomPostViewModel;
        this.$page = str;
        this.$perPage = i;
        this.$lon = d;
        this.$lat = d2;
        this.$isRefresh = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RoomPostViewModel$getPostNearby$1(this.this$0, this.$page, this.$perPage, this.$lon, this.$lat, this.$isRefresh, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.a e = kotlinx.coroutines.flow.c.e(kotlinx.coroutines.flow.c.r(new AnonymousClass1(this.this$0, this.$page, this.$perPage, this.$lon, this.$lat, null)), new AnonymousClass2(null));
            a aVar = new a(this.$isRefresh, this.this$0, this.$lat, this.$lon);
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
