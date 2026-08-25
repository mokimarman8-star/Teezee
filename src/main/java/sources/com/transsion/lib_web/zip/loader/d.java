package com.transsion.lib_web.zip.loader;

import android.content.Context;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.transsion.gslb.BuildConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d {
    private final Context a;
    private final List b;
    private String c;
    private String d;
    private String e;

    public d(Context context, List list) {
        Intrinsics.h(context, "context");
        Intrinsics.h(list, "loaders");
        this.a = context;
        this.b = list;
        this.c = BuildConfig.FLAVOR;
        this.d = BuildConfig.FLAVOR;
        this.e = BuildConfig.FLAVOR;
    }

    public final WebResourceResponse a(WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null) {
            return null;
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            WebResourceResponse a = ((c) it.next()).a(webResourceRequest);
            if (a != null) {
                return a;
            }
        }
        return null;
    }

    public final boolean b() {
        for (c cVar : this.b) {
        }
        return false;
    }
}
