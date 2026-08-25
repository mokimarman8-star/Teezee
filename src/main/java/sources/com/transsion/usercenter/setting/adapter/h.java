package com.transsion.usercenter.setting.adapter;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class h extends BaseItemProvider {
    public int l() {
        return 2;
    }

    public int m() {
        return R$layout.user_item_title_setting;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, jv.b item) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        helper.getView(R$id.tvTitle).setTextById(item.i());
    }
}
