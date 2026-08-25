package zg;

import android.content.Context;
import com.cloud.tmc.integration.params.TmcStartParams;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class g {
    public static final g a = new g();

    private g() {
    }

    public final boolean a(Context context) {
        Intrinsics.h(context, "context");
        return !Intrinsics.c(TmcStartParams.TRANSPARENT_TITLE_NONE, d.a(context));
    }
}
