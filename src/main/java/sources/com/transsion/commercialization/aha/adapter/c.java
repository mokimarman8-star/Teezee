package com.transsion.commercialization.aha.adapter;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.bean.AhaGameAllGames;
import com.transsion.bean.GameLayoutType;
import com.transsion.commercialization.R$id;
import com.transsion.commercialization.R$layout;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c extends BaseItemProvider {
    private final int e = GameLayoutType.ITEM_TITLE.ordinal();

    public int l() {
        return this.e;
    }

    public int m() {
        return R$layout.item_aha_game_title;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, AhaGameAllGames ahaGameAllGames) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(ahaGameAllGames, "item");
        baseViewHolder.setText(R$id.tv_title, ahaGameAllGames.getTitle());
    }
}
