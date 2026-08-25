package com.transsion.postdetail.ui.view;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.gslb.BuildConfig;
import com.transsnet.downloader.manager.DownloadEsHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.ui.view.ImmVideoItemView$saveBuiltInVideo$1", f = "ImmVideoItemView.kt", l = {1569, 1570}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class ImmVideoItemView$saveBuiltInVideo$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadBean $download;
    int label;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.postdetail.ui.view.ImmVideoItemView$saveBuiltInVideo$1$1", f = "ImmVideoItemView.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.postdetail.ui.view.ImmVideoItemView$saveBuiltInVideo$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            fh.b.a.e("download success~");
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ImmVideoItemView$saveBuiltInVideo$1(DownloadBean downloadBean, Continuation<? super ImmVideoItemView$saveBuiltInVideo$1> continuation) {
        super(2, continuation);
        this.$download = downloadBean;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImmVideoItemView$saveBuiltInVideo$1(this.$download, continuation);
    }

    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            DownloadBean downloadBean = this.$download;
            downloadBean.setPath(downloadBean.getUrl());
            this.$download.setStatus(5);
            DownloadEsHelper a = DownloadEsHelper.m.a();
            DownloadBean downloadBean2 = this.$download;
            this.label = 1;
            if (a.T(downloadBean2, this) == f) {
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
            ResultKt.b(obj);
        }
        kotlinx.coroutines.a2 c = kotlinx.coroutines.y0.c();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
        this.label = 2;
        if (kotlinx.coroutines.i.g(c, anonymousClass1, this) == f) {
            return f;
        }
        return Unit.a;
    }
}
