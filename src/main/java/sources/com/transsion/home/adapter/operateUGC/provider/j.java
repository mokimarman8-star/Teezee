package com.transsion.home.adapter.operateUGC.provider;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.adapter.operateUGC.provider.j;
import com.transsion.home.bean.FilterItem;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j extends BaseItemProvider {
    private final Integer e;
    private final boolean f;
    private final Lazy g = LazyKt.b(new Function0() { // from class: com.transsion.home.adapter.operateUGC.provider.h
        public final Object invoke() {
            j.b A;
            A = j.A();
            return A;
        }
    });

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ!\u0010\r\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u000f\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/transsion/home/adapter/operateUGC/provider/j$a;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/home/bean/FilterItem;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", BuildConfig.FLAVOR, "tabId", "Lcom/transsion/home/bean/OperateItem;", "operateItem", "<init>", "(Ljava/lang/Integer;Lcom/transsion/home/bean/OperateItem;)V", "item", "position", BuildConfig.FLAVOR, "F1", "(Lcom/transsion/home/bean/FilterItem;I)V", "E1", "holder", "C1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/home/bean/FilterItem;)V", "F", "Ljava/lang/Integer;", "G", "Lcom/transsion/home/bean/OperateItem;", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends BaseQuickAdapter {
        public static final int H = 8;

        /* renamed from: F, reason: from kotlin metadata */
        private final Integer tabId;

        /* renamed from: G, reason: from kotlin metadata */
        private final OperateItem operateItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Integer num, OperateItem operateItem) {
            super(R.layout.item_ugc_education_filter, (List) null, 2, (DefaultConstructorMarker) null);
            Intrinsics.h(operateItem, "operateItem");
            this.tabId = num;
            this.operateItem = operateItem;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void D1(FilterItem filterItem, a aVar, BaseViewHolder baseViewHolder, View view) {
            String deepLink = filterItem.getDeepLink();
            if (deepLink != null) {
                ij.k.h(deepLink, null, 1, null);
            }
            aVar.F1(filterItem, baseViewHolder.getLayoutPosition());
        }

        private final void E1(FilterItem item, int position) {
            String str;
            HashMap hashMap = new HashMap();
            hashMap.put("module_name", "item");
            if (item == null || (str = item.getTitle()) == null) {
                str = BuildConfig.FLAVOR;
            }
            hashMap.put("title", str);
            hashMap.put("position", String.valueOf(position));
            sk.b.a(this.operateItem, hashMap);
            qi.h hVar = qi.h.a;
            SubTabFragment.Companion companion = SubTabFragment.INSTANCE;
            Integer num = this.tabId;
            hVar.z(companion.a(num != null ? num.intValue() : 1), hashMap);
        }

        private final void F1(FilterItem item, int position) {
            String str;
            HashMap hashMap = new HashMap();
            hashMap.put("module_name", "item");
            if (item == null || (str = item.getTitle()) == null) {
                str = BuildConfig.FLAVOR;
            }
            hashMap.put("title", str);
            hashMap.put("position", String.valueOf(position));
            sk.b.a(this.operateItem, hashMap);
            qi.h hVar = qi.h.a;
            SubTabFragment.Companion companion = SubTabFragment.INSTANCE;
            Integer num = this.tabId;
            hVar.o(companion.a(num != null ? num.intValue() : 1), hashMap);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: C1, reason: merged with bridge method [inline-methods] */
        public void F(final BaseViewHolder holder, final FilterItem item) {
            String str;
            String thumbnail;
            Intrinsics.h(holder, "holder");
            Intrinsics.h(item, "item");
            holder.setText(R.id.tv_op_ugc_item_filter, item.getTitle());
            f.b m = ni.f.a.m(getContext());
            Cover image = item.getImage();
            String str2 = BuildConfig.FLAVOR;
            if (image == null || (str = image.getUrl()) == null) {
                str = BuildConfig.FLAVOR;
            }
            f.b g = m.g(str);
            Cover image2 = item.getImage();
            if (image2 != null && (thumbnail = image2.getThumbnail()) != null) {
                str2 = thumbnail;
            }
            g.l(str2).m(com.blankj.utilcode.util.a0.a(32.0f)).d((ImageView) holder.getView(R.id.iv_op_ugc_item_filter));
            ((RecyclerView.a0) holder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.operateUGC.provider.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    j.a.D1(FilterItem.this, this, holder, view);
                }
            });
            E1(item, holder.getLayoutPosition());
        }
    }

    public static final class b extends RecyclerView.s {
        b() {
            m(0, 4);
        }
    }

    public j(Integer num, boolean z) {
        this.e = num;
        this.f = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b A() {
        return new b();
    }

    private final b B() {
        return (b) this.g.getValue();
    }

    public int l() {
        return PostItemType.UGC_FILTER.ordinal();
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
        String obj = title != null ? StringsKt.n1(title).toString() : null;
        if (obj == null || obj.length() == 0) {
            uf.c.g(textView);
        } else {
            textView.setText(operateItem.getTitle());
            uf.c.k(textView);
        }
        RecyclerView findViewById = ((RecyclerView.a0) baseViewHolder).itemView.findViewById(R.id.sub_operation_filter_recycler);
        findViewById.setLayoutManager(new GridLayoutManager(k(), 5));
        if (findViewById.getItemDecorationCount() == 0) {
            findViewById.addItemDecoration(new tf.b(com.blankj.utilcode.util.a0.a(12.0f), com.blankj.utilcode.util.a0.a(4.0f), com.blankj.utilcode.util.a0.a(8.0f), com.blankj.utilcode.util.a0.a(8.0f)));
        }
        if (!Intrinsics.c(findViewById.getRecycledViewPool(), B())) {
            findViewById.setRecycledViewPool(B());
        }
        a aVar = new a(this.e, operateItem);
        aVar.n1(filters);
        findViewById.setAdapter(aVar);
    }
}
