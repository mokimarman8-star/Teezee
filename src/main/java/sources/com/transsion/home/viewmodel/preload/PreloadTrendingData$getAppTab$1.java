package com.transsion.home.viewmodel.preload;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.baselib.report.launch.b;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.AppTab;
import com.transsion.home.bean.BottomTabItem;
import com.transsion.home.bean.HomeTabItem;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import wf.a;
import yk.e;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.viewmodel.preload.PreloadTrendingData$getAppTab$1", f = "PreloadTrendingData.kt", l = {242}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PreloadTrendingData$getAppTab$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ PreloadTrendingData this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PreloadTrendingData$getAppTab$1(PreloadTrendingData preloadTrendingData, Continuation<? super PreloadTrendingData$getAppTab$1> continuation) {
        super(2, continuation);
        this.this$0 = preloadTrendingData;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PreloadTrendingData$getAppTab$1(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x01bc, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.c(r0, r6) == false) goto L88;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Boolean bool;
        AppTab appTab;
        List<BottomTabItem> bottomTabs;
        List<BottomTabItem> bottomTabs2;
        List<HomeTabItem> homeTabs;
        List<HomeTabItem> homeTabs2;
        List<BottomTabItem> bottomTabs3;
        List<HomeTabItem> homeTabs3;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        Integer num = null;
        try {
            if (i == 0) {
                ResultKt.b(obj);
                AppTab j = PreloadTrendingData.j(this.this$0);
                if (j != null) {
                    PreloadTrendingData preloadTrendingData = this.this$0;
                    j.resetHomeTabs(PreloadTrendingData.i(preloadTrendingData, j.getHomeTabs()));
                    j.setBottomTabs(PreloadTrendingData.h(preloadTrendingData, j));
                    a.a aVar = a.a;
                    List<BottomTabItem> bottomTabs4 = j.getBottomTabs();
                    Integer d = bottomTabs4 != null ? Boxing.d(bottomTabs4.size()) : null;
                    aVar.c("PreloadTrending", "get tab cache " + d + " version=" + j.getVersion(), true);
                    PreloadTrendingData.s(preloadTrendingData, j);
                    preloadTrendingData.C().n(j);
                    PreloadTrendingData.o(preloadTrendingData, j);
                } else {
                    j = null;
                }
                int i2 = b.a.b().getInt("key_or_content_mode_local", -1);
                if (i2 >= 0) {
                    bool = Boxing.a(i2 == 1);
                } else {
                    bool = null;
                }
                a.a.c("PreloadTrending", "homeTab getAppTab ,isUGCMode:" + bool, true);
                e n = PreloadTrendingData.n(this.this$0);
                String a = gg.a.a.a();
                this.L$0 = j;
                this.label = 1;
                Object g = n.g(bool, a, this);
                if (g == f) {
                    return f;
                }
                appTab = j;
                obj = g;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                appTab = (AppTab) this.L$0;
                ResultKt.b(obj);
            }
            PreloadTrendingData preloadTrendingData2 = this.this$0;
            AppTab appTab2 = (AppTab) ((BaseDto) obj).getData();
            List<HomeTabItem> i3 = PreloadTrendingData.i(preloadTrendingData2, appTab2 != null ? appTab2.getHomeTabs() : null);
            if (appTab2 != null) {
                appTab2.resetHomeTabs(i3);
            }
            if (appTab2 != null) {
                appTab2.setBottomTabs(PreloadTrendingData.h(preloadTrendingData2, appTab2));
            }
            a.a aVar2 = a.a;
            aVar2.c("PreloadTrending", "homeTab size=" + ((appTab2 == null || (homeTabs3 = appTab2.getHomeTabs()) == null) ? null : Boxing.d(homeTabs3.size())), true);
            aVar2.c("PreloadTrending", "bottomTab size=" + ((appTab2 == null || (bottomTabs3 = appTab2.getBottomTabs()) == null) ? null : Boxing.d(bottomTabs3.size())) + " version=" + (appTab2 != null ? appTab2.getVersion() : null), true);
            preloadTrendingData2.D().n(appTab2);
            PreloadTrendingData.o(preloadTrendingData2, appTab2);
            if (Intrinsics.c(appTab != null ? appTab.getVersion() : null, appTab2 != null ? appTab2.getVersion() : null)) {
                if (Intrinsics.c((appTab == null || (homeTabs2 = appTab.getHomeTabs()) == null) ? null : Boxing.d(homeTabs2.size()), (appTab2 == null || (homeTabs = appTab2.getHomeTabs()) == null) ? null : Boxing.d(homeTabs.size()))) {
                    Integer d2 = (appTab == null || (bottomTabs2 = appTab.getBottomTabs()) == null) ? null : Boxing.d(bottomTabs2.size());
                    if (appTab2 != null && (bottomTabs = appTab2.getBottomTabs()) != null) {
                        num = Boxing.d(bottomTabs.size());
                    }
                }
            }
            PreloadTrendingData.q(preloadTrendingData2, appTab2);
        } catch (Exception e) {
            if (this.this$0.D().f() == null) {
                PreloadTrendingData.r(this.this$0, false);
            }
            a.a.i("PreloadTrending", "getHomeTab error " + e.getMessage(), true);
        }
        return Unit.a;
    }
}
