package mk;

import android.widget.FrameLayout;
import androidx.constraintlayout.widget.Group;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.ad.bidding.base.r;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.home.R;
import com.transsion.home.bean.UGCFilterVideoItem;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a extends BaseItemProvider {
    public static final C0084a h = new C0084a(null);
    public static final int i = 8;
    private final rk.b e;
    private final int f = 4;
    private final int g = R.layout.ugc_item_filter_source;

    /* renamed from: mk.a$a, reason: collision with other inner class name */
    public static final class C0084a {
        private C0084a() {
        }

        public /* synthetic */ C0084a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(rk.b bVar) {
        this.e = bVar;
    }

    public int l() {
        return this.f;
    }

    public int m() {
        return this.g;
    }

    public void v(BaseViewHolder baseViewHolder, int i2) {
        Intrinsics.h(baseViewHolder, "viewHolder");
        super.v(baseViewHolder, i2);
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, UGCFilterVideoItem uGCFilterVideoItem) {
        Intrinsics.h(baseViewHolder, "holder");
        Intrinsics.h(uGCFilterVideoItem, "item");
        BiddingNativeManager nonAdDelegate = uGCFilterVideoItem.getNonAdDelegate();
        if (nonAdDelegate == null) {
            FrameLayout frameLayout = (FrameLayout) baseViewHolder.getViewOrNull(R.id.nativeView);
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            Group viewOrNull = baseViewHolder.getViewOrNull(R.id.group);
            if (viewOrNull != null) {
                viewOrNull.setVisibility(0);
                return;
            }
            return;
        }
        r a = ow.b.a.a(k(), nonAdDelegate.getSceneId());
        NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) baseViewHolder.getViewOrNull(R.id.nativeView);
        if (nativeWrapperAdView != null) {
            BiddingNativeManager nonAdDelegate2 = uGCFilterVideoItem.getNonAdDelegate();
            nativeWrapperAdView.bindNativeView(nonAdDelegate, a, nonAdDelegate2 != null ? nonAdDelegate2.k0() : null);
        }
        FrameLayout frameLayout2 = (FrameLayout) baseViewHolder.getViewOrNull(R.id.nativeView);
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
        }
        Group viewOrNull2 = baseViewHolder.getViewOrNull(R.id.group);
        if (viewOrNull2 != null) {
            viewOrNull2.setVisibility(8);
        }
    }
}
