package com.chad.library.adapter.base;

import android.view.View;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final /* synthetic */ class m implements View.OnLongClickListener {
    public final /* synthetic */ BaseViewHolder a;
    public final /* synthetic */ BaseQuickAdapter b;

    public /* synthetic */ m(BaseViewHolder baseViewHolder, BaseQuickAdapter baseQuickAdapter) {
        this.a = baseViewHolder;
        this.b = baseQuickAdapter;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        return BaseQuickAdapter.g(this.a, this.b, view);
    }
}
