package com.bumptech.glide.integration.cronet;

import java.util.Map;
import org.chromium.net.UrlRequest;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface CronetRequestFactory {
    UrlRequest.Builder newRequest(String str, int i, Map<String, String> map, UrlRequest.Callback callback);
}
