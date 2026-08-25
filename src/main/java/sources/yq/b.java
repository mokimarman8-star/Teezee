package yq;

import android.content.Context;
import com.transsion.ad.bidding.base.r;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    public static final b a = new b();

    private b() {
    }

    public final r a(Context context, String str) {
        Intrinsics.h(context, "context");
        if (Intrinsics.c(str, "ShortTvDiscoverMostTrendingScene")) {
            return new d(context);
        }
        if (Intrinsics.c(str, "ShortTvListScene")) {
            return new c(context);
        }
        return null;
    }
}
