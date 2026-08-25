package com.cloud.tmc.miniapp;

import com.cloud.tmc.miniapp.base.BaseActivity;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class FwDevDownloadUtils {
    public static final FwDevDownloadUtils INSTANCE = new FwDevDownloadUtils();

    private FwDevDownloadUtils() {
    }

    public final void init(BaseActivity baseActivity) {
        Intrinsics.h(baseActivity, "activity");
    }

    public final void showApiMode(BaseActivity baseActivity) {
        Intrinsics.h(baseActivity, "activity");
    }
}
