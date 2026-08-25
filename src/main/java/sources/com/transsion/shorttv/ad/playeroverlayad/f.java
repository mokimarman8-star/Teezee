package com.transsion.shorttv.ad.playeroverlayad;

import android.content.Context;
import com.transsion.ad.bidding.base.r;
import com.transsion.shorttv.R;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f extends r {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context) {
        super(context);
        Intrinsics.h(context, "context");
    }

    public Integer c() {
        return Integer.valueOf(R.id.ad_choices_view);
    }

    public Integer h() {
        return Integer.valueOf(R.id.store_mark_view);
    }

    public Integer i() {
        return Integer.valueOf(R.id.ad_tag_view);
    }

    public Integer k() {
        return Integer.valueOf(R.id.ad_blur_view);
    }

    public Integer l() {
        return null;
    }

    public Integer m() {
        return null;
    }

    public Integer s() {
        return null;
    }

    public int t() {
        return R.layout.shorttv_player_ad_overlay_layout;
    }

    public Integer v() {
        return Integer.valueOf(R.id.ad_media_view);
    }

    public Integer z() {
        return null;
    }
}
