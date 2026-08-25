package com.transsion.home.adapter.operateUGC.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.bean.BannerData;
import com.transsion.home.bean.OperateItem;
import com.transsion.moviedetailapi.bean.Image;
import ij.k;
import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import ni.f;
import yg.l;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class BannerUGCAdapter extends RecyclerView.Adapter {
    private final List a;
    private final int b;
    private final com.transsion.home.adapter.operateUGC.provider.c c;
    private final OperateItem d;
    private final int e;
    private final int f;

    public static final class a extends RecyclerView.a0 {
        private final ImageView a;
        private final TextView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            Intrinsics.h(view, "itemView");
            View findViewById = view.findViewById(R.id.home_ugc_banner_item_image);
            Intrinsics.g(findViewById, "findViewById(...)");
            this.a = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.home_ugc_banner_title);
            Intrinsics.g(findViewById2, "findViewById(...)");
            this.b = (TextView) findViewById2;
        }

        public final TextView f() {
            return this.b;
        }

        public final ImageView getImageView() {
            return this.a;
        }
    }

    public BannerUGCAdapter(List list, int i, com.transsion.home.adapter.operateUGC.provider.c cVar, OperateItem operateItem) {
        Intrinsics.h(list, "banners");
        Intrinsics.h(cVar, "bannerProvider");
        Intrinsics.h(operateItem, "operateItem");
        this.a = list;
        this.b = i;
        this.c = cVar;
        this.d = operateItem;
        int e = y.e() - (a0.a(12.0f) * 2);
        this.e = e;
        this.f = Intrinsics.c(operateItem.getStyleTemplate(), "BANNER_NARROW") ? (e * 5) / 14 : (e * 9) / 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(BannerData bannerData, BannerUGCAdapter bannerUGCAdapter, int i, View view) {
        String deepLink;
        if (bannerData == null || (deepLink = bannerData.getDeepLink()) == null) {
            return;
        }
        if (!l.a.e()) {
            fh.b.a.d(com.tn.lib.widget.R.string.no_network_toast);
            return;
        }
        k.g(deepLink, "&module_name=opt_banner_free&from_opt_id=" + bannerUGCAdapter.d.getOpId() + "&ops=" + bannerData.getOps() + "&tab_id=" + bannerUGCAdapter.b);
        rk.d.c.b(bannerUGCAdapter.b, i, bannerUGCAdapter.d, bannerData);
    }

    private final void k(BannerData bannerData, int i) {
        if (this.c.I(bannerData != null ? bannerData.getDeepLink() : null)) {
            rk.d.c.a(this.b, i, this.d, bannerData);
        }
    }

    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i) {
        String str;
        String str2;
        Image image;
        Image image2;
        String content;
        Intrinsics.h(aVar, "holder");
        if (this.a.isEmpty()) {
            return;
        }
        final int size = i % this.a.size();
        final BannerData bannerData = (BannerData) this.a.get(size);
        String str3 = BuildConfig.FLAVOR;
        if (bannerData == null || !bannerData.getBuiltIn()) {
            f.a aVar2 = ni.f.a;
            Context context = aVar.getImageView().getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b m = aVar2.m(context);
            if (bannerData == null || (image2 = bannerData.getImage()) == null || (str = image2.getUrl()) == null) {
                str = BuildConfig.FLAVOR;
            }
            f.b m2 = m.g(str).m(this.e);
            if (bannerData == null || (image = bannerData.getImage()) == null || (str2 = image.getThumbnail()) == null) {
                str2 = BuildConfig.FLAVOR;
            }
            m2.l(str2).d(aVar.getImageView());
        } else {
            i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new BannerUGCAdapter$onBindViewHolder$1(bannerData, aVar, null), 3, (Object) null);
        }
        TextView f = aVar.f();
        if (bannerData != null && (content = bannerData.getContent()) != null) {
            str3 = content;
        }
        f.setText(str3);
        k(bannerData, size);
        aVar.getImageView().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.operateUGC.adapter.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BannerUGCAdapter.i(BannerData.this, this, size, view);
            }
        });
    }

    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.h(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_ugc_banner, viewGroup, false);
        Intrinsics.e(inflate);
        a aVar = new a(inflate);
        aVar.getImageView().getLayoutParams().height = this.f;
        return aVar;
    }
}
