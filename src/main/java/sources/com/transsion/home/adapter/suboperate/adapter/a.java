package com.transsion.home.adapter.suboperate.adapter;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.bean.RankingListItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u0007J\u001f\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/transsion/home/adapter/suboperate/adapter/a;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/home/bean/RankingListItem;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", BuildConfig.FLAVOR, "tabId", "<init>", "(I)V", "C1", "()I", "index", BuildConfig.FLAVOR, "D1", "holder", "item", "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/home/bean/RankingListItem;)V", "F", "I", "G", "currentSelectIndex", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a extends BaseQuickAdapter {
    public static final int H = 8;

    /* renamed from: F, reason: from kotlin metadata */
    private final int tabId;

    /* renamed from: G, reason: from kotlin metadata */
    private int currentSelectIndex;

    public a(int i) {
        super(R.layout.home_item_new_style_rank_tab, (List) null, 2, (DefaultConstructorMarker) null);
        this.tabId = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, RankingListItem item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        TextView textView = (TextView) holder.getView(R.id.tvTabName);
        textView.setText(item.getTitle());
        if (holder.getBindingAdapterPosition() == this.currentSelectIndex) {
            Drawable background = textView.getBackground();
            if (background instanceof GradientDrawable) {
                ((GradientDrawable) background).setColor(androidx.core.content.b.getColor(getContext(), com.tn.lib.widget.R.color.white_10));
            }
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            textView.setTextColor(androidx.core.content.b.getColor(getContext(), com.tn.lib.widget.R.color.white));
            return;
        }
        Drawable background2 = textView.getBackground();
        if (background2 instanceof GradientDrawable) {
            ((GradientDrawable) background2).setColor(0);
        }
        textView.setTypeface(Typeface.DEFAULT);
        textView.setTextColor(androidx.core.content.b.getColor(getContext(), com.tn.lib.widget.R.color.white_80));
    }

    /* renamed from: C1, reason: from getter */
    public final int getCurrentSelectIndex() {
        return this.currentSelectIndex;
    }

    public final void D1(int index) {
        int i = this.currentSelectIndex;
        this.currentSelectIndex = index;
        notifyItemChanged(i);
        notifyItemChanged(this.currentSelectIndex);
    }
}
