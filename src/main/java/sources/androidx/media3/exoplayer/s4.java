package androidx.media3.exoplayer;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Looper;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class s4 {

    /* renamed from: a, reason: collision with root package name */
    private final a f11250a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.media3.common.util.p f11251b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f11252c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f11253d;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Context f11254a;

        /* renamed from: b, reason: collision with root package name */
        private WifiManager.WifiLock f11255b;

        public a(Context context) {
            this.f11254a = context;
        }

        public void a(boolean z5, boolean z6) {
            if (z5 && this.f11255b == null) {
                WifiManager wifiManager = (WifiManager) this.f11254a.getApplicationContext().getSystemService("wifi");
                if (wifiManager == null) {
                    androidx.media3.common.util.u.h("WifiLockManager", "WifiManager is null, therefore not creating the WifiLock.");
                    return;
                } else {
                    WifiManager.WifiLock createWifiLock = wifiManager.createWifiLock(3, "ExoPlayer:WifiLockManager");
                    this.f11255b = createWifiLock;
                    createWifiLock.setReferenceCounted(false);
                }
            }
            WifiManager.WifiLock wifiLock = this.f11255b;
            if (wifiLock == null) {
                return;
            }
            if (z5 && z6) {
                wifiLock.acquire();
            } else {
                wifiLock.release();
            }
        }
    }

    public s4(Context context, Looper looper, androidx.media3.common.util.i iVar) {
        this.f11250a = new a(context.getApplicationContext());
        this.f11251b = iVar.createHandler(looper, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(boolean z5, boolean z6) {
        this.f11250a.a(z5, z6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(boolean z5) {
        this.f11250a.a(true, z5);
    }

    public void e(final boolean z5) {
        if (this.f11252c == z5) {
            return;
        }
        this.f11252c = z5;
        final boolean z6 = this.f11253d;
        this.f11251b.post(new Runnable() { // from class: androidx.media3.exoplayer.q4
            @Override // java.lang.Runnable
            public final void run() {
                s4.this.c(z5, z6);
            }
        });
    }

    public void f(final boolean z5) {
        if (this.f11253d == z5) {
            return;
        }
        this.f11253d = z5;
        if (this.f11252c) {
            this.f11251b.post(new Runnable() { // from class: androidx.media3.exoplayer.r4
                @Override // java.lang.Runnable
                public final void run() {
                    s4.this.d(z5);
                }
            });
        }
    }
}
