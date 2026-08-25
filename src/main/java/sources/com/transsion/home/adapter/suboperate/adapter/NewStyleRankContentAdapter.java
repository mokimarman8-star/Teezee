package com.transsion.home.adapter.suboperate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.R$drawable;
import com.transsion.home.bean.OperateItem;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import ni.f;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B3\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001eR\u0014\u0010#\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u001e¨\u0006$"}, d2 = {"Lcom/transsion/home/adapter/suboperate/adapter/NewStyleRankContentAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/bean/Subject;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", BuildConfig.FLAVOR, "layoutResId", "Lcom/transsion/home/bean/OperateItem;", "operateItem", "tabId", BuildConfig.FLAVOR, "isHorizontal", "isTablet", "<init>", "(ILcom/transsion/home/bean/OperateItem;IZZ)V", "position", "P", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "y0", "(Landroid/view/ViewGroup;I)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "item", BuildConfig.FLAVOR, "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/moviedetailapi/bean/Subject;)V", "F", "Lcom/transsion/home/bean/OperateItem;", "G", "I", "H", "itemWidth", "itemHeight", "J", "descHeight", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class NewStyleRankContentAdapter extends BaseQuickAdapter {
    public static final int K = 8;

    /* renamed from: F, reason: from kotlin metadata */
    private final OperateItem operateItem;

    /* renamed from: G, reason: from kotlin metadata */
    private final int tabId;

    /* renamed from: H, reason: from kotlin metadata */
    private final int itemWidth;

    /* renamed from: I, reason: from kotlin metadata */
    private final int itemHeight;

    /* renamed from: J, reason: from kotlin metadata */
    private final int descHeight;

    public NewStyleRankContentAdapter(int i, OperateItem operateItem, int i2, boolean z, boolean z2) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
        this.operateItem = operateItem;
        this.tabId = i2;
        int i3 = z ? 2 : z2 ? 4 : 3;
        float f = z ? 0.56f : 1.39f;
        int a = a0.a(((((a0.b(RangesKt.h(y.e(), y.c())) - 12) - (i3 * 8)) - 12) * 1.0f) / i3);
        this.itemWidth = a;
        this.itemHeight = (int) (a * f);
        this.descHeight = a0.a(27.0f);
    }

    public /* synthetic */ NewStyleRankContentAdapter(int i, OperateItem operateItem, int i2, boolean z, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? R.layout.home_item_new_style_rank_content : i, operateItem, i2, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, Subject item) {
        String str;
        String str2;
        String str3;
        String str4;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        ShapeableImageView viewOrNull = holder.getViewOrNull(R.id.main_op_movie_rank_image);
        String str5 = BuildConfig.FLAVOR;
        if (viewOrNull != null) {
            if (item.getBuiltIn()) {
                kotlinx.coroutines.i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new NewStyleRankContentAdapter$convert$1$1(item, viewOrNull, null), 3, (Object) null);
            } else {
                f.a aVar = ni.f.a;
                Context context = viewOrNull.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b m = aVar.m(context);
                Cover cover = item.getCover();
                if (cover == null || (str3 = cover.getUrl()) == null) {
                    str3 = BuildConfig.FLAVOR;
                }
                f.b g = m.g(str3);
                Cover cover2 = item.getCover();
                if (cover2 == null || (str4 = cover2.getThumbnail()) == null) {
                    str4 = BuildConfig.FLAVOR;
                }
                g.l(str4).m(this.itemWidth).c(this.itemHeight + this.descHeight).d(viewOrNull);
            }
            if (viewOrNull.getLayoutParams().width != this.itemWidth || viewOrNull.getLayoutParams().height != this.itemHeight + this.descHeight) {
                viewOrNull.getLayoutParams().width = this.itemWidth;
                viewOrNull.getLayoutParams().height = this.itemHeight + this.descHeight;
            }
        }
        ShapeableImageView viewOrNull2 = holder.getViewOrNull(R.id.mainOpMovieRankImage);
        if (viewOrNull2 != null) {
            if (item.getBuiltIn()) {
                kotlinx.coroutines.i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new NewStyleRankContentAdapter$convert$2$1(item, viewOrNull2, null), 3, (Object) null);
            } else {
                f.a aVar2 = ni.f.a;
                Context context2 = viewOrNull2.getContext();
                Intrinsics.g(context2, "getContext(...)");
                f.b m2 = aVar2.m(context2);
                Cover cover3 = item.getCover();
                if (cover3 == null || (str = cover3.getUrl()) == null) {
                    str = BuildConfig.FLAVOR;
                }
                f.b g2 = m2.g(str);
                Cover cover4 = item.getCover();
                if (cover4 == null || (str2 = cover4.getThumbnail()) == null) {
                    str2 = BuildConfig.FLAVOR;
                }
                g2.l(str2).m(this.itemWidth).c(this.itemHeight).d(viewOrNull2);
            }
            if (viewOrNull2.getLayoutParams().width != this.itemWidth || viewOrNull2.getLayoutParams().height != this.itemHeight) {
                viewOrNull2.getLayoutParams().width = this.itemWidth;
                viewOrNull2.getLayoutParams().height = this.itemHeight;
            }
        }
        if (P(ij.k.e(getData(), item)) == 100) {
            return;
        }
        TextView textView = (TextView) holder.getViewOrNull(R.id.main_op_movie_rank_title);
        if (textView != null) {
            textView.setText(item.getTitle());
            textView.setMaxWidth(this.itemWidth);
        }
        TextView textView2 = (TextView) holder.getView(R.id.tvRank);
        int bindingAdapterPosition = holder.getBindingAdapterPosition() + 1;
        textView2.setText(String.valueOf(bindingAdapterPosition));
        if (bindingAdapterPosition == 1) {
            textView2.setBackgroundResource(R$drawable.bg_ranking_tl_no1);
        } else if (bindingAdapterPosition == 2) {
            textView2.setBackgroundResource(R$drawable.bg_ranking_tl_no2);
        } else if (bindingAdapterPosition != 3) {
            textView2.setBackgroundResource(R$drawable.bg_ranking_tl_normal);
        } else {
            textView2.setBackgroundResource(R$drawable.bg_ranking_tl_no3);
        }
        TextView textView3 = (TextView) holder.getView(R.id.main_op_movie_rank_corner);
        String corner = item.getCorner();
        if (corner != null) {
            str5 = corner;
        }
        if (str5.length() <= 0) {
            textView3.setVisibility(8);
        } else {
            textView3.setVisibility(0);
            textView3.setText(str5);
        }
    }

    protected int P(int position) {
        if (position == getItemCount() - 1) {
            return 100;
        }
        return super.P(position);
    }

    protected BaseViewHolder y0(ViewGroup parent, int viewType) {
        Intrinsics.h(parent, "parent");
        if (viewType != 100) {
            BaseViewHolder y0 = super.y0(parent, viewType);
            ShapeableImageView viewOrNull = y0.getViewOrNull(R.id.mainOpMovieRankImage);
            if (viewOrNull != null) {
                viewOrNull.getLayoutParams().width = this.itemWidth;
                viewOrNull.getLayoutParams().height = this.itemHeight;
            }
            return y0;
        }
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_operation_movie_rank_more, parent, false);
        View findViewById = inflate.findViewById(R.id.main_op_movie_rank_image);
        if (findViewById != null) {
            findViewById.getLayoutParams().width = this.itemWidth;
            findViewById.getLayoutParams().height = this.itemHeight + this.descHeight;
        }
        View findViewById2 = inflate.findViewById(R.id.main_op_movie_rank_more_mask);
        findViewById2.getLayoutParams().width = this.itemWidth;
        findViewById2.getLayoutParams().height = this.itemHeight + this.descHeight;
        Intrinsics.e(inflate);
        return new BaseViewHolder(inflate);
    }
}
