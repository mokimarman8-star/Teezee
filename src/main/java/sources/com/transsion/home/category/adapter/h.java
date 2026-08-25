package com.transsion.home.category.adapter;

import android.content.Context;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.ad.bidding.base.r;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.home.R;
import com.transsion.moviedetailapi.bean.Subject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h extends BaseItemProvider {
    public int l() {
        return 2;
    }

    public int m() {
        return R.layout.item_ad;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, Subject subject) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(subject, "item");
        ow.b bVar = ow.b.a;
        Context k = k();
        BiddingNativeManager nonAdDelegate = subject.getNonAdDelegate();
        r a = bVar.a(k, nonAdDelegate != null ? nonAdDelegate.getSceneId() : null);
        NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) baseViewHolder.getViewOrNull(R.id.ad_container);
        if (nativeWrapperAdView != null) {
            BiddingNativeManager nonAdDelegate2 = subject.getNonAdDelegate();
            BiddingNativeManager nonAdDelegate3 = subject.getNonAdDelegate();
            nativeWrapperAdView.bindNativeView(nonAdDelegate2, a, nonAdDelegate3 != null ? nonAdDelegate3.k0() : null);
        }
    }
}
