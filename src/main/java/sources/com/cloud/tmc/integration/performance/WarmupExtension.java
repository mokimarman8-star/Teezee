package com.cloud.tmc.integration.performance;

import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.utils.VersionUtils;
import com.cloud.tmc.kernel.log.TmcLogger;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/cloud/tmc/integration/performance/WarmupExtension;", "", "isValid", "", "lowestSupportVersion", "", "deployVersion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface WarmupExtension {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isValid(WarmupExtension warmupExtension, String str, String str2) {
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            boolean isSupportWarmupFramework = VersionUtils.INSTANCE.isSupportWarmupFramework(str, str2);
            StringBuilder sb = new StringBuilder();
            sb.append("框架包是否支持：");
            sb.append(!isSupportWarmupFramework);
            sb.append("; 目标版本：");
            sb.append(str);
            sb.append(", 预热版本：");
            sb.append(str2);
            TmcLogger.d("InnerWarmup", sb.toString());
            return !isSupportWarmupFramework;
        }
    }

    boolean isValid(String lowestSupportVersion, String deployVersion);
}
