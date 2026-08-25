package com.transsion.crypto;

import ak.e;
import android.content.Context;
import bk.a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class TCrypterSdk {
    private static ExecutorService a = new ThreadPoolExecutor(0, 4, 2, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadPoolExecutor.CallerRunsPolicy());

    public static String a(Context context, String str) {
        return a.a(context).b(str);
    }

    public static void b(final Context context) {
        a.execute(new Runnable() { // from class: com.transsion.crypto.TCrypterSdk.1
            @Override // java.lang.Runnable
            public void run() {
                e.b().a(context);
            }
        });
    }

    public static void c(Context context, String str, String str2) {
        a.a(context).d(str, str2);
    }
}
