package com.transsion.rewardscenter.task.ad;

import android.content.Context;
import com.hisavana.common.bean.TAdErrorCode;
import com.tn.lib.widget.R;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.nativead.BiddingSspNativeManager;
import com.transsion.ad.bidding.video.BiddingVideoManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.rewardscenter.task.ad.v;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MemberTaskAdHelper extends BaseStageTaskAdHelper {
    public static final a r = new a(null);
    public static final int s = 8;
    private static final Lazy t = LazyKt.b(new Function0() { // from class: com.transsion.rewardscenter.task.ad.e
        public final Object invoke() {
            int b0;
            b0 = MemberTaskAdHelper.b0();
            return Integer.valueOf(b0);
        }
    });
    private static final Lazy u = LazyKt.b(new Function0() { // from class: com.transsion.rewardscenter.task.ad.f
        public final Object invoke() {
            int a0;
            a0 = MemberTaskAdHelper.a0();
            return Integer.valueOf(a0);
        }
    });
    private final Context g;
    private final n0 h;
    private BiddingSspNativeManager i;
    private Function1 j;
    private BiddingSspNativeManager k;
    private Function1 l;
    private BiddingVideoManager m;
    private Function1 n;
    private final c o;
    private final b p;
    private final MemberTaskAdHelper$rewardAdListener$1 q;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return ((Number) MemberTaskAdHelper.u.getValue()).intValue();
        }

        public final int b() {
            return ((Number) MemberTaskAdHelper.t.getValue()).intValue();
        }
    }

    public static final class b extends oh.a {
        b() {
        }

        public void i(TAdErrorCode tAdErrorCode) {
            super.i(tAdErrorCode);
            Function1 function1 = MemberTaskAdHelper.this.l;
            if (function1 != null) {
                function1.invoke(CollectionsKt.l());
            }
        }

        public void k(List list) {
            Function1 function1;
            super.k(list);
            if (list != null) {
                MemberTaskAdHelper memberTaskAdHelper = MemberTaskAdHelper.this;
                List W = memberTaskAdHelper.W("MemberTaskRegularNativeScene", list, Boolean.FALSE);
                ArrayList arrayList = new ArrayList(CollectionsKt.v(W, 10));
                Iterator it = W.iterator();
                while (it.hasNext()) {
                    arrayList.add(x((BiddingIntermediateMaterialBean) it.next()));
                }
                boolean z = memberTaskAdHelper.u() <= 0;
                boolean z2 = memberTaskAdHelper.t() <= 0;
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : arrayList) {
                        if (!((v.a) obj).k()) {
                            arrayList2.add(obj);
                        }
                    }
                    arrayList = arrayList2;
                }
                if (z2) {
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj2 : arrayList) {
                        if (((v.a) obj2).k()) {
                            arrayList3.add(obj2);
                        }
                    }
                    arrayList = arrayList3;
                }
                if (arrayList.isEmpty() || (function1 = memberTaskAdHelper.l) == null) {
                    return;
                }
                function1.invoke(arrayList);
            }
        }

        public final v.a x(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            Intrinsics.h(biddingIntermediateMaterialBean, "bean");
            return new v.a(biddingIntermediateMaterialBean, null, null, null, null, MemberTaskAdHelper.this.g(biddingIntermediateMaterialBean), MemberTaskAdHelper.this.i(biddingIntermediateMaterialBean), false, 0L, 414, null);
        }
    }

    public static final class c extends oh.a {
        c() {
        }

        public void i(TAdErrorCode tAdErrorCode) {
            super.i(tAdErrorCode);
            Function1 function1 = MemberTaskAdHelper.this.j;
            if (function1 != null) {
                function1.invoke(CollectionsKt.l());
            }
        }

        public void k(List list) {
            super.k(list);
            if (list != null) {
                MemberTaskAdHelper memberTaskAdHelper = MemberTaskAdHelper.this;
                List W = memberTaskAdHelper.W("MemberTaskStageNativeScene", list, Boolean.TRUE);
                Function1 function1 = memberTaskAdHelper.j;
                if (function1 != null) {
                    List list2 = W;
                    ArrayList arrayList = new ArrayList(CollectionsKt.v(list2, 10));
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(x((BiddingIntermediateMaterialBean) it.next()));
                    }
                    function1.invoke(arrayList);
                }
            }
        }

        public final v.c x(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            Intrinsics.h(biddingIntermediateMaterialBean, "bean");
            return new v.c(biddingIntermediateMaterialBean, null, null, null, null, MemberTaskAdHelper.this.g(biddingIntermediateMaterialBean), false, 0L, 0L, 478, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.transsion.rewardscenter.task.ad.MemberTaskAdHelper$rewardAdListener$1] */
    public MemberTaskAdHelper(Context context, n0 n0Var) {
        super(context, n0Var);
        Intrinsics.h(context, "context");
        this.g = context;
        this.h = n0Var;
        this.o = new c();
        this.p = new b();
        this.q = new oh.a() { // from class: com.transsion.rewardscenter.task.ad.MemberTaskAdHelper$rewardAdListener$1
            public void i(TAdErrorCode tAdErrorCode) {
                Context context2;
                Function1 function1;
                super.i(tAdErrorCode);
                context2 = MemberTaskAdHelper.this.g;
                String string = context2.getString(R.string.common_failed);
                Intrinsics.g(string, "getString(...)");
                com.transsion.rewardscenter.utils.p.a(false, string);
                function1 = MemberTaskAdHelper.this.n;
                if (function1 != null) {
                    function1.invoke(Boolean.FALSE);
                }
            }

            public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                n0 n0Var2;
                super.j(biddingIntermediateMaterialBean);
                n0Var2 = MemberTaskAdHelper.this.h;
                if (n0Var2 != null) {
                    kotlinx.coroutines.i.d(n0Var2, (CoroutineContext) null, (CoroutineStart) null, new MemberTaskAdHelper$rewardAdListener$1$onBiddingLoad$1(MemberTaskAdHelper.this, biddingIntermediateMaterialBean, null), 3, (Object) null);
                }
            }

            public void o(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                Function1 function1;
                super.o(biddingIntermediateMaterialBean);
                if (biddingIntermediateMaterialBean != null) {
                    MemberTaskAdHelper memberTaskAdHelper = MemberTaskAdHelper.this;
                    BaseStageTaskAdHelper.A(memberTaskAdHelper, new v.b(null, 1, null), null, 2, null);
                    function1 = memberTaskAdHelper.n;
                    if (function1 != null) {
                        function1.invoke(Boolean.TRUE);
                    }
                }
            }
        };
    }

    private final void T() {
        BiddingSspNativeManager biddingSspNativeManager = this.k;
        if (biddingSspNativeManager != null) {
            biddingSspNativeManager.K0((oh.a) null);
        }
        BiddingSspNativeManager biddingSspNativeManager2 = this.k;
        if (biddingSspNativeManager2 != null) {
            biddingSspNativeManager2.U();
        }
        this.k = null;
    }

    private final void U() {
        BiddingVideoManager biddingVideoManager = this.m;
        if (biddingVideoManager != null) {
            biddingVideoManager.K0((oh.a) null);
        }
        BiddingVideoManager biddingVideoManager2 = this.m;
        if (biddingVideoManager2 != null) {
            biddingVideoManager2.U();
        }
        this.m = null;
    }

    private final void V() {
        BiddingSspNativeManager biddingSspNativeManager = this.i;
        if (biddingSspNativeManager != null) {
            biddingSspNativeManager.K0((oh.a) null);
        }
        BiddingSspNativeManager biddingSspNativeManager2 = this.i;
        if (biddingSspNativeManager2 != null) {
            biddingSspNativeManager2.U();
        }
        this.i = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List W(String str, List list, Boolean bool) {
        Iterator it = list.iterator();
        while (true) {
            String str2 = "Regular";
            if (!it.hasNext()) {
                break;
            }
            BiddingIntermediateMaterialBean biddingIntermediateMaterialBean = (BiddingIntermediateMaterialBean) it.next();
            a.a aVar = wf.a.a;
            if (Intrinsics.c(bool, Boolean.TRUE)) {
                str2 = "Stage";
            }
            a.a.f(aVar, "StageTaskAd", "MemberTaskAdHelper ----> " + str2 + " loaded item, packageName: " + g(biddingIntermediateMaterialBean), false, 4, (Object) null);
        }
        List I0 = CollectionsKt.I0(list, new Comparator() { // from class: com.transsion.rewardscenter.task.ad.MemberTaskAdHelper$filterAds$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t2, T t3) {
                Double ecpm = ((BiddingIntermediateMaterialBean) t3).getEcpm();
                Double valueOf = Double.valueOf(ecpm != null ? ecpm.doubleValue() : 0.0d);
                Double ecpm2 = ((BiddingIntermediateMaterialBean) t2).getEcpm();
                return ComparisonsKt.d(valueOf, Double.valueOf(ecpm2 != null ? ecpm2.doubleValue() : 0.0d));
            }
        });
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : I0) {
            if (hashSet.add(g((BiddingIntermediateMaterialBean) obj))) {
                arrayList.add(obj);
            }
        }
        ArrayList<BiddingIntermediateMaterialBean> arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (!u.a.m(str, g((BiddingIntermediateMaterialBean) obj2))) {
                arrayList2.add(obj2);
            }
        }
        for (BiddingIntermediateMaterialBean biddingIntermediateMaterialBean2 : arrayList2) {
            a.a aVar2 = wf.a.a;
            String str3 = Intrinsics.c(bool, Boolean.TRUE) ? "Stage" : "Regular";
            a.a.f(aVar2, "StageTaskAd", "MemberTaskAdHelper ----> " + str3 + " filtered item, packageName: " + g(biddingIntermediateMaterialBean2), false, 4, (Object) null);
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int a0() {
        return com.transsion.ad.scene.a.a.g("MemberTaskRegularNativeScene");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int b0() {
        return com.transsion.ad.scene.a.a.g("MemberTaskStageNativeScene");
    }

    public final void Q(v.a aVar) {
        Intrinsics.h(aVar, "data");
        if (aVar.f()) {
            return;
        }
        aVar.n(true);
        a.a.f(wf.a.a, "StageTaskAd", "MemberTaskAdHelper ----> bindRegularNativeAd", false, 4, (Object) null);
        if (this.k == null) {
            R();
        }
        aVar.p(new NativeWrapperAdView(this.g, null, 2, null));
        aVar.l(new d0(this.g));
        aVar.q(new w(this.g));
        NativeWrapperAdView h = aVar.h();
        if (h != null) {
            h.bindSspNativeView(this.k, aVar.d(), aVar.j(), aVar.c());
        }
    }

    public final void R() {
        BiddingSspNativeManager biddingSspNativeManager = new BiddingSspNativeManager();
        this.k = biddingSspNativeManager;
        biddingSspNativeManager.L0("MemberTaskRegularNativeScene");
        biddingSspNativeManager.K0(this.p);
    }

    public final void S() {
        BiddingSspNativeManager biddingSspNativeManager = new BiddingSspNativeManager();
        this.i = biddingSspNativeManager;
        biddingSspNativeManager.L0("MemberTaskStageNativeScene");
        biddingSspNativeManager.K0(this.o);
    }

    public final void X(Function1 function1) {
        Intrinsics.h(function1, "callback");
        this.l = function1;
        if (u() > 0 || t() > 0) {
            T();
            R();
            n0 n0Var = this.h;
            if (n0Var != null) {
                kotlinx.coroutines.i.d(n0Var, y0.b(), (CoroutineStart) null, new MemberTaskAdHelper$loadRegularAd$1(this, null), 2, (Object) null);
            }
        }
    }

    public final void Y(Function1 function1) {
        Intrinsics.h(function1, "callback");
        this.n = function1;
        U();
        n0 n0Var = this.h;
        if (n0Var != null) {
            kotlinx.coroutines.i.d(n0Var, y0.b(), (CoroutineStart) null, new MemberTaskAdHelper$loadRewardAd$1(this, null), 2, (Object) null);
        }
    }

    public final void Z(Function1 function1) {
        Intrinsics.h(function1, "callback");
        this.j = function1;
        if (v() <= 0) {
            return;
        }
        V();
        n0 n0Var = this.h;
        if (n0Var != null) {
            kotlinx.coroutines.i.d(n0Var, y0.b(), (CoroutineStart) null, new MemberTaskAdHelper$loadStageAd$1(this, null), 2, (Object) null);
        }
    }

    @Override // com.transsion.rewardscenter.task.ad.BaseStageTaskAdHelper
    public void c(v.c cVar) {
        Intrinsics.h(cVar, "data");
        if (cVar.f()) {
            return;
        }
        cVar.n(true);
        if (this.i == null) {
            S();
        }
        cVar.p(new NativeWrapperAdView(this.g, null, 2, null));
        cVar.l(new d0(this.g));
        cVar.r(new w(this.g));
        NativeWrapperAdView h = cVar.h();
        if (h != null) {
            h.bindSspNativeView(this.i, cVar.d(), cVar.k(), cVar.c());
        }
    }

    @Override // com.transsion.rewardscenter.task.ad.BaseStageTaskAdHelper
    public void d() {
        super.d();
        BiddingSspNativeManager biddingSspNativeManager = this.i;
        if (biddingSspNativeManager != null) {
            biddingSspNativeManager.K0((oh.a) null);
        }
        this.i = null;
        BiddingSspNativeManager biddingSspNativeManager2 = this.k;
        if (biddingSspNativeManager2 != null) {
            biddingSspNativeManager2.K0((oh.a) null);
        }
        this.k = null;
        U();
        this.j = null;
        this.l = null;
        this.n = null;
    }
}
