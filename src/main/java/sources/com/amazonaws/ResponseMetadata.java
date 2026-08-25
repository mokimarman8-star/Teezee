package com.amazonaws;

import com.cloud.tmc.integration.MiniAppConfigHelper;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class ResponseMetadata {
    protected final Map a;

    public ResponseMetadata(Map map) {
        this.a = map;
    }

    public String a() {
        return (String) this.a.get("AWS_REQUEST_ID");
    }

    public String toString() {
        Map map = this.a;
        return map == null ? MiniAppConfigHelper.DEFAULT_KEY_CORS_LIST : map.toString();
    }
}
