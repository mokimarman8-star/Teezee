package androidx.media3.exoplayer;

import android.content.Context;
import android.os.Looper;
import android.os.PowerManager;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class p4 {

    /* renamed from: a, reason: collision with root package name */
    private final a f11123a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.media3.common.util.p f11124b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f11125c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f11126d;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Context f11127a;

        /* renamed from: b, reason: collision with root package name */
        private PowerManager.WakeLock f11128b;

        public a(Context context) {
            this.f11127a = context;
        }

        public void a(boolean z5, boolean z6) {
            if (z5 && this.f11128b == null) {
                PowerManager powerManager = (PowerManager) this.f11127a.getSystemService("power");
                if (powerManager == null) {
                    androidx.media3.common.util.u.h("WakeLockManager", "PowerManager is null, therefore not creating the WakeLock.");
                    return;
                } else {
                    PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, "ExoPlayer:WakeLockManager");
                    this.f11128b = newWakeLock;
                    newWakeLock.setReferenceCounted(false);
                }
            }
            PowerManager.WakeLock wakeLock = this.f11128b;
            if (wakeLock == null) {
                return;
            }
            if (z5 && z6) {
                wakeLock.acquire();
            } else {
                wakeLock.release();
            }
        }
    }

    public p4(Context context, Looper looper, androidx.media3.common.util.i iVar) {
        this.f11123a = new a(context.getApplicationContext());
        this.f11124b = iVar.createHandler(looper, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(boolean z5, boolean z6) {
        this.f11123a.a(z5, z6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(boolean z5) {
        this.f11123a.a(true, z5);
    }

    public void e(final boolean z5) {
        if (this.f11125c == z5) {
            return;
        }
        this.f11125c = z5;
        final boolean z6 = this.f11126d;
        this.f11124b.post(new Runnable() { // from class: androidx.media3.exoplayer.o4
            @Override // java.lang.Runnable
            public final void run() {
                p4.this.c(z5, z6);
            }
        });
    }

    public void f(final boolean z5) {
        if (this.f11126d == z5) {
            return;
        }
        this.f11126d = z5;
        if (this.f11125c) {
            this.f11124b.post(new Runnable() { // from class: androidx.media3.exoplayer.n4
                @Override // java.lang.Runnable
                public final void run() {
                    p4.this.d(z5);
                }
            });
        }
    }
}
