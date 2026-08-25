package com.transsion.home.adapter.suboperate.provider;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.home.R;
import com.transsion.home.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class r0 extends BaseItemProvider {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(OperateItem operateItem, View view) {
        String deepLink = operateItem.getDeepLink();
        if (deepLink != null) {
            ij.k.h(deepLink, null, 1, null);
        }
    }

    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, final OperateItem operateItem) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        ((RecyclerView.a0) baseViewHolder).itemView.setTag("TrendingTitle");
        baseViewHolder.setText(R.id.sub_operation_title_text, operateItem.getTitle());
        baseViewHolder.setGone(R.id.sub_operation_title_more, true);
        ((RecyclerView.a0) baseViewHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.provider.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r0.B(view);
            }
        });
        String deepLink = operateItem.getDeepLink();
        if (deepLink == null || deepLink.length() == 0) {
            return;
        }
        baseViewHolder.setVisible(R.id.sub_operation_title_more, true);
        ((RecyclerView.a0) baseViewHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.provider.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r0.C(OperateItem.this, view);
            }
        });
    }

    public int l() {
        return PostItemType.FEEDS_TITLE.ordinal();
    }

    public int m() {
        return R.layout.item_sub_operation_title;
    }
}
