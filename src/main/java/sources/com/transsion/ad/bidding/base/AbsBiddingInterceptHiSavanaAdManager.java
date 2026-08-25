package com.transsion.ad.bidding.base;

import android.app.Activity;
import com.hisavana.common.bean.AdditionalInfo;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.ad.hi.HiSavanaAdManager;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.plan.AdPlanSourceManager;
import com.transsion.ad.scene.SceneInterceptManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import xh.b;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class AbsBiddingInterceptHiSavanaAdManager extends x implements xh.b {
    private oh.a d;
    private String e;
    private Map f;
    private AtomicBoolean g = new AtomicBoolean(false);
    private AdditionalInfo h;

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j(List list) {
        List list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            if (AdPlanSourceManager.a.d((AdPlans) it.next())) {
                return true;
            }
        }
        return false;
    }

    public final void b(oh.a aVar) {
        oh.a aVar2 = this.d;
        if (aVar2 != null && Intrinsics.c(aVar2, aVar)) {
            n(null);
            b.a.c(this, 3, "destroy() --> 移除监听", (String) null, false, 4, (Object) null);
        }
    }

    public final void c(String str) {
        Intrinsics.h(str, "sceneId");
        kotlinx.coroutines.i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new AbsBiddingInterceptHiSavanaAdManager$enterScene$1(this, str, null), 3, (Object) null);
    }

    public abstract fe.b d();

    public abstract int e();

    public final AdditionalInfo f() {
        fe.b d = d();
        if (d == null || d.hasAd() || e() == 5) {
            return this.h;
        }
        return null;
    }

    public final oh.a g() {
        return this.d;
    }

    public String getClassTag() {
        return b.a.a(this);
    }

    public String getSceneId() {
        return TtmlNode.ANONYMOUS_REGION_ID;
    }

    public final String h() {
        return this.e;
    }

    public final Boolean i() {
        fe.b d = d();
        if (d != null) {
            return Boolean.valueOf(d.hasAd());
        }
        return null;
    }

    public final void k() {
        if (!HiSavanaAdManager.a.f() && e() != 5) {
            oh.a aVar = this.d;
            if (aVar != null) {
                aVar.onLoadFailure(new TAdErrorCode(103, "广告SDK没有初始化"), new AdditionalInfo());
                return;
            }
            return;
        }
        if (this.g.get()) {
            oh.a aVar2 = this.d;
            if (aVar2 != null) {
                aVar2.onLoadFailure(new TAdErrorCode(103, "当前正在展示Hi广告"), new AdditionalInfo());
                return;
            }
            return;
        }
        if (d() == null) {
            oh.a aVar3 = this.d;
            if (aVar3 != null) {
                aVar3.onLoadFailure(new TAdErrorCode(103, "getAdInstance() == null"), new AdditionalInfo());
                return;
            }
            return;
        }
        fe.b d = d();
        if (d != null) {
            d.loadAd();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object l(String str, Map map, Continuation continuation) {
        AbsBiddingInterceptHiSavanaAdManager$preLoadAd$1 absBiddingInterceptHiSavanaAdManager$preLoadAd$1;
        Object obj;
        int i;
        fe.b d;
        if (continuation instanceof AbsBiddingInterceptHiSavanaAdManager$preLoadAd$1) {
            absBiddingInterceptHiSavanaAdManager$preLoadAd$1 = (AbsBiddingInterceptHiSavanaAdManager$preLoadAd$1) continuation;
            int i2 = absBiddingInterceptHiSavanaAdManager$preLoadAd$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                absBiddingInterceptHiSavanaAdManager$preLoadAd$1.label = i2 - Integer.MIN_VALUE;
                obj = absBiddingInterceptHiSavanaAdManager$preLoadAd$1.result;
                Object f = IntrinsicsKt.f();
                i = absBiddingInterceptHiSavanaAdManager$preLoadAd$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    if (!HiSavanaAdManager.a.f()) {
                        return Unit.a;
                    }
                    SceneInterceptManager sceneInterceptManager = SceneInterceptManager.a;
                    absBiddingInterceptHiSavanaAdManager$preLoadAd$1.L$0 = str;
                    absBiddingInterceptHiSavanaAdManager$preLoadAd$1.L$1 = map;
                    absBiddingInterceptHiSavanaAdManager$preLoadAd$1.label = 1;
                    obj = sceneInterceptManager.a(str, absBiddingInterceptHiSavanaAdManager$preLoadAd$1);
                    if (obj == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    map = (Map) absBiddingInterceptHiSavanaAdManager$preLoadAd$1.L$1;
                    str = (String) absBiddingInterceptHiSavanaAdManager$preLoadAd$1.L$0;
                    ResultKt.b(obj);
                }
                if (((Boolean) ((Pair) obj).getFirst()).booleanValue() && !com.transsion.ad.scene.c.a.a(str)) {
                    d = d();
                    if (d == null && d.hasAd()) {
                        return Unit.a;
                    }
                    kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new AbsBiddingInterceptHiSavanaAdManager$preLoadAd$2(str, map, this, null), 3, (Object) null);
                    return Unit.a;
                }
                return Unit.a;
            }
        }
        absBiddingInterceptHiSavanaAdManager$preLoadAd$1 = new AbsBiddingInterceptHiSavanaAdManager$preLoadAd$1(this, continuation);
        obj = absBiddingInterceptHiSavanaAdManager$preLoadAd$1.result;
        Object f2 = IntrinsicsKt.f();
        i = absBiddingInterceptHiSavanaAdManager$preLoadAd$1.label;
        if (i != 0) {
        }
        if (((Boolean) ((Pair) obj).getFirst()).booleanValue()) {
            return Unit.a;
        }
        d = d();
        if (d == null) {
        }
        kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new AbsBiddingInterceptHiSavanaAdManager$preLoadAd$2(str, map, this, null), 3, (Object) null);
        return Unit.a;
    }

    public abstract void m();

    public final AbsBiddingInterceptHiSavanaAdManager n(oh.a aVar) {
        this.d = aVar;
        return this;
    }

    public final void o(String str) {
        this.e = str;
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onClick(TAdNativeInfo tAdNativeInfo, AdditionalInfo additionalInfo) {
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onClick(tAdNativeInfo, additionalInfo);
        oh.a aVar = this.d;
        if (aVar != null) {
            aVar.onClick(tAdNativeInfo, additionalInfo);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onClosed(int i) {
        super.onClosed(i);
        this.g.set(false);
        oh.a aVar = this.d;
        if (aVar != null) {
            aVar.onClosed(i);
        }
        this.d = null;
        m();
        if (e() == 5) {
            return;
        }
        k();
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onLoadFailure(TAdErrorCode tAdErrorCode, AdditionalInfo additionalInfo) {
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onLoadFailure(tAdErrorCode, additionalInfo);
        this.g.set(false);
        oh.a aVar = this.d;
        if (aVar != null) {
            aVar.onLoadFailure(tAdErrorCode, additionalInfo);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onLoadSuccess(AdditionalInfo additionalInfo) {
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onLoadSuccess(additionalInfo);
        this.h = additionalInfo;
        oh.a aVar = this.d;
        if (aVar != null) {
            aVar.onLoadSuccess(additionalInfo);
        }
    }

    public void onLog(int i, String str, String str2, boolean z) {
        b.a.b(this, i, str, str2, z);
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onRewarded() {
        super.onRewarded();
        oh.a aVar = this.d;
        if (aVar != null) {
            aVar.onRewarded();
        }
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onShow(TAdNativeInfo tAdNativeInfo, AdditionalInfo additionalInfo) {
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onShow(tAdNativeInfo, additionalInfo);
        this.g.set(true);
        oh.a aVar = this.d;
        if (aVar != null) {
            aVar.onShow(tAdNativeInfo, additionalInfo);
        }
        this.h = null;
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onShowError(TAdErrorCode tAdErrorCode, AdditionalInfo additionalInfo) {
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onShowError(tAdErrorCode, additionalInfo);
        this.g.set(false);
        oh.a aVar = this.d;
        if (aVar != null) {
            aVar.onShowError(tAdErrorCode, additionalInfo);
        }
    }

    public abstract void p(Activity activity, String str, Integer num, Map map);

    public final void q(Activity activity, Integer num, String str) {
        Intrinsics.h(str, "sceneId");
        if (activity == null) {
            oh.a aVar = this.d;
            if (aVar != null) {
                aVar.onShowError(new TAdErrorCode(103, "activity is null"), new AdditionalInfo());
                return;
            }
            return;
        }
        if (this.g.get()) {
            oh.a aVar2 = this.d;
            if (aVar2 != null) {
                aVar2.onShowError(new TAdErrorCode(103, "当前正在展示Hi广告"), new AdditionalInfo());
                return;
            }
            return;
        }
        if (e() == 5) {
            p(activity, str, num, this.f);
            return;
        }
        fe.b d = d();
        if (d != null && d.hasAd()) {
            p(activity, str, num, this.f);
            return;
        }
        oh.a aVar3 = this.d;
        if (aVar3 != null) {
            aVar3.onShowError(new TAdErrorCode(103, "当前还没有广告"), new AdditionalInfo());
        }
        n(null);
        k();
    }
}
