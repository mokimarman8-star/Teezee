package com.danikula.videocache;

import android.content.Context;
import android.os.Environment;
import java.io.File;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class p {
    private static File a(Context context) {
        File externalCacheDir = "mounted".equals(Environment.getExternalStorageState()) ? context.getExternalCacheDir() : null;
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        if (externalCacheDir != null) {
            return externalCacheDir;
        }
        return new File("/data/data/" + context.getPackageName() + "/cache/");
    }

    static File b(Context context) {
        return new File(a(context), "video-cache");
    }
}
