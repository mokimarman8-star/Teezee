package com.transsion.home.viewmodel.preload;

import android.content.Context;
import java.io.InputStream;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class a {
    private final String a = "appTab.json";

    public final void a(List list) {
        Intrinsics.h(list, "list");
    }

    public final String b(Context context) {
        Intrinsics.h(context, "context");
        try {
            InputStream open = context.getAssets().open(this.a);
            Intrinsics.e(open);
            return Okio.buffer(Okio.source(open)).readUtf8();
        } catch (Exception unused) {
            return null;
        }
    }

    public final String c(Context context) {
        Intrinsics.h(context, "context");
        return null;
    }

    public final String d(Context context) {
        Intrinsics.h(context, "context");
        return null;
    }

    public final String e(Context context) {
        Intrinsics.h(context, "context");
        return null;
    }
}
