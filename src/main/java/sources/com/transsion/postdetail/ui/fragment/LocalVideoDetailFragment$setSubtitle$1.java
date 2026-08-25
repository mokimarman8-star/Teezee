package com.transsion.postdetail.ui.fragment;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.gslb.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$setSubtitle$1", f = "LocalVideoDetailFragment.kt", l = {1413, 1419}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class LocalVideoDetailFragment$setSubtitle$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ LocalVideoDetailFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LocalVideoDetailFragment$setSubtitle$1(LocalVideoDetailFragment localVideoDetailFragment, Continuation<? super LocalVideoDetailFragment$setSubtitle$1> continuation) {
        super(2, continuation);
        this.this$0 = localVideoDetailFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalVideoDetailFragment$setSubtitle$1(this.this$0, continuation);
    }

    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        DownloadBean downloadBean;
        LocalVideoDetailFragment localVideoDetailFragment;
        kotlinx.coroutines.a2 c;
        LocalVideoDetailFragment$setSubtitle$1$1$1 localVideoDetailFragment$setSubtitle$1$1$1;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            downloadBean = this.this$0.downloadBean;
            if (downloadBean != null) {
                localVideoDetailFragment = this.this$0;
                com.transsion.subtitle.h b = com.transsion.subtitle.h.a.b();
                String subtitleResId = downloadBean.getSubtitleResId();
                this.L$0 = localVideoDetailFragment;
                this.L$1 = downloadBean;
                this.label = 1;
                obj = b.a(subtitleResId, this);
                if (obj == f) {
                    return f;
                }
                List list = (List) obj;
                if (list == null) {
                }
                wf.a.a.p(com.transsion.baselib.report.a.a.a(), new String[]{"----- setSubtitle, name:" + downloadBean.getTotalTitleName() + ", subtitleResId:" + downloadBean.getSubtitleResId() + ", size = " + (list == null ? Boxing.d(list.size()) : null)}, true);
                c = kotlinx.coroutines.y0.c();
                localVideoDetailFragment$setSubtitle$1$1$1 = new LocalVideoDetailFragment$setSubtitle$1$1$1(list, localVideoDetailFragment, downloadBean, null);
                this.L$0 = null;
                this.L$1 = null;
                this.label = 2;
                if (kotlinx.coroutines.i.g(c, localVideoDetailFragment$setSubtitle$1$1$1, this) == f) {
                }
            }
        } else if (i == 1) {
            downloadBean = (DownloadBean) this.L$1;
            localVideoDetailFragment = (LocalVideoDetailFragment) this.L$0;
            ResultKt.b(obj);
            List list2 = (List) obj;
            wf.a.a.p(com.transsion.baselib.report.a.a.a(), new String[]{"----- setSubtitle, name:" + downloadBean.getTotalTitleName() + ", subtitleResId:" + downloadBean.getSubtitleResId() + ", size = " + (list2 == null ? Boxing.d(list2.size()) : null)}, true);
            c = kotlinx.coroutines.y0.c();
            localVideoDetailFragment$setSubtitle$1$1$1 = new LocalVideoDetailFragment$setSubtitle$1$1$1(list2, localVideoDetailFragment, downloadBean, null);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
            if (kotlinx.coroutines.i.g(c, localVideoDetailFragment$setSubtitle$1$1$1, this) == f) {
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
