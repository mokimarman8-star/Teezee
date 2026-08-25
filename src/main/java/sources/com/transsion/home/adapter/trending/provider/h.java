package com.transsion.home.adapter.trending.provider;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.view.NoNetworkSmallView;
import com.transsion.home.R;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.p000enum.HomeTabId;
import com.transsion.moviedetailapi.bean.PostItemType;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h extends BaseItemProvider {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(h hVar) {
        Function0<Unit> R1;
        BaseProviderMultiAdapter g = hVar.g();
        if ((g instanceof com.transsion.home.adapter.trending.b) && (R1 = ((com.transsion.home.adapter.trending.b) g).R1()) != null) {
            R1.invoke();
        }
        com.tn.lib.view.o.b(SubTabFragment.INSTANCE.a(HomeTabId.INSTANCE.g()));
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C() {
        com.tn.lib.view.o.c(SubTabFragment.INSTANCE.a(HomeTabId.INSTANCE.g()));
        return Unit.a;
    }

    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, OperateItem operateItem) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(operateItem, "item");
        NoNetworkSmallView viewOrNull = baseViewHolder.getViewOrNull(R.id.no_network);
        if (viewOrNull != null) {
            viewOrNull.retry(new Function0() { // from class: com.transsion.home.adapter.trending.provider.f
                public final Object invoke() {
                    Unit B;
                    B = h.B(h.this);
                    return B;
                }
            });
            viewOrNull.goToSetting(new Function0() { // from class: com.transsion.home.adapter.trending.provider.g
                public final Object invoke() {
                    Unit C;
                    C = h.C();
                    return C;
                }
            });
        }
        com.tn.lib.view.o.a(SubTabFragment.INSTANCE.a(HomeTabId.INSTANCE.g()));
    }

    public int l() {
        return PostItemType.NO_NETWORK.ordinal();
    }

    public int m() {
        return R.layout.item_no_network;
    }
}
