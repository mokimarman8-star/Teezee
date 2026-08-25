package com.transsion.commercialization.aha.adapter;

import android.content.Context;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.bean.AhaGameAllGames;
import com.transsion.bean.GameLayoutType;
import com.transsion.commercialization.R$id;
import com.transsion.commercialization.R$layout;
import com.transsion.gslb.BuildConfig;
import kotlin.jvm.internal.Intrinsics;
import ni.f;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b extends BaseItemProvider {
    public int l() {
        return GameLayoutType.ITEM_INFO.ordinal();
    }

    public int m() {
        return R$layout.item_aha_game_item_provider_layout;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder baseViewHolder, AhaGameAllGames ahaGameAllGames) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(ahaGameAllGames, "item");
        ShapeableImageView viewOrNull = baseViewHolder.getViewOrNull(R$id.ivIcon);
        if (viewOrNull != null) {
            f.a aVar = ni.f.a;
            Context context = viewOrNull.getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b m = aVar.m(context);
            String iconPictureLink = ahaGameAllGames.getIconPictureLink();
            if (iconPictureLink == null) {
                iconPictureLink = BuildConfig.FLAVOR;
            }
            m.g(iconPictureLink).d(viewOrNull);
        }
        baseViewHolder.setText(R$id.tvName, ahaGameAllGames.getName());
        baseViewHolder.setText(R$id.tvStarNum, ahaGameAllGames.getRate());
        baseViewHolder.setText(R$id.tvDescription, ahaGameAllGames.getDescription());
    }
}
