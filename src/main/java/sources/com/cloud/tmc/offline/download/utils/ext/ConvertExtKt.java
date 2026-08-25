package com.cloud.tmc.offline.download.utils.ext;

import com.cloud.tmc.offline.download.utils.ConvertUtils;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"formatMemorySize", "", "", "com.cloud.tmc.offline_download"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class ConvertExtKt {
    public static final String formatMemorySize(long j) {
        return ConvertUtils.getFormatMemorySize$default(ConvertUtils.INSTANCE, j, 0, 2, null);
    }
}
