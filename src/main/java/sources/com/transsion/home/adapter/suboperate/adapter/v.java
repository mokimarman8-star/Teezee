package com.transsion.home.adapter.suboperate.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.home.R;
import com.transsion.home.bean.BannerData;
import com.transsion.home.bean.OperateItem;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class v extends RecyclerView.Adapter {
    private List a;
    private final int b;
    private final com.transsion.home.adapter.suboperate.provider.i c;
    private final OperateItem d;
    private final int e;
    private final int f;

    public v(List list, int i, com.transsion.home.adapter.suboperate.provider.i iVar, OperateItem operateItem) {
        Intrinsics.h(list, "banners");
        Intrinsics.h(iVar, "bannerProvider");
        Intrinsics.h(operateItem, "operateItem");
        this.a = list;
        this.b = i;
        this.c = iVar;
        this.d = operateItem;
        this.f = 1;
    }

    private final BannerData h(int i) {
        int size;
        if (!this.a.isEmpty() && (size = i % this.a.size()) >= 0 && size < this.a.size()) {
            return (BannerData) this.a.get(size);
        }
        return null;
    }

    public final List g() {
        return this.a;
    }

    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    public int getItemViewType(int i) {
        BannerData h = h(i);
        return (h != null ? h.getBiddingAdData() : null) != null ? this.f : this.e;
    }

    public final void i(List list) {
        Intrinsics.h(list, "<set-?>");
        this.a = list;
    }

    public void onBindViewHolder(RecyclerView.a0 a0Var, int i) {
        Intrinsics.h(a0Var, "holder");
        if (this.a.isEmpty()) {
            return;
        }
        int size = i % this.a.size();
        if (getItemViewType(i) == this.f) {
            SubBannerADViewHolder subBannerADViewHolder = a0Var instanceof SubBannerADViewHolder ? (SubBannerADViewHolder) a0Var : null;
            if (subBannerADViewHolder != null) {
                subBannerADViewHolder.i(h(i));
                return;
            }
            return;
        }
        SubBannerViewHolder subBannerViewHolder = a0Var instanceof SubBannerViewHolder ? (SubBannerViewHolder) a0Var : null;
        if (subBannerViewHolder != null) {
            subBannerViewHolder.g(h(i), size);
        }
    }

    public RecyclerView.a0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.h(viewGroup, "parent");
        if (i == this.f) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_sub_banner_ad, viewGroup, false);
            Intrinsics.e(inflate);
            return new SubBannerADViewHolder(inflate);
        }
        View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_sub_view_pager, viewGroup, false);
        Intrinsics.e(inflate2);
        return new SubBannerViewHolder(inflate2, this.b, this.c, this.d);
    }

    public void onViewRecycled(RecyclerView.a0 a0Var) {
        Intrinsics.h(a0Var, "holder");
        super.onViewRecycled(a0Var);
        boolean z = a0Var instanceof SubBannerADViewHolder;
        if ((z ? (SubBannerADViewHolder) a0Var : null) != null) {
            SubBannerADViewHolder subBannerADViewHolder = z ? (SubBannerADViewHolder) a0Var : null;
            if (subBannerADViewHolder != null) {
                subBannerADViewHolder.k();
            }
        }
    }
}
