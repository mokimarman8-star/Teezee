package com.transsion.home.adapter.suboperate.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.edcation.CourseManager;
import com.transsion.flow.bean.LayoutStyle;
import com.transsion.flow.bean.PlayUrl;
import com.transsion.flow.bean.SubjectGameInfo;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.adapter.suboperate.adapter.SubHorizontalViewPagerAdapter;
import com.transsion.home.bean.BannerData;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.p000enum.HomeTabId;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.SubjectDl;
import com.transsion.moviedetailapi.bean.Trailer;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.widget.DownloadView;
import java.util.HashMap;
import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SubHorizontalViewPagerAdapter extends RecyclerView.Adapter {
    private final List a;
    private final int b;
    private final OperateItem c;
    private final int d;
    private final int e;

    public static final class a extends RecyclerView.a0 {
        private final ImageView a;
        private final DownloadView b;
        private final TextView c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            Intrinsics.h(view, "itemView");
            View findViewById = view.findViewById(R.id.home_sub_pager_item_image);
            Intrinsics.g(findViewById, "findViewById(...)");
            this.a = (ImageView) findViewById;
            DownloadView findViewById2 = view.findViewById(R.id.sub_operation_banner_download);
            Intrinsics.g(findViewById2, "findViewById(...)");
            this.b = findViewById2;
            View findViewById3 = view.findViewById(R.id.sub_operation_banner_title);
            Intrinsics.g(findViewById3, "findViewById(...)");
            this.c = (TextView) findViewById3;
        }

        public final DownloadView f() {
            return this.b;
        }

        public final TextView g() {
            return this.c;
        }

        public final ImageView getImageView() {
            return this.a;
        }
    }

    public SubHorizontalViewPagerAdapter(List list, int i, OperateItem operateItem, int i2, int i3) {
        Intrinsics.h(list, "banners");
        Intrinsics.h(operateItem, "operateItem");
        this.a = list;
        this.b = i;
        this.c = operateItem;
        this.d = i2;
        this.e = i3;
    }

    private final Subject i(BannerData bannerData) {
        if (bannerData == null) {
            return null;
        }
        return new Subject(bannerData.getSubjectId(), Integer.valueOf(bannerData.getSubjectType()), (String) null, (String) null, (Cover) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, bannerData.getSeenStatus(), (List) null, (Long) null, (Boolean) null, (String) null, (SubjectDl) null, (List) null, (Cover) null, (Trailer) null, false, false, (BiddingNativeManager) null, (String) null, (Long) null, (String) null, (String) null, false, false, (ShortTVItem) null, (ShortTVFavInfo) null, 0, false, false, 0L, (String) null, (List) null, 0L, (List) null, 0, false, (Integer) null, 0, (SubjectGameInfo) null, (String) null, (List) null, (String) null, (String) null, 0, (Long) null, (Integer) null, (LayoutStyle) null, (PlayUrl) null, (Boolean) null, -32772, 67108863, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(BannerData bannerData, SubHorizontalViewPagerAdapter subHorizontalViewPagerAdapter, int i, View view) {
        String deepLink;
        if (bannerData == null || (deepLink = bannerData.getDeepLink()) == null) {
            return;
        }
        Uri g = com.transsion.baselib.helper.b.a.g(Uri.parse(deepLink + "&module_name=opt_banner_free&autoPlay=true&ops=" + bannerData.getOps()));
        if (g != null) {
            hr.c.j(g);
        }
        subHorizontalViewPagerAdapter.p(bannerData, i, DownloadManagerApi.x0(DownloadManagerApi.j.a(), bannerData.getSubjectId(), (String) null, false, false, 12, (Object) null) ? "play_subject" : "download_subject");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(a aVar, BannerData bannerData, SubHorizontalViewPagerAdapter subHorizontalViewPagerAdapter, Context context, int i, View view) {
        if (aVar.f().getShowType() == 2 || aVar.f().getShowType() == 3) {
            if (bannerData != null) {
                CourseManager.a.v(bannerData.getSubjectId(), bannerData.getSeenStatus());
                fk.a.b(subHorizontalViewPagerAdapter.i(bannerData), SubTabFragment.INSTANCE.a(subHorizontalViewPagerAdapter.b), "opt_rank_list");
                return;
            }
            return;
        }
        String a2 = SubTabFragment.INSTANCE.a(subHorizontalViewPagerAdapter.b);
        Subject subject = new Subject(bannerData != null ? bannerData.getSubjectId() : null, (Integer) null, (String) null, (String) null, (Cover) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (List) null, (Long) null, (Boolean) null, (String) null, (SubjectDl) null, (List) null, (Cover) null, (Trailer) null, false, false, (BiddingNativeManager) null, (String) null, (Long) null, (String) null, (String) null, false, false, (ShortTVItem) null, (ShortTVFavInfo) null, 0, false, false, 0L, (String) null, (List) null, 0L, (List) null, 0, false, (Integer) null, 0, (SubjectGameInfo) null, (String) null, (List) null, (String) null, (String) null, 0, (Long) null, (Integer) null, (LayoutStyle) null, (PlayUrl) null, (Boolean) null, -2, 67108863, (DefaultConstructorMarker) null);
        Intrinsics.e(context);
        subHorizontalViewPagerAdapter.o(bannerData, i, zk.h.g(subject, a2, context, "opt_rank_list"));
    }

    private final void o(BannerData bannerData, int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "click_banner");
        hashMap.put("sequence", String.valueOf(i));
        hashMap.put("module_name", str);
        hashMap.put("tabId", String.valueOf(this.b));
        if (bannerData != null) {
            sk.b.b(bannerData, hashMap);
        }
        sk.b.a(this.c, hashMap);
        com.transsion.baselib.helper.a.a.f(SubTabFragment.INSTANCE.a(this.b), hashMap);
    }

    private final void p(BannerData bannerData, int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "click_banner_poster");
        hashMap.put("sequence", String.valueOf(i));
        hashMap.put("module_name", str);
        hashMap.put("tabId", String.valueOf(this.b));
        if (bannerData != null) {
            sk.b.b(bannerData, hashMap);
        }
        sk.b.a(this.c, hashMap);
        com.transsion.baselib.helper.a.a.f(SubTabFragment.INSTANCE.a(this.b), hashMap);
    }

    private final void q(BannerData bannerData, DownloadView downloadView) {
        Integer seenStatus;
        boolean z = false;
        if ((bannerData != null ? Intrinsics.c(bannerData.getHasResource(), Boolean.TRUE) : false) && HomeTabId.INSTANCE.h(Integer.valueOf(this.b), true)) {
            uf.c.k(downloadView);
        } else {
            if (bannerData != null ? Intrinsics.c(bannerData.getHasResource(), Boolean.TRUE) : false) {
                uf.c.k(downloadView);
            } else {
                uf.c.g(downloadView);
            }
        }
        if (HomeTabId.INSTANCE.h(Integer.valueOf(this.b), true)) {
            if (bannerData != null && (seenStatus = bannerData.getSeenStatus()) != null && seenStatus.intValue() == 1) {
                z = true;
            }
            if (z) {
                downloadView.setCourseAdded();
                return;
            } else {
                downloadView.setAddCourse();
                return;
            }
        }
        if (ij.t.a.b()) {
            if (bannerData != null && bannerData.getSubjectType() == SubjectType.SHORT_TV.getValue()) {
                z = true;
            }
            if (!z) {
                downloadView.setShowPlayType();
                return;
            }
        }
        DownloadView.setShowType$default(downloadView, bannerData != null ? bannerData.getSubjectId() : null, (String) null, (Boolean) null, false, com.tn.lib.widget.R.string.download_now, 14, (Object) null);
    }

    private final void r(a aVar, int i) {
        if (HomeTabId.INSTANCE.h(Integer.valueOf(this.b), true)) {
            if (i == 1) {
                aVar.f().setCourseAdded();
            } else {
                aVar.f().setAddCourse();
            }
        }
    }

    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final a aVar, final int i) {
        String str;
        String str2;
        Image image;
        Image image2;
        String content;
        Intrinsics.h(aVar, "holder");
        final Context context = aVar.getImageView().getContext();
        final BannerData bannerData = (BannerData) this.a.get(i % this.a.size());
        aVar.getImageView().getLayoutParams().height = this.e;
        String str3 = BuildConfig.FLAVOR;
        if (bannerData == null || !bannerData.getBuiltIn()) {
            f.a aVar2 = ni.f.a;
            Intrinsics.e(context);
            f.b m = aVar2.m(context);
            if (bannerData == null || (image2 = bannerData.getImage()) == null || (str = image2.getUrl()) == null) {
                str = BuildConfig.FLAVOR;
            }
            f.b m2 = m.g(str).m(this.d);
            if (bannerData == null || (image = bannerData.getImage()) == null || (str2 = image.getThumbnail()) == null) {
                str2 = BuildConfig.FLAVOR;
            }
            m2.l(str2).d(aVar.getImageView());
        } else {
            kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new SubHorizontalViewPagerAdapter$onBindViewHolder$1(bannerData, aVar, null), 3, (Object) null);
        }
        TextView g = aVar.g();
        if (bannerData != null && (content = bannerData.getContent()) != null) {
            str3 = content;
        }
        g.setText(str3);
        q(bannerData, aVar.f());
        aVar.getImageView().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.adapter.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubHorizontalViewPagerAdapter.l(BannerData.this, this, i, view);
            }
        });
        aVar.f().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.adapter.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubHorizontalViewPagerAdapter.m(SubHorizontalViewPagerAdapter.a.this, bannerData, this, context, i, view);
            }
        });
    }

    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i, List list) {
        Intrinsics.h(aVar, "holder");
        Intrinsics.h(list, "payloads");
        if (list.isEmpty()) {
            onBindViewHolder(aVar, i);
            return;
        }
        Object obj = list.get(list.size() - 1);
        if (obj instanceof Integer) {
            r(aVar, ((Number) obj).intValue());
        }
    }

    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.h(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_sub_horizontal_view_pager, viewGroup, false);
        Intrinsics.e(inflate);
        return new a(inflate);
    }
}
