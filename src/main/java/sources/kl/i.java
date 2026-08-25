package kl;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.transsion.gslb.BuildConfig;
import com.transsion.player.mediasession.MediaItem;
import java.io.File;
import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class i {
    public static File a(Context context) {
        return b(context, true);
    }

    public static File b(Context context, boolean z) {
        String str;
        try {
            str = Environment.getExternalStorageState();
        } catch (IncompatibleClassChangeError | NullPointerException unused) {
            str = BuildConfig.FLAVOR;
        }
        File c = (z && "mounted".equals(str) && d(context)) ? c(context) : null;
        if ((c == null || (!c.exists() && !c.mkdirs())) && ((c = com.transsion.core.utils.b.a(context.getApplicationContext())) == null || !c.exists())) {
            c = context.getFilesDir();
        }
        if (c == null || !c.exists()) {
            c = context.getCacheDir();
        }
        if (c != null) {
            return c;
        }
        String str2 = "/data/data/" + context.getPackageName() + "/cache/";
        Log.w(MediaItem.MUSIC_FLOAT_STATE_ERROR, "Can't define system cache directory! '%s' will be used." + str2);
        return new File(str2);
    }

    private static File c(Context context) {
        File file = new File(new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "files"), "images");
        if (!file.exists()) {
            if (!file.mkdirs()) {
                Log.w(MediaItem.MUSIC_FLOAT_STATE_ERROR, "Unable to create external cache directory");
                return null;
            }
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (IOException unused) {
            }
        }
        return file;
    }

    private static boolean d(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }
}
