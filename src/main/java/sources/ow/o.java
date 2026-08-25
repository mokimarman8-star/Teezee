package ow;

import android.content.Context;
import com.transsion.wrapperad.R$id;
import com.transsion.wrapperad.R$layout;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class o extends com.transsion.ad.bidding.base.r {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(Context context) {
        super(context);
        Intrinsics.h(context, "context");
    }

    public Integer c() {
        return Integer.valueOf(R$id.adChoicesView);
    }

    public Integer h() {
        return null;
    }

    public Integer i() {
        return Integer.valueOf(R$id.adTag);
    }

    public Integer l() {
        return Integer.valueOf(R$id.native_ad_action);
    }

    public Integer m() {
        return null;
    }

    public Integer s() {
        return null;
    }

    public int t() {
        return R$layout.media_content_native_ad_layout;
    }

    public Integer v() {
        return Integer.valueOf(R$id.native_ad_media);
    }

    public Integer z() {
        return null;
    }
}
