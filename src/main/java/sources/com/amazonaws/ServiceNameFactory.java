package com.amazonaws;

import com.amazonaws.internal.config.HttpClientConfig;
import com.amazonaws.internal.config.InternalConfig;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
enum ServiceNameFactory {
    ;

    static String getServiceName(String str) {
        HttpClientConfig h = InternalConfig.Factory.a().h(str);
        if (h == null) {
            return null;
        }
        return h.a();
    }
}
