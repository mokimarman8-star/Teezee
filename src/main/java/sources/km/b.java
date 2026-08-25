package km;

import android.content.Context;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.ad.bidding.base.r;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.flow.bean.MediaType;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b extends a {
    public int l() {
        return MediaType.SUBJECT_DETAIL_NATIVE_AD.ordinal();
    }

    public int m() {
        return R$layout.subject_detail_item_native_ad_layout;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, PostSubjectItem postSubjectItem) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(postSubjectItem, "item");
        ow.b bVar = ow.b.a;
        Context k = k();
        BiddingNativeManager nonAdDelegate = postSubjectItem.getNonAdDelegate();
        r a = bVar.a(k, nonAdDelegate != null ? nonAdDelegate.getSceneId() : null);
        NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) baseViewHolder.getViewOrNull(R$id.adTrendingTAdNativeView);
        if (nativeWrapperAdView != null) {
            BiddingNativeManager nonAdDelegate2 = postSubjectItem.getNonAdDelegate();
            BiddingNativeManager nonAdDelegate3 = postSubjectItem.getNonAdDelegate();
            nativeWrapperAdView.bindNativeView(nonAdDelegate2, a, nonAdDelegate3 != null ? nonAdDelegate3.k0() : null);
        }
    }
}
