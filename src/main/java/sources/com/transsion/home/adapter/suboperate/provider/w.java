package com.transsion.home.adapter.suboperate.provider;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.home.R;
import com.transsion.home.adapter.suboperate.adapter.SubFilterAdapter;
import com.transsion.home.adapter.suboperate.provider.w;
import com.transsion.home.bean.FilterItem;
import com.transsion.home.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class w extends BaseItemProvider {
    private final Integer e;
    private final boolean f;
    private final Lazy g = LazyKt.b(new Function0() { // from class: com.transsion.home.adapter.suboperate.provider.v
        public final Object invoke() {
            w.a A;
            A = w.A();
            return A;
        }
    });

    public static final class a extends RecyclerView.s {
        a() {
            m(0, 4);
        }

        public void k(RecyclerView.a0 a0Var) {
            super.k(a0Var);
        }
    }

    public w(Integer num, boolean z) {
        this.e = num;
        this.f = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a A() {
        return new a();
    }

    private final a B() {
        return (a) this.g.getValue();
    }

    public int l() {
        return PostItemType.FILTER.ordinal();
    }

    public int m() {
        return R.layout.item_sub_operation_filter;
    }

    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, OperateItem operateItem) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        List<FilterItem> filters = operateItem.getFilters();
        if (filters == null) {
            filters = new ArrayList<>();
        }
        if (filters.isEmpty()) {
            View view = ((RecyclerView.a0) baseViewHolder).itemView;
            Intrinsics.g(view, "itemView");
            uf.c.g(view);
            return;
        }
        View view2 = ((RecyclerView.a0) baseViewHolder).itemView;
        Intrinsics.g(view2, "itemView");
        uf.c.k(view2);
        TextView textView = (TextView) baseViewHolder.getView(R.id.sub_operation_filter_title);
        String title = operateItem.getTitle();
        if (title == null || title.length() == 0) {
            uf.c.g(textView);
        } else {
            textView.setText(operateItem.getTitle());
            uf.c.k(textView);
        }
        RecyclerView findViewById = ((RecyclerView.a0) baseViewHolder).itemView.findViewById(R.id.sub_operation_filter_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(k(), 0, false);
        linearLayoutManager.setItemPrefetchEnabled(true);
        findViewById.setLayoutManager(linearLayoutManager);
        if (findViewById.getItemDecorationCount() == 0) {
            findViewById.addItemDecoration(new tf.f(8.0f, 0.0f, 12.0f, 2, (DefaultConstructorMarker) null));
        }
        if (!Intrinsics.c(findViewById.getRecycledViewPool(), B())) {
            findViewById.setRecycledViewPool(B());
        }
        SubFilterAdapter subFilterAdapter = new SubFilterAdapter(0, this.e, operateItem, this.f, 1, null);
        subFilterAdapter.n1(filters);
        findViewById.setAdapter(subFilterAdapter);
    }
}
