package vq;

import android.content.Context;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.ad.bidding.base.r;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.shorttv.R;
import com.transsion.shorttv.bean.Staff;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a extends BaseItemProvider {
    public int l() {
        return 2;
    }

    public int m() {
        return R.layout.short_tv_item_ad;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, Staff staff) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(staff, "item");
        sq.a aVar = sq.a.a;
        Context k = k();
        BiddingNativeManager nonAdDelegate = staff.getNonAdDelegate();
        r a = aVar.a(k, nonAdDelegate != null ? nonAdDelegate.getSceneId() : null);
        NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) baseViewHolder.getViewOrNull(R.id.ad_container);
        if (nativeWrapperAdView != null) {
            BiddingNativeManager nonAdDelegate2 = staff.getNonAdDelegate();
            BiddingNativeManager nonAdDelegate3 = staff.getNonAdDelegate();
            nativeWrapperAdView.bindNativeView(nonAdDelegate2, a, nonAdDelegate3 != null ? nonAdDelegate3.k0() : null);
        }
    }
}
