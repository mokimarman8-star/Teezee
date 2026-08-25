package com.transsion.shorttv.ui.adapter;

import android.content.Context;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.shorttv.R;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class f extends BaseItemProvider {
    private final int e = R.layout.short_tv_item_immersion_ad;

    public int l() {
        return 2;
    }

    public int m() {
        return this.e;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, nr.k item) {
        NativeWrapperAdView viewOrNull;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        if (!(item instanceof nr.c) || (viewOrNull = helper.getViewOrNull(R.id.flRoot)) == null) {
            return;
        }
        yq.b bVar = yq.b.a;
        Context k = k();
        nr.c cVar = (nr.c) item;
        BiddingNativeManager a = cVar.a();
        com.transsion.ad.bidding.base.r a2 = bVar.a(k, a != null ? a.getSceneId() : null);
        BiddingNativeManager a3 = cVar.a();
        BiddingNativeManager a4 = cVar.a();
        viewOrNull.bindNativeView(a3, a2, a4 != null ? a4.k0() : null);
    }
}
