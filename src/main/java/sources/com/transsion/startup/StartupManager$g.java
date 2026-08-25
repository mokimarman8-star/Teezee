package com.transsion.startup;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class StartupManager$g extends mf.e {
    StartupManager$g() {
    }

    public String b(String str) {
        a.a.f(wf.a.a, "TheRouter-replace", "replace path :" + str, false, 4, (Object) null);
        Uri parse = str != null ? Uri.parse(str) : null;
        if (parse == null || !Intrinsics.c(parse.getScheme(), "oneroom")) {
            return str;
        }
        String queryParameter = parse.getQueryParameter("type");
        if (queryParameter == null) {
            queryParameter = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        return queryParameter.length() > 0 ? parse.buildUpon().path(queryParameter).build().toString() : str;
    }
}
