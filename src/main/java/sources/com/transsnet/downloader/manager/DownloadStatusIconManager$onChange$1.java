package com.transsnet.downloader.manager;

import com.transsnet.downloader.callback.DownloadTaskStat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.manager.DownloadStatusIconManager$onChange$1", f = "DownloadStatusIconManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
final class DownloadStatusIconManager$onChange$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadTaskStat $downloadTaskStat;
    int label;
    final /* synthetic */ DownloadStatusIconManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadStatusIconManager$onChange$1(DownloadStatusIconManager downloadStatusIconManager, DownloadTaskStat downloadTaskStat, Continuation<? super DownloadStatusIconManager$onChange$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadStatusIconManager;
        this.$downloadTaskStat = downloadTaskStat;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadStatusIconManager$onChange$1(this.this$0, this.$downloadTaskStat, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadStatusIconManager$onChange$1) create(n0Var, continuation)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        this.this$0.e = this.$downloadTaskStat.getLoadingCount();
        this.this$0.c = this.$downloadTaskStat.getErrorCount();
        this.this$0.d = this.$downloadTaskStat.getDoneCount();
        this.this$0.f = this.$downloadTaskStat.getWaitCount();
        z = this.this$0.g;
        if (z) {
            this.this$0.d = 0;
        }
        i = this.this$0.e;
        i2 = this.this$0.f;
        int i20 = i + i2;
        a.a aVar = wf.a.a;
        i3 = this.this$0.c;
        i4 = this.this$0.d;
        i6 = this.this$0.e;
        a.a.f(aVar, "DownloadStatus", "on download change, errorCount = " + i3 + ", doneCount = " + i4 + ", loadingCount = " + i6 + ",  waitCount = " + this.$downloadTaskStat.getWaitCount(), false, 4, (Object) null);
        if (yg.l.a.e()) {
            i7 = this.this$0.c;
            if (i7 > 0) {
                DownloadStatusIconManager downloadStatusIconManager = this.this$0;
                i13 = downloadStatusIconManager.e;
                DownloadStatusIconManager.u(downloadStatusIconManager, i13 > 0 ? 3 : 2, 0, 2, null);
            } else if (i20 > 0) {
                DownloadStatusIconManager downloadStatusIconManager2 = this.this$0;
                i12 = downloadStatusIconManager2.e;
                downloadStatusIconManager2.t(i12 > 0 ? 5 : 4, i20);
            } else {
                i8 = this.this$0.d;
                if (i8 > 0) {
                    DownloadStatusIconManager.u(this.this$0, 1, 0, 2, null);
                } else {
                    i9 = this.this$0.c;
                    if (i9 == 0) {
                        i10 = this.this$0.d;
                        if (i10 == 0) {
                            i11 = this.this$0.e;
                            if (i11 == 0) {
                                DownloadStatusIconManager.u(this.this$0, 0, 0, 2, null);
                            }
                        }
                    }
                }
            }
            return Unit.a;
        }
        i14 = this.this$0.f;
        if (i14 > 0) {
            i19 = this.this$0.c;
            if (i19 == 0) {
                this.this$0.t(4, i20);
                a.a.f(aVar, "DownloadStatus", "no net, show error~", false, 4, (Object) null);
                return Unit.a;
            }
        }
        DownloadStatusIconManager downloadStatusIconManager3 = this.this$0;
        i15 = downloadStatusIconManager3.c;
        if (i15 == 0) {
            i17 = this.this$0.d;
            if (i17 == 0) {
                i18 = this.this$0.e;
                if (i18 == 0) {
                    i16 = 0;
                    DownloadStatusIconManager.u(downloadStatusIconManager3, i16, 0, 2, null);
                    a.a.f(aVar, "DownloadStatus", "no net, show error~", false, 4, (Object) null);
                    return Unit.a;
                }
            }
        }
        i16 = 2;
        DownloadStatusIconManager.u(downloadStatusIconManager3, i16, 0, 2, null);
        a.a.f(aVar, "DownloadStatus", "no net, show error~", false, 4, (Object) null);
        return Unit.a;
    }
}
