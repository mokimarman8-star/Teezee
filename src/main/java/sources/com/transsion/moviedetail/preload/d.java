package com.transsion.moviedetail.preload;

import android.os.Bundle;
import java.util.Collections;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d implements am.c {
    @Override // am.c
    public List a(String str, Bundle bundle) {
        List list;
        String string;
        if (Intrinsics.c(str, "/movie/detail")) {
            Integer valueOf = bundle != null ? Integer.valueOf(bundle.getInt("season")) : null;
            if (bundle == null || (string = bundle.getString("id")) == null || (list = CollectionsKt.h(new am.b[]{new b(string, valueOf, false, 4, null), new MovieDetailDownloadListLoader(string), new MovieDetailResourcesSeasonLoader(string)})) == null) {
                list = Collections.emptyList();
                Intrinsics.g(list, "emptyList(...)");
            }
        } else {
            list = null;
        }
        if (list != null) {
            return list;
        }
        Intrinsics.y("iPreloadList");
        return null;
    }

    @Override // am.c
    public String getPath() {
        return "/movie/detail";
    }
}
