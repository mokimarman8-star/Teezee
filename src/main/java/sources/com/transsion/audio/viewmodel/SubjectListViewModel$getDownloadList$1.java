package com.transsion.audio.viewmodel;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsnet.downloader.bean.DownloadListBean;
import cx.a;
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
@DebugMetadata(c = "com.transsion.audio.viewmodel.SubjectListViewModel$getDownloadList$1", f = "SubjectListViewModel.kt", l = {52}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SubjectListViewModel$getDownloadList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $endPosition;
    final /* synthetic */ boolean $loadMore;
    final /* synthetic */ String $nextPage;
    final /* synthetic */ int $pagerMode;
    final /* synthetic */ int $perPage;
    final /* synthetic */ int $startPosition;
    final /* synthetic */ String $subjectId;
    int label;
    final /* synthetic */ SubjectListViewModel this$0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Lcom/transsnet/downloader/bean/DownloadListBean;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.audio.viewmodel.SubjectListViewModel$getDownloadList$1$1", f = "SubjectListViewModel.kt", l = {35, 45, 48}, m = "invokeSuspend")
    /* renamed from: com.transsion.audio.viewmodel.SubjectListViewModel$getDownloadList$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.b, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $endPosition;
        final /* synthetic */ boolean $loadMore;
        final /* synthetic */ String $nextPage;
        final /* synthetic */ int $pagerMode;
        final /* synthetic */ int $perPage;
        final /* synthetic */ int $startPosition;
        final /* synthetic */ String $subjectId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SubjectListViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SubjectListViewModel subjectListViewModel, String str, String str2, int i, int i2, int i3, int i4, boolean z, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = subjectListViewModel;
            this.$subjectId = str;
            this.$nextPage = str2;
            this.$perPage = i;
            this.$startPosition = i2;
            this.$endPosition = i3;
            this.$pagerMode = i4;
            this.$loadMore = z;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$subjectId, this.$nextPage, this.$perPage, this.$startPosition, this.$endPosition, this.$pagerMode, this.$loadMore, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(kotlinx.coroutines.flow.b bVar, Continuation<? super Unit> continuation) {
            return create(bVar, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            cx.a i;
            Object c;
            Object obj2;
            kotlinx.coroutines.flow.b bVar;
            Object f = IntrinsicsKt.f();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.b(obj);
                kotlinx.coroutines.flow.b bVar2 = (kotlinx.coroutines.flow.b) this.L$0;
                i = this.this$0.i();
                String a = gg.a.a.a();
                String str = this.$subjectId;
                String str2 = this.$nextPage;
                int i3 = this.$perPage;
                int i4 = this.$startPosition;
                int i5 = this.$endPosition;
                int i6 = this.$pagerMode;
                this.L$0 = bVar2;
                this.label = 1;
                c = a.a.c(i, a, str, str2, i3, 0, i4, i5, i6, (Integer) null, 0, 0, 0, this, 3856, (Object) null);
                obj2 = f;
                if (c == obj2) {
                    return obj2;
                }
                bVar = bVar2;
            } else {
                if (i2 != 1) {
                    if (i2 != 2 && i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    return Unit.a;
                }
                kotlinx.coroutines.flow.b bVar3 = (kotlinx.coroutines.flow.b) this.L$0;
                ResultKt.b(obj);
                bVar = bVar3;
                obj2 = f;
                c = obj;
            }
            BaseDto baseDto = (BaseDto) c;
            if (Intrinsics.c(baseDto.getCode(), "0")) {
                DownloadListBean downloadListBean = (DownloadListBean) baseDto.getData();
                if (downloadListBean != null) {
                    downloadListBean.setLoadMore(this.$loadMore);
                }
                Object data = baseDto.getData();
                this.L$0 = null;
                this.label = 3;
                if (bVar.emit(data, this) == obj2) {
                    return obj2;
                }
            } else {
                this.L$0 = null;
                this.label = 2;
                if (bVar.emit((Object) null, this) == obj2) {
                    return obj2;
                }
            }
            return Unit.a;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/b;", "Lcom/transsnet/downloader/bean/DownloadListBean;", BuildConfig.FLAVOR, "it", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.audio.viewmodel.SubjectListViewModel$getDownloadList$1$2", f = "SubjectListViewModel.kt", l = {51}, m = "invokeSuspend")
    /* renamed from: com.transsion.audio.viewmodel.SubjectListViewModel$getDownloadList$1$2, reason: invalid class name */
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
        final /* synthetic */ SubjectListViewModel a;

        a(SubjectListViewModel subjectListViewModel) {
            this.a = subjectListViewModel;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(DownloadListBean downloadListBean, Continuation continuation) {
            this.a.f().n(downloadListBean);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubjectListViewModel$getDownloadList$1(SubjectListViewModel subjectListViewModel, String str, String str2, int i, int i2, int i3, int i4, boolean z, Continuation<? super SubjectListViewModel$getDownloadList$1> continuation) {
        super(2, continuation);
        this.this$0 = subjectListViewModel;
        this.$subjectId = str;
        this.$nextPage = str2;
        this.$perPage = i;
        this.$startPosition = i2;
        this.$endPosition = i3;
        this.$pagerMode = i4;
        this.$loadMore = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubjectListViewModel$getDownloadList$1(this.this$0, this.$subjectId, this.$nextPage, this.$perPage, this.$startPosition, this.$endPosition, this.$pagerMode, this.$loadMore, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.a e = kotlinx.coroutines.flow.c.e(kotlinx.coroutines.flow.c.r(new AnonymousClass1(this.this$0, this.$subjectId, this.$nextPage, this.$perPage, this.$startPosition, this.$endPosition, this.$pagerMode, this.$loadMore, null)), new AnonymousClass2(null));
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
