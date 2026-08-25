package androidx.media3.common.util;

import android.os.Handler;
import android.os.Looper;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f9063a = new m0();

    void a();

    p createHandler(Looper looper, Handler.Callback callback);

    long currentTimeMillis();

    long elapsedRealtime();

    long nanoTime();

    long uptimeMillis();
}
