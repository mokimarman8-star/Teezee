package com.transsion.home.adapter.operateUGC.provider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.adapter.operateUGC.provider.s;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.p000enum.HomeTabId;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.ugcvideodetail.api.UGCVideoTypeKt;
import com.transsion.ugcvideodetail.api.bean.UGCContent;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import ni.f;
import rk.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class s extends BaseItemProvider {
    private final int e;

    public static final class a {
        private Integer a;
        private List b;

        public a(Integer num, List list) {
            Intrinsics.h(list, "contentList");
            this.a = num;
            this.b = list;
        }

        public final List a() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.c(this.a, aVar.a) && Intrinsics.c(this.b, aVar.b);
        }

        public int hashCode() {
            Integer num = this.a;
            return ((num == null ? 0 : num.hashCode()) * 31) + this.b.hashCode();
        }

        public String toString() {
            return "MusicRankData(index=" + this.a + ", contentList=" + this.b + ")";
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010!¨\u0006$"}, d2 = {"Lcom/transsion/home/adapter/operateUGC/provider/s$b;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/home/adapter/operateUGC/provider/s$a;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", BuildConfig.FLAVOR, "layoutResId", "Lcom/transsion/home/bean/OperateItem;", "operateItem", "tabId", "<init>", "(ILcom/transsion/home/bean/OperateItem;I)V", "Landroid/content/Context;", "context", "Lcom/transsion/ugcvideodetail/api/bean/UGCContent;", "ugcContent", "Landroid/view/ViewGroup;", "parent", "Landroid/view/View;", "E1", "(Landroid/content/Context;Lcom/transsion/ugcvideodetail/api/bean/UGCContent;Landroid/view/ViewGroup;)Landroid/view/View;", "rankListItem", "position", BuildConfig.FLAVOR, "F1", "(Lcom/transsion/home/adapter/operateUGC/provider/s$a;I)V", "G1", "holder", "item", "C1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/home/adapter/operateUGC/provider/s$a;)V", "F", "Lcom/transsion/home/bean/OperateItem;", "G", "I", "H", "perWidth", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @SourceDebugExtension
    public static final class b extends BaseQuickAdapter {
        public static final int I = 8;

        /* renamed from: F, reason: from kotlin metadata */
        private final OperateItem operateItem;

        /* renamed from: G, reason: from kotlin metadata */
        private final int tabId;

        /* renamed from: H, reason: from kotlin metadata */
        private final int perWidth;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i, OperateItem operateItem, int i2) {
            super(i, (List) null, 2, (DefaultConstructorMarker) null);
            Intrinsics.h(operateItem, "operateItem");
            this.operateItem = operateItem;
            this.tabId = i2;
            this.perWidth = com.blankj.utilcode.util.y.e() - lj.a.b(68);
        }

        public /* synthetic */ b(int i, OperateItem operateItem, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? R.layout.item_provider_ranklist : i, operateItem, i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void D1(UGCContent uGCContent, b bVar, a aVar, int i, View view) {
            gu.c.e(uGCContent, Integer.valueOf(bVar.tabId), bVar.operateItem.getOpId());
            bVar.G1(aVar, i);
        }

        private final View E1(Context context, UGCContent ugcContent, ViewGroup parent) {
            String str;
            String j;
            List q;
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_ugc_music_rank, parent, false);
            UGCVideo video = ugcContent.getVideo();
            if (video == null) {
                Intrinsics.e(inflate);
                return inflate;
            }
            ShapeableImageView findViewById = inflate.findViewById(R.id.home_ugc_music_rank_image);
            Intrinsics.g(findViewById, "findViewById(...)");
            ShapeableImageView shapeableImageView = findViewById;
            f.b m = ni.f.a.m(context);
            Cover cover = video.getCover();
            if (cover == null || (str = cover.getUrl()) == null) {
                str = BuildConfig.FLAVOR;
            }
            m.g(str).m(this.perWidth).d(shapeableImageView);
            ((TextView) inflate.findViewById(R.id.home_ugc_music_rank_corner)).setText(video.getCorner());
            ImageView imageView = (ImageView) inflate.findViewById(R.id.home_ugc_music_rank_type_icon);
            Intrinsics.e(imageView);
            UGCVideoTypeKt.i(imageView, video, (Integer) null, 4, (Object) null);
            TextView textView = (TextView) inflate.findViewById(R.id.home_ugc_music_rank_time_text);
            Long duration = video.getDuration();
            textView.setText(TimeUtilKt.a(duration != null ? Integer.valueOf((int) duration.longValue()) : null));
            ((TextView) inflate.findViewById(R.id.home_ugc_music_rank_title)).setText(video.getTitle());
            if (video.isVerticalImmStyle()) {
                q = CollectionsKt.q(new String[]{"special_#shorts_icon", Utils.a().getString(com.transsion.baseui.R.string.ugc_video_shorts), com.transsion.baseui.util.j.c(video.getWatchNum(), context)});
            } else {
                String c = com.transsion.baseui.util.j.c(video.getWatchNum(), context);
                if (this.tabId == HomeTabId.UGC_Trending.getValue()) {
                    Long publishTime = video.getPublishTime();
                    j = TimeUtilKt.k(publishTime != null ? publishTime.longValue() : 0L);
                } else {
                    Long publishTime2 = video.getPublishTime();
                    j = TimeUtilKt.j(publishTime2 != null ? publishTime2.longValue() : 0L);
                }
                q = CollectionsKt.q(new String[]{c, j});
            }
            ((TextView) inflate.findViewById(R.id.home_ugc_music_rank_subtitle)).setText(com.transsion.baseui.util.q.e(q, context));
            Intrinsics.e(inflate);
            return inflate;
        }

        private final void F1(a rankListItem, int position) {
            UGCVideo video;
            UGCContent uGCContent = (UGCContent) CollectionsKt.l0(rankListItem.a(), position);
            if (uGCContent == null || (video = uGCContent.getVideo()) == null) {
                return;
            }
            d.a.e(rk.d.c, this.tabId, position, this.operateItem, video, null, 16, null);
        }

        private final void G1(a rankListItem, int position) {
            d.a.g(rk.d.c, this.tabId, position, this.operateItem, ((UGCContent) rankListItem.a().get(position)).getVideo(), null, 16, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: C1, reason: merged with bridge method [inline-methods] */
        public void F(BaseViewHolder holder, final a item) {
            Intrinsics.h(holder, "holder");
            Intrinsics.h(item, "item");
            ViewGroup viewGroup = (LinearLayout) holder.getView(R.id.sub_operation_rankinglist_root);
            viewGroup.removeAllViews();
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            Intrinsics.f(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.width = this.perWidth;
            marginLayoutParams.rightMargin = lj.a.b(8);
            viewGroup.setLayoutParams(marginLayoutParams);
            viewGroup.setBackground(null);
            final int i = 0;
            for (Object obj : item.a()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.u();
                }
                final UGCContent uGCContent = (UGCContent) obj;
                View E1 = E1(getContext(), uGCContent, viewGroup);
                viewGroup.addView(E1);
                E1.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.operateUGC.provider.t
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        s.b.D1(uGCContent, this, item, i, view);
                    }
                });
                F1(item, i);
                i = i2;
            }
        }
    }

    public s(int i) {
        this.e = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(OperateItem operateItem, s sVar, View view) {
        String deepLink = operateItem.getDeepLink();
        if (deepLink != null) {
            ij.k.g(deepLink, "&filmListTitle=" + operateItem.getTitle());
        }
        sVar.E(operateItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(OperateItem operateItem, s sVar, View view) {
        String deepLink = operateItem.getDeepLink();
        if (deepLink != null) {
            ij.k.g(deepLink, "&filmListTitle=" + operateItem.getTitle());
        }
        sVar.E(operateItem);
    }

    private final void D(OperateItem operateItem) {
        List data;
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "all");
        BaseProviderMultiAdapter g = g();
        hashMap.put("position", String.valueOf((g == null || (data = g.getData()) == null) ? null : Integer.valueOf(data.indexOf(operateItem))));
        String title = operateItem.getTitle();
        if (title == null) {
            title = BuildConfig.FLAVOR;
        }
        hashMap.put("title", title);
        hashMap.put("tabId", String.valueOf(this.e));
        sk.b.a(operateItem, hashMap);
        com.transsion.baselib.helper.a.a.e(SubTabFragment.INSTANCE.a(this.e), hashMap);
    }

    private final void E(OperateItem operateItem) {
        List data;
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "all");
        BaseProviderMultiAdapter g = g();
        hashMap.put("position", String.valueOf((g == null || (data = g.getData()) == null) ? null : Integer.valueOf(data.indexOf(operateItem))));
        String title = operateItem.getTitle();
        if (title == null) {
            title = BuildConfig.FLAVOR;
        }
        hashMap.put("title", title);
        hashMap.put("tabId", String.valueOf(this.e));
        sk.b.a(operateItem, hashMap);
        com.transsion.baselib.helper.a.a.f(SubTabFragment.INSTANCE.a(this.e), hashMap);
    }

    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, final OperateItem operateItem) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        TextView textView = (TextView) baseViewHolder.getView(R.id.provider_ugc_common_title);
        textView.setText(operateItem.getTitle());
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.provider_ugc_common_more_text);
        String deepLink = operateItem.getDeepLink();
        if (deepLink == null || deepLink.length() == 0) {
            uf.c.h(textView2);
        } else {
            uf.c.k(textView2);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.operateUGC.provider.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    s.B(OperateItem.this, this, view);
                }
            });
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.operateUGC.provider.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    s.C(OperateItem.this, this, view);
                }
            });
            D(operateItem);
        }
        RecyclerView view = baseViewHolder.getView(R.id.provider_ugc_common_recycler);
        b bVar = new b(0, operateItem, this.e, 1, null);
        view.setAdapter(bVar);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(k(), 0, false);
        linearLayoutManager.setItemPrefetchEnabled(true);
        view.setLayoutManager(linearLayoutManager);
        view.setOnFlingListener((RecyclerView.p) null);
        new androidx.recyclerview.widget.n().attachToRecyclerView(view);
        ArrayList arrayList = new ArrayList();
        List<UGCContent> contentList = operateItem.getContentList();
        if (contentList != null) {
            int h = RangesKt.h(contentList.size(), 9);
            a aVar = null;
            for (int i = 0; i < h; i++) {
                if (aVar == null) {
                    aVar = new a(Integer.valueOf(i / 3), new ArrayList());
                }
                aVar.a().add(contentList.get(i));
                if (aVar.a().size() == 3) {
                    arrayList.add(aVar);
                    aVar = null;
                }
            }
            bVar.n1(arrayList);
        }
    }

    public int l() {
        return PostItemType.UGC_MUSIC_RANK.ordinal();
    }

    public int m() {
        return R.layout.provider_ugc_op_common;
    }
}
