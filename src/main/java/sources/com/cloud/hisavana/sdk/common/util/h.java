package com.cloud.hisavana.sdk.common.util;

import com.cloud.hisavana.sdk.data.bean.response.ConfigCodeSeatDTO;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class h {
    public static final h a = new h();

    private h() {
    }

    public final ConfigCodeSeatDTO a(ConfigCodeSeatDTO configCodeSeatDTO) {
        Intrinsics.h(configCodeSeatDTO, "defaultConfig");
        configCodeSeatDTO.setApplicationId(c7.b.b);
        configCodeSeatDTO.setAdSeatType("");
        configCodeSeatDTO.setOfflineAdCacheCount(5);
        configCodeSeatDTO.setOfflineAdRequestCount(2);
        configCodeSeatDTO.setOfflineAdRequestTimeInterval(30);
        configCodeSeatDTO.setOfflineAdRequestTimeIntervalNoAd(24);
        configCodeSeatDTO.setAdShowCountLimit(-1);
        configCodeSeatDTO.setCarouselTime(0);
        configCodeSeatDTO.setCarouselCount(1);
        configCodeSeatDTO.setShowInterval(0);
        configCodeSeatDTO.setLastOfflineAdEnable(Boolean.FALSE);
        configCodeSeatDTO.setDefaultConfig(Boolean.TRUE);
        return configCodeSeatDTO;
    }
}
