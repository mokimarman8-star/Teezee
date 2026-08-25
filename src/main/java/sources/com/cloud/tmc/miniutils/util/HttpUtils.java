package com.cloud.tmc.miniutils.util;

import android.text.TextUtils;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class HttpUtils {
    public static long getContentLength(String str) {
        long j = 0;
        try {
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
            httpURLConnection.setRequestMethod("HEAD");
            j = httpURLConnection.getContentLength();
            httpURLConnection.disconnect();
            return j;
        } catch (Throwable unused) {
            return j;
        }
    }
}
