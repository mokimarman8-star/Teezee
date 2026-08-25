package com.chad.library.adapter.base;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class BaseQuickAdapter$c extends GridLayoutManager.c {
    final /* synthetic */ BaseQuickAdapter e;
    final /* synthetic */ RecyclerView.m f;
    final /* synthetic */ GridLayoutManager.c g;

    BaseQuickAdapter$c(BaseQuickAdapter baseQuickAdapter, RecyclerView.m mVar, GridLayoutManager.c cVar) {
        this.e = baseQuickAdapter;
        this.f = mVar;
        this.g = cVar;
    }

    public int f(int i) {
        int itemViewType = this.e.getItemViewType(i);
        if (itemViewType == 268435729 && this.e.b0()) {
            return 1;
        }
        if (itemViewType == 268436275 && this.e.W()) {
            return 1;
        }
        BaseQuickAdapter.j(this.e);
        return this.e.u0(itemViewType) ? this.f.U() : this.g.f(i);
    }
}
