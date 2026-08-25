package com.transsion.ad.bidding.nativead;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.cloud.hisavana.sdk.common.bean.AdActiveInfo;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.ad.db.pslink.AppInstalledBean;
import com.transsion.ad.hi.HiSavanaAdManager;
import com.transsion.ad.ps.installed.AppInstallManager;
import com.transsion.ad.scene.SceneInterceptManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class BiddingHiSspNativeProvider extends com.cloud.hisavana.sdk.api.listener.d {
    public static final a h = new a(null);
    private static final Lazy i = LazyKt.b(new Function0() { // from class: com.transsion.ad.bidding.nativead.d
        public final Object invoke() {
            Map o;
            o = BiddingHiSspNativeProvider.o();
            return o;
        }
    });
    private b7.c c;
    private String d;
    private AtomicBoolean b = new AtomicBoolean(false);
    private final ConcurrentLinkedDeque e = new ConcurrentLinkedDeque();
    private final ConcurrentSkipListSet f = new ConcurrentSkipListSet(new Comparator() { // from class: com.transsion.ad.bidding.nativead.c
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int p;
            p = BiddingHiSspNativeProvider.p((TaNativeInfo) obj, (TaNativeInfo) obj2);
            return p;
        }
    });
    private int g = 3;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Map a() {
            return (Map) BiddingHiSspNativeProvider.i.getValue();
        }

        public final BiddingHiSspNativeProvider b(String str) {
            String i = com.transsion.ad.scene.a.a.i(str);
            if (i == null || i.length() == 0) {
                return null;
            }
            BiddingHiSspNativeProvider biddingHiSspNativeProvider = (BiddingHiSspNativeProvider) a().get(i);
            if (biddingHiSspNativeProvider != null) {
                return biddingHiSspNativeProvider;
            }
            BiddingHiSspNativeProvider biddingHiSspNativeProvider2 = new BiddingHiSspNativeProvider();
            biddingHiSspNativeProvider2.s(i);
            a().put(i, biddingHiSspNativeProvider2);
            return biddingHiSspNativeProvider2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String j() {
        String simpleName = BiddingHiSspNativeProvider.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String l() {
        String str = this.d;
        return str == null ? TtmlNode.ANONYMOUS_REGION_ID : str;
    }

    private final boolean m() {
        boolean z = this.f.size() >= this.g;
        if (z) {
            xh.a.m(xh.a.a, "ad_n", j() + " --> isUpperLimit() --- 达到阈值了 --> nativeInfoList.size = " + this.f.size() + " -- cacheUpperLimit = " + this.g, 0, false, 4, (Object) null);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map o() {
        return new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int p(TaNativeInfo taNativeInfo, TaNativeInfo taNativeInfo2) {
        boolean c = Intrinsics.c(taNativeInfo.getAdCreateId(), taNativeInfo2.getAdCreateId());
        AdImage image = taNativeInfo.getImage();
        String imgUrl = image != null ? image.getImgUrl() : null;
        AdImage image2 = taNativeInfo2.getImage();
        boolean c2 = Intrinsics.c(imgUrl, image2 != null ? image2.getImgUrl() : null);
        if (c || c2) {
            int compare = Double.compare(taNativeInfo2.getBidPrice(), taNativeInfo.getBidPrice());
            if (compare != 0) {
                return compare;
            }
            return 0;
        }
        int compare2 = Double.compare(taNativeInfo2.getBidPrice(), taNativeInfo.getBidPrice());
        if (compare2 != 0) {
            return compare2;
        }
        String adCreateId = taNativeInfo2.getAdCreateId();
        String adCreateId2 = taNativeInfo.getAdCreateId();
        Intrinsics.g(adCreateId2, "getAdCreateId(...)");
        int compareTo = adCreateId.compareTo(adCreateId2);
        if (compareTo != 0) {
            return compareTo;
        }
        String imgUrl2 = taNativeInfo2.getImage().getImgUrl();
        String imgUrl3 = taNativeInfo.getImage().getImgUrl();
        Intrinsics.g(imgUrl3, "getImgUrl(...)");
        return imgUrl2.compareTo(imgUrl3);
    }

    public final void h(com.cloud.hisavana.sdk.api.listener.d dVar) {
        this.e.add(dVar);
    }

    public final List i(int i2, boolean z) {
        Object obj;
        ArrayList arrayList;
        if (i2 > this.g) {
            this.g = i2;
        }
        try {
            Result.Companion companion = Result.Companion;
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                TaNativeInfo taNativeInfo = (TaNativeInfo) it.next();
                b7.c cVar = this.c;
                if (cVar != null && !cVar.u(taNativeInfo)) {
                    taNativeInfo.destroy();
                    it.remove();
                }
            }
            if (!z || this.f.size() >= i2) {
                arrayList = new ArrayList();
                int min = Math.min(i2, this.f.size());
                for (int i3 = 0; i3 < min; i3++) {
                    TaNativeInfo taNativeInfo2 = (TaNativeInfo) this.f.pollFirst();
                    if (taNativeInfo2 != null) {
                        arrayList.add(taNativeInfo2);
                    }
                }
            } else {
                arrayList = null;
            }
            obj = Result.constructor-impl(arrayList);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th));
        }
        List list = (List) (Result.exceptionOrNull-impl(obj) == null ? obj : null);
        n();
        return list;
    }

    public final b7.c k() {
        return this.c;
    }

    public final void n() {
        if (!HiSavanaAdManager.a.f()) {
            xh.a.m(xh.a.a, "ad_n", j() + " --> loadAd() --> 广告SDK没有初始化", 0, false, 4, (Object) null);
            return;
        }
        if (m() || this.b.get()) {
            return;
        }
        this.b.set(true);
        if (this.c == null) {
            b7.c cVar = new b7.c(l());
            this.c = cVar;
            cVar.p(this);
            b7.c cVar2 = this.c;
            if (cVar2 != null) {
                cVar2.z(this.g);
            }
            xh.a.m(xh.a.a, "ad_n", "============= " + j() + " --> loadAd() --> mPlacementId = " + l() + " --> create TNativeAd() ============= ", 0, false, 4, (Object) null);
        }
        b7.c cVar3 = this.c;
        if (cVar3 != null) {
            cVar3.z(this.g);
        }
        b7.c cVar4 = this.c;
        if (cVar4 != null) {
            cVar4.v();
        }
    }

    public void onAdActivate(AdActiveInfo adActiveInfo) {
        String str;
        super.onAdActivate(adActiveInfo);
        AppInstallManager appInstallManager = AppInstallManager.a;
        if (adActiveInfo == null || (str = adActiveInfo.getPackageName()) == null) {
            str = "ew没有传递过来包名";
        }
        AppInstalledBean a2 = appInstallManager.a(str);
        a2.setSource("EW");
        Application a3 = Utils.a();
        Intrinsics.g(a3, "getApp(...)");
        appInstallManager.e(a3, a2);
    }

    public void onAdLoaded(List list) {
        this.b.set(false);
        if (list != null) {
            this.f.addAll(list);
        }
    }

    public void onError(TaErrorCode taErrorCode) {
        this.b.set(false);
        xh.a.a.l("ad_n", j() + " --> onError() --> placementId = " + l() + " --> errorMessage = " + (taErrorCode != null ? taErrorCode.getErrorMessage() : null), 6, false);
    }

    public void onNativeAdClick(TaNativeInfo taNativeInfo) {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((com.cloud.hisavana.sdk.api.listener.d) it.next()).onNativeAdClick(taNativeInfo);
        }
    }

    public void onNativeAdShow(TaNativeInfo taNativeInfo) {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((com.cloud.hisavana.sdk.api.listener.d) it.next()).onNativeAdShow(taNativeInfo);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object q(String str, int i2, Map map, Continuation continuation) {
        BiddingHiSspNativeProvider$preLoadAd$1 biddingHiSspNativeProvider$preLoadAd$1;
        Object obj;
        int i3;
        String str2;
        Map map2;
        int i4;
        if (continuation instanceof BiddingHiSspNativeProvider$preLoadAd$1) {
            biddingHiSspNativeProvider$preLoadAd$1 = (BiddingHiSspNativeProvider$preLoadAd$1) continuation;
            int i5 = biddingHiSspNativeProvider$preLoadAd$1.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                biddingHiSspNativeProvider$preLoadAd$1.label = i5 - Integer.MIN_VALUE;
                obj = biddingHiSspNativeProvider$preLoadAd$1.result;
                Object f = IntrinsicsKt.f();
                i3 = biddingHiSspNativeProvider$preLoadAd$1.label;
                if (i3 != 0) {
                    ResultKt.b(obj);
                    if (!HiSavanaAdManager.a.f()) {
                        return Unit.a;
                    }
                    SceneInterceptManager sceneInterceptManager = SceneInterceptManager.a;
                    biddingHiSspNativeProvider$preLoadAd$1.L$0 = str;
                    biddingHiSspNativeProvider$preLoadAd$1.L$1 = map;
                    biddingHiSspNativeProvider$preLoadAd$1.I$0 = i2;
                    biddingHiSspNativeProvider$preLoadAd$1.label = 1;
                    obj = sceneInterceptManager.a(str, biddingHiSspNativeProvider$preLoadAd$1);
                    if (obj == f) {
                        return f;
                    }
                    str2 = str;
                    map2 = map;
                    i4 = i2;
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i6 = biddingHiSspNativeProvider$preLoadAd$1.I$0;
                    map2 = (Map) biddingHiSspNativeProvider$preLoadAd$1.L$1;
                    str2 = (String) biddingHiSspNativeProvider$preLoadAd$1.L$0;
                    ResultKt.b(obj);
                    i4 = i6;
                }
                if (((Boolean) ((Pair) obj).getFirst()).booleanValue() && !com.transsion.ad.scene.c.a.a(str2) && this.f.isEmpty()) {
                    i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new BiddingHiSspNativeProvider$preLoadAd$2(str2, this, map2, i4, null), 3, (Object) null);
                    return Unit.a;
                }
                return Unit.a;
            }
        }
        biddingHiSspNativeProvider$preLoadAd$1 = new BiddingHiSspNativeProvider$preLoadAd$1(this, continuation);
        obj = biddingHiSspNativeProvider$preLoadAd$1.result;
        Object f2 = IntrinsicsKt.f();
        i3 = biddingHiSspNativeProvider$preLoadAd$1.label;
        if (i3 != 0) {
        }
        if (((Boolean) ((Pair) obj).getFirst()).booleanValue()) {
            return Unit.a;
        }
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new BiddingHiSspNativeProvider$preLoadAd$2(str2, this, map2, i4, null), 3, (Object) null);
        return Unit.a;
    }

    public final void r(com.cloud.hisavana.sdk.api.listener.d dVar) {
        this.e.remove(dVar);
    }

    public final void s(String str) {
        this.d = str;
    }
}
