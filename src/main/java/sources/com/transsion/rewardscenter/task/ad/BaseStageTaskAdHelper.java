package com.transsion.rewardscenter.task.ad;

import android.content.Context;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hisavana.common.bean.TAdNativeInfo;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.nativead.BiddingSspNativeManager;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.gslb.BuildConfig;
import com.transsion.rewardscenter.task.ad.v;
import com.transsion.rewardscenterapi.MemberTaskItem;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.n0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class BaseStageTaskAdHelper {
    public static final b e = new b(null);
    public static final int f = 8;
    private final Context a;
    private final n0 b;
    private long c;
    private a d;

    public interface a {
        void a(Integer num);

        void b();

        void start();
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BaseStageTaskAdHelper(Context context, n0 n0Var) {
        Intrinsics.h(context, "context");
        this.a = context;
        this.b = n0Var;
    }

    public static /* synthetic */ void A(BaseStageTaskAdHelper baseStageTaskAdHelper, v vVar, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startClaim");
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        baseStageTaskAdHelper.z(vVar, function0);
    }

    public void c(v.c cVar) {
        Intrinsics.h(cVar, "data");
    }

    public void d() {
    }

    public final long e(String str) {
        JsonElement jsonElement;
        JsonObject b2 = com.transsion.ad.scene.d.a.b(str);
        if (b2 == null || (jsonElement = b2.get("expDuration")) == null) {
            return 30000L;
        }
        return jsonElement.getAsLong();
    }

    public final void f(Function0 function0) {
        Unit unit;
        if (u.a.j() != null) {
            if (function0 != null) {
                function0.invoke();
                unit = Unit.a;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        n0 n0Var = this.b;
        if (n0Var != null) {
            kotlinx.coroutines.i.d(n0Var, (CoroutineContext) null, (CoroutineStart) null, new BaseStageTaskAdHelper$fetchMemberAdTaskInfo$2$1(function0, null), 3, (Object) null);
        }
    }

    public final String g(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        List<AdMaterialList> adMaterialList;
        AdMaterialList adMaterialList2;
        RecommendInfo psRecommendInfo;
        String packageName;
        AdsDTO adItem;
        Intrinsics.h(biddingIntermediateMaterialBean, "adBean");
        if (biddingIntermediateMaterialBean.getNativeInfo() != null) {
            TAdNativeInfo nativeInfo = biddingIntermediateMaterialBean.getNativeInfo();
            if (nativeInfo == null || (packageName = nativeInfo.getPackageName()) == null) {
                return BuildConfig.FLAVOR;
            }
        } else if (biddingIntermediateMaterialBean.getSspNativeInfo() != null) {
            TaNativeInfo sspNativeInfo = biddingIntermediateMaterialBean.getSspNativeInfo();
            if (sspNativeInfo == null || (adItem = sspNativeInfo.getAdItem()) == null) {
                return BuildConfig.FLAVOR;
            }
            String psPackageName = adItem.getPsPackageName();
            packageName = (psPackageName == null || psPackageName.length() == 0) ? adItem.getPackageName() : adItem.getPsPackageName();
            if (packageName == null) {
                return BuildConfig.FLAVOR;
            }
        } else {
            AdPlans plans = biddingIntermediateMaterialBean.getPlans();
            if (plans == null || (adMaterialList = plans.getAdMaterialList()) == null || (adMaterialList2 = adMaterialList.get(0)) == null || (psRecommendInfo = adMaterialList2.getPsRecommendInfo()) == null || (packageName = psRecommendInfo.getPackageName()) == null) {
                return BuildConfig.FLAVOR;
            }
        }
        return packageName;
    }

    public final long h() {
        return this.c;
    }

    public final boolean i(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        RecommendInfo psRecommendInfo;
        Integer adType;
        List<AdMaterialList> adMaterialList;
        AdsDTO adItem;
        Integer pullNewestLive;
        AdsDTO adItem2;
        Integer pullNewestLive2;
        Intrinsics.h(biddingIntermediateMaterialBean, "adBean");
        if (biddingIntermediateMaterialBean.getSspNativeInfo() != null) {
            TaNativeInfo sspNativeInfo = biddingIntermediateMaterialBean.getSspNativeInfo();
            if (sspNativeInfo == null || (adItem2 = sspNativeInfo.getAdItem()) == null || (pullNewestLive2 = adItem2.getPullNewestLive()) == null || pullNewestLive2.intValue() != 1) {
                TaNativeInfo sspNativeInfo2 = biddingIntermediateMaterialBean.getSspNativeInfo();
                if (sspNativeInfo2 != null && (adItem = sspNativeInfo2.getAdItem()) != null && (pullNewestLive = adItem.getPullNewestLive()) != null && pullNewestLive.intValue() == 2) {
                    return true;
                }
            } else if (!com.transsion.rewardscenter.utils.o.a.a(this.a, g(biddingIntermediateMaterialBean))) {
                return true;
            }
        } else {
            AdPlans plans = biddingIntermediateMaterialBean.getPlans();
            AdMaterialList adMaterialList2 = (plans == null || (adMaterialList = plans.getAdMaterialList()) == null) ? null : (AdMaterialList) CollectionsKt.k0(adMaterialList);
            if (adMaterialList2 != null && (psRecommendInfo = adMaterialList2.getPsRecommendInfo()) != null && (adType = psRecommendInfo.getAdType()) != null && adType.intValue() == 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean j(v.a aVar) {
        return (aVar != null ? aVar.e() : null) == AdTaskState.DOWNLOADING && aVar.g() > 0 && System.currentTimeMillis() - aVar.g() > 180000;
    }

    public final boolean k(v.c cVar) {
        return (cVar != null ? cVar.e() : null) == AdTaskState.DOWNLOADING && cVar.g() > 0 && System.currentTimeMillis() - cVar.g() > 180000;
    }

    public final boolean l(v.c cVar) {
        if (cVar == null || cVar.e() != AdTaskState.PLAYING) {
            return false;
        }
        cVar.q(System.currentTimeMillis() - this.c);
        a.a.f(wf.a.a, "StageTaskAd", "----> onResume playedTime: " + cVar.j(), false, 4, (Object) null);
        if (cVar.j() >= e(cVar.c().getSceneId())) {
            cVar.m(AdTaskState.PLAYED);
            u.a.v(cVar.i(), cVar.e());
            return true;
        }
        com.transsion.rewardscenter.utils.p.a(false, "Play for 30 seconds to get the reward.");
        cVar.m(AdTaskState.CLAIMED_STAGE1);
        u.a.v(cVar.i(), cVar.e());
        return true;
    }

    public final boolean m(v.a aVar) {
        boolean z;
        boolean z2;
        if (aVar == null) {
            return false;
        }
        if (aVar.e() == AdTaskState.DOWNLOADING) {
            if (com.transsion.rewardscenter.utils.o.a.a(this.a, aVar.i())) {
                aVar.m(AdTaskState.INSTALLED);
                u.a.v(aVar.i(), aVar.e());
                z2 = false;
                z = true;
            } else if (j(aVar)) {
                aVar.m(AdTaskState.NORMAL);
                aVar.o(0L);
                u.a.v(aVar.i(), aVar.e());
                z = false;
                z2 = true;
            }
            return !z || z2;
        }
        z = false;
        z2 = false;
        if (z) {
        }
    }

    public final boolean n(v.c cVar) {
        boolean z;
        boolean z2;
        if (cVar == null) {
            return false;
        }
        AdTaskState e2 = cVar.e();
        AdTaskState adTaskState = AdTaskState.NORMAL;
        if (e2 == adTaskState || cVar.e() == AdTaskState.DOWNLOADING) {
            if (com.transsion.rewardscenter.utils.o.a.a(this.a, cVar.i())) {
                cVar.m(AdTaskState.INSTALLED);
                u.a.v(cVar.i(), cVar.e());
                z2 = false;
                z = true;
            } else if (k(cVar)) {
                cVar.m(adTaskState);
                cVar.o(0L);
                u.a.v(cVar.i(), cVar.e());
                z = false;
                z2 = true;
            }
            return !z || z2;
        }
        z = false;
        z2 = false;
        if (z) {
        }
    }

    public final void o() {
        this.c = System.currentTimeMillis();
    }

    public final void p() {
    }

    public final int q(String str) {
        JsonElement jsonElement;
        JsonObject b2 = com.transsion.ad.scene.d.a.b(str);
        if (b2 == null || (jsonElement = b2.get("cooldownDays")) == null) {
            return 3;
        }
        return jsonElement.getAsInt();
    }

    public final void r() {
        if (v() > 0) {
            BiddingSspNativeManager.Companion.b(BiddingSspNativeManager.x, "MemberTaskStageNativeScene", (Map) null, 2, (Object) null);
        }
        if (u() > 0 || t() > 0) {
            BiddingSspNativeManager.Companion.b(BiddingSspNativeManager.x, "MemberTaskRegularNativeScene", (Map) null, 2, (Object) null);
        }
    }

    public final int s(MemberTaskItem memberTaskItem) {
        Integer totalProgress;
        if (memberTaskItem == null) {
            return 0;
        }
        Integer status = memberTaskItem.getStatus();
        if ((status != null && status.intValue() == 3) || (totalProgress = memberTaskItem.getTotalProgress()) == null) {
            return 0;
        }
        int intValue = totalProgress.intValue();
        Integer progress = memberTaskItem.getProgress();
        return intValue - (progress != null ? progress.intValue() : 0);
    }

    public final int t() {
        return s(u.a.g());
    }

    public final int u() {
        return s(u.a.h());
    }

    public final int v() {
        return s(u.a.j());
    }

    public final int w() {
        return s(u.a.k());
    }

    public final void x(a aVar) {
        this.d = aVar;
    }

    public final void y(String str, Integer num) {
        Intrinsics.h(str, "packageName");
        u.a.u(str, num);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void z(v vVar, Function0 function0) {
        MemberTaskItem memberTaskItem;
        MemberTaskItem i;
        a aVar;
        a aVar2 = this.d;
        if (aVar2 != null) {
            aVar2.start();
        }
        if (vVar instanceof v.c) {
            i = ((v.c) vVar).e() == AdTaskState.INSTALLED ? u.a.j() : u.a.k();
        } else if (vVar instanceof v.a) {
            i = ((v.a) vVar).k() ? u.a.h() : u.a.g();
        } else {
            if (!(vVar instanceof v.b)) {
                memberTaskItem = null;
                if (memberTaskItem != null) {
                    n0 n0Var = this.b;
                    if ((n0Var != null ? kotlinx.coroutines.i.d(n0Var, (CoroutineContext) null, (CoroutineStart) null, new BaseStageTaskAdHelper$startClaim$1$1(memberTaskItem, this, vVar, function0, null), 3, (Object) null) : null) != null) {
                        return;
                    }
                }
                aVar = this.d;
                if (aVar != null) {
                    aVar.b();
                }
                com.transsion.rewardscenter.utils.p.a(false, "Failed to claim points.");
                Unit unit = Unit.a;
            }
            i = u.a.i();
        }
        memberTaskItem = i;
        if (memberTaskItem != null) {
        }
        aVar = this.d;
        if (aVar != null) {
        }
        com.transsion.rewardscenter.utils.p.a(false, "Failed to claim points.");
        Unit unit2 = Unit.a;
    }
}
