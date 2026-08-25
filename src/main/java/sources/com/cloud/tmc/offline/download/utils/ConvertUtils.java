package com.cloud.tmc.offline.download.utils;

import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniutils.constant.MemoryConstants;
import java.text.DecimalFormat;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/cloud/tmc/offline/download/utils/ConvertUtils;", "", "()V", "TAG", "", "getFormatMemorySize", "size", "", "unit", "", "com.cloud.tmc.offline_download"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class ConvertUtils {
    public static final ConvertUtils INSTANCE = new ConvertUtils();
    private static final String TAG = "TmcOfflineDownload: ConvertUtils";

    private ConvertUtils() {
    }

    public static /* synthetic */ String getFormatMemorySize$default(ConvertUtils convertUtils, long j, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = MemoryConstants.KB;
        }
        return convertUtils.getFormatMemorySize(j, i);
    }

    public final String getFormatMemorySize(long size, int unit) {
        DecimalFormat decimalFormat = new DecimalFormat("####.00");
        String str = "0 B";
        if (size >= 0) {
            try {
                if (size < unit) {
                    str = size + " B";
                } else {
                    if (size < unit * unit) {
                        str = decimalFormat.format(size / unit) + " KB";
                    } else if (size < r1 * unit) {
                        double d = unit;
                        str = decimalFormat.format((size / d) / d) + " MB";
                    } else {
                        double d2 = unit;
                        str = decimalFormat.format(((size / d2) / d2) / d2) + " GB";
                    }
                }
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("convert size to ");
                sb.append(size);
                sb.append(" is failed.");
                TmcLogger.e(TAG, sb.toString(), th);
            }
        }
        return str;
    }
}
