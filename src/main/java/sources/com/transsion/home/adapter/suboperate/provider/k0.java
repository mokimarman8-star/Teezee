package com.transsion.home.adapter.suboperate.provider;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.bean.BffCommonOpData;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class k0 extends BaseItemProvider {
    private final int e;
    private final boolean f;
    private final int g;

    public k0(int i, boolean z) {
        this.e = i;
        this.f = z;
        int i2 = z ? 4 : 3;
        this.g = ((int) (com.blankj.utilcode.util.a0.a(((((com.blankj.utilcode.util.a0.b(RangesKt.h(com.blankj.utilcode.util.y.e(), com.blankj.utilcode.util.y.c())) - 12) - (i2 * 8)) - 12) * 1.0f) / i2) * 1.39f)) + com.blankj.utilcode.util.a0.a(26.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(List list, k0 k0Var, OperateItem operateItem, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        BffCommonOpData bffCommonOpData = (BffCommonOpData) CollectionsKt.l0(list, i);
        if (bffCommonOpData == null) {
            return;
        }
        if (i == list.size() - 1) {
            k0Var.B(operateItem, bffCommonOpData);
            k0Var.D(bffCommonOpData, i, operateItem);
        } else {
            k0Var.B(operateItem, bffCommonOpData);
            k0Var.D(bffCommonOpData, i, operateItem);
        }
    }

    private final void B(OperateItem operateItem, BffCommonOpData bffCommonOpData) {
        String deepLink = bffCommonOpData.getDeepLink();
        if (deepLink != null) {
            ij.k.h(deepLink, null, 1, null);
        }
    }

    private final void C(OperateItem operateItem) {
        String str;
        String opId;
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "browse_post_list");
        String str2 = BuildConfig.FLAVOR;
        if (operateItem == null || (str = operateItem.getTitle()) == null) {
            str = BuildConfig.FLAVOR;
        }
        hashMap.put("title", str);
        if (operateItem != null && (opId = operateItem.getOpId()) != null) {
            str2 = opId;
        }
        hashMap.put("opId", str2);
        hashMap.put("tabId", String.valueOf(this.e));
        if (operateItem != null) {
            sk.b.a(operateItem, hashMap);
        }
        com.transsion.baselib.helper.a.a.e(SubTabFragment.INSTANCE.a(this.e), hashMap);
    }

    private final void D(BffCommonOpData bffCommonOpData, int i, OperateItem operateItem) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "click_post_list_item");
        hashMap.put("sequence", String.valueOf(i));
        hashMap.put("tabId", String.valueOf(this.e));
        sk.b.c(bffCommonOpData, hashMap);
        sk.b.a(operateItem, hashMap);
        com.transsion.baselib.helper.a.a.f(SubTabFragment.INSTANCE.a(this.e), hashMap);
    }

    public int l() {
        return PostItemType.POST_LIST.ordinal();
    }

    public int m() {
        return R.layout.item_sub_operation_variable;
    }

    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, final OperateItem operateItem) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        List<BffCommonOpData> postData = operateItem.getPostData();
        if (postData == null) {
            postData = CollectionsKt.l();
        }
        ((RecyclerView.a0) baseViewHolder).itemView.setVisibility(postData.isEmpty() ? 8 : 0);
        if (postData.isEmpty()) {
            return;
        }
        ((TextView) baseViewHolder.getView(R.id.sub_operation_variable_title)).setText(operateItem.getTitle());
        RecyclerView view = baseViewHolder.getView(R.id.sub_operation_variable_recycle);
        final List K0 = CollectionsKt.K0(postData, 10);
        if (this.g > 0) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.g;
            view.setLayoutParams(layoutParams);
        }
        Object tag = view.getTag();
        com.transsion.home.adapter.suboperate.adapter.o oVar = tag instanceof com.transsion.home.adapter.suboperate.adapter.o ? (com.transsion.home.adapter.suboperate.adapter.o) tag : null;
        if (oVar == null) {
            oVar = new com.transsion.home.adapter.suboperate.adapter.o(0, operateItem, this.e, this.f, 1, null);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(k(), 0, false);
            linearLayoutManager.setItemPrefetchEnabled(true);
            view.setLayoutManager(linearLayoutManager);
            view.setAdapter(oVar);
            view.setTag(oVar);
            if (view.getItemDecorationCount() == 0) {
                view.addItemDecoration(new tf.f(8.0f, 0.0f, 12.0f, 2, (DefaultConstructorMarker) null));
            }
        } else {
            oVar.E1(operateItem);
        }
        oVar.n1(K0);
        oVar.w1(new r6.d() { // from class: com.transsion.home.adapter.suboperate.provider.j0
            public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                k0.A(K0, this, operateItem, baseQuickAdapter, view2, i);
            }
        });
        C(operateItem);
    }
}
