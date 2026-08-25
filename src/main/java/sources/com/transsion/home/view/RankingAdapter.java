package com.transsion.home.view;

import android.content.Context;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import ni.f;
import zg.h;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\fR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/transsion/home/view/RankingAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/bean/Subject;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", BuildConfig.FLAVOR, "datas", "<init>", "(Ljava/util/List;)V", "holder", "item", BuildConfig.FLAVOR, "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/moviedetailapi/bean/Subject;)V", "Lkotlin/Pair;", BuildConfig.FLAVOR, "F", "Lkotlin/Pair;", "pairWH", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RankingAdapter extends BaseQuickAdapter {
    public static final int G = 8;

    /* renamed from: F, reason: from kotlin metadata */
    private final Pair<Integer, Integer> pairWH;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankingAdapter(List<Subject> list) {
        super(R.layout.item_ranking, list);
        Intrinsics.h(list, "datas");
        this.pairWH = h.a.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, Subject item) {
        String sb;
        String str;
        String thumbnail;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        ConstraintLayout viewOrNull = holder.getViewOrNull(R.id.item_root);
        if (viewOrNull != null) {
            ViewGroup.LayoutParams layoutParams = viewOrNull.getLayoutParams();
            layoutParams.width = ((Number) this.pairWH.getFirst()).intValue();
            layoutParams.height = -2;
            viewOrNull.setLayoutParams(layoutParams);
        }
        ShapeableImageView viewOrNull2 = holder.getViewOrNull(R.id.iv_cover);
        if (viewOrNull2 != null) {
            ViewGroup.LayoutParams layoutParams2 = viewOrNull2.getLayoutParams();
            layoutParams2.width = -1;
            layoutParams2.height = ((Number) this.pairWH.getSecond()).intValue();
            if (item.getBuiltIn()) {
                i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new RankingAdapter$convert$2$1(item, viewOrNull2, null), 3, (Object) null);
            } else {
                f.a aVar = ni.f.a;
                Context context = viewOrNull2.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b m = aVar.m(context);
                Cover cover = item.getCover();
                String str2 = BuildConfig.FLAVOR;
                if (cover == null || (str = cover.getUrl()) == null) {
                    str = BuildConfig.FLAVOR;
                }
                f.b c = m.g(str).m(((Number) this.pairWH.getFirst()).intValue()).c(((Number) this.pairWH.getSecond()).intValue());
                Cover cover2 = item.getCover();
                if (cover2 != null && (thumbnail = cover2.getThumbnail()) != null) {
                    str2 = thumbnail;
                }
                c.l(str2).d(viewOrNull2);
            }
        }
        AppCompatTextView viewOrNull3 = holder.getViewOrNull(R.id.tv_score);
        if (viewOrNull3 != null) {
            uf.c.k(viewOrNull3);
            viewOrNull3.setText(item.getImdbRate());
        }
        AppCompatTextView viewOrNull4 = holder.getViewOrNull(R.id.tv_title);
        if (viewOrNull4 != null) {
            viewOrNull4.setText(item.getTitle());
        }
        AppCompatTextView viewOrNull5 = holder.getViewOrNull(R.id.tv_tag);
        if (viewOrNull5 != null) {
            String tag = item.getTag();
            if (tag == null || tag.length() == 0) {
                viewOrNull5.setTextColor(androidx.core.content.b.getColor(viewOrNull5.getContext(), com.tn.lib.widget.R.color.text_03));
                StringBuilder sb2 = new StringBuilder();
                sb2.append(item.getCountryName());
                String genre = item.getGenre();
                List S0 = genre != null ? StringsKt.S0(genre, new String[]{","}, false, 0, 6, (Object) null) : null;
                if (S0 != null && (!S0.isEmpty())) {
                    sb2.append(" ");
                    sb2.append((String) S0.get(0));
                }
                sb = sb2.toString();
            } else {
                viewOrNull5.setTextColor(androidx.core.content.b.getColor(viewOrNull5.getContext(), com.tn.lib.widget.R.color.rank_tag_color));
                sb = item.getTag();
            }
            viewOrNull5.setText(sb);
        }
    }
}
