package com.transsion.home.fragment.tab;

import androidx.fragment.app.FragmentActivity;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.wrapperad.view.secondfloor.CustomSwipeRefreshLayout;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TrendingFragment$d implements CustomSwipeRefreshLayout.b {
    final /* synthetic */ TrendingFragment a;

    TrendingFragment$d(TrendingFragment trendingFragment) {
        this.a = trendingFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(TrendingFragment trendingFragment) {
        trendingFragment.c0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(TrendingFragment trendingFragment) {
        trendingFragment.c0();
    }

    public void a(String str, float f, float f2) {
        CustomSwipeRefreshLayout customSwipeRefreshLayout;
        CustomSwipeRefreshLayout customSwipeRefreshLayout2;
        qk.x xVar;
        CustomSwipeRefreshLayout customSwipeRefreshLayout3;
        CustomSwipeRefreshLayout customSwipeRefreshLayout4;
        CustomSwipeRefreshLayout customSwipeRefreshLayout5;
        CustomSwipeRefreshLayout customSwipeRefreshLayout6;
        qk.x xVar2;
        CustomSwipeRefreshLayout customSwipeRefreshLayout7;
        Intrinsics.h(str, "action");
        if (Intrinsics.c(str, "DOWN")) {
            TrendingFragment trendingFragment = this.a;
            BaseActivity activity = trendingFragment.getActivity();
            BaseActivity baseActivity = activity instanceof BaseActivity ? activity : null;
            TrendingFragment.d1(trendingFragment, baseActivity != null ? baseActivity.hasAd() : false);
        }
        if (!TrendingFragment.T0(this.a)) {
            if (Intrinsics.c(str, "DOWN") && (xVar2 = (qk.x) this.a.getMViewBinding()) != null && (customSwipeRefreshLayout7 = xVar2.e) != null) {
                customSwipeRefreshLayout7.setProgressViewOffset(false, TrendingFragment.W0(this.a), TrendingFragment.W0(this.a) + com.blankj.utilcode.util.a0.a(50.0f));
            }
            qk.x xVar3 = (qk.x) this.a.getMViewBinding();
            if (xVar3 == null || (customSwipeRefreshLayout6 = xVar3.e) == null) {
                return;
            }
            customSwipeRefreshLayout6.setCurrentState("IDLE");
            return;
        }
        FragmentActivity activity2 = this.a.getActivity();
        BaseActivity baseActivity2 = activity2 instanceof BaseActivity ? (BaseActivity) activity2 : null;
        if (baseActivity2 != null) {
            baseActivity2.onAction(str, f, f2);
        }
        int hashCode = str.hashCode();
        if (hashCode == -1435393951) {
            if (str.equals("SECOND_FLOOR")) {
                qk.x xVar4 = (qk.x) this.a.getMViewBinding();
                if (xVar4 != null && (customSwipeRefreshLayout2 = xVar4.e) != null) {
                    customSwipeRefreshLayout2.setRefreshing(true);
                }
                qk.x xVar5 = (qk.x) this.a.getMViewBinding();
                if (xVar5 == null || (customSwipeRefreshLayout = xVar5.e) == null) {
                    return;
                }
                final TrendingFragment trendingFragment2 = this.a;
                customSwipeRefreshLayout.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.tab.t1
                    @Override // java.lang.Runnable
                    public final void run() {
                        TrendingFragment$d.e(trendingFragment2);
                    }
                }, 300L);
                return;
            }
            return;
        }
        if (hashCode == 2715) {
            str.equals("UP");
            return;
        }
        if (hashCode == 2104482) {
            if (!str.equals("DOWN") || (xVar = (qk.x) this.a.getMViewBinding()) == null || (customSwipeRefreshLayout3 = xVar.e) == null) {
                return;
            }
            customSwipeRefreshLayout3.setProgressViewOffset(false, -600, -600);
            return;
        }
        if (hashCode == 1803427515 && str.equals("REFRESH")) {
            qk.x xVar6 = (qk.x) this.a.getMViewBinding();
            if (xVar6 != null && (customSwipeRefreshLayout5 = xVar6.e) != null) {
                customSwipeRefreshLayout5.setRefreshing(true);
            }
            qk.x xVar7 = (qk.x) this.a.getMViewBinding();
            if (xVar7 == null || (customSwipeRefreshLayout4 = xVar7.e) == null) {
                return;
            }
            final TrendingFragment trendingFragment3 = this.a;
            customSwipeRefreshLayout4.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.tab.s1
                @Override // java.lang.Runnable
                public final void run() {
                    TrendingFragment$d.d(trendingFragment3);
                }
            }, 300L);
        }
    }
}
