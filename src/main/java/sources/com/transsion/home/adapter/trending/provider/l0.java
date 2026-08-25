package com.transsion.home.adapter.trending.provider;

import android.content.Context;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.home.R;
import com.transsion.home.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class l0 extends BaseItemProvider {
    public int l() {
        return PostItemType.TRENDING_NATIVE_AD.ordinal();
    }

    public int m() {
        return R.layout.post_list_item_native_ad_layout;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, OperateItem operateItem) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        ow.b bVar = ow.b.a;
        Context k = k();
        BiddingNativeManager nonAdDelegate = operateItem.getNonAdDelegate();
        com.transsion.ad.bidding.base.r a = bVar.a(k, nonAdDelegate != null ? nonAdDelegate.getSceneId() : null);
        NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) baseViewHolder.getViewOrNull(R.id.nativeView);
        if (nativeWrapperAdView != null) {
            BiddingNativeManager nonAdDelegate2 = operateItem.getNonAdDelegate();
            BiddingNativeManager nonAdDelegate3 = operateItem.getNonAdDelegate();
            nativeWrapperAdView.bindNativeView(nonAdDelegate2, a, nonAdDelegate3 != null ? nonAdDelegate3.k0() : null);
        }
    }
}
