package ow;

import android.content.Context;
import com.transsion.wrapperad.R$id;
import com.transsion.wrapperad.R$layout;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a extends com.transsion.ad.bidding.base.r {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        Intrinsics.h(context, "context");
    }

    public Integer c() {
        return Integer.valueOf(R$id.native_ad_choices);
    }

    public Integer h() {
        return Integer.valueOf(R$id.store_mark_view);
    }

    public Integer i() {
        return Integer.valueOf(R$id.adIcon);
    }

    public Integer l() {
        return Integer.valueOf(R$id.native_ad_action);
    }

    public Integer m() {
        return Integer.valueOf(R$id.native_ad_des);
    }

    public Integer s() {
        return Integer.valueOf(R$id.native_ad_icon);
    }

    public int t() {
        return R$layout.native_adalysing_result_tips_dialog_ad_layout;
    }

    public Integer v() {
        return Integer.valueOf(R$id.native_ad_media);
    }

    public Integer z() {
        return Integer.valueOf(R$id.native_ad_title);
    }
}
