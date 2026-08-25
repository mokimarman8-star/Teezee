package com.chad.library.adapter.base;

import android.view.View;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final /* synthetic */ class l implements View.OnClickListener {
    public final /* synthetic */ BaseViewHolder a;
    public final /* synthetic */ BaseQuickAdapter b;

    public /* synthetic */ l(BaseViewHolder baseViewHolder, BaseQuickAdapter baseQuickAdapter) {
        this.a = baseViewHolder;
        this.b = baseQuickAdapter;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        BaseQuickAdapter.i(this.a, this.b, view);
    }
}
