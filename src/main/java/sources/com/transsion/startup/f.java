package com.transsion.startup;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.component.uA.b;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.List;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class f {
    private static void a(File file, boolean z) {
        if (z) {
            try {
                if (file.exists()) {
                    return;
                }
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String b(Context context) {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo != null && runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public static void c(Context context) {
        if (context == null || Build.VERSION.SDK_INT < 28) {
            return;
        }
        try {
            String str = HttpUrl.FRAGMENT_ENCODE_SET;
            String b = b(context);
            if (!TextUtils.equals(context.getPackageName(), b)) {
                if (TextUtils.isEmpty(b)) {
                    b = context.getPackageName();
                }
                b.a(b);
                str = "_" + b;
            }
            d(context, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void d(Context context, String str) {
        File file = new File(com.bytedance.sdk.openadsdk.common.a.a(context).getAbsolutePath() + "/app_webview" + str + "/webview_data.lock");
        if (file.exists()) {
            try {
                FileLock tryLock = new RandomAccessFile(file, "rw").getChannel().tryLock();
                if (tryLock != null) {
                    tryLock.close();
                } else {
                    a(file, file.delete());
                }
            } catch (Exception e) {
                e.printStackTrace();
                a(file, file.exists() ? file.delete() : false);
            }
        }
    }
}
