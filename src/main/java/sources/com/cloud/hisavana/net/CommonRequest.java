package com.cloud.hisavana.net;

import android.text.TextUtils;
import com.cloud.hisavana.net.impl.IHttpCallback;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class CommonRequest {
    private CommonRequest() {
        throw new IllegalStateException("Utility class");
    }

    public static Request a(String str, RequestParams requestParams, IHttpCallback iHttpCallback) {
        try {
            StringBuilder sb = new StringBuilder(str);
            sb.append("?");
            if (requestParams != null && !requestParams.getHttpParams().isEmpty()) {
                for (Map.Entry entry : requestParams.getHttpParams().entrySet()) {
                    sb.append((String) entry.getKey());
                    sb.append("=");
                    sb.append((String) entry.getValue());
                    sb.append("&");
                }
            }
            return requestParams != null ? new Request.Builder().url(sb.substring(0, sb.length() - 1)).headers(c(requestParams.getHttpHeaders())).get().build() : new Request.Builder().url(sb.substring(0, sb.length() - 1)).get().build();
        } catch (Exception e) {
            if (iHttpCallback != null) {
                iHttpCallback.d(490, null, e);
            }
            return null;
        }
    }

    public static Request b(String str, RequestParams requestParams, IHttpCallback iHttpCallback) {
        try {
            return new Request.Builder().url(str).headers(c(requestParams.getHttpHeaders())).post(d(requestParams.getPostBody())).build();
        } catch (Exception e) {
            if (iHttpCallback != null) {
                iHttpCallback.d(490, null, e);
            }
            return null;
        }
    }

    private static Headers c(Map map) {
        if (map == null) {
            map = new HashMap();
        }
        return !map.isEmpty() ? Headers.of(map) : new Headers.Builder().build();
    }

    private static RequestBody d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return RequestBody.create(MediaType.get(ContentType.JSON.getValue()), str);
    }
}
