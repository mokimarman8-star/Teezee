package com.transsion.home.fragment.tab;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.transsion.home.bean.AppointSubject;
import com.transsion.home.bean.BannerBean;
import com.transsion.home.bean.BannerData;
import com.transsion.home.bean.CustomData;
import com.transsion.home.bean.LiveListItem;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.viewmodel.TrendingViewModel;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TrendingFragment$e implements rk.a {
    final /* synthetic */ TrendingFragment a;

    TrendingFragment$e(TrendingFragment trendingFragment) {
        this.a = trendingFragment;
    }

    @Override // rk.a
    public void a(int i, long j, View view) {
        List<BannerData> banners;
        androidx.lifecycle.b0 W;
        List<BannerData> items;
        try {
            BaseQuickAdapter V0 = TrendingFragment.V0(this.a);
            com.transsion.home.adapter.trending.b bVar = null;
            if (V0 == null) {
                Intrinsics.y("mAdapter");
                V0 = null;
            }
            OperateItem operateItem = (OperateItem) V0.getData().get(i);
            TrendingFragment.c1(this.a, i);
            String type = operateItem.getType();
            if (Intrinsics.c(type, PostItemType.OP_SUBJECTS_MOVIE.getValue())) {
                List<AppointSubject> subjects = operateItem.getSubjects();
                if (subjects != null) {
                    zk.c.a.s(operateItem, operateItem.getType() + "_Full", subjects, j, i);
                    return;
                }
                return;
            }
            if (Intrinsics.c(type, PostItemType.CUSTOM_DATA.getValue())) {
                CustomData customData = operateItem.getCustomData();
                if (customData == null || (items = customData.getItems()) == null) {
                    return;
                }
                zk.c.a.b(operateItem, operateItem.getType() + "_Full", items, j, i);
                return;
            }
            if (!Intrinsics.c(type, PostItemType.HORIZONTAL_BANNER.getValue()) && !Intrinsics.c(type, PostItemType.BANNER.getValue())) {
                if (Intrinsics.c(type, PostItemType.SPORT_LIVE.getValue())) {
                    List<LiveListItem> liveList = operateItem.getLiveList();
                    if (liveList != null) {
                        zk.c.a.t(operateItem, operateItem.getType() + "_Full", liveList, j, i);
                        return;
                    }
                    return;
                }
                if (Intrinsics.c(type, PostItemType.ROOM.getValue())) {
                    TrendingViewModel X0 = TrendingFragment.X0(this.a);
                    if (X0 == null || (W = X0.W()) == null) {
                        return;
                    }
                    return;
                }
                if (Intrinsics.c(type, PostItemType.SINGLE_IMAGE.getValue())) {
                    zk.c.a.e(i, j, operateItem);
                    return;
                }
                rk.c C1 = this.a.C1();
                if (C1 != null) {
                    com.transsion.home.adapter.trending.b V02 = TrendingFragment.V0(this.a);
                    if (V02 == null) {
                        Intrinsics.y("mAdapter");
                    } else {
                        bVar = V02;
                    }
                    C1.a(bVar, i, j);
                    return;
                }
                return;
            }
            BannerBean banner = operateItem.getBanner();
            if (banner == null || (banners = banner.getBanners()) == null) {
                return;
            }
            zk.c.a.b(operateItem, operateItem.getType() + "_Full", banners, j, i);
        } catch (Exception e) {
            String message = e.getMessage();
            if (message != null) {
                a.a.f(wf.a.a, "reportExposure", message, false, 4, (Object) null);
            }
        }
    }
}
