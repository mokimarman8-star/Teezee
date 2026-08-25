package com.transsion.rewardscenter.redeem;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.rewardscenter.R$id;
import com.transsion.rewardscenter.R$layout;
import com.transsion.rewardscenter.redeem.e;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class i extends BaseItemProvider {
    public int l() {
        return 0;
    }

    public int m() {
        return R$layout.redeem_title_item;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, e eVar) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(eVar, "item");
        if (eVar instanceof e.c) {
            baseViewHolder.setText(R$id.tv_title, ((e.c) eVar).a());
        }
    }
}
