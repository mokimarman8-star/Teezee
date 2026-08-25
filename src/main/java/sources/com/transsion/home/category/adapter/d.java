package com.transsion.home.category.adapter;

import android.content.Context;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.base.r;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.flow.bean.CategoryItemBean;
import com.transsion.home.R;
import com.transsion.moviedetailapi.bean.Subject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d extends BaseItemProvider {
    public int l() {
        return 3;
    }

    public int m() {
        return R.layout.item_ad;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, CategoryItemBean categoryItemBean) {
        BiddingNativeManager nonAdDelegate;
        BiddingNativeManager nonAdDelegate2;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(categoryItemBean, "item");
        ow.b bVar = ow.b.a;
        Context k = k();
        Subject subject = categoryItemBean.getSubject();
        BiddingIntermediateMaterialBean biddingIntermediateMaterialBean = null;
        r a = bVar.a(k, (subject == null || (nonAdDelegate2 = subject.getNonAdDelegate()) == null) ? null : nonAdDelegate2.getSceneId());
        NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) baseViewHolder.getViewOrNull(R.id.ad_container);
        if (nativeWrapperAdView != null) {
            Subject subject2 = categoryItemBean.getSubject();
            BiddingNativeManager nonAdDelegate3 = subject2 != null ? subject2.getNonAdDelegate() : null;
            Subject subject3 = categoryItemBean.getSubject();
            if (subject3 != null && (nonAdDelegate = subject3.getNonAdDelegate()) != null) {
                biddingIntermediateMaterialBean = nonAdDelegate.k0();
            }
            nativeWrapperAdView.bindNativeView(nonAdDelegate3, a, biddingIntermediateMaterialBean);
        }
    }
}
