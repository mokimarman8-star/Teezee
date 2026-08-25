package androidx.media3.exoplayer;

import android.os.HandlerThread;
import android.os.Looper;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class s3 {

    /* renamed from: a, reason: collision with root package name */
    private final Object f11246a;

    /* renamed from: b, reason: collision with root package name */
    private Looper f11247b;

    /* renamed from: c, reason: collision with root package name */
    private HandlerThread f11248c;

    /* renamed from: d, reason: collision with root package name */
    private int f11249d;

    public s3() {
        this(null);
    }

    public s3(Looper looper) {
        this.f11246a = new Object();
        this.f11247b = looper;
        this.f11248c = null;
        this.f11249d = 0;
    }

    public Looper a() {
        Looper looper;
        synchronized (this.f11246a) {
            try {
                if (this.f11247b == null) {
                    androidx.media3.common.util.a.g(this.f11249d == 0 && this.f11248c == null);
                    HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
                    this.f11248c = handlerThread;
                    handlerThread.start();
                    this.f11247b = this.f11248c.getLooper();
                }
                this.f11249d++;
                looper = this.f11247b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return looper;
    }

    public void b() {
        HandlerThread handlerThread;
        synchronized (this.f11246a) {
            try {
                androidx.media3.common.util.a.g(this.f11249d > 0);
                int i5 = this.f11249d - 1;
                this.f11249d = i5;
                if (i5 == 0 && (handlerThread = this.f11248c) != null) {
                    handlerThread.quit();
                    this.f11248c = null;
                    this.f11247b = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
