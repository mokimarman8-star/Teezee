package com.transsion.home.adapter.trending.adapter;

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
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import ij.k;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import ni.f;
import sk.b;
import zk.c;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B;\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010!R\u0014\u0010$\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010!¨\u0006%"}, d2 = {"Lcom/transsion/home/adapter/trending/adapter/OpMovieRankAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/bean/Subject;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", BuildConfig.FLAVOR, "layoutResId", "Lcom/transsion/home/bean/OperateItem;", "operateItem", BuildConfig.FLAVOR, "isSubTab", "tabId", "isHorizontal", "isTablet", "<init>", "(ILcom/transsion/home/bean/OperateItem;ZIZZ)V", "item", "pos", BuildConfig.FLAVOR, "C1", "(Lcom/transsion/moviedetailapi/bean/Subject;I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "y0", "(Landroid/view/ViewGroup;I)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/moviedetailapi/bean/Subject;)V", "F", "Lcom/transsion/home/bean/OperateItem;", "G", "Z", "H", "I", "itemWidth", "J", "itemHeight", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class OpMovieRankAdapter extends BaseQuickAdapter {
    public static final int K = 8;

    /* renamed from: F, reason: from kotlin metadata */
    private final OperateItem operateItem;

    /* renamed from: G, reason: from kotlin metadata */
    private final boolean isSubTab;

    /* renamed from: H, reason: from kotlin metadata */
    private final int tabId;

    /* renamed from: I, reason: from kotlin metadata */
    private final int itemWidth;

    /* renamed from: J, reason: from kotlin metadata */
    private final int itemHeight;

    public OpMovieRankAdapter(int i, OperateItem operateItem, boolean z, int i2, boolean z2, boolean z3) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
        this.operateItem = operateItem;
        this.isSubTab = z;
        this.tabId = i2;
        int i3 = z2 ? 2 : z3 ? 4 : 3;
        float f = z2 ? 0.56f : 1.39f;
        int a = a0.a(((((a0.b(RangesKt.h(y.e(), y.c())) - 12) - (i3 * 8)) - 12) * 1.0f) / i3);
        this.itemWidth = a;
        this.itemHeight = (int) (a * f);
    }

    public /* synthetic */ OpMovieRankAdapter(int i, OperateItem operateItem, boolean z, int i2, boolean z2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? R.layout.item_main_operation_movie_rank : i, operateItem, z, i2, z2, z3);
    }

    private final void C1(Subject item, int pos) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "browse_rank_item");
        hashMap.put("sequence", String.valueOf(pos));
        hashMap.put("tabId", String.valueOf(this.tabId));
        OperateItem operateItem = this.operateItem;
        if (operateItem != null) {
            b.a(operateItem, hashMap);
        }
        b.d(item, hashMap);
        com.transsion.baselib.helper.a.a.e(SubTabFragment.INSTANCE.a(this.tabId), hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, Subject item) {
        String str;
        String thumbnail;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        int e = k.e(getData(), item);
        z(holder, getItemViewType(e));
        ShapeableImageView viewOrNull = holder.getViewOrNull(R.id.main_op_movie_rank_image);
        if (viewOrNull != null) {
            if (item.getBuiltIn()) {
                i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new OpMovieRankAdapter$convert$1$1(item, viewOrNull, null), 3, (Object) null);
            } else {
                f.a aVar = f.a;
                Context context = viewOrNull.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b m = aVar.m(context);
                Cover cover = item.getCover();
                String str2 = BuildConfig.FLAVOR;
                if (cover == null || (str = cover.getUrl()) == null) {
                    str = BuildConfig.FLAVOR;
                }
                f.b g = m.g(str);
                Cover cover2 = item.getCover();
                if (cover2 != null && (thumbnail = cover2.getThumbnail()) != null) {
                    str2 = thumbnail;
                }
                g.l(str2).m(this.itemWidth).c(this.itemHeight).d(viewOrNull);
            }
            if (viewOrNull.getLayoutParams().width != this.itemWidth || viewOrNull.getLayoutParams().height != this.itemHeight) {
                viewOrNull.getLayoutParams().width = this.itemWidth;
                viewOrNull.getLayoutParams().height = this.itemHeight;
            }
        }
        if (P(e) == 100) {
            return;
        }
        TextView textView = (TextView) holder.getViewOrNull(R.id.main_op_movie_rank_title);
        if (textView != null) {
            textView.setText(item.getTitle());
            textView.setMaxWidth(this.itemWidth);
        }
        holder.setText(R.id.main_op_movie_rank_corner, item.getCorner());
        if (this.isSubTab) {
            C1(item, e);
        } else {
            c.a.g(item, e, this.operateItem);
        }
    }

    protected BaseViewHolder y0(ViewGroup parent, int viewType) {
        Intrinsics.h(parent, "parent");
        if (viewType != 100) {
            BaseViewHolder y0 = super.y0(parent, viewType);
            ShapeableImageView viewOrNull = y0.getViewOrNull(R.id.main_op_movie_rank_image);
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
            findViewById.getLayoutParams().height = this.itemHeight;
        }
        View findViewById2 = inflate.findViewById(R.id.main_op_movie_rank_more_mask);
        findViewById2.getLayoutParams().width = this.itemWidth;
        findViewById2.getLayoutParams().height = this.itemHeight;
        Intrinsics.e(inflate);
        return new BaseViewHolder(inflate);
    }
}
