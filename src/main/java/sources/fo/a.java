package fo;

import android.content.Context;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a extends BaseItemProvider {
    public int l() {
        return 2;
    }

    public int m() {
        return R$layout.item_for_you_ad_layout;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, Subject subject) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(subject, "item");
        ow.b bVar = ow.b.a;
        Context k = k();
        BiddingNativeManager nonAdDelegate = subject.getNonAdDelegate();
        com.transsion.ad.bidding.base.r a = bVar.a(k, nonAdDelegate != null ? nonAdDelegate.getSceneId() : null);
        NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) baseViewHolder.getViewOrNull(R$id.tAdNativeView);
        if (nativeWrapperAdView != null) {
            BiddingNativeManager nonAdDelegate2 = subject.getNonAdDelegate();
            BiddingNativeManager nonAdDelegate3 = subject.getNonAdDelegate();
            nativeWrapperAdView.bindNativeView(nonAdDelegate2, a, nonAdDelegate3 != null ? nonAdDelegate3.k0() : null);
        }
    }
}
