package com.transsion.shorttv.ui.adapter.provider;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.shorttv.R;
import com.transsion.shorttv.bean.OperateItem;
import com.transsion.shorttv.bean.ShortTvItemType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class t extends BaseItemProvider {
    public static final a e = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(BaseViewHolder baseViewHolder, View view) {
        a.a.f(wf.a.a, "ShortTVFilter", "click Latest", false, 4, (Object) null);
        Navigator.x(TheRouter.c("/home/playlist").K("label", "fresh-releases-list").K("category", "TVSHOW").K("recType", "OPT").K("topIds", (String) null), ((RecyclerView.a0) baseViewHolder).itemView.getContext(), (mf.c) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(BaseViewHolder baseViewHolder, View view) {
        a.a.f(wf.a.a, "ShortTVFilter", "click Hottest", false, 4, (Object) null);
        Navigator.x(TheRouter.c("/home/playlist").K("label", "must-watch-list").K("category", "TVSHOW").K("recType", "OPT").K("topIds", (String) null), ((RecyclerView.a0) baseViewHolder).itemView.getContext(), (mf.c) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(BaseViewHolder baseViewHolder, View view) {
        Navigator.x(TheRouter.c("/home/movieFilter").F("tabId", 7).K("tabCode", "ShortTV").z("showViewPager", false), ((RecyclerView.a0) baseViewHolder).itemView.getContext(), (mf.c) null, 2, (Object) null);
    }

    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void b(final BaseViewHolder helper, OperateItem item) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        ((TextView) helper.getView(R.id.iv_latest)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.shorttv.ui.adapter.provider.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t.C(helper, view);
            }
        });
        ((TextView) helper.getView(R.id.iv_hottest)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.shorttv.ui.adapter.provider.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t.D(helper, view);
            }
        });
        ((TextView) helper.getView(R.id.iv_all)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.shorttv.ui.adapter.provider.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t.E(helper, view);
            }
        });
    }

    public int l() {
        return ShortTvItemType.FILTER.ordinal();
    }

    public int m() {
        return R.layout.short_tv_layout_category;
    }
}
