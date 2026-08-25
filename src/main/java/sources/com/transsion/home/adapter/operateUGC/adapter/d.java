package com.transsion.home.adapter.operateUGC.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.baseui.util.j;
import com.transsion.baseui.util.q;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.R$drawable;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.RankingListItem;
import com.transsion.home.p000enum.HomeTabId;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.ugcvideodetail.api.bean.UGCContent;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoCreator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import ni.f;
import rk.d;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ1\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ\u001f\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010$¨\u0006'"}, d2 = {"Lcom/transsion/home/adapter/operateUGC/adapter/d;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/home/bean/RankingListItem;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", BuildConfig.FLAVOR, "layoutResId", "Lcom/transsion/home/bean/OperateItem;", "operateItem", "tabId", "<init>", "(ILcom/transsion/home/bean/OperateItem;I)V", "Landroid/content/Context;", "context", "Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;", "ugcVideo", "Landroid/view/ViewGroup;", "parent", "position", "Landroid/view/View;", "F1", "(Landroid/content/Context;Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;Landroid/view/ViewGroup;I)Landroid/view/View;", "pos", "E1", "(I)I", "rankListItem", BuildConfig.FLAVOR, "G1", "(Lcom/transsion/home/bean/RankingListItem;I)V", "H1", "holder", "item", "C1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/home/bean/RankingListItem;)V", "F", "Lcom/transsion/home/bean/OperateItem;", "G", "I", "H", "perWidth", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d extends BaseQuickAdapter {
    public static final int I = 8;

    /* renamed from: F, reason: from kotlin metadata */
    private final OperateItem operateItem;

    /* renamed from: G, reason: from kotlin metadata */
    private final int tabId;

    /* renamed from: H, reason: from kotlin metadata */
    private final int perWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(int i, OperateItem operateItem, int i2) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.h(operateItem, "operateItem");
        this.operateItem = operateItem;
        this.tabId = i2;
        this.perWidth = Math.min(y.e(), y.c()) - a0.a(54.0f);
    }

    public /* synthetic */ d(int i, OperateItem operateItem, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? R.layout.item_ugc_provider_ranklist : i, operateItem, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D1(UGCContent uGCContent, d dVar, RankingListItem rankingListItem, int i, View view) {
        gu.c.h(uGCContent.getVideo(), Integer.valueOf(dVar.tabId), dVar.operateItem.getOpId());
        dVar.H1(rankingListItem, i);
    }

    private final int E1(int pos) {
        return pos != 0 ? pos != 1 ? pos != 2 ? R$drawable.ic_ugc_rank_default : R$drawable.ic_ugc_rank_03 : R$drawable.ic_ugc_rank_02 : R$drawable.ic_ugc_rank_01;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0149  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final View F1(Context context, UGCVideo ugcVideo, ViewGroup parent, int position) {
        String str;
        String str2;
        String str3;
        String j;
        Long publishTime;
        List q;
        Long publishTime2;
        AppCompatImageView findViewById;
        String valueOf;
        String str4;
        UGCVideoCreator creator;
        UGCVideoCreator creator2;
        Cover cover;
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_ugc_provider_ranklist_items, parent, false);
        ShapeableImageView findViewById2 = inflate.findViewById(R.id.home_ugc_rankinglist_cover);
        Intrinsics.g(findViewById2, "findViewById(...)");
        ShapeableImageView shapeableImageView = findViewById2;
        f.b m = ni.f.a.m(context);
        if (ugcVideo == null || (cover = ugcVideo.getCover()) == null || (str = cover.getUrl()) == null) {
            str = BuildConfig.FLAVOR;
        }
        m.g(str).d(shapeableImageView);
        ((TextView) inflate.findViewById(R.id.home_ugc_rankinglist_title)).setText(ugcVideo != null ? ugcVideo.getTitle() : null);
        TextView textView = (TextView) inflate.findViewById(R.id.home_ugc_rankinglist_corner_text);
        if (ugcVideo == null || (str2 = ugcVideo.getCorner()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        textView.setText(str2);
        TextView textView2 = (TextView) inflate.findViewById(R.id.home_ugc_ranklist_time_text);
        if (ugcVideo == null || (str3 = ugcVideo.getTimeOrCount(context)) == null) {
            str3 = BuildConfig.FLAVOR;
        }
        textView2.setText(str3);
        if (HomeTabId.INSTANCE.h(Integer.valueOf(this.tabId), false)) {
            String nickname = (ugcVideo == null || (creator2 = ugcVideo.getCreator()) == null) ? null : creator2.getNickname();
            if (nickname != null && nickname.length() != 0) {
                String c = j.c(ugcVideo != null ? ugcVideo.getWatchNum() : null, context);
                if (ugcVideo == null || (creator = ugcVideo.getCreator()) == null || (str4 = creator.getNickname()) == null) {
                    str4 = BuildConfig.FLAVOR;
                }
                q = CollectionsKt.q(new String[]{c, "special_#user_icon", str4});
                ((TextView) inflate.findViewById(R.id.home_ugc_rankinglist_tag)).setText(q.e(q, context));
                findViewById = inflate.findViewById(R.id.home_ugc_rankinglist_rank);
                if (findViewById != null) {
                    findViewById.setImageResource(E1(position));
                }
                TextView textView3 = (TextView) inflate.findViewById(R.id.home_ugc_rankinglist_text);
                if (position <= 2) {
                    if (position < 9) {
                        valueOf = "0" + (position + 1);
                    } else {
                        valueOf = String.valueOf(position + 1);
                    }
                    textView3.setText(valueOf);
                } else {
                    textView3.setText(BuildConfig.FLAVOR);
                }
                Intrinsics.e(inflate);
                return inflate;
            }
        }
        String c2 = j.c(ugcVideo != null ? ugcVideo.getWatchNum() : null, context);
        long j2 = 0;
        if (this.tabId == HomeTabId.UGC_Trending.getValue()) {
            if (ugcVideo != null && (publishTime2 = ugcVideo.getPublishTime()) != null) {
                j2 = publishTime2.longValue();
            }
            j = TimeUtilKt.k(j2);
        } else {
            if (ugcVideo != null && (publishTime = ugcVideo.getPublishTime()) != null) {
                j2 = publishTime.longValue();
            }
            j = TimeUtilKt.j(j2);
        }
        q = CollectionsKt.q(new String[]{c2, j});
        ((TextView) inflate.findViewById(R.id.home_ugc_rankinglist_tag)).setText(q.e(q, context));
        findViewById = inflate.findViewById(R.id.home_ugc_rankinglist_rank);
        if (findViewById != null) {
        }
        TextView textView32 = (TextView) inflate.findViewById(R.id.home_ugc_rankinglist_text);
        if (position <= 2) {
        }
        Intrinsics.e(inflate);
        return inflate;
    }

    private final void G1(RankingListItem rankListItem, int position) {
        UGCContent uGCContent;
        List<UGCContent> contentList = rankListItem.getContentList();
        UGCVideo video = (contentList == null || (uGCContent = contentList.get(position)) == null) ? null : uGCContent.getVideo();
        d.a aVar = rk.d.c;
        int i = this.tabId;
        OperateItem operateItem = this.operateItem;
        String title = rankListItem.getTitle();
        if (title == null) {
            title = BuildConfig.FLAVOR;
        }
        aVar.d(i, position, operateItem, video, MapsKt.f(TuplesKt.a("page_tab_name", title)));
    }

    private final void H1(RankingListItem rankListItem, int position) {
        UGCContent uGCContent;
        List<UGCContent> contentList = rankListItem.getContentList();
        UGCVideo video = (contentList == null || (uGCContent = contentList.get(position)) == null) ? null : uGCContent.getVideo();
        d.a aVar = rk.d.c;
        int i = this.tabId;
        OperateItem operateItem = this.operateItem;
        String title = rankListItem.getTitle();
        if (title == null) {
            title = BuildConfig.FLAVOR;
        }
        aVar.f(i, position, operateItem, video, MapsKt.f(TuplesKt.a("page_tab_name", title)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, final RankingListItem item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        LinearLayout linearLayout = (LinearLayout) holder.getView(R.id.home_ugc_rankinglist_liner);
        linearLayout.removeAllViews();
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.width = this.perWidth;
        linearLayout.setLayoutParams(layoutParams);
        List<UGCContent> contentList = item.getContentList();
        if (contentList != null) {
            final int i = 0;
            for (Object obj : contentList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.u();
                }
                final UGCContent uGCContent = (UGCContent) obj;
                View F1 = F1(getContext(), uGCContent.getVideo(), linearLayout, i);
                linearLayout.addView(F1);
                F1.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.operateUGC.adapter.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        d.D1(uGCContent, this, item, i, view);
                    }
                });
                G1(item, i);
                i = i2;
            }
        }
    }
}
