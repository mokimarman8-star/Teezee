package com.transsion.search_pugc.fragment.hot.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.search.R$drawable;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.R$string;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoHashTag;
import ij.h;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ni.f;
import t6.i;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/transsion/search_pugc/fragment/hot/adapter/g;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lt6/i;", BuildConfig.FLAVOR, "parentName", BuildConfig.FLAVOR, "parentIndex", BuildConfig.FLAVOR, "showRank", "<init>", "(Ljava/lang/String;IZ)V", "video", "position", BuildConfig.FLAVOR, "F1", "(Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;I)V", "E1", "()I", "holder", "item", "C1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;)V", "F", "Ljava/lang/String;", "G", "I", "H", "Z", "mIsLowDevice", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g extends BaseQuickAdapter implements i {

    /* renamed from: F, reason: from kotlin metadata */
    private final String parentName;

    /* renamed from: G, reason: from kotlin metadata */
    private final int parentIndex;

    /* renamed from: H, reason: from kotlin metadata */
    private final boolean showRank;

    /* renamed from: I, reason: from kotlin metadata */
    private final boolean mIsLowDevice;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(String str, int i, boolean z) {
        super(R$layout.item_search_rank_item, (List) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.h(str, "parentName");
        this.parentName = str;
        this.parentIndex = i;
        this.showRank = z;
        this.mIsLowDevice = h.a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D1(g gVar, UGCVideo uGCVideo, int i, View view) {
        gVar.F1(uGCVideo, i);
    }

    private final int E1() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? 8388613 : 8388611;
    }

    private final void F1(UGCVideo video, int position) {
        com.transsion.search_pugc.g.g.a(getContext()).t(video, position, this.parentName, this.parentIndex);
        if (getContext() instanceof Activity) {
            Context context = getContext();
            Intrinsics.f(context, "null cannot be cast to non-null type android.app.Activity");
            if (KeyboardUtils.g((Activity) context)) {
                Context context2 = getContext();
                Intrinsics.f(context2, "null cannot be cast to non-null type android.app.Activity");
                KeyboardUtils.d((Activity) context2);
            }
        }
        com.transsion.search_pugc.constant.a.h(video, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, final UGCVideo item) {
        String str;
        String str2;
        UGCVideoHashTag uGCVideoHashTag;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        final int g0 = g0(item);
        boolean z = true;
        if (this.showRank) {
            holder.setVisible(R$id.search_hot_rank_item_index_text, false);
        } else {
            int i = R$drawable.bg_hot_subject_no4;
            if (g0 == 0) {
                i = R$drawable.bg_hot_subject_no1;
            } else if (g0 == 1) {
                i = R$drawable.bg_hot_subject_no2;
            } else if (g0 == 2) {
                i = R$drawable.bg_hot_subject_no3;
            }
            holder.setText(R$id.search_hot_rank_item_index_text, String.valueOf(g0 + 1));
            holder.setBackgroundResource(R$id.search_hot_rank_item_index_text, i);
        }
        boolean z2 = this.mIsLowDevice;
        String str3 = BuildConfig.FLAVOR;
        if (z2) {
            holder.setGone(R$id.search_hot_rank_item_image_linear, true);
        } else {
            f.b m = ni.f.a.m(getContext());
            Cover cover = item.getCover();
            if (cover == null || (str = cover.getUrl()) == null) {
                str = BuildConfig.FLAVOR;
            }
            f.b g = m.g(str);
            Cover cover2 = item.getCover();
            if (cover2 == null || (str2 = cover2.getThumbnail()) == null) {
                str2 = BuildConfig.FLAVOR;
            }
            g.l(str2).m(a0.a(50.0f)).d((ImageView) holder.getView(R$id.search_hot_rank_item_image));
        }
        int i2 = R$id.search_hot_rank_item_title_text;
        String title = item.getTitle();
        if (title == null) {
            title = BuildConfig.FLAVOR;
        }
        holder.setText(i2, title);
        ((TextView) holder.getView(R$id.search_hot_rank_item_title_text)).setGravity(E1());
        ((TextView) holder.getView(R$id.search_hot_rank_item_subtitle_text)).setGravity(E1());
        ((RecyclerView.a0) holder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search_pugc.fragment.hot.adapter.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.D1(g.this, item, g0, view);
            }
        });
        int i3 = R$id.search_hot_rank_item_corner;
        String corner = item.getCorner();
        if (corner != null && corner.length() != 0) {
            z = false;
        }
        holder.setGone(i3, z);
        int i4 = R$id.search_hot_rank_item_corner;
        String corner2 = item.getCorner();
        if (corner2 != null) {
            str3 = corner2;
        }
        holder.setText(i4, str3);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String watchNum = item.getWatchNum();
        String l = watchNum != null ? com.transsion.search_pugc.constant.a.l(watchNum) : null;
        spannableStringBuilder.append((CharSequence) (l + " " + getContext().getString(R$string.views)));
        List hashTags = item.getHashTags();
        if (hashTags != null && (uGCVideoHashTag = (UGCVideoHashTag) CollectionsKt.l0(hashTags, 0)) != null) {
            spannableStringBuilder.append((CharSequence) "￼");
            spannableStringBuilder.append((CharSequence) uGCVideoHashTag.getTitle());
        }
        ((TextView) holder.getView(R$id.search_hot_rank_item_subtitle_text)).setText(spannableStringBuilder);
    }

    public /* bridge */ /* synthetic */ t6.f b(BaseQuickAdapter baseQuickAdapter) {
        return t6.h.a(this, baseQuickAdapter);
    }
}
