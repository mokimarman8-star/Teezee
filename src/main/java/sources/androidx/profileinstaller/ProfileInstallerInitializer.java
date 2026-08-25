package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import d4.a;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class ProfileInstallerInitializer implements a {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(Context context, long j) {
        g(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(Context context) {
        new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new k(context));
    }

    public List a() {
        return Collections.emptyList();
    }

    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public b b(Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return new b();
        }
        Choreographer.getInstance().postFrameCallback(new i(this, context.getApplicationContext()));
        return new b();
    }

    void g(Context context) {
        (Build.VERSION.SDK_INT >= 28 ? a.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new j(context), new Random().nextInt(Math.max(1000, 1)) + 5000);
    }
}
