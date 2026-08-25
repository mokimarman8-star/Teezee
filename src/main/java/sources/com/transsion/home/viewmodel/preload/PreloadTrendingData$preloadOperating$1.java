package com.transsion.home.viewmodel.preload;

import android.content.Context;
import com.blankj.utilcode.util.o;
import com.transsion.baselib.report.launch.b;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.MainOperateData;
import com.transsion.home.bean.OperateItem;
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
import kotlinx.coroutines.n0;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.viewmodel.preload.PreloadTrendingData$preloadOperating$1", f = "PreloadTrendingData.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PreloadTrendingData$preloadOperating$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ PreloadTrendingData this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PreloadTrendingData$preloadOperating$1(PreloadTrendingData preloadTrendingData, Context context, Continuation<? super PreloadTrendingData$preloadOperating$1> continuation) {
        super(2, continuation);
        this.this$0 = preloadTrendingData;
        this.$context = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PreloadTrendingData$preloadOperating$1(this.this$0, this.$context, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        String string = b.a.b().getString("main_operating_data", BuildConfig.FLAVOR);
        if (string == null || string.length() == 0) {
            string = PreloadTrendingData.k(this.this$0).c(this.$context);
        }
        if (string != null) {
            try {
            } catch (Exception e) {
                a.a.c("PreloadTrending", "exception when from json " + e.getMessage(), true);
                Boxing.a(this.this$0.Q(BuildConfig.FLAVOR));
            }
            if (string.length() != 0) {
                MainOperateData mainOperateData = (MainOperateData) o.d(string, MainOperateData.class);
                if (mainOperateData != null) {
                    PreloadTrendingData preloadTrendingData = this.this$0;
                    mainOperateData.setSourceFrom("from_cache");
                    a.a aVar = a.a;
                    List<OperateItem> items = mainOperateData.getItems();
                    aVar.c("PreloadTrending", "load operating cache size=" + (items != null ? Boxing.d(items.size()) : null) + "}", true);
                    preloadTrendingData.J().n(mainOperateData);
                    String version = mainOperateData.getVersion();
                    if (version == null) {
                        version = BuildConfig.FLAVOR;
                    }
                    Boxing.a(preloadTrendingData.Q(version));
                }
                return Unit.a;
            }
        }
        this.this$0.Q(BuildConfig.FLAVOR);
        a.a.c("PreloadTrending", "preloadOperatingCache json is null", true);
        return Unit.a;
    }
}
