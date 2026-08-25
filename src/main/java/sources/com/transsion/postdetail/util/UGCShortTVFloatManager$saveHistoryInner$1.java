package com.transsion.postdetail.util;

import com.transsion.baselib.db.video.UGCVideoDetailPlayDao;
import com.transsion.gslb.BuildConfig;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoBelongToCollection;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.util.UGCShortTVFloatManager$saveHistoryInner$1", f = "UGCShortTVFloatManager.kt", l = {59, 63}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class UGCShortTVFloatManager$saveHistoryInner$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callback;
    final /* synthetic */ dw.a $floatBean;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UGCShortTVFloatManager$saveHistoryInner$1(dw.a aVar, Function0<Unit> function0, Continuation<? super UGCShortTVFloatManager$saveHistoryInner$1> continuation) {
        super(2, continuation);
        this.$floatBean = aVar;
        this.$callback = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        UGCShortTVFloatManager$saveHistoryInner$1 uGCShortTVFloatManager$saveHistoryInner$1 = new UGCShortTVFloatManager$saveHistoryInner$1(this.$floatBean, this.$callback, continuation);
        uGCShortTVFloatManager$saveHistoryInner$1.L$0 = obj;
        return uGCShortTVFloatManager$saveHistoryInner$1;
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00d0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0085 A[Catch: all -> 0x0024, TryCatch #0 {all -> 0x0024, blocks: (B:13:0x001f, B:14:0x00a1, B:22:0x005f, B:24:0x006b, B:26:0x0071, B:30:0x007f, B:32:0x0085, B:34:0x008b, B:37:0x007a), top: B:2:0x0008 }] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlin.jvm.functions.Function0] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, kotlin.jvm.functions.Function0<kotlin.Unit>] */
    /* JADX WARN: Type inference failed for: r1v6, types: [kotlin.jvm.functions.Function0] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ?? r1;
        a2 c;
        UGCShortTVFloatManager$saveHistoryInner$1$1$2 uGCShortTVFloatManager$saveHistoryInner$1$1$2;
        String r;
        UGCVideo v;
        UGCVideoDetailPlayDao i;
        Object f = IntrinsicsKt.f();
        int i2 = this.label;
        try {
        } catch (Throwable th2) {
            Result.Companion companion = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
            r1 = i2;
        }
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Unit.a;
            }
            ?? r12 = (Function0) this.L$0;
            ResultKt.b(obj);
            i2 = r12;
            a.a.f(wf.a.a, "VideoFloat", "shorttv--saveHistory--end", false, 4, (Object) null);
            Result.constructor-impl(Unit.a);
            r1 = i2;
            c = y0.c();
            uGCShortTVFloatManager$saveHistoryInner$1$1$2 = new UGCShortTVFloatManager$saveHistoryInner$1$1$2(r1, null);
            this.L$0 = null;
            this.label = 2;
            if (kotlinx.coroutines.i.g(c, uGCShortTVFloatManager$saveHistoryInner$1$1$2, this) == f) {
                return f;
            }
            return Unit.a;
        }
        ResultKt.b(obj);
        dw.a aVar = this.$floatBean;
        if (aVar != null) {
            ?? r13 = this.$callback;
            a.a.f(wf.a.a, "VideoFloat", "shorttv-----saveHistory, ep:" + aVar.c() + ", progress:" + aVar.n(), false, 4, (Object) null);
            Result.Companion companion2 = Result.Companion;
            long currentTimeMillis = System.currentTimeMillis();
            UGCVideo v2 = aVar.v();
            if (v2 != null) {
                UGCVideoBelongToCollection belongToCollection = v2.getBelongToCollection();
                if (belongToCollection != null) {
                    r = belongToCollection.getCollectionId();
                    if (r == null) {
                    }
                    String str = r;
                    v = aVar.v();
                    i2 = r13;
                    if (v != null) {
                        String ugcVideoId = v.getUgcVideoId();
                        i2 = r13;
                        if (ugcVideoId != null) {
                            i = UGCShortTVFloatManager.b.i();
                            long n = aVar.n();
                            this.L$0 = r13;
                            this.label = 1;
                            i2 = r13;
                            if (i.k(str, ugcVideoId, currentTimeMillis, n, this) == f) {
                                return f;
                            }
                        }
                    }
                    a.a.f(wf.a.a, "VideoFloat", "shorttv--saveHistory--end", false, 4, (Object) null);
                    Result.constructor-impl(Unit.a);
                    r1 = i2;
                    c = y0.c();
                    uGCShortTVFloatManager$saveHistoryInner$1$1$2 = new UGCShortTVFloatManager$saveHistoryInner$1$1$2(r1, null);
                    this.L$0 = null;
                    this.label = 2;
                    if (kotlinx.coroutines.i.g(c, uGCShortTVFloatManager$saveHistoryInner$1$1$2, this) == f) {
                    }
                }
            }
            r = aVar.r();
            String str2 = r;
            v = aVar.v();
            i2 = r13;
            if (v != null) {
            }
            a.a.f(wf.a.a, "VideoFloat", "shorttv--saveHistory--end", false, 4, (Object) null);
            Result.constructor-impl(Unit.a);
            r1 = i2;
            c = y0.c();
            uGCShortTVFloatManager$saveHistoryInner$1$1$2 = new UGCShortTVFloatManager$saveHistoryInner$1$1$2(r1, null);
            this.L$0 = null;
            this.label = 2;
            if (kotlinx.coroutines.i.g(c, uGCShortTVFloatManager$saveHistoryInner$1$1$2, this) == f) {
            }
        }
        return Unit.a;
        Result.Companion companion3 = Result.Companion;
        Result.constructor-impl(ResultKt.a(th2));
        r1 = i2;
        c = y0.c();
        uGCShortTVFloatManager$saveHistoryInner$1$1$2 = new UGCShortTVFloatManager$saveHistoryInner$1$1$2(r1, null);
        this.L$0 = null;
        this.label = 2;
        if (kotlinx.coroutines.i.g(c, uGCShortTVFloatManager$saveHistoryInner$1$1$2, this) == f) {
        }
        return Unit.a;
    }
}
