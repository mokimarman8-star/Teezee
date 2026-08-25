package com.transsnet.downloader.util;

import com.transsion.mb.config.manager.ConfigBean;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class j {
    public static final j a = new j();

    private j() {
    }

    public final boolean a() {
        String value;
        Long x;
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
        long j = bVar.b().getLong("key_download_st_show_last_time", 0L);
        long j2 = bVar.b().getLong("key_download_st_showed_times", 0L);
        ConfigBean d = cm.f.d(cm.f.c.a(), "key_storage_per_total_show_times", false, 2, (Object) null);
        long longValue = (d == null || (value = d.getValue()) == null || (x = StringsKt.x(value)) == null) ? 3L : x.longValue();
        return !com.blankj.utilcode.util.c0.f(j) && (longValue > 0 ? longValue : 3L) > j2;
    }
}
