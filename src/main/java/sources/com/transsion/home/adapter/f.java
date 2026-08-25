package com.transsion.home.adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.R$drawable;
import com.transsion.home.bean.CategoryType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/transsion/home/adapter/f;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/home/bean/CategoryType;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "<init>", "()V", "holder", "item", BuildConfig.FLAVOR, "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/home/bean/CategoryType;)V", BuildConfig.FLAVOR, "position", "E1", "(I)V", "D1", "()I", "C1", "()Lcom/transsion/home/bean/CategoryType;", "F", "I", "currentSelectedPosition", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f extends BaseQuickAdapter {
    public static final int G = 8;

    /* renamed from: F, reason: from kotlin metadata */
    private int currentSelectedPosition;

    public f() {
        super(R.layout.item_ranking_category, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.widget.TextView, com.transsion.baseui.widget.GradientTextView] */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, CategoryType item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        int layoutPosition = holder.getLayoutPosition();
        boolean z = layoutPosition == this.currentSelectedPosition;
        ?? r4 = (GradientTextView) holder.getView(R.id.ranking_category_name);
        String name = item.getName();
        if (name == null) {
            name = BuildConfig.FLAVOR;
        }
        r4.setText(name);
        if (z) {
            r4.setGradientColors(androidx.core.content.b.getColor(getContext(), com.tn.lib.widget.R.color.brand_new_gradient_start), androidx.core.content.b.getColor(getContext(), com.tn.lib.widget.R.color.brand_new_gradient_center), androidx.core.content.b.getColor(getContext(), com.tn.lib.widget.R.color.brand_new_gradient_end));
        } else {
            r4.setGradientColors(androidx.core.content.b.getColor(getContext(), com.tn.lib.widget.R.color.white_60), androidx.core.content.b.getColor(getContext(), com.tn.lib.widget.R.color.white_60), androidx.core.content.b.getColor(getContext(), com.tn.lib.widget.R.color.white_60));
        }
        int i = this.currentSelectedPosition;
        boolean z2 = layoutPosition == i + (-1);
        boolean z3 = layoutPosition == i + 1;
        int i2 = z ? R$drawable.bg_ranking_category_selected : z2 ? R$drawable.bg_ranking_category_above_selected : z3 ? R$drawable.bg_ranking_category_below_selected : R$drawable.bg_ranking_category_normal;
        a.a.f(wf.a.a, "RankingCategory", "position=" + layoutPosition + ", selected=" + i + ", isAbove=" + z2 + ", isBelow=" + z3 + ", bg=" + i2, false, 4, (Object) null);
        ((RecyclerView.a0) holder).itemView.setBackgroundResource(i2);
    }

    public final CategoryType C1() {
        return (CategoryType) CollectionsKt.l0(getData(), this.currentSelectedPosition);
    }

    /* renamed from: D1, reason: from getter */
    public final int getCurrentSelectedPosition() {
        return this.currentSelectedPosition;
    }

    public final void E1(int position) {
        int i = this.currentSelectedPosition;
        if (position == i) {
            return;
        }
        this.currentSelectedPosition = position;
        notifyItemChanged(i);
        if (i > 0) {
            notifyItemChanged(i - 1);
        }
        if (i < getData().size() - 1) {
            notifyItemChanged(i + 1);
        }
        notifyItemChanged(this.currentSelectedPosition);
        int i2 = this.currentSelectedPosition;
        if (i2 > 0) {
            notifyItemChanged(i2 - 1);
        }
        if (this.currentSelectedPosition < getData().size() - 1) {
            notifyItemChanged(this.currentSelectedPosition + 1);
        }
    }
}
