package com.cloud.tmc.miniapp.ad;

import com.cloud.tmc.integration.proxy.IAdActivityGetProxy;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class AdActivityGetImp implements IAdActivityGetProxy {
    public Class<?> getAdFormActivity() {
        return WebviewAdFormActivity.class;
    }

    public Class<?> getAdLandingPageActivity() {
        return WebviewAdLandingPageActivity.class;
    }

    public Class<?> getAdPersonalizationActivity() {
        return WebviewPersonalizationActivity.class;
    }
}
