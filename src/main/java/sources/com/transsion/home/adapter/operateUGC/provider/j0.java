package com.transsion.home.adapter.operateUGC.provider;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.R;
import com.transsion.home.adapter.operateUGC.adapter.VerticalContentUGCAdapter;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.ugcvideodetail.api.bean.UGCContent;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j0 extends BaseItemProvider {
    public static final a f = new a(null);
    public static final int g = 8;
    private final int e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public j0(int i) {
        this.e = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(OperateItem operateItem, j0 j0Var) {
        String deepLink = operateItem.getDeepLink();
        if (deepLink != null && deepLink.length() != 0) {
            j0Var.G(operateItem);
            String deepLink2 = operateItem.getDeepLink();
            if (deepLink2 != null) {
                ij.k.h(deepLink2, null, 1, null);
            }
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(Function0 function0, View view) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(Function0 function0, View view) {
        function0.invoke();
    }

    private final void F(OperateItem operateItem) {
        List data;
        Pair a2 = TuplesKt.a("module_name", "all");
        BaseProviderMultiAdapter g2 = g();
        Pair a3 = TuplesKt.a("position", String.valueOf((g2 == null || (data = g2.getData()) == null) ? null : Integer.valueOf(data.indexOf(operateItem))));
        String title = operateItem.getTitle();
        if (title == null) {
            title = BuildConfig.FLAVOR;
        }
        Map m = MapsKt.m(new Pair[]{a2, a3, TuplesKt.a("title", title), TuplesKt.a("tabId", String.valueOf(this.e))});
        sk.b.a(operateItem, m);
        qi.h.a.z(SubTabFragment.INSTANCE.a(this.e), m);
    }

    private final void G(OperateItem operateItem) {
        List data;
        Pair a2 = TuplesKt.a("module_name", "all");
        BaseProviderMultiAdapter g2 = g();
        Pair a3 = TuplesKt.a("position", String.valueOf((g2 == null || (data = g2.getData()) == null) ? null : Integer.valueOf(data.indexOf(operateItem))));
        String title = operateItem.getTitle();
        if (title == null) {
            title = BuildConfig.FLAVOR;
        }
        Map m = MapsKt.m(new Pair[]{a2, a3, TuplesKt.a("title", title), TuplesKt.a("tabId", String.valueOf(this.e))});
        sk.b.a(operateItem, m);
        qi.h.a.o(SubTabFragment.INSTANCE.a(this.e), m);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00ad, code lost:
    
        if (r9 == null) goto L22;
     */
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(BaseViewHolder baseViewHolder, final OperateItem operateItem) {
        List l;
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        final Function0 function0 = new Function0() { // from class: com.transsion.home.adapter.operateUGC.provider.g0
            public final Object invoke() {
                Unit C;
                C = j0.C(OperateItem.this, this);
                return C;
            }
        };
        ((TextView) baseViewHolder.getView(R.id.tvProviderVerticalTitle)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.operateUGC.provider.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j0.D(function0, view);
            }
        });
        TextView textView = (TextView) baseViewHolder.getView(R.id.tvProviderVerticalMore);
        String deepLink = operateItem.getDeepLink();
        if (deepLink == null || deepLink.length() == 0) {
            uf.c.g(textView);
        } else {
            uf.c.k(textView);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.operateUGC.provider.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j0.E(function0, view);
            }
        });
        F(operateItem);
        String title = operateItem.getTitle();
        if (title != null && title.length() != 0) {
            ((TextView) baseViewHolder.getView(R.id.tvProviderVerticalTitle)).setText(operateItem.getTitle());
        }
        VerticalContentUGCAdapter verticalContentUGCAdapter = new VerticalContentUGCAdapter(operateItem, this.e, 0, 4, null);
        RecyclerView view = baseViewHolder.getView(R.id.rvProviderVerticalPost);
        view.setLayoutManager(new NpaGridLayoutManager(view.getContext(), 3));
        if (view.getItemDecorationCount() == 0) {
            view.addItemDecoration(new tf.a(lj.a.b(8), 0, 0, 0));
        }
        view.setAdapter(verticalContentUGCAdapter);
        List<UGCContent> contentList = operateItem.getContentList();
        if (contentList != null) {
            l = CollectionsKt.K0(contentList, (contentList.size() / 3) * 3);
        }
        l = CollectionsKt.l();
        verticalContentUGCAdapter.n1(l);
    }

    public int l() {
        return PostItemType.UGC_PORTRAIT_GRID.ordinal();
    }

    public int m() {
        return R.layout.provider_ugc_vertical_content;
    }
}
