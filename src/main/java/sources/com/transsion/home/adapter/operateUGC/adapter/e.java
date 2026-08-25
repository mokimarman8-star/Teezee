package com.transsion.home.adapter.operateUGC.adapter;

import android.content.res.ColorStateList;
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

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u0007R\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/transsion/home/adapter/operateUGC/adapter/e;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/home/bean/RankingListItem;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", BuildConfig.FLAVOR, "layoutResId", "<init>", "(I)V", "holder", "item", BuildConfig.FLAVOR, "B1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/home/bean/RankingListItem;)V", "index", "C1", "F", "I", "currentSelectIndex", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e extends BaseQuickAdapter {
    public static final int G = 8;

    /* renamed from: F, reason: from kotlin metadata */
    private int currentSelectIndex;

    public e() {
        this(0, 1, null);
    }

    public e(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ e(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? R.layout.item_ugc_provider_ranklist_tab : i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(BaseViewHolder holder, RankingListItem item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        TextView textView = (TextView) holder.getView(R.id.home_ugc_rankinglist_tab_text);
        textView.setText(item.getTitle());
        if (getData().indexOf(item) == this.currentSelectIndex) {
            textView.setTypeface(uf.a.a(getContext()));
            textView.setBackgroundTintList(ColorStateList.valueOf(androidx.core.content.b.getColor(getContext(), com.tn.lib.widget.R.color.white_10)));
        } else {
            textView.setTypeface(uf.a.d(getContext()));
            textView.setBackgroundTintList(ColorStateList.valueOf(androidx.core.content.b.getColor(getContext(), com.tn.lib.widget.R.color.transparent)));
        }
    }

    public final void C1(int index) {
        this.currentSelectIndex = index;
        notifyDataSetChanged();
    }
}
