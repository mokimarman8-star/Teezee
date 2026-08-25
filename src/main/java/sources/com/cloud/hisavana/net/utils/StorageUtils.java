package com.cloud.hisavana.net.utils;

import android.content.Context;
import android.os.Environment;
import com.cloud.sdk.commonutil.util.c;
import com.cloud.sdk.commonutil.util.e;
import java.io.File;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class StorageUtils {
    private static volatile File a;

    private StorageUtils() {
    }

    public static File a(Context context) {
        return b(context, true);
    }

    public static File b(Context context, boolean z) {
        File file;
        if (z) {
            file = e(context);
            if (file != null && file.exists()) {
                File file2 = new File(file.getPath() + File.separator + "hisavana_net_cache");
                if (!file2.exists() && !file2.mkdir()) {
                    c.Log().w("StorageUtils", "can't create cache file");
                }
                file = file2;
            }
        } else {
            file = null;
        }
        if ((file == null || (!file.exists() && !file.mkdirs())) && ((file = e.b(context.getApplicationContext())) == null || !file.exists())) {
            file = context.getFilesDir();
        }
        if (file == null || !file.exists()) {
            file = context.getCacheDir();
        }
        if (file != null) {
            return file;
        }
        String str = "/data/data/" + context.getPackageName() + File.separator + "hisavana_net_cache";
        c.Log().w("StorageUtils", "Can't define system cache directory! '%s' will be used." + str);
        return new File(str);
    }

    public static File c(Context context, boolean z) {
        File file;
        if (z) {
            file = e(context);
            if (file != null) {
                File file2 = new File(file.getPath() + File.separator + "hisavana_default_cache");
                if (!file2.exists() && !file2.mkdir()) {
                    c.Log().e("StorageUtils", "getOfflineCacheDirectory,storage cache is not ready");
                }
                file = file2;
            }
        } else {
            file = null;
        }
        if (file == null) {
            file = new File("/data/data/" + context.getPackageName() + File.separator + "hisavana_default_cache");
            if (!file.exists() && !file.mkdir()) {
                c.Log().e("StorageUtils", "getOfflineCacheDirectory,app cache path is not ready");
            }
        }
        return file;
    }

    public static File d(Context context, boolean z) {
        File file;
        if (z) {
            file = e(context);
            if (file != null) {
                File file2 = new File(file.getPath() + File.separator + "hisavana_video_cache");
                if (!file2.exists() && !file2.mkdir()) {
                    c.Log().e("StorageUtils", "getExoCacheDirectory,storage cache is not ready");
                }
                file = file2;
            }
        } else {
            file = null;
        }
        if (file == null) {
            file = new File("/data/data/" + context.getPackageName() + File.separator + "hisavana_video_cache");
            if (!file.exists() && !file.mkdir()) {
                c.Log().e("StorageUtils", "getExoCacheDirectory,app cache path is not ready");
            }
        }
        return file;
    }

    public static File e(Context context) {
        String str = "";
        if (a != null) {
            return a;
        }
        File file = new File(Environment.getExternalStorageDirectory() + "/Android/data/" + context.getPackageName() + "/files");
        if (file.exists()) {
            a = file;
        } else if (file.mkdir()) {
            a = file;
        } else {
            c.Log().w("StorageUtils", "getExternalFileDir is not exists");
        }
        if (a == null) {
            try {
                str = Environment.getExternalStorageState();
            } catch (IncompatibleClassChangeError | NullPointerException unused) {
            }
            if ("mounted".equals(str)) {
                a = context.getExternalFilesDir(null);
            }
        }
        return a;
    }

    public static File f(Context context, boolean z) {
        File file;
        if (z) {
            file = e(context);
            if (file != null) {
                File file2 = new File(file.getPath() + File.separator + "hisavana_normal_video_cache");
                if (!file2.exists() && !file2.mkdir()) {
                    c.Log().e("StorageUtils", "getVideoCacheDirectory,storage cache is not ready");
                }
                file = file2;
            }
        } else {
            file = null;
        }
        if (file == null) {
            file = new File("/data/data/" + context.getPackageName() + File.separator + "hisavana_normal_video_cache");
            if (!file.exists() && !file.mkdir()) {
                c.Log().e("StorageUtils", "getVideoCacheDirectory,app cache path is not ready");
            }
        }
        return file;
    }
}
