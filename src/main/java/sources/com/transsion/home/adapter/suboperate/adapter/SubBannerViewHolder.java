package com.transsion.home.adapter.suboperate.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.transsion.gslb.BuildConfig;
import com.transsion.gslb.Utils;
import com.transsion.home.R;
import com.transsion.home.bean.BannerData;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.Image;
import com.transsnet.downloader.DownloadManagerApi;
import java.util.HashMap;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SubBannerViewHolder extends RecyclerView.a0 {
    private final int a;
    private final com.transsion.home.adapter.suboperate.provider.i b;
    private final OperateItem c;
    private final View d;
    private final View e;
    private final ImageView f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubBannerViewHolder(View view, int i, com.transsion.home.adapter.suboperate.provider.i iVar, OperateItem operateItem) {
        super(view);
        Intrinsics.h(view, "itemView");
        Intrinsics.h(iVar, "bannerProvider");
        Intrinsics.h(operateItem, "operateItem");
        this.a = i;
        this.b = iVar;
        this.c = operateItem;
        View findViewById = view.findViewById(R.id.home_sub_pager_items_status);
        Intrinsics.g(findViewById, "findViewById(...)");
        this.d = findViewById;
        View findViewById2 = view.findViewById(R.id.home_sub_pager_items_top_mask);
        Intrinsics.g(findViewById2, "findViewById(...)");
        this.e = findViewById2;
        View findViewById3 = view.findViewById(R.id.home_sub_pager_item_image);
        Intrinsics.g(findViewById3, "findViewById(...)");
        this.f = (ImageView) findViewById3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(BannerData bannerData, SubBannerViewHolder subBannerViewHolder, int i, View view) {
        String deepLink = bannerData.getDeepLink();
        if (deepLink != null) {
            if (!yg.l.a.e()) {
                fh.b.a.d(com.tn.lib.widget.R.string.no_network_toast);
                return;
            }
            Uri g = com.transsion.baselib.helper.b.a.g(Uri.parse(deepLink + "&module_name=opt_banner_free&autoPlay=true&ops=" + bannerData.getOps()));
            if (g != null) {
                ij.k.o(g);
            }
            subBannerViewHolder.k(bannerData, i, DownloadManagerApi.x0(DownloadManagerApi.j.a(), bannerData.getSubjectId(), (String) null, false, false, 12, (Object) null) ? "play_subject" : "download_subject");
        }
    }

    private final GradientDrawable i(String str) {
        int parseColor = Color.parseColor(str);
        int red = Color.red(parseColor);
        int green = Color.green(parseColor);
        int blue = Color.blue(parseColor);
        int argb = Color.argb(255, red, green, blue);
        int argb2 = Color.argb(153, red, green, blue);
        int argb3 = Color.argb(0, red, green, blue);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setColors(new int[]{argb, argb2, argb3});
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        return gradientDrawable;
    }

    private final void j(BannerData bannerData, int i) {
        if (this.b.T(bannerData != null ? bannerData.getSubjectId() : null)) {
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "browse_banner");
            hashMap.put("sequence", String.valueOf(i));
            hashMap.put("tabId", String.valueOf(this.a));
            if (bannerData != null) {
                sk.b.b(bannerData, hashMap);
            }
            sk.b.a(this.c, hashMap);
            com.transsion.baselib.helper.a.a.e(SubTabFragment.INSTANCE.a(this.a), hashMap);
        }
    }

    private final void k(BannerData bannerData, int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "click_banner_poster");
        hashMap.put("sequence", String.valueOf(i));
        hashMap.put("module_name", str);
        hashMap.put("tabId", String.valueOf(this.a));
        if (bannerData != null) {
            sk.b.b(bannerData, hashMap);
        }
        sk.b.a(this.c, hashMap);
        com.transsion.baselib.helper.a.a.f(SubTabFragment.INSTANCE.a(this.a), hashMap);
    }

    public final void g(final BannerData bannerData, final int i) {
        String str;
        String thumbnail;
        if (bannerData == null) {
            return;
        }
        zg.h hVar = zg.h.a;
        Context context = this.f.getContext();
        Intrinsics.g(context, "getContext(...)");
        int e = hVar.e(context);
        if (bannerData.getBuiltIn()) {
            kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new SubBannerViewHolder$bindData$1(bannerData, this, null), 3, (Object) null);
        } else {
            f.a aVar = ni.f.a;
            Context context2 = this.f.getContext();
            Intrinsics.g(context2, "getContext(...)");
            f.b m = aVar.m(context2);
            Image image = bannerData.getImage();
            String str2 = BuildConfig.FLAVOR;
            if (image == null || (str = image.getUrl()) == null) {
                str = BuildConfig.FLAVOR;
            }
            f.b m2 = m.g(str).m(e);
            Image image2 = bannerData.getImage();
            if (image2 != null && (thumbnail = image2.getThumbnail()) != null) {
                str2 = thumbnail;
            }
            m2.l(str2).d(this.f);
        }
        this.d.getLayoutParams().height = com.blankj.utilcode.util.d.c() + a0.a(44.0f);
        Image image3 = bannerData.getImage();
        String averageHueDark = image3 != null ? image3.getAverageHueDark() : null;
        if (averageHueDark != null && StringsKt.c0(averageHueDark, Utils.SEPARATOR, false, 2, (Object) null)) {
            this.d.setBackgroundColor(Color.parseColor(averageHueDark));
            this.e.setBackground(i(averageHueDark));
        }
        j(bannerData, i);
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.adapter.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubBannerViewHolder.h(BannerData.this, this, i, view);
            }
        });
    }

    public final ImageView getImageView() {
        return this.f;
    }
}
