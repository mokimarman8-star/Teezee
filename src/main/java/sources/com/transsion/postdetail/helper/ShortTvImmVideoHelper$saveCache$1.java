package com.transsion.postdetail.helper;

import com.blankj.utilcode.util.o;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.helper.ShortTvImmVideoHelper$saveCache$1", f = "ShortTvImmVideoHelper.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class ShortTvImmVideoHelper$saveCache$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Subject> $videoList;
    int label;
    final /* synthetic */ ShortTvImmVideoHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ShortTvImmVideoHelper$saveCache$1(List<? extends Subject> list, ShortTvImmVideoHelper shortTvImmVideoHelper, Continuation<? super ShortTvImmVideoHelper$saveCache$1> continuation) {
        super(2, continuation);
        this.$videoList = list;
        this.this$0 = shortTvImmVideoHelper;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTvImmVideoHelper$saveCache$1(this.$videoList, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Media video;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        try {
            List<Subject> list = this.$videoList;
            List<Subject> subList = list.subList(list.size() - 1, this.$videoList.size());
            ShortTvImmVideoHelper shortTvImmVideoHelper = this.this$0;
            for (Subject subject : subList) {
                if (subject.isCache()) {
                    return Unit.a;
                }
                subject.setCache(true);
                a.a.f(wf.a.a, "shorttv_detail_video", "save cache", false, 4, (Object) null);
                ShortTVItem shortTVFirstEp = subject.getShortTVFirstEp();
                shortTvImmVideoHelper.u((shortTVFirstEp == null || (video = shortTVFirstEp.getVideo()) == null) ? null : video.getVideoAddress());
            }
            com.transsion.baselib.report.launch.b.a.b().putString("k_save_video", o.j(subList));
        } catch (Exception unused) {
        }
        return Unit.a;
    }
}
