package com.transsion.shorttv.subtitle;

import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.viewmodel.ShortTvViewModel;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import nr.e;
import ur.h;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.shorttv.subtitle.ShortTVSubtitleControlImp$selectSubtitle$6", f = "ShortTVSubtitleControlImp.kt", l = {446}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class ShortTVSubtitleControlImp$selectSubtitle$6 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ xr.b $bean;
    int label;
    final /* synthetic */ ShortTVSubtitleControlImp this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ShortTVSubtitleControlImp$selectSubtitle$6(xr.b bVar, ShortTVSubtitleControlImp shortTVSubtitleControlImp, Continuation<? super ShortTVSubtitleControlImp$selectSubtitle$6> continuation) {
        super(2, continuation);
        this.$bean = bVar;
        this.this$0 = shortTVSubtitleControlImp;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTVSubtitleControlImp$selectSubtitle$6(this.$bean, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
    
        r3 = (r1 = r4.this$0).d;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SubtitleDownloadTable a;
        String id;
        ShortTVSubtitleControlImp shortTVSubtitleControlImp;
        ShortTvViewModel shortTvViewModel;
        h A0;
        e eVar;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            xr.b bVar = this.$bean;
            if (bVar != null && (a = bVar.a()) != null && (id = a.getId()) != null && shortTvViewModel != null && (A0 = shortTvViewModel.A0()) != null) {
                eVar = shortTVSubtitleControlImp.e;
                String e = eVar.e();
                this.label = 1;
                if (A0.b(e, id, this) == f) {
                    return f;
                }
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
