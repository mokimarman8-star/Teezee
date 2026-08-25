package com.transsion.player.longvideo.member;

import android.content.Context;
import com.transsion.player.longvideo.R$id;
import com.transsion.player.longvideo.R$layout;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e extends com.transsion.ad.bidding.base.r {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context) {
        super(context);
        Intrinsics.h(context, "context");
    }

    public Integer c() {
        return Integer.valueOf(R$id.adChoicesView);
    }

    public Integer h() {
        return Integer.valueOf(R$id.store_mark_view);
    }

    public Integer i() {
        return Integer.valueOf(R$id.adIcon);
    }

    public Integer k() {
        return Integer.valueOf(R$id.ivBurlBgView);
    }

    public Integer l() {
        return null;
    }

    public Integer m() {
        return Integer.valueOf(R$id.native_ad_body);
    }

    public Integer s() {
        return Integer.valueOf(R$id.native_ad_icon);
    }

    public int t() {
        return R$layout.resolution_ad_native_layout;
    }

    public Integer v() {
        return Integer.valueOf(R$id.coverview);
    }

    public Integer z() {
        return Integer.valueOf(R$id.native_ad_title);
    }
}
