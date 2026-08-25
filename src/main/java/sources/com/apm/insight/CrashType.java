package com.apm.insight;

import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.cloud.tmc.integration.event.EventConstants;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public enum CrashType {
    LAUNCH("launch"),
    JAVA("java"),
    NATIVE(EventConstants.ADDRESS_NATIVE),
    ASAN("asan"),
    TSAN("tsan"),
    ANR("anr"),
    BLOCK("block"),
    ENSURE("ensure"),
    DART("dart"),
    CUSTOM_JAVA("custom_java"),
    OOM("oom"),
    ALL(IntegrationConstants.NAVIGATION_BAR_ALL_ACTION);

    private String mName;

    CrashType(String str) {
        this.mName = str;
    }

    public final String getName() {
        return this.mName;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return getName();
    }
}
