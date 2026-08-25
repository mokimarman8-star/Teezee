package com.cloud.hisavana.sdk.common.util;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.webkit.WebResourceResponse;
import com.bumptech.glide.load.Key;
import com.cloud.hisavana.sdk.b4;
import java.io.ByteArrayInputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class q0 {
    public static WebResourceResponse a(String str) {
        if (TextUtils.isEmpty(str) || !str.endsWith("_tmc_load_ok.png")) {
            return null;
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAAAAAA6fptVAAAACklEQVQYV2P4DwABAQEAWk1v8QAAAABJRU5ErkJggg==".getBytes());
            MimeTypeMap.getSingleton();
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
            if (TextUtils.isEmpty(fileExtensionFromUrl)) {
                return null;
            }
            return new WebResourceResponse(MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl), Key.STRING_CHARSET_NAME, byteArrayInputStream);
        } catch (Exception e) {
            b4.b().d("ssp", Log.getStackTraceString(e));
            return null;
        }
    }
}
